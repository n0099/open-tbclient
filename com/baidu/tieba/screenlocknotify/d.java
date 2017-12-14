package com.baidu.tieba.screenlocknotify;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes2.dex */
public class d {
    private KeyguardManager gek;
    private PowerManager gel;
    private PowerManager.WakeLock gem;
    private KeyguardManager.KeyguardLock gen;
    private Context mContext;

    public d() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.gel = (PowerManager) this.mContext.getSystemService("power");
            this.gem = this.gel.newWakeLock(268435462, "ScreenLockNotify");
            this.gem.setReferenceCounted(false);
            this.gek = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.gen = this.gek.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bnf() {
        try {
            this.gen.reenableKeyguard();
            a.bna().gdZ++;
            if (this.gem != null) {
                this.gem.release();
                this.gem = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bng() {
        try {
            if (this.gem == null) {
                this.gem = this.gel.newWakeLock(268435462, "ScreenLockNotify");
                this.gem.setReferenceCounted(false);
            }
            if (this.gem != null) {
                this.gem.acquire(10000L);
                this.gen.disableKeyguard();
                a.bna().gdW = 0;
                a.bna().gea++;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean bnh() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.gek, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.gel.isScreenOn();
    }
}
