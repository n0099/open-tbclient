package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class r {
    private KeyguardManager eZW;
    private PowerManager fan;
    private PowerManager.WakeLock fao;
    private KeyguardManager.KeyguardLock fap;
    private Context mContext;

    public r() {
        try {
            this.mContext = TbadkCoreApplication.m9getInst().getApp();
            this.fan = (PowerManager) this.mContext.getSystemService("power");
            this.fao = this.fan.newWakeLock(268435462, "ScreenLockNotify");
            this.fao.setReferenceCounted(false);
            this.eZW = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.fap = this.eZW.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void baG() {
        try {
            this.fap.reenableKeyguard();
            i.baB().fac++;
            if (this.fao != null) {
                this.fao.release();
                this.fao = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void baH() {
        try {
            if (this.fao == null) {
                this.fao = this.fan.newWakeLock(268435462, "ScreenLockNotify");
                this.fao.setReferenceCounted(false);
            }
            if (this.fao != null) {
                this.fao.acquire(10000L);
                this.fap.disableKeyguard();
                i.baB().eZZ = 0;
                i.baB().fad++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean baI() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.eZW, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.fan.isScreenOn();
    }
}
