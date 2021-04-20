package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f26730d = "e";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f26731e = {0, 1, 2, 3};
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static e f26732f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f26733g;

    /* renamed from: a  reason: collision with root package name */
    public List<Vector<BdNetTask>> f26734a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f26735b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26736c;

    public e() {
        int length = f26731e.length;
        this.f26734a = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f26734a.add(new Vector<>());
        }
        this.f26735b = new Vector<>();
    }

    public static e a() {
        synchronized (e.class) {
            if (f26732f == null) {
                f26732f = new e();
            }
        }
        return f26732f;
    }

    public static boolean b() {
        return f26733g;
    }

    public static void c() {
        f26732f = null;
    }

    public final synchronized void a(BdNetTask bdNetTask, int i) {
        if (bdNetTask == null) {
            return;
        }
        if (this.f26734a == null) {
            this.f26734a = new ArrayList(f26731e.length);
        }
        if (this.f26734a.isEmpty()) {
            for (int i2 = 0; i2 < f26731e.length; i2++) {
                this.f26734a.add(new Vector<>());
            }
        }
        int length = f26731e.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i == f26731e[i3]) {
                this.f26734a.get(i3).add(bdNetTask);
                return;
            }
        }
    }

    public final synchronized BdNetTask d() {
        int size = this.f26734a.size();
        for (int i = 0; i < size; i++) {
            Vector<BdNetTask> vector = this.f26734a.get(i);
            if (vector.size() > 0) {
                return vector.remove(0);
            }
        }
        return null;
    }

    public final synchronized BdNetEngine e() {
        int size = this.f26735b.size();
        for (int i = 0; i < size; i++) {
            BdNetEngine bdNetEngine = this.f26735b.get(i);
            if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                bdNetEngine.allocate();
                return bdNetEngine;
            }
        }
        if (size < 6) {
            BdNetEngine bdNetEngine2 = new BdNetEngine();
            bdNetEngine2.allocate();
            this.f26735b.add(bdNetEngine2);
            return bdNetEngine2;
        }
        return null;
    }
}
