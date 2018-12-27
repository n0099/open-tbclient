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
    private NewUserGuideActivity hvv;
    private ImageView hvw;
    private ImageView hvx;
    private ImageView hvy;
    private GoOnAnimView hvz;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap hvu = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.bGN();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.bGM();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hvv = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(e.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(e.g.root_view);
            this.hvw = (ImageView) viewGroup2.findViewById(e.g.image_tip_1);
            this.hvx = (ImageView) viewGroup2.findViewById(e.g.image_tip_2);
            this.hvy = (ImageView) viewGroup2.findViewById(e.g.image_tip_3);
            this.hvu = BitmapHelper.getResBitmap(this.hvv.getPageContext().getPageActivity(), e.f.pic_bg_startpage);
            if (this.hvu != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.hvv.getResources(), this.hvu));
            }
            this.hvz = (GoOnAnimView) viewGroup2.findViewById(e.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.hvz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.hvv != null) {
                        if (NewUserGuideIntroduceFragment.this.hvv.bGJ().bGQ()) {
                            NewUserGuideIntroduceFragment.this.hvv.bGL();
                            return;
                        }
                        RightSlideViewPager bGI = NewUserGuideIntroduceFragment.this.hvv.bGI();
                        if (bGI != null) {
                            bGI.setCurrentItem(1, true);
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
            this.hvv.bGL();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGM() {
        this.hvw.setImageResource(e.f.pic_startpage1_one);
        this.hvx.setImageResource(e.f.pic_startpage1_two);
        this.hvy.setImageResource(e.f.pic_startpage1_three);
        a(this.hvw, true, 0L);
        a(this.hvx, false, 100L);
        a(this.hvy, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bGN() {
        if (this.hvz != null) {
            this.hvz.onStart();
        }
    }

    public void bGO() {
        if (this.hvz != null) {
            this.hvz.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.hvu != null) {
                if (!this.hvu.isRecycled()) {
                    this.hvu.recycle();
                }
                this.hvu = null;
            }
            this.hvw.clearAnimation();
            this.hvw.setImageDrawable(null);
            this.hvx.clearAnimation();
            this.hvx.setImageDrawable(null);
            this.hvy.clearAnimation();
            this.hvy.setImageDrawable(null);
            if (this.hvz != null) {
                this.hvz.onDestroy();
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
