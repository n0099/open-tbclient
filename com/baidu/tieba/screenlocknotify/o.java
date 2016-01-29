package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private PowerManager dHL;
    private PowerManager.WakeLock dHM;
    private KeyguardManager.KeyguardLock dHN;
    private KeyguardManager dHn;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.dHL = (PowerManager) this.mContext.getSystemService("power");
            this.dHM = this.dHL.newWakeLock(268435462, "ScreenLockNotify");
            this.dHM.setReferenceCounted(false);
            this.dHn = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.dHN = this.dHn.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aGd() {
        try {
            this.dHN.reenableKeyguard();
            f.aFV().dHu++;
            if (this.dHM != null) {
                this.dHM.release();
                this.dHM = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aGe() {
        try {
            if (this.dHM == null) {
                this.dHM = this.dHL.newWakeLock(268435462, "ScreenLockNotify");
                this.dHM.setReferenceCounted(false);
            }
            if (this.dHM != null) {
                this.dHM.acquire(10000L);
                this.dHN.disableKeyguard();
                f.aFV().dHr = 0;
                f.aFV().dHv++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aGf() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.dHn, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.dHL.isScreenOn();
    }
}
