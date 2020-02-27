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
    private KeyguardManager kuF;
    private PowerManager kuG;
    private PowerManager.WakeLock kuH;
    private KeyguardManager.KeyguardLock kuI;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.kuG = (PowerManager) this.mContext.getSystemService("power");
            this.kuH = this.kuG.newWakeLock(268435462, "ScreenLockNotify");
            this.kuH.setReferenceCounted(false);
            this.kuF = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.kuI = this.kuF.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cOV() {
        try {
            this.kuI.reenableKeyguard();
            if (this.kuH != null) {
                this.kuH.release();
                this.kuH = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cOW() {
        try {
            if (this.kuH == null) {
                this.kuH = this.kuG.newWakeLock(268435462, "ScreenLockNotify");
                this.kuH.setReferenceCounted(false);
            }
            if (this.kuH != null) {
                this.kuH.acquire(10000L);
                this.kuI.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cOX() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.kuF, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean cOY() {
        return this.kuG.isScreenOn();
    }

    public static Drawable cOZ() {
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
