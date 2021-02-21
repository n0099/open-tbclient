package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes6.dex */
public interface d extends r, WritableByteChannel {
    d OA(int i) throws IOException;

    d OB(int i) throws IOException;

    d Oz(int i) throws IOException;

    d YM(String str) throws IOException;

    d ah(byte[] bArr) throws IOException;

    d eoI() throws IOException;

    c eoz();

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    void flush() throws IOException;

    d in(long j) throws IOException;

    d io(long j) throws IOException;

    d w(byte[] bArr, int i, int i2) throws IOException;
}
