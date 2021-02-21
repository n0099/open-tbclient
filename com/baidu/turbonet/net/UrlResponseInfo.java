package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes6.dex */
public final class UrlResponseInfo {
    private final int mHttpStatusCode;
    private final String mHttpStatusText;
    private final String mNegotiatedProtocol;
    private final String mProxyServer;
    private final List<String> mResponseInfoUrlChain;
    private final boolean mWasCached;
    private final AtomicLong oRP = new AtomicLong();
    private final HeaderBlock oRQ;

    /* loaded from: classes6.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> mAllHeadersList;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.mAllHeadersList = list;
        }

        public List<Map.Entry<String, String>> ehg() {
            return this.mAllHeadersList;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.mResponseInfoUrlChain = Collections.unmodifiableList(list);
        this.mHttpStatusCode = i;
        this.mHttpStatusText = str;
        this.oRQ = new HeaderBlock(Collections.unmodifiableList(list2));
        this.mWasCached = z;
        this.mNegotiatedProtocol = str2;
        this.mProxyServer = str3;
    }

    public String getUrl() {
        return this.mResponseInfoUrlChain.get(this.mResponseInfoUrlChain.size() - 1);
    }

    public List<String> eha() {
        return this.mResponseInfoUrlChain;
    }

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public String ehb() {
        return this.mHttpStatusText;
    }

    public List<Map.Entry<String, String>> ehc() {
        return this.oRQ.ehg();
    }

    public boolean ehd() {
        return this.mWasCached;
    }

    public String ehe() {
        return this.mNegotiatedProtocol;
    }

    public String ehf() {
        return this.mProxyServer;
    }

    public long getReceivedBytesCount() {
        return this.oRP.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), eha().toString(), Integer.valueOf(getHttpStatusCode()), ehb(), ehc().toString(), Boolean.valueOf(ehd()), ehe(), ehf(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hT(long j) {
        this.oRP.set(j);
    }
}
