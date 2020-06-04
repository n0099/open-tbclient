package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class UrlResponseInfo {
    private final int mfb;
    private final List<String> mgt;
    private final String mgu;
    private final boolean mgv;
    private final String mgw;
    private final String mgx;
    private final AtomicLong mgy = new AtomicLong();
    private final HeaderBlock mgz;

    /* loaded from: classes.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> mgA;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.mgA = list;
        }

        public List<Map.Entry<String, String>> drD() {
            return this.mgA;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.mgt = Collections.unmodifiableList(list);
        this.mfb = i;
        this.mgu = str;
        this.mgz = new HeaderBlock(Collections.unmodifiableList(list2));
        this.mgv = z;
        this.mgw = str2;
        this.mgx = str3;
    }

    public String getUrl() {
        return this.mgt.get(this.mgt.size() - 1);
    }

    public List<String> drx() {
        return this.mgt;
    }

    public int getHttpStatusCode() {
        return this.mfb;
    }

    public String dry() {
        return this.mgu;
    }

    public List<Map.Entry<String, String>> drz() {
        return this.mgz.drD();
    }

    public boolean drA() {
        return this.mgv;
    }

    public String drB() {
        return this.mgw;
    }

    public String drC() {
        return this.mgx;
    }

    public long getReceivedBytesCount() {
        return this.mgy.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), drx().toString(), Integer.valueOf(getHttpStatusCode()), dry(), drz().toString(), Boolean.valueOf(drA()), drB(), drC(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fz(long j) {
        this.mgy.set(j);
    }
}
