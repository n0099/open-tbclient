package com.baidu.tieba.launcherGuide.guide;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.tieba.i;
import com.baidu.tieba.launcherGuide.view.GoOnAnimView;
/* loaded from: classes.dex */
public class h extends BaseFragment {
    private NewUserGuideActivity bRD;
    private ImageView bRE;
    private ImageView bRF;
    private ImageView bRG;
    private GoOnAnimView bRH;
    private ViewGroup mRootView;
    private boolean Dy = false;
    private Bitmap bRC = null;
    private Handler mHandler = new i(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bRD = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(i.g.guide_introduce, (ViewGroup) null);
            this.Dy = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(i.f.root_view);
            this.bRE = (ImageView) viewGroup2.findViewById(i.f.image_tip_1);
            this.bRF = (ImageView) viewGroup2.findViewById(i.f.image_tip_2);
            this.bRG = (ImageView) viewGroup2.findViewById(i.f.image_tip_3);
            this.bRC = com.baidu.tbadk.core.util.c.b(this.bRD.getPageContext().getPageActivity(), i.e.pic_bg_startpage);
            if (this.bRC != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.bRD.getResources(), this.bRC));
            }
            this.bRH = (GoOnAnimView) viewGroup2.findViewById(i.f.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.bRH.setOnClickListener(new j(this));
            return viewGroup2;
        } catch (InflateException e) {
            this.Dy = false;
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.bRD.aaA();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaB() {
        this.bRE.setImageResource(i.e.pic_startpage1_one);
        this.bRF.setImageResource(i.e.pic_startpage1_two);
        this.bRG.setImageResource(i.e.pic_startpage1_three);
        a(this.bRE, true, 0L);
        a(this.bRF, false, 100L);
        a(this.bRG, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void aaC() {
        if (this.bRH != null) {
            this.bRH.onStart();
        }
    }

    public void aaD() {
        if (this.bRH != null) {
            this.bRH.onStop();
        }
    }

    private void stop() {
        if (this.Dy) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.bRC != null) {
                if (!this.bRC.isRecycled()) {
                    this.bRC.recycle();
                }
                this.bRC = null;
            }
            this.bRE.clearAnimation();
            this.bRE.setImageDrawable(null);
            this.bRF.clearAnimation();
            this.bRF.setImageDrawable(null);
            this.bRG.clearAnimation();
            this.bRG.setImageDrawable(null);
            if (this.bRH != null) {
                this.bRH.onDestroy();
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
