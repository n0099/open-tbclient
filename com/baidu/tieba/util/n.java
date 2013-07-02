package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class n extends Thread {
    private int a;
    private String b;
    private Hashtable c;

    public n(Hashtable hashtable) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = 3;
        this.c = hashtable;
    }

    public n(int i, String str) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList A;
        super.run();
        try {
            if (this.a == 3) {
                if (this.c != null && (A = DatabaseService.A()) != null) {
                    int size = A.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put((String) A.get(i), 1);
                    }
                }
            } else if (this.a == 2) {
                DatabaseService.t(this.b);
            } else if (this.a == 1) {
                DatabaseService.s(this.b);
            }
        } catch (Exception e) {
            z.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
