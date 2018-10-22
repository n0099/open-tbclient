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
    private KeyguardManager hqC;
    private PowerManager hqD;
    private PowerManager.WakeLock hqE;
    private KeyguardManager.KeyguardLock hqF;
    private Context mContext;

    public a() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.hqD = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.hqE = this.hqD.newWakeLock(268435462, "ScreenLockNotify");
            this.hqE.setReferenceCounted(false);
            this.hqC = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.hqF = this.hqC.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bGe() {
        try {
            this.hqF.reenableKeyguard();
            if (this.hqE != null) {
                this.hqE.release();
                this.hqE = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bGf() {
        try {
            if (this.hqE == null) {
                this.hqE = this.hqD.newWakeLock(268435462, "ScreenLockNotify");
                this.hqE.setReferenceCounted(false);
            }
            if (this.hqE != null) {
                this.hqE.acquire(ErrDef.Feature.WEIGHT);
                this.hqF.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isKeyguardLocked() {
        if (this.hqC == null) {
            return true;
        }
        return this.hqC.inKeyguardRestrictedInputMode();
    }

    public boolean bGg() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.hqC, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.hqD.isScreenOn();
    }

    public static Drawable bGh() {
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
