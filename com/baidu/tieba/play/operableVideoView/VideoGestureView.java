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
    private int gIk;
    private SwitchImageView iag;
    private TextView iah;
    private SeekBar iai;
    private int iaj;
    private float iak;
    private int ial;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.gIk = 100;
        this.iak = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIk = 100;
        this.iak = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIk = 100;
        this.iak = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), d.h.operable_video_gesture, this);
        this.iag = (SwitchImageView) findViewById(d.g.gesture_icon);
        this.iah = (TextView) findViewById(d.g.gesture_txt);
        this.iai = (SeekBar) findViewById(d.g.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.gIk = this.mAudioManager.getStreamMaxVolume(3);
            this.iaj = this.mAudioManager.getStreamVolume(3);
            this.iak = 100 / this.gIk;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.iag.setStateImage(d.f.icon_vedio_fast_forward, d.f.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.iag.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds52);
            this.iag.setVisibility(0);
            this.iah.setVisibility(0);
            this.iai.setVisibility(8);
            this.mState = 3;
        }
        this.iah.setText(str);
        this.iag.setState(z ? 1 : 0);
    }

    public void m(Context context, boolean z) {
        if (this.mState != 1) {
            this.iag.setStateImage(d.f.icon_vedio_volume_white, d.f.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.iag.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds55);
            this.iai.setMax(100);
            this.iag.setVisibility(0);
            this.iah.setVisibility(8);
            this.iai.setVisibility(0);
            this.iaj = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.iak == 0.0f) {
            if (z && this.iaj < this.gIk) {
                this.iaj++;
            }
            if (!z && this.iaj > 0) {
                this.iaj--;
            }
        }
        if (this.iaj <= 0) {
            this.iag.setState(1);
        } else {
            this.iag.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.iaj, 0);
        this.iai.setProgress(this.mProgress);
    }

    public void n(Context context, boolean z) {
        if (this.mState != 2) {
            this.iag.setStateImage(d.f.icon_video_light_white, d.f.icon_video_light_white);
            this.iag.setState(0);
            ((RelativeLayout.LayoutParams) this.iag.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds32);
            this.iai.setMax(255);
            this.iag.setVisibility(0);
            this.iah.setVisibility(8);
            this.iai.setVisibility(0);
            this.ial = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.ial++;
        } else {
            this.ial--;
        }
        if (this.ial < 0) {
            this.ial = 0;
        } else if (this.ial > 255) {
            this.ial = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.ial / 255.0f;
        window.setAttributes(attributes);
        this.iai.setProgress(this.ial);
    }
}
