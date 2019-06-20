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
    private KeyguardManager jnh;
    private PowerManager jni;
    private PowerManager.WakeLock jnj;
    private KeyguardManager.KeyguardLock jnk;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.jni = (PowerManager) this.mContext.getSystemService("power");
            this.jnj = this.jni.newWakeLock(268435462, "ScreenLockNotify");
            this.jnj.setReferenceCounted(false);
            this.jnh = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.jnk = this.jnh.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cqK() {
        try {
            this.jnk.reenableKeyguard();
            if (this.jnj != null) {
                this.jnj.release();
                this.jnj = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cqL() {
        try {
            if (this.jnj == null) {
                this.jnj = this.jni.newWakeLock(268435462, "ScreenLockNotify");
                this.jnj.setReferenceCounted(false);
            }
            if (this.jnj != null) {
                this.jnj.acquire(10000L);
                this.jnk.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cqM() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.jnh, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.jni.isScreenOn();
    }

    public static Drawable cqN() {
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
