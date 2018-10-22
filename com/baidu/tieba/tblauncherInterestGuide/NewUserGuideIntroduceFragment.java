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
import com.baidu.tieba.e;
import com.baidu.tieba.tblauncherInterestGuide.view.GoOnAnimView;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
/* loaded from: classes3.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity hjn;
    private ImageView hjo;
    private ImageView hjp;
    private ImageView hjq;
    private GoOnAnimView hjr;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap hjm = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.bEv();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.bEu();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hjn = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(e.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(e.g.root_view);
            this.hjo = (ImageView) viewGroup2.findViewById(e.g.image_tip_1);
            this.hjp = (ImageView) viewGroup2.findViewById(e.g.image_tip_2);
            this.hjq = (ImageView) viewGroup2.findViewById(e.g.image_tip_3);
            this.hjm = BitmapHelper.getResBitmap(this.hjn.getPageContext().getPageActivity(), e.f.pic_bg_startpage);
            if (this.hjm != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.hjn.getResources(), this.hjm));
            }
            this.hjr = (GoOnAnimView) viewGroup2.findViewById(e.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.hjr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.hjn != null) {
                        if (NewUserGuideIntroduceFragment.this.hjn.bEr().bEy()) {
                            NewUserGuideIntroduceFragment.this.hjn.bEt();
                            return;
                        }
                        RightSlideViewPager bEq = NewUserGuideIntroduceFragment.this.hjn.bEq();
                        if (bEq != null) {
                            bEq.setCurrentItem(1, true);
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
            this.hjn.bEt();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEu() {
        this.hjo.setImageResource(e.f.pic_startpage1_one);
        this.hjp.setImageResource(e.f.pic_startpage1_two);
        this.hjq.setImageResource(e.f.pic_startpage1_three);
        a(this.hjo, true, 0L);
        a(this.hjp, false, 100L);
        a(this.hjq, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bEv() {
        if (this.hjr != null) {
            this.hjr.onStart();
        }
    }

    public void bEw() {
        if (this.hjr != null) {
            this.hjr.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.hjm != null) {
                if (!this.hjm.isRecycled()) {
                    this.hjm.recycle();
                }
                this.hjm = null;
            }
            this.hjo.clearAnimation();
            this.hjo.setImageDrawable(null);
            this.hjp.clearAnimation();
            this.hjp.setImageDrawable(null);
            this.hjq.clearAnimation();
            this.hjq.setImageDrawable(null);
            if (this.hjr != null) {
                this.hjr.onDestroy();
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
