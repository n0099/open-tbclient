package com.baidu.tieba.t;

import android.app.KeyguardManager;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.PowerManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private KeyguardManager hbs;
    private PowerManager hbt;
    private PowerManager.WakeLock hbu;
    private KeyguardManager.KeyguardLock hbv;
    private Context mContext;

    public a() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.hbt = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.hbu = this.hbt.newWakeLock(268435462, "ScreenLockNotify");
            this.hbu.setReferenceCounted(false);
            this.hbs = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.hbv = this.hbs.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bzZ() {
        try {
            this.hbv.reenableKeyguard();
            if (this.hbu != null) {
                this.hbu.release();
                this.hbu = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bAa() {
        try {
            if (this.hbu == null) {
                this.hbu = this.hbt.newWakeLock(268435462, "ScreenLockNotify");
                this.hbu.setReferenceCounted(false);
            }
            if (this.hbu != null) {
                this.hbu.acquire(10000L);
                this.hbv.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isKeyguardLocked() {
        if (this.hbs == null) {
            return true;
        }
        return this.hbs.inKeyguardRestrictedInputMode();
    }

    public boolean bAb() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.hbs, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.hbt.isScreenOn();
    }

    public static Drawable bAc() {
        Bitmap bitmap;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        try {
            Drawable drawable = WallpaperManager.getInstance(inst).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.ah(inst), bitmap.getWidth());
                int min2 = Math.min(l.aj(inst), bitmap.getHeight());
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
