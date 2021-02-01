package com.bytedance.sdk.openadsdk;
/* loaded from: classes6.dex */
public class TTAppDownloadInfo {

    /* renamed from: a  reason: collision with root package name */
    private long f6088a;

    /* renamed from: b  reason: collision with root package name */
    private int f6089b;
    private long c;
    private long d;
    private String e;
    private String f;

    public long getId() {
        return this.f6088a;
    }

    public void setId(long j) {
        this.f6088a = j;
    }

    public int getInternalStatusKey() {
        return this.f6089b;
    }

    public void setInternalStatusKey(int i) {
        this.f6089b = i;
    }

    public long getTotalBytes() {
        return this.c;
    }

    public void setTotalBytes(long j) {
        this.c = j;
    }

    public long getCurrBytes() {
        return this.d;
    }

    public void setCurrBytes(long j) {
        this.d = j;
    }

    public String getFileName() {
        return this.e;
    }

    public void setFileName(String str) {
        this.e = str;
    }

    public String getAppName() {
        return this.f;
    }

    public void setAppName(String str) {
        this.f = str;
    }
}
