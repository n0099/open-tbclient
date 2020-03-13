package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> kWm;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.kWm = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cXw() {
        return this.kWm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.kWm.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.kWm != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kWm.size()) {
                    break;
                }
                if (this.kWm.get(i2).get() == activity) {
                    this.kWm.remove(this.kWm.get(i2));
                }
                i = i2 + 1;
            }
        }
        cXx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cXx() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.kWm.size(); i++) {
            Activity activity = this.kWm.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final d kWn = new d((byte) 0);
    }
}
