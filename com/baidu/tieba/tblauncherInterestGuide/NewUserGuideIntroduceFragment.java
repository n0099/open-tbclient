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
    private NewUserGuideActivity lsp;
    private ImageView lsq;
    private ImageView lsr;
    private ImageView lss;
    private GoOnAnimView lst;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap lso = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dfZ();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.DX();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lsp = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.lsq = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.lsr = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.lss = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.lso = BitmapHelper.getResBitmap(this.lsp.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.lso != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.lsp.getResources(), this.lso));
            }
            this.lst = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.lst.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.lsp != null) {
                        if (NewUserGuideIntroduceFragment.this.lsp.dfW().dgc()) {
                            NewUserGuideIntroduceFragment.this.lsp.dfY();
                            return;
                        }
                        RightSlideViewPager dfV = NewUserGuideIntroduceFragment.this.lsp.dfV();
                        if (dfV != null) {
                            dfV.setCurrentItem(1, true);
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
            this.lsp.dfY();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX() {
        this.lsq.setImageResource(R.drawable.pic_startpage1_one);
        this.lsr.setImageResource(R.drawable.pic_startpage1_two);
        this.lss.setImageResource(R.drawable.pic_startpage1_three);
        a(this.lsq, true, 0L);
        a(this.lsr, false, 100L);
        a(this.lss, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dfZ() {
        if (this.lst != null) {
            this.lst.onStart();
        }
    }

    public void dga() {
        if (this.lst != null) {
            this.lst.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.lso != null) {
                if (!this.lso.isRecycled()) {
                    this.lso.recycle();
                }
                this.lso = null;
            }
            this.lsq.clearAnimation();
            this.lsq.setImageDrawable(null);
            this.lsr.clearAnimation();
            this.lsr.setImageDrawable(null);
            this.lss.clearAnimation();
            this.lss.setImageDrawable(null);
            if (this.lst != null) {
                this.lst.onDestroy();
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
