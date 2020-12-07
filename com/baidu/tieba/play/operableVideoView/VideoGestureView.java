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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoGestureView extends RelativeLayout {
    private int kUe;
    private ViewGroup mAN;
    private ImageView mAO;
    private ProgressBar mAP;
    private ViewGroup mAQ;
    private ImageView mAR;
    private TextView mAS;
    private int mAT;
    private float mAU;
    private int mAV;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.kUe = 100;
        this.mAU = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kUe = 100;
        this.mAU = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kUe = 100;
        this.mAU = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mAN = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mAO = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mAP = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mAQ = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mAR = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mAS = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mAN.setBackgroundDrawable(ap.aR(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.kUe = this.mAudioManager.getStreamMaxVolume(3);
            this.mAT = this.mAudioManager.getStreamVolume(3);
            this.mAU = 100 / this.kUe;
        }
    }

    public void E(boolean z, String str) {
        if (this.mState != 3) {
            this.mAQ.setVisibility(0);
            this.mAN.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.mState = 3;
        }
        this.mAS.setText(str);
        SvgManager.btW().a(this.mAR, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void x(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mAQ.setVisibility(8);
            this.mAN.setVisibility(0);
            this.mAP.setMax(100);
            setBackgroundDrawable(null);
            this.mAT = this.mAudioManager.getStreamVolume(3);
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
        this.mAT = (int) (this.mProgress / this.mAU);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.btW().a(this.mAO, i2, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mAT, 0);
        this.mAP.setProgress(this.mProgress);
    }

    public void y(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mAQ.setVisibility(8);
            this.mAN.setVisibility(0);
            this.mAP.setMax(255);
            setBackgroundDrawable(null);
            this.mAV = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mAV += 2;
        } else {
            this.mAV -= 2;
        }
        if (this.mAV < 1) {
            this.mAV = 1;
        } else if (this.mAV > 255) {
            this.mAV = 255;
        }
        if (this.mAV <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mAV <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.btW().a(this.mAO, i, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mAV / 255.0f;
        window.setAttributes(attributes);
        this.mAP.setProgress(this.mAV);
    }
}
