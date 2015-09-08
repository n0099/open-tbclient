package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private KeyguardManager cCO;
    private PowerManager cDn;
    private PowerManager.WakeLock cDo;
    private KeyguardManager.KeyguardLock cDp;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.cDn = (PowerManager) this.mContext.getSystemService("power");
            this.cDo = this.cDn.newWakeLock(268435462, "ScreenLockNotify");
            this.cDo.setReferenceCounted(false);
            this.cCO = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.cDp = this.cCO.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aor() {
        try {
            this.cDp.reenableKeyguard();
            f.aoj().cCV++;
            if (this.cDo != null) {
                this.cDo.release();
                this.cDo = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aos() {
        try {
            if (this.cDo == null) {
                this.cDo = this.cDn.newWakeLock(268435462, "ScreenLockNotify");
                this.cDo.setReferenceCounted(false);
            }
            if (this.cDo != null) {
                this.cDo.acquire(10000L);
                this.cDp.disableKeyguard();
                f.aoj().cCS = 0;
                f.aoj().cCW++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aot() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.cCO, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.cDn.isScreenOn();
    }
}
