package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager gKj;
    private PowerManager gKk;
    private PowerManager.WakeLock gKl;
    private KeyguardManager.KeyguardLock gKm;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gKk = (PowerManager) this.mContext.getSystemService(Constants.HTTP_POWER);
            this.gKl = this.gKk.newWakeLock(268435462, "ScreenLockNotify");
            this.gKl.setReferenceCounted(false);
            this.gKj = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gKm = this.gKj.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bpD() {
        try {
            this.gKm.reenableKeyguard();
            a.bpy().gJY++;
            if (this.gKl != null) {
                this.gKl.release();
                this.gKl = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bpE() {
        try {
            if (this.gKl == null) {
                this.gKl = this.gKk.newWakeLock(268435462, "ScreenLockNotify");
                this.gKl.setReferenceCounted(false);
            }
            if (this.gKl != null) {
                this.gKl.acquire(10000L);
                this.gKm.disableKeyguard();
                a.bpy().gJV = 0;
                a.bpy().gJZ++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bpF() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gKj, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gKk.isScreenOn();
    }
}
