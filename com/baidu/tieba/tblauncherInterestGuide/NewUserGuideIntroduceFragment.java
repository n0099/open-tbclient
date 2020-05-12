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
    private NewUserGuideActivity kZF;
    private ImageView kZG;
    private ImageView kZH;
    private ImageView kZI;
    private GoOnAnimView kZJ;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap kZE = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cYL();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.CA();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kZF = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.kZG = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.kZH = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.kZI = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.kZE = BitmapHelper.getResBitmap(this.kZF.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.kZE != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.kZF.getResources(), this.kZE));
            }
            this.kZJ = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.kZJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.kZF != null) {
                        if (NewUserGuideIntroduceFragment.this.kZF.cYI().cYO()) {
                            NewUserGuideIntroduceFragment.this.kZF.cYK();
                            return;
                        }
                        RightSlideViewPager cYH = NewUserGuideIntroduceFragment.this.kZF.cYH();
                        if (cYH != null) {
                            cYH.setCurrentItem(1, true);
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
            this.kZF.cYK();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CA() {
        this.kZG.setImageResource(R.drawable.pic_startpage1_one);
        this.kZH.setImageResource(R.drawable.pic_startpage1_two);
        this.kZI.setImageResource(R.drawable.pic_startpage1_three);
        a(this.kZG, true, 0L);
        a(this.kZH, false, 100L);
        a(this.kZI, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cYL() {
        if (this.kZJ != null) {
            this.kZJ.onStart();
        }
    }

    public void cYM() {
        if (this.kZJ != null) {
            this.kZJ.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.kZE != null) {
                if (!this.kZE.isRecycled()) {
                    this.kZE.recycle();
                }
                this.kZE = null;
            }
            this.kZG.clearAnimation();
            this.kZG.setImageDrawable(null);
            this.kZH.clearAnimation();
            this.kZH.setImageDrawable(null);
            this.kZI.clearAnimation();
            this.kZI.setImageDrawable(null);
            if (this.kZJ != null) {
                this.kZJ.onDestroy();
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
