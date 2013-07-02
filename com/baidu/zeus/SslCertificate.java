package com.baidu.zeus;

import android.os.Bundle;
import com.baidu.zeus.bouncycastle.X509Name;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
/* loaded from: classes.dex */
public class SslCertificate {
    private static String ISO_8601_DATE_FORMAT = "yyyy-MM-dd HH:mm:ssZ";
    private static final String ISSUED_BY = "issued-by";
    private static final String ISSUED_TO = "issued-to";
    private static final String VALID_NOT_AFTER = "valid-not-after";
    private static final String VALID_NOT_BEFORE = "valid-not-before";
    private DName mIssuedBy;
    private DName mIssuedTo;
    private Date mValidNotAfter;
    private Date mValidNotBefore;

    public static Bundle saveState(SslCertificate sslCertificate) {
        if (sslCertificate == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ISSUED_TO, sslCertificate.getIssuedTo().getDName());
        bundle.putString(ISSUED_BY, sslCertificate.getIssuedBy().getDName());
        bundle.putString(VALID_NOT_BEFORE, sslCertificate.getValidNotBefore());
        bundle.putString(VALID_NOT_AFTER, sslCertificate.getValidNotAfter());
        return bundle;
    }

    public static SslCertificate restoreState(Bundle bundle) {
        if (bundle != null) {
            return new SslCertificate(bundle.getString(ISSUED_TO), bundle.getString(ISSUED_BY), bundle.getString(VALID_NOT_BEFORE), bundle.getString(VALID_NOT_AFTER));
        }
        return null;
    }

    public SslCertificate(String str, String str2, String str3, String str4) {
        this(str, str2, parseDate(str3), parseDate(str4));
    }

    public SslCertificate(String str, String str2, Date date, Date date2) {
        this.mIssuedTo = new DName(str);
        this.mIssuedBy = new DName(str2);
        this.mValidNotBefore = cloneDate(date);
        this.mValidNotAfter = cloneDate(date2);
    }

    public SslCertificate(X509Certificate x509Certificate) {
        this(x509Certificate.getSubjectDN().getName(), x509Certificate.getIssuerDN().getName(), x509Certificate.getNotBefore(), x509Certificate.getNotAfter());
    }

    public Date getValidNotBeforeDate() {
        return cloneDate(this.mValidNotBefore);
    }

    public String getValidNotBefore() {
        return formatDate(this.mValidNotBefore);
    }

    public Date getValidNotAfterDate() {
        return cloneDate(this.mValidNotAfter);
    }

    public String getValidNotAfter() {
        return formatDate(this.mValidNotAfter);
    }

    public DName getIssuedTo() {
        return this.mIssuedTo;
    }

    public DName getIssuedBy() {
        return this.mIssuedBy;
    }

    public String toString() {
        return "Issued to: " + this.mIssuedTo.getDName() + ";\nIssued by: " + this.mIssuedBy.getDName() + ";\n";
    }

    private static Date parseDate(String str) {
        try {
            return new SimpleDateFormat(ISO_8601_DATE_FORMAT).parse(str);
        } catch (java.text.ParseException e) {
            return null;
        }
    }

    private static String formatDate(Date date) {
        return date == null ? "" : new SimpleDateFormat(ISO_8601_DATE_FORMAT).format(date);
    }

    private static Date cloneDate(Date date) {
        if (date == null) {
            return null;
        }
        return (Date) date.clone();
    }

    /* loaded from: classes.dex */
    public class DName {
        private String mCName;
        private String mDName;
        private String mOName;
        private String mUName;

        public DName(String str) {
            if (str != null) {
                this.mDName = str;
                try {
                    X509Name x509Name = new X509Name(str);
                    Vector values = x509Name.getValues();
                    Vector oIDs = x509Name.getOIDs();
                    for (int i = 0; i < oIDs.size(); i++) {
                        if (oIDs.elementAt(i).equals(X509Name.CN)) {
                            this.mCName = (String) values.elementAt(i);
                        } else if (oIDs.elementAt(i).equals(X509Name.O)) {
                            this.mOName = (String) values.elementAt(i);
                        } else if (oIDs.elementAt(i).equals(X509Name.OU)) {
                            this.mUName = (String) values.elementAt(i);
                        }
                    }
                } catch (IllegalArgumentException e) {
                }
            }
        }

        public String getDName() {
            return this.mDName != null ? this.mDName : "";
        }

        public String getCName() {
            return this.mCName != null ? this.mCName : "";
        }

        public String getOName() {
            return this.mOName != null ? this.mOName : "";
        }

        public String getUName() {
            return this.mUName != null ? this.mUName : "";
        }
    }
}
