package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class r {
    private KeyguardManager fmp;
    private PowerManager fmq;
    private PowerManager.WakeLock fmr;
    private KeyguardManager.KeyguardLock fms;
    private Context mContext;

    public r() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.fmq = (PowerManager) this.mContext.getSystemService("power");
            this.fmr = this.fmq.newWakeLock(268435462, "ScreenLockNotify");
            this.fmr.setReferenceCounted(false);
            this.fmp = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fms = this.fmp.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void baU() {
        try {
            this.fms.reenableKeyguard();
            i.baP().fme++;
            if (this.fmr != null) {
                this.fmr.release();
                this.fmr = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void baV() {
        try {
            if (this.fmr == null) {
                this.fmr = this.fmq.newWakeLock(268435462, "ScreenLockNotify");
                this.fmr.setReferenceCounted(false);
            }
            if (this.fmr != null) {
                this.fmr.acquire(10000L);
                this.fms.disableKeyguard();
                i.baP().fmb = 0;
                i.baP().fmf++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean baW() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fmp, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fmq.isScreenOn();
    }
}
