package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes.dex */
public final class d {
    private Stack<WeakReference<Activity>> hxM;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hxM = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bJU() {
        return this.hxM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.hxM.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.hxM != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hxM.size()) {
                    break;
                }
                if (this.hxM.get(i2).get() == activity) {
                    this.hxM.remove(this.hxM.get(i2));
                }
                i = i2 + 1;
            }
        }
        bJV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bJV() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hxM.size(); i++) {
            Activity activity = this.hxM.get(i).get();
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
        private static final d hxN = new d((byte) 0);
    }
}
