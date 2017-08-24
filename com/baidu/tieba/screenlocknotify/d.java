package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fMU;
    private PowerManager fMV;
    private PowerManager.WakeLock fMW;
    private KeyguardManager.KeyguardLock fMX;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fMV = (PowerManager) this.mContext.getSystemService("power");
            this.fMW = this.fMV.newWakeLock(268435462, "ScreenLockNotify");
            this.fMW.setReferenceCounted(false);
            this.fMU = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fMX = this.fMU.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bjv() {
        try {
            this.fMX.reenableKeyguard();
            a.bjq().fMJ++;
            if (this.fMW != null) {
                this.fMW.release();
                this.fMW = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bjw() {
        try {
            if (this.fMW == null) {
                this.fMW = this.fMV.newWakeLock(268435462, "ScreenLockNotify");
                this.fMW.setReferenceCounted(false);
            }
            if (this.fMW != null) {
                this.fMW.acquire(10000L);
                this.fMX.disableKeyguard();
                a.bjq().fMG = 0;
                a.bjq().fMK++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bjx() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fMU, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fMV.isScreenOn();
    }
}
