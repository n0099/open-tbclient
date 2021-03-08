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
    private int lfz;
    private AudioManager mAudioManager;
    private ViewGroup mMX;
    private ImageView mMY;
    private ProgressBar mMZ;
    private ViewGroup mNa;
    private ImageView mNb;
    private TextView mNc;
    private int mNd;
    private float mNe;
    private int mNf;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.lfz = 100;
        this.mNe = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lfz = 100;
        this.mNe = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lfz = 100;
        this.mNe = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mMX = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mMY = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mMZ = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mNa = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mNb = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mNc = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mMX.setBackgroundDrawable(ap.aL(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.lfz = this.mAudioManager.getStreamMaxVolume(3);
            this.mNd = this.mAudioManager.getStreamVolume(3);
            this.mNe = 100 / this.lfz;
        }
    }

    public void L(boolean z, String str) {
        if (this.mState != 3) {
            this.mNa.setVisibility(0);
            this.mMX.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.mState = 3;
        }
        this.mNc.setText(str);
        SvgManager.bsU().a(this.mNb, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void u(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mNa.setVisibility(8);
            this.mMX.setVisibility(0);
            this.mMZ.setMax(100);
            setBackgroundDrawable(null);
            this.mNd = this.mAudioManager.getStreamVolume(3);
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
        this.mNd = (int) (this.mProgress / this.mNe);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bsU().a(this.mMY, i2, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mNd, 0);
        this.mMZ.setProgress(this.mProgress);
    }

    public void v(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mNa.setVisibility(8);
            this.mMX.setVisibility(0);
            this.mMZ.setMax(255);
            setBackgroundDrawable(null);
            this.mNf = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mNf += 2;
        } else {
            this.mNf -= 2;
        }
        if (this.mNf < 1) {
            this.mNf = 1;
        } else if (this.mNf > 255) {
            this.mNf = 255;
        }
        if (this.mNf <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mNf <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bsU().a(this.mMY, i, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mNf / 255.0f;
        window.setAttributes(attributes);
        this.mMZ.setProgress(this.mNf);
    }
}
