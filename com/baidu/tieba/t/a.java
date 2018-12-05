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
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private KeyguardManager.KeyguardLock hzA;
    private KeyguardManager hzx;
    private PowerManager hzy;
    private PowerManager.WakeLock hzz;
    private Context mContext;

    public a() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.hzy = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.hzz = this.hzy.newWakeLock(268435462, "ScreenLockNotify");
            this.hzz.setReferenceCounted(false);
            this.hzx = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.hzA = this.hzx.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bHI() {
        try {
            this.hzA.reenableKeyguard();
            if (this.hzz != null) {
                this.hzz.release();
                this.hzz = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bHJ() {
        try {
            if (this.hzz == null) {
                this.hzz = this.hzy.newWakeLock(268435462, "ScreenLockNotify");
                this.hzz.setReferenceCounted(false);
            }
            if (this.hzz != null) {
                this.hzz.acquire(ErrDef.Feature.WEIGHT);
                this.hzA.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isKeyguardLocked() {
        if (this.hzx == null) {
            return true;
        }
        return this.hzx.inKeyguardRestrictedInputMode();
    }

    public boolean bHK() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.hzx, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.hzy.isScreenOn();
    }

    public static Drawable bHL() {
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
