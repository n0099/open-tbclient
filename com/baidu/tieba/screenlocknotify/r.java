package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class r {
    private KeyguardManager fwD;
    private PowerManager fwE;
    private PowerManager.WakeLock fwF;
    private KeyguardManager.KeyguardLock fwG;
    private Context mContext;

    public r() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.fwE = (PowerManager) this.mContext.getSystemService("power");
            this.fwF = this.fwE.newWakeLock(268435462, "ScreenLockNotify");
            this.fwF.setReferenceCounted(false);
            this.fwD = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fwG = this.fwD.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bfj() {
        try {
            this.fwG.reenableKeyguard();
            i.bfe().fws++;
            if (this.fwF != null) {
                this.fwF.release();
                this.fwF = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bfk() {
        try {
            if (this.fwF == null) {
                this.fwF = this.fwE.newWakeLock(268435462, "ScreenLockNotify");
                this.fwF.setReferenceCounted(false);
            }
            if (this.fwF != null) {
                this.fwF.acquire(10000L);
                this.fwG.disableKeyguard();
                i.bfe().fwp = 0;
                i.bfe().fwt++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bfl() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fwD, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fwE.isScreenOn();
    }
}
