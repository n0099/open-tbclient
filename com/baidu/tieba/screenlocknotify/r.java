package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class r {
    private KeyguardManager.KeyguardLock feA;
    private KeyguardManager fex;
    private PowerManager fey;
    private PowerManager.WakeLock fez;
    private Context mContext;

    public r() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.fey = (PowerManager) this.mContext.getSystemService("power");
            this.fez = this.fey.newWakeLock(268435462, "ScreenLockNotify");
            this.fez.setReferenceCounted(false);
            this.fex = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.feA = this.fex.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aZA() {
        try {
            this.feA.reenableKeyguard();
            i.aZv().fem++;
            if (this.fez != null) {
                this.fez.release();
                this.fez = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void aZB() {
        try {
            if (this.fez == null) {
                this.fez = this.fey.newWakeLock(268435462, "ScreenLockNotify");
                this.fez.setReferenceCounted(false);
            }
            if (this.fez != null) {
                this.fez.acquire(10000L);
                this.feA.disableKeyguard();
                i.aZv().fej = 0;
                i.aZv().fen++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean aZC() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fex, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fey.isScreenOn();
    }
}
