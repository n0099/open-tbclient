package com.baidu.tieba.write;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.view.AniImageView;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class AudioIcon extends RelativeLayout {
    private static int g = 0;

    /* renamed from: a  reason: collision with root package name */
    private Context f2063a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private AniImageView h;
    private ImageView i;

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 1));
    }

    public AudioIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = -1;
        this.f2063a = context;
        k();
        a(attributeSet);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.h.setEnabled(z);
    }

    public void a() {
        com.baidu.tieba.sharedPref.b.a().b("audio_animation_done", true);
    }

    private boolean j() {
        return com.baidu.tieba.sharedPref.b.a().a("audio_animation_done", false);
    }

    public void b() {
        setVisibility(8);
    }

    public void c() {
        setVisibility(0);
    }

    private void k() {
        LayoutInflater.from(this.f2063a).inflate(R.layout.audio_icon, (ViewGroup) this, true);
        this.h = (AniImageView) findViewById(R.id.audio_icon);
        this.i = (ImageView) findViewById(R.id.new_icon);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, R.id.audio_icon);
        layoutParams.setMargins(UtilHelper.a(this.f2063a, -12.0f), UtilHelper.a(this.f2063a, -2.0f), 0, 0);
        this.i.setLayoutParams(layoutParams);
    }

    public void d() {
        if (!j()) {
            List<Animation> animations = ((AnimationSet) AnimationUtils.loadAnimation(this.f2063a, R.anim.audio_icon_rotate)).getAnimations();
            g = 0;
            m mVar = new m(this, animations);
            for (int i = 0; i < animations.size(); i++) {
                animations.get(i).setAnimationListener(mVar);
            }
            new Handler().postDelayed(new n(this, animations), 500L);
        }
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f2063a.obtainStyledAttributes(attributeSet, com.baidu.tieba.ag.PbWriteToolView);
        this.c = obtainStyledAttributes.getResourceId(4, -1);
        this.d = obtainStyledAttributes.getResourceId(5, -1);
        this.e = obtainStyledAttributes.getResourceId(6, -1);
        this.f = obtainStyledAttributes.getResourceId(7, -1);
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        if (this.h != null) {
            this.h.setClickable(z);
        }
    }

    public void a(int i) {
        if (i == 1) {
            this.h.setImageResource(this.d);
            this.i.setImageResource(R.drawable.icon_news_content_prompt_1);
            return;
        }
        this.h.setImageResource(this.c);
        this.i.setImageResource(R.drawable.icon_news_content_prompt);
    }

    private boolean l() {
        return TiebaApplication.g().ap() == 1;
    }

    public void e() {
        this.h.setImageResource(l() ? this.f : this.e);
    }

    public void f() {
        this.h.setImageResource(l() ? this.d : this.c);
    }

    public ImageView getView() {
        return this.h;
    }

    public void g() {
        if (this.i != null) {
            this.i.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (this.h != null) {
            this.h.setOnClickListener(onClickListener);
        }
    }

    public void h() {
        if (this.i != null) {
            this.i.setVisibility(4);
        }
    }

    public void setImage(Drawable drawable) {
        if (this.h != null) {
            this.h.setImageDrawable(drawable);
        }
    }

    public void setImageResource(int i) {
        if (this.h != null) {
            this.h.setImageResource(i);
        }
    }
}
