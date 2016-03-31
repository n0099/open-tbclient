package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private KeyguardManager dZH;
    private PowerManager eaf;
    private PowerManager.WakeLock eag;
    private KeyguardManager.KeyguardLock eah;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.eaf = (PowerManager) this.mContext.getSystemService("power");
            this.eag = this.eaf.newWakeLock(268435462, "ScreenLockNotify");
            this.eag.setReferenceCounted(false);
            this.dZH = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.eah = this.dZH.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aMN() {
        try {
            this.eah.reenableKeyguard();
            f.aMF().dZO++;
            if (this.eag != null) {
                this.eag.release();
                this.eag = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aMO() {
        try {
            if (this.eag == null) {
                this.eag = this.eaf.newWakeLock(268435462, "ScreenLockNotify");
                this.eag.setReferenceCounted(false);
            }
            if (this.eag != null) {
                this.eag.acquire(10000L);
                this.eah.disableKeyguard();
                f.aMF().dZL = 0;
                f.aMF().dZP++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aMP() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.dZH, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.eaf.isScreenOn();
    }
}
