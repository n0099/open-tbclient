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
    private NewUserGuideActivity lNj;
    private ImageView lNk;
    private ImageView lNl;
    private ImageView lNm;
    private GoOnAnimView lNn;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap lNi = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dkA();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.Ez();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lNj = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.lNk = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.lNl = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.lNm = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.lNi = BitmapHelper.getResBitmap(this.lNj.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.lNi != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.lNj.getResources(), this.lNi));
            }
            this.lNn = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.lNn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.lNj != null) {
                        if (NewUserGuideIntroduceFragment.this.lNj.dkx().dkD()) {
                            NewUserGuideIntroduceFragment.this.lNj.dkz();
                            return;
                        }
                        RightSlideViewPager dkw = NewUserGuideIntroduceFragment.this.lNj.dkw();
                        if (dkw != null) {
                            dkw.setCurrentItem(1, true);
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
            this.lNj.dkz();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez() {
        this.lNk.setImageResource(R.drawable.pic_startpage1_one);
        this.lNl.setImageResource(R.drawable.pic_startpage1_two);
        this.lNm.setImageResource(R.drawable.pic_startpage1_three);
        a(this.lNk, true, 0L);
        a(this.lNl, false, 100L);
        a(this.lNm, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dkA() {
        if (this.lNn != null) {
            this.lNn.onStart();
        }
    }

    public void dkB() {
        if (this.lNn != null) {
            this.lNn.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.lNi != null) {
                if (!this.lNi.isRecycled()) {
                    this.lNi.recycle();
                }
                this.lNi = null;
            }
            this.lNk.clearAnimation();
            this.lNk.setImageDrawable(null);
            this.lNl.clearAnimation();
            this.lNl.setImageDrawable(null);
            this.lNm.clearAnimation();
            this.lNm.setImageDrawable(null);
            if (this.lNn != null) {
                this.lNn.onDestroy();
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
