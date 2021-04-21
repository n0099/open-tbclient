package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final String f26738d = "e";

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f26739e = {0, 1, 2, 3};
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: f  reason: collision with root package name */
    public static e f26740f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f26741g;

    /* renamed from: a  reason: collision with root package name */
    public List<Vector<BdNetTask>> f26742a;

    /* renamed from: b  reason: collision with root package name */
    public Vector<BdNetEngine> f26743b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26744c;

    public e() {
        int length = f26739e.length;
        this.f26742a = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.f26742a.add(new Vector<>());
        }
        this.f26743b = new Vector<>();
    }

    public static e a() {
        synchronized (e.class) {
            if (f26740f == null) {
                f26740f = new e();
            }
        }
        return f26740f;
    }

    public static boolean b() {
        return f26741g;
    }

    public static void c() {
        f26740f = null;
    }

    public final synchronized void a(BdNetTask bdNetTask, int i) {
        if (bdNetTask == null) {
            return;
        }
        if (this.f26742a == null) {
            this.f26742a = new ArrayList(f26739e.length);
        }
        if (this.f26742a.isEmpty()) {
            for (int i2 = 0; i2 < f26739e.length; i2++) {
                this.f26742a.add(new Vector<>());
            }
        }
        int length = f26739e.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i == f26739e[i3]) {
                this.f26742a.get(i3).add(bdNetTask);
                return;
            }
        }
    }

    public final synchronized BdNetTask d() {
        int size = this.f26742a.size();
        for (int i = 0; i < size; i++) {
            Vector<BdNetTask> vector = this.f26742a.get(i);
            if (vector.size() > 0) {
                return vector.remove(0);
            }
        }
        return null;
    }

    public final synchronized BdNetEngine e() {
        int size = this.f26743b.size();
        for (int i = 0; i < size; i++) {
            BdNetEngine bdNetEngine = this.f26743b.get(i);
            if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                bdNetEngine.allocate();
                return bdNetEngine;
            }
        }
        if (size < 6) {
            BdNetEngine bdNetEngine2 = new BdNetEngine();
            bdNetEngine2.allocate();
            this.f26743b.add(bdNetEngine2);
            return bdNetEngine2;
        }
        return null;
    }
}
