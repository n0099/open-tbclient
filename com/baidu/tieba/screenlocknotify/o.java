package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private KeyguardManager fcI;
    private PowerManager fdg;
    private PowerManager.WakeLock fdh;
    private KeyguardManager.KeyguardLock fdi;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.fdg = (PowerManager) this.mContext.getSystemService("power");
            this.fdh = this.fdg.newWakeLock(268435462, "ScreenLockNotify");
            this.fdh.setReferenceCounted(false);
            this.fcI = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fdi = this.fcI.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bbU() {
        try {
            this.fdi.reenableKeyguard();
            f.bbM().fcP++;
            if (this.fdh != null) {
                this.fdh.release();
                this.fdh = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bbV() {
        try {
            if (this.fdh == null) {
                this.fdh = this.fdg.newWakeLock(268435462, "ScreenLockNotify");
                this.fdh.setReferenceCounted(false);
            }
            if (this.fdh != null) {
                this.fdh.acquire(10000L);
                this.fdi.disableKeyguard();
                f.bbM().fcM = 0;
                f.bbM().fcQ++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bbW() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fcI, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fdg.isScreenOn();
    }
}
