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
    private NewUserGuideActivity jfU;
    private ImageView jfV;
    private ImageView jfW;
    private ImageView jfX;
    private GoOnAnimView jfY;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap jfT = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cpd();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.cpc();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jfU = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.jfV = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.jfW = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.jfX = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.jfT = BitmapHelper.getResBitmap(this.jfU.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.jfT != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.jfU.getResources(), this.jfT));
            }
            this.jfY = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.jfY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.jfU != null) {
                        if (NewUserGuideIntroduceFragment.this.jfU.coZ().cpg()) {
                            NewUserGuideIntroduceFragment.this.jfU.cpb();
                            return;
                        }
                        RightSlideViewPager coY = NewUserGuideIntroduceFragment.this.jfU.coY();
                        if (coY != null) {
                            coY.setCurrentItem(1, true);
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
            this.jfU.cpb();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpc() {
        this.jfV.setImageResource(R.drawable.pic_startpage1_one);
        this.jfW.setImageResource(R.drawable.pic_startpage1_two);
        this.jfX.setImageResource(R.drawable.pic_startpage1_three);
        a(this.jfV, true, 0L);
        a(this.jfW, false, 100L);
        a(this.jfX, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cpd() {
        if (this.jfY != null) {
            this.jfY.onStart();
        }
    }

    public void cpe() {
        if (this.jfY != null) {
            this.jfY.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.jfT != null) {
                if (!this.jfT.isRecycled()) {
                    this.jfT.recycle();
                }
                this.jfT = null;
            }
            this.jfV.clearAnimation();
            this.jfV.setImageDrawable(null);
            this.jfW.clearAnimation();
            this.jfW.setImageDrawable(null);
            this.jfX.clearAnimation();
            this.jfX.setImageDrawable(null);
            if (this.jfY != null) {
                this.jfY.onDestroy();
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
