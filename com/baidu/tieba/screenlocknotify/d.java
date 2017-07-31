package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fKZ;
    private PowerManager fLa;
    private PowerManager.WakeLock fLb;
    private KeyguardManager.KeyguardLock fLc;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fLa = (PowerManager) this.mContext.getSystemService("power");
            this.fLb = this.fLa.newWakeLock(268435462, "ScreenLockNotify");
            this.fLb.setReferenceCounted(false);
            this.fKZ = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fLc = this.fKZ.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void biU() {
        try {
            this.fLc.reenableKeyguard();
            a.biP().fKO++;
            if (this.fLb != null) {
                this.fLb.release();
                this.fLb = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void biV() {
        try {
            if (this.fLb == null) {
                this.fLb = this.fLa.newWakeLock(268435462, "ScreenLockNotify");
                this.fLb.setReferenceCounted(false);
            }
            if (this.fLb != null) {
                this.fLb.acquire(10000L);
                this.fLc.disableKeyguard();
                a.biP().fKL = 0;
                a.biP().fKP++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean biW() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fKZ, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fLa.isScreenOn();
    }
}
