package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes4.dex */
public interface d extends r, WritableByteChannel {
    d PK(int i) throws IOException;

    d PL(int i) throws IOException;

    d PM(int i) throws IOException;

    d YG(String str) throws IOException;

    d aj(byte[] bArr) throws IOException;

    c epT();

    d eqc() throws IOException;

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    void flush() throws IOException;

    d ik(long j) throws IOException;

    d il(long j) throws IOException;

    d x(byte[] bArr, int i, int i2) throws IOException;
}
