package com.baidu.tieba.t;

import android.app.KeyguardManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private KeyguardManager hbt;
    private PowerManager hbu;
    private PowerManager.WakeLock hbv;
    private KeyguardManager.KeyguardLock hbw;
    private Context mContext;

    public a() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.hbu = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.hbv = this.hbu.newWakeLock(268435462, "ScreenLockNotify");
            this.hbv.setReferenceCounted(false);
            this.hbt = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.hbw = this.hbt.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bAb() {
        try {
            this.hbw.reenableKeyguard();
            if (this.hbv != null) {
                this.hbv.release();
                this.hbv = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bAc() {
        try {
            if (this.hbv == null) {
                this.hbv = this.hbu.newWakeLock(268435462, "ScreenLockNotify");
                this.hbv.setReferenceCounted(false);
            }
            if (this.hbv != null) {
                this.hbv.acquire(10000L);
                this.hbw.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isKeyguardLocked() {
        if (this.hbt == null) {
            return true;
        }
        return this.hbt.inKeyguardRestrictedInputMode();
    }

    public boolean bAd() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.hbt, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.hbu.isScreenOn();
    }

    public static Drawable bAe() {
        Bitmap bitmap;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        try {
            Drawable drawable = WallpaperManager.getInstance(inst).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.ah(inst), bitmap.getWidth());
                int min2 = Math.min(l.aj(inst), bitmap.getHeight());
                try {
                    return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, min, min2));
                } catch (Throwable th) {
                    try {
                        return new BitmapDrawable(Bitmap.createBitmap(bitmap, 0, 0, min, min2));
                    } catch (Throwable th2) {
                        BdLog.e(th2.getMessage());
                        return null;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
