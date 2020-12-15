package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes14.dex */
public final class UrlResponseInfo {
    private final int oDW;
    private final List<String> oFn;
    private final String oFo;
    private final boolean oFp;
    private final String oFq;
    private final String oFr;
    private final AtomicLong oFs = new AtomicLong();
    private final HeaderBlock oFt;

    /* loaded from: classes14.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> oFu;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.oFu = list;
        }

        public List<Map.Entry<String, String>> eik() {
            return this.oFu;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.oFn = Collections.unmodifiableList(list);
        this.oDW = i;
        this.oFo = str;
        this.oFt = new HeaderBlock(Collections.unmodifiableList(list2));
        this.oFp = z;
        this.oFq = str2;
        this.oFr = str3;
    }

    public String getUrl() {
        return this.oFn.get(this.oFn.size() - 1);
    }

    public List<String> eie() {
        return this.oFn;
    }

    public int getHttpStatusCode() {
        return this.oDW;
    }

    public String eif() {
        return this.oFo;
    }

    public List<Map.Entry<String, String>> eig() {
        return this.oFt.eik();
    }

    public boolean eih() {
        return this.oFp;
    }

    public String eii() {
        return this.oFq;
    }

    public String eij() {
        return this.oFr;
    }

    public long getReceivedBytesCount() {
        return this.oFs.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), eie().toString(), Integer.valueOf(getHttpStatusCode()), eif(), eig().toString(), Boolean.valueOf(eih()), eii(), eij(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hW(long j) {
        this.oFs.set(j);
    }
}
