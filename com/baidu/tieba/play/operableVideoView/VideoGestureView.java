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
    private int gIl;
    private SwitchImageView iah;
    private TextView iai;
    private SeekBar iaj;
    private int iak;
    private float ial;
    private int iam;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.gIl = 100;
        this.ial = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIl = 100;
        this.ial = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIl = 100;
        this.ial = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), d.h.operable_video_gesture, this);
        this.iah = (SwitchImageView) findViewById(d.g.gesture_icon);
        this.iai = (TextView) findViewById(d.g.gesture_txt);
        this.iaj = (SeekBar) findViewById(d.g.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.gIl = this.mAudioManager.getStreamMaxVolume(3);
            this.iak = this.mAudioManager.getStreamVolume(3);
            this.ial = 100 / this.gIl;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.iah.setStateImage(d.f.icon_vedio_fast_forward, d.f.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.iah.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds52);
            this.iah.setVisibility(0);
            this.iai.setVisibility(0);
            this.iaj.setVisibility(8);
            this.mState = 3;
        }
        this.iai.setText(str);
        this.iah.setState(z ? 1 : 0);
    }

    public void m(Context context, boolean z) {
        if (this.mState != 1) {
            this.iah.setStateImage(d.f.icon_vedio_volume_white, d.f.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.iah.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds55);
            this.iaj.setMax(100);
            this.iah.setVisibility(0);
            this.iai.setVisibility(8);
            this.iaj.setVisibility(0);
            this.iak = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.ial == 0.0f) {
            if (z && this.iak < this.gIl) {
                this.iak++;
            }
            if (!z && this.iak > 0) {
                this.iak--;
            }
        }
        if (this.iak <= 0) {
            this.iah.setState(1);
        } else {
            this.iah.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.iak, 0);
        this.iaj.setProgress(this.mProgress);
    }

    public void n(Context context, boolean z) {
        if (this.mState != 2) {
            this.iah.setStateImage(d.f.icon_video_light_white, d.f.icon_video_light_white);
            this.iah.setState(0);
            ((RelativeLayout.LayoutParams) this.iah.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds32);
            this.iaj.setMax(255);
            this.iah.setVisibility(0);
            this.iai.setVisibility(8);
            this.iaj.setVisibility(0);
            this.iam = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.iam++;
        } else {
            this.iam--;
        }
        if (this.iam < 0) {
            this.iam = 0;
        } else if (this.iam > 255) {
            this.iam = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.iam / 255.0f;
        window.setAttributes(attributes);
        this.iaj.setProgress(this.iam);
    }
}
