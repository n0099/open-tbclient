package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private KeyguardManager ecO;
    private PowerManager edm;
    private PowerManager.WakeLock edn;
    private KeyguardManager.KeyguardLock edo;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m11getInst().getApp();
            this.edm = (PowerManager) this.mContext.getSystemService("power");
            this.edn = this.edm.newWakeLock(268435462, "ScreenLockNotify");
            this.edn.setReferenceCounted(false);
            this.ecO = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.edo = this.ecO.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aMX() {
        try {
            this.edo.reenableKeyguard();
            f.aMP().ecV++;
            if (this.edn != null) {
                this.edn.release();
                this.edn = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aMY() {
        try {
            if (this.edn == null) {
                this.edn = this.edm.newWakeLock(268435462, "ScreenLockNotify");
                this.edn.setReferenceCounted(false);
            }
            if (this.edn != null) {
                this.edn.acquire(10000L);
                this.edo.disableKeyguard();
                f.aMP().ecS = 0;
                f.aMP().ecW++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aMZ() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.ecO, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.edm.isScreenOn();
    }
}
