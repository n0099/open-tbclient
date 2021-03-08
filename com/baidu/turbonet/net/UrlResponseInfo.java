package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class UrlResponseInfo {
    private final int mHttpStatusCode;
    private final String mHttpStatusText;
    private final String mNegotiatedProtocol;
    private final String mProxyServer;
    private final List<String> mResponseInfoUrlChain;
    private final boolean mWasCached;
    private final AtomicLong oTU = new AtomicLong();
    private final HeaderBlock oTV;

    /* loaded from: classes5.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> mAllHeadersList;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.mAllHeadersList = list;
        }

        public List<Map.Entry<String, String>> eho() {
            return this.mAllHeadersList;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.mResponseInfoUrlChain = Collections.unmodifiableList(list);
        this.mHttpStatusCode = i;
        this.mHttpStatusText = str;
        this.oTV = new HeaderBlock(Collections.unmodifiableList(list2));
        this.mWasCached = z;
        this.mNegotiatedProtocol = str2;
        this.mProxyServer = str3;
    }

    public String getUrl() {
        return this.mResponseInfoUrlChain.get(this.mResponseInfoUrlChain.size() - 1);
    }

    public List<String> ehi() {
        return this.mResponseInfoUrlChain;
    }

    public int getHttpStatusCode() {
        return this.mHttpStatusCode;
    }

    public String ehj() {
        return this.mHttpStatusText;
    }

    public List<Map.Entry<String, String>> ehk() {
        return this.oTV.eho();
    }

    public boolean ehl() {
        return this.mWasCached;
    }

    public String ehm() {
        return this.mNegotiatedProtocol;
    }

    public String ehn() {
        return this.mProxyServer;
    }

    public long getReceivedBytesCount() {
        return this.oTU.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), ehi().toString(), Integer.valueOf(getHttpStatusCode()), ehj(), ehk().toString(), Boolean.valueOf(ehl()), ehm(), ehn(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hT(long j) {
        this.oTU.set(j);
    }
}
