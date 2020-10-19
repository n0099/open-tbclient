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
    private NewUserGuideActivity mLM;
    private ImageView mLN;
    private ImageView mLO;
    private ImageView mLP;
    private GoOnAnimView mLQ;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap mLL = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dGU();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.LX();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mLM = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.mLN = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.mLO = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.mLP = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.mLL = BitmapHelper.getResBitmap(this.mLM.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.mLL != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.mLM.getResources(), this.mLL));
            }
            this.mLQ = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.mLQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.mLM != null) {
                        if (NewUserGuideIntroduceFragment.this.mLM.dGR().dGX()) {
                            NewUserGuideIntroduceFragment.this.mLM.dGT();
                            return;
                        }
                        RightSlideViewPager dGQ = NewUserGuideIntroduceFragment.this.mLM.dGQ();
                        if (dGQ != null) {
                            dGQ.setCurrentItem(1, true);
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
            this.mLM.dGT();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LX() {
        this.mLN.setImageResource(R.drawable.pic_startpage1_one);
        this.mLO.setImageResource(R.drawable.pic_startpage1_two);
        this.mLP.setImageResource(R.drawable.pic_startpage1_three);
        a(this.mLN, true, 0L);
        a(this.mLO, false, 100L);
        a(this.mLP, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dGU() {
        if (this.mLQ != null) {
            this.mLQ.onStart();
        }
    }

    public void dGV() {
        if (this.mLQ != null) {
            this.mLQ.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.mLL != null) {
                if (!this.mLL.isRecycled()) {
                    this.mLL.recycle();
                }
                this.mLL = null;
            }
            this.mLN.clearAnimation();
            this.mLN.setImageDrawable(null);
            this.mLO.clearAnimation();
            this.mLO.setImageDrawable(null);
            this.mLP.clearAnimation();
            this.mLP.setImageDrawable(null);
            if (this.mLQ != null) {
                this.mLQ.onDestroy();
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
