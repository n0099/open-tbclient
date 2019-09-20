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
    private KeyguardManager jwR;
    private PowerManager jwS;
    private PowerManager.WakeLock jwT;
    private KeyguardManager.KeyguardLock jwU;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.jwS = (PowerManager) this.mContext.getSystemService("power");
            this.jwT = this.jwS.newWakeLock(268435462, "ScreenLockNotify");
            this.jwT.setReferenceCounted(false);
            this.jwR = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.jwU = this.jwR.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cuE() {
        try {
            this.jwU.reenableKeyguard();
            if (this.jwT != null) {
                this.jwT.release();
                this.jwT = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cuF() {
        try {
            if (this.jwT == null) {
                this.jwT = this.jwS.newWakeLock(268435462, "ScreenLockNotify");
                this.jwT.setReferenceCounted(false);
            }
            if (this.jwT != null) {
                this.jwT.acquire(10000L);
                this.jwU.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cuG() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.jwR, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean cuH() {
        return this.jwS.isScreenOn();
    }

    public static Drawable cuI() {
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
