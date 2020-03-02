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
    private NewUserGuideActivity knF;
    private ImageView knG;
    private ImageView knH;
    private ImageView knI;
    private GoOnAnimView knJ;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap knE = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cNv();
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
        this.knF = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.knG = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.knH = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.knI = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.knE = BitmapHelper.getResBitmap(this.knF.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.knE != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.knF.getResources(), this.knE));
            }
            this.knJ = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.knJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.knF != null) {
                        if (NewUserGuideIntroduceFragment.this.knF.cNs().cNy()) {
                            NewUserGuideIntroduceFragment.this.knF.cNu();
                            return;
                        }
                        RightSlideViewPager cNr = NewUserGuideIntroduceFragment.this.knF.cNr();
                        if (cNr != null) {
                            cNr.setCurrentItem(1, true);
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
            this.knF.cNu();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG() {
        this.knG.setImageResource(R.drawable.pic_startpage1_one);
        this.knH.setImageResource(R.drawable.pic_startpage1_two);
        this.knI.setImageResource(R.drawable.pic_startpage1_three);
        a(this.knG, true, 0L);
        a(this.knH, false, 100L);
        a(this.knI, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cNv() {
        if (this.knJ != null) {
            this.knJ.onStart();
        }
    }

    public void cNw() {
        if (this.knJ != null) {
            this.knJ.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.knE != null) {
                if (!this.knE.isRecycled()) {
                    this.knE.recycle();
                }
                this.knE = null;
            }
            this.knG.clearAnimation();
            this.knG.setImageDrawable(null);
            this.knH.clearAnimation();
            this.knH.setImageDrawable(null);
            this.knI.clearAnimation();
            this.knI.setImageDrawable(null);
            if (this.knJ != null) {
                this.knJ.onDestroy();
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
