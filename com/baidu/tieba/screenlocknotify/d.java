package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private KeyguardManager grW;
    private PowerManager grX;
    private PowerManager.WakeLock grY;
    private KeyguardManager.KeyguardLock grZ;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.grX = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.grY = this.grX.newWakeLock(268435462, "ScreenLockNotify");
            this.grY.setReferenceCounted(false);
            this.grW = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.grZ = this.grW.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bpI() {
        try {
            this.grZ.reenableKeyguard();
            a.bpD().grL++;
            if (this.grY != null) {
                this.grY.release();
                this.grY = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bpJ() {
        try {
            if (this.grY == null) {
                this.grY = this.grX.newWakeLock(268435462, "ScreenLockNotify");
                this.grY.setReferenceCounted(false);
            }
            if (this.grY != null) {
                this.grY.acquire(10000L);
                this.grZ.disableKeyguard();
                a.bpD().grI = 0;
                a.bpD().grM++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bpK() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.grW, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.grX.isScreenOn();
    }
}
