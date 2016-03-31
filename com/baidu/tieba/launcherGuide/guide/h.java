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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.launcherGuide.view.GoOnAnimView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends BaseFragment {
    private ViewGroup Wy;
    private NewUserGuideActivity cDG;
    private ImageView cDH;
    private ImageView cDI;
    private ImageView cDJ;
    private GoOnAnimView cDK;
    private boolean Ew = false;
    private Bitmap cDF = null;
    private Handler mHandler = new i(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cDG = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(t.h.guide_introduce, (ViewGroup) null);
            this.Ew = true;
            this.Wy = (ViewGroup) viewGroup2.findViewById(t.g.root_view);
            this.cDH = (ImageView) viewGroup2.findViewById(t.g.image_tip_1);
            this.cDI = (ImageView) viewGroup2.findViewById(t.g.image_tip_2);
            this.cDJ = (ImageView) viewGroup2.findViewById(t.g.image_tip_3);
            this.cDF = BitmapHelper.getResBitmap(this.cDG.getPageContext().getPageActivity(), t.f.pic_bg_startpage);
            if (this.cDF != null) {
                this.Wy.setBackgroundDrawable(new BitmapDrawable(this.cDG.getResources(), this.cDF));
            }
            this.cDK = (GoOnAnimView) viewGroup2.findViewById(t.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.cDK.setOnClickListener(new j(this));
            return viewGroup2;
        } catch (InflateException e) {
            this.Ew = false;
            if (TbadkApplication.getInst().isDebugMode()) {
                throw e;
            }
            BdLog.e(e);
            this.cDG.anb();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anc() {
        this.cDH.setImageResource(t.f.pic_startpage1_one);
        this.cDI.setImageResource(t.f.pic_startpage1_two);
        this.cDJ.setImageResource(t.f.pic_startpage1_three);
        a(this.cDH, true, 0L);
        a(this.cDI, false, 100L);
        a(this.cDJ, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void and() {
        if (this.cDK != null) {
            this.cDK.onStart();
        }
    }

    public void ane() {
        if (this.cDK != null) {
            this.cDK.onStop();
        }
    }

    private void stop() {
        if (this.Ew) {
            this.Wy.setBackgroundDrawable(null);
            if (this.cDF != null) {
                if (!this.cDF.isRecycled()) {
                    this.cDF.recycle();
                }
                this.cDF = null;
            }
            this.cDH.clearAnimation();
            this.cDH.setImageDrawable(null);
            this.cDI.clearAnimation();
            this.cDI.setImageDrawable(null);
            this.cDJ.clearAnimation();
            this.cDJ.setImageDrawable(null);
            if (this.cDK != null) {
                this.cDK.onDestroy();
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
