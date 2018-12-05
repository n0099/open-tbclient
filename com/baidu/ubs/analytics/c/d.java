package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> icJ;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.icJ = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bRO() {
        return this.icJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.icJ.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.icJ != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.icJ.size()) {
                    break;
                }
                if (this.icJ.get(i2).get() == activity) {
                    this.icJ.remove(this.icJ.get(i2));
                }
                i = i2 + 1;
            }
        }
        bRP();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bRP() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.icJ.size(); i++) {
            Activity activity = this.icJ.get(i).get();
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
        private static final d icK = new d((byte) 0);
    }
}
