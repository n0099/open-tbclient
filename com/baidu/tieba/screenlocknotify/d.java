package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fMT;
    private PowerManager fMU;
    private PowerManager.WakeLock fMV;
    private KeyguardManager.KeyguardLock fMW;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fMU = (PowerManager) this.mContext.getSystemService("power");
            this.fMV = this.fMU.newWakeLock(268435462, "ScreenLockNotify");
            this.fMV.setReferenceCounted(false);
            this.fMT = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fMW = this.fMT.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bjA() {
        try {
            this.fMW.reenableKeyguard();
            a.bjv().fMI++;
            if (this.fMV != null) {
                this.fMV.release();
                this.fMV = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bjB() {
        try {
            if (this.fMV == null) {
                this.fMV = this.fMU.newWakeLock(268435462, "ScreenLockNotify");
                this.fMV.setReferenceCounted(false);
            }
            if (this.fMV != null) {
                this.fMV.acquire(10000L);
                this.fMW.disableKeyguard();
                a.bjv().fMF = 0;
                a.bjv().fMJ++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bjC() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fMT, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fMU.isScreenOn();
    }
}
