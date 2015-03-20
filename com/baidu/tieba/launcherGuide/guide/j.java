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
/* loaded from: classes.dex */
public class j extends BaseFragment {
    private NewUserGuideActivity bwE;
    private ImageView bwF;
    private ImageView bwG;
    private ImageView bwH;
    private GoOnAnimView bwI;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap XI = null;
    private Handler mHandler = new k(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bwE = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(com.baidu.tieba.w.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(com.baidu.tieba.v.root_view);
            this.bwF = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_1);
            this.bwG = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_2);
            this.bwH = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_3);
            this.XI = com.baidu.tbadk.core.util.c.b(this.bwE.getPageContext().getPageActivity(), com.baidu.tieba.u.pic_bg_startpage);
            if (this.XI != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.bwE.getResources(), this.XI));
            }
            this.bwI = (GoOnAnimView) viewGroup2.findViewById(com.baidu.tieba.v.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.bwI.setOnClickListener(new l(this));
            return viewGroup2;
        } catch (InflateException e) {
            this.isInit = false;
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.bwE.Wb();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wc() {
        this.bwF.setImageResource(com.baidu.tieba.u.pic_startpage1_one);
        this.bwG.setImageResource(com.baidu.tieba.u.pic_startpage1_two);
        this.bwH.setImageResource(com.baidu.tieba.u.pic_startpage1_three);
        a(this.bwF, true, 0L);
        a(this.bwG, false, 100L);
        a(this.bwH, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void Wd() {
        if (this.bwI != null) {
            this.bwI.onStart();
        }
    }

    public void We() {
        if (this.bwI != null) {
            this.bwI.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.XI != null) {
                if (!this.XI.isRecycled()) {
                    this.XI.recycle();
                }
                this.XI = null;
            }
            this.bwF.clearAnimation();
            this.bwF.setImageDrawable(null);
            this.bwG.clearAnimation();
            this.bwG.setImageDrawable(null);
            this.bwH.clearAnimation();
            this.bwH.setImageDrawable(null);
            if (this.bwI != null) {
                this.bwI.onDestroy();
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
