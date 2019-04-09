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
    private KeyguardManager iUf;
    private PowerManager iUg;
    private PowerManager.WakeLock iUh;
    private KeyguardManager.KeyguardLock iUi;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.iUg = (PowerManager) this.mContext.getSystemService("power");
            this.iUh = this.iUg.newWakeLock(268435462, "ScreenLockNotify");
            this.iUh.setReferenceCounted(false);
            this.iUf = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.iUi = this.iUf.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ciE() {
        try {
            this.iUi.reenableKeyguard();
            if (this.iUh != null) {
                this.iUh.release();
                this.iUh = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ciF() {
        try {
            if (this.iUh == null) {
                this.iUh = this.iUg.newWakeLock(268435462, "ScreenLockNotify");
                this.iUh.setReferenceCounted(false);
            }
            if (this.iUh != null) {
                this.iUh.acquire(10000L);
                this.iUi.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean ciG() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.iUf, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.iUg.isScreenOn();
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
