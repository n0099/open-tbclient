package com.baidu.tieba.view;

import java.util.ArrayList;
/* loaded from: classes.dex */
class bz {

    /* renamed from: a  reason: collision with root package name */
    int f2685a = 0;
    ArrayList<int[]> b = new ArrayList<>();
    final /* synthetic */ WaterFallView c;

    public bz(WaterFallView waterFallView) {
        this.c = waterFallView;
    }

    public void a(int i) {
        this.f2685a += i;
        this.b.add(new int[]{this.f2685a, this.f2685a});
    }

    public void a() {
        this.f2685a = 0;
        this.b.clear();
    }

    public int b() {
        return this.f2685a;
    }

    public int b(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.b.get(i2)[1] > i) {
                return i2;
            }
        }
        return -1;
    }

    public int c(int i) {
        int i2;
        int size = this.b.size();
        if (size <= 0) {
            return -1;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i2 = i3;
                break;
            } else if (this.b.get(i3)[0] <= i) {
                i3++;
            } else {
                i2 = i3 - 1;
                break;
            }
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 >= size) {
            return size - 1;
        }
        return i2;
    }
}
