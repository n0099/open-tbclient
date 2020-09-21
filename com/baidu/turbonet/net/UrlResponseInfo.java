package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes15.dex */
public final class UrlResponseInfo {
    private final int nmq;
    private final List<String> nnJ;
    private final String nnK;
    private final boolean nnL;
    private final String nnM;
    private final String nnN;
    private final AtomicLong nnO = new AtomicLong();
    private final HeaderBlock nnP;

    /* loaded from: classes15.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> nnQ;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.nnQ = list;
        }

        public List<Map.Entry<String, String>> dPu() {
            return this.nnQ;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.nnJ = Collections.unmodifiableList(list);
        this.nmq = i;
        this.nnK = str;
        this.nnP = new HeaderBlock(Collections.unmodifiableList(list2));
        this.nnL = z;
        this.nnM = str2;
        this.nnN = str3;
    }

    public String getUrl() {
        return this.nnJ.get(this.nnJ.size() - 1);
    }

    public List<String> dPo() {
        return this.nnJ;
    }

    public int getHttpStatusCode() {
        return this.nmq;
    }

    public String dPp() {
        return this.nnK;
    }

    public List<Map.Entry<String, String>> dPq() {
        return this.nnP.dPu();
    }

    public boolean dPr() {
        return this.nnL;
    }

    public String dPs() {
        return this.nnM;
    }

    public String dPt() {
        return this.nnN;
    }

    public long getReceivedBytesCount() {
        return this.nnO.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), dPo().toString(), Integer.valueOf(getHttpStatusCode()), dPp(), dPq().toString(), Boolean.valueOf(dPr()), dPs(), dPt(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gt(long j) {
        this.nnO.set(j);
    }
}
