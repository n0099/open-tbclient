package com.bytedance.sdk.openadsdk;
/* loaded from: classes5.dex */
public class TTAppDownloadInfo {

    /* renamed from: a  reason: collision with root package name */
    public long f27005a;

    /* renamed from: b  reason: collision with root package name */
    public int f27006b;

    /* renamed from: c  reason: collision with root package name */
    public long f27007c;

    /* renamed from: d  reason: collision with root package name */
    public long f27008d;

    /* renamed from: e  reason: collision with root package name */
    public String f27009e;

    /* renamed from: f  reason: collision with root package name */
    public String f27010f;

    public String getAppName() {
        return this.f27010f;
    }

    public long getCurrBytes() {
        return this.f27008d;
    }

    public String getFileName() {
        return this.f27009e;
    }

    public long getId() {
        return this.f27005a;
    }

    public int getInternalStatusKey() {
        return this.f27006b;
    }

    public long getTotalBytes() {
        return this.f27007c;
    }

    public void setAppName(String str) {
        this.f27010f = str;
    }

    public void setCurrBytes(long j) {
        this.f27008d = j;
    }

    public void setFileName(String str) {
        this.f27009e = str;
    }

    public void setId(long j) {
        this.f27005a = j;
    }

    public void setInternalStatusKey(int i) {
        this.f27006b = i;
    }

    public void setTotalBytes(long j) {
        this.f27007c = j;
    }
}
