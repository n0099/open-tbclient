package com.baidu.tieba.play.operableVideoView;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.SwitchImageView;
/* loaded from: classes.dex */
public class VideoGestureView extends RelativeLayout {
    private int hgM;
    private SwitchImageView iBa;
    private TextView iBb;
    private SeekBar iBc;
    private int iBd;
    private float iBe;
    private int iBf;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hgM = 100;
        this.iBe = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hgM = 100;
        this.iBe = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hgM = 100;
        this.iBe = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.iBa = (SwitchImageView) findViewById(R.id.gesture_icon);
        this.iBb = (TextView) findViewById(R.id.gesture_txt);
        this.iBc = (SeekBar) findViewById(R.id.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hgM = this.mAudioManager.getStreamMaxVolume(3);
            this.iBd = this.mAudioManager.getStreamVolume(3);
            this.iBe = 100 / this.hgM;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.iBa.setStateImage(R.drawable.icon_vedio_fast_forward, R.drawable.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.iBa.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds52);
            this.iBa.setVisibility(0);
            this.iBb.setVisibility(0);
            this.iBc.setVisibility(8);
            this.mState = 3;
        }
        this.iBb.setText(str);
        this.iBa.setState(z ? 1 : 0);
    }

    public void k(Context context, boolean z) {
        if (this.mState != 1) {
            this.iBa.setStateImage(R.drawable.icon_vedio_volume_white, R.drawable.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.iBa.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds55);
            this.iBc.setMax(100);
            this.iBa.setVisibility(0);
            this.iBb.setVisibility(8);
            this.iBc.setVisibility(0);
            this.iBd = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.iBe == 0.0f) {
            if (z && this.iBd < this.hgM) {
                this.iBd++;
            }
            if (!z && this.iBd > 0) {
                this.iBd--;
            }
        }
        if (this.iBd <= 0) {
            this.iBa.setState(1);
        } else {
            this.iBa.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.iBd, 0);
        this.iBc.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        if (this.mState != 2) {
            this.iBa.setStateImage(R.drawable.icon_video_light_white, R.drawable.icon_video_light_white);
            this.iBa.setState(0);
            ((RelativeLayout.LayoutParams) this.iBa.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds32);
            this.iBc.setMax(255);
            this.iBa.setVisibility(0);
            this.iBb.setVisibility(8);
            this.iBc.setVisibility(0);
            this.iBf = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.iBf++;
        } else {
            this.iBf--;
        }
        if (this.iBf < 0) {
            this.iBf = 0;
        } else if (this.iBf > 255) {
            this.iBf = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.iBf / 255.0f;
        window.setAttributes(attributes);
        this.iBc.setProgress(this.iBf);
    }
}
