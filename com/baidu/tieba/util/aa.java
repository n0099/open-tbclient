package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public class aa extends Thread {
    private int a;
    private String b;
    private Hashtable<String, Integer> c;

    public aa(Hashtable<String, Integer> hashtable) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = 3;
        this.c = hashtable;
    }

    public aa(int i, String str) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList<String> y;
        super.run();
        try {
            if (this.a == 3) {
                if (this.c != null && (y = DatabaseService.y()) != null) {
                    int size = y.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put(y.get(i), 1);
                    }
                }
            } else if (this.a == 2) {
                DatabaseService.s(this.b);
            } else if (this.a == 1) {
                DatabaseService.r(this.b);
            }
        } catch (Exception e) {
            be.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
