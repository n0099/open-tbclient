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
    private NewUserGuideActivity knR;
    private ImageView knS;
    private ImageView knT;
    private ImageView knU;
    private GoOnAnimView knV;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap knQ = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cNw();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.xG();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.knR = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.knS = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.knT = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.knU = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.knQ = BitmapHelper.getResBitmap(this.knR.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.knQ != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.knR.getResources(), this.knQ));
            }
            this.knV = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.knV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.knR != null) {
                        if (NewUserGuideIntroduceFragment.this.knR.cNt().cNz()) {
                            NewUserGuideIntroduceFragment.this.knR.cNv();
                            return;
                        }
                        RightSlideViewPager cNs = NewUserGuideIntroduceFragment.this.knR.cNs();
                        if (cNs != null) {
                            cNs.setCurrentItem(1, true);
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
            this.knR.cNv();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG() {
        this.knS.setImageResource(R.drawable.pic_startpage1_one);
        this.knT.setImageResource(R.drawable.pic_startpage1_two);
        this.knU.setImageResource(R.drawable.pic_startpage1_three);
        a(this.knS, true, 0L);
        a(this.knT, false, 100L);
        a(this.knU, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cNw() {
        if (this.knV != null) {
            this.knV.onStart();
        }
    }

    public void cNx() {
        if (this.knV != null) {
            this.knV.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.knQ != null) {
                if (!this.knQ.isRecycled()) {
                    this.knQ.recycle();
                }
                this.knQ = null;
            }
            this.knS.clearAnimation();
            this.knS.setImageDrawable(null);
            this.knT.clearAnimation();
            this.knT.setImageDrawable(null);
            this.knU.clearAnimation();
            this.knU.setImageDrawable(null);
            if (this.knV != null) {
                this.knV.onDestroy();
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
