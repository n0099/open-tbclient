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
/* loaded from: classes3.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity gOH;
    private ImageView gOI;
    private ImageView gOJ;
    private ImageView gOK;
    private GoOnAnimView gOL;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap gOG = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.bzm();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.bzl();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gOH = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.i.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.gOI = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.gOJ = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.gOK = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.gOG = BitmapHelper.getResBitmap(this.gOH.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.gOG != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.gOH.getResources(), this.gOG));
            }
            this.gOL = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.gOL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.gOH != null) {
                        if (NewUserGuideIntroduceFragment.this.gOH.bzi().bzp()) {
                            NewUserGuideIntroduceFragment.this.gOH.bzk();
                            return;
                        }
                        RightSlideViewPager bzh = NewUserGuideIntroduceFragment.this.gOH.bzh();
                        if (bzh != null) {
                            bzh.setCurrentItem(1, true);
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
            this.gOH.bzk();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzl() {
        this.gOI.setImageResource(d.f.pic_startpage1_one);
        this.gOJ.setImageResource(d.f.pic_startpage1_two);
        this.gOK.setImageResource(d.f.pic_startpage1_three);
        a(this.gOI, true, 0L);
        a(this.gOJ, false, 100L);
        a(this.gOK, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bzm() {
        if (this.gOL != null) {
            this.gOL.onStart();
        }
    }

    public void bzn() {
        if (this.gOL != null) {
            this.gOL.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.gOG != null) {
                if (!this.gOG.isRecycled()) {
                    this.gOG.recycle();
                }
                this.gOG = null;
            }
            this.gOI.clearAnimation();
            this.gOI.setImageDrawable(null);
            this.gOJ.clearAnimation();
            this.gOJ.setImageDrawable(null);
            this.gOK.clearAnimation();
            this.gOK.setImageDrawable(null);
            if (this.gOL != null) {
                this.gOL.onDestroy();
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
