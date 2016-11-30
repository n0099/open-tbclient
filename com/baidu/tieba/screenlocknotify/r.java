package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r {
    private KeyguardManager fmG;
    private PowerManager fmX;
    private PowerManager.WakeLock fmY;
    private KeyguardManager.KeyguardLock fmZ;
    private Context mContext;

    public r() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.fmX = (PowerManager) this.mContext.getSystemService("power");
            this.fmY = this.fmX.newWakeLock(268435462, "ScreenLockNotify");
            this.fmY.setReferenceCounted(false);
            this.fmG = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fmZ = this.fmG.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bfc() {
        try {
            this.fmZ.reenableKeyguard();
            i.beX().fmM++;
            if (this.fmY != null) {
                this.fmY.release();
                this.fmY = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bfd() {
        try {
            if (this.fmY == null) {
                this.fmY = this.fmX.newWakeLock(268435462, "ScreenLockNotify");
                this.fmY.setReferenceCounted(false);
            }
            if (this.fmY != null) {
                this.fmY.acquire(10000L);
                this.fmZ.disableKeyguard();
                i.beX().fmJ = 0;
                i.beX().fmN++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bfe() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fmG, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fmX.isScreenOn();
    }
}
