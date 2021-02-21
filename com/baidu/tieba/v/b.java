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
    private KeyguardManager nKA;
    private PowerManager nKB;
    private PowerManager.WakeLock nKC;
    private KeyguardManager.KeyguardLock nKD;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nKB = (PowerManager) this.mContext.getSystemService("power");
            this.nKC = this.nKB.newWakeLock(268435462, "ScreenLockNotify");
            this.nKC.setReferenceCounted(false);
            this.nKA = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nKD = this.nKA.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dRR() {
        try {
            this.nKD.reenableKeyguard();
            if (this.nKC != null) {
                this.nKC.release();
                this.nKC = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dRS() {
        try {
            if (this.nKC == null) {
                this.nKC = this.nKB.newWakeLock(268435462, "ScreenLockNotify");
                this.nKC.setReferenceCounted(false);
            }
            if (this.nKC != null) {
                this.nKC.acquire(10000L);
                this.nKD.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dRT() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nKA, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dRU() {
        return this.nKB.isScreenOn();
    }

    public static Drawable dRV() {
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
