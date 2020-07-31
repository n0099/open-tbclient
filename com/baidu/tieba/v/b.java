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
    private KeyguardManager mbB;
    private PowerManager mbC;
    private PowerManager.WakeLock mbD;
    private KeyguardManager.KeyguardLock mbE;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.mbC = (PowerManager) this.mContext.getSystemService("power");
            this.mbD = this.mbC.newWakeLock(268435462, "ScreenLockNotify");
            this.mbD.setReferenceCounted(false);
            this.mbB = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.mbE = this.mbB.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dpl() {
        try {
            this.mbE.reenableKeyguard();
            if (this.mbD != null) {
                this.mbD.release();
                this.mbD = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dpm() {
        try {
            if (this.mbD == null) {
                this.mbD = this.mbC.newWakeLock(268435462, "ScreenLockNotify");
                this.mbD.setReferenceCounted(false);
            }
            if (this.mbD != null) {
                this.mbD.acquire(10000L);
                this.mbE.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dpn() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.mbB, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dpo() {
        return this.mbC.isScreenOn();
    }

    public static Drawable dpp() {
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
