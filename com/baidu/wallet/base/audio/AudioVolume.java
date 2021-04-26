package com.baidu.wallet.base.audio;

import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.wallet.core.utils.LogUtil;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class AudioVolume {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23928a = "AudioVolume";

    /* renamed from: b  reason: collision with root package name */
    public int f23929b;

    /* renamed from: c  reason: collision with root package name */
    public int f23930c = 8000;

    /* renamed from: d  reason: collision with root package name */
    public long f23931d;

    /* renamed from: e  reason: collision with root package name */
    public double f23932e;

    public AudioVolume(int i2) {
        a(i2);
    }

    private void a(int i2) {
        this.f23929b = 0;
        this.f23931d = 0;
        if (512 < i2) {
            this.f23930c = i2;
        } else {
            this.f23930c = 8000;
        }
    }

    public void calAccumulatedVolume(ByteBuffer byteBuffer, boolean z) {
        int i2;
        int i3;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (z) {
            position >>= 1;
            limit >>= 1;
            i2 = this.f23930c >> 1;
            i3 = this.f23929b;
        } else {
            i2 = this.f23930c;
            i3 = this.f23929b;
        }
        int i4 = i2 - i3;
        int i5 = limit - position;
        if (i4 >= i5) {
            while (position < limit) {
                this.f23931d = (long) (this.f23931d + Math.pow(z ? byteBuffer.getShort(position) : byteBuffer.get(position), 2.0d));
                position++;
            }
            this.f23929b += i5;
            return;
        }
        int i6 = i4 + position;
        while (position < i6) {
            short s = z ? byteBuffer.getShort(position) : byteBuffer.get(position);
            LogUtil.d(f23928a, "value: " + ((int) s));
            this.f23931d = (long) (((double) this.f23931d) + Math.pow((double) s, 2.0d));
            position++;
        }
        this.f23932e = Math.log10((int) (this.f23931d / this.f23930c)) * 10.0d;
        LogUtil.i(f23928a, "calAccumulatedVolume: " + this.f23932e + FieldBuilder.SE + i6 + FieldBuilder.SE + this.f23931d);
        this.f23931d = 0L;
        this.f23929b = 0;
        for (int i7 = i6; i7 < limit; i7++) {
            this.f23931d = (long) (this.f23931d + Math.pow(z ? byteBuffer.getShort(i7) : byteBuffer.get(i7), 2.0d));
        }
        this.f23929b += limit - i6;
    }

    public double getVolume() {
        return this.f23932e;
    }
}
