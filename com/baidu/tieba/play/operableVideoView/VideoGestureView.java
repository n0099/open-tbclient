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
    private int kog;
    private ViewGroup lTT;
    private ImageView lTU;
    private ProgressBar lTV;
    private ViewGroup lTW;
    private ImageView lTX;
    private TextView lTY;
    private int lTZ;
    private float lUa;
    private int lUb;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.kog = 100;
        this.lUa = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kog = 100;
        this.lUa = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kog = 100;
        this.lUa = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.lTT = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.lTU = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.lTV = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.lTW = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.lTX = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.lTY = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.lTT.setBackgroundDrawable(ap.aN(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (this.mAudioManager != null) {
            this.kog = this.mAudioManager.getStreamMaxVolume(3);
            this.lTZ = this.mAudioManager.getStreamVolume(3);
            this.lUa = 100 / this.kog;
        }
    }

    public void B(boolean z, String str) {
        if (this.mState != 3) {
            this.lTW.setVisibility(0);
            this.lTT.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.lTY.setText(str);
        SvgManager.bmU().a(this.lTX, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void s(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.lTW.setVisibility(8);
            this.lTT.setVisibility(0);
            this.lTV.setMax(100);
            setBackgroundDrawable(null);
            this.lTZ = this.mAudioManager.getStreamVolume(3);
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
        this.lTZ = (int) (this.mProgress / this.lUa);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bmU().a(this.lTU, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.lTZ, 0);
        this.lTV.setProgress(this.mProgress);
    }

    public void t(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.lTW.setVisibility(8);
            this.lTT.setVisibility(0);
            this.lTV.setMax(255);
            setBackgroundDrawable(null);
            this.lUb = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.lUb += 2;
        } else {
            this.lUb -= 2;
        }
        if (this.lUb < 1) {
            this.lUb = 1;
        } else if (this.lUb > 255) {
            this.lUb = 255;
        }
        if (this.lUb <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.lUb <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bmU().a(this.lTU, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.lUb / 255.0f;
        window.setAttributes(attributes);
        this.lTV.setProgress(this.lUb);
    }
}
