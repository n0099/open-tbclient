package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class q {
    private KeyguardManager ccU;
    private PowerManager cdn;
    private PowerManager.WakeLock cdo;
    private KeyguardManager.KeyguardLock cdp;
    private Context mContext;

    public q() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.cdn = (PowerManager) this.mContext.getSystemService("power");
            this.cdo = this.cdn.newWakeLock(268435462, "ScreenLockNotify");
            this.cdo.setReferenceCounted(false);
            this.ccU = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.cdp = this.ccU.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ahV() {
        try {
            this.cdp.reenableKeyguard();
            f.ahP().cdb++;
            if (this.cdo != null) {
                this.cdo.release();
                this.cdo = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ahW() {
        try {
            if (this.cdo == null) {
                this.cdo = this.cdn.newWakeLock(268435462, "ScreenLockNotify");
                this.cdo.setReferenceCounted(false);
            }
            if (this.cdo != null) {
                this.cdo.acquire(10000L);
                this.cdp.disableKeyguard();
                f.ahP().ccY = 0;
                f.ahP().cdc++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean ahX() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.ccU, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.cdn.isScreenOn();
    }
}
