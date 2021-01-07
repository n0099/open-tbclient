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
    private KeyguardManager nEU;
    private PowerManager nEV;
    private PowerManager.WakeLock nEW;
    private KeyguardManager.KeyguardLock nEX;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nEV = (PowerManager) this.mContext.getSystemService("power");
            this.nEW = this.nEV.newWakeLock(268435462, "ScreenLockNotify");
            this.nEW.setReferenceCounted(false);
            this.nEU = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nEX = this.nEU.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dTq() {
        try {
            this.nEX.reenableKeyguard();
            if (this.nEW != null) {
                this.nEW.release();
                this.nEW = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dTr() {
        try {
            if (this.nEW == null) {
                this.nEW = this.nEV.newWakeLock(268435462, "ScreenLockNotify");
                this.nEW.setReferenceCounted(false);
            }
            if (this.nEW != null) {
                this.nEW.acquire(10000L);
                this.nEX.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dTs() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nEU, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dTt() {
        return this.nEV.isScreenOn();
    }

    public static Drawable dTu() {
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
