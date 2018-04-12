package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes.dex */
public final class d {
    private Stack<WeakReference<Activity>> hkQ;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hkQ = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bES() {
        return this.hkQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.hkQ.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.hkQ != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hkQ.size()) {
                    break;
                }
                if (this.hkQ.get(i2).get() == activity) {
                    this.hkQ.remove(this.hkQ.get(i2));
                }
                i = i2 + 1;
            }
        }
        bET();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bET() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hkQ.size(); i++) {
            Activity activity = this.hkQ.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d hkR = new d((byte) 0);
    }
}
