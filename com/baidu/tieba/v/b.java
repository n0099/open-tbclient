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
    private KeyguardManager nfF;
    private PowerManager nfG;
    private PowerManager.WakeLock nfH;
    private KeyguardManager.KeyguardLock nfI;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nfG = (PowerManager) this.mContext.getSystemService("power");
            this.nfH = this.nfG.newWakeLock(268435462, "ScreenLockNotify");
            this.nfH.setReferenceCounted(false);
            this.nfF = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nfI = this.nfF.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dLE() {
        try {
            this.nfI.reenableKeyguard();
            if (this.nfH != null) {
                this.nfH.release();
                this.nfH = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dLF() {
        try {
            if (this.nfH == null) {
                this.nfH = this.nfG.newWakeLock(268435462, "ScreenLockNotify");
                this.nfH.setReferenceCounted(false);
            }
            if (this.nfH != null) {
                this.nfH.acquire(10000L);
                this.nfI.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dLG() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nfF, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dLH() {
        return this.nfG.isScreenOn();
    }

    public static Drawable dLI() {
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
