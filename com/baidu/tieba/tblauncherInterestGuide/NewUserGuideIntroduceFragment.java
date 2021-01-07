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
                    NewUserGuideIntroduceFragment.this.dSi();
                    return;
                case 1:
                    NewUserGuideIntroduceFragment.this.Oj();
                    return;
                default:
                    return;
            }
        }
    };
    private ViewGroup mRootView;
    private NewUserGuideActivity nzu;
    private ImageView nzv;
    private ImageView nzw;
    private ImageView nzx;
    private GoOnAnimView nzy;

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nzu = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.isInit = true;
            this.mRootView = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.nzv = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.nzw = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.nzx = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            this.mBackBitmap = BitmapHelper.getResBitmap(this.nzu.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            if (this.mBackBitmap != null) {
                this.mRootView.setBackgroundDrawable(new BitmapDrawable(this.nzu.getResources(), this.mBackBitmap));
            }
            this.nzy = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.mHandler.removeMessages(0);
            this.mHandler.removeMessages(1);
            this.mHandler.sendEmptyMessageDelayed(0, 750L);
            this.mHandler.sendEmptyMessageDelayed(1, 70L);
            this.nzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tblauncherInterestGuide.NewUserGuideIntroduceFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (NewUserGuideIntroduceFragment.this.nzu != null) {
                        if (NewUserGuideIntroduceFragment.this.nzu.dSf().dSl()) {
                            NewUserGuideIntroduceFragment.this.nzu.dSh();
                            return;
                        }
                        RightSlideViewPager dSe = NewUserGuideIntroduceFragment.this.nzu.dSe();
                        if (dSe != null) {
                            dSe.setCurrentItem(1, true);
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
            this.nzu.dSh();
            TbadkApplication.getInst().onAppMemoryLow();
            return new FrameLayout(layoutInflater.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oj() {
        this.nzv.setImageResource(R.drawable.pic_startpage1_one);
        this.nzw.setImageResource(R.drawable.pic_startpage1_two);
        this.nzx.setImageResource(R.drawable.pic_startpage1_three);
        a(this.nzv, true, 0L);
        a(this.nzw, false, 100L);
        a(this.nzx, true, 250L);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stop();
    }

    public void dSi() {
        if (this.nzy != null) {
            this.nzy.onStart();
        }
    }

    public void dSj() {
        if (this.nzy != null) {
            this.nzy.onStop();
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
            this.nzv.clearAnimation();
            this.nzv.setImageDrawable(null);
            this.nzw.clearAnimation();
            this.nzw.setImageDrawable(null);
            this.nzx.clearAnimation();
            this.nzx.setImageDrawable(null);
            if (this.nzy != null) {
                this.nzy.onDestroy();
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
