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
    private PowerManager.WakeLock iUA;
    private KeyguardManager.KeyguardLock iUB;
    private KeyguardManager iUy;
    private PowerManager iUz;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.iUz = (PowerManager) this.mContext.getSystemService("power");
            this.iUA = this.iUz.newWakeLock(268435462, "ScreenLockNotify");
            this.iUA.setReferenceCounted(false);
            this.iUy = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.iUB = this.iUy.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ciD() {
        try {
            this.iUB.reenableKeyguard();
            if (this.iUA != null) {
                this.iUA.release();
                this.iUA = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ciE() {
        try {
            if (this.iUA == null) {
                this.iUA = this.iUz.newWakeLock(268435462, "ScreenLockNotify");
                this.iUA.setReferenceCounted(false);
            }
            if (this.iUA != null) {
                this.iUA.acquire(10000L);
                this.iUB.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean ciF() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.iUy, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.iUz.isScreenOn();
    }

    public static Drawable ciG() {
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
