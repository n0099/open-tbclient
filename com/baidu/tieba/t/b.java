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
    private KeyguardManager iUq;
    private PowerManager iUr;
    private PowerManager.WakeLock iUs;
    private KeyguardManager.KeyguardLock iUt;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.iUr = (PowerManager) this.mContext.getSystemService("power");
            this.iUs = this.iUr.newWakeLock(268435462, "ScreenLockNotify");
            this.iUs.setReferenceCounted(false);
            this.iUq = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.iUt = this.iUq.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ciG() {
        try {
            this.iUt.reenableKeyguard();
            if (this.iUs != null) {
                this.iUs.release();
                this.iUs = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ciH() {
        try {
            if (this.iUs == null) {
                this.iUs = this.iUr.newWakeLock(268435462, "ScreenLockNotify");
                this.iUs.setReferenceCounted(false);
            }
            if (this.iUs != null) {
                this.iUs.acquire(10000L);
                this.iUt.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean ciI() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.iUq, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.iUr.isScreenOn();
    }

    public static Drawable ciJ() {
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
