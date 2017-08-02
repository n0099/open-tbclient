package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fJN;
    private PowerManager fJO;
    private PowerManager.WakeLock fJP;
    private KeyguardManager.KeyguardLock fJQ;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fJO = (PowerManager) this.mContext.getSystemService("power");
            this.fJP = this.fJO.newWakeLock(268435462, "ScreenLockNotify");
            this.fJP.setReferenceCounted(false);
            this.fJN = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fJQ = this.fJN.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void biK() {
        try {
            this.fJQ.reenableKeyguard();
            a.biF().fJC++;
            if (this.fJP != null) {
                this.fJP.release();
                this.fJP = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void biL() {
        try {
            if (this.fJP == null) {
                this.fJP = this.fJO.newWakeLock(268435462, "ScreenLockNotify");
                this.fJP.setReferenceCounted(false);
            }
            if (this.fJP != null) {
                this.fJP.acquire(10000L);
                this.fJQ.disableKeyguard();
                a.biF().fJz = 0;
                a.biF().fJD++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean biM() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fJN, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fJO.isScreenOn();
    }
}
