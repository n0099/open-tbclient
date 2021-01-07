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
    private int kZJ;
    private AudioManager mAudioManager;
    private ViewGroup mGf;
    private ImageView mGg;
    private ProgressBar mGh;
    private ViewGroup mGi;
    private ImageView mGj;
    private TextView mGk;
    private int mGm;
    private float mGn;
    private int mGo;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.kZJ = 100;
        this.mGn = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kZJ = 100;
        this.mGn = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kZJ = 100;
        this.mGn = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mGf = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mGg = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mGh = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mGi = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mGj = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mGk = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mGf.setBackgroundDrawable(ao.aO(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.kZJ = this.mAudioManager.getStreamMaxVolume(3);
            this.mGm = this.mAudioManager.getStreamVolume(3);
            this.mGn = 100 / this.kZJ;
        }
    }

    public void E(boolean z, String str) {
        if (this.mState != 3) {
            this.mGi.setVisibility(0);
            this.mGf.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.mState = 3;
        }
        this.mGk.setText(str);
        SvgManager.bwr().a(this.mGj, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void u(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mGi.setVisibility(8);
            this.mGf.setVisibility(0);
            this.mGh.setMax(100);
            setBackgroundDrawable(null);
            this.mGm = this.mAudioManager.getStreamVolume(3);
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
        this.mGm = (int) (this.mProgress / this.mGn);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bwr().a(this.mGg, i2, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mGm, 0);
        this.mGh.setProgress(this.mProgress);
    }

    public void v(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mGi.setVisibility(8);
            this.mGf.setVisibility(0);
            this.mGh.setMax(255);
            setBackgroundDrawable(null);
            this.mGo = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mGo += 2;
        } else {
            this.mGo -= 2;
        }
        if (this.mGo < 1) {
            this.mGo = 1;
        } else if (this.mGo > 255) {
            this.mGo = 255;
        }
        if (this.mGo <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mGo <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bwr().a(this.mGg, i, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mGo / 255.0f;
        window.setAttributes(attributes);
        this.mGh.setProgress(this.mGo);
    }
}
