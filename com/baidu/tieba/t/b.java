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
    private KeyguardManager jto;
    private PowerManager jtp;
    private PowerManager.WakeLock jtq;
    private KeyguardManager.KeyguardLock jtr;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.jtp = (PowerManager) this.mContext.getSystemService("power");
            this.jtq = this.jtp.newWakeLock(268435462, "ScreenLockNotify");
            this.jtq.setReferenceCounted(false);
            this.jto = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.jtr = this.jto.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ctu() {
        try {
            this.jtr.reenableKeyguard();
            if (this.jtq != null) {
                this.jtq.release();
                this.jtq = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ctv() {
        try {
            if (this.jtq == null) {
                this.jtq = this.jtp.newWakeLock(268435462, "ScreenLockNotify");
                this.jtq.setReferenceCounted(false);
            }
            if (this.jtq != null) {
                this.jtq.acquire(10000L);
                this.jtr.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean ctw() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.jto, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean ctx() {
        return this.jtp.isScreenOn();
    }

    public static Drawable cty() {
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
