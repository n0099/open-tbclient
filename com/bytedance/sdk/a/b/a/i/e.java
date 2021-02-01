package com.bytedance.sdk.a.b.a.i;

import com.baidu.android.common.others.IStringUtil;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
/* loaded from: classes6.dex */
public final class e implements HostnameVerifier {
    public static final e pqO = new e();

    private e() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException e) {
            return false;
        }
    }

    public boolean a(String str, X509Certificate x509Certificate) {
        if (com.bytedance.sdk.a.b.a.c.c(str)) {
            return b(str, x509Certificate);
        }
        return c(str, x509Certificate);
    }

    private boolean b(String str, X509Certificate x509Certificate) {
        List<String> a2 = a(x509Certificate, 7);
        int size = a2.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(a2.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean c(String str, X509Certificate x509Certificate) {
        String a2;
        String lowerCase = str.toLowerCase(Locale.US);
        List<String> a3 = a(x509Certificate, 2);
        int size = a3.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            if (a(lowerCase, a3.get(i))) {
                return true;
            }
            i++;
            z = true;
        }
        if (z || (a2 = new d(x509Certificate.getSubjectX500Principal()).a(AdvanceSetting.CLEAR_NOTIFICATION)) == null) {
            return false;
        }
        return a(lowerCase, a2);
    }

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> a2 = a(x509Certificate, 7);
        List<String> a3 = a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(a2.size() + a3.size());
        arrayList.addAll(a2);
        arrayList.addAll(a3);
        return arrayList;
    }

    private static List<String> a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException e) {
            return Collections.emptyList();
        }
    }

    public boolean a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith(IStringUtil.TOP_PATH) || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith(IStringUtil.TOP_PATH)) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + '.';
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains("*")) {
            return str.equals(lowerCase);
        }
        if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
            return false;
        }
        String substring = lowerCase.substring(1);
        if (str.endsWith(substring)) {
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length + (-1)) == -1;
        }
        return false;
    }
}
