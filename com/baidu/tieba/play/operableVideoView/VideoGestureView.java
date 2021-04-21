package com.baidu.tieba.play.operableVideoView;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class VideoGestureView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f20236e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f20237f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f20238g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f20239h;
    public ImageView i;
    public TextView j;
    public AudioManager k;
    public int l;
    public int m;
    public float n;
    public int o;
    public int p;
    public int q;

    public VideoGestureView(Context context) {
        super(context);
        this.l = 100;
        this.n = 1.0f;
        this.q = 0;
        e();
    }

    public void a(Context context, boolean z) {
        int i;
        if (this.q != 2) {
            this.f20239h.setVisibility(8);
            this.f20236e.setVisibility(0);
            this.f20238g.setMax(255);
            setBackgroundDrawable(null);
            this.p = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.q = 2;
        }
        if (z) {
            this.p += 2;
        } else {
            this.p -= 2;
        }
        int i2 = this.p;
        if (i2 < 1) {
            this.p = 1;
        } else if (i2 > 255) {
            this.p = 255;
        }
        int i3 = this.p;
        if (i3 <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (i3 <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f20237f, i, R.color.CAM_X0622, null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.p / 255.0f;
        window.setAttributes(attributes);
        this.f20238g.setProgress(this.p);
    }

    public void b(boolean z, String str) {
        if (this.q != 3) {
            this.f20239h.setVisibility(0);
            this.f20236e.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.q = 3;
        }
        this.j.setText(str);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.i, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, null);
    }

    public void c(Context context, boolean z) {
        d(context, z, 1);
    }

    public void d(Context context, boolean z, int i) {
        int i2;
        int i3;
        int i4;
        if (this.q != 1) {
            this.f20239h.setVisibility(8);
            this.f20236e.setVisibility(0);
            this.f20238g.setMax(100);
            setBackgroundDrawable(null);
            this.m = this.k.getStreamVolume(3);
            this.q = 1;
        }
        if (z && (i4 = this.o) < 100) {
            this.o = i4 + i;
        }
        if (!z && (i3 = this.o) > 0) {
            this.o = i3 - i;
        }
        if (this.o > 100) {
            this.o = 100;
        }
        if (this.o < 0) {
            this.o = 0;
        }
        int i5 = this.o;
        this.m = (int) (i5 / this.n);
        if (i5 == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (i5 < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f20237f, i2, R.color.CAM_X0622, null);
        this.k.setStreamVolume(3, this.m, 0);
        this.f20238g.setProgress(this.o);
    }

    public final void e() {
        RelativeLayout.inflate(getContext(), R.layout.operable_video_gesture, this);
        this.f20236e = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.f20237f = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.f20238g = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.f20239h = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.i = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.j = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.f20236e.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        AudioManager audioManager = (AudioManager) getContext().getSystemService("audio");
        this.k = audioManager;
        if (audioManager != null) {
            this.l = audioManager.getStreamMaxVolume(3);
            this.m = this.k.getStreamVolume(3);
            this.n = 100 / this.l;
        }
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = 100;
        this.n = 1.0f;
        this.q = 0;
        e();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 100;
        this.n = 1.0f;
        this.q = 0;
        e();
    }
}
