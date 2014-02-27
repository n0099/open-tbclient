package com.baidu.tieba.util;

import java.util.ArrayList;
import java.util.Hashtable;
/* loaded from: classes.dex */
public final class ah extends Thread {
    private int a;
    private String b;
    private Hashtable<String, Integer> c;

    public ah(Hashtable<String, Integer> hashtable) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = 3;
        this.c = hashtable;
    }

    public ah(int i, String str) {
        this.a = 3;
        this.b = null;
        this.c = null;
        this.a = i;
        this.b = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ArrayList<String> v;
        super.run();
        try {
            if (this.a == 3) {
                if (this.c != null && (v = DatabaseService.v()) != null) {
                    int size = v.size();
                    for (int i = 0; i < size; i++) {
                        this.c.put(v.get(i), 1);
                    }
                }
            } else if (this.a == 2) {
                DatabaseService.n(this.b);
            } else if (this.a == 1) {
                DatabaseService.m(this.b);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "run", e.getMessage());
        }
    }
}
