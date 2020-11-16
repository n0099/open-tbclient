package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes12.dex */
public final class UrlResponseInfo {
    private final int ooW;
    private final List<String> oqp;
    private final String oqq;
    private final boolean oqr;
    private final String oqs;
    private final String oqt;
    private final AtomicLong oqu = new AtomicLong();
    private final HeaderBlock oqv;

    /* loaded from: classes12.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> oqw;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.oqw = list;
        }

        public List<Map.Entry<String, String>> ecE() {
            return this.oqw;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.oqp = Collections.unmodifiableList(list);
        this.ooW = i;
        this.oqq = str;
        this.oqv = new HeaderBlock(Collections.unmodifiableList(list2));
        this.oqr = z;
        this.oqs = str2;
        this.oqt = str3;
    }

    public String getUrl() {
        return this.oqp.get(this.oqp.size() - 1);
    }

    public List<String> ecy() {
        return this.oqp;
    }

    public int getHttpStatusCode() {
        return this.ooW;
    }

    public String ecz() {
        return this.oqq;
    }

    public List<Map.Entry<String, String>> ecA() {
        return this.oqv.ecE();
    }

    public boolean ecB() {
        return this.oqr;
    }

    public String ecC() {
        return this.oqs;
    }

    public String ecD() {
        return this.oqt;
    }

    public long getReceivedBytesCount() {
        return this.oqu.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), ecy().toString(), Integer.valueOf(getHttpStatusCode()), ecz(), ecA().toString(), Boolean.valueOf(ecB()), ecC(), ecD(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hr(long j) {
        this.oqu.set(j);
    }
}
