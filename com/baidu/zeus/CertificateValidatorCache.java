package com.baidu.zeus;

import android.os.SystemClock;
import com.baidu.zeus.security.Sha1MessageDigest;
import java.security.GeneralSecurityException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
/* loaded from: classes.dex */
class CertificateValidatorCache {
    private static final long CACHE_ENTRY_LIFETIME = 600000;
    private static CertificateFactory sCertificateFactory;
    private int mBigScrew = new Random().nextInt();
    private HashMap mCacheMap = new HashMap();
    public static long mSave = 0;
    public static long mCost = 0;

    public static byte[] secureHash(Certificate[] certificateArr) {
        byte[] encoded;
        byte[] bArr = null;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (certificateArr != null && certificateArr.length != 0) {
            try {
                synchronized (CertificateValidatorCache.class) {
                    if (sCertificateFactory == null) {
                        try {
                            sCertificateFactory = CertificateFactory.getInstance("X.509");
                        } catch (GeneralSecurityException e) {
                        }
                    }
                }
                CertPath generateCertPath = sCertificateFactory.generateCertPath(Arrays.asList(certificateArr));
                if (generateCertPath != null && (encoded = generateCertPath.getEncoded()) != null) {
                    bArr = new Sha1MessageDigest().digest(encoded);
                }
            } catch (GeneralSecurityException e2) {
            }
        }
        mCost = (SystemClock.uptimeMillis() - uptimeMillis) + mCost;
        return bArr;
    }

    public boolean has(String str, byte[] bArr) {
        CacheEntry cacheEntry;
        if (str != null && str.length() != 0 && bArr != null && bArr.length != 0 && (cacheEntry = (CacheEntry) this.mCacheMap.get(new Integer(this.mBigScrew ^ str.hashCode()))) != null) {
            if (!cacheEntry.expired()) {
                boolean has = cacheEntry.has(str, bArr);
                if (has) {
                    mSave += cacheEntry.mSave;
                    return has;
                }
                return has;
            }
            this.mCacheMap.remove(cacheEntry);
        }
        return false;
    }

    public boolean put(String str, byte[] bArr, long j) {
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            return false;
        }
        this.mCacheMap.put(new Integer(this.mBigScrew ^ str.hashCode()), new CacheEntry(str, bArr, j));
        return true;
    }

    /* loaded from: classes.dex */
    class CacheEntry {
        private String mDomain;
        private byte[] mHash;
        public long mSave;
        private long mTime = SystemClock.uptimeMillis();

        public CacheEntry(String str, byte[] bArr, long j) {
            this.mDomain = str;
            this.mHash = bArr;
            this.mSave = j;
        }

        public boolean expired() {
            return CertificateValidatorCache.CACHE_ENTRY_LIFETIME < SystemClock.uptimeMillis() - this.mTime;
        }

        public boolean has(String str, byte[] bArr) {
            int length;
            if ((str == null || str.length() <= 0 || this.mDomain.equals(str)) && bArr != null && (length = bArr.length) > 0 && length == this.mHash.length) {
                for (int i = 0; i < length; i++) {
                    if (bArr[i] != this.mHash[i]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }
}
