package com.baidu.ugc.audioedit;

import com.baidu.tieba.s6b;
import org.vinuxproject.sonic.Sonic;
/* loaded from: classes9.dex */
public class AudioSpeedOperator implements s6b {
    public Sonic mSonic;

    @Override // com.baidu.tieba.s6b
    public int availableBytes() {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            return sonic.a();
        }
        return 0;
    }

    @Override // com.baidu.tieba.s6b
    public void close() {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.b();
        }
    }

    @Override // com.baidu.tieba.s6b
    public void flush() {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.c();
        }
    }

    @Override // com.baidu.tieba.s6b
    public byte[] getOutPutBytes() {
        int availableBytes = availableBytes();
        byte[] bArr = new byte[availableBytes];
        receiveBytes(bArr, availableBytes);
        return bArr;
    }

    @Override // com.baidu.tieba.s6b
    public void init(int i, int i2) {
        this.mSonic = new Sonic(i, i2);
    }

    @Override // com.baidu.tieba.s6b
    public boolean putBytes(byte[] bArr, int i) {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.d(bArr, i);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.s6b
    public int receiveBytes(byte[] bArr, int i) {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            return sonic.e(bArr, i);
        }
        return 0;
    }

    @Override // com.baidu.tieba.s6b
    public void setSpeed(float f) {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.f(f);
        }
    }
}
