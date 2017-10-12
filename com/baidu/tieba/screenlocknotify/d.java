package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager fIv;
    private PowerManager fIw;
    private PowerManager.WakeLock fIx;
    private KeyguardManager.KeyguardLock fIy;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.fIw = (PowerManager) this.mContext.getSystemService("power");
            this.fIx = this.fIw.newWakeLock(268435462, "ScreenLockNotify");
            this.fIx.setReferenceCounted(false);
            this.fIv = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fIy = this.fIv.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bhg() {
        try {
            this.fIy.reenableKeyguard();
            a.bhb().fIk++;
            if (this.fIx != null) {
                this.fIx.release();
                this.fIx = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bhh() {
        try {
            if (this.fIx == null) {
                this.fIx = this.fIw.newWakeLock(268435462, "ScreenLockNotify");
                this.fIx.setReferenceCounted(false);
            }
            if (this.fIx != null) {
                this.fIx.acquire(10000L);
                this.fIy.disableKeyguard();
                a.bhb().fIh = 0;
                a.bhb().fIl++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bhi() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.fIv, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fIw.isScreenOn();
    }
}
