package com.baidu.wallet.base.audio;

import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.wallet.core.utils.LogUtil;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class AudioVolume {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23520a = "AudioVolume";

    /* renamed from: b  reason: collision with root package name */
    public int f23521b;

    /* renamed from: c  reason: collision with root package name */
    public int f23522c = 8000;

    /* renamed from: d  reason: collision with root package name */
    public long f23523d;

    /* renamed from: e  reason: collision with root package name */
    public double f23524e;

    public AudioVolume(int i) {
        a(i);
    }

    private void a(int i) {
        this.f23521b = 0;
        this.f23523d = 0;
        if (512 < i) {
            this.f23522c = i;
        } else {
            this.f23522c = 8000;
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
            i = this.f23522c >> 1;
            i2 = this.f23521b;
        } else {
            i = this.f23522c;
            i2 = this.f23521b;
        }
        int i3 = i - i2;
        int i4 = limit - position;
        if (i3 >= i4) {
            while (position < limit) {
                this.f23523d = (long) (this.f23523d + Math.pow(z ? byteBuffer.getShort(position) : byteBuffer.get(position), 2.0d));
                position++;
            }
            this.f23521b += i4;
            return;
        }
        int i5 = i3 + position;
        while (position < i5) {
            short s = z ? byteBuffer.getShort(position) : byteBuffer.get(position);
            LogUtil.d(f23520a, "value: " + ((int) s));
            this.f23523d = (long) (((double) this.f23523d) + Math.pow((double) s, 2.0d));
            position++;
        }
        this.f23524e = Math.log10((int) (this.f23523d / this.f23522c)) * 10.0d;
        LogUtil.i(f23520a, "calAccumulatedVolume: " + this.f23524e + FieldBuilder.SE + i5 + FieldBuilder.SE + this.f23523d);
        this.f23523d = 0L;
        this.f23521b = 0;
        for (int i6 = i5; i6 < limit; i6++) {
            this.f23523d = (long) (this.f23523d + Math.pow(z ? byteBuffer.getShort(i6) : byteBuffer.get(i6), 2.0d));
        }
        this.f23521b += limit - i5;
    }

    public double getVolume() {
        return this.f23524e;
    }
}
