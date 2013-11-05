package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class x extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f2464a;
    private String b;
    private Hashtable<String, Integer> c;

    public x(Hashtable<String, Integer> hashtable) {
        this.f2464a = 3;
        this.b = null;
        this.c = null;
        this.f2464a = 3;
        this.c = hashtable;
    }

    public x(int i, String str) {
        this.f2464a = 3;
        this.b = null;
        this.c = null;
        this.f2464a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList<String> y;
        super.run();
        try {
            if (this.f2464a == 3) {
                if (this.c != null && (y = DatabaseService.y()) != null) {
                    int size = y.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put(y.get(i), 1);
                    }
                }
            } else if (this.f2464a == 2) {
                DatabaseService.r(this.b);
            } else if (this.f2464a == 1) {
                DatabaseService.q(this.b);
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
