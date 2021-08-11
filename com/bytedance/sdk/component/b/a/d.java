package com.bytedance.sdk.component.b.a;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes9.dex */
public interface d extends r, WritableByteChannel {
    d b(String str) throws IOException;

    c c();

    d c(byte[] bArr) throws IOException;

    d c(byte[] bArr, int i2, int i3) throws IOException;

    @Override // com.bytedance.sdk.component.b.a.r, java.io.Flushable
    void flush() throws IOException;

    d g(int i2) throws IOException;

    d h(int i2) throws IOException;

    d i(int i2) throws IOException;

    d k(long j2) throws IOException;

    d l(long j2) throws IOException;

    d u() throws IOException;
}
