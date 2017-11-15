package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fRY;
    private PowerManager fRZ;
    private PowerManager.WakeLock fSa;
    private KeyguardManager.KeyguardLock fSb;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fRZ = (PowerManager) this.mContext.getSystemService("power");
            this.fSa = this.fRZ.newWakeLock(268435462, "ScreenLockNotify");
            this.fSa.setReferenceCounted(false);
            this.fRY = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fSb = this.fRY.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bkz() {
        try {
            this.fSb.reenableKeyguard();
            a.bku().fRN++;
            if (this.fSa != null) {
                this.fSa.release();
                this.fSa = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bkA() {
        try {
            if (this.fSa == null) {
                this.fSa = this.fRZ.newWakeLock(268435462, "ScreenLockNotify");
                this.fSa.setReferenceCounted(false);
            }
            if (this.fSa != null) {
                this.fSa.acquire(10000L);
                this.fSb.disableKeyguard();
                a.bku().fRK = 0;
                a.bku().fRO++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bkB() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fRY, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fRZ.isScreenOn();
    }
}
