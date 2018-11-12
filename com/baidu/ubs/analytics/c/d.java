package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> hVz;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hVz = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bPI() {
        return this.hVz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.hVz.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.hVz != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hVz.size()) {
                    break;
                }
                if (this.hVz.get(i2).get() == activity) {
                    this.hVz.remove(this.hVz.get(i2));
                }
                i = i2 + 1;
            }
        }
        bPJ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bPJ() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hVz.size(); i++) {
            Activity activity = this.hVz.get(i).get();
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
        private static final d hVA = new d((byte) 0);
    }
}
