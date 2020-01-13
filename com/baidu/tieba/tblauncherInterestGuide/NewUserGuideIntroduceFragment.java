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
/* loaded from: classes7.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity kmB;
    private ImageView kmC;
    private ImageView kmD;
    private ImageView kmE;
    private GoOnAnimView kmF;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap kmA = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cLW();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.vI();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kmB = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.kmC = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.kmD = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.kmE = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.kmA = BitmapHelper.getResBitmap(this.kmB.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.kmA != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.kmB.getResources(), this.kmA));
            }
            this.kmF = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.kmF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.kmB != null) {
                        if (NewUserGuideIntroduceFragment.this.kmB.cLT().cLZ()) {
                            NewUserGuideIntroduceFragment.this.kmB.cLV();
                            return;
                        }
                        RightSlideViewPager cLS = NewUserGuideIntroduceFragment.this.kmB.cLS();
                        if (cLS != null) {
                            cLS.setCurrentItem(1, true);
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
            this.kmB.cLV();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI() {
        this.kmC.setImageResource(R.drawable.pic_startpage1_one);
        this.kmD.setImageResource(R.drawable.pic_startpage1_two);
        this.kmE.setImageResource(R.drawable.pic_startpage1_three);
        a(this.kmC, true, 0L);
        a(this.kmD, false, 100L);
        a(this.kmE, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cLW() {
        if (this.kmF != null) {
            this.kmF.onStart();
        }
    }

    public void cLX() {
        if (this.kmF != null) {
            this.kmF.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.kmA != null) {
                if (!this.kmA.isRecycled()) {
                    this.kmA.recycle();
                }
                this.kmA = null;
            }
            this.kmC.clearAnimation();
            this.kmC.setImageDrawable(null);
            this.kmD.clearAnimation();
            this.kmD.setImageDrawable(null);
            this.kmE.clearAnimation();
            this.kmE.setImageDrawable(null);
            if (this.kmF != null) {
                this.kmF.onDestroy();
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
