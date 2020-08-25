package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes5.dex */
public final class d {
    private Stack<WeakReference<Activity>> nfW;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.nfW = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dMn() {
        return this.nfW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.nfW.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.nfW != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.nfW.size()) {
                    break;
                }
                if (this.nfW.get(i2).get() == activity) {
                    this.nfW.remove(this.nfW.get(i2));
                }
                i = i2 + 1;
            }
        }
        Uu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String Uu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.nfW.size(); i++) {
            Activity activity = this.nfW.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private static final d nfX = new d((byte) 0);
    }
}
