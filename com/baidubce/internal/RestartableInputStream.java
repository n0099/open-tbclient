package com.baidubce.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* loaded from: classes24.dex */
public abstract class RestartableInputStream extends InputStream {
    public abstract void restart();

    public static RestartableInputStream wrap(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        byteArrayInputStream.mark(bArr.length);
        return new RestartableResettableInputStream(byteArrayInputStream);
    }
}
