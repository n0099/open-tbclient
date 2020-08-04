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
    private KeyguardManager mbD;
    private PowerManager mbE;
    private PowerManager.WakeLock mbF;
    private KeyguardManager.KeyguardLock mbG;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.mbE = (PowerManager) this.mContext.getSystemService("power");
            this.mbF = this.mbE.newWakeLock(268435462, "ScreenLockNotify");
            this.mbF.setReferenceCounted(false);
            this.mbD = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.mbG = this.mbD.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dpm() {
        try {
            this.mbG.reenableKeyguard();
            if (this.mbF != null) {
                this.mbF.release();
                this.mbF = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dpn() {
        try {
            if (this.mbF == null) {
                this.mbF = this.mbE.newWakeLock(268435462, "ScreenLockNotify");
                this.mbF.setReferenceCounted(false);
            }
            if (this.mbF != null) {
                this.mbF.acquire(10000L);
                this.mbG.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean dpo() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.mbD, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean dpp() {
        return this.mbE.isScreenOn();
    }

    public static Drawable dpq() {
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
