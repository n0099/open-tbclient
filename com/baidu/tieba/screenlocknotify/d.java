package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fKS;
    private PowerManager fKT;
    private PowerManager.WakeLock fKU;
    private KeyguardManager.KeyguardLock fKV;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fKT = (PowerManager) this.mContext.getSystemService("power");
            this.fKU = this.fKT.newWakeLock(268435462, "ScreenLockNotify");
            this.fKU.setReferenceCounted(false);
            this.fKS = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fKV = this.fKS.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void biu() {
        try {
            this.fKV.reenableKeyguard();
            a.bip().fKH++;
            if (this.fKU != null) {
                this.fKU.release();
                this.fKU = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void biv() {
        try {
            if (this.fKU == null) {
                this.fKU = this.fKT.newWakeLock(268435462, "ScreenLockNotify");
                this.fKU.setReferenceCounted(false);
            }
            if (this.fKU != null) {
                this.fKU.acquire(10000L);
                this.fKV.disableKeyguard();
                a.bip().fKE = 0;
                a.bip().fKI++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean biw() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fKS, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fKT.isScreenOn();
    }
}
