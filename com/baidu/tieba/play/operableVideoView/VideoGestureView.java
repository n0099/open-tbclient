package com.baidu.tieba.play.operableVideoView;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class VideoGestureView extends RelativeLayout {
    private int jQo;
    private ViewGroup lvO;
    private ImageView lvP;
    private ProgressBar lvQ;
    private ViewGroup lvR;
    private ImageView lvS;
    private TextView lvT;
    private int lvU;
    private float lvV;
    private int lvW;
    private AudioManager mAudioManager;
    private int mProgress;
    private int mState;

    public VideoGestureView(Context context) {
        super(context);
        this.jQo = 100;
        this.lvV = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQo = 100;
        this.lvV = 1.0f;
        this.mState = 0;
        init();
    }

    public VideoGestureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQo = 100;
        this.lvV = 1.0f;
        this.mState = 0;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.operable_video_gesture, this);
        this.lvO = (ViewGroup) findViewById(R.id.video_gesture_progress_zone);
        this.lvP = (ImageView) findViewById(R.id.video_gesture_progress_icon);
        this.lvQ = (ProgressBar) findViewById(R.id.video_gesture_progress_bar);
        this.lvR = (ViewGroup) findViewById(R.id.video_gesture_ffrew_zone);
        this.lvS = (ImageView) findViewById(R.id.video_gesture_ffrew_icon);
        this.lvT = (TextView) findViewById(R.id.video_gesture_ffrew_txt);
        this.lvO.setBackgroundDrawable(ap.aO(getResources().getDimensionPixelOffset(R.dimen.tbds37), getResources().getColor(R.color.cp_mask_b_alpha33)));
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
        if (this.mAudioManager != null) {
            this.jQo = this.mAudioManager.getStreamMaxVolume(3);
            this.lvU = this.mAudioManager.getStreamVolume(3);
            this.lvV = 100 / this.jQo;
        }
    }

    public void B(boolean z, String str) {
        if (this.mState != 3) {
            this.lvR.setVisibility(0);
            this.lvO.setVisibility(8);
            setBackgroundResource(R.color.cp_mask_b_alpha33);
            this.mState = 3;
        }
        this.lvT.setText(str);
        SvgManager.bjq().a(this.lvS, z ? R.drawable.ic_icon_pure_video_rewind44_svg : R.drawable.ic_icon_pure_video_forward44_svg, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
    }

    public void r(Context context, boolean z) {
        c(context, z, 1);
    }

    public void c(Context context, boolean z, int i) {
        int i2;
        if (this.mState != 1) {
            this.lvR.setVisibility(8);
            this.lvO.setVisibility(0);
            this.lvQ.setMax(100);
            setBackgroundDrawable(null);
            this.lvU = this.mAudioManager.getStreamVolume(3);
            this.mState = 1;
        }
        if (z && this.mProgress < 100) {
            this.mProgress += i;
        }
        if (!z && this.mProgress > 0) {
            this.mProgress -= i;
        }
        if (this.mProgress > 100) {
            this.mProgress = 100;
        }
        if (this.mProgress < 0) {
            this.mProgress = 0;
        }
        this.lvU = (int) (this.mProgress / this.lvV);
        if (this.mProgress == 0) {
            i2 = R.drawable.ic_icon_pure_video_silent16_svg;
        } else if (this.mProgress < 50) {
            i2 = R.drawable.ic_icon_pure_video_sound_small16_svg;
        } else {
            i2 = R.drawable.ic_icon_pure_video_sound_big16_svg;
        }
        SvgManager.bjq().a(this.lvP, i2, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        this.mAudioManager.setStreamVolume(3, this.lvU, 0);
        this.lvQ.setProgress(this.mProgress);
    }

    public void s(Context context, boolean z) {
        int i;
        if (this.mState != 2) {
            this.lvR.setVisibility(8);
            this.lvO.setVisibility(0);
            this.lvQ.setMax(255);
            setBackgroundDrawable(null);
            this.lvW = Settings.System.getInt(context.getContentResolver(), "screen_brightness", 255);
            this.mState = 2;
        }
        if (z) {
            this.lvW += 2;
        } else {
            this.lvW -= 2;
        }
        if (this.lvW < 1) {
            this.lvW = 1;
        } else if (this.lvW > 255) {
            this.lvW = 255;
        }
        if (this.lvW <= 43) {
            i = R.drawable.ic_icon_pure_video_dark16_svg;
        } else if (this.lvW <= 128) {
            i = R.drawable.ic_icon_pure_video_weaklight16_svg;
        } else {
            i = R.drawable.ic_icon_pure_video_highlight16_svg;
        }
        SvgManager.bjq().a(this.lvP, i, R.color.cp_mask_c_alpha100, (SvgManager.SvgResourceStateType) null);
        Window window = ((Activity) context).getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = this.lvW / 255.0f;
        window.setAttributes(attributes);
        this.lvQ.setProgress(this.lvW);
    }
}
