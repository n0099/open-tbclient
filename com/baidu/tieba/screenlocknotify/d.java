package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private PowerManager gfA;
    private PowerManager.WakeLock gfB;
    private KeyguardManager.KeyguardLock gfC;
    private KeyguardManager gfz;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gfA = (PowerManager) this.mContext.getSystemService(Constants.HTTP_POWER);
            this.gfB = this.gfA.newWakeLock(268435462, "ScreenLockNotify");
            this.gfB.setReferenceCounted(false);
            this.gfz = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gfC = this.gfz.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bkL() {
        try {
            this.gfC.reenableKeyguard();
            a.bkG().gfo++;
            if (this.gfB != null) {
                this.gfB.release();
                this.gfB = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bkM() {
        try {
            if (this.gfB == null) {
                this.gfB = this.gfA.newWakeLock(268435462, "ScreenLockNotify");
                this.gfB.setReferenceCounted(false);
            }
            if (this.gfB != null) {
                this.gfB.acquire(10000L);
                this.gfC.disableKeyguard();
                a.bkG().gfl = 0;
                a.bkG().gfp++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bkN() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gfz, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gfA.isScreenOn();
    }
}
