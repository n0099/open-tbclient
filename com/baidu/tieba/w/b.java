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
    private KeyguardManager nAN;
    private PowerManager nAO;
    private PowerManager.WakeLock nAP;
    private KeyguardManager.KeyguardLock nAQ;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nAO = (PowerManager) this.mContext.getSystemService("power");
            this.nAP = this.nAO.newWakeLock(268435462, "ScreenLockNotify");
            this.nAP.setReferenceCounted(false);
            this.nAN = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nAQ = this.nAN.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dTy() {
        try {
            this.nAQ.reenableKeyguard();
            if (this.nAP != null) {
                this.nAP.release();
                this.nAP = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dTz() {
        try {
            if (this.nAP == null) {
                this.nAP = this.nAO.newWakeLock(268435462, "ScreenLockNotify");
                this.nAP.setReferenceCounted(false);
            }
            if (this.nAP != null) {
                this.nAP.acquire(10000L);
                this.nAQ.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dTA() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nAN, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dTB() {
        return this.nAO.isScreenOn();
    }

    public static Drawable dTC() {
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
