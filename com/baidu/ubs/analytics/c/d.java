package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> miY;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.miY = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dsE() {
        return this.miY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.miY.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.miY != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.miY.size()) {
                    break;
                }
                if (this.miY.get(i2).get() == activity) {
                    this.miY.remove(this.miY.get(i2));
                }
                i = i2 + 1;
            }
        }
        dsF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String dsF() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.miY.size(); i++) {
            Activity activity = this.miY.get(i).get();
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
        private static final d miZ = new d((byte) 0);
    }
}
