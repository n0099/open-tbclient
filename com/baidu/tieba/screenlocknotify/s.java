package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class s {
    private PowerManager bMH;
    private PowerManager.WakeLock bMI;
    private KeyguardManager.KeyguardLock bMJ;
    private KeyguardManager bMo;
    private Context mContext;

    public s() {
        try {
            this.mContext = TbadkApplication.getInst().getApp();
            this.bMH = (PowerManager) this.mContext.getSystemService("power");
            this.bMI = this.bMH.newWakeLock(268435462, "ScreenLockNotify");
            this.bMI.setReferenceCounted(false);
            this.bMo = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.bMJ = this.bMo.newKeyguardLock("ScreenLockUtils");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aca() {
        try {
            this.bMJ.reenableKeyguard();
            f.acd().bMw++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.bMI != null) {
            this.bMI.release();
            this.bMI = null;
        }
    }

    public void acj() {
        if (this.bMI == null) {
            this.bMI = this.bMH.newWakeLock(268435462, "ScreenLockNotify");
            this.bMI.setReferenceCounted(false);
        }
        if (this.bMI != null) {
            this.bMI.acquire(10000L);
            this.bMJ.disableKeyguard();
            f.acd().bMt = 0;
            f.acd().bMx++;
        }
    }
}
