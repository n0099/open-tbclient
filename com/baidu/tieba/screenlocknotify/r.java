package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r {
    private KeyguardManager ffT;
    private PowerManager fgk;
    private PowerManager.WakeLock fgl;
    private KeyguardManager.KeyguardLock fgm;
    private Context mContext;

    public r() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.fgk = (PowerManager) this.mContext.getSystemService("power");
            this.fgl = this.fgk.newWakeLock(268435462, "ScreenLockNotify");
            this.fgl.setReferenceCounted(false);
            this.ffT = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fgm = this.ffT.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bba() {
        try {
            this.fgm.reenableKeyguard();
            i.baV().ffZ++;
            if (this.fgl != null) {
                this.fgl.release();
                this.fgl = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bbb() {
        try {
            if (this.fgl == null) {
                this.fgl = this.fgk.newWakeLock(268435462, "ScreenLockNotify");
                this.fgl.setReferenceCounted(false);
            }
            if (this.fgl != null) {
                this.fgl.acquire(10000L);
                this.fgm.disableKeyguard();
                i.baV().ffW = 0;
                i.baV().fga++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bbc() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.ffT, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fgk.isScreenOn();
    }
}
