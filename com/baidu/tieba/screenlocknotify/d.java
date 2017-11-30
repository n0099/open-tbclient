package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager gbE;
    private PowerManager gbF;
    private PowerManager.WakeLock gbG;
    private KeyguardManager.KeyguardLock gbH;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gbF = (PowerManager) this.mContext.getSystemService("power");
            this.gbG = this.gbF.newWakeLock(268435462, "ScreenLockNotify");
            this.gbG.setReferenceCounted(false);
            this.gbE = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gbH = this.gbE.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bmz() {
        try {
            this.gbH.reenableKeyguard();
            a.bmu().gbt++;
            if (this.gbG != null) {
                this.gbG.release();
                this.gbG = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bmA() {
        try {
            if (this.gbG == null) {
                this.gbG = this.gbF.newWakeLock(268435462, "ScreenLockNotify");
                this.gbG.setReferenceCounted(false);
            }
            if (this.gbG != null) {
                this.gbG.acquire(10000L);
                this.gbH.disableKeyguard();
                a.bmu().gbq = 0;
                a.bmu().gbu++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bmB() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gbE, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gbF.isScreenOn();
    }
}
