package com.baidu.turbonet.net;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.security.KeyChain;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.CalledByNativeUnchecked;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
/* loaded from: classes13.dex */
public class AndroidNetworkLibrary {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AndroidNetworkLibrary() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bArr) == null) {
            X509Util.b(bArr);
        }
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            X509Util.c();
        }
    }

    @CalledByNative
    public static boolean getIsRoaming(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isRoaming();
        }
        return invokeL.booleanValue;
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return URLConnection.guessContentTypeFromName("foo." + str);
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getNetworkCountryIso(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getNetworkCountryIso();
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getNetworkOperator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getNetworkOperator();
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static String getSimOperator(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "" : telephonyManager.getSimOperator();
        }
        return (String) invokeL.objValue;
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                if (networkInterfaces == null) {
                    return false;
                }
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    try {
                        if (nextElement.isUp() && !nextElement.isLoopback()) {
                            return false;
                        }
                    } catch (SocketException unused) {
                    }
                }
                return true;
            } catch (Exception e2) {
                String str = "could not get network interfaces: " + e2;
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @CalledByNative
    public static boolean storeCertificate(Context context, int i2, byte[] bArr) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65545, null, context, i2, bArr)) == null) {
            try {
                Intent createInstallIntent = KeyChain.createInstallIntent();
                createInstallIntent.addFlags(268435456);
                if (i2 == 1 || i2 == 2) {
                    createInstallIntent.putExtra("CERT", bArr);
                } else if (i2 != 3) {
                    String str = "invalid certificate type: " + i2;
                    return false;
                } else {
                    createInstallIntent.putExtra("PKCS12", bArr);
                }
                context.startActivity(createInstallIntent);
                return true;
            } catch (ActivityNotFoundException e2) {
                String str2 = "could not store crypto file: " + e2;
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    @CalledByNative
    public static boolean storeKeyPair(Context context, byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, context, bArr, bArr2)) == null) {
            try {
                Intent createInstallIntent = KeyChain.createInstallIntent();
                createInstallIntent.putExtra("PKEY", bArr2);
                createInstallIntent.putExtra("KEY", bArr);
                createInstallIntent.addFlags(268435456);
                context.startActivity(createInstallIntent);
                return true;
            } catch (ActivityNotFoundException e2) {
                String str = "could not store key pair: " + e2;
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65547, null, bArr, str, str2, i2)) == null) {
            try {
                return X509Util.n(bArr, str, str2, i2);
            } catch (IllegalArgumentException unused) {
                return new AndroidCertVerifyResult(-1);
            } catch (KeyStoreException unused2) {
                return new AndroidCertVerifyResult(-1);
            } catch (NoSuchAlgorithmException unused3) {
                return new AndroidCertVerifyResult(-1);
            }
        }
        return (AndroidCertVerifyResult) invokeLLLI.objValue;
    }
}
