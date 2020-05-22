package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class UrlResponseInfo {
    private final int mdR;
    private final List<String> mfj;
    private final String mfk;
    private final boolean mfl;
    private final String mfm;
    private final String mfn;
    private final AtomicLong mfo = new AtomicLong();
    private final HeaderBlock mfp;

    /* loaded from: classes.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> mfq;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.mfq = list;
        }

        public List<Map.Entry<String, String>> drp() {
            return this.mfq;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.mfj = Collections.unmodifiableList(list);
        this.mdR = i;
        this.mfk = str;
        this.mfp = new HeaderBlock(Collections.unmodifiableList(list2));
        this.mfl = z;
        this.mfm = str2;
        this.mfn = str3;
    }

    public String getUrl() {
        return this.mfj.get(this.mfj.size() - 1);
    }

    public List<String> drj() {
        return this.mfj;
    }

    public int getHttpStatusCode() {
        return this.mdR;
    }

    public String drk() {
        return this.mfk;
    }

    public List<Map.Entry<String, String>> drl() {
        return this.mfp.drp();
    }

    public boolean drm() {
        return this.mfl;
    }

    public String drn() {
        return this.mfm;
    }

    public String dro() {
        return this.mfn;
    }

    public long getReceivedBytesCount() {
        return this.mfo.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), drj().toString(), Integer.valueOf(getHttpStatusCode()), drk(), drl().toString(), Boolean.valueOf(drm()), drn(), dro(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fz(long j) {
        this.mfo.set(j);
    }
}
