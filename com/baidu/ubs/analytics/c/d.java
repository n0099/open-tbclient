package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> mER;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.mER = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dxj() {
        return this.mER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.mER.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.mER != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mER.size()) {
                    break;
                }
                if (this.mER.get(i2).get() == activity) {
                    this.mER.remove(this.mER.get(i2));
                }
                i = i2 + 1;
            }
        }
        dxk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String dxk() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mER.size(); i++) {
            Activity activity = this.mER.get(i).get();
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
        private static final d mES = new d((byte) 0);
    }
}
