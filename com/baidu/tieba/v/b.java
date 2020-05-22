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
    private KeyguardManager lzu;
    private PowerManager lzv;
    private PowerManager.WakeLock lzw;
    private KeyguardManager.KeyguardLock lzx;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.lzv = (PowerManager) this.mContext.getSystemService("power");
            this.lzw = this.lzv.newWakeLock(268435462, "ScreenLockNotify");
            this.lzw.setReferenceCounted(false);
            this.lzu = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.lzx = this.lzu.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dhA() {
        try {
            this.lzx.reenableKeyguard();
            if (this.lzw != null) {
                this.lzw.release();
                this.lzw = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dhB() {
        try {
            if (this.lzw == null) {
                this.lzw = this.lzv.newWakeLock(268435462, "ScreenLockNotify");
                this.lzw.setReferenceCounted(false);
            }
            if (this.lzw != null) {
                this.lzw.acquire(10000L);
                this.lzx.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dhC() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.lzu, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dhD() {
        return this.lzv.isScreenOn();
    }

    public static Drawable dhE() {
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
