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
    private int iLi;
    private ViewGroup kkE;
    private ImageView kkF;
    private ProgressBar kkG;
    private ViewGroup kkH;
    private ImageView kkI;
    private TextView kkJ;
    private int kkK;
    private float kkL;
    private int kkM;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.iLi = 100;
        this.kkL = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLi = 100;
        this.kkL = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLi = 100;
        this.kkL = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.kkE = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.kkF = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.kkG = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.kkH = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.kkI = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.kkJ = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.kkE.setBackgroundDrawable(am.aB(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.iLi = this.mAudioManager.getStreamMaxVolume(3);
            this.kkK = this.mAudioManager.getStreamVolume(3);
            this.kkL = 100 / this.iLi;
        }
    }

    public void y(boolean z, String str) {
        if (this.mState != 3) {
            this.kkH.setVisibility(0);
            this.kkE.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.kkJ.setText(str);
        SvgManager.aOU().a(this.kkI, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void k(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.kkH.setVisibility(8);
            this.kkE.setVisibility(0);
            this.kkG.setMax(100);
            setBackgroundDrawable(null);
            this.kkK = this.mAudioManager.getStreamVolume(3);
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
        this.kkK = (int) (this.mProgress / this.kkL);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.aOU().a(this.kkF, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.kkK, 0);
        this.kkG.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.kkH.setVisibility(8);
            this.kkE.setVisibility(0);
            this.kkG.setMax(255);
            setBackgroundDrawable(null);
            this.kkM = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.kkM += 2;
        } else {
            this.kkM -= 2;
        }
        if (this.kkM < 1) {
            this.kkM = 1;
        } else if (this.kkM > 255) {
            this.kkM = 255;
        }
        if (this.kkM <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.kkM <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.aOU().a(this.kkF, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.kkM / 255.0f;
        window.setAttributes(attributes);
        this.kkG.setProgress(this.kkM);
    }
}
