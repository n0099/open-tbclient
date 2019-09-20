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
    private int hiI;
    private SwitchImageView iCE;
    private TextView iCF;
    private SeekBar iCG;
    private int iCH;
    private float iCI;
    private int iCJ;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.hiI = 100;
        this.iCI = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hiI = 100;
        this.iCI = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hiI = 100;
        this.iCI = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.iCE = (SwitchImageView) findViewById(R.id.gesture_icon);
        this.iCF = (TextView) findViewById(R.id.gesture_txt);
        this.iCG = (SeekBar) findViewById(R.id.gesture_seekbar);
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.hiI = this.mAudioManager.getStreamMaxVolume(3);
            this.iCH = this.mAudioManager.getStreamVolume(3);
            this.iCI = 100 / this.hiI;
        }
    }

    public void x(boolean z, String str) {
        if (this.mState != 3) {
            this.iCE.setStateImage(R.drawable.icon_vedio_fast_forward, R.drawable.icon_vedio_quick_retreat);
            ((RelativeLayout.LayoutParams) this.iCE.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds52);
            this.iCE.setVisibility(0);
            this.iCF.setVisibility(0);
            this.iCG.setVisibility(8);
            this.mState = 3;
        }
        this.iCF.setText(str);
        this.iCE.setState(z ? 1 : 0);
    }

    public void k(Context context, boolean z) {
        if (this.mState != 1) {
            this.iCE.setStateImage(R.drawable.icon_vedio_volume_white, R.drawable.icon_vedio_mute_white);
            ((RelativeLayout.LayoutParams) this.iCE.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds55);
            this.iCG.setMax(100);
            this.iCE.setVisibility(0);
            this.iCF.setVisibility(8);
            this.iCG.setVisibility(0);
            this.iCH = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress++;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress--;
        }
        if (this.mProgress % this.iCI == 0.0f) {
            if (z && this.iCH < this.hiI) {
                this.iCH++;
            }
            if (!z && this.iCH > 0) {
                this.iCH--;
            }
        }
        if (this.iCH <= 0) {
            this.iCE.setState(1);
        } else {
            this.iCE.setState(0);
        }
        this.mAudioManager.setStreamVolume(3, this.iCH, 0);
        this.iCG.setProgress(this.mProgress);
    }

    public void l(Context context, boolean z) {
        if (this.mState != 2) {
            this.iCE.setStateImage(R.drawable.icon_video_light_white, R.drawable.icon_video_light_white);
            this.iCE.setState(0);
            ((RelativeLayout.LayoutParams) this.iCE.getLayoutParams()).topMargin = (int) getResources().getDimension(R.dimen.tbds32);
            this.iCG.setMax(255);
            this.iCE.setVisibility(0);
            this.iCF.setVisibility(8);
            this.iCG.setVisibility(0);
            this.iCJ = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.iCJ++;
        } else {
            this.iCJ--;
        }
        if (this.iCJ < 0) {
            this.iCJ = 0;
        } else if (this.iCJ > 255) {
            this.iCJ = 255;
        }
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.iCJ / 255.0f;
        window.setAttributes(attributes);
        this.iCG.setProgress(this.iCJ);
    }
}
