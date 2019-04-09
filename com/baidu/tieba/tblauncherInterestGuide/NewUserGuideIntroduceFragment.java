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
/* loaded from: classes4.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity iNb;
    private ImageView iNc;
    private ImageView iNd;
    private ImageView iNe;
    private GoOnAnimView iNf;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap iNa = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cgZ();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.cgY();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iNb = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.iNc = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.iNd = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.iNe = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.iNa = BitmapHelper.getResBitmap(this.iNb.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.iNa != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.iNb.getResources(), this.iNa));
            }
            this.iNf = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.iNf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.iNb != null) {
                        if (NewUserGuideIntroduceFragment.this.iNb.cgV().chc()) {
                            NewUserGuideIntroduceFragment.this.iNb.cgX();
                            return;
                        }
                        RightSlideViewPager cgU = NewUserGuideIntroduceFragment.this.iNb.cgU();
                        if (cgU != null) {
                            cgU.setCurrentItem(1, true);
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
            this.iNb.cgX();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgY() {
        this.iNc.setImageResource(d.f.pic_startpage1_one);
        this.iNd.setImageResource(d.f.pic_startpage1_two);
        this.iNe.setImageResource(d.f.pic_startpage1_three);
        a(this.iNc, true, 0L);
        a(this.iNd, false, 100L);
        a(this.iNe, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cgZ() {
        if (this.iNf != null) {
            this.iNf.onStart();
        }
    }

    public void cha() {
        if (this.iNf != null) {
            this.iNf.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.iNa != null) {
                if (!this.iNa.isRecycled()) {
                    this.iNa.recycle();
                }
                this.iNa = null;
            }
            this.iNc.clearAnimation();
            this.iNc.setImageDrawable(null);
            this.iNd.clearAnimation();
            this.iNd.setImageDrawable(null);
            this.iNe.clearAnimation();
            this.iNe.setImageDrawable(null);
            if (this.iNf != null) {
                this.iNf.onDestroy();
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
