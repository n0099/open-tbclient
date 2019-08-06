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
    private int hgN;
    private SwitchImageView iAm;
    private TextView iAn;
    private SeekBar iAo;
    private int iAp;
    private float iAq;
    private int iAr;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hgN = 100;
        this.iAq = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hgN = 100;
        this.iAq = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hgN = 100;
        this.iAq = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.iAm = (SwitchImageView) findViewById(R.id.gesture_icon);
        this.iAn = (TextView) findViewById(R.id.gesture_txt);
        this.iAo = (SeekBar) findViewById(R.id.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hgN = this.mAudioManager.getStreamMaxVolume(3);
            this.iAp = this.mAudioManager.getStreamVolume(3);
            this.iAq = 100 / this.hgN;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.iAm.setStateImage(R.drawable.icon_vedio_fast_forward, R.drawable.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.iAm.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds52);
            this.iAm.setVisibility(0);
            this.iAn.setVisibility(0);
            this.iAo.setVisibility(8);
            this.mState = 3;
        }
        this.iAn.setText(str);
        this.iAm.setState(z ? 1 : 0);
    }

    public void k(Context context, boolean z) {
        if (this.mState != 1) {
            this.iAm.setStateImage(R.drawable.icon_vedio_volume_white, R.drawable.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.iAm.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds55);
            this.iAo.setMax(100);
            this.iAm.setVisibility(0);
            this.iAn.setVisibility(8);
            this.iAo.setVisibility(0);
            this.iAp = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.iAq == 0.0f) {
            if (z && this.iAp < this.hgN) {
                this.iAp++;
            }
            if (!z && this.iAp > 0) {
                this.iAp--;
            }
        }
        if (this.iAp <= 0) {
            this.iAm.setState(1);
        } else {
            this.iAm.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.iAp, 0);
        this.iAo.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        if (this.mState != 2) {
            this.iAm.setStateImage(R.drawable.icon_video_light_white, R.drawable.icon_video_light_white);
            this.iAm.setState(0);
            ((RelativeLayout.LayoutParams) this.iAm.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds32);
            this.iAo.setMax(255);
            this.iAm.setVisibility(0);
            this.iAn.setVisibility(8);
            this.iAo.setVisibility(0);
            this.iAr = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.iAr++;
        } else {
            this.iAr--;
        }
        if (this.iAr < 0) {
            this.iAr = 0;
        } else if (this.iAr > 255) {
            this.iAr = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.iAr / 255.0f;
        window.setAttributes(attributes);
        this.iAo.setProgress(this.iAr);
    }
}
