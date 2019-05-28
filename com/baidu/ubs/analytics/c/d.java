package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jPC;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jPC = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cAs() {
        return this.jPC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jPC.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jPC != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jPC.size()) {
                    break;
                }
                if (this.jPC.get(i2).get() == activity) {
                    this.jPC.remove(this.jPC.get(i2));
                }
                i = i2 + 1;
            }
        }
        cAt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cAt() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jPC.size(); i++) {
            Activity activity = this.jPC.get(i).get();
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
        private static final d jPD = new d((byte) 0);
    }
}
