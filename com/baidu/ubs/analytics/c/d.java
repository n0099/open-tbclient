package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> ihd;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.ihd = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bTm() {
        return this.ihd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.ihd.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.ihd != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ihd.size()) {
                    break;
                }
                if (this.ihd.get(i2).get() == activity) {
                    this.ihd.remove(this.ihd.get(i2));
                }
                i = i2 + 1;
            }
        }
        bTn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bTn() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.ihd.size(); i++) {
            Activity activity = this.ihd.get(i).get();
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
        private static final d ihe = new d((byte) 0);
    }
}
