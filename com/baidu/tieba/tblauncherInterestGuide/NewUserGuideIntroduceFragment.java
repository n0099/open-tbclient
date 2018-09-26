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
    private NewUserGuideActivity hbV;
    private ImageView hbW;
    private ImageView hbX;
    private ImageView hbY;
    private GoOnAnimView hbZ;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap hbU = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.bBh();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.bBg();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbV = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(e.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(e.g.root_view);
            this.hbW = (ImageView) viewGroup2.findViewById(e.g.image_tip_1);
            this.hbX = (ImageView) viewGroup2.findViewById(e.g.image_tip_2);
            this.hbY = (ImageView) viewGroup2.findViewById(e.g.image_tip_3);
            this.hbU = BitmapHelper.getResBitmap(this.hbV.getPageContext().getPageActivity(), e.f.pic_bg_startpage);
            if (this.hbU != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.hbV.getResources(), this.hbU));
            }
            this.hbZ = (GoOnAnimView) viewGroup2.findViewById(e.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.hbZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.hbV != null) {
                        if (NewUserGuideIntroduceFragment.this.hbV.bBd().bBk()) {
                            NewUserGuideIntroduceFragment.this.hbV.bBf();
                            return;
                        }
                        RightSlideViewPager bBc = NewUserGuideIntroduceFragment.this.hbV.bBc();
                        if (bBc != null) {
                            bBc.setCurrentItem(1, true);
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
            this.hbV.bBf();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBg() {
        this.hbW.setImageResource(e.f.pic_startpage1_one);
        this.hbX.setImageResource(e.f.pic_startpage1_two);
        this.hbY.setImageResource(e.f.pic_startpage1_three);
        a(this.hbW, true, 0L);
        a(this.hbX, false, 100L);
        a(this.hbY, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bBh() {
        if (this.hbZ != null) {
            this.hbZ.onStart();
        }
    }

    public void bBi() {
        if (this.hbZ != null) {
            this.hbZ.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.hbU != null) {
                if (!this.hbU.isRecycled()) {
                    this.hbU.recycle();
                }
                this.hbU = null;
            }
            this.hbW.clearAnimation();
            this.hbW.setImageDrawable(null);
            this.hbX.clearAnimation();
            this.hbX.setImageDrawable(null);
            this.hbY.clearAnimation();
            this.hbY.setImageDrawable(null);
            if (this.hbZ != null) {
                this.hbZ.onDestroy();
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
