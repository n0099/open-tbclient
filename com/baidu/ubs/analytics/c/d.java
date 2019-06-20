package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jPF;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jPF = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cAr() {
        return this.jPF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jPF.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jPF != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jPF.size()) {
                    break;
                }
                if (this.jPF.get(i2).get() == activity) {
                    this.jPF.remove(this.jPF.get(i2));
                }
                i = i2 + 1;
            }
        }
        cAs();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cAs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jPF.size(); i++) {
            Activity activity = this.jPF.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private static final d jPG = new d((byte) 0);
    }
}
