package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes17.dex */
public final class d {
    private Stack<WeakReference<Activity>> osV;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.osV = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> edE() {
        return this.osV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.osV.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.osV != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.osV.size()) {
                    break;
                }
                if (this.osV.get(i2).get() == activity) {
                    this.osV.remove(this.osV.get(i2));
                }
                i = i2 + 1;
            }
        }
        aaK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String aaK() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.osV.size(); i++) {
            Activity activity = this.osV.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a {
        private static final d osW = new d((byte) 0);
    }
}
