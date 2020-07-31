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
    private int jAM;
    private ViewGroup lfi;
    private ImageView lfj;
    private ProgressBar lfk;
    private ViewGroup lfl;
    private ImageView lfm;
    private TextView lfn;
    private int lfo;
    private float lfp;
    private int lfq;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.jAM = 100;
        this.lfp = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jAM = 100;
        this.lfp = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jAM = 100;
        this.lfp = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.lfi = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.lfj = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.lfk = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.lfl = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.lfm = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.lfn = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.lfi.setBackgroundDrawable(ao.aH(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.jAM = this.mAudioManager.getStreamMaxVolume(3);
            this.lfo = this.mAudioManager.getStreamVolume(3);
            this.lfp = 100 / this.jAM;
        }
    }

    public void A(boolean z, String str) {
        if (this.mState != 3) {
            this.lfl.setVisibility(0);
            this.lfi.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.lfn.setText(str);
        SvgManager.baR().a(this.lfm, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void q(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.lfl.setVisibility(8);
            this.lfi.setVisibility(0);
            this.lfk.setMax(100);
            setBackgroundDrawable(null);
            this.lfo = this.mAudioManager.getStreamVolume(3);
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
        this.lfo = (int) (this.mProgress / this.lfp);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.baR().a(this.lfj, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.lfo, 0);
        this.lfk.setProgress(this.mProgress);
    }

    public void r(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.lfl.setVisibility(8);
            this.lfi.setVisibility(0);
            this.lfk.setMax(255);
            setBackgroundDrawable(null);
            this.lfq = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.lfq += 2;
        } else {
            this.lfq -= 2;
        }
        if (this.lfq < 1) {
            this.lfq = 1;
        } else if (this.lfq > 255) {
            this.lfq = 255;
        }
        if (this.lfq <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.lfq <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.baR().a(this.lfj, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.lfq / 255.0f;
        window.setAttributes(attributes);
        this.lfk.setProgress(this.lfq);
    }
}
