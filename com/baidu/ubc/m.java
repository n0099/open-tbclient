package com.baidu.ubc;

import android.util.Log;
/* loaded from: classes13.dex */
class m {
    private static final boolean DEBUG = l.DEBUG & true;
    private static String TAG = "ControlData";
    private final int dpW;
    private int mCount;
    private final String mId;
    private final int mSize;
    private long mTime;

    public m(String str, int i, int i2) {
        this.mId = str;
        this.dpW = i;
        this.mSize = i2;
    }

    public boolean aIq() {
        if (this.dpW == 0 || this.mSize == 0) {
            return false;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (DEBUG) {
            Log.d(TAG, "id " + this.mId + " mCycle " + this.dpW + " mSize " + this.mSize + "mCount =  " + this.mCount + " duration " + ((valueOf.longValue() - this.mTime) / 1000));
        }
        if (this.mTime != 0 && (valueOf.longValue() - this.mTime) / 1000 <= this.dpW && this.mCount >= this.mSize) {
            if (DEBUG) {
                Log.d(TAG, "control");
            }
            return true;
        }
        if (this.mTime == 0) {
            this.mTime = valueOf.longValue();
        } else if ((valueOf.longValue() - this.mTime) / 1000 > this.dpW) {
            this.mTime = valueOf.longValue();
            this.mCount = 0;
            if (DEBUG) {
                Log.d(TAG, "reset");
            }
        }
        this.mCount++;
        return false;
    }

    public boolean aIr() {
        return this.mCount != 0 && this.mCount == this.mSize;
    }

    public String getId() {
        return this.mId;
    }
}
