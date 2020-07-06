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
    private KeyguardManager lUl;
    private PowerManager lUm;
    private PowerManager.WakeLock lUn;
    private KeyguardManager.KeyguardLock lUo;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.lUm = (PowerManager) this.mContext.getSystemService("power");
            this.lUn = this.lUm.newWakeLock(268435462, "ScreenLockNotify");
            this.lUn.setReferenceCounted(false);
            this.lUl = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.lUo = this.lUl.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dmb() {
        try {
            this.lUo.reenableKeyguard();
            if (this.lUn != null) {
                this.lUn.release();
                this.lUn = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dmc() {
        try {
            if (this.lUn == null) {
                this.lUn = this.lUm.newWakeLock(268435462, "ScreenLockNotify");
                this.lUn.setReferenceCounted(false);
            }
            if (this.lUn != null) {
                this.lUn.acquire(10000L);
                this.lUo.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dmd() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.lUl, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dme() {
        return this.lUm.isScreenOn();
    }

    public static Drawable dmf() {
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
