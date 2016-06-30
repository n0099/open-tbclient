package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private PowerManager eHS;
    private PowerManager.WakeLock eHT;
    private KeyguardManager.KeyguardLock eHU;
    private KeyguardManager eHu;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.eHS = (PowerManager) this.mContext.getSystemService("power");
            this.eHT = this.eHS.newWakeLock(268435462, "ScreenLockNotify");
            this.eHT.setReferenceCounted(false);
            this.eHu = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.eHU = this.eHu.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aVf() {
        try {
            this.eHU.reenableKeyguard();
            f.aUX().eHB++;
            if (this.eHT != null) {
                this.eHT.release();
                this.eHT = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aVg() {
        try {
            if (this.eHT == null) {
                this.eHT = this.eHS.newWakeLock(268435462, "ScreenLockNotify");
                this.eHT.setReferenceCounted(false);
            }
            if (this.eHT != null) {
                this.eHT.acquire(10000L);
                this.eHU.disableKeyguard();
                f.aUX().eHy = 0;
                f.aUX().eHC++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aVh() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.eHu, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.eHS.isScreenOn();
    }
}
