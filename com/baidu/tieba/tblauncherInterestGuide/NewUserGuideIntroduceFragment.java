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
    private GoOnAnimView ntA;
    private NewUserGuideActivity ntw;
    private ImageView ntx;
    private ImageView nty;
    private ImageView ntz;
    private boolean isInit = false;
    private Bitmap ntv = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dRV();
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
        this.ntw = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.ntx = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.nty = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.ntz = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.ntv = BitmapHelper.getResBitmap(this.ntw.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.ntv != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.ntw.getResources(), this.ntv));
            }
            this.ntA = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.ntA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.ntw != null) {
                        if (NewUserGuideIntroduceFragment.this.ntw.dRS().dRY()) {
                            NewUserGuideIntroduceFragment.this.ntw.dRU();
                            return;
                        }
                        RightSlideViewPager dRR = NewUserGuideIntroduceFragment.this.ntw.dRR();
                        if (dRR != null) {
                            dRR.setCurrentItem(1, true);
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
            this.ntw.dRU();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        this.ntx.setImageResource(R.drawable.pic_startpage1_one);
        this.nty.setImageResource(R.drawable.pic_startpage1_two);
        this.ntz.setImageResource(R.drawable.pic_startpage1_three);
        a(this.ntx, true, 0L);
        a(this.nty, false, 100L);
        a(this.ntz, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dRV() {
        if (this.ntA != null) {
            this.ntA.onStart();
        }
    }

    public void dRW() {
        if (this.ntA != null) {
            this.ntA.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.ntv != null) {
                if (!this.ntv.isRecycled()) {
                    this.ntv.recycle();
                }
                this.ntv = null;
            }
            this.ntx.clearAnimation();
            this.ntx.setImageDrawable(null);
            this.nty.clearAnimation();
            this.nty.setImageDrawable(null);
            this.ntz.clearAnimation();
            this.ntz.setImageDrawable(null);
            if (this.ntA != null) {
                this.ntA.onDestroy();
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
