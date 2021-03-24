package com.bytedance.sdk.adnet.err;

import d.c.c.b.d.k;
/* loaded from: classes5.dex */
public class VAdError extends Exception {
    public static final int CACHE_DISPATCH_FAIL_CODE = 607;
    public static final int CONNECT_FAIL_CODE = 601;
    public static final int CONNECT_TIMEOUT_CODE = 602;
    public static final int DOWNLOAD_FILE_CANCEL_FAIL_CODE = 611;
    public static final int DOWNLOAD_FILE_INVALID_FAIL_CODE = 610;
    public static final int IMAGE_OOM_FAIL_CODE = 612;
    public static final int NETWORK_DISPATCH_FAIL_CODE = 608;
    public static final int NETWORK_FAIL_CODE = 603;
    public static final int PARSE_RESPONSE_CONTENT_FAIL_CODE = 606;
    public static final int PARSE_RESPONSE_FAIL_CODE = 605;
    public static final int RENAME_DOWNLOAD_FILE_FAIL_CODE = 609;
    public static final int UNSUPPORT_ENCODE_FAIL_CODE = 604;

    /* renamed from: a  reason: collision with root package name */
    public int f27237a;

    /* renamed from: b  reason: collision with root package name */
    public long f27238b;
    public final k networkResponse;

    public VAdError(k kVar) {
        this.networkResponse = kVar;
    }

    public int getErrorCode() {
        return this.f27237a;
    }

    public long getNetworkTimeMs() {
        return this.f27238b;
    }

    public void setErrorCode(int i) {
        this.f27237a = i;
    }

    public void setNetworkTimeMs(long j) {
        this.f27238b = j;
    }

    public VAdError(int i) {
        this.networkResponse = null;
        this.f27237a = i;
    }

    public VAdError(String str, int i) {
        super(str);
        this.networkResponse = null;
        this.f27237a = i;
    }

    public VAdError(String str, Throwable th, int i) {
        super(str, th);
        this.networkResponse = null;
        this.f27237a = i;
    }

    public VAdError(Throwable th, int i) {
        super(th);
        this.networkResponse = null;
        this.f27237a = i;
    }
}
