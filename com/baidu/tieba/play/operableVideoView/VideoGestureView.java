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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoGestureView extends RelativeLayout {
    private int kVe;
    private AudioManager mAudioManager;
    private ViewGroup mBA;
    private ImageView mBB;
    private TextView mBC;
    private int mBD;
    private float mBE;
    private int mBF;
    private ViewGroup mBx;
    private ImageView mBy;
    private ProgressBar mBz;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.kVe = 100;
        this.mBE = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kVe = 100;
        this.mBE = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kVe = 100;
        this.mBE = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mBx = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mBy = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mBz = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mBA = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mBB = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mBC = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mBx.setBackgroundDrawable(ao.aO(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.kVe = this.mAudioManager.getStreamMaxVolume(3);
            this.mBD = this.mAudioManager.getStreamVolume(3);
            this.mBE = 100 / this.kVe;
        }
    }

    public void E(boolean z, String str) {
        if (this.mState != 3) {
            this.mBA.setVisibility(0);
            this.mBx.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.mState = 3;
        }
        this.mBC.setText(str);
        SvgManager.bsx().a(this.mBB, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void u(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mBA.setVisibility(8);
            this.mBx.setVisibility(0);
            this.mBz.setMax(100);
            setBackgroundDrawable(null);
            this.mBD = this.mAudioManager.getStreamVolume(3);
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
        this.mBD = (int) (this.mProgress / this.mBE);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bsx().a(this.mBy, i2, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mBD, 0);
        this.mBz.setProgress(this.mProgress);
    }

    public void v(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mBA.setVisibility(8);
            this.mBx.setVisibility(0);
            this.mBz.setMax(255);
            setBackgroundDrawable(null);
            this.mBF = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mBF += 2;
        } else {
            this.mBF -= 2;
        }
        if (this.mBF < 1) {
            this.mBF = 1;
        } else if (this.mBF > 255) {
            this.mBF = 255;
        }
        if (this.mBF <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mBF <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bsx().a(this.mBy, i, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mBF / 255.0f;
        window.setAttributes(attributes);
        this.mBz.setProgress(this.mBF);
    }
}
