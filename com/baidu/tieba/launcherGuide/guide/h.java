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
    private NewUserGuideActivity bRO;
    private ImageView bRP;
    private ImageView bRQ;
    private ImageView bRR;
    private GoOnAnimView bRS;
    private ViewGroup mRootView;
    private boolean Dz = false;
    private Bitmap bRN = null;
    private Handler mHandler = new i(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bRO = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(i.g.guide_introduce, (ViewGroup) null);
            this.Dz = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(i.f.root_view);
            this.bRP = (ImageView) viewGroup2.findViewById(i.f.image_tip_1);
            this.bRQ = (ImageView) viewGroup2.findViewById(i.f.image_tip_2);
            this.bRR = (ImageView) viewGroup2.findViewById(i.f.image_tip_3);
            this.bRN = com.baidu.tbadk.core.util.c.b(this.bRO.getPageContext().getPageActivity(), i.e.pic_bg_startpage);
            if (this.bRN != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.bRO.getResources(), this.bRN));
            }
            this.bRS = (GoOnAnimView) viewGroup2.findViewById(i.f.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.bRS.setOnClickListener(new j(this));
            return viewGroup2;
        } catch (InflateException e) {
            this.Dz = false;
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.bRO.aaA();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaB() {
        this.bRP.setImageResource(i.e.pic_startpage1_one);
        this.bRQ.setImageResource(i.e.pic_startpage1_two);
        this.bRR.setImageResource(i.e.pic_startpage1_three);
        a(this.bRP, true, 0L);
        a(this.bRQ, false, 100L);
        a(this.bRR, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void aaC() {
        if (this.bRS != null) {
            this.bRS.onStart();
        }
    }

    public void aaD() {
        if (this.bRS != null) {
            this.bRS.onStop();
        }
    }

    private void stop() {
        if (this.Dz) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.bRN != null) {
                if (!this.bRN.isRecycled()) {
                    this.bRN.recycle();
                }
                this.bRN = null;
            }
            this.bRP.clearAnimation();
            this.bRP.setImageDrawable(null);
            this.bRQ.clearAnimation();
            this.bRQ.setImageDrawable(null);
            this.bRR.clearAnimation();
            this.bRR.setImageDrawable(null);
            if (this.bRS != null) {
                this.bRS.onDestroy();
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
