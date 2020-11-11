package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes10.dex */
public final class d {
    private Stack<WeakReference<Activity>> ors;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.ors = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> edF() {
        return this.ors;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.ors.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.ors != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ors.size()) {
                    break;
                }
                if (this.ors.get(i2).get() == activity) {
                    this.ors.remove(this.ors.get(i2));
                }
                i = i2 + 1;
            }
        }
        abt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String abt() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.ors.size(); i++) {
            Activity activity = this.ors.get(i).get();
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
        private static final d ort = new d((byte) 0);
    }
}
