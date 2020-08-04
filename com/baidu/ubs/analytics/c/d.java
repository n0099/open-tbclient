package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> mNa;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.mNa = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dAA() {
        return this.mNa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.mNa.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.mNa != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mNa.size()) {
                    break;
                }
                if (this.mNa.get(i2).get() == activity) {
                    this.mNa.remove(this.mNa.get(i2));
                }
                i = i2 + 1;
            }
        }
        dAB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String dAB() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mNa.size(); i++) {
            Activity activity = this.mNa.get(i).get();
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
        private static final d mNb = new d((byte) 0);
    }
}
