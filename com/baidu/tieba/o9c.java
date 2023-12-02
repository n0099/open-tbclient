package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.ui.SystemBarTintManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
/* loaded from: classes7.dex */
public class o9c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (bArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (byte b : bArr) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        sb.append(TransactionIdCreater.FILL_BYTE);
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static byte[] h(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new byte[0];
            }
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length = upperCase.length() / 2;
            byte[] bArr = new byte[length];
            try {
                byte[] bytes = upperCase.getBytes(StandardCharsets.UTF_8);
                for (int i2 = 0; i2 < length; i2++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("0x");
                    sb.append(new String(new byte[]{bytes[i2 * 2]}, StandardCharsets.UTF_8));
                    bArr[i2] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i + 1]}, StandardCharsets.UTF_8)).byteValue());
                }
            } catch (NumberFormatException e) {
                String str2 = "hex string 2 byte array exception : " + e.getMessage();
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] i(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i)) == null) {
            if (bArr == null) {
                return bArr;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (i < 0) {
                    bArr[i2] = (byte) (bArr[i2] << (-i));
                } else {
                    bArr[i2] = (byte) (bArr[i2] >> i);
                }
            }
            return bArr;
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] j(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bArr, bArr2)) == null) {
            byte[] bArr3 = null;
            if (bArr != null) {
                int length = bArr.length;
                if (length != bArr2.length) {
                    return null;
                }
                bArr3 = new byte[length];
                for (int i = 0; i < length; i++) {
                    bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
                }
            }
            return bArr3;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static RequestHeader a() throws ApiException {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context a = v9c.e.a();
            String str2 = null;
            try {
                Object obj = a.getPackageManager().getApplicationInfo(a.getPackageName(), 128).metaData.get("com.hihonor.push.app_id");
                if (obj != null) {
                    str2 = String.valueOf(obj);
                }
            } catch (PackageManager.NameNotFoundException e) {
                q9c.b("ConfigUtils", "getPushAppId", e);
            }
            if (!TextUtils.isEmpty(str2)) {
                String str3 = "checkPushAppId Parameter is " + str2;
                String e2 = e(a, a.getPackageName());
                if (!TextUtils.isEmpty(e2)) {
                    String str4 = "checkPushCertFingerprint Parameter is " + e2;
                    RequestHeader requestHeader = new RequestHeader();
                    requestHeader.setPackageName(a.getPackageName());
                    requestHeader.setAppId(str2);
                    requestHeader.setCertificateFingerprint(e2);
                    t9c t9cVar = t9c.b;
                    requestHeader.setPushToken(t9cVar.c(a));
                    synchronized (t9cVar) {
                        t9cVar.a(a);
                        SharedPreferences sharedPreferences = t9c.a.a;
                        if (sharedPreferences != null) {
                            str = sharedPreferences.getString("key_aaid", "");
                        } else {
                            str = "";
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = UUID.randomUUID().toString().replace("-", "");
                            String str5 = "getRandomUUID UUID =" + str;
                            t9c.a.b("key_aaid", str);
                        }
                    }
                    requestHeader.setAAID(str);
                    requestHeader.setSdkVersion(70001103);
                    return requestHeader;
                }
                q9c.a("checkPushConfig Parameter is missing.");
                throw HonorPushErrorEnum.ERROR_CERT_FINGERPRINT_EMPTY.toApiException();
            }
            q9c.a("checkPushConfig Parameter is missing");
            throw HonorPushErrorEnum.ERROR_NO_APPID.toApiException();
        }
        return (RequestHeader) invokeV.objValue;
    }

    public static ApiException b(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, exc)) == null) {
            if (exc.getCause() instanceof ApiException) {
                return (ApiException) exc.getCause();
            }
            if (exc instanceof ApiException) {
                return (ApiException) exc;
            }
            return new ApiException(-1, exc.getMessage());
        }
        return (ApiException) invokeL.objValue;
    }

    public static <TResult> hac<TResult> c(Callable<TResult> callable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, callable)) == null) {
            ExecutorService executorService = abc.c.b;
            zac zacVar = new zac();
            try {
                executorService.execute(new eac(zacVar, callable));
            } catch (Exception e) {
                zacVar.a(e);
            }
            return zacVar.a;
        }
        return (hac) invokeL.objValue;
    }

    public static void g(Handler handler) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, handler) != null) || Looper.myLooper() == handler.getLooper()) {
            return;
        }
        throw new IllegalStateException("Must be called on the handler thread");
    }

    public static <TResult> TResult d(hac<TResult> hacVar) throws ExecutionException, InterruptedException {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hacVar)) == null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                synchronized (hacVar.a) {
                    z = hacVar.b;
                }
                if (z) {
                    if (hacVar.f()) {
                        return hacVar.d();
                    }
                    throw new ExecutionException(hacVar.c());
                }
                lac lacVar = new lac();
                abc abcVar = abc.c;
                hacVar.a(new cac(abcVar.a, lacVar));
                hacVar.a(new y9c(abcVar.a, lacVar));
                hacVar.a(new p9c(abcVar.a, lacVar));
                lacVar.a.await();
                if (hacVar.f()) {
                    return hacVar.d();
                }
                throw new ExecutionException(hacVar.c());
            }
            throw new IllegalStateException("await must not be called on the UI thread");
        }
        return (TResult) invokeL.objValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0054 -> B:20:0x0055). Please submit an issue!!! */
    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Signature[] signatureArr;
        String str2;
        SigningInfo signingInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            String str3 = "getCertFingerprint pkgName=" + str + "onlyOne=true";
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 30) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, SystemBarTintManager.FLAG_TRANSLUCENT_NAVIGATION);
                if (packageInfo != null && (signingInfo = packageInfo.signingInfo) != null) {
                    if (signingInfo.hasMultipleSigners()) {
                        signatureArr = signingInfo.getApkContentsSigners();
                    } else {
                        signatureArr = signingInfo.getSigningCertificateHistory();
                    }
                }
                signatureArr = null;
            } else {
                PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
                if (packageInfo2 != null) {
                    signatureArr = packageInfo2.signatures;
                }
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                int length = signatureArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    try {
                        byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[i].toByteArray());
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            String upperCase = Integer.toHexString(b & 255).toUpperCase(Locale.US);
                            if (upperCase.length() == 1) {
                                sb.append("0");
                            }
                            sb.append(upperCase);
                        }
                        str2 = sb.toString();
                    } catch (NoSuchAlgorithmException unused) {
                        str2 = null;
                    }
                    if (str2 != null) {
                        arrayList.add(str2);
                        break;
                    }
                    i++;
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return (String) arrayList.get(0);
        }
        return (String) invokeLL.objValue;
    }
}
