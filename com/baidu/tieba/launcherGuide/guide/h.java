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
    private NewUserGuideActivity bSj;
    private ImageView bSk;
    private ImageView bSl;
    private ImageView bSm;
    private GoOnAnimView bSn;
    private ViewGroup mRootView;
    private boolean DA = false;
    private Bitmap bSi = null;
    private Handler mHandler = new i(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bSj = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(i.g.guide_introduce, (ViewGroup) null);
            this.DA = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(i.f.root_view);
            this.bSk = (ImageView) viewGroup2.findViewById(i.f.image_tip_1);
            this.bSl = (ImageView) viewGroup2.findViewById(i.f.image_tip_2);
            this.bSm = (ImageView) viewGroup2.findViewById(i.f.image_tip_3);
            this.bSi = com.baidu.tbadk.core.util.c.b(this.bSj.getPageContext().getPageActivity(), i.e.pic_bg_startpage);
            if (this.bSi != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.bSj.getResources(), this.bSi));
            }
            this.bSn = (GoOnAnimView) viewGroup2.findViewById(i.f.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.bSn.setOnClickListener(new j(this));
            return viewGroup2;
        } catch (InflateException e) {
            this.DA = false;
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.bSj.aaR();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaS() {
        this.bSk.setImageResource(i.e.pic_startpage1_one);
        this.bSl.setImageResource(i.e.pic_startpage1_two);
        this.bSm.setImageResource(i.e.pic_startpage1_three);
        a(this.bSk, true, 0L);
        a(this.bSl, false, 100L);
        a(this.bSm, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void aaT() {
        if (this.bSn != null) {
            this.bSn.onStart();
        }
    }

    public void aaU() {
        if (this.bSn != null) {
            this.bSn.onStop();
        }
    }

    private void stop() {
        if (this.DA) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.bSi != null) {
                if (!this.bSi.isRecycled()) {
                    this.bSi.recycle();
                }
                this.bSi = null;
            }
            this.bSk.clearAnimation();
            this.bSk.setImageDrawable(null);
            this.bSl.clearAnimation();
            this.bSl.setImageDrawable(null);
            this.bSm.clearAnimation();
            this.bSm.setImageDrawable(null);
            if (this.bSn != null) {
                this.bSn.onDestroy();
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
