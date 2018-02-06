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
    private NewUserGuideActivity hgr;
    private ImageView hgs;
    private ImageView hgt;
    private ImageView hgu;
    private GoOnAnimView hgv;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap hgq = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    e.this.bzf();
                    return;
                case 1:
                    e.this.bze();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hgr = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.hgs = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.hgt = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.hgu = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.hgq = BitmapHelper.getResBitmap(this.hgr.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.hgq != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.hgr.getResources(), this.hgq));
            }
            this.hgv = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.hgv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.e.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.hgr != null) {
                        if (e.this.hgr.bzb().bzi()) {
                            e.this.hgr.bzd();
                            return;
                        }
                        RightSlideViewPager bza = e.this.hgr.bza();
                        if (bza != null) {
                            bza.setCurrentItem(1, true);
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
            this.hgr.bzd();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bze() {
        this.hgs.setImageResource(d.f.pic_startpage1_one);
        this.hgt.setImageResource(d.f.pic_startpage1_two);
        this.hgu.setImageResource(d.f.pic_startpage1_three);
        a(this.hgs, true, 0L);
        a(this.hgt, false, 100L);
        a(this.hgu, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bzf() {
        if (this.hgv != null) {
            this.hgv.onStart();
        }
    }

    public void bzg() {
        if (this.hgv != null) {
            this.hgv.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.hgq != null) {
                if (!this.hgq.isRecycled()) {
                    this.hgq.recycle();
                }
                this.hgq = null;
            }
            this.hgs.clearAnimation();
            this.hgs.setImageDrawable(null);
            this.hgt.clearAnimation();
            this.hgt.setImageDrawable(null);
            this.hgu.clearAnimation();
            this.hgu.setImageDrawable(null);
            if (this.hgv != null) {
                this.hgv.onDestroy();
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
