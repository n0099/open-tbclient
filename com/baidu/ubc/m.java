package com.baidu.ubc;

import android.util.Log;
/* loaded from: classes5.dex */
class m {
    private static final boolean DEBUG = l.DEBUG & true;
    private static String TAG = "ControlData";
    private final int ewq;
    private final int ewr;
    private int mCount;
    private final String mId;
    private long mTime;

    public m(String str, int i, int i2) {
        this.mId = str;
        this.ewq = i;
        this.ewr = i2;
    }

    public boolean beD() {
        if (this.ewq == 0 || this.ewr == 0) {
            return false;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (DEBUG) {
            Log.d(TAG, "id " + this.mId + " mLimitUnit " + this.ewq + " mLimitCnt " + this.ewr + "mCount =  " + this.mCount + " duration " + ((valueOf.longValue() - this.mTime) / 1000));
        }
        if (this.mTime != 0 && (valueOf.longValue() - this.mTime) / 1000 <= this.ewq && this.mCount >= this.ewr) {
            if (DEBUG) {
                Log.d(TAG, "control");
            }
            return true;
        }
        if (this.mTime == 0) {
            this.mTime = valueOf.longValue();
        } else if ((valueOf.longValue() - this.mTime) / 1000 > this.ewq) {
            this.mTime = valueOf.longValue();
            this.mCount = 0;
            if (DEBUG) {
                Log.d(TAG, "reset");
            }
        }
        this.mCount++;
        return false;
    }

    public boolean beE() {
        return this.mCount != 0 && this.mCount == this.ewr;
    }

    public String getId() {
        return this.mId;
    }
}
