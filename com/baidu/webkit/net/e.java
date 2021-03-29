package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f27045d = "e";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f27046e = {0, 1, 2, 3};
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static e f27047f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f27048g;

    /* renamed from: a  reason: collision with root package name */
    public List<Vector<BdNetTask>> f27049a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f27050b;

    /* renamed from: c  reason: collision with root package name */
    public Context f27051c;

    public e() {
        int length = f27046e.length;
        this.f27049a = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f27049a.add(new Vector<>());
        }
        this.f27050b = new Vector<>();
    }

    public static e a() {
        synchronized (e.class) {
            if (f27047f == null) {
                f27047f = new e();
            }
        }
        return f27047f;
    }

    public static boolean b() {
        return f27048g;
    }

    public static void c() {
        f27047f = null;
    }

    public final synchronized void a(BdNetTask bdNetTask, int i) {
        if (bdNetTask == null) {
            return;
        }
        if (this.f27049a == null) {
            this.f27049a = new ArrayList(f27046e.length);
        }
        if (this.f27049a.isEmpty()) {
            for (int i2 = 0; i2 < f27046e.length; i2++) {
                this.f27049a.add(new Vector<>());
            }
        }
        int length = f27046e.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i == f27046e[i3]) {
                this.f27049a.get(i3).add(bdNetTask);
                return;
            }
        }
    }

    public final synchronized BdNetTask d() {
        int size = this.f27049a.size();
        for (int i = 0; i < size; i++) {
            Vector<BdNetTask> vector = this.f27049a.get(i);
            if (vector.size() > 0) {
                return vector.remove(0);
            }
        }
        return null;
    }

    public final synchronized BdNetEngine e() {
        int size = this.f27050b.size();
        for (int i = 0; i < size; i++) {
            BdNetEngine bdNetEngine = this.f27050b.get(i);
            if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                bdNetEngine.allocate();
                return bdNetEngine;
            }
        }
        if (size < 6) {
            BdNetEngine bdNetEngine2 = new BdNetEngine();
            bdNetEngine2.allocate();
            this.f27050b.add(bdNetEngine2);
            return bdNetEngine2;
        }
        return null;
    }
}
