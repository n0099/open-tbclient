package com.baidu.ugc.audioedit;

import com.baidu.tieba.ftb;
import org.vinuxproject.sonic.Sonic;
/* loaded from: classes9.dex */
public class AudioSpeedOperator implements ftb {
    public Sonic mSonic;

    @Override // com.baidu.tieba.ftb
    public int availableBytes() {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            return sonic.a();
        }
        return 0;
    }

    @Override // com.baidu.tieba.ftb
    public void close() {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.b();
        }
    }

    @Override // com.baidu.tieba.ftb
    public void flush() {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.c();
        }
    }

    @Override // com.baidu.tieba.ftb
    public byte[] getOutPutBytes() {
        int availableBytes = availableBytes();
        byte[] bArr = new byte[availableBytes];
        receiveBytes(bArr, availableBytes);
        return bArr;
    }

    @Override // com.baidu.tieba.ftb
    public void init(int i, int i2) {
        this.mSonic = new Sonic(i, i2);
    }

    @Override // com.baidu.tieba.ftb
    public boolean putBytes(byte[] bArr, int i) {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.d(bArr, i);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.ftb
    public int receiveBytes(byte[] bArr, int i) {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            return sonic.e(bArr, i);
        }
        return 0;
    }

    @Override // com.baidu.tieba.ftb
    public void setSpeed(float f) {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.f(f);
        }
    }
}
