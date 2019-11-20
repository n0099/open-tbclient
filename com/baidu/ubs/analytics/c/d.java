package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jXp;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jXp = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cBi() {
        return this.jXp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jXp.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jXp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jXp.size()) {
                    break;
                }
                if (this.jXp.get(i2).get() == activity) {
                    this.jXp.remove(this.jXp.get(i2));
                }
                i = i2 + 1;
            }
        }
        cBj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cBj() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jXp.size(); i++) {
            Activity activity = this.jXp.get(i).get();
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
        private static final d jXq = new d((byte) 0);
    }
}
