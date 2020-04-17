package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> lOt;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.lOt = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dld() {
        return this.lOt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.lOt.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.lOt != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lOt.size()) {
                    break;
                }
                if (this.lOt.get(i2).get() == activity) {
                    this.lOt.remove(this.lOt.get(i2));
                }
                i = i2 + 1;
            }
        }
        dle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String dle() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.lOt.size(); i++) {
            Activity activity = this.lOt.get(i).get();
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
        private static final d lOu = new d((byte) 0);
    }
}
