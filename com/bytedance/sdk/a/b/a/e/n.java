package com.bytedance.sdk.a.b.a.e;

import java.util.Arrays;
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private int f3986a;
    private final int[] b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f3986a = 0;
        Arrays.fill(this.b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n dV(int i, int i2) {
        if (i >= 0 && i < this.b.length) {
            this.f3986a = (1 << i) | this.f3986a;
            this.b[i] = i2;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return ((1 << i) & this.f3986a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return this.b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.f3986a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((2 & this.f3986a) != 0) {
            return this.b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return (16 & this.f3986a) != 0 ? this.b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i) {
        return (32 & this.f3986a) != 0 ? this.b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        if ((128 & this.f3986a) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        for (int i = 0; i < 10; i++) {
            if (nVar.a(i)) {
                dV(i, nVar.b(i));
            }
        }
    }
}
