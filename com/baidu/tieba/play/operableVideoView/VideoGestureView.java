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
    private int gZJ;
    private SwitchImageView isR;
    private TextView isS;
    private SeekBar isT;
    private int isU;
    private float isV;
    private int isW;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.gZJ = 100;
        this.isV = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZJ = 100;
        this.isV = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZJ = 100;
        this.isV = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.isR = (SwitchImageView) findViewById(R.id.gesture_icon);
        this.isS = (TextView) findViewById(R.id.gesture_txt);
        this.isT = (SeekBar) findViewById(R.id.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.gZJ = this.mAudioManager.getStreamMaxVolume(3);
            this.isU = this.mAudioManager.getStreamVolume(3);
            this.isV = 100 / this.gZJ;
        }
    }

    public void w(boolean z, String str) {
        if (this.mState != 3) {
            this.isR.setStateImage(R.drawable.icon_vedio_fast_forward, R.drawable.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.isR.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds52);
            this.isR.setVisibility(0);
            this.isS.setVisibility(0);
            this.isT.setVisibility(8);
            this.mState = 3;
        }
        this.isS.setText(str);
        this.isR.setState(z ? 1 : 0);
    }

    public void k(Context context, boolean z) {
        if (this.mState != 1) {
            this.isR.setStateImage(R.drawable.icon_vedio_volume_white, R.drawable.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.isR.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds55);
            this.isT.setMax(100);
            this.isR.setVisibility(0);
            this.isS.setVisibility(8);
            this.isT.setVisibility(0);
            this.isU = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.isV == 0.0f) {
            if (z && this.isU < this.gZJ) {
                this.isU++;
            }
            if (!z && this.isU > 0) {
                this.isU--;
            }
        }
        if (this.isU <= 0) {
            this.isR.setState(1);
        } else {
            this.isR.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.isU, 0);
        this.isT.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        if (this.mState != 2) {
            this.isR.setStateImage(R.drawable.icon_video_light_white, R.drawable.icon_video_light_white);
            this.isR.setState(0);
            ((RelativeLayout.LayoutParams) this.isR.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds32);
            this.isT.setMax(255);
            this.isR.setVisibility(0);
            this.isS.setVisibility(8);
            this.isT.setVisibility(0);
            this.isW = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.isW++;
        } else {
            this.isW--;
        }
        if (this.isW < 0) {
            this.isW = 0;
        } else if (this.isW > 255) {
            this.isW = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.isW / 255.0f;
        window.setAttributes(attributes);
        this.isT.setProgress(this.isW);
    }
}
