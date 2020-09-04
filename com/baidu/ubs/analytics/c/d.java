package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes5.dex */
public final class d {
    private Stack<WeakReference<Activity>> ngo;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.ngo = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dMw() {
        return this.ngo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.ngo.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.ngo != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ngo.size()) {
                    break;
                }
                if (this.ngo.get(i2).get() == activity) {
                    this.ngo.remove(this.ngo.get(i2));
                }
                i = i2 + 1;
            }
        }
        Uu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String Uu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.ngo.size(); i++) {
            Activity activity = this.ngo.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static final d ngp = new d((byte) 0);
    }
}
