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
    private ImageView lUA;
    private ImageView lUB;
    private GoOnAnimView lUC;
    private NewUserGuideActivity lUy;
    private ImageView lUz;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap lUx = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dnK();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.EG();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lUy = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.lUz = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.lUA = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.lUB = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.lUx = BitmapHelper.getResBitmap(this.lUy.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.lUx != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.lUy.getResources(), this.lUx));
            }
            this.lUC = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.lUC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.lUy != null) {
                        if (NewUserGuideIntroduceFragment.this.lUy.dnH().dnN()) {
                            NewUserGuideIntroduceFragment.this.lUy.dnJ();
                            return;
                        }
                        RightSlideViewPager dnG = NewUserGuideIntroduceFragment.this.lUy.dnG();
                        if (dnG != null) {
                            dnG.setCurrentItem(1, true);
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
            this.lUy.dnJ();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG() {
        this.lUz.setImageResource(R.drawable.pic_startpage1_one);
        this.lUA.setImageResource(R.drawable.pic_startpage1_two);
        this.lUB.setImageResource(R.drawable.pic_startpage1_three);
        a(this.lUz, true, 0L);
        a(this.lUA, false, 100L);
        a(this.lUB, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dnK() {
        if (this.lUC != null) {
            this.lUC.onStart();
        }
    }

    public void dnL() {
        if (this.lUC != null) {
            this.lUC.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.lUx != null) {
                if (!this.lUx.isRecycled()) {
                    this.lUx.recycle();
                }
                this.lUx = null;
            }
            this.lUz.clearAnimation();
            this.lUz.setImageDrawable(null);
            this.lUA.clearAnimation();
            this.lUA.setImageDrawable(null);
            this.lUB.clearAnimation();
            this.lUB.setImageDrawable(null);
            if (this.lUC != null) {
                this.lUC.onDestroy();
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
