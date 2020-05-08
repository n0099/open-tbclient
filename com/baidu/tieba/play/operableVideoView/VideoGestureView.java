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
    private int iLm;
    private ViewGroup kkI;
    private ImageView kkJ;
    private ProgressBar kkK;
    private ViewGroup kkL;
    private ImageView kkM;
    private TextView kkN;
    private int kkO;
    private float kkP;
    private int kkQ;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.iLm = 100;
        this.kkP = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLm = 100;
        this.kkP = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLm = 100;
        this.kkP = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.kkI = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.kkJ = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.kkK = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.kkL = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.kkM = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.kkN = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.kkI.setBackgroundDrawable(am.aB(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.iLm = this.mAudioManager.getStreamMaxVolume(3);
            this.kkO = this.mAudioManager.getStreamVolume(3);
            this.kkP = 100 / this.iLm;
        }
    }

    public void y(boolean z, String str) {
        if (this.mState != 3) {
            this.kkL.setVisibility(0);
            this.kkI.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.kkN.setText(str);
        SvgManager.aOR().a(this.kkM, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void k(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.kkL.setVisibility(8);
            this.kkI.setVisibility(0);
            this.kkK.setMax(100);
            setBackgroundDrawable(null);
            this.kkO = this.mAudioManager.getStreamVolume(3);
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
        this.kkO = (int) (this.mProgress / this.kkP);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aOR().a(this.kkJ, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.kkO, 0);
        this.kkK.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.kkL.setVisibility(8);
            this.kkI.setVisibility(0);
            this.kkK.setMax(255);
            setBackgroundDrawable(null);
            this.kkQ = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.kkQ += 2;
        } else {
            this.kkQ -= 2;
        }
        if (this.kkQ < 1) {
            this.kkQ = 1;
        } else if (this.kkQ > 255) {
            this.kkQ = 255;
        }
        if (this.kkQ <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.kkQ <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aOR().a(this.kkJ, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.kkQ / 255.0f;
        window.setAttributes(attributes);
        this.kkK.setProgress(this.kkQ);
    }
}
