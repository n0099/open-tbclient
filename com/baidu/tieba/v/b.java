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
    private KeyguardManager lgF;
    private PowerManager lgG;
    private PowerManager.WakeLock lgH;
    private KeyguardManager.KeyguardLock lgI;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.lgG = (PowerManager) this.mContext.getSystemService("power");
            this.lgH = this.lgG.newWakeLock(268435462, "ScreenLockNotify");
            this.lgH.setReferenceCounted(false);
            this.lgF = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.lgI = this.lgF.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dao() {
        try {
            this.lgI.reenableKeyguard();
            if (this.lgH != null) {
                this.lgH.release();
                this.lgH = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dap() {
        try {
            if (this.lgH == null) {
                this.lgH = this.lgG.newWakeLock(268435462, "ScreenLockNotify");
                this.lgH.setReferenceCounted(false);
            }
            if (this.lgH != null) {
                this.lgH.acquire(10000L);
                this.lgI.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean daq() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.lgF, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dar() {
        return this.lgG.isScreenOn();
    }

    public static Drawable das() {
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
