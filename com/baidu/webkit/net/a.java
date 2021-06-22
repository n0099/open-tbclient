package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f26908d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f26909e = {0, 1, 2, 3};
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static a f26910f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f26911g;

    /* renamed from: a  reason: collision with root package name */
    public List<Vector<BdNetTask>> f26912a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f26913b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26914c;

    public a() {
        int length = f26909e.length;
        this.f26912a = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.f26912a.add(new Vector<>());
        }
        this.f26913b = new Vector<>();
    }

    public static a a() {
        synchronized (a.class) {
            if (f26910f == null) {
                f26910f = new a();
            }
        }
        return f26910f;
    }

    public static boolean b() {
        return f26911g;
    }

    public static void c() {
        f26910f = null;
    }

    public final synchronized void a(BdNetTask bdNetTask, int i2) {
        if (bdNetTask == null) {
            return;
        }
        if (this.f26912a == null) {
            this.f26912a = new ArrayList(f26909e.length);
        }
        if (this.f26912a.isEmpty()) {
            for (int i3 = 0; i3 < f26909e.length; i3++) {
                this.f26912a.add(new Vector<>());
            }
        }
        int length = f26909e.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i2 == f26909e[i4]) {
                this.f26912a.get(i4).add(bdNetTask);
                return;
            }
        }
    }

    public final synchronized BdNetTask d() {
        int size = this.f26912a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Vector<BdNetTask> vector = this.f26912a.get(i2);
            if (vector.size() > 0) {
                return vector.remove(0);
            }
        }
        return null;
    }

    public final synchronized BdNetEngine e() {
        int size = this.f26913b.size();
        for (int i2 = 0; i2 < size; i2++) {
            BdNetEngine bdNetEngine = this.f26913b.get(i2);
            if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                bdNetEngine.allocate();
                return bdNetEngine;
            }
        }
        if (size < 6) {
            BdNetEngine bdNetEngine2 = new BdNetEngine();
            bdNetEngine2.allocate();
            this.f26913b.add(bdNetEngine2);
            return bdNetEngine2;
        }
        return null;
    }
}
