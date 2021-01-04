package com.bytedance.sdk.a.b.a.e;

import androidx.core.internal.view.SupportMenu;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private int f6223a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f6224b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f6223a = 0;
        Arrays.fill(this.f6224b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n dX(int i, int i2) {
        if (i >= 0 && i < this.f6224b.length) {
            this.f6223a = (1 << i) | this.f6223a;
            this.f6224b[i] = i2;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return ((1 << i) & this.f6223a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return this.f6224b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.f6223a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((2 & this.f6223a) != 0) {
            return this.f6224b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return (16 & this.f6223a) != 0 ? this.f6224b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i) {
        return (32 & this.f6223a) != 0 ? this.f6224b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return (128 & this.f6223a) != 0 ? this.f6224b[7] : SupportMenu.USER_MASK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        for (int i = 0; i < 10; i++) {
            if (nVar.a(i)) {
                dX(i, nVar.b(i));
            }
        }
    }
}
