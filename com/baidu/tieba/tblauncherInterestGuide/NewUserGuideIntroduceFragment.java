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
/* loaded from: classes9.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity kZB;
    private ImageView kZC;
    private ImageView kZD;
    private ImageView kZE;
    private GoOnAnimView kZF;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap kZA = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cYN();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.CB();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kZB = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.kZC = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.kZD = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.kZE = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.kZA = BitmapHelper.getResBitmap(this.kZB.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.kZA != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.kZB.getResources(), this.kZA));
            }
            this.kZF = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.kZF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.kZB != null) {
                        if (NewUserGuideIntroduceFragment.this.kZB.cYK().cYQ()) {
                            NewUserGuideIntroduceFragment.this.kZB.cYM();
                            return;
                        }
                        RightSlideViewPager cYJ = NewUserGuideIntroduceFragment.this.kZB.cYJ();
                        if (cYJ != null) {
                            cYJ.setCurrentItem(1, true);
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
            this.kZB.cYM();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CB() {
        this.kZC.setImageResource(R.drawable.pic_startpage1_one);
        this.kZD.setImageResource(R.drawable.pic_startpage1_two);
        this.kZE.setImageResource(R.drawable.pic_startpage1_three);
        a(this.kZC, true, 0L);
        a(this.kZD, false, 100L);
        a(this.kZE, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cYN() {
        if (this.kZF != null) {
            this.kZF.onStart();
        }
    }

    public void cYO() {
        if (this.kZF != null) {
            this.kZF.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.kZA != null) {
                if (!this.kZA.isRecycled()) {
                    this.kZA.recycle();
                }
                this.kZA = null;
            }
            this.kZC.clearAnimation();
            this.kZC.setImageDrawable(null);
            this.kZD.clearAnimation();
            this.kZD.setImageDrawable(null);
            this.kZE.clearAnimation();
            this.kZE.setImageDrawable(null);
            if (this.kZF != null) {
                this.kZF.onDestroy();
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
