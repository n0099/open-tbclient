package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r {
    private PowerManager feJ;
    private PowerManager.WakeLock feK;
    private KeyguardManager.KeyguardLock feL;
    private KeyguardManager fes;
    private Context mContext;

    public r() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.feJ = (PowerManager) this.mContext.getSystemService("power");
            this.feK = this.feJ.newWakeLock(268435462, "ScreenLockNotify");
            this.feK.setReferenceCounted(false);
            this.fes = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.feL = this.fes.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bar() {
        try {
            this.feL.reenableKeyguard();
            i.bam().fey++;
            if (this.feK != null) {
                this.feK.release();
                this.feK = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bas() {
        try {
            if (this.feK == null) {
                this.feK = this.feJ.newWakeLock(268435462, "ScreenLockNotify");
                this.feK.setReferenceCounted(false);
            }
            if (this.feK != null) {
                this.feK.acquire(10000L);
                this.feL.disableKeyguard();
                i.bam().fev = 0;
                i.bam().fez++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bat() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fes, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.feJ.isScreenOn();
    }
}
