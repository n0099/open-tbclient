package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class q extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private int f1770a;
    private String b;
    private Hashtable c;

    public q(Hashtable hashtable) {
        this.f1770a = 3;
        this.b = null;
        this.c = null;
        this.f1770a = 3;
        this.c = hashtable;
    }

    public q(int i, String str) {
        this.f1770a = 3;
        this.b = null;
        this.c = null;
        this.f1770a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList A;
        super.run();
        try {
            if (this.f1770a == 3) {
                if (this.c != null && (A = DatabaseService.A()) != null) {
                    int size = A.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put((String) A.get(i), 1);
                    }
                }
            } else if (this.f1770a == 2) {
                DatabaseService.t(this.b);
            } else if (this.f1770a == 1) {
                DatabaseService.s(this.b);
            }
        } catch (Exception e) {
            aj.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
