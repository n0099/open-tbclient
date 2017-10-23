package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fIh;
    private PowerManager fIi;
    private PowerManager.WakeLock fIj;
    private KeyguardManager.KeyguardLock fIk;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fIi = (PowerManager) this.mContext.getSystemService("power");
            this.fIj = this.fIi.newWakeLock(268435462, "ScreenLockNotify");
            this.fIj.setReferenceCounted(false);
            this.fIh = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fIk = this.fIh.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bhb() {
        try {
            this.fIk.reenableKeyguard();
            a.bgW().fHW++;
            if (this.fIj != null) {
                this.fIj.release();
                this.fIj = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bhc() {
        try {
            if (this.fIj == null) {
                this.fIj = this.fIi.newWakeLock(268435462, "ScreenLockNotify");
                this.fIj.setReferenceCounted(false);
            }
            if (this.fIj != null) {
                this.fIj.acquire(10000L);
                this.fIk.disableKeyguard();
                a.bgW().fHT = 0;
                a.bgW().fHX++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bhd() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fIh, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fIi.isScreenOn();
    }
}
