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
    private KeyguardManager nKa;
    private PowerManager nKb;
    private PowerManager.WakeLock nKc;
    private KeyguardManager.KeyguardLock nKd;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.nKb = (PowerManager) this.mContext.getSystemService("power");
            this.nKc = this.nKb.newWakeLock(268435462, "ScreenLockNotify");
            this.nKc.setReferenceCounted(false);
            this.nKa = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.nKd = this.nKa.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dRJ() {
        try {
            this.nKd.reenableKeyguard();
            if (this.nKc != null) {
                this.nKc.release();
                this.nKc = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dRK() {
        try {
            if (this.nKc == null) {
                this.nKc = this.nKb.newWakeLock(268435462, "ScreenLockNotify");
                this.nKc.setReferenceCounted(false);
            }
            if (this.nKc != null) {
                this.nKc.acquire(10000L);
                this.nKd.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dRL() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.nKa, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dRM() {
        return this.nKb.isScreenOn();
    }

    public static Drawable dRN() {
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
