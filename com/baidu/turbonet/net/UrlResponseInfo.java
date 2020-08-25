package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class UrlResponseInfo {
    private final int nbZ;
    private final List<String> nds;
    private final String ndt;
    private final boolean ndu;
    private final String ndv;
    private final String ndw;
    private final AtomicLong ndx = new AtomicLong();
    private final HeaderBlock ndy;

    /* loaded from: classes10.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> ndz;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.ndz = list;
        }

        public List<Map.Entry<String, String>> dLn() {
            return this.ndz;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.nds = Collections.unmodifiableList(list);
        this.nbZ = i;
        this.ndt = str;
        this.ndy = new HeaderBlock(Collections.unmodifiableList(list2));
        this.ndu = z;
        this.ndv = str2;
        this.ndw = str3;
    }

    public String getUrl() {
        return this.nds.get(this.nds.size() - 1);
    }

    public List<String> dLh() {
        return this.nds;
    }

    public int getHttpStatusCode() {
        return this.nbZ;
    }

    public String dLi() {
        return this.ndt;
    }

    public List<Map.Entry<String, String>> dLj() {
        return this.ndy.dLn();
    }

    public boolean dLk() {
        return this.ndu;
    }

    public String dLl() {
        return this.ndv;
    }

    public String dLm() {
        return this.ndw;
    }

    public long getReceivedBytesCount() {
        return this.ndx.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), dLh().toString(), Integer.valueOf(getHttpStatusCode()), dLi(), dLj().toString(), Boolean.valueOf(dLk()), dLl(), dLm(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gd(long j) {
        this.ndx.set(j);
    }
}
