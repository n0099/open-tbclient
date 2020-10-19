package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes17.dex */
public final class UrlResponseInfo {
    private final int nBN;
    private final List<String> nDf;
    private final String nDg;
    private final boolean nDh;
    private final String nDi;
    private final String nDj;
    private final AtomicLong nDk = new AtomicLong();
    private final HeaderBlock nDl;

    /* loaded from: classes17.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> nDm;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.nDm = list;
        }

        public List<Map.Entry<String, String>> dTf() {
            return this.nDm;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.nDf = Collections.unmodifiableList(list);
        this.nBN = i;
        this.nDg = str;
        this.nDl = new HeaderBlock(Collections.unmodifiableList(list2));
        this.nDh = z;
        this.nDi = str2;
        this.nDj = str3;
    }

    public String getUrl() {
        return this.nDf.get(this.nDf.size() - 1);
    }

    public List<String> dSZ() {
        return this.nDf;
    }

    public int getHttpStatusCode() {
        return this.nBN;
    }

    public String dTa() {
        return this.nDg;
    }

    public List<Map.Entry<String, String>> dTb() {
        return this.nDl.dTf();
    }

    public boolean dTc() {
        return this.nDh;
    }

    public String dTd() {
        return this.nDi;
    }

    public String dTe() {
        return this.nDj;
    }

    public long getReceivedBytesCount() {
        return this.nDk.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), dSZ().toString(), Integer.valueOf(getHttpStatusCode()), dTa(), dTb().toString(), Boolean.valueOf(dTc()), dTd(), dTe(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gL(long j) {
        this.nDk.set(j);
    }
}
