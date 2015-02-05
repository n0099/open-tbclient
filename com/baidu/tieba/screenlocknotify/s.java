package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class s {
    private KeyguardManager bNX;
    private PowerManager bOq;
    private PowerManager.WakeLock bOr;
    private KeyguardManager.KeyguardLock bOs;
    private Context mContext;

    public s() {
        try {
            this.mContext = TbadkApplication.getInst().getApp();
            this.bOq = (PowerManager) this.mContext.getSystemService("power");
            this.bOr = this.bOq.newWakeLock(268435462, "ScreenLockNotify");
            this.bOr.setReferenceCounted(false);
            this.bNX = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.bOs = this.bNX.newKeyguardLock("ScreenLockUtils");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void acH() {
        try {
            this.bOs.reenableKeyguard();
            f.acB().bOf++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.bOr != null) {
            this.bOr.release();
            this.bOr = null;
        }
    }

    public void acI() {
        if (this.bOr == null) {
            this.bOr = this.bOq.newWakeLock(268435462, "ScreenLockNotify");
            this.bOr.setReferenceCounted(false);
        }
        if (this.bOr != null) {
            this.bOr.acquire(10000L);
            this.bOs.disableKeyguard();
            f.acB().bOc = 0;
            f.acB().bOg++;
        }
    }
}
