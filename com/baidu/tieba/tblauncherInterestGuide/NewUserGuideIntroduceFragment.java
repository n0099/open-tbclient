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
    private NewUserGuideActivity kmG;
    private ImageView kmH;
    private ImageView kmI;
    private ImageView kmJ;
    private GoOnAnimView kmK;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap kmF = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cLY();
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
        this.kmG = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.kmH = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.kmI = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.kmJ = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.kmF = BitmapHelper.getResBitmap(this.kmG.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.kmF != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.kmG.getResources(), this.kmF));
            }
            this.kmK = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.kmK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.kmG != null) {
                        if (NewUserGuideIntroduceFragment.this.kmG.cLV().cMb()) {
                            NewUserGuideIntroduceFragment.this.kmG.cLX();
                            return;
                        }
                        RightSlideViewPager cLU = NewUserGuideIntroduceFragment.this.kmG.cLU();
                        if (cLU != null) {
                            cLU.setCurrentItem(1, true);
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
            this.kmG.cLX();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI() {
        this.kmH.setImageResource(R.drawable.pic_startpage1_one);
        this.kmI.setImageResource(R.drawable.pic_startpage1_two);
        this.kmJ.setImageResource(R.drawable.pic_startpage1_three);
        a(this.kmH, true, 0L);
        a(this.kmI, false, 100L);
        a(this.kmJ, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cLY() {
        if (this.kmK != null) {
            this.kmK.onStart();
        }
    }

    public void cLZ() {
        if (this.kmK != null) {
            this.kmK.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.kmF != null) {
                if (!this.kmF.isRecycled()) {
                    this.kmF.recycle();
                }
                this.kmF = null;
            }
            this.kmH.clearAnimation();
            this.kmH.setImageDrawable(null);
            this.kmI.clearAnimation();
            this.kmI.setImageDrawable(null);
            this.kmJ.clearAnimation();
            this.kmJ.setImageDrawable(null);
            if (this.kmK != null) {
                this.kmK.onDestroy();
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
