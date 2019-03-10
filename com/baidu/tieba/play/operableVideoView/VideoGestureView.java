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
import com.baidu.tieba.d;
import com.baidu.tieba.view.SwitchImageView;
/* loaded from: classes.dex */
public class VideoGestureView extends RelativeLayout {
    private int gIy;
    private SwitchImageView iaA;
    private TextView iaB;
    private SeekBar iaC;
    private int iaD;
    private float iaE;
    private int iaF;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.gIy = 100;
        this.iaE = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIy = 100;
        this.iaE = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIy = 100;
        this.iaE = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), d.h.operable_video_gesture, this);
        this.iaA = (SwitchImageView) findViewById(d.g.gesture_icon);
        this.iaB = (TextView) findViewById(d.g.gesture_txt);
        this.iaC = (SeekBar) findViewById(d.g.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.gIy = this.mAudioManager.getStreamMaxVolume(3);
            this.iaD = this.mAudioManager.getStreamVolume(3);
            this.iaE = 100 / this.gIy;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.iaA.setStateImage(d.f.icon_vedio_fast_forward, d.f.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.iaA.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds52);
            this.iaA.setVisibility(0);
            this.iaB.setVisibility(0);
            this.iaC.setVisibility(8);
            this.mState = 3;
        }
        this.iaB.setText(str);
        this.iaA.setState(z ? 1 : 0);
    }

    public void m(Context context, boolean z) {
        if (this.mState != 1) {
            this.iaA.setStateImage(d.f.icon_vedio_volume_white, d.f.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.iaA.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds55);
            this.iaC.setMax(100);
            this.iaA.setVisibility(0);
            this.iaB.setVisibility(8);
            this.iaC.setVisibility(0);
            this.iaD = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.iaE == 0.0f) {
            if (z && this.iaD < this.gIy) {
                this.iaD++;
            }
            if (!z && this.iaD > 0) {
                this.iaD--;
            }
        }
        if (this.iaD <= 0) {
            this.iaA.setState(1);
        } else {
            this.iaA.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.iaD, 0);
        this.iaC.setProgress(this.mProgress);
    }

    public void n(Context context, boolean z) {
        if (this.mState != 2) {
            this.iaA.setStateImage(d.f.icon_video_light_white, d.f.icon_video_light_white);
            this.iaA.setState(0);
            ((RelativeLayout.LayoutParams) this.iaA.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds32);
            this.iaC.setMax(255);
            this.iaA.setVisibility(0);
            this.iaB.setVisibility(8);
            this.iaC.setVisibility(0);
            this.iaF = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.iaF++;
        } else {
            this.iaF--;
        }
        if (this.iaF < 0) {
            this.iaF = 0;
        } else if (this.iaF > 255) {
            this.iaF = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.iaF / 255.0f;
        window.setAttributes(attributes);
        this.iaC.setProgress(this.iaF);
    }
}
