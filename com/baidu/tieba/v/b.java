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
    private KeyguardManager kuT;
    private PowerManager kuU;
    private PowerManager.WakeLock kuV;
    private KeyguardManager.KeyguardLock kuW;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.kuU = (PowerManager) this.mContext.getSystemService("power");
            this.kuV = this.kuU.newWakeLock(268435462, "ScreenLockNotify");
            this.kuV.setReferenceCounted(false);
            this.kuT = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.kuW = this.kuT.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cOY() {
        try {
            this.kuW.reenableKeyguard();
            if (this.kuV != null) {
                this.kuV.release();
                this.kuV = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cOZ() {
        try {
            if (this.kuV == null) {
                this.kuV = this.kuU.newWakeLock(268435462, "ScreenLockNotify");
                this.kuV.setReferenceCounted(false);
            }
            if (this.kuV != null) {
                this.kuV.acquire(10000L);
                this.kuW.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cPa() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.kuT, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean cPb() {
        return this.kuU.isScreenOn();
    }

    public static Drawable cPc() {
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
