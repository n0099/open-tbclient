package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/* loaded from: classes11.dex */
public final class e {
    private static final String d = e.class.getSimpleName();
    private static final int[] e = {0, 1, 2, 3};
    @SuppressLint({"StaticFieldLeak"})
    private static e f;
    private static boolean g;
    List<Vector<BdNetTask>> a;
    Vector<BdNetEngine> b;
    Context c;

    private e() {
        int length = e.length;
        this.a = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            this.a.add(new Vector<>());
        }
        this.b = new Vector<>();
    }

    public static e a() {
        synchronized (e.class) {
            if (f == null) {
                f = new e();
            }
        }
        return f;
    }

    public static boolean b() {
        return g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        f = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        r4.a.get(r0).add(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(BdNetTask bdNetTask, int i) {
        int i2 = 0;
        synchronized (this) {
            if (bdNetTask != null) {
                if (this.a == null) {
                    this.a = new ArrayList(e.length);
                }
                if (this.a.isEmpty()) {
                    for (int i3 = 0; i3 < e.length; i3++) {
                        this.a.add(new Vector<>());
                    }
                }
                int length = e.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (i == e[i2]) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = r0.remove(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized BdNetTask d() {
        BdNetTask bdNetTask;
        int size = this.a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                bdNetTask = null;
                break;
            }
            Vector<BdNetTask> vector = this.a.get(i);
            if (vector.size() > 0) {
                break;
            }
            i++;
        }
        return bdNetTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized BdNetEngine e() {
        BdNetEngine bdNetEngine;
        int size = this.b.size();
        int i = 0;
        while (true) {
            if (i < size) {
                bdNetEngine = this.b.get(i);
                if (!bdNetEngine.isWorking() && bdNetEngine.isRecycle()) {
                    bdNetEngine.allocate();
                    break;
                }
                i++;
            } else if (size < 6) {
                bdNetEngine = new BdNetEngine();
                bdNetEngine.allocate();
                this.b.add(bdNetEngine);
            } else {
                bdNetEngine = null;
            }
        }
        return bdNetEngine;
    }
}
