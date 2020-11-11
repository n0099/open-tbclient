package com.baidu.tieba.yuyinala.charm.charmrank;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.i;
/* loaded from: classes4.dex */
public class YuyinCharmRankTotalActivity extends BaseActivity<YuyinCharmRankTotalActivity> implements View.OnTouchListener {
    private View mRootView;
    private int mScreenWidth;
    private f nTf;
    private Handler mHandler = new Handler();
    private boolean aVc = false;
    private boolean aZb = false;
    private boolean aZc = false;
    private ViewTreeObserver.OnGlobalLayoutListener aYX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.3
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(YuyinCharmRankTotalActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != YuyinCharmRankTotalActivity.this.mScreenWidth) {
                YuyinCharmRankTotalActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    YuyinCharmRankTotalActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            i.ae(YuyinCharmRankTotalActivity.this.nTf.getView());
                        }
                    }, 300L);
                }
            }
        }
    };
    CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            YuyinCharmRankTotalActivity.this.closeActivity();
        }
    };
    public CustomMessageListener bek = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!YuyinCharmRankTotalActivity.this.isFinishing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                YuyinCharmRankTotalActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.nTf = new f(this);
            this.mRootView = this.nTf.getView();
            setContentView(this.mRootView);
            registerListener(this.aVt);
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aZb = false;
            this.mRootView.setVisibility(4);
            MessageManager.getInstance().registerListener(this.bek);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aVc) {
            this.mRootView.setVisibility(0);
            HW();
            this.aVc = true;
        }
    }

    private void HW() {
        this.aZb = true;
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_bottom);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                YuyinCharmRankTotalActivity.this.aZb = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void HX() {
        if (!this.aZc && !this.aZb) {
            Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_bottom);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.YuyinCharmRankTotalActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    YuyinCharmRankTotalActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(YuyinCharmRankTotalActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aZc = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        HX();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Ur();
    }

    private void Ur() {
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            View decorView = window.getDecorView();
            decorView.setOnTouchListener(this);
            if (!UtilHelper.canUseStyleImmersiveSticky() && screenDimensions[1] > screenDimensions[0]) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                attributes.gravity = 80;
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aYX);
            if (this.nTf.getView().getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.nTf.getView().getLayoutParams();
                layoutParams.width = screenDimensions[0];
                layoutParams.height = (int) (screenDimensions[1] * 0.6d);
                layoutParams.gravity = 80;
                this.nTf.getView().setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            z = true;
            if (view.getId() != a.f.ala_charm_detail_id) {
                finish();
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.nTf.onDestory();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aYX);
        MessageManager.getInstance().unRegisterListener(this.bek);
        this.aYX = null;
    }
}
