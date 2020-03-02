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
    private int hZC;
    private ViewGroup jyO;
    private ImageView jyP;
    private ProgressBar jyQ;
    private ViewGroup jyR;
    private ImageView jyS;
    private TextView jyT;
    private int jyU;
    private float jyV;
    private int jyW;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hZC = 100;
        this.jyV = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hZC = 100;
        this.jyV = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hZC = 100;
        this.jyV = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.jyO = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.jyP = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.jyQ = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.jyR = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.jyS = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.jyT = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.jyO.setBackgroundDrawable(am.ay(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hZC = this.mAudioManager.getStreamMaxVolume(3);
            this.jyU = this.mAudioManager.getStreamVolume(3);
            this.jyV = 100 / this.hZC;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.jyR.setVisibility(0);
            this.jyO.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.jyT.setText(str);
        SvgManager.aGC().a(this.jyS, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void k(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.jyR.setVisibility(8);
            this.jyO.setVisibility(0);
            this.jyQ.setMax(100);
            setBackgroundDrawable(null);
            this.jyU = this.mAudioManager.getStreamVolume(3);
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
        this.jyU = (int) (this.mProgress / this.jyV);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aGC().a(this.jyP, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.jyU, 0);
        this.jyQ.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.jyR.setVisibility(8);
            this.jyO.setVisibility(0);
            this.jyQ.setMax(255);
            setBackgroundDrawable(null);
            this.jyW = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.jyW += 2;
        } else {
            this.jyW -= 2;
        }
        if (this.jyW < 1) {
            this.jyW = 1;
        } else if (this.jyW > 255) {
            this.jyW = 255;
        }
        if (this.jyW <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.jyW <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aGC().a(this.jyP, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.jyW / 255.0f;
        window.setAttributes(attributes);
        this.jyQ.setProgress(this.jyW);
    }
}
