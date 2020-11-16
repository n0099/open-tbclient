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
    private KeyguardManager nmI;
    private PowerManager nmJ;
    private PowerManager.WakeLock nmK;
    private KeyguardManager.KeyguardLock nmL;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nmJ = (PowerManager) this.mContext.getSystemService("power");
            this.nmK = this.nmJ.newWakeLock(268435462, "ScreenLockNotify");
            this.nmK.setReferenceCounted(false);
            this.nmI = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nmL = this.nmI.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dOf() {
        try {
            this.nmL.reenableKeyguard();
            if (this.nmK != null) {
                this.nmK.release();
                this.nmK = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dOg() {
        try {
            if (this.nmK == null) {
                this.nmK = this.nmJ.newWakeLock(268435462, "ScreenLockNotify");
                this.nmK.setReferenceCounted(false);
            }
            if (this.nmK != null) {
                this.nmK.acquire(10000L);
                this.nmL.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dOh() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nmI, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dOi() {
        return this.nmJ.isScreenOn();
    }

    public static Drawable dOj() {
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
