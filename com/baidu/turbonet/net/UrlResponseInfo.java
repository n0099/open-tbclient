package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes17.dex */
public final class UrlResponseInfo {
    private final int oeo;
    private final List<String> ofH;
    private final String ofI;
    private final boolean ofJ;
    private final String ofK;
    private final String ofL;
    private final AtomicLong ofM = new AtomicLong();
    private final HeaderBlock ofN;

    /* loaded from: classes17.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> ofO;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.ofO = list;
        }

        public List<Map.Entry<String, String>> dYX() {
            return this.ofO;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.ofH = Collections.unmodifiableList(list);
        this.oeo = i;
        this.ofI = str;
        this.ofN = new HeaderBlock(Collections.unmodifiableList(list2));
        this.ofJ = z;
        this.ofK = str2;
        this.ofL = str3;
    }

    public String getUrl() {
        return this.ofH.get(this.ofH.size() - 1);
    }

    public List<String> dYR() {
        return this.ofH;
    }

    public int getHttpStatusCode() {
        return this.oeo;
    }

    public String dYS() {
        return this.ofI;
    }

    public List<Map.Entry<String, String>> dYT() {
        return this.ofN.dYX();
    }

    public boolean dYU() {
        return this.ofJ;
    }

    public String dYV() {
        return this.ofK;
    }

    public String dYW() {
        return this.ofL;
    }

    public long getReceivedBytesCount() {
        return this.ofM.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), dYR().toString(), Integer.valueOf(getHttpStatusCode()), dYS(), dYT().toString(), Boolean.valueOf(dYU()), dYV(), dYW(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gS(long j) {
        this.ofM.set(j);
    }
}
