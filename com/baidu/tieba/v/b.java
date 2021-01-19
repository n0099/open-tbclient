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
    private KeyguardManager nAq;
    private PowerManager nAr;
    private PowerManager.WakeLock nAs;
    private KeyguardManager.KeyguardLock nAt;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nAr = (PowerManager) this.mContext.getSystemService("power");
            this.nAs = this.nAr.newWakeLock(268435462, "ScreenLockNotify");
            this.nAs.setReferenceCounted(false);
            this.nAq = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nAt = this.nAq.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dPy() {
        try {
            this.nAt.reenableKeyguard();
            if (this.nAs != null) {
                this.nAs.release();
                this.nAs = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dPz() {
        try {
            if (this.nAs == null) {
                this.nAs = this.nAr.newWakeLock(268435462, "ScreenLockNotify");
                this.nAs.setReferenceCounted(false);
            }
            if (this.nAs != null) {
                this.nAs.acquire(10000L);
                this.nAt.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dPA() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nAq, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dPB() {
        return this.nAr.isScreenOn();
    }

    public static Drawable dPC() {
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
