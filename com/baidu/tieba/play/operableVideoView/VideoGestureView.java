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
    private int ldi;
    private AudioManager mAudioManager;
    private ViewGroup mKG;
    private ImageView mKH;
    private ProgressBar mKI;
    private ViewGroup mKJ;
    private ImageView mKK;
    private TextView mKL;
    private int mKM;
    private float mKN;
    private int mKO;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.ldi = 100;
        this.mKN = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ldi = 100;
        this.mKN = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ldi = 100;
        this.mKN = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mKG = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mKH = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mKI = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mKJ = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mKK = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mKL = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mKG.setBackgroundDrawable(ap.aL(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.ldi = this.mAudioManager.getStreamMaxVolume(3);
            this.mKM = this.mAudioManager.getStreamVolume(3);
            this.mKN = 100 / this.ldi;
        }
    }

    public void L(boolean z, String str) {
        if (this.mState != 3) {
            this.mKJ.setVisibility(0);
            this.mKG.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.mState = 3;
        }
        this.mKL.setText(str);
        SvgManager.bsR().a(this.mKK, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void u(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mKJ.setVisibility(8);
            this.mKG.setVisibility(0);
            this.mKI.setMax(100);
            setBackgroundDrawable(null);
            this.mKM = this.mAudioManager.getStreamVolume(3);
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
        this.mKM = (int) (this.mProgress / this.mKN);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bsR().a(this.mKH, i2, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mKM, 0);
        this.mKI.setProgress(this.mProgress);
    }

    public void v(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mKJ.setVisibility(8);
            this.mKG.setVisibility(0);
            this.mKI.setMax(255);
            setBackgroundDrawable(null);
            this.mKO = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mKO += 2;
        } else {
            this.mKO -= 2;
        }
        if (this.mKO < 1) {
            this.mKO = 1;
        } else if (this.mKO > 255) {
            this.mKO = 255;
        }
        if (this.mKO <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mKO <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bsR().a(this.mKH, i, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mKO / 255.0f;
        window.setAttributes(attributes);
        this.mKI.setProgress(this.mKO);
    }
}
