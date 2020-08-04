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
    private int jAO;
    private ViewGroup lfk;
    private ImageView lfl;
    private ProgressBar lfm;
    private ViewGroup lfn;
    private ImageView lfo;
    private TextView lfp;
    private int lfq;
    private float lfr;
    private int lfs;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.jAO = 100;
        this.lfr = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jAO = 100;
        this.lfr = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jAO = 100;
        this.lfr = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.lfk = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.lfl = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.lfm = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.lfn = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.lfo = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.lfp = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.lfk.setBackgroundDrawable(ao.aH(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.jAO = this.mAudioManager.getStreamMaxVolume(3);
            this.lfq = this.mAudioManager.getStreamVolume(3);
            this.lfr = 100 / this.jAO;
        }
    }

    public void A(boolean z, String str) {
        if (this.mState != 3) {
            this.lfn.setVisibility(0);
            this.lfk.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.lfp.setText(str);
        SvgManager.baR().a(this.lfo, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void q(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.lfn.setVisibility(8);
            this.lfk.setVisibility(0);
            this.lfm.setMax(100);
            setBackgroundDrawable(null);
            this.lfq = this.mAudioManager.getStreamVolume(3);
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
        this.lfq = (int) (this.mProgress / this.lfr);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.baR().a(this.lfl, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.lfq, 0);
        this.lfm.setProgress(this.mProgress);
    }

    public void r(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.lfn.setVisibility(8);
            this.lfk.setVisibility(0);
            this.lfm.setMax(255);
            setBackgroundDrawable(null);
            this.lfs = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.lfs += 2;
        } else {
            this.lfs -= 2;
        }
        if (this.lfs < 1) {
            this.lfs = 1;
        } else if (this.lfs > 255) {
            this.lfs = 255;
        }
        if (this.lfs <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.lfs <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.baR().a(this.lfl, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.lfs / 255.0f;
        window.setAttributes(attributes);
        this.lfm.setProgress(this.lfs);
    }
}
