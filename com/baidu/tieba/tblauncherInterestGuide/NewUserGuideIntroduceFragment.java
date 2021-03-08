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
/* loaded from: classes2.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private boolean isInit = false;
    private Bitmap mBackBitmap = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dQS();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.LQ();
                    return;
                default:
                    return;
            }
        }
    };
    private ViewGroup mRootView;
    private NewUserGuideActivity nHg;
    private ImageView nHh;
    private ImageView nHi;
    private ImageView nHj;
    private GoOnAnimView nHk;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nHg = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.nHh = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.nHi = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.nHj = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.mBackBitmap = BitmapHelper.getResBitmap(this.nHg.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.mBackBitmap != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.nHg.getResources(), this.mBackBitmap));
            }
            this.nHk = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.nHk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.nHg != null) {
                        if (NewUserGuideIntroduceFragment.this.nHg.dQP().dQV()) {
                            NewUserGuideIntroduceFragment.this.nHg.dQR();
                            return;
                        }
                        RightSlideViewPager dQO = NewUserGuideIntroduceFragment.this.nHg.dQO();
                        if (dQO != null) {
                            dQO.setCurrentItem(1, true);
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
            this.nHg.dQR();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LQ() {
        this.nHh.setImageResource(R.drawable.pic_startpage1_one);
        this.nHi.setImageResource(R.drawable.pic_startpage1_two);
        this.nHj.setImageResource(R.drawable.pic_startpage1_three);
        a(this.nHh, true, 0L);
        a(this.nHi, false, 100L);
        a(this.nHj, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dQS() {
        if (this.nHk != null) {
            this.nHk.onStart();
        }
    }

    public void dQT() {
        if (this.nHk != null) {
            this.nHk.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.mBackBitmap != null) {
                if (!this.mBackBitmap.isRecycled()) {
                    this.mBackBitmap.recycle();
                }
                this.mBackBitmap = null;
            }
            this.nHh.clearAnimation();
            this.nHh.setImageDrawable(null);
            this.nHi.clearAnimation();
            this.nHi.setImageDrawable(null);
            this.nHj.clearAnimation();
            this.nHj.setImageDrawable(null);
            if (this.nHk != null) {
                this.nHk.onDestroy();
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
