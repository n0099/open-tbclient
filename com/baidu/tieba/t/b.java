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
    private KeyguardManager jnd;
    private PowerManager jne;
    private PowerManager.WakeLock jnf;
    private KeyguardManager.KeyguardLock jng;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.jne = (PowerManager) this.mContext.getSystemService("power");
            this.jnf = this.jne.newWakeLock(268435462, "ScreenLockNotify");
            this.jnf.setReferenceCounted(false);
            this.jnd = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.jng = this.jnd.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cqJ() {
        try {
            this.jng.reenableKeyguard();
            if (this.jnf != null) {
                this.jnf.release();
                this.jnf = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cqK() {
        try {
            if (this.jnf == null) {
                this.jnf = this.jne.newWakeLock(268435462, "ScreenLockNotify");
                this.jnf.setReferenceCounted(false);
            }
            if (this.jnf != null) {
                this.jnf.acquire(10000L);
                this.jng.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cqL() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.jnd, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.jne.isScreenOn();
    }

    public static Drawable cqM() {
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
