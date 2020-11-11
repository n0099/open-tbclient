package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes17.dex */
public final class UrlResponseInfo {
    private final int ont;
    private final List<String> ooL;
    private final String ooM;
    private final boolean ooN;
    private final String ooO;
    private final String ooP;
    private final AtomicLong ooQ = new AtomicLong();
    private final HeaderBlock ooR;

    /* loaded from: classes17.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> ooS;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.ooS = list;
        }

        public List<Map.Entry<String, String>> ecF() {
            return this.ooS;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.ooL = Collections.unmodifiableList(list);
        this.ont = i;
        this.ooM = str;
        this.ooR = new HeaderBlock(Collections.unmodifiableList(list2));
        this.ooN = z;
        this.ooO = str2;
        this.ooP = str3;
    }

    public String getUrl() {
        return this.ooL.get(this.ooL.size() - 1);
    }

    public List<String> ecz() {
        return this.ooL;
    }

    public int getHttpStatusCode() {
        return this.ont;
    }

    public String ecA() {
        return this.ooM;
    }

    public List<Map.Entry<String, String>> ecB() {
        return this.ooR.ecF();
    }

    public boolean ecC() {
        return this.ooN;
    }

    public String ecD() {
        return this.ooO;
    }

    public String ecE() {
        return this.ooP;
    }

    public long getReceivedBytesCount() {
        return this.ooQ.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), ecz().toString(), Integer.valueOf(getHttpStatusCode()), ecA(), ecB().toString(), Boolean.valueOf(ecC()), ecD(), ecE(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ho(long j) {
        this.ooQ.set(j);
    }
}
