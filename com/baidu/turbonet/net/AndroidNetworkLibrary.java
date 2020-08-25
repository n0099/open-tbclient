package com.baidu.turbonet.net;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.security.KeyChain;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.CalledByNativeUnchecked;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
/* loaded from: classes10.dex */
class AndroidNetworkLibrary {
    AndroidNetworkLibrary() {
    }

    @CalledByNative
    public static boolean storeKeyPair(Context context, byte[] bArr, byte[] bArr2) {
        try {
            Intent createInstallIntent = KeyChain.createInstallIntent();
            createInstallIntent.putExtra("PKEY", bArr2);
            createInstallIntent.putExtra("KEY", bArr);
            createInstallIntent.addFlags(268435456);
            context.startActivity(createInstallIntent);
            return true;
        } catch (ActivityNotFoundException e) {
            Log.w("AndroidNetworkLibrary", "could not store key pair: " + e);
            return false;
        }
    }

    @CalledByNative
    public static boolean storeCertificate(Context context, int i, byte[] bArr) {
        try {
            Intent createInstallIntent = KeyChain.createInstallIntent();
            createInstallIntent.addFlags(268435456);
            switch (i) {
                case 1:
                case 2:
                    createInstallIntent.putExtra("CERT", bArr);
                    break;
                case 3:
                    createInstallIntent.putExtra("PKCS12", bArr);
                    break;
                default:
                    Log.w("AndroidNetworkLibrary", "invalid certificate type: " + i);
                    return false;
            }
            context.startActivity(createInstallIntent);
            return true;
        } catch (ActivityNotFoundException e) {
            Log.w("AndroidNetworkLibrary", "could not store crypto file: " + e);
            return false;
        }
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String str) {
        return URLConnection.guessContentTypeFromName("foo." + str);
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
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
                } catch (SocketException e) {
                }
            }
            return true;
        } catch (Exception e2) {
            Log.w("AndroidNetworkLibrary", "could not get network interfaces: " + e2);
            return false;
        }
    }

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] bArr, String str, String str2, int i) {
        try {
            return X509Util.verifyServerCertificates(bArr, str, str2, i);
        } catch (IllegalArgumentException e) {
            return new AndroidCertVerifyResult(-1);
        } catch (KeyStoreException e2) {
            return new AndroidCertVerifyResult(-1);
        } catch (NoSuchAlgorithmException e3) {
            return new AndroidCertVerifyResult(-1);
        }
    }

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] bArr) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        X509Util.addTestRootCertificate(bArr);
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        X509Util.clearTestRootCertificates();
    }

    @CalledByNative
    private static String getNetworkCountryIso(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getNetworkCountryIso();
    }

    @CalledByNative
    private static String getNetworkOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getNetworkOperator();
    }

    @CalledByNative
    private static String getSimOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager == null ? "" : telephonyManager.getSimOperator();
    }

    @CalledByNative
    private static boolean getIsRoaming(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isRoaming();
    }
}
