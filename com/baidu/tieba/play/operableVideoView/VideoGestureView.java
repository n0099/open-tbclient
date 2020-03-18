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
    private int ibo;
    private ImageView jAA;
    private ProgressBar jAB;
    private ViewGroup jAC;
    private ImageView jAD;
    private TextView jAE;
    private int jAF;
    private float jAG;
    private int jAH;
    private ViewGroup jAz;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.ibo = 100;
        this.jAG = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ibo = 100;
        this.jAG = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ibo = 100;
        this.jAG = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.jAz = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.jAA = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.jAB = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.jAC = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.jAD = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.jAE = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.jAz.setBackgroundDrawable(am.ay(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.ibo = this.mAudioManager.getStreamMaxVolume(3);
            this.jAF = this.mAudioManager.getStreamVolume(3);
            this.jAG = 100 / this.ibo;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.jAC.setVisibility(0);
            this.jAz.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.jAE.setText(str);
        SvgManager.aGG().a(this.jAD, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void k(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.jAC.setVisibility(8);
            this.jAz.setVisibility(0);
            this.jAB.setMax(100);
            setBackgroundDrawable(null);
            this.jAF = this.mAudioManager.getStreamVolume(3);
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
        this.jAF = (int) (this.mProgress / this.jAG);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aGG().a(this.jAA, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.jAF, 0);
        this.jAB.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.jAC.setVisibility(8);
            this.jAz.setVisibility(0);
            this.jAB.setMax(255);
            setBackgroundDrawable(null);
            this.jAH = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.jAH += 2;
        } else {
            this.jAH -= 2;
        }
        if (this.jAH < 1) {
            this.jAH = 1;
        } else if (this.jAH > 255) {
            this.jAH = 255;
        }
        if (this.jAH <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.jAH <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aGG().a(this.jAA, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.jAH / 255.0f;
        window.setAttributes(attributes);
        this.jAB.setProgress(this.jAH);
    }
}
