package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private PowerManager cuR;
    private PowerManager.WakeLock cuS;
    private KeyguardManager.KeyguardLock cuT;
    private KeyguardManager cut;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.cuR = (PowerManager) this.mContext.getSystemService("power");
            this.cuS = this.cuR.newWakeLock(268435462, "ScreenLockNotify");
            this.cuS.setReferenceCounted(false);
            this.cut = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.cuT = this.cut.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void akk() {
        try {
            this.cuT.reenableKeyguard();
            g.akd().cuA++;
            if (this.cuS != null) {
                this.cuS.release();
                this.cuS = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void akl() {
        try {
            if (this.cuS == null) {
                this.cuS = this.cuR.newWakeLock(268435462, "ScreenLockNotify");
                this.cuS.setReferenceCounted(false);
            }
            if (this.cuS != null) {
                this.cuS.acquire(10000L);
                this.cuT.disableKeyguard();
                g.akd().cux = 0;
                g.akd().cuB++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean akm() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.cut, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.cuR.isScreenOn();
    }
}
