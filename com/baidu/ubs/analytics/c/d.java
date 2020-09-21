package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes7.dex */
public final class d {
    private Stack<WeakReference<Activity>> nqq;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.nqq = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dQu() {
        return this.nqq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.nqq.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.nqq != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nqq.size()) {
                    break;
                }
                if (this.nqq.get(i2).get() == activity) {
                    this.nqq.remove(this.nqq.get(i2));
                }
                i = i2 + 1;
            }
        }
        Vd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String Vd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.nqq.size(); i++) {
            Activity activity = this.nqq.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private static final d nqr = new d((byte) 0);
    }
}
