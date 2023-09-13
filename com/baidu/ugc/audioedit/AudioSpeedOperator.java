package com.baidu.ugc.audioedit;

import com.baidu.tieba.veb;
import org.vinuxproject.sonic.Sonic;
/* loaded from: classes9.dex */
public class AudioSpeedOperator implements veb {
    public Sonic mSonic;

    @Override // com.baidu.tieba.veb
    public int availableBytes() {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            return sonic.a();
        }
        return 0;
    }

    @Override // com.baidu.tieba.veb
    public void close() {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.b();
        }
    }

    @Override // com.baidu.tieba.veb
    public void flush() {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.c();
        }
    }

    @Override // com.baidu.tieba.veb
    public byte[] getOutPutBytes() {
        int availableBytes = availableBytes();
        byte[] bArr = new byte[availableBytes];
        receiveBytes(bArr, availableBytes);
        return bArr;
    }

    @Override // com.baidu.tieba.veb
    public void init(int i, int i2) {
        this.mSonic = new Sonic(i, i2);
    }

    @Override // com.baidu.tieba.veb
    public boolean putBytes(byte[] bArr, int i) {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.d(bArr, i);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.veb
    public int receiveBytes(byte[] bArr, int i) {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            return sonic.e(bArr, i);
        }
        return 0;
    }

    @Override // com.baidu.tieba.veb
    public void setSpeed(float f) {
        Sonic sonic = this.mSonic;
        if (sonic != null) {
            sonic.f(f);
        }
    }
}
