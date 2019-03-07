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
    private TextView iaA;
    private SeekBar iaB;
    private int iaC;
    private float iaD;
    private int iaE;
    private SwitchImageView iaz;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.gIx = 100;
        this.iaD = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gIx = 100;
        this.iaD = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gIx = 100;
        this.iaD = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), d.h.operable_video_gesture, this);
        this.iaz = (SwitchImageView) findViewById(d.g.gesture_icon);
        this.iaA = (TextView) findViewById(d.g.gesture_txt);
        this.iaB = (SeekBar) findViewById(d.g.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.gIx = this.mAudioManager.getStreamMaxVolume(3);
            this.iaC = this.mAudioManager.getStreamVolume(3);
            this.iaD = 100 / this.gIx;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.iaz.setStateImage(d.f.icon_vedio_fast_forward, d.f.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.iaz.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds52);
            this.iaz.setVisibility(0);
            this.iaA.setVisibility(0);
            this.iaB.setVisibility(8);
            this.mState = 3;
        }
        this.iaA.setText(str);
        this.iaz.setState(z ? 1 : 0);
    }

    public void m(Context context, boolean z) {
        if (this.mState != 1) {
            this.iaz.setStateImage(d.f.icon_vedio_volume_white, d.f.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.iaz.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds55);
            this.iaB.setMax(100);
            this.iaz.setVisibility(0);
            this.iaA.setVisibility(8);
            this.iaB.setVisibility(0);
            this.iaC = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.iaD == 0.0f) {
            if (z && this.iaC < this.gIx) {
                this.iaC++;
            }
            if (!z && this.iaC > 0) {
                this.iaC--;
            }
        }
        if (this.iaC <= 0) {
            this.iaz.setState(1);
        } else {
            this.iaz.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.iaC, 0);
        this.iaB.setProgress(this.mProgress);
    }

    public void n(Context context, boolean z) {
        if (this.mState != 2) {
            this.iaz.setStateImage(d.f.icon_video_light_white, d.f.icon_video_light_white);
            this.iaz.setState(0);
            ((RelativeLayout.LayoutParams) this.iaz.getLayoutParams()).topMargin = (int) getResources().getDimension(d.e.tbds32);
            this.iaB.setMax(255);
            this.iaz.setVisibility(0);
            this.iaA.setVisibility(8);
            this.iaB.setVisibility(0);
            this.iaE = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.iaE++;
        } else {
            this.iaE--;
        }
        if (this.iaE < 0) {
            this.iaE = 0;
        } else if (this.iaE > 255) {
            this.iaE = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.iaE / 255.0f;
        window.setAttributes(attributes);
        this.iaB.setProgress(this.iaE);
    }
}
