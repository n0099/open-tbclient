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
    private NewUserGuideActivity hsj;
    private ImageView hsk;
    private ImageView hsl;
    private ImageView hsm;
    private GoOnAnimView hsn;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap hsi = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.bFX();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.bFW();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hsj = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(e.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(e.g.root_view);
            this.hsk = (ImageView) viewGroup2.findViewById(e.g.image_tip_1);
            this.hsl = (ImageView) viewGroup2.findViewById(e.g.image_tip_2);
            this.hsm = (ImageView) viewGroup2.findViewById(e.g.image_tip_3);
            this.hsi = BitmapHelper.getResBitmap(this.hsj.getPageContext().getPageActivity(), e.f.pic_bg_startpage);
            if (this.hsi != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.hsj.getResources(), this.hsi));
            }
            this.hsn = (GoOnAnimView) viewGroup2.findViewById(e.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.hsn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.hsj != null) {
                        if (NewUserGuideIntroduceFragment.this.hsj.bFT().bGa()) {
                            NewUserGuideIntroduceFragment.this.hsj.bFV();
                            return;
                        }
                        RightSlideViewPager bFS = NewUserGuideIntroduceFragment.this.hsj.bFS();
                        if (bFS != null) {
                            bFS.setCurrentItem(1, true);
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
            this.hsj.bFV();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFW() {
        this.hsk.setImageResource(e.f.pic_startpage1_one);
        this.hsl.setImageResource(e.f.pic_startpage1_two);
        this.hsm.setImageResource(e.f.pic_startpage1_three);
        a(this.hsk, true, 0L);
        a(this.hsl, false, 100L);
        a(this.hsm, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void bFX() {
        if (this.hsn != null) {
            this.hsn.onStart();
        }
    }

    public void bFY() {
        if (this.hsn != null) {
            this.hsn.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.hsi != null) {
                if (!this.hsi.isRecycled()) {
                    this.hsi.recycle();
                }
                this.hsi = null;
            }
            this.hsk.clearAnimation();
            this.hsk.setImageDrawable(null);
            this.hsl.clearAnimation();
            this.hsl.setImageDrawable(null);
            this.hsm.clearAnimation();
            this.hsm.setImageDrawable(null);
            if (this.hsn != null) {
                this.hsn.onDestroy();
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
