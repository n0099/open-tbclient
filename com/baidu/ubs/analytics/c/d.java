package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jwK;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jwK = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cst() {
        return this.jwK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jwK.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jwK != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jwK.size()) {
                    break;
                }
                if (this.jwK.get(i2).get() == activity) {
                    this.jwK.remove(this.jwK.get(i2));
                }
                i = i2 + 1;
            }
        }
        csu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String csu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jwK.size(); i++) {
            Activity activity = this.jwK.get(i).get();
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
        private static final d jwL = new d((byte) 0);
    }
}
