package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fQW;
    private PowerManager fQX;
    private PowerManager.WakeLock fQY;
    private KeyguardManager.KeyguardLock fQZ;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fQX = (PowerManager) this.mContext.getSystemService("power");
            this.fQY = this.fQX.newWakeLock(268435462, "ScreenLockNotify");
            this.fQY.setReferenceCounted(false);
            this.fQW = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fQZ = this.fQW.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bko() {
        try {
            this.fQZ.reenableKeyguard();
            a.bkj().fQL++;
            if (this.fQY != null) {
                this.fQY.release();
                this.fQY = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bkp() {
        try {
            if (this.fQY == null) {
                this.fQY = this.fQX.newWakeLock(268435462, "ScreenLockNotify");
                this.fQY.setReferenceCounted(false);
            }
            if (this.fQY != null) {
                this.fQY.acquire(10000L);
                this.fQZ.disableKeyguard();
                a.bkj().fQI = 0;
                a.bkj().fQM++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bkq() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fQW, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fQX.isScreenOn();
    }
}
