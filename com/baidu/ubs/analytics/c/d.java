package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> ifW;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.ifW = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> bSE() {
        return this.ifW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.ifW.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.ifW != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ifW.size()) {
                    break;
                }
                if (this.ifW.get(i2).get() == activity) {
                    this.ifW.remove(this.ifW.get(i2));
                }
                i = i2 + 1;
            }
        }
        bSF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String bSF() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.ifW.size(); i++) {
            Activity activity = this.ifW.get(i).get();
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
        private static final d ifX = new d((byte) 0);
    }
}
