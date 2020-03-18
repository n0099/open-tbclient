package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> kXP;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.kXP = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cXU() {
        return this.kXP;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.kXP.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.kXP != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kXP.size()) {
                    break;
                }
                if (this.kXP.get(i2).get() == activity) {
                    this.kXP.remove(this.kXP.get(i2));
                }
                i = i2 + 1;
            }
        }
        cXV();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cXV() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.kXP.size(); i++) {
            Activity activity = this.kXP.get(i).get();
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
        private static final d kXQ = new d((byte) 0);
    }
}
