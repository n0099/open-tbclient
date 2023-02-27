package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes7.dex */
public final class a {
    public static final String d = "a";
    public static final int[] e = {0, 1, 2, 3};
    @SuppressLint({"StaticFieldLeak"})
    public static a f;
    public static boolean g;
    public List<Vector<BdNetTask>> a;
    public Vector<BdNetEngine> b;
    public Context c;

    public a() {
        int length = e.length;
        this.a = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.a.add(new Vector<>());
        }
        this.b = new Vector<>();
    }

    public static a a() {
        synchronized (a.class) {
            if (f == null) {
                f = new a();
            }
        }
        return f;
    }

    public static boolean b() {
        return g;
    }

    public static void c() {
        f = null;
    }

    public final synchronized void a(BdNetTask bdNetTask, int i) {
        if (bdNetTask == null) {
            return;
        }
        if (this.a == null) {
            this.a = new ArrayList(e.length);
        }
        if (this.a.isEmpty()) {
            for (int i2 = 0; i2 < e.length; i2++) {
                this.a.add(new Vector<>());
            }
        }
        int length = e.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i == e[i3]) {
                this.a.get(i3).add(bdNetTask);
                return;
            }
        }
    }

    public final synchronized BdNetTask d() {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            Vector<BdNetTask> vector = this.a.get(i);
            if (vector.size() > 0) {
                return vector.remove(0);
            }
        }
        return null;
    }

    public final synchronized BdNetEngine e() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            BdNetEngine bdNetEngine = this.b.get(i);
            if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                bdNetEngine.allocate();
                return bdNetEngine;
            }
        }
        if (size < 6) {
            BdNetEngine bdNetEngine2 = new BdNetEngine();
            bdNetEngine2.allocate();
            this.b.add(bdNetEngine2);
            return bdNetEngine2;
        }
        return null;
    }
}
