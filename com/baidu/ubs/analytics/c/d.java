package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes2.dex */
public final class d {
    private Stack<WeakReference<Activity>> hCA;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hCA = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bJd() {
        return this.hCA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.hCA.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.hCA != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hCA.size()) {
                    break;
                }
                if (this.hCA.get(i2).get() == activity) {
                    this.hCA.remove(this.hCA.get(i2));
                }
                i = i2 + 1;
            }
        }
        bJe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bJe() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hCA.size(); i++) {
            Activity activity = this.hCA.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        private static final d hCB = new d((byte) 0);
    }
}
