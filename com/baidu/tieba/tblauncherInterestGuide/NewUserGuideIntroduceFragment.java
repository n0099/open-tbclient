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
import com.baidu.tieba.d;
import com.baidu.tieba.tblauncherInterestGuide.view.GoOnAnimView;
import com.baidu.tieba.tblauncherInterestGuide.view.RightSlideViewPager;
/* loaded from: classes3.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private NewUserGuideActivity gUg;
    private ImageView gUh;
    private ImageView gUi;
    private ImageView gUj;
    private GoOnAnimView gUk;
    private ViewGroup mRootView;
    private boolean isInit = false;
    private Bitmap gUf = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.byx();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.byw();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUg = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(d.h.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(d.g.root_view);
            this.gUh = (ImageView) viewGroup2.findViewById(d.g.image_tip_1);
            this.gUi = (ImageView) viewGroup2.findViewById(d.g.image_tip_2);
            this.gUj = (ImageView) viewGroup2.findViewById(d.g.image_tip_3);
            this.gUf = BitmapHelper.getResBitmap(this.gUg.getPageContext().getPageActivity(), d.f.pic_bg_startpage);
            if (this.gUf != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.gUg.getResources(), this.gUf));
            }
            this.gUk = (GoOnAnimView) viewGroup2.findViewById(d.g.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.gUk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.gUg != null) {
                        if (NewUserGuideIntroduceFragment.this.gUg.byt().byA()) {
                            NewUserGuideIntroduceFragment.this.gUg.byv();
                            return;
                        }
                        RightSlideViewPager bys = NewUserGuideIntroduceFragment.this.gUg.bys();
                        if (bys != null) {
                            bys.setCurrentItem(1, true);
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
            this.gUg.byv();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byw() {
        this.gUh.setImageResource(d.f.pic_startpage1_one);
        this.gUi.setImageResource(d.f.pic_startpage1_two);
        this.gUj.setImageResource(d.f.pic_startpage1_three);
        a(this.gUh, true, 0L);
        a(this.gUi, false, 100L);
        a(this.gUj, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void byx() {
        if (this.gUk != null) {
            this.gUk.onStart();
        }
    }

    public void byy() {
        if (this.gUk != null) {
            this.gUk.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.gUf != null) {
                if (!this.gUf.isRecycled()) {
                    this.gUf.recycle();
                }
                this.gUf = null;
            }
            this.gUh.clearAnimation();
            this.gUh.setImageDrawable(null);
            this.gUi.clearAnimation();
            this.gUi.setImageDrawable(null);
            this.gUj.clearAnimation();
            this.gUj.setImageDrawable(null);
            if (this.gUk != null) {
                this.gUk.onDestroy();
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
