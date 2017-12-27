package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager gSp;
    private PowerManager gSq;
    private PowerManager.WakeLock gSr;
    private KeyguardManager.KeyguardLock gSs;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gSq = (PowerManager) this.mContext.getSystemService("power");
            this.gSr = this.gSq.newWakeLock(268435462, "ScreenLockNotify");
            this.gSr.setReferenceCounted(false);
            this.gSp = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gSs = this.gSp.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void buN() {
        try {
            this.gSs.reenableKeyguard();
            a.buI().gSe++;
            if (this.gSr != null) {
                this.gSr.release();
                this.gSr = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void buO() {
        try {
            if (this.gSr == null) {
                this.gSr = this.gSq.newWakeLock(268435462, "ScreenLockNotify");
                this.gSr.setReferenceCounted(false);
            }
            if (this.gSr != null) {
                this.gSr.acquire(10000L);
                this.gSs.disableKeyguard();
                a.buI().gSb = 0;
                a.buI().gSf++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean buP() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gSp, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gSq.isScreenOn();
    }
}
