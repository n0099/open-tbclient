package com.bytedance.pangle.f;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.lang.ref.WeakReference;
import java.security.cert.CertificateException;
/* loaded from: classes2.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static WeakReference<Signature[]> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        o a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                if (com.bytedance.pangle.util.g.a()) {
                    a2 = d.a(str);
                } else {
                    a2 = a.a(str);
                }
                Signature[] signatureArr = a2 != null ? a2.f55171b : null;
                WeakReference<Signature[]> weakReference = a;
                Signature[] signatureArr2 = weakReference != null ? weakReference.get() : null;
                if (signatureArr2 == null || signatureArr2.length == 0) {
                    try {
                        PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 64);
                        Signature[] signatureArr3 = packageInfo.signatures;
                        a = new WeakReference<>(packageInfo.signatures);
                        signatureArr2 = signatureArr3;
                    } catch (PackageManager.NameNotFoundException unused) {
                        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get host signature error : ".concat(String.valueOf(str)));
                        return false;
                    }
                }
                try {
                    return o.b(signatureArr2, signatureArr);
                } catch (CertificateException unused2) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify host-plugin signature are effective match : ".concat(String.valueOf(str)));
                    return false;
                }
            } catch (q unused3) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
