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
    private KeyguardManager nMF;
    private PowerManager nMG;
    private PowerManager.WakeLock nMH;
    private KeyguardManager.KeyguardLock nMI;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nMG = (PowerManager) this.mContext.getSystemService("power");
            this.nMH = this.nMG.newWakeLock(268435462, "ScreenLockNotify");
            this.nMH.setReferenceCounted(false);
            this.nMF = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nMI = this.nMF.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dRZ() {
        try {
            this.nMI.reenableKeyguard();
            if (this.nMH != null) {
                this.nMH.release();
                this.nMH = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dSa() {
        try {
            if (this.nMH == null) {
                this.nMH = this.nMG.newWakeLock(268435462, "ScreenLockNotify");
                this.nMH.setReferenceCounted(false);
            }
            if (this.nMH != null) {
                this.nMH.acquire(10000L);
                this.nMI.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dSb() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nMF, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dSc() {
        return this.nMG.isScreenOn();
    }

    public static Drawable dSd() {
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
