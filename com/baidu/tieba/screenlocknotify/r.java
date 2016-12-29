package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r {
    private KeyguardManager eQB;
    private PowerManager eQS;
    private PowerManager.WakeLock eQT;
    private KeyguardManager.KeyguardLock eQU;
    private Context mContext;

    public r() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.eQS = (PowerManager) this.mContext.getSystemService("power");
            this.eQT = this.eQS.newWakeLock(268435462, "ScreenLockNotify");
            this.eQT.setReferenceCounted(false);
            this.eQB = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.eQU = this.eQB.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aYR() {
        try {
            this.eQU.reenableKeyguard();
            i.aYM().eQH++;
            if (this.eQT != null) {
                this.eQT.release();
                this.eQT = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aYS() {
        try {
            if (this.eQT == null) {
                this.eQT = this.eQS.newWakeLock(268435462, "ScreenLockNotify");
                this.eQT.setReferenceCounted(false);
            }
            if (this.eQT != null) {
                this.eQT.acquire(10000L);
                this.eQU.disableKeyguard();
                i.aYM().eQE = 0;
                i.aYM().eQI++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aYT() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.eQB, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.eQS.isScreenOn();
    }
}
