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
    private NewUserGuideActivity hwC;
    private ImageView hwD;
    private ImageView hwE;
    private ImageView hwF;
    private GoOnAnimView hwG;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap hwB = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.bHw();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.bHv();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hwC = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(e.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(e.g.root_view);
            this.hwD = (ImageView) viewGroup2.findViewById(e.g.image_tip_1);
            this.hwE = (ImageView) viewGroup2.findViewById(e.g.image_tip_2);
            this.hwF = (ImageView) viewGroup2.findViewById(e.g.image_tip_3);
            this.hwB = BitmapHelper.getResBitmap(this.hwC.getPageContext().getPageActivity(), e.f.pic_bg_startpage);
            if (this.hwB != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.hwC.getResources(), this.hwB));
            }
            this.hwG = (GoOnAnimView) viewGroup2.findViewById(e.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.hwG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.hwC != null) {
                        if (NewUserGuideIntroduceFragment.this.hwC.bHs().bHz()) {
                            NewUserGuideIntroduceFragment.this.hwC.bHu();
                            return;
                        }
                        RightSlideViewPager bHr = NewUserGuideIntroduceFragment.this.hwC.bHr();
                        if (bHr != null) {
                            bHr.setCurrentItem(1, true);
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
            this.hwC.bHu();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHv() {
        this.hwD.setImageResource(e.f.pic_startpage1_one);
        this.hwE.setImageResource(e.f.pic_startpage1_two);
        this.hwF.setImageResource(e.f.pic_startpage1_three);
        a(this.hwD, true, 0L);
        a(this.hwE, false, 100L);
        a(this.hwF, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bHw() {
        if (this.hwG != null) {
            this.hwG.onStart();
        }
    }

    public void bHx() {
        if (this.hwG != null) {
            this.hwG.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.hwB != null) {
                if (!this.hwB.isRecycled()) {
                    this.hwB.recycle();
                }
                this.hwB = null;
            }
            this.hwD.clearAnimation();
            this.hwD.setImageDrawable(null);
            this.hwE.clearAnimation();
            this.hwE.setImageDrawable(null);
            this.hwF.clearAnimation();
            this.hwF.setImageDrawable(null);
            if (this.hwG != null) {
                this.hwG.onDestroy();
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
