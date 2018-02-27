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
    private NewUserGuideActivity hgc;
    private ImageView hgd;
    private ImageView hge;
    private ImageView hgf;
    private GoOnAnimView hgg;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap hgb = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    e.this.bze();
                    return;
                case 1:
                    e.this.bzd();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgc = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.hgd = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.hge = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.hgf = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.hgb = BitmapHelper.getResBitmap(this.hgc.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.hgb != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.hgc.getResources(), this.hgb));
            }
            this.hgg = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.hgg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hgc != null) {
                        if (e.this.hgc.bza().bzh()) {
                            e.this.hgc.bzc();
                            return;
                        }
                        RightSlideViewPager byZ = e.this.hgc.byZ();
                        if (byZ != null) {
                            byZ.setCurrentItem(1, true);
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
            this.hgc.bzc();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzd() {
        this.hgd.setImageResource(d.f.pic_startpage1_one);
        this.hge.setImageResource(d.f.pic_startpage1_two);
        this.hgf.setImageResource(d.f.pic_startpage1_three);
        a(this.hgd, true, 0L);
        a(this.hge, false, 100L);
        a(this.hgf, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bze() {
        if (this.hgg != null) {
            this.hgg.onStart();
        }
    }

    public void bzf() {
        if (this.hgg != null) {
            this.hgg.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.hgb != null) {
                if (!this.hgb.isRecycled()) {
                    this.hgb.recycle();
                }
                this.hgb = null;
            }
            this.hgd.clearAnimation();
            this.hgd.setImageDrawable(null);
            this.hge.clearAnimation();
            this.hge.setImageDrawable(null);
            this.hgf.clearAnimation();
            this.hgf.setImageDrawable(null);
            if (this.hgg != null) {
                this.hgg.onDestroy();
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
