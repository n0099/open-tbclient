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
import com.baidu.ar.parser.ARResourceKey;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private KeyguardManager hCI;
    private PowerManager hCJ;
    private PowerManager.WakeLock hCK;
    private KeyguardManager.KeyguardLock hCL;
    private Context mContext;

    public a() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.hCJ = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.hCK = this.hCJ.newWakeLock(268435462, "ScreenLockNotify");
            this.hCK.setReferenceCounted(false);
            this.hCI = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.hCL = this.hCI.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bIx() {
        try {
            this.hCL.reenableKeyguard();
            if (this.hCK != null) {
                this.hCK.release();
                this.hCK = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bIy() {
        try {
            if (this.hCK == null) {
                this.hCK = this.hCJ.newWakeLock(268435462, "ScreenLockNotify");
                this.hCK.setReferenceCounted(false);
            }
            if (this.hCK != null) {
                this.hCK.acquire(ErrDef.Feature.WEIGHT);
                this.hCL.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isKeyguardLocked() {
        if (this.hCI == null) {
            return true;
        }
        return this.hCI.inKeyguardRestrictedInputMode();
    }

    public boolean bIz() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.hCI, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.hCJ.isScreenOn();
    }

    public static Drawable bIA() {
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
