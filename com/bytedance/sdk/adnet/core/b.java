package com.bytedance.sdk.adnet.core;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f6316a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f6317b;
    private final int c;
    private final InputStream d;

    public b(int i, List<a> list) {
        this(i, list, -1, null);
    }

    public b(int i, List<a> list, int i2, InputStream inputStream) {
        this.f6316a = i;
        this.f6317b = list;
        this.c = i2;
        this.d = inputStream;
    }

    public final int getStatusCode() {
        return this.f6316a;
    }

    public final List<a> esm() {
        return Collections.unmodifiableList(this.f6317b);
    }

    public final int getContentLength() {
        return this.c;
    }

    public final InputStream getContent() {
        return this.d;
    }
}
