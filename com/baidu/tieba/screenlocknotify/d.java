package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class d {
    private KeyguardManager gvN;
    private PowerManager gvO;
    private PowerManager.WakeLock gvP;
    private KeyguardManager.KeyguardLock gvQ;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gvO = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.gvP = this.gvO.newWakeLock(268435462, "ScreenLockNotify");
            this.gvP.setReferenceCounted(false);
            this.gvN = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gvQ = this.gvN.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bqj() {
        try {
            this.gvQ.reenableKeyguard();
            a.bqe().gvC++;
            if (this.gvP != null) {
                this.gvP.release();
                this.gvP = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bqk() {
        try {
            if (this.gvP == null) {
                this.gvP = this.gvO.newWakeLock(268435462, "ScreenLockNotify");
                this.gvP.setReferenceCounted(false);
            }
            if (this.gvP != null) {
                this.gvP.acquire(10000L);
                this.gvQ.disableKeyguard();
                a.bqe().gvz = 0;
                a.bqe().gvD++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bql() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gvN, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gvO.isScreenOn();
    }
}
