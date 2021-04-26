package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f27549d = "e";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f27550e = {0, 1, 2, 3};
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static e f27551f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f27552g;

    /* renamed from: a  reason: collision with root package name */
    public List<Vector<BdNetTask>> f27553a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f27554b;

    /* renamed from: c  reason: collision with root package name */
    public Context f27555c;

    public e() {
        int length = f27550e.length;
        this.f27553a = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.f27553a.add(new Vector<>());
        }
        this.f27554b = new Vector<>();
    }

    public static e a() {
        synchronized (e.class) {
            if (f27551f == null) {
                f27551f = new e();
            }
        }
        return f27551f;
    }

    public static boolean b() {
        return f27552g;
    }

    public static void c() {
        f27551f = null;
    }

    public final synchronized void a(BdNetTask bdNetTask, int i2) {
        if (bdNetTask == null) {
            return;
        }
        if (this.f27553a == null) {
            this.f27553a = new ArrayList(f27550e.length);
        }
        if (this.f27553a.isEmpty()) {
            for (int i3 = 0; i3 < f27550e.length; i3++) {
                this.f27553a.add(new Vector<>());
            }
        }
        int length = f27550e.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i2 == f27550e[i4]) {
                this.f27553a.get(i4).add(bdNetTask);
                return;
            }
        }
    }

    public final synchronized BdNetTask d() {
        int size = this.f27553a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Vector<BdNetTask> vector = this.f27553a.get(i2);
            if (vector.size() > 0) {
                return vector.remove(0);
            }
        }
        return null;
    }

    public final synchronized BdNetEngine e() {
        int size = this.f27554b.size();
        for (int i2 = 0; i2 < size; i2++) {
            BdNetEngine bdNetEngine = this.f27554b.get(i2);
            if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                bdNetEngine.allocate();
                return bdNetEngine;
            }
        }
        if (size < 6) {
            BdNetEngine bdNetEngine2 = new BdNetEngine();
            bdNetEngine2.allocate();
            this.f27554b.add(bdNetEngine2);
            return bdNetEngine2;
        }
        return null;
    }
}
