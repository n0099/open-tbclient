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
public class e extends BaseFragment {
    private NewUserGuideActivity hgA;
    private ImageView hgB;
    private ImageView hgC;
    private ImageView hgD;
    private GoOnAnimView hgE;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap hgz = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    e.this.bzj();
                    return;
                case 1:
                    e.this.bzi();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgA = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.hgB = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.hgC = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.hgD = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.hgz = BitmapHelper.getResBitmap(this.hgA.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.hgz != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.hgA.getResources(), this.hgz));
            }
            this.hgE = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.hgE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hgA != null) {
                        if (e.this.hgA.bzf().bzm()) {
                            e.this.hgA.bzh();
                            return;
                        }
                        RightSlideViewPager bze = e.this.hgA.bze();
                        if (bze != null) {
                            bze.setCurrentItem(1, true);
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
            this.hgA.bzh();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzi() {
        this.hgB.setImageResource(d.f.pic_startpage1_one);
        this.hgC.setImageResource(d.f.pic_startpage1_two);
        this.hgD.setImageResource(d.f.pic_startpage1_three);
        a(this.hgB, true, 0L);
        a(this.hgC, false, 100L);
        a(this.hgD, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bzj() {
        if (this.hgE != null) {
            this.hgE.onStart();
        }
    }

    public void bzk() {
        if (this.hgE != null) {
            this.hgE.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.hgz != null) {
                if (!this.hgz.isRecycled()) {
                    this.hgz.recycle();
                }
                this.hgz = null;
            }
            this.hgB.clearAnimation();
            this.hgB.setImageDrawable(null);
            this.hgC.clearAnimation();
            this.hgC.setImageDrawable(null);
            this.hgD.clearAnimation();
            this.hgD.setImageDrawable(null);
            if (this.hgE != null) {
                this.hgE.onDestroy();
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
