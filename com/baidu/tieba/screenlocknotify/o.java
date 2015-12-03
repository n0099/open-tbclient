package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private PowerManager.WakeLock dkA;
    private KeyguardManager.KeyguardLock dkB;
    private KeyguardManager dkb;
    private PowerManager dkz;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.dkz = (PowerManager) this.mContext.getSystemService("power");
            this.dkA = this.dkz.newWakeLock(268435462, "ScreenLockNotify");
            this.dkA.setReferenceCounted(false);
            this.dkb = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.dkB = this.dkb.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void awP() {
        try {
            this.dkB.reenableKeyguard();
            f.awH().dki++;
            if (this.dkA != null) {
                this.dkA.release();
                this.dkA = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void awQ() {
        try {
            if (this.dkA == null) {
                this.dkA = this.dkz.newWakeLock(268435462, "ScreenLockNotify");
                this.dkA.setReferenceCounted(false);
            }
            if (this.dkA != null) {
                this.dkA.acquire(10000L);
                this.dkB.disableKeyguard();
                f.awH().dkf = 0;
                f.awH().dkj++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean awR() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.dkb, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.dkz.isScreenOn();
    }
}
