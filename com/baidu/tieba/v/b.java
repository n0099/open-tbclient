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
    private KeyguardManager mDp;
    private PowerManager mDq;
    private PowerManager.WakeLock mDr;
    private KeyguardManager.KeyguardLock mDs;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.mDq = (PowerManager) this.mContext.getSystemService("power");
            this.mDr = this.mDq.newWakeLock(268435462, "ScreenLockNotify");
            this.mDr.setReferenceCounted(false);
            this.mDp = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.mDs = this.mDp.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dEK() {
        try {
            this.mDs.reenableKeyguard();
            if (this.mDr != null) {
                this.mDr.release();
                this.mDr = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dEL() {
        try {
            if (this.mDr == null) {
                this.mDr = this.mDq.newWakeLock(268435462, "ScreenLockNotify");
                this.mDr.setReferenceCounted(false);
            }
            if (this.mDr != null) {
                this.mDr.acquire(10000L);
                this.mDs.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dEM() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.mDp, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dEN() {
        return this.mDq.isScreenOn();
    }

    public static Drawable dEO() {
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
