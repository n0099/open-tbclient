package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private PowerManager gKA;
    private PowerManager.WakeLock gKB;
    private KeyguardManager.KeyguardLock gKC;
    private KeyguardManager gKz;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gKA = (PowerManager) this.mContext.getSystemService(Constants.HTTP_POWER);
            this.gKB = this.gKA.newWakeLock(268435462, "ScreenLockNotify");
            this.gKB.setReferenceCounted(false);
            this.gKz = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gKC = this.gKz.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bpE() {
        try {
            this.gKC.reenableKeyguard();
            a.bpz().gKo++;
            if (this.gKB != null) {
                this.gKB.release();
                this.gKB = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bpF() {
        try {
            if (this.gKB == null) {
                this.gKB = this.gKA.newWakeLock(268435462, "ScreenLockNotify");
                this.gKB.setReferenceCounted(false);
            }
            if (this.gKB != null) {
                this.gKB.acquire(10000L);
                this.gKC.disableKeyguard();
                a.bpz().gKl = 0;
                a.bpz().gKp++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bpG() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gKz, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gKA.isScreenOn();
    }
}
