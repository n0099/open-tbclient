package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> kVY;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.kVY = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cXt() {
        return this.kVY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.kVY.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.kVY != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kVY.size()) {
                    break;
                }
                if (this.kVY.get(i2).get() == activity) {
                    this.kVY.remove(this.kVY.get(i2));
                }
                i = i2 + 1;
            }
        }
        cXu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cXu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.kVY.size(); i++) {
            Activity activity = this.kVY.get(i).get();
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
        private static final d kVZ = new d((byte) 0);
    }
}
