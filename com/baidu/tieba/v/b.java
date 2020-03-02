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
    private KeyguardManager kuH;
    private PowerManager kuI;
    private PowerManager.WakeLock kuJ;
    private KeyguardManager.KeyguardLock kuK;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.kuI = (PowerManager) this.mContext.getSystemService("power");
            this.kuJ = this.kuI.newWakeLock(268435462, "ScreenLockNotify");
            this.kuJ.setReferenceCounted(false);
            this.kuH = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.kuK = this.kuH.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cOX() {
        try {
            this.kuK.reenableKeyguard();
            if (this.kuJ != null) {
                this.kuJ.release();
                this.kuJ = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cOY() {
        try {
            if (this.kuJ == null) {
                this.kuJ = this.kuI.newWakeLock(268435462, "ScreenLockNotify");
                this.kuJ.setReferenceCounted(false);
            }
            if (this.kuJ != null) {
                this.kuJ.acquire(10000L);
                this.kuK.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cOZ() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.kuH, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean cPa() {
        return this.kuI.isScreenOn();
    }

    public static Drawable cPb() {
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
