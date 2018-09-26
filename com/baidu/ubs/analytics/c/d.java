package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes2.dex */
public final class d {
    private Stack<WeakReference<Activity>> hKW;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hKW = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bLU() {
        return this.hKW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.hKW.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.hKW != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hKW.size()) {
                    break;
                }
                if (this.hKW.get(i2).get() == activity) {
                    this.hKW.remove(this.hKW.get(i2));
                }
                i = i2 + 1;
            }
        }
        bLV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bLV() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hKW.size(); i++) {
            Activity activity = this.hKW.get(i).get();
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
        private static final d hKX = new d((byte) 0);
    }
}
