package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes.dex */
public final class d {
    private Stack<WeakReference<Activity>> hlR;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hlR = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bEQ() {
        return this.hlR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.hlR.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.hlR != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hlR.size()) {
                    break;
                }
                if (this.hlR.get(i2).get() == activity) {
                    this.hlR.remove(this.hlR.get(i2));
                }
                i = i2 + 1;
            }
        }
        bER();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bER() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hlR.size(); i++) {
            Activity activity = this.hlR.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private static final d hlS = new d((byte) 0);
    }
}
