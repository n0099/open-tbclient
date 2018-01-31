package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager gHT;
    private PowerManager gHU;
    private PowerManager.WakeLock gHV;
    private KeyguardManager.KeyguardLock gHW;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gHU = (PowerManager) this.mContext.getSystemService("power");
            this.gHV = this.gHU.newWakeLock(268435462, "ScreenLockNotify");
            this.gHV.setReferenceCounted(false);
            this.gHT = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gHW = this.gHT.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void boh() {
        try {
            this.gHW.reenableKeyguard();
            a.boc().gHI++;
            if (this.gHV != null) {
                this.gHV.release();
                this.gHV = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void boi() {
        try {
            if (this.gHV == null) {
                this.gHV = this.gHU.newWakeLock(268435462, "ScreenLockNotify");
                this.gHV.setReferenceCounted(false);
            }
            if (this.gHV != null) {
                this.gHV.acquire(10000L);
                this.gHW.disableKeyguard();
                a.boc().gHF = 0;
                a.boc().gHJ++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean boj() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gHT, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gHU.isScreenOn();
    }
}
