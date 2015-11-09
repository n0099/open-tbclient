package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private KeyguardManager cLK;
    private PowerManager cMj;
    private PowerManager.WakeLock cMk;
    private KeyguardManager.KeyguardLock cMl;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.cMj = (PowerManager) this.mContext.getSystemService("power");
            this.cMk = this.cMj.newWakeLock(268435462, "ScreenLockNotify");
            this.cMk.setReferenceCounted(false);
            this.cLK = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.cMl = this.cLK.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void arr() {
        try {
            this.cMl.reenableKeyguard();
            f.arj().cLR++;
            if (this.cMk != null) {
                this.cMk.release();
                this.cMk = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ars() {
        try {
            if (this.cMk == null) {
                this.cMk = this.cMj.newWakeLock(268435462, "ScreenLockNotify");
                this.cMk.setReferenceCounted(false);
            }
            if (this.cMk != null) {
                this.cMk.acquire(10000L);
                this.cMl.disableKeyguard();
                f.arj().cLO = 0;
                f.arj().cLS++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean art() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.cLK, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.cMj.isScreenOn();
    }
}
