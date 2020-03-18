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
    private KeyguardManager.KeyguardLock kwA;
    private KeyguardManager kwx;
    private PowerManager kwy;
    private PowerManager.WakeLock kwz;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.kwy = (PowerManager) this.mContext.getSystemService("power");
            this.kwz = this.kwy.newWakeLock(268435462, "ScreenLockNotify");
            this.kwz.setReferenceCounted(false);
            this.kwx = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.kwA = this.kwx.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cPs() {
        try {
            this.kwA.reenableKeyguard();
            if (this.kwz != null) {
                this.kwz.release();
                this.kwz = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cPt() {
        try {
            if (this.kwz == null) {
                this.kwz = this.kwy.newWakeLock(268435462, "ScreenLockNotify");
                this.kwz.setReferenceCounted(false);
            }
            if (this.kwz != null) {
                this.kwz.acquire(10000L);
                this.kwA.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cPu() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.kwx, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean cPv() {
        return this.kwy.isScreenOn();
    }

    public static Drawable cPw() {
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
