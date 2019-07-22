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
    private SwitchImageView izi;
    private TextView izj;
    private SeekBar izk;
    private int izl;
    private float izm;
    private int izn;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hfV = 100;
        this.izm = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hfV = 100;
        this.izm = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hfV = 100;
        this.izm = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.izi = (SwitchImageView) findViewById(R.id.gesture_icon);
        this.izj = (TextView) findViewById(R.id.gesture_txt);
        this.izk = (SeekBar) findViewById(R.id.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hfV = this.mAudioManager.getStreamMaxVolume(3);
            this.izl = this.mAudioManager.getStreamVolume(3);
            this.izm = 100 / this.hfV;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.izi.setStateImage(R.drawable.icon_vedio_fast_forward, R.drawable.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.izi.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds52);
            this.izi.setVisibility(0);
            this.izj.setVisibility(0);
            this.izk.setVisibility(8);
            this.mState = 3;
        }
        this.izj.setText(str);
        this.izi.setState(z ? 1 : 0);
    }

    public void k(Context context, boolean z) {
        if (this.mState != 1) {
            this.izi.setStateImage(R.drawable.icon_vedio_volume_white, R.drawable.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.izi.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds55);
            this.izk.setMax(100);
            this.izi.setVisibility(0);
            this.izj.setVisibility(8);
            this.izk.setVisibility(0);
            this.izl = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.izm == 0.0f) {
            if (z && this.izl < this.hfV) {
                this.izl++;
            }
            if (!z && this.izl > 0) {
                this.izl--;
            }
        }
        if (this.izl <= 0) {
            this.izi.setState(1);
        } else {
            this.izi.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.izl, 0);
        this.izk.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        if (this.mState != 2) {
            this.izi.setStateImage(R.drawable.icon_video_light_white, R.drawable.icon_video_light_white);
            this.izi.setState(0);
            ((RelativeLayout.LayoutParams) this.izi.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds32);
            this.izk.setMax(255);
            this.izi.setVisibility(0);
            this.izj.setVisibility(8);
            this.izk.setVisibility(0);
            this.izn = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.izn++;
        } else {
            this.izn--;
        }
        if (this.izn < 0) {
            this.izn = 0;
        } else if (this.izn > 255) {
            this.izn = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.izn / 255.0f;
        window.setAttributes(attributes);
        this.izk.setProgress(this.izn);
    }
}
