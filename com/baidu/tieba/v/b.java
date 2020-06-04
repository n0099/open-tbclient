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
    private KeyguardManager lAD;
    private PowerManager lAE;
    private PowerManager.WakeLock lAF;
    private KeyguardManager.KeyguardLock lAG;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.lAE = (PowerManager) this.mContext.getSystemService("power");
            this.lAF = this.lAE.newWakeLock(268435462, "ScreenLockNotify");
            this.lAF.setReferenceCounted(false);
            this.lAD = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.lAG = this.lAD.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dhP() {
        try {
            this.lAG.reenableKeyguard();
            if (this.lAF != null) {
                this.lAF.release();
                this.lAF = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dhQ() {
        try {
            if (this.lAF == null) {
                this.lAF = this.lAE.newWakeLock(268435462, "ScreenLockNotify");
                this.lAF.setReferenceCounted(false);
            }
            if (this.lAF != null) {
                this.lAF.acquire(10000L);
                this.lAG.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dhR() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.lAD, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dhS() {
        return this.lAE.isScreenOn();
    }

    public static Drawable dhT() {
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
