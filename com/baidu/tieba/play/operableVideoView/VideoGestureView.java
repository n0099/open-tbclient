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
    private int jYR;
    private ViewGroup lEF;
    private ImageView lEG;
    private ProgressBar lEH;
    private ViewGroup lEI;
    private ImageView lEJ;
    private TextView lEK;
    private int lEL;
    private float lEM;
    private int lEN;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.jYR = 100;
        this.lEM = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jYR = 100;
        this.lEM = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jYR = 100;
        this.lEM = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.lEF = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.lEG = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.lEH = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.lEI = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.lEJ = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.lEK = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.lEF.setBackgroundDrawable(ap.aO(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.jYR = this.mAudioManager.getStreamMaxVolume(3);
            this.lEL = this.mAudioManager.getStreamVolume(3);
            this.lEM = 100 / this.jYR;
        }
    }

    public void B(boolean z, String str) {
        if (this.mState != 3) {
            this.lEI.setVisibility(0);
            this.lEF.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.lEK.setText(str);
        SvgManager.bkl().a(this.lEJ, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void s(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.lEI.setVisibility(8);
            this.lEF.setVisibility(0);
            this.lEH.setMax(100);
            setBackgroundDrawable(null);
            this.lEL = this.mAudioManager.getStreamVolume(3);
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
        this.lEL = (int) (this.mProgress / this.lEM);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bkl().a(this.lEG, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.lEL, 0);
        this.lEH.setProgress(this.mProgress);
    }

    public void t(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.lEI.setVisibility(8);
            this.lEF.setVisibility(0);
            this.lEH.setMax(255);
            setBackgroundDrawable(null);
            this.lEN = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.lEN += 2;
        } else {
            this.lEN -= 2;
        }
        if (this.lEN < 1) {
            this.lEN = 1;
        } else if (this.lEN > 255) {
            this.lEN = 255;
        }
        if (this.lEN <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.lEN <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bkl().a(this.lEG, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.lEN / 255.0f;
        window.setAttributes(attributes);
        this.lEH.setProgress(this.lEN);
    }
}
