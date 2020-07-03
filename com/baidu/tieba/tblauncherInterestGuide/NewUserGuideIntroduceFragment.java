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
    private NewUserGuideActivity lNg;
    private ImageView lNh;
    private ImageView lNi;
    private ImageView lNj;
    private GoOnAnimView lNk;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap lNf = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dkw();
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
        this.lNg = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.lNh = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.lNi = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.lNj = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.lNf = BitmapHelper.getResBitmap(this.lNg.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.lNf != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.lNg.getResources(), this.lNf));
            }
            this.lNk = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.lNk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.lNg != null) {
                        if (NewUserGuideIntroduceFragment.this.lNg.dkt().dkz()) {
                            NewUserGuideIntroduceFragment.this.lNg.dkv();
                            return;
                        }
                        RightSlideViewPager dks = NewUserGuideIntroduceFragment.this.lNg.dks();
                        if (dks != null) {
                            dks.setCurrentItem(1, true);
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
            this.lNg.dkv();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ez() {
        this.lNh.setImageResource(R.drawable.pic_startpage1_one);
        this.lNi.setImageResource(R.drawable.pic_startpage1_two);
        this.lNj.setImageResource(R.drawable.pic_startpage1_three);
        a(this.lNh, true, 0L);
        a(this.lNi, false, 100L);
        a(this.lNj, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dkw() {
        if (this.lNk != null) {
            this.lNk.onStart();
        }
    }

    public void dkx() {
        if (this.lNk != null) {
            this.lNk.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.lNf != null) {
                if (!this.lNf.isRecycled()) {
                    this.lNf.recycle();
                }
                this.lNf = null;
            }
            this.lNh.clearAnimation();
            this.lNh.setImageDrawable(null);
            this.lNi.clearAnimation();
            this.lNi.setImageDrawable(null);
            this.lNj.clearAnimation();
            this.lNj.setImageDrawable(null);
            if (this.lNk != null) {
                this.lNk.onDestroy();
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
