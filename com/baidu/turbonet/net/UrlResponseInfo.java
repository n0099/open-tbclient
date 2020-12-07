package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes14.dex */
public final class UrlResponseInfo {
    private final int oDU;
    private final List<String> oFl;
    private final String oFm;
    private final boolean oFn;
    private final String oFo;
    private final String oFp;
    private final AtomicLong oFq = new AtomicLong();
    private final HeaderBlock oFr;

    /* loaded from: classes14.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> oFs;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.oFs = list;
        }

        public List<Map.Entry<String, String>> eij() {
            return this.oFs;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.oFl = Collections.unmodifiableList(list);
        this.oDU = i;
        this.oFm = str;
        this.oFr = new HeaderBlock(Collections.unmodifiableList(list2));
        this.oFn = z;
        this.oFo = str2;
        this.oFp = str3;
    }

    public String getUrl() {
        return this.oFl.get(this.oFl.size() - 1);
    }

    public List<String> eid() {
        return this.oFl;
    }

    public int getHttpStatusCode() {
        return this.oDU;
    }

    public String eie() {
        return this.oFm;
    }

    public List<Map.Entry<String, String>> eif() {
        return this.oFr.eij();
    }

    public boolean eig() {
        return this.oFn;
    }

    public String eih() {
        return this.oFo;
    }

    public String eii() {
        return this.oFp;
    }

    public long getReceivedBytesCount() {
        return this.oFq.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), eid().toString(), Integer.valueOf(getHttpStatusCode()), eie(), eif().toString(), Boolean.valueOf(eig()), eih(), eii(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hW(long j) {
        this.oFq.set(j);
    }
}
