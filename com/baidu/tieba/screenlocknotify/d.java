package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fIw;
    private PowerManager fIx;
    private PowerManager.WakeLock fIy;
    private KeyguardManager.KeyguardLock fIz;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fIx = (PowerManager) this.mContext.getSystemService("power");
            this.fIy = this.fIx.newWakeLock(268435462, "ScreenLockNotify");
            this.fIy.setReferenceCounted(false);
            this.fIw = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fIz = this.fIw.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bhh() {
        try {
            this.fIz.reenableKeyguard();
            a.bhc().fIl++;
            if (this.fIy != null) {
                this.fIy.release();
                this.fIy = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bhi() {
        try {
            if (this.fIy == null) {
                this.fIy = this.fIx.newWakeLock(268435462, "ScreenLockNotify");
                this.fIy.setReferenceCounted(false);
            }
            if (this.fIy != null) {
                this.fIy.acquire(10000L);
                this.fIz.disableKeyguard();
                a.bhc().fIi = 0;
                a.bhc().fIm++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bhj() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fIw, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fIx.isScreenOn();
    }
}
