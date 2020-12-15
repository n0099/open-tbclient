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
/* loaded from: classes22.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private ViewGroup mRootView;
    private ImageView ntA;
    private ImageView ntB;
    private GoOnAnimView ntC;
    private NewUserGuideActivity nty;
    private ImageView ntz;
    private boolean isInit = false;
    private Bitmap ntx = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dRW();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.OD();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nty = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.ntz = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.ntA = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.ntB = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.ntx = BitmapHelper.getResBitmap(this.nty.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.ntx != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.nty.getResources(), this.ntx));
            }
            this.ntC = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.ntC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.nty != null) {
                        if (NewUserGuideIntroduceFragment.this.nty.dRT().dRZ()) {
                            NewUserGuideIntroduceFragment.this.nty.dRV();
                            return;
                        }
                        RightSlideViewPager dRS = NewUserGuideIntroduceFragment.this.nty.dRS();
                        if (dRS != null) {
                            dRS.setCurrentItem(1, true);
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
            this.nty.dRV();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        this.ntz.setImageResource(R.drawable.pic_startpage1_one);
        this.ntA.setImageResource(R.drawable.pic_startpage1_two);
        this.ntB.setImageResource(R.drawable.pic_startpage1_three);
        a(this.ntz, true, 0L);
        a(this.ntA, false, 100L);
        a(this.ntB, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dRW() {
        if (this.ntC != null) {
            this.ntC.onStart();
        }
    }

    public void dRX() {
        if (this.ntC != null) {
            this.ntC.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.ntx != null) {
                if (!this.ntx.isRecycled()) {
                    this.ntx.recycle();
                }
                this.ntx = null;
            }
            this.ntz.clearAnimation();
            this.ntz.setImageDrawable(null);
            this.ntA.clearAnimation();
            this.ntA.setImageDrawable(null);
            this.ntB.clearAnimation();
            this.ntB.setImageDrawable(null);
            if (this.ntC != null) {
                this.ntC.onDestroy();
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
