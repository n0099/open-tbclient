package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> mhM;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.mhM = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dsq() {
        return this.mhM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.mhM.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.mhM != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mhM.size()) {
                    break;
                }
                if (this.mhM.get(i2).get() == activity) {
                    this.mhM.remove(this.mhM.get(i2));
                }
                i = i2 + 1;
            }
        }
        dsr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String dsr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mhM.size(); i++) {
            Activity activity = this.mhM.get(i).get();
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
        private static final d mhN = new d((byte) 0);
    }
}
