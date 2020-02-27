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
    private int hZA;
    private ViewGroup jyM;
    private ImageView jyN;
    private ProgressBar jyO;
    private ViewGroup jyP;
    private ImageView jyQ;
    private TextView jyR;
    private int jyS;
    private float jyT;
    private int jyU;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hZA = 100;
        this.jyT = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hZA = 100;
        this.jyT = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hZA = 100;
        this.jyT = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.jyM = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.jyN = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.jyO = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.jyP = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.jyQ = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.jyR = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.jyM.setBackgroundDrawable(am.ay(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hZA = this.mAudioManager.getStreamMaxVolume(3);
            this.jyS = this.mAudioManager.getStreamVolume(3);
            this.jyT = 100 / this.hZA;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.jyP.setVisibility(0);
            this.jyM.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.jyR.setText(str);
        SvgManager.aGA().a(this.jyQ, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void k(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.jyP.setVisibility(8);
            this.jyM.setVisibility(0);
            this.jyO.setMax(100);
            setBackgroundDrawable(null);
            this.jyS = this.mAudioManager.getStreamVolume(3);
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
        this.jyS = (int) (this.mProgress / this.jyT);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aGA().a(this.jyN, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.jyS, 0);
        this.jyO.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.jyP.setVisibility(8);
            this.jyM.setVisibility(0);
            this.jyO.setMax(255);
            setBackgroundDrawable(null);
            this.jyU = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.jyU += 2;
        } else {
            this.jyU -= 2;
        }
        if (this.jyU < 1) {
            this.jyU = 1;
        } else if (this.jyU > 255) {
            this.jyU = 255;
        }
        if (this.jyU <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.jyU <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aGA().a(this.jyN, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.jyU / 255.0f;
        window.setAttributes(attributes);
        this.jyO.setProgress(this.jyU);
    }
}
