package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class UrlResponseInfo {
    private final int mAQ;
    private final List<String> mCk;
    private final String mCl;
    private final boolean mCm;
    private final String mCn;
    private final String mCo;
    private final AtomicLong mCp = new AtomicLong();
    private final HeaderBlock mCq;

    /* loaded from: classes.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> mCr;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.mCr = list;
        }

        public List<Map.Entry<String, String>> dwi() {
            return this.mCr;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.mCk = Collections.unmodifiableList(list);
        this.mAQ = i;
        this.mCl = str;
        this.mCq = new HeaderBlock(Collections.unmodifiableList(list2));
        this.mCm = z;
        this.mCn = str2;
        this.mCo = str3;
    }

    public String getUrl() {
        return this.mCk.get(this.mCk.size() - 1);
    }

    public List<String> dwc() {
        return this.mCk;
    }

    public int getHttpStatusCode() {
        return this.mAQ;
    }

    public String dwd() {
        return this.mCl;
    }

    public List<Map.Entry<String, String>> dwe() {
        return this.mCq.dwi();
    }

    public boolean dwf() {
        return this.mCm;
    }

    public String dwg() {
        return this.mCn;
    }

    public String dwh() {
        return this.mCo;
    }

    public long getReceivedBytesCount() {
        return this.mCp.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), dwc().toString(), Integer.valueOf(getHttpStatusCode()), dwd(), dwe().toString(), Boolean.valueOf(dwf()), dwg(), dwh(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fE(long j) {
        this.mCp.set(j);
    }
}
