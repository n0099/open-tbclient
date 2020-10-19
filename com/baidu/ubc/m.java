package com.baidu.ubc;

import android.util.Log;
/* loaded from: classes19.dex */
class m {
    private static final boolean DEBUG = l.DEBUG & true;
    private static String TAG = "ControlData";
    private final int dXP;
    private int mCount;
    private final String mId;
    private final int mSize;
    private long mTime;

    public m(String str, int i, int i2) {
        this.mId = str;
        this.dXP = i;
        this.mSize = i2;
    }

    public boolean aZi() {
        if (this.dXP == 0 || this.mSize == 0) {
            return false;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (DEBUG) {
            Log.d(TAG, "id " + this.mId + " mCycle " + this.dXP + " mSize " + this.mSize + "mCount =  " + this.mCount + " duration " + ((valueOf.longValue() - this.mTime) / 1000));
        }
        if (this.mTime != 0 && (valueOf.longValue() - this.mTime) / 1000 <= this.dXP && this.mCount >= this.mSize) {
            if (DEBUG) {
                Log.d(TAG, "control");
            }
            return true;
        }
        if (this.mTime == 0) {
            this.mTime = valueOf.longValue();
        } else if ((valueOf.longValue() - this.mTime) / 1000 > this.dXP) {
            this.mTime = valueOf.longValue();
            this.mCount = 0;
            if (DEBUG) {
                Log.d(TAG, "reset");
            }
        }
        this.mCount++;
        return false;
    }

    public boolean aZj() {
        return this.mCount != 0 && this.mCount == this.mSize;
    }

    public String getId() {
        return this.mId;
    }
}
