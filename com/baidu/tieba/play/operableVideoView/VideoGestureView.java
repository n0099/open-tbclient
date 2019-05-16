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
    private int gZF;
    private SwitchImageView isN;
    private TextView isO;
    private SeekBar isP;
    private int isQ;
    private float isR;
    private int isS;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.gZF = 100;
        this.isR = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZF = 100;
        this.isR = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZF = 100;
        this.isR = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.isN = (SwitchImageView) findViewById(R.id.gesture_icon);
        this.isO = (TextView) findViewById(R.id.gesture_txt);
        this.isP = (SeekBar) findViewById(R.id.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.gZF = this.mAudioManager.getStreamMaxVolume(3);
            this.isQ = this.mAudioManager.getStreamVolume(3);
            this.isR = 100 / this.gZF;
        }
    }

    public void w(boolean z, String str) {
        if (this.mState != 3) {
            this.isN.setStateImage(R.drawable.icon_vedio_fast_forward, R.drawable.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.isN.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds52);
            this.isN.setVisibility(0);
            this.isO.setVisibility(0);
            this.isP.setVisibility(8);
            this.mState = 3;
        }
        this.isO.setText(str);
        this.isN.setState(z ? 1 : 0);
    }

    public void k(Context context, boolean z) {
        if (this.mState != 1) {
            this.isN.setStateImage(R.drawable.icon_vedio_volume_white, R.drawable.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.isN.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds55);
            this.isP.setMax(100);
            this.isN.setVisibility(0);
            this.isO.setVisibility(8);
            this.isP.setVisibility(0);
            this.isQ = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.isR == 0.0f) {
            if (z && this.isQ < this.gZF) {
                this.isQ++;
            }
            if (!z && this.isQ > 0) {
                this.isQ--;
            }
        }
        if (this.isQ <= 0) {
            this.isN.setState(1);
        } else {
            this.isN.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.isQ, 0);
        this.isP.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        if (this.mState != 2) {
            this.isN.setStateImage(R.drawable.icon_video_light_white, R.drawable.icon_video_light_white);
            this.isN.setState(0);
            ((RelativeLayout.LayoutParams) this.isN.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds32);
            this.isP.setMax(255);
            this.isN.setVisibility(0);
            this.isO.setVisibility(8);
            this.isP.setVisibility(0);
            this.isS = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.isS++;
        } else {
            this.isS--;
        }
        if (this.isS < 0) {
            this.isS = 0;
        } else if (this.isS > 255) {
            this.isS = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.isS / 255.0f;
        window.setAttributes(attributes);
        this.isP.setProgress(this.isS);
    }
}
