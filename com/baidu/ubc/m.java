package com.baidu.ubc;

import android.util.Log;
/* loaded from: classes6.dex */
class m {
    private static final boolean DEBUG = l.DEBUG & true;
    private static String TAG = "ControlData";
    private final int eBf;
    private final int eBg;
    private int mCount;
    private final String mId;
    private long mTime;

    public m(String str, int i, int i2) {
        this.mId = str;
        this.eBf = i;
        this.eBg = i2;
    }

    public boolean biw() {
        if (this.eBf == 0 || this.eBg == 0) {
            return false;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (DEBUG) {
            Log.d(TAG, "id " + this.mId + " mLimitUnit " + this.eBf + " mLimitCnt " + this.eBg + "mCount =  " + this.mCount + " duration " + ((valueOf.longValue() - this.mTime) / 1000));
        }
        if (this.mTime != 0 && (valueOf.longValue() - this.mTime) / 1000 <= this.eBf && this.mCount >= this.eBg) {
            if (DEBUG) {
                Log.d(TAG, "control");
            }
            return true;
        }
        if (this.mTime == 0) {
            this.mTime = valueOf.longValue();
        } else if ((valueOf.longValue() - this.mTime) / 1000 > this.eBf) {
            this.mTime = valueOf.longValue();
            this.mCount = 0;
            if (DEBUG) {
                Log.d(TAG, "reset");
            }
        }
        this.mCount++;
        return false;
    }

    public boolean bix() {
        return this.mCount != 0 && this.mCount == this.eBg;
    }

    public String getId() {
        return this.mId;
    }
}
