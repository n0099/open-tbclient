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
    private int gIx;
    private SwitchImageView iau;
    private TextView iav;
    private SeekBar iaw;
    private int iax;
    private float iay;
    private int iaz;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.gIx = 100;
        this.iay = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIx = 100;
        this.iay = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIx = 100;
        this.iay = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), d.h.operable_video_gesture, this);
        this.iau = (SwitchImageView) findViewById(d.g.gesture_icon);
        this.iav = (TextView) findViewById(d.g.gesture_txt);
        this.iaw = (SeekBar) findViewById(d.g.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.gIx = this.mAudioManager.getStreamMaxVolume(3);
            this.iax = this.mAudioManager.getStreamVolume(3);
            this.iay = 100 / this.gIx;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.iau.setStateImage(d.f.icon_vedio_fast_forward, d.f.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.iau.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds52);
            this.iau.setVisibility(0);
            this.iav.setVisibility(0);
            this.iaw.setVisibility(8);
            this.mState = 3;
        }
        this.iav.setText(str);
        this.iau.setState(z ? 1 : 0);
    }

    public void m(Context context, boolean z) {
        if (this.mState != 1) {
            this.iau.setStateImage(d.f.icon_vedio_volume_white, d.f.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.iau.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds55);
            this.iaw.setMax(100);
            this.iau.setVisibility(0);
            this.iav.setVisibility(8);
            this.iaw.setVisibility(0);
            this.iax = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.iay == 0.0f) {
            if (z && this.iax < this.gIx) {
                this.iax++;
            }
            if (!z && this.iax > 0) {
                this.iax--;
            }
        }
        if (this.iax <= 0) {
            this.iau.setState(1);
        } else {
            this.iau.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.iax, 0);
        this.iaw.setProgress(this.mProgress);
    }

    public void n(Context context, boolean z) {
        if (this.mState != 2) {
            this.iau.setStateImage(d.f.icon_video_light_white, d.f.icon_video_light_white);
            this.iau.setState(0);
            ((RelativeLayout.LayoutParams) this.iau.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds32);
            this.iaw.setMax(255);
            this.iau.setVisibility(0);
            this.iav.setVisibility(8);
            this.iaw.setVisibility(0);
            this.iaz = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.iaz++;
        } else {
            this.iaz--;
        }
        if (this.iaz < 0) {
            this.iaz = 0;
        } else if (this.iaz > 255) {
            this.iaz = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.iaz / 255.0f;
        window.setAttributes(attributes);
        this.iaw.setProgress(this.iaz);
    }
}
