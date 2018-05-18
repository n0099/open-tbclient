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
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.view.GoOnAnimView;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
/* loaded from: classes3.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity gDf;
    private ImageView gDg;
    private ImageView gDh;
    private ImageView gDi;
    private GoOnAnimView gDj;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap gDe = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.buj();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.bui();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gDf = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.i.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.gDg = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.gDh = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.gDi = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.gDe = BitmapHelper.getResBitmap(this.gDf.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.gDe != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.gDf.getResources(), this.gDe));
            }
            this.gDj = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.gDj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (NewUserGuideIntroduceFragment.this.gDf != null) {
                        if (NewUserGuideIntroduceFragment.this.gDf.buf().bum()) {
                            NewUserGuideIntroduceFragment.this.gDf.buh();
                            return;
                        }
                        RightSlideViewPager bue = NewUserGuideIntroduceFragment.this.gDf.bue();
                        if (bue != null) {
                            bue.setCurrentItem(1, true);
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
            this.gDf.buh();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bui() {
        this.gDg.setImageResource(d.f.pic_startpage1_one);
        this.gDh.setImageResource(d.f.pic_startpage1_two);
        this.gDi.setImageResource(d.f.pic_startpage1_three);
        a(this.gDg, true, 0L);
        a(this.gDh, false, 100L);
        a(this.gDi, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void buj() {
        if (this.gDj != null) {
            this.gDj.onStart();
        }
    }

    public void buk() {
        if (this.gDj != null) {
            this.gDj.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.gDe != null) {
                if (!this.gDe.isRecycled()) {
                    this.gDe.recycle();
                }
                this.gDe = null;
            }
            this.gDg.clearAnimation();
            this.gDg.setImageDrawable(null);
            this.gDh.clearAnimation();
            this.gDh.setImageDrawable(null);
            this.gDi.clearAnimation();
            this.gDi.setImageDrawable(null);
            if (this.gDj != null) {
                this.gDj.onDestroy();
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
