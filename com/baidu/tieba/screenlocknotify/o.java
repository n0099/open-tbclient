package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private KeyguardManager cJP;
    private PowerManager cKo;
    private PowerManager.WakeLock cKp;
    private KeyguardManager.KeyguardLock cKq;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.cKo = (PowerManager) this.mContext.getSystemService("power");
            this.cKp = this.cKo.newWakeLock(268435462, "ScreenLockNotify");
            this.cKp.setReferenceCounted(false);
            this.cJP = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.cKq = this.cJP.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aqJ() {
        try {
            this.cKq.reenableKeyguard();
            f.aqB().cJW++;
            if (this.cKp != null) {
                this.cKp.release();
                this.cKp = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aqK() {
        try {
            if (this.cKp == null) {
                this.cKp = this.cKo.newWakeLock(268435462, "ScreenLockNotify");
                this.cKp.setReferenceCounted(false);
            }
            if (this.cKp != null) {
                this.cKp.acquire(10000L);
                this.cKq.disableKeyguard();
                f.aqB().cJT = 0;
                f.aqB().cJX++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aqL() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.cJP, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.cKo.isScreenOn();
    }
}
