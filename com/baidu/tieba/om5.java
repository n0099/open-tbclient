package com.baidu.tieba;

import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public interface om5 {
    InputStream a() throws IOException;

    int available() throws IOException;

    void close() throws IOException;

    byte peek() throws IOException;

    int position();

    int read(byte[] bArr, int i, int i2) throws IOException;

    void reset() throws IOException;

    long skip(long j) throws IOException;
}
