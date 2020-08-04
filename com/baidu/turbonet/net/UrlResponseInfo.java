package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes19.dex */
public final class UrlResponseInfo {
    private final int mJe;
    private final String mKA;
    private final String mKB;
    private final AtomicLong mKC = new AtomicLong();
    private final HeaderBlock mKD;
    private final List<String> mKx;
    private final String mKy;
    private final boolean mKz;

    /* loaded from: classes19.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> mKE;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.mKE = list;
        }

        public List<Map.Entry<String, String>> dzA() {
            return this.mKE;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.mKx = Collections.unmodifiableList(list);
        this.mJe = i;
        this.mKy = str;
        this.mKD = new HeaderBlock(Collections.unmodifiableList(list2));
        this.mKz = z;
        this.mKA = str2;
        this.mKB = str3;
    }

    public String getUrl() {
        return this.mKx.get(this.mKx.size() - 1);
    }

    public List<String> dzu() {
        return this.mKx;
    }

    public int getHttpStatusCode() {
        return this.mJe;
    }

    public String dzv() {
        return this.mKy;
    }

    public List<Map.Entry<String, String>> dzw() {
        return this.mKD.dzA();
    }

    public boolean dzx() {
        return this.mKz;
    }

    public String dzy() {
        return this.mKA;
    }

    public String dzz() {
        return this.mKB;
    }

    public long getReceivedBytesCount() {
        return this.mKC.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), dzu().toString(), Integer.valueOf(getHttpStatusCode()), dzv(), dzw().toString(), Boolean.valueOf(dzx()), dzy(), dzz(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fR(long j) {
        this.mKC.set(j);
    }
}
