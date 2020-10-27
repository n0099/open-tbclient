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
    private NewUserGuideActivity mYv;
    private ImageView mYw;
    private ImageView mYx;
    private ImageView mYy;
    private GoOnAnimView mYz;
    private boolean isInit = false;
    private Bitmap mYu = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dKc();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.Mr();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mYv = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.mYw = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.mYx = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.mYy = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.mYu = BitmapHelper.getResBitmap(this.mYv.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.mYu != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.mYv.getResources(), this.mYu));
            }
            this.mYz = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.mYz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.mYv != null) {
                        if (NewUserGuideIntroduceFragment.this.mYv.dJZ().dKf()) {
                            NewUserGuideIntroduceFragment.this.mYv.dKb();
                            return;
                        }
                        RightSlideViewPager dJY = NewUserGuideIntroduceFragment.this.mYv.dJY();
                        if (dJY != null) {
                            dJY.setCurrentItem(1, true);
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
            this.mYv.dKb();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mr() {
        this.mYw.setImageResource(R.drawable.pic_startpage1_one);
        this.mYx.setImageResource(R.drawable.pic_startpage1_two);
        this.mYy.setImageResource(R.drawable.pic_startpage1_three);
        a(this.mYw, true, 0L);
        a(this.mYx, false, 100L);
        a(this.mYy, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dKc() {
        if (this.mYz != null) {
            this.mYz.onStart();
        }
    }

    public void dKd() {
        if (this.mYz != null) {
            this.mYz.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.mYu != null) {
                if (!this.mYu.isRecycled()) {
                    this.mYu.recycle();
                }
                this.mYu = null;
            }
            this.mYw.clearAnimation();
            this.mYw.setImageDrawable(null);
            this.mYx.clearAnimation();
            this.mYx.setImageDrawable(null);
            this.mYy.clearAnimation();
            this.mYy.setImageDrawable(null);
            if (this.mYz != null) {
                this.mYz.onDestroy();
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
