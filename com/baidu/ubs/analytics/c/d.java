package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes10.dex */
public final class d {
    private Stack<WeakReference<Activity>> nFK;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.nFK = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dUf() {
        return this.nFK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.nFK.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.nFK != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nFK.size()) {
                    break;
                }
                if (this.nFK.get(i2).get() == activity) {
                    this.nFK.remove(this.nFK.get(i2));
                }
                i = i2 + 1;
            }
        }
        Xa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String Xa() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.nFK.size(); i++) {
            Activity activity = this.nFK.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private static final d nFL = new d((byte) 0);
    }
}
