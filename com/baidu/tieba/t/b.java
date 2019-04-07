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
    private KeyguardManager iUe;
    private PowerManager iUf;
    private PowerManager.WakeLock iUg;
    private KeyguardManager.KeyguardLock iUh;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.iUf = (PowerManager) this.mContext.getSystemService("power");
            this.iUg = this.iUf.newWakeLock(268435462, "ScreenLockNotify");
            this.iUg.setReferenceCounted(false);
            this.iUe = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.iUh = this.iUe.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ciE() {
        try {
            this.iUh.reenableKeyguard();
            if (this.iUg != null) {
                this.iUg.release();
                this.iUg = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ciF() {
        try {
            if (this.iUg == null) {
                this.iUg = this.iUf.newWakeLock(268435462, "ScreenLockNotify");
                this.iUg.setReferenceCounted(false);
            }
            if (this.iUg != null) {
                this.iUg.acquire(10000L);
                this.iUh.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean ciG() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.iUe, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.iUf.isScreenOn();
    }

    public static Drawable ciH() {
        Bitmap bitmap;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        try {
            Drawable drawable = WallpaperManager.getInstance(inst).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.aO(inst), bitmap.getWidth());
                int min2 = Math.min(l.aQ(inst), bitmap.getHeight());
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
