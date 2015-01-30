package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class s {
    private KeyguardManager bNY;
    private PowerManager bOr;
    private PowerManager.WakeLock bOs;
    private KeyguardManager.KeyguardLock bOt;
    private Context mContext;

    public s() {
        try {
            this.mContext = TbadkApplication.getInst().getApp();
            this.bOr = (PowerManager) this.mContext.getSystemService("power");
            this.bOs = this.bOr.newWakeLock(268435462, "ScreenLockNotify");
            this.bOs.setReferenceCounted(false);
            this.bNY = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.bOt = this.bNY.newKeyguardLock("ScreenLockUtils");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void acM() {
        try {
            this.bOt.reenableKeyguard();
            f.acG().bOg++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.bOs != null) {
            this.bOs.release();
            this.bOs = null;
        }
    }

    public void acN() {
        if (this.bOs == null) {
            this.bOs = this.bOr.newWakeLock(268435462, "ScreenLockNotify");
            this.bOs.setReferenceCounted(false);
        }
        if (this.bOs != null) {
            this.bOs.acquire(10000L);
            this.bOt.disableKeyguard();
            f.acG().bOd = 0;
            f.acG().bOh++;
        }
    }
}
