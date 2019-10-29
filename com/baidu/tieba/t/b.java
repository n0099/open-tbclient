package com.baidu.tieba.t;

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
    private KeyguardManager jwJ;
    private PowerManager jwK;
    private PowerManager.WakeLock jwL;
    private KeyguardManager.KeyguardLock jwM;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.jwK = (PowerManager) this.mContext.getSystemService("power");
            this.jwL = this.jwK.newWakeLock(268435462, "ScreenLockNotify");
            this.jwL.setReferenceCounted(false);
            this.jwJ = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.jwM = this.jwJ.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cst() {
        try {
            this.jwM.reenableKeyguard();
            if (this.jwL != null) {
                this.jwL.release();
                this.jwL = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void csu() {
        try {
            if (this.jwL == null) {
                this.jwL = this.jwK.newWakeLock(268435462, "ScreenLockNotify");
                this.jwL.setReferenceCounted(false);
            }
            if (this.jwL != null) {
                this.jwL.acquire(10000L);
                this.jwM.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean csv() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.jwJ, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean csw() {
        return this.jwK.isScreenOn();
    }

    public static Drawable csx() {
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
