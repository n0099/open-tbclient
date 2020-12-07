package com.baidu.tieba.w;

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
    private KeyguardManager nAL;
    private PowerManager nAM;
    private PowerManager.WakeLock nAN;
    private KeyguardManager.KeyguardLock nAO;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nAM = (PowerManager) this.mContext.getSystemService("power");
            this.nAN = this.nAM.newWakeLock(268435462, "ScreenLockNotify");
            this.nAN.setReferenceCounted(false);
            this.nAL = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nAO = this.nAL.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dTx() {
        try {
            this.nAO.reenableKeyguard();
            if (this.nAN != null) {
                this.nAN.release();
                this.nAN = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dTy() {
        try {
            if (this.nAN == null) {
                this.nAN = this.nAM.newWakeLock(268435462, "ScreenLockNotify");
                this.nAN.setReferenceCounted(false);
            }
            if (this.nAN != null) {
                this.nAN.acquire(10000L);
                this.nAO.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dTz() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nAL, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dTA() {
        return this.nAM.isScreenOn();
    }

    public static Drawable dTB() {
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
