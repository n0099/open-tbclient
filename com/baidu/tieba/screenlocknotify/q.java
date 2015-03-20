package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class q {
    private PowerManager bYN;
    private PowerManager.WakeLock bYO;
    private KeyguardManager.KeyguardLock bYP;
    private KeyguardManager bYt;
    private Context mContext;

    public q() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.bYN = (PowerManager) this.mContext.getSystemService("power");
            this.bYO = this.bYN.newWakeLock(268435462, "ScreenLockNotify");
            this.bYO.setReferenceCounted(false);
            this.bYt = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.bYP = this.bYt.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void afK() {
        try {
            this.bYP.reenableKeyguard();
            f.afN().bYB++;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.bYO != null) {
            this.bYO.release();
            this.bYO = null;
        }
    }

    public void afJ() {
        try {
            if (this.bYO == null) {
                this.bYO = this.bYN.newWakeLock(268435462, "ScreenLockNotify");
                this.bYO.setReferenceCounted(false);
            }
            if (this.bYO != null) {
                this.bYO.acquire(10000L);
                this.bYP.disableKeyguard();
                f.afN().bYy = 0;
                f.afN().bYC++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean afT() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.bYt, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.bYN.isScreenOn();
    }
}
