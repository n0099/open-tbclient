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
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity gTi;
    private ImageView gTj;
    private ImageView gTk;
    private ImageView gTl;
    private GoOnAnimView gTm;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap gTh = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.bzU();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.bzT();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gTi = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.i.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.gTj = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.gTk = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.gTl = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.gTh = BitmapHelper.getResBitmap(this.gTi.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.gTh != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.gTi.getResources(), this.gTh));
            }
            this.gTm = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.gTm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.gTi != null) {
                        if (NewUserGuideIntroduceFragment.this.gTi.bzQ().bzX()) {
                            NewUserGuideIntroduceFragment.this.gTi.bzS();
                            return;
                        }
                        RightSlideViewPager bzP = NewUserGuideIntroduceFragment.this.gTi.bzP();
                        if (bzP != null) {
                            bzP.setCurrentItem(1, true);
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
            this.gTi.bzS();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzT() {
        this.gTj.setImageResource(d.f.pic_startpage1_one);
        this.gTk.setImageResource(d.f.pic_startpage1_two);
        this.gTl.setImageResource(d.f.pic_startpage1_three);
        a(this.gTj, true, 0L);
        a(this.gTk, false, 100L);
        a(this.gTl, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bzU() {
        if (this.gTm != null) {
            this.gTm.onStart();
        }
    }

    public void bzV() {
        if (this.gTm != null) {
            this.gTm.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.gTh != null) {
                if (!this.gTh.isRecycled()) {
                    this.gTh.recycle();
                }
                this.gTh = null;
            }
            this.gTj.clearAnimation();
            this.gTj.setImageDrawable(null);
            this.gTk.clearAnimation();
            this.gTk.setImageDrawable(null);
            this.gTl.clearAnimation();
            this.gTl.setImageDrawable(null);
            if (this.gTm != null) {
                this.gTm.onDestroy();
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
