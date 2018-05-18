package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private KeyguardManager ggC;
    private PowerManager ggD;
    private PowerManager.WakeLock ggE;
    private KeyguardManager.KeyguardLock ggF;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.ggD = (PowerManager) this.mContext.getSystemService(Constants.HTTP_POWER);
            this.ggE = this.ggD.newWakeLock(268435462, "ScreenLockNotify");
            this.ggE.setReferenceCounted(false);
            this.ggC = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.ggF = this.ggC.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bkK() {
        try {
            this.ggF.reenableKeyguard();
            a.bkF().ggr++;
            if (this.ggE != null) {
                this.ggE.release();
                this.ggE = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bkL() {
        try {
            if (this.ggE == null) {
                this.ggE = this.ggD.newWakeLock(268435462, "ScreenLockNotify");
                this.ggE.setReferenceCounted(false);
            }
            if (this.ggE != null) {
                this.ggE.acquire(10000L);
                this.ggF.disableKeyguard();
                a.bkF().ggo = 0;
                a.bkF().ggs++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bkM() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.ggC, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.ggD.isScreenOn();
    }
}
