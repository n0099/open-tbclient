package com.baidu.tieba.view;

import java.util.ArrayList;
/* loaded from: classes.dex */
class bl {

    /* renamed from: a  reason: collision with root package name */
    int f1836a = 0;
    ArrayList b = new ArrayList();
    final /* synthetic */ WaterFallView c;

    public bl(WaterFallView waterFallView) {
        this.c = waterFallView;
    }

    public void a(int i) {
        this.f1836a += i;
        this.b.add(new int[]{this.f1836a, this.f1836a});
    }

    public void a() {
        this.f1836a = 0;
        this.b.clear();
    }

    public int b() {
        return this.f1836a;
    }

    public int b(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((int[]) this.b.get(i2))[1] > i) {
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
            } else if (((int[]) this.b.get(i3))[0] <= i) {
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
