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
/* loaded from: classes21.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private ViewGroup mRootView;
    private NewUserGuideActivity mwc;
    private ImageView mwd;
    private ImageView mwe;
    private ImageView mwf;
    private GoOnAnimView mwg;
    private boolean isInit = false;
    private Bitmap mwb = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dDi();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.KS();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mwc = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.mwd = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.mwe = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.mwf = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.mwb = BitmapHelper.getResBitmap(this.mwc.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.mwb != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.mwc.getResources(), this.mwb));
            }
            this.mwg = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.mwg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.mwc != null) {
                        if (NewUserGuideIntroduceFragment.this.mwc.dDf().dDl()) {
                            NewUserGuideIntroduceFragment.this.mwc.dDh();
                            return;
                        }
                        RightSlideViewPager dDe = NewUserGuideIntroduceFragment.this.mwc.dDe();
                        if (dDe != null) {
                            dDe.setCurrentItem(1, true);
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
            this.mwc.dDh();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KS() {
        this.mwd.setImageResource(R.drawable.pic_startpage1_one);
        this.mwe.setImageResource(R.drawable.pic_startpage1_two);
        this.mwf.setImageResource(R.drawable.pic_startpage1_three);
        a(this.mwd, true, 0L);
        a(this.mwe, false, 100L);
        a(this.mwf, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dDi() {
        if (this.mwg != null) {
            this.mwg.onStart();
        }
    }

    public void dDj() {
        if (this.mwg != null) {
            this.mwg.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.mwb != null) {
                if (!this.mwb.isRecycled()) {
                    this.mwb.recycle();
                }
                this.mwb = null;
            }
            this.mwd.clearAnimation();
            this.mwd.setImageDrawable(null);
            this.mwe.clearAnimation();
            this.mwe.setImageDrawable(null);
            this.mwf.clearAnimation();
            this.mwf.setImageDrawable(null);
            if (this.mwg != null) {
                this.mwg.onDestroy();
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
