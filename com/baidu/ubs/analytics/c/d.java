package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes2.dex */
public final class d {
    private Stack<WeakReference<Activity>> hBT;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hBT = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bKv() {
        return this.hBT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.hBT.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.hBT != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hBT.size()) {
                    break;
                }
                if (this.hBT.get(i2).get() == activity) {
                    this.hBT.remove(this.hBT.get(i2));
                }
                i = i2 + 1;
            }
        }
        bKw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bKw() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hBT.size(); i++) {
            Activity activity = this.hBT.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static final d hBU = new d((byte) 0);
    }
}
