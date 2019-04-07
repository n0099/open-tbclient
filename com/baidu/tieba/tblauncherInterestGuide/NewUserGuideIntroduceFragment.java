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
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.view.GoOnAnimView;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
/* loaded from: classes4.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity iNa;
    private ImageView iNb;
    private ImageView iNc;
    private ImageView iNd;
    private GoOnAnimView iNe;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap iMZ = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cgZ();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.cgY();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iNa = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.iNb = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.iNc = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.iNd = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.iMZ = BitmapHelper.getResBitmap(this.iNa.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.iMZ != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.iNa.getResources(), this.iMZ));
            }
            this.iNe = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.iNe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.iNa != null) {
                        if (NewUserGuideIntroduceFragment.this.iNa.cgV().chc()) {
                            NewUserGuideIntroduceFragment.this.iNa.cgX();
                            return;
                        }
                        RightSlideViewPager cgU = NewUserGuideIntroduceFragment.this.iNa.cgU();
                        if (cgU != null) {
                            cgU.setCurrentItem(1, true);
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
            this.iNa.cgX();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgY() {
        this.iNb.setImageResource(d.f.pic_startpage1_one);
        this.iNc.setImageResource(d.f.pic_startpage1_two);
        this.iNd.setImageResource(d.f.pic_startpage1_three);
        a(this.iNb, true, 0L);
        a(this.iNc, false, 100L);
        a(this.iNd, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cgZ() {
        if (this.iNe != null) {
            this.iNe.onStart();
        }
    }

    public void cha() {
        if (this.iNe != null) {
            this.iNe.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.iMZ != null) {
                if (!this.iMZ.isRecycled()) {
                    this.iMZ.recycle();
                }
                this.iMZ = null;
            }
            this.iNb.clearAnimation();
            this.iNb.setImageDrawable(null);
            this.iNc.clearAnimation();
            this.iNc.setImageDrawable(null);
            this.iNd.clearAnimation();
            this.iNd.setImageDrawable(null);
            if (this.iNe != null) {
                this.iNe.onDestroy();
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
