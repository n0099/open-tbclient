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
/* loaded from: classes2.dex */
public class VideoGestureView extends RelativeLayout {
    private int jQi;
    private ViewGroup lvD;
    private ImageView lvE;
    private ProgressBar lvF;
    private ViewGroup lvG;
    private ImageView lvH;
    private TextView lvI;
    private int lvJ;
    private float lvK;
    private int lvL;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.jQi = 100;
        this.lvK = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQi = 100;
        this.lvK = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQi = 100;
        this.lvK = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.lvD = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.lvE = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.lvF = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.lvG = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.lvH = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.lvI = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.lvD.setBackgroundDrawable(ap.aO(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.jQi = this.mAudioManager.getStreamMaxVolume(3);
            this.lvJ = this.mAudioManager.getStreamVolume(3);
            this.lvK = 100 / this.jQi;
        }
    }

    public void B(boolean z, String str) {
        if (this.mState != 3) {
            this.lvG.setVisibility(0);
            this.lvD.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.lvI.setText(str);
        SvgManager.bjq().a(this.lvH, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void r(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.lvG.setVisibility(8);
            this.lvD.setVisibility(0);
            this.lvF.setMax(100);
            setBackgroundDrawable(null);
            this.lvJ = this.mAudioManager.getStreamVolume(3);
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
        this.lvJ = (int) (this.mProgress / this.lvK);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bjq().a(this.lvE, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.lvJ, 0);
        this.lvF.setProgress(this.mProgress);
    }

    public void s(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.lvG.setVisibility(8);
            this.lvD.setVisibility(0);
            this.lvF.setMax(255);
            setBackgroundDrawable(null);
            this.lvL = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.lvL += 2;
        } else {
            this.lvL -= 2;
        }
        if (this.lvL < 1) {
            this.lvL = 1;
        } else if (this.lvL > 255) {
            this.lvL = 255;
        }
        if (this.lvL <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.lvL <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bjq().a(this.lvE, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.lvL / 255.0f;
        window.setAttributes(attributes);
        this.lvF.setProgress(this.lvL);
    }
}
