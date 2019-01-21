package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> ihe;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.ihe = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bTm() {
        return this.ihe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.ihe.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.ihe != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ihe.size()) {
                    break;
                }
                if (this.ihe.get(i2).get() == activity) {
                    this.ihe.remove(this.ihe.get(i2));
                }
                i = i2 + 1;
            }
        }
        bTn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bTn() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.ihe.size(); i++) {
            Activity activity = this.ihe.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static final d ihf = new d((byte) 0);
    }
}
