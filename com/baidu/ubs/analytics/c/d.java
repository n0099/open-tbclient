package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> kWa;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.kWa = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cXv() {
        return this.kWa;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.kWa.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.kWa != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kWa.size()) {
                    break;
                }
                if (this.kWa.get(i2).get() == activity) {
                    this.kWa.remove(this.kWa.get(i2));
                }
                i = i2 + 1;
            }
        }
        cXw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cXw() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.kWa.size(); i++) {
            Activity activity = this.kWa.get(i).get();
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
        private static final d kWb = new d((byte) 0);
    }
}
