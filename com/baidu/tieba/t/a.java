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
    private KeyguardManager hsl;
    private PowerManager hsm;
    private PowerManager.WakeLock hsn;
    private KeyguardManager.KeyguardLock hso;
    private Context mContext;

    public a() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.hsm = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.hsn = this.hsm.newWakeLock(268435462, "ScreenLockNotify");
            this.hsn.setReferenceCounted(false);
            this.hsl = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.hso = this.hsl.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bFD() {
        try {
            this.hso.reenableKeyguard();
            if (this.hsn != null) {
                this.hsn.release();
                this.hsn = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bFE() {
        try {
            if (this.hsn == null) {
                this.hsn = this.hsm.newWakeLock(268435462, "ScreenLockNotify");
                this.hsn.setReferenceCounted(false);
            }
            if (this.hsn != null) {
                this.hsn.acquire(ErrDef.Feature.WEIGHT);
                this.hso.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isKeyguardLocked() {
        if (this.hsl == null) {
            return true;
        }
        return this.hsl.inKeyguardRestrictedInputMode();
    }

    public boolean bFF() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.hsl, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.hsm.isScreenOn();
    }

    public static Drawable bFG() {
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
