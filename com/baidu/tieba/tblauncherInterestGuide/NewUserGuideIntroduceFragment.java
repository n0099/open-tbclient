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
                    NewUserGuideIntroduceFragment.this.dQJ();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.LN();
                    return;
                default:
                    return;
            }
        }
    };
    private ViewGroup mRootView;
    private NewUserGuideActivity nFa;
    private ImageView nFb;
    private ImageView nFc;
    private ImageView nFd;
    private GoOnAnimView nFe;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nFa = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.nFb = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.nFc = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.nFd = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.mBackBitmap = BitmapHelper.getResBitmap(this.nFa.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.mBackBitmap != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.nFa.getResources(), this.mBackBitmap));
            }
            this.nFe = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.nFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.nFa != null) {
                        if (NewUserGuideIntroduceFragment.this.nFa.dQG().dQM()) {
                            NewUserGuideIntroduceFragment.this.nFa.dQI();
                            return;
                        }
                        RightSlideViewPager dQF = NewUserGuideIntroduceFragment.this.nFa.dQF();
                        if (dQF != null) {
                            dQF.setCurrentItem(1, true);
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
            this.nFa.dQI();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LN() {
        this.nFb.setImageResource(R.drawable.pic_startpage1_one);
        this.nFc.setImageResource(R.drawable.pic_startpage1_two);
        this.nFd.setImageResource(R.drawable.pic_startpage1_three);
        a(this.nFb, true, 0L);
        a(this.nFc, false, 100L);
        a(this.nFd, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dQJ() {
        if (this.nFe != null) {
            this.nFe.onStart();
        }
    }

    public void dQK() {
        if (this.nFe != null) {
            this.nFe.onStop();
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
            this.nFb.clearAnimation();
            this.nFb.setImageDrawable(null);
            this.nFc.clearAnimation();
            this.nFc.setImageDrawable(null);
            this.nFd.clearAnimation();
            this.nFd.setImageDrawable(null);
            if (this.nFe != null) {
                this.nFe.onDestroy();
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
