package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes2.dex */
public final class d {
    private Stack<WeakReference<Activity>> hCy;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hCy = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bIZ() {
        return this.hCy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.hCy.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.hCy != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hCy.size()) {
                    break;
                }
                if (this.hCy.get(i2).get() == activity) {
                    this.hCy.remove(this.hCy.get(i2));
                }
                i = i2 + 1;
            }
        }
        bJa();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bJa() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hCy.size(); i++) {
            Activity activity = this.hCy.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static final d hCz = new d((byte) 0);
    }
}
