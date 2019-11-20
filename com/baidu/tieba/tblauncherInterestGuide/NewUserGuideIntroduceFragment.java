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
    private NewUserGuideActivity joM;
    private ImageView joN;
    private ImageView joO;
    private ImageView joP;
    private GoOnAnimView joQ;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap joL = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.cqM();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.tx();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.joM = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.joN = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.joO = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.joP = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.joL = BitmapHelper.getResBitmap(this.joM.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.joL != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.joM.getResources(), this.joL));
            }
            this.joQ = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.joQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.joM != null) {
                        if (NewUserGuideIntroduceFragment.this.joM.cqJ().cqP()) {
                            NewUserGuideIntroduceFragment.this.joM.cqL();
                            return;
                        }
                        RightSlideViewPager cqI = NewUserGuideIntroduceFragment.this.joM.cqI();
                        if (cqI != null) {
                            cqI.setCurrentItem(1, true);
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
            this.joM.cqL();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx() {
        this.joN.setImageResource(R.drawable.pic_startpage1_one);
        this.joO.setImageResource(R.drawable.pic_startpage1_two);
        this.joP.setImageResource(R.drawable.pic_startpage1_three);
        a(this.joN, true, 0L);
        a(this.joO, false, 100L);
        a(this.joP, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void cqM() {
        if (this.joQ != null) {
            this.joQ.onStart();
        }
    }

    public void cqN() {
        if (this.joQ != null) {
            this.joQ.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.joL != null) {
                if (!this.joL.isRecycled()) {
                    this.joL.recycle();
                }
                this.joL = null;
            }
            this.joN.clearAnimation();
            this.joN.setImageDrawable(null);
            this.joO.clearAnimation();
            this.joO.setImageDrawable(null);
            this.joP.clearAnimation();
            this.joP.setImageDrawable(null);
            if (this.joQ != null) {
                this.joQ.onDestroy();
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
