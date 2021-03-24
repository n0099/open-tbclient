package com.baidu.wallet.base.audio;

import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.wallet.core.utils.LogUtil;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class AudioVolume {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23519a = "AudioVolume";

    /* renamed from: b  reason: collision with root package name */
    public int f23520b;

    /* renamed from: c  reason: collision with root package name */
    public int f23521c = 8000;

    /* renamed from: d  reason: collision with root package name */
    public long f23522d;

    /* renamed from: e  reason: collision with root package name */
    public double f23523e;

    public AudioVolume(int i) {
        a(i);
    }

    private void a(int i) {
        this.f23520b = 0;
        this.f23522d = 0;
        if (512 < i) {
            this.f23521c = i;
        } else {
            this.f23521c = 8000;
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
            i = this.f23521c >> 1;
            i2 = this.f23520b;
        } else {
            i = this.f23521c;
            i2 = this.f23520b;
        }
        int i3 = i - i2;
        int i4 = limit - position;
        if (i3 >= i4) {
            while (position < limit) {
                short s = z ? byteBuffer.getShort(position) : byteBuffer.get(position);
                double d2 = this.f23522d;
                double pow = Math.pow(s, 2.0d);
                Double.isNaN(d2);
                this.f23522d = (long) (d2 + pow);
                position++;
            }
            this.f23520b += i4;
            return;
        }
        int i5 = i3 + position;
        while (position < i5) {
            short s2 = z ? byteBuffer.getShort(position) : byteBuffer.get(position);
            LogUtil.d(f23519a, "value: " + ((int) s2));
            double d3 = (double) this.f23522d;
            double pow2 = Math.pow((double) s2, 2.0d);
            Double.isNaN(d3);
            this.f23522d = (long) (d3 + pow2);
            position++;
        }
        this.f23523e = Math.log10((int) (this.f23522d / this.f23521c)) * 10.0d;
        LogUtil.i(f23519a, "calAccumulatedVolume: " + this.f23523e + FieldBuilder.SE + i5 + FieldBuilder.SE + this.f23522d);
        this.f23522d = 0L;
        this.f23520b = 0;
        for (int i6 = i5; i6 < limit; i6++) {
            short s3 = z ? byteBuffer.getShort(i6) : byteBuffer.get(i6);
            double d4 = this.f23522d;
            double pow3 = Math.pow(s3, 2.0d);
            Double.isNaN(d4);
            this.f23522d = (long) (d4 + pow3);
        }
        this.f23520b += limit - i5;
    }

    public double getVolume() {
        return this.f23523e;
    }
}
