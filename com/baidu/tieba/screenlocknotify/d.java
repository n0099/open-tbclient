package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private KeyguardManager gfw;
    private PowerManager gfx;
    private PowerManager.WakeLock gfy;
    private KeyguardManager.KeyguardLock gfz;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gfx = (PowerManager) this.mContext.getSystemService(Constants.HTTP_POWER);
            this.gfy = this.gfx.newWakeLock(268435462, "ScreenLockNotify");
            this.gfy.setReferenceCounted(false);
            this.gfw = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gfz = this.gfw.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bkL() {
        try {
            this.gfz.reenableKeyguard();
            a.bkG().gfl++;
            if (this.gfy != null) {
                this.gfy.release();
                this.gfy = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bkM() {
        try {
            if (this.gfy == null) {
                this.gfy = this.gfx.newWakeLock(268435462, "ScreenLockNotify");
                this.gfy.setReferenceCounted(false);
            }
            if (this.gfy != null) {
                this.gfy.acquire(10000L);
                this.gfz.disableKeyguard();
                a.bkG().gfi = 0;
                a.bkG().gfm++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bkN() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gfw, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gfx.isScreenOn();
    }
}
