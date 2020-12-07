package com.baidu.ubc;

import android.util.Log;
/* loaded from: classes15.dex */
class m {
    private static final boolean DEBUG = l.DEBUG & true;
    private static String TAG = "ControlData";
    private final int erv;
    private final int erw;
    private int mCount;
    private final String mId;
    private long mTime;

    public m(String str, int i, int i2) {
        this.mId = str;
        this.erv = i;
        this.erw = i2;
    }

    public boolean bfZ() {
        if (this.erv == 0 || this.erw == 0) {
            return false;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (DEBUG) {
            Log.d(TAG, "id " + this.mId + " mLimitUnit " + this.erv + " mLimitCnt " + this.erw + "mCount =  " + this.mCount + " duration " + ((valueOf.longValue() - this.mTime) / 1000));
        }
        if (this.mTime != 0 && (valueOf.longValue() - this.mTime) / 1000 <= this.erv && this.mCount >= this.erw) {
            if (DEBUG) {
                Log.d(TAG, "control");
            }
            return true;
        }
        if (this.mTime == 0) {
            this.mTime = valueOf.longValue();
        } else if ((valueOf.longValue() - this.mTime) / 1000 > this.erv) {
            this.mTime = valueOf.longValue();
            this.mCount = 0;
            if (DEBUG) {
                Log.d(TAG, "reset");
            }
        }
        this.mCount++;
        return false;
    }

    public boolean bga() {
        return this.mCount != 0 && this.mCount == this.erw;
    }

    public String getId() {
        return this.mId;
    }
}
