package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class q {
    private KeyguardManager ccV;
    private PowerManager cdo;
    private PowerManager.WakeLock cdp;
    private KeyguardManager.KeyguardLock cdq;
    private Context mContext;

    public q() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.cdo = (PowerManager) this.mContext.getSystemService("power");
            this.cdp = this.cdo.newWakeLock(268435462, "ScreenLockNotify");
            this.cdp.setReferenceCounted(false);
            this.ccV = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.cdq = this.ccV.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ahW() {
        try {
            this.cdq.reenableKeyguard();
            f.ahQ().cdc++;
            if (this.cdp != null) {
                this.cdp.release();
                this.cdp = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ahX() {
        try {
            if (this.cdp == null) {
                this.cdp = this.cdo.newWakeLock(268435462, "ScreenLockNotify");
                this.cdp.setReferenceCounted(false);
            }
            if (this.cdp != null) {
                this.cdp.acquire(10000L);
                this.cdq.disableKeyguard();
                f.ahQ().ccZ = 0;
                f.ahQ().cdd++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean ahY() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.ccV, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.cdo.isScreenOn();
    }
}
