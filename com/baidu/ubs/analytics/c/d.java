package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> mMY;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.mMY = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dAz() {
        return this.mMY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.mMY.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.mMY != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mMY.size()) {
                    break;
                }
                if (this.mMY.get(i2).get() == activity) {
                    this.mMY.remove(this.mMY.get(i2));
                }
                i = i2 + 1;
            }
        }
        dAA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String dAA() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mMY.size(); i++) {
            Activity activity = this.mMY.get(i).get();
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
        private static final d mMZ = new d((byte) 0);
    }
}
