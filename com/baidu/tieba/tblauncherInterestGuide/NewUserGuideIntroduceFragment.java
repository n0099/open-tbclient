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
/* loaded from: classes21.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {
    private ViewGroup mRootView;
    private NewUserGuideActivity nfs;
    private ImageView nft;
    private ImageView nfu;
    private ImageView nfv;
    private GoOnAnimView nfw;
    private boolean isInit = false;
    private Bitmap nfr = null;
    private Handler mHandler = new Handler() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    NewUserGuideIntroduceFragment.this.dMD();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.Mi();
                    return;
                default:
                    return;
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nfs = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.nft = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.nfu = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.nfv = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.nfr = BitmapHelper.getResBitmap(this.nfs.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.nfr != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.nfs.getResources(), this.nfr));
            }
            this.nfw = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.nfw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.nfs != null) {
                        if (NewUserGuideIntroduceFragment.this.nfs.dMA().dMG()) {
                            NewUserGuideIntroduceFragment.this.nfs.dMC();
                            return;
                        }
                        RightSlideViewPager dMz = NewUserGuideIntroduceFragment.this.nfs.dMz();
                        if (dMz != null) {
                            dMz.setCurrentItem(1, true);
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
            this.nfs.dMC();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mi() {
        this.nft.setImageResource(R.drawable.pic_startpage1_one);
        this.nfu.setImageResource(R.drawable.pic_startpage1_two);
        this.nfv.setImageResource(R.drawable.pic_startpage1_three);
        a(this.nft, true, 0L);
        a(this.nfu, false, 100L);
        a(this.nfv, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dMD() {
        if (this.nfw != null) {
            this.nfw.onStart();
        }
    }

    public void dME() {
        if (this.nfw != null) {
            this.nfw.onStop();
        }
    }

    private void stop() {
        if (this.isInit) {
            this.mRootView.setBackgroundDrawable(null);
            if (this.nfr != null) {
                if (!this.nfr.isRecycled()) {
                    this.nfr.recycle();
                }
                this.nfr = null;
            }
            this.nft.clearAnimation();
            this.nft.setImageDrawable(null);
            this.nfu.clearAnimation();
            this.nfu.setImageDrawable(null);
            this.nfv.clearAnimation();
            this.nfv.setImageDrawable(null);
            if (this.nfw != null) {
                this.nfw.onDestroy();
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
