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
    private int hfV;
    private SwitchImageView iAj;
    private TextView iAk;
    private SeekBar iAl;
    private int iAm;
    private float iAn;
    private int iAo;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hfV = 100;
        this.iAn = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hfV = 100;
        this.iAn = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hfV = 100;
        this.iAn = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.iAj = (SwitchImageView) findViewById(R.id.gesture_icon);
        this.iAk = (TextView) findViewById(R.id.gesture_txt);
        this.iAl = (SeekBar) findViewById(R.id.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hfV = this.mAudioManager.getStreamMaxVolume(3);
            this.iAm = this.mAudioManager.getStreamVolume(3);
            this.iAn = 100 / this.hfV;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.iAj.setStateImage(R.drawable.icon_vedio_fast_forward, R.drawable.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.iAj.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds52);
            this.iAj.setVisibility(0);
            this.iAk.setVisibility(0);
            this.iAl.setVisibility(8);
            this.mState = 3;
        }
        this.iAk.setText(str);
        this.iAj.setState(z ? 1 : 0);
    }

    public void k(Context context, boolean z) {
        if (this.mState != 1) {
            this.iAj.setStateImage(R.drawable.icon_vedio_volume_white, R.drawable.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.iAj.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds55);
            this.iAl.setMax(100);
            this.iAj.setVisibility(0);
            this.iAk.setVisibility(8);
            this.iAl.setVisibility(0);
            this.iAm = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.iAn == 0.0f) {
            if (z && this.iAm < this.hfV) {
                this.iAm++;
            }
            if (!z && this.iAm > 0) {
                this.iAm--;
            }
        }
        if (this.iAm <= 0) {
            this.iAj.setState(1);
        } else {
            this.iAj.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.iAm, 0);
        this.iAl.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        if (this.mState != 2) {
            this.iAj.setStateImage(R.drawable.icon_video_light_white, R.drawable.icon_video_light_white);
            this.iAj.setState(0);
            ((RelativeLayout.LayoutParams) this.iAj.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds32);
            this.iAl.setMax(255);
            this.iAj.setVisibility(0);
            this.iAk.setVisibility(8);
            this.iAl.setVisibility(0);
            this.iAo = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.iAo++;
        } else {
            this.iAo--;
        }
        if (this.iAo < 0) {
            this.iAo = 0;
        } else if (this.iAo > 255) {
            this.iAo = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.iAo / 255.0f;
        window.setAttributes(attributes);
        this.iAl.setProgress(this.iAo);
    }
}
