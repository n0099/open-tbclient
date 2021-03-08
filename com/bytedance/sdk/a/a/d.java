package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes6.dex */
public interface d extends r, WritableByteChannel {
    d OD(int i) throws IOException;

    d OE(int i) throws IOException;

    d OF(int i) throws IOException;

    d YT(String str) throws IOException;

    d aj(byte[] bArr) throws IOException;

    c eoG();

    d eoP() throws IOException;

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    void flush() throws IOException;

    d in(long j) throws IOException;

    d io(long j) throws IOException;

    d w(byte[] bArr, int i, int i2) throws IOException;
}
