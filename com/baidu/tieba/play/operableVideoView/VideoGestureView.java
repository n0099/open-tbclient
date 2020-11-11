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
    private int kGx;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;
    private ViewGroup mmq;
    private ImageView mmr;
    private ProgressBar mms;
    private ViewGroup mmt;
    private ImageView mmu;
    private TextView mmv;
    private int mmw;
    private float mmx;
    private int mmy;

    public VideoGestureView(Context context) {
        super(context);
        this.kGx = 100;
        this.mmx = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kGx = 100;
        this.mmx = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kGx = 100;
        this.mmx = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mmq = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mmr = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mms = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mmt = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mmu = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mmv = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mmq.setBackgroundDrawable(ap.aO(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (this.mAudioManager != null) {
            this.kGx = this.mAudioManager.getStreamMaxVolume(3);
            this.mmw = this.mAudioManager.getStreamVolume(3);
            this.mmx = 100 / this.kGx;
        }
    }

    public void D(boolean z, String str) {
        if (this.mState != 3) {
            this.mmt.setVisibility(0);
            this.mmq.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.mmv.setText(str);
        SvgManager.brn().a(this.mmu, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void t(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mmt.setVisibility(8);
            this.mmq.setVisibility(0);
            this.mms.setMax(100);
            setBackgroundDrawable(null);
            this.mmw = this.mAudioManager.getStreamVolume(3);
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
        this.mmw = (int) (this.mProgress / this.mmx);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.brn().a(this.mmr, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mmw, 0);
        this.mms.setProgress(this.mProgress);
    }

    public void u(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mmt.setVisibility(8);
            this.mmq.setVisibility(0);
            this.mms.setMax(255);
            setBackgroundDrawable(null);
            this.mmy = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mmy += 2;
        } else {
            this.mmy -= 2;
        }
        if (this.mmy < 1) {
            this.mmy = 1;
        } else if (this.mmy > 255) {
            this.mmy = 255;
        }
        if (this.mmy <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mmy <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.brn().a(this.mmr, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mmy / 255.0f;
        window.setAttributes(attributes);
        this.mms.setProgress(this.mmy);
    }
}
