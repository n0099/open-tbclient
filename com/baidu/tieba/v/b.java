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
    private KeyguardManager lgJ;
    private PowerManager lgK;
    private PowerManager.WakeLock lgL;
    private KeyguardManager.KeyguardLock lgM;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.lgK = (PowerManager) this.mContext.getSystemService("power");
            this.lgL = this.lgK.newWakeLock(268435462, "ScreenLockNotify");
            this.lgL.setReferenceCounted(false);
            this.lgJ = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.lgM = this.lgJ.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dam() {
        try {
            this.lgM.reenableKeyguard();
            if (this.lgL != null) {
                this.lgL.release();
                this.lgL = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dan() {
        try {
            if (this.lgL == null) {
                this.lgL = this.lgK.newWakeLock(268435462, "ScreenLockNotify");
                this.lgL.setReferenceCounted(false);
            }
            if (this.lgL != null) {
                this.lgL.acquire(10000L);
                this.lgM.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dao() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.lgJ, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dap() {
        return this.lgK.isScreenOn();
    }

    public static Drawable daq() {
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
