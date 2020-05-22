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
    private int jam;
    private ViewGroup kCD;
    private ImageView kCE;
    private ProgressBar kCF;
    private ViewGroup kCG;
    private ImageView kCH;
    private TextView kCI;
    private int kCJ;
    private float kCK;
    private int kCL;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.jam = 100;
        this.kCK = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jam = 100;
        this.kCK = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jam = 100;
        this.kCK = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.kCD = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.kCE = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.kCF = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.kCG = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.kCH = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.kCI = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.kCD.setBackgroundDrawable(am.aE(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.jam = this.mAudioManager.getStreamMaxVolume(3);
            this.kCJ = this.mAudioManager.getStreamVolume(3);
            this.kCK = 100 / this.jam;
        }
    }

    public void y(boolean z, String str) {
        if (this.mState != 3) {
            this.kCG.setVisibility(0);
            this.kCD.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.kCI.setText(str);
        SvgManager.aUV().a(this.kCH, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void p(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.kCG.setVisibility(8);
            this.kCD.setVisibility(0);
            this.kCF.setMax(100);
            setBackgroundDrawable(null);
            this.kCJ = this.mAudioManager.getStreamVolume(3);
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
        this.kCJ = (int) (this.mProgress / this.kCK);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aUV().a(this.kCE, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.kCJ, 0);
        this.kCF.setProgress(this.mProgress);
    }

    public void q(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.kCG.setVisibility(8);
            this.kCD.setVisibility(0);
            this.kCF.setMax(255);
            setBackgroundDrawable(null);
            this.kCL = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.kCL += 2;
        } else {
            this.kCL -= 2;
        }
        if (this.kCL < 1) {
            this.kCL = 1;
        } else if (this.kCL > 255) {
            this.kCL = 255;
        }
        if (this.kCL <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.kCL <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aUV().a(this.kCE, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.kCL / 255.0f;
        window.setAttributes(attributes);
        this.kCF.setProgress(this.kCL);
    }
}
