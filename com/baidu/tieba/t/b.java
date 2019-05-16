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
    private KeyguardManager jnc;
    private PowerManager jnd;
    private PowerManager.WakeLock jne;
    private KeyguardManager.KeyguardLock jnf;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.jnd = (PowerManager) this.mContext.getSystemService("power");
            this.jne = this.jnd.newWakeLock(268435462, "ScreenLockNotify");
            this.jne.setReferenceCounted(false);
            this.jnc = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.jnf = this.jnc.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cqH() {
        try {
            this.jnf.reenableKeyguard();
            if (this.jne != null) {
                this.jne.release();
                this.jne = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cqI() {
        try {
            if (this.jne == null) {
                this.jne = this.jnd.newWakeLock(268435462, "ScreenLockNotify");
                this.jne.setReferenceCounted(false);
            }
            if (this.jne != null) {
                this.jne.acquire(10000L);
                this.jnf.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cqJ() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.jnc, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.jnd.isScreenOn();
    }

    public static Drawable cqK() {
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
