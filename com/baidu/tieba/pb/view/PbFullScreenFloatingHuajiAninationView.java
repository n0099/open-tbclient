package com.baidu.tieba.pb.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    public static final int w = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    public static final int x = l.k(TbadkCoreApplication.getInst());

    /* renamed from: e  reason: collision with root package name */
    public ImageView f19614e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f19615f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19616g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19617h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f19618i;
    public ImageView j;
    public TextView k;
    public AnimatorSet l;
    public AnimatorSet m;
    public AnimatorSet n;
    public AnimatorSet o;
    public AnimatorSet p;
    public AnimatorSet q;
    public AnimatorSet r;
    public c s;
    public boolean t;
    public Runnable u;
    public Runnable v;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PbFullScreenFloatingHuajiAninationView.this.b();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
            if (PbFullScreenFloatingHuajiAninationView.this.getParent() == null || PbFullScreenFloatingHuajiAninationView.this.getParent() != viewGroup) {
                return;
            }
            viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.t = false;
        this.u = new a();
        this.v = new b();
        c();
    }

    public final void b() {
        this.t = false;
        e.a().post(this.v);
        c cVar = this.s;
        if (cVar != null) {
            cVar.onAnimationEnd();
        }
        removeCallbacks(this.u);
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.pb_full_screen_floating_huaji_view, this);
        this.f19614e = (ImageView) findViewById(R.id.pb_video_floating_big_huaji);
        this.f19615f = (ImageView) findViewById(R.id.pb_video_floating_small_huaji1);
        this.f19616g = (ImageView) findViewById(R.id.pb_video_floating_small_huaji2);
        this.f19617h = (ImageView) findViewById(R.id.pb_video_floating_small_huaji3);
        this.f19618i = (ImageView) findViewById(R.id.pb_video_floating_small_huaji4);
        this.j = (ImageView) findViewById(R.id.pb_video_floating_small_huaji5);
        TextView textView = (TextView) findViewById(R.id.pb_video_floating_huaji_tip);
        this.k = textView;
        textView.setX((x - w) / 2);
        e(TbadkCoreApplication.getInst().getSkinType());
        d();
    }

    public final void d() {
        this.l = new AnimatorSet();
        Drawable drawable = SkinManager.getDrawable(R.drawable.icon_floor_bigpraised_floating);
        ImageView imageView = this.f19614e;
        float intrinsicWidth = (x - drawable.getIntrinsicWidth()) / 2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "X", x, intrinsicWidth);
        ofFloat.setDuration(400L);
        ImageView imageView2 = this.f19614e;
        float intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.l.playTogether(ofFloat, ofFloat2);
        this.m = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f19615f, "X", x, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.m.play(ofFloat3);
        this.n = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f19616g, "X", x, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.n.play(ofFloat4);
        this.o = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f19617h, "X", x, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.o.play(ofFloat5);
        this.p = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f19618i, "X", x, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(IMLikeRequest.TIME_INTERVAL);
        this.p.play(ofFloat6);
        this.q = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.j, "X", x, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.q.play(ofFloat7);
        this.r = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.k, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.k, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.k, "X", x / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.r.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void e(int i2) {
        SkinManager.setBackgroundColor(this, R.color.black_alpha60);
        int i3 = R.drawable.icon_floor_praised_floating;
        int i4 = R.drawable.icon_floor_bigpraised_floating;
        d.a.j0.s.c.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.a()) {
            i3 = R.drawable.icon_floor_praised_floating_xmas;
            i4 = R.drawable.icon_floor_bigpraised_floating_xmas;
        }
        SkinManager.setImageResource(this.f19614e, i4);
        SkinManager.setImageResource(this.f19615f, i3);
        SkinManager.setImageResource(this.f19616g, i3);
        SkinManager.setImageResource(this.f19617h, i3);
        SkinManager.setImageResource(this.f19618i, i3);
        SkinManager.setImageResource(this.j, i3);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
    }

    public void f(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2 || this.t) {
            return;
        }
        this.t = true;
        ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
        postDelayed(this.u, 2000L);
        this.l.start();
        this.m.start();
        this.n.start();
        this.o.start();
        this.p.start();
        this.q.start();
    }

    public void g() {
        if (this.t) {
            b();
            this.l.cancel();
            this.m.cancel();
            this.n.cancel();
            this.o.cancel();
            this.p.cancel();
            this.q.cancel();
            this.r.cancel();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            g();
        }
    }

    public void setFloatingHuajiAninationListener(c cVar) {
        this.s = cVar;
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.t = false;
        this.u = new a();
        this.v = new b();
        c();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.t = false;
        this.u = new a();
        this.v = new b();
        c();
    }
}
