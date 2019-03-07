package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jwJ;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jwJ = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> csi() {
        return this.jwJ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jwJ.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jwJ != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jwJ.size()) {
                    break;
                }
                if (this.jwJ.get(i2).get() == activity) {
                    this.jwJ.remove(this.jwJ.get(i2));
                }
                i = i2 + 1;
            }
        }
        csj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String csj() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jwJ.size(); i++) {
            Activity activity = this.jwJ.get(i).get();
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
        private static final d jwK = new d((byte) 0);
    }
}
