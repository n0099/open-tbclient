package com.baidu.tieba.u;

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
    private KeyguardManager kqa;
    private PowerManager kqb;
    private PowerManager.WakeLock kqc;
    private KeyguardManager.KeyguardLock kqd;
    private Context mContext;

    public b() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.kqb = (PowerManager) this.mContext.getSystemService("power");
            this.kqc = this.kqb.newWakeLock(268435462, "ScreenLockNotify");
            this.kqc.setReferenceCounted(false);
            this.kqa = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.kqd = this.kqa.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cMt() {
        try {
            this.kqd.reenableKeyguard();
            if (this.kqc != null) {
                this.kqc.release();
                this.kqc = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void cMu() {
        try {
            if (this.kqc == null) {
                this.kqc = this.kqb.newWakeLock(268435462, "ScreenLockNotify");
                this.kqc.setReferenceCounted(false);
            }
            if (this.kqc != null) {
                this.kqc.acquire(10000L);
                this.kqd.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean cMv() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.kqa, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean cMw() {
        return this.kqb.isScreenOn();
    }

    public static Drawable cMx() {
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
