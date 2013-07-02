package com.baidu.zeus;

import com.baidu.zeus.bouncycastle.X509Name;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/* loaded from: classes.dex */
public class DomainNameChecker {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    private static Pattern QUICK_IP_PATTERN;

    static {
        try {
            QUICK_IP_PATTERN = Pattern.compile("^[a-f0-9\\.:]+$");
        } catch (PatternSyntaxException e) {
        }
    }

    public static boolean match(X509Certificate x509Certificate, String str) {
        if (x509Certificate == null || str == null || str.length() == 0) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!isIpAddress(lowerCase)) {
            return matchDns(x509Certificate, lowerCase);
        }
        return matchIpAddress(x509Certificate, lowerCase);
    }

    private static boolean isIpAddress(String str) {
        boolean z = (str == null || str.length() == 0) ? false : true;
        if (z) {
            try {
                boolean matches = QUICK_IP_PATTERN.matcher(str).matches();
                if (matches) {
                    return str.equals(InetAddress.getByName(str).getHostAddress());
                }
                return matches;
            } catch (UnknownHostException e) {
                if (e.getMessage() == null) {
                }
                return false;
            }
        }
        return z;
    }

    private static boolean matchIpAddress(X509Certificate x509Certificate, String str) {
        Integer num;
        String str2;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                for (List<?> list : subjectAlternativeNames) {
                    if (list != null && 2 <= list.size() && (num = (Integer) list.get(0)) != null && num.intValue() == 7 && (str2 = (String) list.get(1)) != null && str.equalsIgnoreCase(str2)) {
                        return true;
                    }
                }
            }
        } catch (CertificateParsingException e) {
        }
        return false;
    }

    private static boolean matchDns(X509Certificate x509Certificate, String str) {
        boolean z;
        boolean z2;
        Integer num;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                z = false;
                for (List<?> list : subjectAlternativeNames) {
                    try {
                        if (list == null || 2 > list.size() || (num = (Integer) list.get(0)) == null || num.intValue() != 2) {
                            z2 = z;
                        } else {
                            try {
                                String str2 = (String) list.get(1);
                                if (str2 != null && matchDns(str, str2)) {
                                    return true;
                                }
                                z2 = true;
                            } catch (CertificateParsingException e) {
                                z = true;
                            }
                        }
                        z = z2;
                    } catch (CertificateParsingException e2) {
                    }
                }
            } else {
                z = false;
            }
        } catch (CertificateParsingException e3) {
            z = false;
        }
        if (!z) {
            X509Name x509Name = new X509Name(x509Certificate.getSubjectDN().getName());
            Vector values = x509Name.getValues();
            Vector oIDs = x509Name.getOIDs();
            for (int i = 0; i < oIDs.size(); i++) {
                if (oIDs.elementAt(i).equals(X509Name.CN)) {
                    return matchDns(str, (String) values.elementAt(i));
                }
            }
        }
        return false;
    }

    private static boolean matchDns(String str, String str2) {
        String[] split;
        String[] split2;
        int length;
        int length2;
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return false;
        }
        String lowerCase = str2.toLowerCase();
        boolean equals = str.equals(lowerCase);
        if (!equals && (length = (split = str.split("\\.")).length) >= (length2 = (split2 = lowerCase.split("\\.")).length)) {
            int i = length2 - 1;
            while (i >= 0) {
                boolean equals2 = split[i].equals(split2[i]);
                if (equals2) {
                    i--;
                    equals = equals2;
                } else {
                    boolean z = i == 0 && length == length2;
                    if (z) {
                        boolean equals3 = split2[0].equals("*");
                        if (!equals3) {
                            return domainTokenMatch(split[0], split2[0]);
                        }
                        return equals3;
                    }
                    return z;
                }
            }
            return equals;
        }
        return equals;
    }

    private static boolean domainTokenMatch(String str, String str2) {
        int indexOf;
        if (str == null || str2 == null || (indexOf = str2.indexOf(42)) < 0 || str2.length() - 1 > str.length()) {
            return false;
        }
        return str.startsWith(str2.substring(0, indexOf)) && str.endsWith(str2.substring(indexOf + 1));
    }
}
