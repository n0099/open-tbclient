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
    private KeyguardManager nlB;
    private PowerManager nlC;
    private PowerManager.WakeLock nlD;
    private KeyguardManager.KeyguardLock nlE;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nlC = (PowerManager) this.mContext.getSystemService("power");
            this.nlD = this.nlC.newWakeLock(268435462, "ScreenLockNotify");
            this.nlD.setReferenceCounted(false);
            this.nlB = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nlE = this.nlB.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dOg() {
        try {
            this.nlE.reenableKeyguard();
            if (this.nlD != null) {
                this.nlD.release();
                this.nlD = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dOh() {
        try {
            if (this.nlD == null) {
                this.nlD = this.nlC.newWakeLock(268435462, "ScreenLockNotify");
                this.nlD.setReferenceCounted(false);
            }
            if (this.nlD != null) {
                this.nlD.acquire(10000L);
                this.nlE.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dOi() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nlB, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dOj() {
        return this.nlC.isScreenOn();
    }

    public static Drawable dOk() {
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
