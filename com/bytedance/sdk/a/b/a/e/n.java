package com.bytedance.sdk.a.b.a.e;

import androidx.core.internal.view.SupportMenu;
import java.util.Arrays;
/* loaded from: classes4.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private int f5924a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f5925b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f5924a = 0;
        Arrays.fill(this.f5925b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n dX(int i, int i2) {
        if (i >= 0 && i < this.f5925b.length) {
            this.f5924a = (1 << i) | this.f5924a;
            this.f5925b[i] = i2;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return ((1 << i) & this.f5924a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return this.f5925b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.f5924a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((2 & this.f5924a) != 0) {
            return this.f5925b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return (16 & this.f5924a) != 0 ? this.f5925b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i) {
        return (32 & this.f5924a) != 0 ? this.f5925b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return (128 & this.f5924a) != 0 ? this.f5925b[7] : SupportMenu.USER_MASK;
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
