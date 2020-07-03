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
    private KeyguardManager lUi;
    private PowerManager lUj;
    private PowerManager.WakeLock lUk;
    private KeyguardManager.KeyguardLock lUl;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.lUj = (PowerManager) this.mContext.getSystemService("power");
            this.lUk = this.lUj.newWakeLock(268435462, "ScreenLockNotify");
            this.lUk.setReferenceCounted(false);
            this.lUi = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.lUl = this.lUi.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dlX() {
        try {
            this.lUl.reenableKeyguard();
            if (this.lUk != null) {
                this.lUk.release();
                this.lUk = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dlY() {
        try {
            if (this.lUk == null) {
                this.lUk = this.lUj.newWakeLock(268435462, "ScreenLockNotify");
                this.lUk.setReferenceCounted(false);
            }
            if (this.lUk != null) {
                this.lUk.acquire(10000L);
                this.lUl.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dlZ() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.lUi, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dma() {
        return this.lUj.isScreenOn();
    }

    public static Drawable dmb() {
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
