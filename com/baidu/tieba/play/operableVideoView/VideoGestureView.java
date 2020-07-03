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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoGestureView extends RelativeLayout {
    private int jsj;
    private ViewGroup kXH;
    private ImageView kXI;
    private ProgressBar kXJ;
    private ViewGroup kXK;
    private ImageView kXL;
    private TextView kXM;
    private int kXN;
    private float kXO;
    private int kXP;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.jsj = 100;
        this.kXO = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jsj = 100;
        this.kXO = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jsj = 100;
        this.kXO = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.kXH = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.kXI = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.kXJ = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.kXK = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.kXL = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.kXM = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.kXH.setBackgroundDrawable(an.aG(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.jsj = this.mAudioManager.getStreamMaxVolume(3);
            this.kXN = this.mAudioManager.getStreamVolume(3);
            this.kXO = 100 / this.jsj;
        }
    }

    public void A(boolean z, String str) {
        if (this.mState != 3) {
            this.kXK.setVisibility(0);
            this.kXH.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.kXM.setText(str);
        SvgManager.aWQ().a(this.kXL, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void p(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.kXK.setVisibility(8);
            this.kXH.setVisibility(0);
            this.kXJ.setMax(100);
            setBackgroundDrawable(null);
            this.kXN = this.mAudioManager.getStreamVolume(3);
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
        this.kXN = (int) (this.mProgress / this.kXO);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aWQ().a(this.kXI, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.kXN, 0);
        this.kXJ.setProgress(this.mProgress);
    }

    public void q(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.kXK.setVisibility(8);
            this.kXH.setVisibility(0);
            this.kXJ.setMax(255);
            setBackgroundDrawable(null);
            this.kXP = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.kXP += 2;
        } else {
            this.kXP -= 2;
        }
        if (this.kXP < 1) {
            this.kXP = 1;
        } else if (this.kXP > 255) {
            this.kXP = 255;
        }
        if (this.kXP <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.kXP <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aWQ().a(this.kXI, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.kXP / 255.0f;
        window.setAttributes(attributes);
        this.kXJ.setProgress(this.kXP);
    }
}
