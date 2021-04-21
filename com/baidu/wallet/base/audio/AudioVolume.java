package com.baidu.wallet.base.audio;

import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.wallet.core.utils.LogUtil;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class AudioVolume {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23213a = "AudioVolume";

    /* renamed from: b  reason: collision with root package name */
    public int f23214b;

    /* renamed from: c  reason: collision with root package name */
    public int f23215c = 8000;

    /* renamed from: d  reason: collision with root package name */
    public long f23216d;

    /* renamed from: e  reason: collision with root package name */
    public double f23217e;

    public AudioVolume(int i) {
        a(i);
    }

    private void a(int i) {
        this.f23214b = 0;
        this.f23216d = 0;
        if (512 < i) {
            this.f23215c = i;
        } else {
            this.f23215c = 8000;
        }
    }

    public void calAccumulatedVolume(ByteBuffer byteBuffer, boolean z) {
        int i;
        int i2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        if (z) {
            position >>= 1;
            limit >>= 1;
            i = this.f23215c >> 1;
            i2 = this.f23214b;
        } else {
            i = this.f23215c;
            i2 = this.f23214b;
        }
        int i3 = i - i2;
        int i4 = limit - position;
        if (i3 >= i4) {
            while (position < limit) {
                this.f23216d = (long) (this.f23216d + Math.pow(z ? byteBuffer.getShort(position) : byteBuffer.get(position), 2.0d));
                position++;
            }
            this.f23214b += i4;
            return;
        }
        int i5 = i3 + position;
        while (position < i5) {
            short s = z ? byteBuffer.getShort(position) : byteBuffer.get(position);
            LogUtil.d(f23213a, "value: " + ((int) s));
            this.f23216d = (long) (((double) this.f23216d) + Math.pow((double) s, 2.0d));
            position++;
        }
        this.f23217e = Math.log10((int) (this.f23216d / this.f23215c)) * 10.0d;
        LogUtil.i(f23213a, "calAccumulatedVolume: " + this.f23217e + FieldBuilder.SE + i5 + FieldBuilder.SE + this.f23216d);
        this.f23216d = 0L;
        this.f23214b = 0;
        for (int i6 = i5; i6 < limit; i6++) {
            this.f23216d = (long) (this.f23216d + Math.pow(z ? byteBuffer.getShort(i6) : byteBuffer.get(i6), 2.0d));
        }
        this.f23214b += limit - i5;
    }

    public double getVolume() {
        return this.f23217e;
    }
}
