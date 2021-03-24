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
/* loaded from: classes5.dex */
public class NewUserGuideIntroduceFragment extends BaseFragment {

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f21541f;

    /* renamed from: h  reason: collision with root package name */
    public NewUserGuideActivity f21543h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public GoOnAnimView l;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21540e = false;

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f21542g = null;
    public Handler m = new a();

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                NewUserGuideIntroduceFragment.this.I0();
            } else if (i != 1) {
            } else {
                NewUserGuideIntroduceFragment.this.H0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (NewUserGuideIntroduceFragment.this.f21543h != null) {
                if (NewUserGuideIntroduceFragment.this.f21543h.getNewUserGuideModel().v()) {
                    NewUserGuideIntroduceFragment.this.f21543h.startMainTabEnterFourm();
                    return;
                }
                RightSlideViewPager viewPager = NewUserGuideIntroduceFragment.this.f21543h.getViewPager();
                if (viewPager != null) {
                    viewPager.setCurrentItem(1, true);
                }
            }
        }
    }

    public final void G0(ImageView imageView, boolean z, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, z ? 1.0f : -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        translateAnimation.setStartOffset(j);
        translateAnimation.setFillAfter(true);
        imageView.startAnimation(translateAnimation);
    }

    public final void H0() {
        this.i.setImageResource(R.drawable.pic_startpage1_one);
        this.j.setImageResource(R.drawable.pic_startpage1_two);
        this.k.setImageResource(R.drawable.pic_startpage1_three);
        G0(this.i, true, 0L);
        G0(this.j, false, 100L);
        G0(this.k, true, 250L);
    }

    public void I0() {
        GoOnAnimView goOnAnimView = this.l;
        if (goOnAnimView != null) {
            goOnAnimView.j();
        }
    }

    public final void J0() {
        if (this.f21540e) {
            this.f21541f.setBackgroundDrawable(null);
            Bitmap bitmap = this.f21542g;
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    this.f21542g.recycle();
                }
                this.f21542g = null;
            }
            this.i.clearAnimation();
            this.i.setImageDrawable(null);
            this.j.clearAnimation();
            this.j.setImageDrawable(null);
            this.k.clearAnimation();
            this.k.setImageDrawable(null);
            GoOnAnimView goOnAnimView = this.l;
            if (goOnAnimView != null) {
                goOnAnimView.i();
            }
            this.m.removeMessages(0);
            this.m.removeMessages(1);
        }
    }

    public void K0() {
        GoOnAnimView goOnAnimView = this.l;
        if (goOnAnimView != null) {
            goOnAnimView.k();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21543h = (NewUserGuideActivity) getBaseFragmentActivity();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
            this.f21540e = true;
            this.f21541f = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
            this.i = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
            this.j = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
            this.k = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f21543h.getPageContext().getPageActivity(), R.drawable.pic_bg_startpage);
            this.f21542g = resBitmap;
            if (resBitmap != null) {
                this.f21541f.setBackgroundDrawable(new BitmapDrawable(this.f21543h.getResources(), this.f21542g));
            }
            this.l = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
            this.m.removeMessages(0);
            this.m.removeMessages(1);
            this.m.sendEmptyMessageDelayed(0, 750L);
            this.m.sendEmptyMessageDelayed(1, 70L);
            this.l.setOnClickListener(new b());
            return viewGroup2;
        } catch (InflateException e2) {
            this.f21540e = false;
            if (!TbadkApplication.getInst().isDebugMode()) {
                BdLog.e(e2);
                this.f21543h.startMainTabEnterFourm();
                TbadkApplication.getInst().onAppMemoryLow();
                return new FrameLayout(layoutInflater.getContext());
            }
            throw e2;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        J0();
    }
}
