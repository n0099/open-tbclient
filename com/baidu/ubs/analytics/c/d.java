package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> lOx;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.lOx = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dlb() {
        return this.lOx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.lOx.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.lOx != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lOx.size()) {
                    break;
                }
                if (this.lOx.get(i2).get() == activity) {
                    this.lOx.remove(this.lOx.get(i2));
                }
                i = i2 + 1;
            }
        }
        dlc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String dlc() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.lOx.size(); i++) {
            Activity activity = this.lOx.get(i).get();
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
        private static final d lOy = new d((byte) 0);
    }
}
