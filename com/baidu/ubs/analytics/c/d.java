package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jXK;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jXK = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cDL() {
        return this.jXK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jXK.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jXK != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jXK.size()) {
                    break;
                }
                if (this.jXK.get(i2).get() == activity) {
                    this.jXK.remove(this.jXK.get(i2));
                }
                i = i2 + 1;
            }
        }
        cDM();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cDM() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jXK.size(); i++) {
            Activity activity = this.jXK.get(i).get();
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
        private static final d jXL = new d((byte) 0);
    }
}
