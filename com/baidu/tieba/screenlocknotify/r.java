package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r {
    private PowerManager fiD;
    private PowerManager.WakeLock fiE;
    private KeyguardManager.KeyguardLock fiF;
    private KeyguardManager fil;
    private Context mContext;

    public r() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.fiD = (PowerManager) this.mContext.getSystemService("power");
            this.fiE = this.fiD.newWakeLock(268435462, "ScreenLockNotify");
            this.fiE.setReferenceCounted(false);
            this.fil = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fiF = this.fil.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bcb() {
        try {
            this.fiF.reenableKeyguard();
            i.bbW().fir++;
            if (this.fiE != null) {
                this.fiE.release();
                this.fiE = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bcc() {
        try {
            if (this.fiE == null) {
                this.fiE = this.fiD.newWakeLock(268435462, "ScreenLockNotify");
                this.fiE.setReferenceCounted(false);
            }
            if (this.fiE != null) {
                this.fiE.acquire(10000L);
                this.fiF.disableKeyguard();
                i.bbW().fio = 0;
                i.bbW().fis++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bcd() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fil, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fiD.isScreenOn();
    }
}
