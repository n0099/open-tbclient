package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private PowerManager.WakeLock gKA;
    private KeyguardManager.KeyguardLock gKB;
    private KeyguardManager gKy;
    private PowerManager gKz;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gKz = (PowerManager) this.mContext.getSystemService(Constants.HTTP_POWER);
            this.gKA = this.gKz.newWakeLock(268435462, "ScreenLockNotify");
            this.gKA.setReferenceCounted(false);
            this.gKy = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gKB = this.gKy.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bpE() {
        try {
            this.gKB.reenableKeyguard();
            a.bpz().gKn++;
            if (this.gKA != null) {
                this.gKA.release();
                this.gKA = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bpF() {
        try {
            if (this.gKA == null) {
                this.gKA = this.gKz.newWakeLock(268435462, "ScreenLockNotify");
                this.gKA.setReferenceCounted(false);
            }
            if (this.gKA != null) {
                this.gKA.acquire(10000L);
                this.gKB.disableKeyguard();
                a.bpz().gKk = 0;
                a.bpz().gKo++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bpG() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gKy, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gKz.isScreenOn();
    }
}
