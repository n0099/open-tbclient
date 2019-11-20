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
    private KeyguardManager jvS;
    private PowerManager jvT;
    private PowerManager.WakeLock jvU;
    private KeyguardManager.KeyguardLock jvV;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.jvT = (PowerManager) this.mContext.getSystemService("power");
            this.jvU = this.jvT.newWakeLock(268435462, "ScreenLockNotify");
            this.jvU.setReferenceCounted(false);
            this.jvS = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.jvV = this.jvS.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void csr() {
        try {
            this.jvV.reenableKeyguard();
            if (this.jvU != null) {
                this.jvU.release();
                this.jvU = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void css() {
        try {
            if (this.jvU == null) {
                this.jvU = this.jvT.newWakeLock(268435462, "ScreenLockNotify");
                this.jvU.setReferenceCounted(false);
            }
            if (this.jvU != null) {
                this.jvU.acquire(10000L);
                this.jvV.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cst() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.jvS, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean csu() {
        return this.jvT.isScreenOn();
    }

    public static Drawable csv() {
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
