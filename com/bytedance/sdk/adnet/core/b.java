package com.bytedance.sdk.adnet.core;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f4034a;
    private final List<a> b;
    private final int c;
    private final InputStream d;

    public b(int i, List<a> list) {
        this(i, list, -1, null);
    }

    public b(int i, List<a> list, int i2, InputStream inputStream) {
        this.f4034a = i;
        this.b = list;
        this.c = i2;
        this.d = inputStream;
    }

    public final int getStatusCode() {
        return this.f4034a;
    }

    public final List<a> erb() {
        return Collections.unmodifiableList(this.b);
    }

    public final int getContentLength() {
        return this.c;
    }

    public final InputStream getContent() {
        return this.d;
    }
}
