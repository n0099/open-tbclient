package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class q extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f1807a;
    private String b;
    private Hashtable c;

    public q(Hashtable hashtable) {
        this.f1807a = 3;
        this.b = null;
        this.c = null;
        this.f1807a = 3;
        this.c = hashtable;
    }

    public q(int i, String str) {
        this.f1807a = 3;
        this.b = null;
        this.c = null;
        this.f1807a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList y;
        super.run();
        try {
            if (this.f1807a == 3) {
                if (this.c != null && (y = DatabaseService.y()) != null) {
                    int size = y.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put((String) y.get(i), 1);
                    }
                }
            } else if (this.f1807a == 2) {
                DatabaseService.r(this.b);
            } else if (this.f1807a == 1) {
                DatabaseService.q(this.b);
            }
        } catch (Exception e) {
            aq.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
