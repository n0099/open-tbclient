package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class z extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f2618a;
    private String b;
    private Hashtable<String, Integer> c;

    public z(Hashtable<String, Integer> hashtable) {
        this.f2618a = 3;
        this.b = null;
        this.c = null;
        this.f2618a = 3;
        this.c = hashtable;
    }

    public z(int i, String str) {
        this.f2618a = 3;
        this.b = null;
        this.c = null;
        this.f2618a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList<String> y;
        super.run();
        try {
            if (this.f2618a == 3) {
                if (this.c != null && (y = DatabaseService.y()) != null) {
                    int size = y.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put(y.get(i), 1);
                    }
                }
            } else if (this.f2618a == 2) {
                DatabaseService.q(this.b);
            } else if (this.f2618a == 1) {
                DatabaseService.p(this.b);
            }
        } catch (Exception e) {
            bd.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
