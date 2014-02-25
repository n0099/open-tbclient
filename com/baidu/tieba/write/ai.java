package com.baidu.tieba.write;

import com.baidu.tieba.data.AntiData;
/* loaded from: classes.dex */
public class ai {
    final int a;
    final String b;
    final AntiData c;

    public ai(int i, String str, AntiData antiData) {
        this.a = i;
        this.b = str;
        this.c = antiData;
    }

    public boolean a() {
        return this.a != 0;
    }

    public boolean b() {
        return this.a == 5 || this.a == 6;
    }

    public int c() {
        return this.a;
    }

    public String d() {
        return this.b;
    }

    public AntiData e() {
        return this.c;
    }
}
