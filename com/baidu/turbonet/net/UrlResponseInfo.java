package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class UrlResponseInfo {
    private final int lKy;
    private final List<String> lLQ;
    private final String lLR;
    private final boolean lLS;
    private final String lLT;
    private final String lLU;
    private final AtomicLong lLV = new AtomicLong();
    private final HeaderBlock lLW;

    /* loaded from: classes.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> lLX;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.lLX = list;
        }

        public List<Map.Entry<String, String>> dkb() {
            return this.lLX;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.lLQ = Collections.unmodifiableList(list);
        this.lKy = i;
        this.lLR = str;
        this.lLW = new HeaderBlock(Collections.unmodifiableList(list2));
        this.lLS = z;
        this.lLT = str2;
        this.lLU = str3;
    }

    public String getUrl() {
        return this.lLQ.get(this.lLQ.size() - 1);
    }

    public List<String> djV() {
        return this.lLQ;
    }

    public int getHttpStatusCode() {
        return this.lKy;
    }

    public String djW() {
        return this.lLR;
    }

    public List<Map.Entry<String, String>> djX() {
        return this.lLW.dkb();
    }

    public boolean djY() {
        return this.lLS;
    }

    public String djZ() {
        return this.lLT;
    }

    public String dka() {
        return this.lLU;
    }

    public long getReceivedBytesCount() {
        return this.lLV.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), djV().toString(), Integer.valueOf(getHttpStatusCode()), djW(), djX().toString(), Boolean.valueOf(djY()), djZ(), dka(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fz(long j) {
        this.lLV.set(j);
    }
}
