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
    private GoOnAnimView lUA;
    private NewUserGuideActivity lUw;
    private ImageView lUx;
    private ImageView lUy;
    private ImageView lUz;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap lUv = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dnJ();
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
        this.lUw = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.lUx = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.lUy = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.lUz = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.lUv = BitmapHelper.getResBitmap(this.lUw.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.lUv != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.lUw.getResources(), this.lUv));
            }
            this.lUA = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.lUA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.lUw != null) {
                        if (NewUserGuideIntroduceFragment.this.lUw.dnG().dnM()) {
                            NewUserGuideIntroduceFragment.this.lUw.dnI();
                            return;
                        }
                        RightSlideViewPager dnF = NewUserGuideIntroduceFragment.this.lUw.dnF();
                        if (dnF != null) {
                            dnF.setCurrentItem(1, true);
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
            this.lUw.dnI();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG() {
        this.lUx.setImageResource(R.drawable.pic_startpage1_one);
        this.lUy.setImageResource(R.drawable.pic_startpage1_two);
        this.lUz.setImageResource(R.drawable.pic_startpage1_three);
        a(this.lUx, true, 0L);
        a(this.lUy, false, 100L);
        a(this.lUz, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dnJ() {
        if (this.lUA != null) {
            this.lUA.onStart();
        }
    }

    public void dnK() {
        if (this.lUA != null) {
            this.lUA.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.lUv != null) {
                if (!this.lUv.isRecycled()) {
                    this.lUv.recycle();
                }
                this.lUv = null;
            }
            this.lUx.clearAnimation();
            this.lUx.setImageDrawable(null);
            this.lUy.clearAnimation();
            this.lUy.setImageDrawable(null);
            this.lUz.clearAnimation();
            this.lUz.setImageDrawable(null);
            if (this.lUA != null) {
                this.lUA.onDestroy();
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
