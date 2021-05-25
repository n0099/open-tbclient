package com.baidu.wallet.base.nopassauth;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BeanConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
/* loaded from: classes5.dex */
public final class OtpTokenUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23268a = "OtpTokenUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final String f23269b = "key_later_server_time";

    /* renamed from: c  reason: collision with root package name */
    public static long f23270c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static int f23271d = 10;

    public static InputStream a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static String getEncryptTOtpCode(Context context, int i2, String str, int i3) {
        return !TextUtils.isEmpty(str) ? new c(str, i2, 0L, i3).a(context) : "";
    }

    public static String getSN(String str) {
        String[] split;
        String decryptProxy = SafePay.getInstance().decryptProxy(str);
        if (TextUtils.isEmpty(decryptProxy) || (split = decryptProxy.split("\\|")) == null || split.length != 9) {
            return null;
        }
        return split[2];
    }

    public static String getSafeSavedData(String str, Context context) {
        String passUid = WalletLoginHelper.getInstance().getPassUid();
        String str2 = SafePay.getInstance().tokenDecrypt(str);
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            if (bytes.length >= 1) {
                byte[] bArr = new byte[bytes.length - 1];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length - 1);
                if (bytes[bytes.length - 1] == 1 && !TextUtils.isEmpty(passUid)) {
                    bArr = xorArrayRepeat(bArr, passUid.getBytes("UTF-8"));
                }
                return new String(bArr, "UTF-8");
            }
            return "";
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getSafeSavedDataByUnionId(String str, Context context) {
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        String str2 = SafePay.getInstance().tokenDecrypt(str);
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            if (bytes.length >= 1) {
                byte[] bArr = new byte[bytes.length - 1];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length - 1);
                if (bytes[bytes.length - 1] == 1 && !TextUtils.isEmpty(unionId)) {
                    bArr = xorArrayRepeat(bArr, unionId.getBytes("UTF-8"));
                }
                return new String(bArr, "UTF-8");
            }
            return "";
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static long getmSyncWithServerTime(Context context) {
        return ((Long) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, f23269b, 0L)).longValue();
    }

    public static void setmSyncWithServerTime(Context context, long j) {
        SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, f23269b, Long.valueOf(j));
    }

    public static long syncTime(long j) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            try {
                f23270c = 0L;
                httpsURLConnection = (HttpsURLConnection) new URL("https://www.baidu.com/").openConnection();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setConnectTimeout(f23271d * 1000);
            httpsURLConnection.setHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.wallet.base.nopassauth.OtpTokenUtils.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return "www.baidu.com".equals(str) || "m.baidu.com".equals(str);
                }
            });
            httpsURLConnection.connect();
            f23270c = httpsURLConnection.getDate() / 1000;
            if (httpsURLConnection != null) {
                try {
                    InputStream a2 = a(httpsURLConnection);
                    if (a2 != null) {
                        a2.close();
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                httpsURLConnection.disconnect();
            }
            return (System.currentTimeMillis() / 1000) - f23270c;
        } catch (Exception e4) {
            e = e4;
            httpsURLConnection2 = httpsURLConnection;
            e.printStackTrace();
            if (httpsURLConnection2 != null) {
                try {
                    InputStream a3 = a(httpsURLConnection2);
                    if (a3 != null) {
                        a3.close();
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                httpsURLConnection2.disconnect();
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            httpsURLConnection2 = httpsURLConnection;
            if (httpsURLConnection2 != null) {
                try {
                    InputStream a4 = a(httpsURLConnection2);
                    if (a4 != null) {
                        a4.close();
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                httpsURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public static String toSafeSavedData(String str, Context context) {
        byte[] a2;
        String passUid = WalletLoginHelper.getInstance().getPassUid();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(passUid)) {
                    a2 = a(str.getBytes("UTF-8"), false);
                } else {
                    a2 = a(xorArrayRepeat(str.getBytes("UTF-8"), passUid.getBytes("UTF-8")), true);
                }
                return SafePay.getInstance().tokenEncrypt(new String(a2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static String toSafeSavedDataByUnionId(String str, Context context) {
        byte[] a2;
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        if (!TextUtils.isEmpty(str)) {
            try {
                if (TextUtils.isEmpty(unionId)) {
                    a2 = a(str.getBytes("UTF-8"), false);
                } else {
                    a2 = a(xorArrayRepeat(str.getBytes("UTF-8"), unionId.getBytes("UTF-8")), true);
                }
                return SafePay.getInstance().tokenEncrypt(new String(a2, "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static byte[] xorArrayRepeat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            bArr3[i3] = (byte) (bArr[i2] ^ bArr2[i3 % bArr2.length]);
            i2++;
            i3++;
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, boolean z) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length + 1];
        int i2 = 0;
        for (byte b2 : bArr) {
            bArr2[i2] = b2;
            i2++;
        }
        bArr2[bArr.length] = z ? (byte) 1 : (byte) 0;
        return bArr2;
    }
}
