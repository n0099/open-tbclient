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
    private KeyguardManager mTc;
    private PowerManager mTd;
    private PowerManager.WakeLock mTe;
    private KeyguardManager.KeyguardLock mTf;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.mTd = (PowerManager) this.mContext.getSystemService("power");
            this.mTe = this.mTd.newWakeLock(268435462, "ScreenLockNotify");
            this.mTe.setReferenceCounted(false);
            this.mTc = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.mTf = this.mTc.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dIw() {
        try {
            this.mTf.reenableKeyguard();
            if (this.mTe != null) {
                this.mTe.release();
                this.mTe = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dIx() {
        try {
            if (this.mTe == null) {
                this.mTe = this.mTd.newWakeLock(268435462, "ScreenLockNotify");
                this.mTe.setReferenceCounted(false);
            }
            if (this.mTe != null) {
                this.mTe.acquire(10000L);
                this.mTf.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dIy() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.mTc, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dIz() {
        return this.mTd.isScreenOn();
    }

    public static Drawable dIA() {
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
