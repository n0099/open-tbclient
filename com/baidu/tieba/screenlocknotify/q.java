package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class q {
    private KeyguardManager bYI;
    private PowerManager bZc;
    private PowerManager.WakeLock bZd;
    private KeyguardManager.KeyguardLock bZe;
    private Context mContext;

    public q() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.bZc = (PowerManager) this.mContext.getSystemService("power");
            this.bZd = this.bZc.newWakeLock(268435462, "ScreenLockNotify");
            this.bZd.setReferenceCounted(false);
            this.bYI = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.bZe = this.bYI.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void afZ() {
        try {
            this.bZe.reenableKeyguard();
            f.agc().bYQ++;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.bZd != null) {
            this.bZd.release();
            this.bZd = null;
        }
    }

    public void afY() {
        try {
            if (this.bZd == null) {
                this.bZd = this.bZc.newWakeLock(268435462, "ScreenLockNotify");
                this.bZd.setReferenceCounted(false);
            }
            if (this.bZd != null) {
                this.bZd.acquire(10000L);
                this.bZe.disableKeyguard();
                f.agc().bYN = 0;
                f.agc().bYR++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean agi() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.bYI, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.bZc.isScreenOn();
    }
}
