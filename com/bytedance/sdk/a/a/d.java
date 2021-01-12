package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
/* loaded from: classes4.dex */
public interface d extends r, WritableByteChannel {
    d Od(int i) throws IOException;

    d Oe(int i) throws IOException;

    d Of(int i) throws IOException;

    d Xy(String str) throws IOException;

    d ai(byte[] bArr) throws IOException;

    c elX();

    d emg() throws IOException;

    @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
    void flush() throws IOException;

    d ik(long j) throws IOException;

    d il(long j) throws IOException;

    d w(byte[] bArr, int i, int i2) throws IOException;
}
