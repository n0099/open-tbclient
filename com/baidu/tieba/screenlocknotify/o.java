package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private PowerManager eUU;
    private PowerManager.WakeLock eUV;
    private KeyguardManager.KeyguardLock eUW;
    private KeyguardManager eUw;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m10getInst().getApp();
            this.eUU = (PowerManager) this.mContext.getSystemService("power");
            this.eUV = this.eUU.newWakeLock(268435462, "ScreenLockNotify");
            this.eUV.setReferenceCounted(false);
            this.eUw = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.eUW = this.eUw.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aYs() {
        try {
            this.eUW.reenableKeyguard();
            f.aYk().eUD++;
            if (this.eUV != null) {
                this.eUV.release();
                this.eUV = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aYt() {
        try {
            if (this.eUV == null) {
                this.eUV = this.eUU.newWakeLock(268435462, "ScreenLockNotify");
                this.eUV.setReferenceCounted(false);
            }
            if (this.eUV != null) {
                this.eUV.acquire(10000L);
                this.eUW.disableKeyguard();
                f.aYk().eUA = 0;
                f.aYk().eUE++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aYu() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.eUw, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.eUU.isScreenOn();
    }
}
