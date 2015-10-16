package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private PowerManager cKN;
    private PowerManager.WakeLock cKO;
    private KeyguardManager.KeyguardLock cKP;
    private KeyguardManager cKo;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.cKN = (PowerManager) this.mContext.getSystemService("power");
            this.cKO = this.cKN.newWakeLock(268435462, "ScreenLockNotify");
            this.cKO.setReferenceCounted(false);
            this.cKo = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.cKP = this.cKo.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aqP() {
        try {
            this.cKP.reenableKeyguard();
            f.aqH().cKv++;
            if (this.cKO != null) {
                this.cKO.release();
                this.cKO = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aqQ() {
        try {
            if (this.cKO == null) {
                this.cKO = this.cKN.newWakeLock(268435462, "ScreenLockNotify");
                this.cKO.setReferenceCounted(false);
            }
            if (this.cKO != null) {
                this.cKO.acquire(10000L);
                this.cKP.disableKeyguard();
                f.aqH().cKs = 0;
                f.aqH().cKw++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aqR() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.cKo, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.cKN.isScreenOn();
    }
}
