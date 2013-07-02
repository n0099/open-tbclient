package com.baidu.zeus;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.MKEvent;
/* loaded from: classes.dex */
public class ZeusEdgeEffect {
    private static final float EPSILON = 0.001f;
    private static final float HELD_EDGE_ALPHA = 0.7f;
    private static final float HELD_EDGE_SCALE_Y = 0.5f;
    private static final float HELD_GLOW_ALPHA = 0.5f;
    private static final float HELD_GLOW_SCALE_Y = 0.5f;
    private static final float MAX_ALPHA = 0.8f;
    private static final float MAX_GLOW_HEIGHT = 4.0f;
    private static final int MIN_VELOCITY = 100;
    private static final int PULL_DECAY_TIME = 1000;
    private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 1.1f;
    private static final int PULL_DISTANCE_EDGE_FACTOR = 7;
    private static final int PULL_DISTANCE_GLOW_FACTOR = 7;
    private static final float PULL_EDGE_BEGIN = 0.6f;
    private static final float PULL_GLOW_BEGIN = 1.0f;
    private static final int PULL_TIME = 167;
    private static final int RECEDE_TIME = 1000;
    private static final int STATE_ABSORB = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PULL = 1;
    private static final int STATE_PULL_DECAY = 4;
    private static final int STATE_RECEDE = 3;
    private static final String TAG = "EdgeEffect";
    private static final int VELOCITY_EDGE_FACTOR = 8;
    private static final int VELOCITY_GLOW_FACTOR = 16;
    private float mDuration;
    private final Drawable mEdge;
    private float mEdgeAlpha;
    private float mEdgeAlphaFinish;
    private float mEdgeAlphaStart;
    private float mEdgeScaleY;
    private float mEdgeScaleYFinish;
    private float mEdgeScaleYStart;
    private final Drawable mGlow;
    private float mGlowAlpha;
    private float mGlowAlphaFinish;
    private float mGlowAlphaStart;
    private float mGlowScaleY;
    private float mGlowScaleYFinish;
    private float mGlowScaleYStart;
    private int mHeight;
    private final Interpolator mInterpolator;
    private final int mMinWidth;
    private float mPullDistance;
    private long mStartTime;
    private int mWidth;
    private final int MIN_WIDTH = MKEvent.ERROR_PERMISSION_DENIED;
    private int mState = 0;

    public ZeusEdgeEffect(Context context) {
        Resources resources = context.getResources();
        this.mEdge = null;
        this.mGlow = null;
        this.mMinWidth = (int) ((resources.getDisplayMetrics().density * 300.0f) + 0.5f);
        this.mInterpolator = new DecelerateInterpolator();
    }

    public void setSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    public boolean isFinished() {
        return this.mState == 0;
    }

    public void finish() {
        this.mState = 0;
    }

    public void onPull(float f) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.mState != 4 || ((float) (currentAnimationTimeMillis - this.mStartTime)) >= this.mDuration) {
            if (this.mState != 1) {
                this.mGlowScaleY = PULL_GLOW_BEGIN;
            }
            this.mState = 1;
            this.mStartTime = currentAnimationTimeMillis;
            this.mDuration = 167.0f;
            this.mPullDistance += f;
            float abs = Math.abs(this.mPullDistance);
            float max = Math.max((float) PULL_EDGE_BEGIN, Math.min(abs, (float) MAX_ALPHA));
            this.mEdgeAlphaStart = max;
            this.mEdgeAlpha = max;
            float max2 = Math.max(0.5f, Math.min(abs * 7.0f, (float) PULL_GLOW_BEGIN));
            this.mEdgeScaleYStart = max2;
            this.mEdgeScaleY = max2;
            float min = Math.min((float) MAX_ALPHA, this.mGlowAlpha + (Math.abs(f) * PULL_DISTANCE_ALPHA_GLOW_FACTOR));
            this.mGlowAlphaStart = min;
            this.mGlowAlpha = min;
            float abs2 = Math.abs(f);
            if (f > 0.0f && this.mPullDistance < 0.0f) {
                abs2 = -abs2;
            }
            if (this.mPullDistance == 0.0f) {
                this.mGlowScaleY = 0.0f;
            }
            float min2 = Math.min((float) MAX_GLOW_HEIGHT, Math.max(0.0f, (abs2 * 7.0f) + this.mGlowScaleY));
            this.mGlowScaleYStart = min2;
            this.mGlowScaleY = min2;
            this.mEdgeAlphaFinish = this.mEdgeAlpha;
            this.mEdgeScaleYFinish = this.mEdgeScaleY;
            this.mGlowAlphaFinish = this.mGlowAlpha;
            this.mGlowScaleYFinish = this.mGlowScaleY;
        }
    }

    public void onRelease() {
        this.mPullDistance = 0.0f;
        if (this.mState == 1 || this.mState == 4) {
            this.mState = 3;
            this.mEdgeAlphaStart = this.mEdgeAlpha;
            this.mEdgeScaleYStart = this.mEdgeScaleY;
            this.mGlowAlphaStart = this.mGlowAlpha;
            this.mGlowScaleYStart = this.mGlowScaleY;
            this.mEdgeAlphaFinish = 0.0f;
            this.mEdgeScaleYFinish = 0.0f;
            this.mGlowAlphaFinish = 0.0f;
            this.mGlowScaleYFinish = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 1000.0f;
        }
    }

    public void onAbsorb(int i) {
        this.mState = 2;
        int max = Math.max(100, Math.abs(i));
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = 0.1f + (max * 0.03f);
        this.mEdgeAlphaStart = 0.0f;
        this.mEdgeScaleYStart = 0.0f;
        this.mEdgeScaleY = 0.0f;
        this.mGlowAlphaStart = 0.5f;
        this.mGlowScaleYStart = 0.0f;
        this.mEdgeAlphaFinish = Math.max(0, Math.min(max * 8, 1));
        this.mEdgeScaleYFinish = Math.max(0.5f, Math.min(max * 8, (float) PULL_GLOW_BEGIN));
        this.mGlowScaleYFinish = Math.min(0.025f + ((max / 100) * max * 1.5E-4f), 1.75f);
        this.mGlowAlphaFinish = Math.max(this.mGlowAlphaStart, Math.min(max * 16 * 1.0E-5f, (float) MAX_ALPHA));
    }

    public boolean draw(Canvas canvas) {
        update();
        int intrinsicHeight = this.mEdge.getIntrinsicHeight();
        this.mEdge.getIntrinsicWidth();
        int intrinsicHeight2 = this.mGlow.getIntrinsicHeight();
        int intrinsicWidth = this.mGlow.getIntrinsicWidth();
        this.mGlow.setAlpha((int) (Math.max(0.0f, Math.min(this.mGlowAlpha, (float) PULL_GLOW_BEGIN)) * 255.0f));
        int min = (int) Math.min((((intrinsicHeight2 * this.mGlowScaleY) * intrinsicHeight2) / intrinsicWidth) * PULL_EDGE_BEGIN, intrinsicHeight2 * MAX_GLOW_HEIGHT);
        if (this.mWidth < this.mMinWidth) {
            int i = (this.mWidth - this.mMinWidth) / 2;
            this.mGlow.setBounds(i, 0, this.mWidth - i, min);
        } else {
            this.mGlow.setBounds(0, 0, this.mWidth, min);
        }
        this.mGlow.draw(canvas);
        this.mEdge.setAlpha((int) (Math.max(0.0f, Math.min(this.mEdgeAlpha, (float) PULL_GLOW_BEGIN)) * 255.0f));
        int i2 = (int) (intrinsicHeight * this.mEdgeScaleY);
        if (this.mWidth < this.mMinWidth) {
            int i3 = (this.mWidth - this.mMinWidth) / 2;
            this.mEdge.setBounds(i3, 0, this.mWidth - i3, i2);
        } else {
            this.mEdge.setBounds(0, 0, this.mWidth, i2);
        }
        this.mEdge.draw(canvas);
        return this.mState != 0;
    }

    private void update() {
        float min = Math.min(((float) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) / this.mDuration, (float) PULL_GLOW_BEGIN);
        float interpolation = this.mInterpolator.getInterpolation(min);
        this.mEdgeAlpha = this.mEdgeAlphaStart + ((this.mEdgeAlphaFinish - this.mEdgeAlphaStart) * interpolation);
        this.mEdgeScaleY = this.mEdgeScaleYStart + ((this.mEdgeScaleYFinish - this.mEdgeScaleYStart) * interpolation);
        this.mGlowAlpha = this.mGlowAlphaStart + ((this.mGlowAlphaFinish - this.mGlowAlphaStart) * interpolation);
        this.mGlowScaleY = this.mGlowScaleYStart + ((this.mGlowScaleYFinish - this.mGlowScaleYStart) * interpolation);
        if (min >= 0.999f) {
            switch (this.mState) {
                case 1:
                    this.mState = 4;
                    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    this.mDuration = 1000.0f;
                    this.mEdgeAlphaStart = this.mEdgeAlpha;
                    this.mEdgeScaleYStart = this.mEdgeScaleY;
                    this.mGlowAlphaStart = this.mGlowAlpha;
                    this.mGlowScaleYStart = this.mGlowScaleY;
                    this.mEdgeAlphaFinish = 0.0f;
                    this.mEdgeScaleYFinish = 0.0f;
                    this.mGlowAlphaFinish = 0.0f;
                    this.mGlowScaleYFinish = 0.0f;
                    return;
                case 2:
                    this.mState = 3;
                    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    this.mDuration = 1000.0f;
                    this.mEdgeAlphaStart = this.mEdgeAlpha;
                    this.mEdgeScaleYStart = this.mEdgeScaleY;
                    this.mGlowAlphaStart = this.mGlowAlpha;
                    this.mGlowScaleYStart = this.mGlowScaleY;
                    this.mEdgeAlphaFinish = 0.0f;
                    this.mEdgeScaleYFinish = 0.0f;
                    this.mGlowAlphaFinish = 0.0f;
                    this.mGlowScaleYFinish = 0.0f;
                    return;
                case 3:
                    this.mState = 0;
                    return;
                case 4:
                    this.mEdgeScaleY = ((this.mGlowScaleYFinish != 0.0f ? PULL_GLOW_BEGIN / (this.mGlowScaleYFinish * this.mGlowScaleYFinish) : Float.MAX_VALUE) * interpolation * (this.mEdgeScaleYFinish - this.mEdgeScaleYStart)) + this.mEdgeScaleYStart;
                    this.mState = 3;
                    return;
                default:
                    return;
            }
        }
    }
}
