package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class UrlResponseInfo {
    private final int lKC;
    private final List<String> lLU;
    private final String lLV;
    private final boolean lLW;
    private final String lLX;
    private final String lLY;
    private final AtomicLong lLZ = new AtomicLong();
    private final HeaderBlock lMa;

    /* loaded from: classes.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> lMb;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.lMb = list;
        }

        public List<Map.Entry<String, String>> djZ() {
            return this.lMb;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.lLU = Collections.unmodifiableList(list);
        this.lKC = i;
        this.lLV = str;
        this.lMa = new HeaderBlock(Collections.unmodifiableList(list2));
        this.lLW = z;
        this.lLX = str2;
        this.lLY = str3;
    }

    public String getUrl() {
        return this.lLU.get(this.lLU.size() - 1);
    }

    public List<String> djT() {
        return this.lLU;
    }

    public int getHttpStatusCode() {
        return this.lKC;
    }

    public String djU() {
        return this.lLV;
    }

    public List<Map.Entry<String, String>> djV() {
        return this.lMa.djZ();
    }

    public boolean djW() {
        return this.lLW;
    }

    public String djX() {
        return this.lLX;
    }

    public String djY() {
        return this.lLY;
    }

    public long getReceivedBytesCount() {
        return this.lLZ.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), djT().toString(), Integer.valueOf(getHttpStatusCode()), djU(), djV().toString(), Boolean.valueOf(djW()), djX(), djY(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fz(long j) {
        this.lLZ.set(j);
    }
}
