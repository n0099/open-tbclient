package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jxc;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jxc = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> css() {
        return this.jxc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jxc.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jxc != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jxc.size()) {
                    break;
                }
                if (this.jxc.get(i2).get() == activity) {
                    this.jxc.remove(this.jxc.get(i2));
                }
                i = i2 + 1;
            }
        }
        cst();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cst() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jxc.size(); i++) {
            Activity activity = this.jxc.get(i).get();
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
        private static final d jxd = new d((byte) 0);
    }
}
