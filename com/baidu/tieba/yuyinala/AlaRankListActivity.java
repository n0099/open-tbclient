package com.baidu.tieba.yuyinala;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaCharmRankActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.utils.i;
import com.baidu.live.utils.r;
import com.baidu.tieba.yuyinala.adapter.AlaRankListFragmentAdapter;
import com.baidu.tieba.yuyinala.view.e;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class AlaRankListActivity extends BaseActivity<AlaRankListActivity> implements View.OnTouchListener {
    private AlaLiveRoomPanelTabHost aCE;
    private int aHv;
    private String bac;
    private long gmS;
    private boolean gmV;
    private ImageView gmW;
    private String mPortrait;
    private String mRoomId;
    private View mRootView;
    private int mScreenWidth;
    private String mUserName;
    private String oeF;
    private AlaRankListFragmentAdapter oeG;
    private String otherParams;
    private Handler mHandler = new Handler();
    private boolean aTo = false;
    private boolean aXA = false;
    private boolean aXB = false;
    private ViewTreeObserver.OnGlobalLayoutListener aXw = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.yuyinala.AlaRankListActivity.4
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaRankListActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != AlaRankListActivity.this.mScreenWidth) {
                AlaRankListActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    AlaRankListActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.AlaRankListActivity.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AlaRankListActivity.this.mRootView != null) {
                                i.ae(AlaRankListActivity.this.mRootView);
                                r.e(AlaRankListActivity.this.getActivity(), false);
                            }
                        }
                    }, 300L);
                }
            }
        }
    };
    public CustomMessageListener bdo = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.yuyinala.AlaRankListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!AlaRankListActivity.this.isFinishing() && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                AlaRankListActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            this.aHv = getIntent().getIntExtra(UbcStatConstant.KEY_LIVE_TYPE, 1);
            this.mUserName = getIntent().getStringExtra(TbEnum.SystemMessage.KEY_USER_NAME);
            this.gmV = getIntent().getBooleanExtra("rank_list_from", false);
            this.mPortrait = getIntent().getStringExtra("portrait");
            this.bac = getIntent().getStringExtra("feed_id");
            this.gmS = getIntent().getLongExtra("live_id", -1L);
            this.otherParams = getIntent().getStringExtra(IntentConfig.OTHER_PARAMS);
            this.oeF = getIntent().getStringExtra(YuyinAlaCharmRankActivityConfig.C_ROOM_ID);
            this.mRoomId = getIntent().getStringExtra("room_id");
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aXA = false;
            this.mRootView.setVisibility(4);
            MessageManager.getInstance().registerListener(this.bdo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aTo) {
            this.mRootView.setVisibility(0);
            EL();
            this.aTo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getPageContext().getPageActivity());
    }

    private void EL() {
        Animation loadAnimation;
        this.aXA = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.AlaRankListActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaRankListActivity.this.aXA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void EM() {
        Animation loadAnimation;
        if (!this.aXB && !this.aXA) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0194a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.yuyinala.AlaRankListActivity.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaRankListActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaRankListActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aXB = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        EM();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_rank_list_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.gmW = (ImageView) this.mRootView.findViewById(a.f.rule_icon);
        this.gmW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaRankListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                final e eds = new e.a(AlaRankListActivity.this.gmW).bo(9.0f).bp(4.0f).bm(200.0f).bn(190.0f).x("按今日的魅力收益进行排名").Mk(16).bq(10.0f).br(14.0f).bs(8.0f).zY(true).zZ(true).eds();
                eds.show();
                AlaRankListActivity.this.gmW.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.AlaRankListActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        eds.dismiss();
                    }
                }, IMConnection.RETRY_DELAY_TIMES);
            }
        });
        initTabSpec();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Ts();
    }

    private void Ts() {
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            View decorView = window.getDecorView();
            decorView.setOnTouchListener(this);
            if (!UtilHelper.canUseStyleImmersiveSticky()) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (screenDimensions[1] > screenDimensions[0]) {
                    attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                    attributes.gravity = 80;
                } else {
                    attributes.height = screenDimensions[1];
                    attributes.gravity = 48;
                }
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aXw);
            if (this.mRootView.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.6d);
                    layoutParams.gravity = 80;
                } else {
                    layoutParams.width = screenDimensions[1];
                    layoutParams.height = screenDimensions[1];
                    layoutParams.gravity = 53;
                }
                this.mRootView.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (view == this.mRootView) {
                return true;
            }
            setResult(0);
            finish();
            return true;
        }
        return false;
    }

    private void initTabSpec() {
        this.oeG = new AlaRankListFragmentAdapter(this, this.oeF);
        this.aCE = (AlaLiveRoomPanelTabHost) this.mRootView.findViewById(a.f.ala_charm_tab_host);
        this.aCE.setTabWidgetBg(a.e.yuyin_ala_rank_list_title_corner_bg);
        this.aCE.setViewPagerBg(a.e.yuyin_ala_rank_white_bg);
        this.aCE.setData(this.oeG.getDataList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Iterator<d> it = this.oeG.getDataList().iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aXw);
        this.aXw = null;
        MessageManager.getInstance().unRegisterListener(this.bdo);
    }
}
