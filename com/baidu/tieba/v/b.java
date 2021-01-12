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
    private KeyguardManager nAp;
    private PowerManager nAq;
    private PowerManager.WakeLock nAr;
    private KeyguardManager.KeyguardLock nAs;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nAq = (PowerManager) this.mContext.getSystemService("power");
            this.nAr = this.nAq.newWakeLock(268435462, "ScreenLockNotify");
            this.nAr.setReferenceCounted(false);
            this.nAp = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nAs = this.nAp.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dPy() {
        try {
            this.nAs.reenableKeyguard();
            if (this.nAr != null) {
                this.nAr.release();
                this.nAr = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dPz() {
        try {
            if (this.nAr == null) {
                this.nAr = this.nAq.newWakeLock(268435462, "ScreenLockNotify");
                this.nAr.setReferenceCounted(false);
            }
            if (this.nAr != null) {
                this.nAr.acquire(10000L);
                this.nAs.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dPA() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nAp, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dPB() {
        return this.nAq.isScreenOn();
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
