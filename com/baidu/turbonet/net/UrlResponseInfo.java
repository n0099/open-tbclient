package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class UrlResponseInfo {
    private final int ncr;
    private final List<String> ndK;
    private final String ndL;
    private final boolean ndM;
    private final String ndN;
    private final String ndO;
    private final AtomicLong ndP = new AtomicLong();
    private final HeaderBlock ndQ;

    /* loaded from: classes10.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> ndR;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.ndR = list;
        }

        public List<Map.Entry<String, String>> dLw() {
            return this.ndR;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.ndK = Collections.unmodifiableList(list);
        this.ncr = i;
        this.ndL = str;
        this.ndQ = new HeaderBlock(Collections.unmodifiableList(list2));
        this.ndM = z;
        this.ndN = str2;
        this.ndO = str3;
    }

    public String getUrl() {
        return this.ndK.get(this.ndK.size() - 1);
    }

    public List<String> dLq() {
        return this.ndK;
    }

    public int getHttpStatusCode() {
        return this.ncr;
    }

    public String dLr() {
        return this.ndL;
    }

    public List<Map.Entry<String, String>> dLs() {
        return this.ndQ.dLw();
    }

    public boolean dLt() {
        return this.ndM;
    }

    public String dLu() {
        return this.ndN;
    }

    public String dLv() {
        return this.ndO;
    }

    public long getReceivedBytesCount() {
        return this.ndP.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), dLq().toString(), Integer.valueOf(getHttpStatusCode()), dLr(), dLs().toString(), Boolean.valueOf(dLt()), dLu(), dLv(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gf(long j) {
        this.ndP.set(j);
    }
}
