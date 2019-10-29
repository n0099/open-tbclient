package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jYg;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jYg = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cBk() {
        return this.jYg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jYg.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jYg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jYg.size()) {
                    break;
                }
                if (this.jYg.get(i2).get() == activity) {
                    this.jYg.remove(this.jYg.get(i2));
                }
                i = i2 + 1;
            }
        }
        cBl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cBl() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jYg.size(); i++) {
            Activity activity = this.jYg.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private static final d jYh = new d((byte) 0);
    }
}
