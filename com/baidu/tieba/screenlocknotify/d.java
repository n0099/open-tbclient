package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private PowerManager.WakeLock gHA;
    private KeyguardManager.KeyguardLock gHB;
    private KeyguardManager gHy;
    private PowerManager gHz;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gHz = (PowerManager) this.mContext.getSystemService("power");
            this.gHA = this.gHz.newWakeLock(268435462, "ScreenLockNotify");
            this.gHA.setReferenceCounted(false);
            this.gHy = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gHB = this.gHy.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bog() {
        try {
            this.gHB.reenableKeyguard();
            a.bob().gHn++;
            if (this.gHA != null) {
                this.gHA.release();
                this.gHA = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void boh() {
        try {
            if (this.gHA == null) {
                this.gHA = this.gHz.newWakeLock(268435462, "ScreenLockNotify");
                this.gHA.setReferenceCounted(false);
            }
            if (this.gHA != null) {
                this.gHA.acquire(10000L);
                this.gHB.disableKeyguard();
                a.bob().gHk = 0;
                a.bob().gHo++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean boi() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gHy, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gHz.isScreenOn();
    }
}
