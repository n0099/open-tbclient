package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.bi;
import com.bytedance.embedapplog.bp;
import com.bytedance.embedapplog.br;
import java.security.MessageDigest;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class bn implements bi {
    private final bi ppE;
    private aw<Boolean> ppq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bi biVar) {
        this.ppq = new aw<Boolean>() { // from class: com.bytedance.embedapplog.bn.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.embedapplog.aw
            /* renamed from: M */
            public Boolean L(Object... objArr) {
                long j;
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return false;
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        j = packageInfo.getLongVersionCode();
                    } else {
                        j = packageInfo.versionCode;
                    }
                    return Boolean.valueOf(j >= 1);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return false;
                }
            }
        };
        this.ppE = biVar;
    }

    @Override // com.bytedance.embedapplog.bi
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        Boolean b = this.ppq.b(context);
        if (this.ppE != null && !b.booleanValue()) {
            return this.ppE.a(context);
        }
        return b.booleanValue();
    }

    @Override // com.bytedance.embedapplog.bi
    public bi.a hR(final Context context) {
        if (this.ppE != null && !this.ppq.b(new Object[0]).booleanValue()) {
            return this.ppE.hR(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        bi.a aVar = new bi.a();
        aVar.b = (String) new bp(context, intent, new bp.b<br, String>() { // from class: com.bytedance.embedapplog.bn.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            /* renamed from: a */
            public br e(IBinder iBinder) {
                return br.a.a(iBinder);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.bytedance.embedapplog.bp.b
            public String a(br brVar) {
                if (brVar == null) {
                    return null;
                }
                String c = bn.this.c(context);
                if (TextUtils.isEmpty(c)) {
                    return null;
                }
                return brVar.a(context.getPackageName(), c, "OUID");
            }
        }).a();
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Context context) {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            signatureArr = packageInfo != null ? packageInfo.signatures : null;
        } catch (Throwable th) {
            th.printStackTrace();
            signatureArr = null;
        }
        if (signatureArr == null || signatureArr.length <= 0) {
            return null;
        }
        byte[] byteArray = signatureArr[0].toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                }
                return sb.toString();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
