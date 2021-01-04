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
    private ViewGroup mGg;
    private ImageView mGh;
    private ProgressBar mGi;
    private ViewGroup mGj;
    private ImageView mGk;
    private TextView mGm;
    private int mGn;
    private float mGo;
    private int mGp;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.kZJ = 100;
        this.mGo = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kZJ = 100;
        this.mGo = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kZJ = 100;
        this.mGo = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mGg = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mGh = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mGi = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mGj = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mGk = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mGm = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mGg.setBackgroundDrawable(ao.aO(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.kZJ = this.mAudioManager.getStreamMaxVolume(3);
            this.mGn = this.mAudioManager.getStreamVolume(3);
            this.mGo = 100 / this.kZJ;
        }
    }

    public void E(boolean z, String str) {
        if (this.mState != 3) {
            this.mGj.setVisibility(0);
            this.mGg.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.mState = 3;
        }
        this.mGm.setText(str);
        SvgManager.bwq().a(this.mGk, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void u(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mGj.setVisibility(8);
            this.mGg.setVisibility(0);
            this.mGi.setMax(100);
            setBackgroundDrawable(null);
            this.mGn = this.mAudioManager.getStreamVolume(3);
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
        this.mGn = (int) (this.mProgress / this.mGo);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bwq().a(this.mGh, i2, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mGn, 0);
        this.mGi.setProgress(this.mProgress);
    }

    public void v(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mGj.setVisibility(8);
            this.mGg.setVisibility(0);
            this.mGi.setMax(255);
            setBackgroundDrawable(null);
            this.mGp = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mGp += 2;
        } else {
            this.mGp -= 2;
        }
        if (this.mGp < 1) {
            this.mGp = 1;
        } else if (this.mGp > 255) {
            this.mGp = 255;
        }
        if (this.mGp <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mGp <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bwq().a(this.mGh, i, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mGp / 255.0f;
        window.setAttributes(attributes);
        this.mGi.setProgress(this.mGp);
    }
}
