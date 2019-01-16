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
    private KeyguardManager hDP;
    private PowerManager hDQ;
    private PowerManager.WakeLock hDR;
    private KeyguardManager.KeyguardLock hDS;
    private Context mContext;

    public a() {
        try {
            this.mContext = TbadkCoreApplication.getInst().getApp();
            this.hDQ = (PowerManager) this.mContext.getSystemService(ARResourceKey.HTTP_POWER);
            this.hDR = this.hDQ.newWakeLock(268435462, "ScreenLockNotify");
            this.hDR.setReferenceCounted(false);
            this.hDP = (KeyguardManager) this.mContext.getSystemService("keyguard");
            this.hDS = this.hDP.newKeyguardLock("ScreenLockUtils");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bJg() {
        try {
            this.hDS.reenableKeyguard();
            if (this.hDR != null) {
                this.hDR.release();
                this.hDR = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bJh() {
        try {
            if (this.hDR == null) {
                this.hDR = this.hDQ.newWakeLock(268435462, "ScreenLockNotify");
                this.hDR.setReferenceCounted(false);
            }
            if (this.hDR != null) {
                this.hDR.acquire(ErrDef.Feature.WEIGHT);
                this.hDS.disableKeyguard();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isKeyguardLocked() {
        if (this.hDP == null) {
            return true;
        }
        return this.hDP.inKeyguardRestrictedInputMode();
    }

    public boolean bJi() {
        try {
            return ((Boolean) KeyguardManager.class.getMethod("isKeyguardSecure", new Class[0]).invoke(this.hDP, new Object[0])).booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isScreenOn() {
        return this.hDQ.isScreenOn();
    }

    public static Drawable bJj() {
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
