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
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class b {
    private KeyguardManager juv;
    private PowerManager juw;
    private PowerManager.WakeLock jux;
    private KeyguardManager.KeyguardLock juy;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.juw = (PowerManager) this.mContext.getSystemService("power");
            this.jux = this.juw.newWakeLock(268435462, "ScreenLockNotify");
            this.jux.setReferenceCounted(false);
            this.juv = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.juy = this.juv.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ctQ() {
        try {
            this.juy.reenableKeyguard();
            if (this.jux != null) {
                this.jux.release();
                this.jux = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ctR() {
        try {
            if (this.jux == null) {
                this.jux = this.juw.newWakeLock(268435462, "ScreenLockNotify");
                this.jux.setReferenceCounted(false);
            }
            if (this.jux != null) {
                this.jux.acquire(10000L);
                this.juy.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean ctS() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.juv, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean ctT() {
        return this.juw.isScreenOn();
    }

    public static Drawable ctU() {
        Bitmap bitmap;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        try {
            Drawable drawable = WallpaperManager.getInstance(inst).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.af(inst), bitmap.getWidth());
                int min2 = Math.min(l.ah(inst), bitmap.getHeight());
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
