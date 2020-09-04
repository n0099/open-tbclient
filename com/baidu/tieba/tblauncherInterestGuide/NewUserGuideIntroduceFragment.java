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
/* loaded from: classes16.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private ViewGroup mRootView;
    private NewUserGuideActivity mmD;
    private ImageView mmE;
    private ImageView mmF;
    private ImageView mmG;
    private GoOnAnimView mmH;
    private boolean isInit = false;
    private Bitmap mmC = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dzo();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.Kl();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mmD = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.mmE = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.mmF = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.mmG = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.mmC = BitmapHelper.getResBitmap(this.mmD.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.mmC != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.mmD.getResources(), this.mmC));
            }
            this.mmH = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.mmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.mmD != null) {
                        if (NewUserGuideIntroduceFragment.this.mmD.dzl().dzr()) {
                            NewUserGuideIntroduceFragment.this.mmD.dzn();
                            return;
                        }
                        RightSlideViewPager dzk = NewUserGuideIntroduceFragment.this.mmD.dzk();
                        if (dzk != null) {
                            dzk.setCurrentItem(1, true);
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
            this.mmD.dzn();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kl() {
        this.mmE.setImageResource(R.drawable.pic_startpage1_one);
        this.mmF.setImageResource(R.drawable.pic_startpage1_two);
        this.mmG.setImageResource(R.drawable.pic_startpage1_three);
        a(this.mmE, true, 0L);
        a(this.mmF, false, 100L);
        a(this.mmG, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dzo() {
        if (this.mmH != null) {
            this.mmH.onStart();
        }
    }

    public void dzp() {
        if (this.mmH != null) {
            this.mmH.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.mmC != null) {
                if (!this.mmC.isRecycled()) {
                    this.mmC.recycle();
                }
                this.mmC = null;
            }
            this.mmE.clearAnimation();
            this.mmE.setImageDrawable(null);
            this.mmF.clearAnimation();
            this.mmF.setImageDrawable(null);
            this.mmG.clearAnimation();
            this.mmG.setImageDrawable(null);
            if (this.mmH != null) {
                this.mmH.onDestroy();
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
