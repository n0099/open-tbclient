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
    private NewUserGuideActivity gCc;
    private ImageView gCd;
    private ImageView gCe;
    private ImageView gCf;
    private GoOnAnimView gCg;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap gCb = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.bul();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.buk();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gCc = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.i.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.gCd = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.gCe = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.gCf = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.gCb = BitmapHelper.getResBitmap(this.gCc.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.gCb != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.gCc.getResources(), this.gCb));
            }
            this.gCg = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.gCg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (NewUserGuideIntroduceFragment.this.gCc != null) {
                        if (NewUserGuideIntroduceFragment.this.gCc.buh().buo()) {
                            NewUserGuideIntroduceFragment.this.gCc.buj();
                            return;
                        }
                        RightSlideViewPager bug = NewUserGuideIntroduceFragment.this.gCc.bug();
                        if (bug != null) {
                            bug.setCurrentItem(1, true);
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
            this.gCc.buj();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buk() {
        this.gCd.setImageResource(d.f.pic_startpage1_one);
        this.gCe.setImageResource(d.f.pic_startpage1_two);
        this.gCf.setImageResource(d.f.pic_startpage1_three);
        a(this.gCd, true, 0L);
        a(this.gCe, false, 100L);
        a(this.gCf, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bul() {
        if (this.gCg != null) {
            this.gCg.onStart();
        }
    }

    public void bum() {
        if (this.gCg != null) {
            this.gCg.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.gCb != null) {
                if (!this.gCb.isRecycled()) {
                    this.gCb.recycle();
                }
                this.gCb = null;
            }
            this.gCd.clearAnimation();
            this.gCd.setImageDrawable(null);
            this.gCe.clearAnimation();
            this.gCe.setImageDrawable(null);
            this.gCf.clearAnimation();
            this.gCf.setImageDrawable(null);
            if (this.gCg != null) {
                this.gCg.onDestroy();
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
