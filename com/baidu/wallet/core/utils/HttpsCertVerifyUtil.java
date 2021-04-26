package com.baidu.wallet.core.utils;

import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class HttpsCertVerifyUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24730a = ",";

    public static boolean a(int i2) {
        return 3 == i2 || 4 == i2 || 5 == i2;
    }

    public static byte[] a(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        int length = str.length() / 2;
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            int indexOf = "0123456789abcdef".indexOf(charArray[i3]) << 4;
            int indexOf2 = "0123456789abcdef".indexOf(charArray[i3 + 1]);
            if (indexOf == -1 || indexOf2 == -1) {
                return null;
            }
            bArr[i2] = (byte) (indexOf2 | indexOf);
        }
        return bArr;
    }

    public static boolean isWhiteListVerificationPassed(SslError sslError) {
        if (sslError == null) {
            return false;
        }
        int primaryError = sslError.getPrimaryError();
        if (a(primaryError)) {
            String[] a2 = a();
            if (a2 != null && a2.length != 0) {
                byte[] a3 = a(sslError.getCertificate());
                if (a3 == null) {
                    LogUtil.d("currentSHA256 byte[] is null or 0.");
                    return false;
                }
                for (String str : a2) {
                    if (Arrays.equals(a3, a(str.toLowerCase()))) {
                        DXMSdkSAUtils.onEventWithValues(StatServiceEvent.CERTIFICATE_WHITE_LIST_PASSED, Arrays.asList(primaryError + "", sslError.getUrl(), str));
                        PayStatisticsUtil.onEventWithValues(StatServiceEvent.CERTIFICATE_WHITE_LIST_PASSED, Arrays.asList(primaryError + "", sslError.getUrl(), str));
                        return true;
                    }
                }
                DXMSdkSAUtils.onEventWithValues(StatServiceEvent.CERTIFICATE_WHITE_LIST_FAILED, Arrays.asList(primaryError + "", sslError.getUrl(), a(a3)));
                PayStatisticsUtil.onEventWithValues(StatServiceEvent.CERTIFICATE_WHITE_LIST_FAILED, Arrays.asList(primaryError + "", sslError.getUrl(), a(a3)));
                return false;
            }
            LogUtil.d("certWhiteList is null or 0.");
            return false;
        }
        LogUtil.d("Ssl Error not in Verify filed!");
        return false;
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String[] a() {
        String str = SdkInitResponse.getInstance().certWhiteList;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(",");
    }

    public static byte[] a(SslCertificate sslCertificate) {
        if (sslCertificate == null) {
            LogUtil.d("sslCertificate is null");
            return null;
        }
        Bundle saveState = SslCertificate.saveState(sslCertificate);
        if (saveState != null) {
            byte[] byteArray = saveState.getByteArray("x509-certificate");
            if (byteArray != null) {
                try {
                    return MessageDigest.getInstance("SHA-256").digest(CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(byteArray)).getEncoded());
                } catch (NoSuchAlgorithmException e2) {
                    LogUtil.d(e2.getMessage());
                    return null;
                } catch (CertificateException e3) {
                    LogUtil.d(e3.getMessage());
                    return null;
                }
            }
            LogUtil.d("bytes is null");
            return null;
        }
        LogUtil.d("bundle is null");
        return null;
    }
}
