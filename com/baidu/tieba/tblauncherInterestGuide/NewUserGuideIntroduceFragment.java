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
/* loaded from: classes4.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity jmi;
    private ImageView jmj;
    private ImageView jmk;
    private ImageView jml;
    private GoOnAnimView jmm;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap jmh = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.crP();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.crO();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jmi = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.jmj = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.jmk = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.jml = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.jmh = BitmapHelper.getResBitmap(this.jmi.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.jmh != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.jmi.getResources(), this.jmh));
            }
            this.jmm = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.jmm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.jmi != null) {
                        if (NewUserGuideIntroduceFragment.this.jmi.crL().crS()) {
                            NewUserGuideIntroduceFragment.this.jmi.crN();
                            return;
                        }
                        RightSlideViewPager crK = NewUserGuideIntroduceFragment.this.jmi.crK();
                        if (crK != null) {
                            crK.setCurrentItem(1, true);
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
            this.jmi.crN();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crO() {
        this.jmj.setImageResource(R.drawable.pic_startpage1_one);
        this.jmk.setImageResource(R.drawable.pic_startpage1_two);
        this.jml.setImageResource(R.drawable.pic_startpage1_three);
        a(this.jmj, true, 0L);
        a(this.jmk, false, 100L);
        a(this.jml, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void crP() {
        if (this.jmm != null) {
            this.jmm.onStart();
        }
    }

    public void crQ() {
        if (this.jmm != null) {
            this.jmm.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.jmh != null) {
                if (!this.jmh.isRecycled()) {
                    this.jmh.recycle();
                }
                this.jmh = null;
            }
            this.jmj.clearAnimation();
            this.jmj.setImageDrawable(null);
            this.jmk.clearAnimation();
            this.jmk.setImageDrawable(null);
            this.jml.clearAnimation();
            this.jml.setImageDrawable(null);
            if (this.jmm != null) {
                this.jmm.onDestroy();
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
