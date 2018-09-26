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
    private KeyguardManager hjl;
    private PowerManager hjm;
    private PowerManager.WakeLock hjn;
    private KeyguardManager.KeyguardLock hjo;
    private Context mContext;

    public a() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.hjm = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.hjn = this.hjm.newWakeLock(268435462, "ScreenLockNotify");
            this.hjn.setReferenceCounted(false);
            this.hjl = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.hjo = this.hjl.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bCQ() {
        try {
            this.hjo.reenableKeyguard();
            if (this.hjn != null) {
                this.hjn.release();
                this.hjn = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bCR() {
        try {
            if (this.hjn == null) {
                this.hjn = this.hjm.newWakeLock(268435462, "ScreenLockNotify");
                this.hjn.setReferenceCounted(false);
            }
            if (this.hjn != null) {
                this.hjn.acquire(10000L);
                this.hjo.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isKeyguardLocked() {
        if (this.hjl == null) {
            return true;
        }
        return this.hjl.inKeyguardRestrictedInputMode();
    }

    public boolean bCS() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.hjl, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.hjm.isScreenOn();
    }

    public static Drawable bCT() {
        Bitmap bitmap;
        TbadkCoreApplication inst = TbadkCoreApplication.getInst();
        try {
            Drawable drawable = WallpaperManager.getInstance(inst).getDrawable();
            if (drawable != null && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                int min = Math.min(l.aO(inst), bitmap.getWidth());
                int min2 = Math.min(l.aQ(inst), bitmap.getHeight());
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
