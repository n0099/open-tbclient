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
import com.baidu.tieba.launcherGuide.view.GoOnAnimView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h extends BaseFragment {
    private GoOnAnimView ciA;
    private NewUserGuideActivity ciw;
    private ImageView cix;
    private ImageView ciy;
    private ImageView ciz;
    private ViewGroup mRootView;
    private boolean DL = false;
    private Bitmap civ = null;
    private Handler mHandler = new i(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ciw = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(n.g.guide_introduce, (ViewGroup) null);
            this.DL = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(n.f.root_view);
            this.cix = (ImageView) viewGroup2.findViewById(n.f.image_tip_1);
            this.ciy = (ImageView) viewGroup2.findViewById(n.f.image_tip_2);
            this.ciz = (ImageView) viewGroup2.findViewById(n.f.image_tip_3);
            this.civ = com.baidu.tbadk.core.util.c.b(this.ciw.getPageContext().getPageActivity(), n.e.pic_bg_startpage);
            if (this.civ != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.ciw.getResources(), this.civ));
            }
            this.ciA = (GoOnAnimView) viewGroup2.findViewById(n.f.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.ciA.setOnClickListener(new j(this));
            return viewGroup2;
        } catch (InflateException e) {
            this.DL = false;
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.ciw.aex();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aey() {
        this.cix.setImageResource(n.e.pic_startpage1_one);
        this.ciy.setImageResource(n.e.pic_startpage1_two);
        this.ciz.setImageResource(n.e.pic_startpage1_three);
        a(this.cix, true, 0L);
        a(this.ciy, false, 100L);
        a(this.ciz, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void aez() {
        if (this.ciA != null) {
            this.ciA.onStart();
        }
    }

    public void aeA() {
        if (this.ciA != null) {
            this.ciA.onStop();
        }
    }

    private void stop() {
        if (this.DL) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.civ != null) {
                if (!this.civ.isRecycled()) {
                    this.civ.recycle();
                }
                this.civ = null;
            }
            this.cix.clearAnimation();
            this.cix.setImageDrawable(null);
            this.ciy.clearAnimation();
            this.ciy.setImageDrawable(null);
            this.ciz.clearAnimation();
            this.ciz.setImageDrawable(null);
            if (this.ciA != null) {
                this.ciA.onDestroy();
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
