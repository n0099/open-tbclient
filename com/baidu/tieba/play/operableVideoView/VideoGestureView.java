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
    private int kUg;
    private ViewGroup mAP;
    private ImageView mAQ;
    private ProgressBar mAR;
    private ViewGroup mAS;
    private ImageView mAT;
    private TextView mAU;
    private int mAV;
    private float mAW;
    private int mAX;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.kUg = 100;
        this.mAW = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kUg = 100;
        this.mAW = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kUg = 100;
        this.mAW = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mAP = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mAQ = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mAR = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mAS = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mAT = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mAU = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mAP.setBackgroundDrawable(ap.aR(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.kUg = this.mAudioManager.getStreamMaxVolume(3);
            this.mAV = this.mAudioManager.getStreamVolume(3);
            this.mAW = 100 / this.kUg;
        }
    }

    public void E(boolean z, String str) {
        if (this.mState != 3) {
            this.mAS.setVisibility(0);
            this.mAP.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.mState = 3;
        }
        this.mAU.setText(str);
        SvgManager.btW().a(this.mAT, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void x(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mAS.setVisibility(8);
            this.mAP.setVisibility(0);
            this.mAR.setMax(100);
            setBackgroundDrawable(null);
            this.mAV = this.mAudioManager.getStreamVolume(3);
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
        this.mAV = (int) (this.mProgress / this.mAW);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.btW().a(this.mAQ, i2, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mAV, 0);
        this.mAR.setProgress(this.mProgress);
    }

    public void y(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mAS.setVisibility(8);
            this.mAP.setVisibility(0);
            this.mAR.setMax(255);
            setBackgroundDrawable(null);
            this.mAX = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mAX += 2;
        } else {
            this.mAX -= 2;
        }
        if (this.mAX < 1) {
            this.mAX = 1;
        } else if (this.mAX > 255) {
            this.mAX = 255;
        }
        if (this.mAX <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mAX <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.btW().a(this.mAQ, i, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mAX / 255.0f;
        window.setAttributes(attributes);
        this.mAR.setProgress(this.mAX);
    }
}
