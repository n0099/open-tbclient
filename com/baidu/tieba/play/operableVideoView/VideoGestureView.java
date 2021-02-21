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
    private int ldw;
    private AudioManager mAudioManager;
    private ViewGroup mKV;
    private ImageView mKW;
    private ProgressBar mKX;
    private ViewGroup mKY;
    private ImageView mKZ;
    private TextView mLa;
    private int mLb;
    private float mLc;
    private int mLd;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.ldw = 100;
        this.mLc = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ldw = 100;
        this.mLc = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ldw = 100;
        this.mLc = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mKV = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mKW = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mKX = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mKY = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mKZ = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mLa = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mKV.setBackgroundDrawable(ap.aL(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.ldw = this.mAudioManager.getStreamMaxVolume(3);
            this.mLb = this.mAudioManager.getStreamVolume(3);
            this.mLc = 100 / this.ldw;
        }
    }

    public void L(boolean z, String str) {
        if (this.mState != 3) {
            this.mKY.setVisibility(0);
            this.mKV.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.mState = 3;
        }
        this.mLa.setText(str);
        SvgManager.bsR().a(this.mKZ, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void u(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mKY.setVisibility(8);
            this.mKV.setVisibility(0);
            this.mKX.setMax(100);
            setBackgroundDrawable(null);
            this.mLb = this.mAudioManager.getStreamVolume(3);
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
        this.mLb = (int) (this.mProgress / this.mLc);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bsR().a(this.mKW, i2, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mLb, 0);
        this.mKX.setProgress(this.mProgress);
    }

    public void v(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mKY.setVisibility(8);
            this.mKV.setVisibility(0);
            this.mKX.setMax(255);
            setBackgroundDrawable(null);
            this.mLd = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mLd += 2;
        } else {
            this.mLd -= 2;
        }
        if (this.mLd < 1) {
            this.mLd = 1;
        } else if (this.mLd > 255) {
            this.mLd = 255;
        }
        if (this.mLd <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mLd <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bsR().a(this.mKW, i, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mLd / 255.0f;
        window.setAttributes(attributes);
        this.mKX.setProgress(this.mLd);
    }
}
