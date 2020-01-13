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
    private ViewGroup jxR;
    private ImageView jxS;
    private ProgressBar jxT;
    private ViewGroup jxU;
    private ImageView jxV;
    private TextView jxW;
    private int jxX;
    private float jxY;
    private int jxZ;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hXC = 100;
        this.jxY = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hXC = 100;
        this.jxY = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hXC = 100;
        this.jxY = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.jxR = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.jxS = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.jxT = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.jxU = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.jxV = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.jxW = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.jxR.setBackgroundDrawable(am.ay(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hXC = this.mAudioManager.getStreamMaxVolume(3);
            this.jxX = this.mAudioManager.getStreamVolume(3);
            this.jxY = 100 / this.hXC;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.jxU.setVisibility(0);
            this.jxR.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.jxW.setText(str);
        SvgManager.aEp().a(this.jxV, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void l(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.jxU.setVisibility(8);
            this.jxR.setVisibility(0);
            this.jxT.setMax(100);
            setBackgroundDrawable(null);
            this.jxX = this.mAudioManager.getStreamVolume(3);
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
        this.jxX = (int) (this.mProgress / this.jxY);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aEp().a(this.jxS, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.jxX, 0);
        this.jxT.setProgress(this.mProgress);
    }

    public void m(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.jxU.setVisibility(8);
            this.jxR.setVisibility(0);
            this.jxT.setMax(255);
            setBackgroundDrawable(null);
            this.jxZ = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.jxZ += 2;
        } else {
            this.jxZ -= 2;
        }
        if (this.jxZ < 1) {
            this.jxZ = 1;
        } else if (this.jxZ > 255) {
            this.jxZ = 255;
        }
        if (this.jxZ <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.jxZ <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aEp().a(this.jxS, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.jxZ / 255.0f;
        window.setAttributes(attributes);
        this.jxT.setProgress(this.jxZ);
    }
}
