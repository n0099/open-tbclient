package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class q extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f1927a;
    private String b;
    private Hashtable<String, Integer> c;

    public q(Hashtable<String, Integer> hashtable) {
        this.f1927a = 3;
        this.b = null;
        this.c = null;
        this.f1927a = 3;
        this.c = hashtable;
    }

    public q(int i, String str) {
        this.f1927a = 3;
        this.b = null;
        this.c = null;
        this.f1927a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList<String> y;
        super.run();
        try {
            if (this.f1927a == 3) {
                if (this.c != null && (y = DatabaseService.y()) != null) {
                    int size = y.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put(y.get(i), 1);
                    }
                }
            } else if (this.f1927a == 2) {
                DatabaseService.r(this.b);
            } else if (this.f1927a == 1) {
                DatabaseService.q(this.b);
            }
        } catch (Exception e) {
            av.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
