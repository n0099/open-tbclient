package com.baidu.turbonet.net;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class UrlResponseInfo {
    private final int mAT;
    private final List<String> mCn;
    private final String mCo;
    private final boolean mCp;
    private final String mCq;
    private final String mCr;
    private final AtomicLong mCs = new AtomicLong();
    private final HeaderBlock mCt;

    /* loaded from: classes.dex */
    public static final class HeaderBlock {
        private final List<Map.Entry<String, String>> mCu;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderBlock(List<Map.Entry<String, String>> list) {
            this.mCu = list;
        }

        public List<Map.Entry<String, String>> dwm() {
            return this.mCu;
        }
    }

    public UrlResponseInfo(List<String> list, int i, String str, List<Map.Entry<String, String>> list2, boolean z, String str2, String str3) {
        this.mCn = Collections.unmodifiableList(list);
        this.mAT = i;
        this.mCo = str;
        this.mCt = new HeaderBlock(Collections.unmodifiableList(list2));
        this.mCp = z;
        this.mCq = str2;
        this.mCr = str3;
    }

    public String getUrl() {
        return this.mCn.get(this.mCn.size() - 1);
    }

    public List<String> dwg() {
        return this.mCn;
    }

    public int getHttpStatusCode() {
        return this.mAT;
    }

    public String dwh() {
        return this.mCo;
    }

    public List<Map.Entry<String, String>> dwi() {
        return this.mCt.dwm();
    }

    public boolean dwj() {
        return this.mCp;
    }

    public String dwk() {
        return this.mCq;
    }

    public String dwl() {
        return this.mCr;
    }

    public long getReceivedBytesCount() {
        return this.mCs.get();
    }

    public String toString() {
        return String.format(Locale.ROOT, "UrlResponseInfo@[%s][%s]: urlChain = %s, httpStatus = %d %s, headers = %s, wasCached = %b, negotiatedProtocol = %s, proxyServer= %s, receivedBytesCount = %d", Integer.toHexString(System.identityHashCode(this)), getUrl(), dwg().toString(), Integer.valueOf(getHttpStatusCode()), dwh(), dwi().toString(), Boolean.valueOf(dwj()), dwk(), dwl(), Long.valueOf(getReceivedBytesCount()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fE(long j) {
        this.mCs.set(j);
    }
}
