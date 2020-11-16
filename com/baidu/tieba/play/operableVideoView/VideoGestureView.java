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
    private int kGM;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;
    private ViewGroup mmK;
    private ImageView mmL;
    private ProgressBar mmM;
    private ViewGroup mmN;
    private ImageView mmO;
    private TextView mmP;
    private int mmQ;
    private float mmR;
    private int mmS;

    public VideoGestureView(Context context) {
        super(context);
        this.kGM = 100;
        this.mmR = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kGM = 100;
        this.mmR = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kGM = 100;
        this.mmR = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.mmK = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.mmL = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.mmM = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.mmN = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.mmO = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.mmP = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.mmK.setBackgroundDrawable(ap.aP(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.CAM_X0605)));
        this.mAudioManager = (AudioManager) getContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        if (this.mAudioManager != null) {
            this.kGM = this.mAudioManager.getStreamMaxVolume(3);
            this.mmQ = this.mAudioManager.getStreamVolume(3);
            this.mmR = 100 / this.kGM;
        }
    }

    public void E(boolean z, String str) {
        if (this.mState != 3) {
            this.mmN.setVisibility(0);
            this.mmK.setVisibility(8);
            setBackgroundResource(R.color.CAM_X0605);
            this.mState = 3;
        }
        this.mmP.setText(str);
        SvgManager.bqB().a(this.mmO, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
    }

    public void s(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.mmN.setVisibility(8);
            this.mmK.setVisibility(0);
            this.mmM.setMax(100);
            setBackgroundDrawable(null);
            this.mmQ = this.mAudioManager.getStreamVolume(3);
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
        this.mmQ = (int) (this.mProgress / this.mmR);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bqB().a(this.mmL, i2, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.mmQ, 0);
        this.mmM.setProgress(this.mProgress);
    }

    public void t(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.mmN.setVisibility(8);
            this.mmK.setVisibility(0);
            this.mmM.setMax(255);
            setBackgroundDrawable(null);
            this.mmS = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.mmS += 2;
        } else {
            this.mmS -= 2;
        }
        if (this.mmS < 1) {
            this.mmS = 1;
        } else if (this.mmS > 255) {
            this.mmS = 255;
        }
        if (this.mmS <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.mmS <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bqB().a(this.mmL, i, R.color.CAM_X0622, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.mmS / 255.0f;
        window.setAttributes(attributes);
        this.mmM.setProgress(this.mmS);
    }
}
