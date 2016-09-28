package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private PowerManager ffO;
    private PowerManager.WakeLock ffP;
    private KeyguardManager.KeyguardLock ffQ;
    private KeyguardManager ffq;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.ffO = (PowerManager) this.mContext.getSystemService("power");
            this.ffP = this.ffO.newWakeLock(268435462, "ScreenLockNotify");
            this.ffP.setReferenceCounted(false);
            this.ffq = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.ffQ = this.ffq.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bcE() {
        try {
            this.ffQ.reenableKeyguard();
            f.bcw().ffx++;
            if (this.ffP != null) {
                this.ffP.release();
                this.ffP = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bcF() {
        try {
            if (this.ffP == null) {
                this.ffP = this.ffO.newWakeLock(268435462, "ScreenLockNotify");
                this.ffP.setReferenceCounted(false);
            }
            if (this.ffP != null) {
                this.ffP.acquire(10000L);
                this.ffQ.disableKeyguard();
                f.bcw().ffu = 0;
                f.bcw().ffy++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bcG() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.ffq, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.ffO.isScreenOn();
    }
}
