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
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.view.GoOnAnimView;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
/* loaded from: classes22.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private ViewGroup mRootView;
    private NewUserGuideActivity neq;
    private ImageView ner;
    private ImageView nes;
    private ImageView neu;
    private GoOnAnimView nev;
    private boolean isInit = false;
    private Bitmap nep = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dME();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.MR();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.neq = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.ner = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.nes = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.neu = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.nep = BitmapHelper.getResBitmap(this.neq.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.nep != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.neq.getResources(), this.nep));
            }
            this.nev = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.nev.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.neq != null) {
                        if (NewUserGuideIntroduceFragment.this.neq.dMB().dMH()) {
                            NewUserGuideIntroduceFragment.this.neq.dMD();
                            return;
                        }
                        RightSlideViewPager dMA = NewUserGuideIntroduceFragment.this.neq.dMA();
                        if (dMA != null) {
                            dMA.setCurrentItem(1, true);
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
            this.neq.dMD();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MR() {
        this.ner.setImageResource(R.drawable.pic_startpage1_one);
        this.nes.setImageResource(R.drawable.pic_startpage1_two);
        this.neu.setImageResource(R.drawable.pic_startpage1_three);
        a(this.ner, true, 0L);
        a(this.nes, false, 100L);
        a(this.neu, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dME() {
        if (this.nev != null) {
            this.nev.onStart();
        }
    }

    public void dMF() {
        if (this.nev != null) {
            this.nev.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.nep != null) {
                if (!this.nep.isRecycled()) {
                    this.nep.recycle();
                }
                this.nep = null;
            }
            this.ner.clearAnimation();
            this.ner.setImageDrawable(null);
            this.nes.clearAnimation();
            this.nes.setImageDrawable(null);
            this.neu.clearAnimation();
            this.neu.setImageDrawable(null);
            if (this.nev != null) {
                this.nev.onDestroy();
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
