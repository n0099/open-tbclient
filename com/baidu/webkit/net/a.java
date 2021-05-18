package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final String f26794d = "a";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f26795e = {0, 1, 2, 3};
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static a f26796f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f26797g;

    /* renamed from: a  reason: collision with root package name */
    public List<Vector<BdNetTask>> f26798a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f26799b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26800c;

    public a() {
        int length = f26795e.length;
        this.f26798a = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            this.f26798a.add(new Vector<>());
        }
        this.f26799b = new Vector<>();
    }

    public static a a() {
        synchronized (a.class) {
            if (f26796f == null) {
                f26796f = new a();
            }
        }
        return f26796f;
    }

    public static boolean b() {
        return f26797g;
    }

    public static void c() {
        f26796f = null;
    }

    public final synchronized void a(BdNetTask bdNetTask, int i2) {
        if (bdNetTask == null) {
            return;
        }
        if (this.f26798a == null) {
            this.f26798a = new ArrayList(f26795e.length);
        }
        if (this.f26798a.isEmpty()) {
            for (int i3 = 0; i3 < f26795e.length; i3++) {
                this.f26798a.add(new Vector<>());
            }
        }
        int length = f26795e.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i2 == f26795e[i4]) {
                this.f26798a.get(i4).add(bdNetTask);
                return;
            }
        }
    }

    public final synchronized BdNetTask d() {
        int size = this.f26798a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Vector<BdNetTask> vector = this.f26798a.get(i2);
            if (vector.size() > 0) {
                return vector.remove(0);
            }
        }
        return null;
    }

    public final synchronized BdNetEngine e() {
        int size = this.f26799b.size();
        for (int i2 = 0; i2 < size; i2++) {
            BdNetEngine bdNetEngine = this.f26799b.get(i2);
            if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                bdNetEngine.allocate();
                return bdNetEngine;
            }
        }
        if (size < 6) {
            BdNetEngine bdNetEngine2 = new BdNetEngine();
            bdNetEngine2.allocate();
            this.f26799b.add(bdNetEngine2);
            return bdNetEngine2;
        }
        return null;
    }
}
