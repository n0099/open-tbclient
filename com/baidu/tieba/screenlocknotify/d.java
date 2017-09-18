package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fLL;
    private PowerManager fLM;
    private PowerManager.WakeLock fLN;
    private KeyguardManager.KeyguardLock fLO;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fLM = (PowerManager) this.mContext.getSystemService("power");
            this.fLN = this.fLM.newWakeLock(268435462, "ScreenLockNotify");
            this.fLN.setReferenceCounted(false);
            this.fLL = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fLO = this.fLL.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void biF() {
        try {
            this.fLO.reenableKeyguard();
            a.biA().fLA++;
            if (this.fLN != null) {
                this.fLN.release();
                this.fLN = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void biG() {
        try {
            if (this.fLN == null) {
                this.fLN = this.fLM.newWakeLock(268435462, "ScreenLockNotify");
                this.fLN.setReferenceCounted(false);
            }
            if (this.fLN != null) {
                this.fLN.acquire(10000L);
                this.fLO.disableKeyguard();
                a.biA().fLx = 0;
                a.biA().fLB++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean biH() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fLL, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fLM.isScreenOn();
    }
}
