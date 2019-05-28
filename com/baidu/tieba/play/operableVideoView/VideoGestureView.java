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
    private int gZI;
    private SwitchImageView isQ;
    private TextView isR;
    private SeekBar isS;
    private int isT;
    private float isU;
    private int isV;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.gZI = 100;
        this.isU = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZI = 100;
        this.isU = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZI = 100;
        this.isU = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.isQ = (SwitchImageView) findViewById(R.id.gesture_icon);
        this.isR = (TextView) findViewById(R.id.gesture_txt);
        this.isS = (SeekBar) findViewById(R.id.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.gZI = this.mAudioManager.getStreamMaxVolume(3);
            this.isT = this.mAudioManager.getStreamVolume(3);
            this.isU = 100 / this.gZI;
        }
    }

    public void w(boolean z, String str) {
        if (this.mState != 3) {
            this.isQ.setStateImage(R.drawable.icon_vedio_fast_forward, R.drawable.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.isQ.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds52);
            this.isQ.setVisibility(0);
            this.isR.setVisibility(0);
            this.isS.setVisibility(8);
            this.mState = 3;
        }
        this.isR.setText(str);
        this.isQ.setState(z ? 1 : 0);
    }

    public void k(Context context, boolean z) {
        if (this.mState != 1) {
            this.isQ.setStateImage(R.drawable.icon_vedio_volume_white, R.drawable.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.isQ.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds55);
            this.isS.setMax(100);
            this.isQ.setVisibility(0);
            this.isR.setVisibility(8);
            this.isS.setVisibility(0);
            this.isT = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.isU == 0.0f) {
            if (z && this.isT < this.gZI) {
                this.isT++;
            }
            if (!z && this.isT > 0) {
                this.isT--;
            }
        }
        if (this.isT <= 0) {
            this.isQ.setState(1);
        } else {
            this.isQ.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.isT, 0);
        this.isS.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        if (this.mState != 2) {
            this.isQ.setStateImage(R.drawable.icon_video_light_white, R.drawable.icon_video_light_white);
            this.isQ.setState(0);
            ((RelativeLayout.LayoutParams) this.isQ.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds32);
            this.isS.setMax(255);
            this.isQ.setVisibility(0);
            this.isR.setVisibility(8);
            this.isS.setVisibility(0);
            this.isV = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.isV++;
        } else {
            this.isV--;
        }
        if (this.isV < 0) {
            this.isV = 0;
        } else if (this.isV > 255) {
            this.isV = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.isV / 255.0f;
        window.setAttributes(attributes);
        this.isS.setProgress(this.isV);
    }
}
