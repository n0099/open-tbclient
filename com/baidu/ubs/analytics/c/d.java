package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jWE;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jWE = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cDq() {
        return this.jWE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jWE.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jWE != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jWE.size()) {
                    break;
                }
                if (this.jWE.get(i2).get() == activity) {
                    this.jWE.remove(this.jWE.get(i2));
                }
                i = i2 + 1;
            }
        }
        cDr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cDr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jWE.size(); i++) {
            Activity activity = this.jWE.get(i).get();
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
        private static final d jWF = new d((byte) 0);
    }
}
