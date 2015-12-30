package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class o {
    private PowerManager drH;
    private PowerManager.WakeLock drI;
    private KeyguardManager.KeyguardLock drJ;
    private KeyguardManager drj;
    private Context mContext;

    public o() {
        try {
            this.mContext = TbadkCoreApplication.m411getInst().getApp();
            this.drH = (PowerManager) this.mContext.getSystemService("power");
            this.drI = this.drH.newWakeLock(268435462, "ScreenLockNotify");
            this.drI.setReferenceCounted(false);
            this.drj = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.drJ = this.drj.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ayW() {
        try {
            this.drJ.reenableKeyguard();
            f.ayO().drq++;
            if (this.drI != null) {
                this.drI.release();
                this.drI = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ayX() {
        try {
            if (this.drI == null) {
                this.drI = this.drH.newWakeLock(268435462, "ScreenLockNotify");
                this.drI.setReferenceCounted(false);
            }
            if (this.drI != null) {
                this.drI.acquire(10000L);
                this.drJ.disableKeyguard();
                f.ayO().drn = 0;
                f.ayO().drr++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean ayY() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.drj, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.drH.isScreenOn();
    }
}
