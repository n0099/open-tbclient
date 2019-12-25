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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoGestureView extends RelativeLayout {
    private int hTY;
    private ViewGroup jup;
    private ImageView juq;
    private ProgressBar jur;
    private ViewGroup jus;
    private ImageView jut;
    private TextView juu;
    private int juv;
    private float juw;
    private int jux;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hTY = 100;
        this.juw = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hTY = 100;
        this.juw = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hTY = 100;
        this.juw = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.jup = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.juq = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.jur = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.jus = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.jut = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.juu = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.jup.setBackgroundDrawable(am.au(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hTY = this.mAudioManager.getStreamMaxVolume(3);
            this.juv = this.mAudioManager.getStreamVolume(3);
            this.juw = 100 / this.hTY;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.jus.setVisibility(0);
            this.jup.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.juu.setText(str);
        SvgManager.aDW().a(this.jut, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void l(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.jus.setVisibility(8);
            this.jup.setVisibility(0);
            this.jur.setMax(100);
            setBackgroundDrawable(null);
            this.juv = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress += i;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress -= i;
        }
        if (this.mProgress > 100) {
            this.mProgress = 100;
        }
        if (this.mProgress < 0) {
            this.mProgress = 0;
        }
        this.juv = (int) (this.mProgress / this.juw);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aDW().a(this.juq, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.juv, 0);
        this.jur.setProgress(this.mProgress);
    }

    public void m(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.jus.setVisibility(8);
            this.jup.setVisibility(0);
            this.jur.setMax(255);
            setBackgroundDrawable(null);
            this.jux = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.jux += 2;
        } else {
            this.jux -= 2;
        }
        if (this.jux < 1) {
            this.jux = 1;
        } else if (this.jux > 255) {
            this.jux = 255;
        }
        if (this.jux <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.jux <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aDW().a(this.juq, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.jux / 255.0f;
        window.setAttributes(attributes);
        this.jur.setProgress(this.jux);
    }
}
