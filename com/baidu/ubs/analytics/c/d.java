package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes10.dex */
public final class d {
    private Stack<WeakReference<Activity>> oim;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.oim = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dZX() {
        return this.oim;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.oim.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.oim != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oim.size()) {
                    break;
                }
                if (this.oim.get(i2).get() == activity) {
                    this.oim.remove(this.oim.get(i2));
                }
                i = i2 + 1;
            }
        }
        YU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String YU() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.oim.size(); i++) {
            Activity activity = this.oim.get(i).get();
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
        private static final d oin = new d((byte) 0);
    }
}
