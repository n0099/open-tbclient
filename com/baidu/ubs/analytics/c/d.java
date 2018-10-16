package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> hTO;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.hTO = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bQk() {
        return this.hTO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.hTO.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.hTO != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hTO.size()) {
                    break;
                }
                if (this.hTO.get(i2).get() == activity) {
                    this.hTO.remove(this.hTO.get(i2));
                }
                i = i2 + 1;
            }
        }
        bQl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bQl() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.hTO.size(); i++) {
            Activity activity = this.hTO.get(i).get();
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
        private static final d hTP = new d((byte) 0);
    }
}
