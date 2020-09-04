package com.baidu.tieba.v;

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
    private Context mContext;
    private KeyguardManager mtG;
    private PowerManager mtH;
    private PowerManager.WakeLock mtI;
    private KeyguardManager.KeyguardLock mtJ;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.mtH = (PowerManager) this.mContext.getSystemService("power");
            this.mtI = this.mtH.newWakeLock(268435462, "ScreenLockNotify");
            this.mtI.setReferenceCounted(false);
            this.mtG = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.mtJ = this.mtG.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dAQ() {
        try {
            this.mtJ.reenableKeyguard();
            if (this.mtI != null) {
                this.mtI.release();
                this.mtI = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dAR() {
        try {
            if (this.mtI == null) {
                this.mtI = this.mtH.newWakeLock(268435462, "ScreenLockNotify");
                this.mtI.setReferenceCounted(false);
            }
            if (this.mtI != null) {
                this.mtI.acquire(10000L);
                this.mtJ.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dAS() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.mtG, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dAT() {
        return this.mtH.isScreenOn();
    }

    public static Drawable dAU() {
        Bitmap bitmap;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        try {
            Drawable drawable = WallpaperManager.getInstance(inst).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.getEquipmentWidth(inst), bitmap.getWidth());
                int min2 = Math.min(l.getEquipmentHeight(inst), bitmap.getHeight());
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
