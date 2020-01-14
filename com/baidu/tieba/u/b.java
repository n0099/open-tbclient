package com.baidu.tieba.u;

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
    private KeyguardManager ktI;
    private PowerManager ktJ;
    private PowerManager.WakeLock ktK;
    private KeyguardManager.KeyguardLock ktL;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.ktJ = (PowerManager) this.mContext.getSystemService("power");
            this.ktK = this.ktJ.newWakeLock(268435462, "ScreenLockNotify");
            this.ktK.setReferenceCounted(false);
            this.ktI = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.ktL = this.ktI.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cNA() {
        try {
            this.ktL.reenableKeyguard();
            if (this.ktK != null) {
                this.ktK.release();
                this.ktK = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cNB() {
        try {
            if (this.ktK == null) {
                this.ktK = this.ktJ.newWakeLock(268435462, "ScreenLockNotify");
                this.ktK.setReferenceCounted(false);
            }
            if (this.ktK != null) {
                this.ktK.acquire(10000L);
                this.ktL.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cNC() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.ktI, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean cND() {
        return this.ktJ.isScreenOn();
    }

    public static Drawable cNE() {
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
