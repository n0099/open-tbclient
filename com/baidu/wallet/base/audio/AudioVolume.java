package com.baidu.wallet.base.audio;

import com.baidu.wallet.core.utils.LogUtil;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class AudioVolume {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23287a = "AudioVolume";

    /* renamed from: b  reason: collision with root package name */
    public int f23288b;

    /* renamed from: c  reason: collision with root package name */
    public int f23289c = 8000;

    /* renamed from: d  reason: collision with root package name */
    public long f23290d;

    /* renamed from: e  reason: collision with root package name */
    public double f23291e;

    public AudioVolume(int i2) {
        a(i2);
    }

    private void a(int i2) {
        this.f23288b = 0;
        this.f23290d = 0;
        if (512 < i2) {
            this.f23289c = i2;
        } else {
            this.f23289c = 8000;
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
            i2 = this.f23289c >> 1;
            i3 = this.f23288b;
        } else {
            i2 = this.f23289c;
            i3 = this.f23288b;
        }
        int i4 = i2 - i3;
        int i5 = limit - position;
        if (i4 >= i5) {
            while (position < limit) {
                this.f23290d = (long) (this.f23290d + Math.pow(z ? byteBuffer.getShort(position) : byteBuffer.get(position), 2.0d));
                position++;
            }
            this.f23288b += i5;
            return;
        }
        int i6 = i4 + position;
        while (position < i6) {
            short s = z ? byteBuffer.getShort(position) : byteBuffer.get(position);
            LogUtil.d(f23287a, "value: " + ((int) s));
            this.f23290d = (long) (((double) this.f23290d) + Math.pow((double) s, 2.0d));
            position++;
        }
        this.f23291e = Math.log10((int) (this.f23290d / this.f23289c)) * 10.0d;
        LogUtil.i(f23287a, "calAccumulatedVolume: " + this.f23291e + "|" + i6 + "|" + this.f23290d);
        this.f23290d = 0L;
        this.f23288b = 0;
        for (int i7 = i6; i7 < limit; i7++) {
            this.f23290d = (long) (this.f23290d + Math.pow(z ? byteBuffer.getShort(i7) : byteBuffer.get(i7), 2.0d));
        }
        this.f23288b += limit - i6;
    }

    public double getVolume() {
        return this.f23291e;
    }
}
