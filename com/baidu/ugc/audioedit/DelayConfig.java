package com.baidu.ugc.audioedit;

import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class DelayConfig implements Serializable {
    public static final int MODE_PART_SECTION = 2;
    public static final int MODE_WHOLE_SECTION = 1;
    public int[] pairTimeArray;
    public int pairTimeLength;
    public int delayMode = 1;
    public int delayTime = -1;
    public float decrease = -1.0f;
    public int newPosition = -1;

    public boolean available() {
        if (this.delayTime < 0) {
            float f = this.decrease;
            if ((f < 0.0f || f > 1.0f) && ((this.pairTimeLength <= 0 || this.pairTimeArray == null) && this.newPosition < 0)) {
                return false;
            }
        }
        return true;
    }

    public float getDecrease() {
        return this.decrease;
    }

    public int getDelayMode() {
        return this.delayMode;
    }

    public int getDelayTime() {
        return this.delayTime;
    }

    public int getNewPosition() {
        return this.newPosition;
    }

    public int[] getPairTimeArray() {
        return this.pairTimeArray;
    }

    public int getPairTimeLength() {
        return this.pairTimeLength;
    }

    public DelayConfig setDecrease(float f) {
        this.decrease = f;
        return this;
    }

    public DelayConfig setDelayTime(int i) {
        this.delayTime = i;
        return this;
    }

    public DelayConfig setNewPosition(int i) {
        this.newPosition = i;
        return this;
    }

    public DelayConfig setDelayInterval(int i, int[] iArr) {
        this.pairTimeLength = i;
        this.pairTimeArray = iArr;
        return this;
    }

    public String toString() {
        return "DelayConfig{delayMode=" + this.delayMode + ", delayTime=" + this.delayTime + ", decrease=" + this.decrease + ", pairTimeLength=" + this.pairTimeLength + ", pairTimeArray=" + Arrays.toString(this.pairTimeArray) + ", newPosition=" + this.newPosition + '}';
    }
}
