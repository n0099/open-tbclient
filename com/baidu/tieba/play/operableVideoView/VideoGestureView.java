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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes.dex */
public class VideoGestureView extends RelativeLayout {
    private int kAD;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;
    private int mgA;
    private ViewGroup mgs;
    private ImageView mgt;
    private ProgressBar mgu;
    private ViewGroup mgv;
    private ImageView mgw;
    private TextView mgx;
    private int mgy;
    private float mgz;

    public VideoGestureView(Context context) {
        super(context);
        this.kAD = 100;
        this.mgz = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kAD = 100;
        this.mgz = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kAD = 100;
        this.mgz = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mgs = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mgt = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mgu = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mgv = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mgw = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mgx = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mgs.setBackgroundDrawable(ap.aO(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (this.mAudioManager != null) {
            this.kAD = this.mAudioManager.getStreamMaxVolume(3);
            this.mgy = this.mAudioManager.getStreamVolume(3);
            this.mgz = 100 / this.kAD;
        }
    }

    public void D(boolean z, String str) {
        if (this.mState != 3) {
            this.mgv.setVisibility(0);
            this.mgs.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.mgx.setText(str);
        SvgManager.boN().a(this.mgw, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void s(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mgv.setVisibility(8);
            this.mgs.setVisibility(0);
            this.mgu.setMax(100);
            setBackgroundDrawable(null);
            this.mgy = this.mAudioManager.getStreamVolume(3);
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
        this.mgy = (int) (this.mProgress / this.mgz);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.boN().a(this.mgt, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mgy, 0);
        this.mgu.setProgress(this.mProgress);
    }

    public void t(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mgv.setVisibility(8);
            this.mgs.setVisibility(0);
            this.mgu.setMax(255);
            setBackgroundDrawable(null);
            this.mgA = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mgA += 2;
        } else {
            this.mgA -= 2;
        }
        if (this.mgA < 1) {
            this.mgA = 1;
        } else if (this.mgA > 255) {
            this.mgA = 255;
        }
        if (this.mgA <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mgA <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.boN().a(this.mgt, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mgA / 255.0f;
        window.setAttributes(attributes);
        this.mgu.setProgress(this.mgA);
    }
}
