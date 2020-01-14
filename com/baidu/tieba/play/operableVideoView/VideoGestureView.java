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
    private int hXC;
    private ViewGroup jxW;
    private ImageView jxX;
    private ProgressBar jxY;
    private ViewGroup jxZ;
    private ImageView jya;
    private TextView jyb;
    private int jyc;
    private float jyd;
    private int jye;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hXC = 100;
        this.jyd = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hXC = 100;
        this.jyd = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hXC = 100;
        this.jyd = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.jxW = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.jxX = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.jxY = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.jxZ = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.jya = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.jyb = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.jxW.setBackgroundDrawable(am.ay(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hXC = this.mAudioManager.getStreamMaxVolume(3);
            this.jyc = this.mAudioManager.getStreamVolume(3);
            this.jyd = 100 / this.hXC;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.jxZ.setVisibility(0);
            this.jxW.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.jyb.setText(str);
        SvgManager.aEp().a(this.jya, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void l(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.jxZ.setVisibility(8);
            this.jxW.setVisibility(0);
            this.jxY.setMax(100);
            setBackgroundDrawable(null);
            this.jyc = this.mAudioManager.getStreamVolume(3);
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
        this.jyc = (int) (this.mProgress / this.jyd);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aEp().a(this.jxX, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.jyc, 0);
        this.jxY.setProgress(this.mProgress);
    }

    public void m(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.jxZ.setVisibility(8);
            this.jxW.setVisibility(0);
            this.jxY.setMax(255);
            setBackgroundDrawable(null);
            this.jye = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.jye += 2;
        } else {
            this.jye -= 2;
        }
        if (this.jye < 1) {
            this.jye = 1;
        } else if (this.jye > 255) {
            this.jye = 255;
        }
        if (this.jye <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.jye <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aEp().a(this.jxX, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.jye / 255.0f;
        window.setAttributes(attributes);
        this.jxY.setProgress(this.jye);
    }
}
