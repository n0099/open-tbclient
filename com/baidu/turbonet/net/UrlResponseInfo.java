package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes19.dex */
public final class UrlResponseInfo {
    private final int mJc;
    private final AtomicLong mKA = new AtomicLong();
    private final HeaderBlock mKB;
    private final List<String> mKv;
    private final String mKw;
    private final boolean mKx;
    private final String mKy;
    private final String mKz;

    /* loaded from: classes19.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> mKC;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.mKC = list;
        }

        public List<Map.Entry<String, String>> dzz() {
            return this.mKC;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.mKv = Collections.unmodifiableList(list);
        this.mJc = i;
        this.mKw = str;
        this.mKB = new HeaderBlock(Collections.unmodifiableList(list2));
        this.mKx = z;
        this.mKy = str2;
        this.mKz = str3;
    }

    public String getUrl() {
        return this.mKv.get(this.mKv.size() - 1);
    }

    public List<String> dzt() {
        return this.mKv;
    }

    public int getHttpStatusCode() {
        return this.mJc;
    }

    public String dzu() {
        return this.mKw;
    }

    public List<Map.Entry<String, String>> dzv() {
        return this.mKB.dzz();
    }

    public boolean dzw() {
        return this.mKx;
    }

    public String dzx() {
        return this.mKy;
    }

    public String dzy() {
        return this.mKz;
    }

    public long getReceivedBytesCount() {
        return this.mKA.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), dzt().toString(), Integer.valueOf(getHttpStatusCode()), dzu(), dzv().toString(), Boolean.valueOf(dzw()), dzx(), dzy(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fR(long j) {
        this.mKA.set(j);
    }
}
