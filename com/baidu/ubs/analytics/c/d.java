package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jwU;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jwU = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> csv() {
        return this.jwU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jwU.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jwU != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jwU.size()) {
                    break;
                }
                if (this.jwU.get(i2).get() == activity) {
                    this.jwU.remove(this.jwU.get(i2));
                }
                i = i2 + 1;
            }
        }
        csw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String csw() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jwU.size(); i++) {
            Activity activity = this.jwU.get(i).get();
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
        private static final d jwV = new d((byte) 0);
    }
}
