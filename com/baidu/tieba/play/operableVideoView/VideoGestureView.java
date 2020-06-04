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
    private int jaZ;
    private ViewGroup kDL;
    private ImageView kDM;
    private ProgressBar kDN;
    private ViewGroup kDO;
    private ImageView kDP;
    private TextView kDQ;
    private int kDR;
    private float kDS;
    private int kDT;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.jaZ = 100;
        this.kDS = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jaZ = 100;
        this.kDS = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jaZ = 100;
        this.kDS = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.kDL = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.kDM = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.kDN = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.kDO = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.kDP = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.kDQ = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.kDL.setBackgroundDrawable(am.aE(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.jaZ = this.mAudioManager.getStreamMaxVolume(3);
            this.kDR = this.mAudioManager.getStreamVolume(3);
            this.kDS = 100 / this.jaZ;
        }
    }

    public void y(boolean z, String str) {
        if (this.mState != 3) {
            this.kDO.setVisibility(0);
            this.kDL.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.kDQ.setText(str);
        SvgManager.aUW().a(this.kDP, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void p(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.kDO.setVisibility(8);
            this.kDL.setVisibility(0);
            this.kDN.setMax(100);
            setBackgroundDrawable(null);
            this.kDR = this.mAudioManager.getStreamVolume(3);
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
        this.kDR = (int) (this.mProgress / this.kDS);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aUW().a(this.kDM, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.kDR, 0);
        this.kDN.setProgress(this.mProgress);
    }

    public void q(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.kDO.setVisibility(8);
            this.kDL.setVisibility(0);
            this.kDN.setMax(255);
            setBackgroundDrawable(null);
            this.kDT = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.kDT += 2;
        } else {
            this.kDT -= 2;
        }
        if (this.kDT < 1) {
            this.kDT = 1;
        } else if (this.kDT > 255) {
            this.kDT = 255;
        }
        if (this.kDT <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.kDT <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aUW().a(this.kDM, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.kDT / 255.0f;
        window.setAttributes(attributes);
        this.kDN.setProgress(this.kDT);
    }
}
