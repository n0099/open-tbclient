package com.baidu.zeus;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public class ZeusScroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE = 0;
    private static float sViscousFluidNormalize;
    private static float sViscousFluidScale = 8.0f;
    private float mCoeffX;
    private float mCoeffY;
    private int mCurrX;
    private int mCurrY;
    private final float mDeceleration;
    private float mDeltaX;
    private float mDeltaY;
    private int mDuration;
    private float mDurationReciprocal;
    private int mFinalX;
    private int mFinalY;
    private boolean mFinished;
    private Interpolator mInterpolator;
    private int mMaxX;
    private int mMaxY;
    private int mMinX;
    private int mMinY;
    private int mMode;
    private long mStartTime;
    private int mStartX;
    private int mStartY;
    private float mVelocity;

    static {
        sViscousFluidNormalize = 1.0f;
        sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
    }

    public ZeusScroller(Context context) {
        this(context, null);
    }

    public ZeusScroller(Context context, Interpolator interpolator) {
        this.mCoeffX = 0.0f;
        this.mCoeffY = 1.0f;
        this.mFinished = true;
        this.mInterpolator = interpolator;
        this.mDeceleration = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * ViewConfiguration.getScrollFriction();
    }

    public final boolean isFinished() {
        return this.mFinished;
    }

    public final void forceFinished(boolean z) {
        this.mFinished = z;
    }

    public final int getDuration() {
        return this.mDuration;
    }

    public final int getCurrX() {
        return this.mCurrX;
    }

    public final int getCurrY() {
        return this.mCurrY;
    }

    public float getCurrVelocity() {
        return this.mVelocity - ((this.mDeceleration * timePassed()) / 2000.0f);
    }

    public final int getStartX() {
        return this.mStartX;
    }

    public final int getStartY() {
        return this.mStartY;
    }

    public final int getFinalX() {
        return this.mFinalX;
    }

    public final int getFinalY() {
        return this.mFinalY;
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (this.mFinished) {
            return false;
        }
        int currentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
        if (currentAnimationTimeMillis < this.mDuration) {
            switch (this.mMode) {
                case 0:
                    float f = currentAnimationTimeMillis * this.mDurationReciprocal;
                    if (this.mInterpolator == null) {
                        interpolation = viscousFluid(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.mCurrX = this.mStartX + Math.round(this.mDeltaX * interpolation);
                    this.mCurrY = Math.round(interpolation * this.mDeltaY) + this.mStartY;
                    break;
                case 1:
                    float f2 = currentAnimationTimeMillis / 1000.0f;
                    float f3 = (this.mVelocity * f2) - ((f2 * (this.mDeceleration * f2)) / 2.0f);
                    this.mCurrX = this.mStartX + Math.round(this.mCoeffX * f3);
                    this.mCurrX = Math.min(this.mCurrX, this.mMaxX);
                    this.mCurrX = Math.max(this.mCurrX, this.mMinX);
                    this.mCurrY = Math.round(f3 * this.mCoeffY) + this.mStartY;
                    this.mCurrY = Math.min(this.mCurrY, this.mMaxY);
                    this.mCurrY = Math.max(this.mCurrY, this.mMinY);
                    if (this.mCurrX == this.mFinalX && this.mCurrY == this.mFinalY) {
                        this.mFinished = true;
                        break;
                    }
                    break;
            }
        } else {
            this.mCurrX = this.mFinalX;
            this.mCurrY = this.mFinalY;
            this.mFinished = true;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, DEFAULT_DURATION);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.mFinished = false;
        this.mDuration = i5;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i;
        this.mStartY = i2;
        this.mFinalX = i + i3;
        this.mFinalY = i2 + i4;
        this.mDeltaX = i3;
        this.mDeltaY = i4;
        this.mDurationReciprocal = 1.0f / this.mDuration;
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mMode = 1;
        this.mFinished = false;
        float hypot = (float) Math.hypot(i3, i4);
        this.mVelocity = hypot;
        this.mDuration = (int) ((1000.0f * hypot) / this.mDeceleration);
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mStartX = i;
        this.mStartY = i2;
        this.mCoeffX = hypot == 0.0f ? 1.0f : i3 / hypot;
        this.mCoeffY = hypot != 0.0f ? i4 / hypot : 1.0f;
        int i9 = (int) ((hypot * hypot) / (2.0f * this.mDeceleration));
        this.mMinX = i5;
        this.mMaxX = i6;
        this.mMinY = i7;
        this.mMaxY = i8;
        this.mFinalX = Math.round(i9 * this.mCoeffX) + i;
        this.mFinalX = Math.min(this.mFinalX, this.mMaxX);
        this.mFinalX = Math.max(this.mFinalX, this.mMinX);
        this.mFinalY = Math.round(i9 * this.mCoeffY) + i2;
        this.mFinalY = Math.min(this.mFinalY, this.mMaxY);
        this.mFinalY = Math.max(this.mFinalY, this.mMinY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float viscousFluid(float f) {
        float exp;
        float f2 = sViscousFluidScale * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * sViscousFluidNormalize;
    }

    public void abortAnimation() {
        this.mCurrX = this.mFinalX;
        this.mCurrY = this.mFinalY;
        this.mFinished = true;
    }

    public void extendDuration(int i) {
        this.mDuration = timePassed() + i;
        this.mDurationReciprocal = 1.0f / this.mDuration;
        this.mFinished = false;
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    }

    public void setFinalX(int i) {
        this.mFinalX = i;
        this.mDeltaX = this.mFinalX - this.mStartX;
        this.mFinished = false;
    }

    public void setFinalY(int i) {
        this.mFinalY = i;
        this.mDeltaY = this.mFinalY - this.mStartY;
        this.mFinished = false;
    }
}
