package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f26826d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f26827e = {0, 1, 2, 3};
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static a f26828f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f26829g;

    /* renamed from: a  reason: collision with root package name */
    public List<Vector<BdNetTask>> f26830a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f26831b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26832c;

    public a() {
        int length = f26827e.length;
        this.f26830a = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.f26830a.add(new Vector<>());
        }
        this.f26831b = new Vector<>();
    }

    public static a a() {
        synchronized (a.class) {
            if (f26828f == null) {
                f26828f = new a();
            }
        }
        return f26828f;
    }

    public static boolean b() {
        return f26829g;
    }

    public static void c() {
        f26828f = null;
    }

    public final synchronized void a(BdNetTask bdNetTask, int i2) {
        if (bdNetTask == null) {
            return;
        }
        if (this.f26830a == null) {
            this.f26830a = new ArrayList(f26827e.length);
        }
        if (this.f26830a.isEmpty()) {
            for (int i3 = 0; i3 < f26827e.length; i3++) {
                this.f26830a.add(new Vector<>());
            }
        }
        int length = f26827e.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i2 == f26827e[i4]) {
                this.f26830a.get(i4).add(bdNetTask);
                return;
            }
        }
    }

    public final synchronized BdNetTask d() {
        int size = this.f26830a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Vector<BdNetTask> vector = this.f26830a.get(i2);
            if (vector.size() > 0) {
                return vector.remove(0);
            }
        }
        return null;
    }

    public final synchronized BdNetEngine e() {
        int size = this.f26831b.size();
        for (int i2 = 0; i2 < size; i2++) {
            BdNetEngine bdNetEngine = this.f26831b.get(i2);
            if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                bdNetEngine.allocate();
                return bdNetEngine;
            }
        }
        if (size < 6) {
            BdNetEngine bdNetEngine2 = new BdNetEngine();
            bdNetEngine2.allocate();
            this.f26831b.add(bdNetEngine2);
            return bdNetEngine2;
        }
        return null;
    }
}
