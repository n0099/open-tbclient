package com.baidu.tieba;
/* loaded from: classes8.dex */
public interface veb {
    int availableBytes();

    void close();

    void flush();

    byte[] getOutPutBytes();

    void init(int i, int i2);

    boolean putBytes(byte[] bArr, int i);

    int receiveBytes(byte[] bArr, int i);

    void setSpeed(float f);
}
