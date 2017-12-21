package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager geq;
    private PowerManager ger;
    private PowerManager.WakeLock ges;
    private KeyguardManager.KeyguardLock get;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.ger = (PowerManager) this.mContext.getSystemService("power");
            this.ges = this.ger.newWakeLock(268435462, "ScreenLockNotify");
            this.ges.setReferenceCounted(false);
            this.geq = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.get = this.geq.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bnf() {
        try {
            this.get.reenableKeyguard();
            a.bna().gee++;
            if (this.ges != null) {
                this.ges.release();
                this.ges = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bng() {
        try {
            if (this.ges == null) {
                this.ges = this.ger.newWakeLock(268435462, "ScreenLockNotify");
                this.ges.setReferenceCounted(false);
            }
            if (this.ges != null) {
                this.ges.acquire(10000L);
                this.get.disableKeyguard();
                a.bna().geb = 0;
                a.bna().gef++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bnh() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.geq, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.ger.isScreenOn();
    }
}
