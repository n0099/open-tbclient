package com.baidu.tieba.tblauncherInterestGuide;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.view.GoOnAnimView;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
/* loaded from: classes9.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private ImageView ltA;
    private ImageView ltB;
    private ImageView ltC;
    private GoOnAnimView ltD;
    private NewUserGuideActivity ltz;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap lty = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dgo();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.DX();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ltz = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.ltA = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.ltB = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.ltC = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.lty = BitmapHelper.getResBitmap(this.ltz.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.lty != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.ltz.getResources(), this.lty));
            }
            this.ltD = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.ltD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.ltz != null) {
                        if (NewUserGuideIntroduceFragment.this.ltz.dgl().dgr()) {
                            NewUserGuideIntroduceFragment.this.ltz.dgn();
                            return;
                        }
                        RightSlideViewPager dgk = NewUserGuideIntroduceFragment.this.ltz.dgk();
                        if (dgk != null) {
                            dgk.setCurrentItem(1, true);
                        }
                    }
                }
            });
            return viewGroup2;
        } catch (InflateException e) {
            this.isInit = false;
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.ltz.dgn();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX() {
        this.ltA.setImageResource(R.drawable.pic_startpage1_one);
        this.ltB.setImageResource(R.drawable.pic_startpage1_two);
        this.ltC.setImageResource(R.drawable.pic_startpage1_three);
        a(this.ltA, true, 0L);
        a(this.ltB, false, 100L);
        a(this.ltC, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dgo() {
        if (this.ltD != null) {
            this.ltD.onStart();
        }
    }

    public void dgp() {
        if (this.ltD != null) {
            this.ltD.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.lty != null) {
                if (!this.lty.isRecycled()) {
                    this.lty.recycle();
                }
                this.lty = null;
            }
            this.ltA.clearAnimation();
            this.ltA.setImageDrawable(null);
            this.ltB.clearAnimation();
            this.ltB.setImageDrawable(null);
            this.ltC.clearAnimation();
            this.ltC.setImageDrawable(null);
            if (this.ltD != null) {
                this.ltD.onDestroy();
            }
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
        }
    }

    private void a(ImageView imageView, boolean z, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, z ? 1.0f : -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        translateAnimation.setStartOffset(j);
        translateAnimation.setFillAfter(true);
        imageView.startAnimation(translateAnimation);
    }
}
