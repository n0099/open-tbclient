package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> kVs;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.kVs = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cWf() {
        return this.kVs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.kVs.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.kVs != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kVs.size()) {
                    break;
                }
                if (this.kVs.get(i2).get() == activity) {
                    this.kVs.remove(this.kVs.get(i2));
                }
                i = i2 + 1;
            }
        }
        cWg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cWg() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.kVs.size(); i++) {
            Activity activity = this.kVs.get(i).get();
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
        private static final d kVt = new d((byte) 0);
    }
}
