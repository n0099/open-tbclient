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
/* loaded from: classes2.dex */
public class b {
    private Context mContext;
    private KeyguardManager mto;
    private PowerManager mtp;
    private PowerManager.WakeLock mtq;
    private KeyguardManager.KeyguardLock mtr;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.mtp = (PowerManager) this.mContext.getSystemService("power");
            this.mtq = this.mtp.newWakeLock(268435462, "ScreenLockNotify");
            this.mtq.setReferenceCounted(false);
            this.mto = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.mtr = this.mto.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dAH() {
        try {
            this.mtr.reenableKeyguard();
            if (this.mtq != null) {
                this.mtq.release();
                this.mtq = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dAI() {
        try {
            if (this.mtq == null) {
                this.mtq = this.mtp.newWakeLock(268435462, "ScreenLockNotify");
                this.mtq.setReferenceCounted(false);
            }
            if (this.mtq != null) {
                this.mtq.acquire(10000L);
                this.mtr.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dAJ() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.mto, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dAK() {
        return this.mtp.isScreenOn();
    }

    public static Drawable dAL() {
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
