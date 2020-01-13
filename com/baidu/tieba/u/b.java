package com.baidu.tieba.u;

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
    private KeyguardManager ktD;
    private PowerManager ktE;
    private PowerManager.WakeLock ktF;
    private KeyguardManager.KeyguardLock ktG;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.ktE = (PowerManager) this.mContext.getSystemService("power");
            this.ktF = this.ktE.newWakeLock(268435462, "ScreenLockNotify");
            this.ktF.setReferenceCounted(false);
            this.ktD = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.ktG = this.ktD.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cNy() {
        try {
            this.ktG.reenableKeyguard();
            if (this.ktF != null) {
                this.ktF.release();
                this.ktF = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cNz() {
        try {
            if (this.ktF == null) {
                this.ktF = this.ktE.newWakeLock(268435462, "ScreenLockNotify");
                this.ktF.setReferenceCounted(false);
            }
            if (this.ktF != null) {
                this.ktF.acquire(10000L);
                this.ktG.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cNA() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.ktD, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean cNB() {
        return this.ktE.isScreenOn();
    }

    public static Drawable cNC() {
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
