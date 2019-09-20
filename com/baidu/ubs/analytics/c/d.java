package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> kah;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.kah = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cEz() {
        return this.kah;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.kah.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.kah != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kah.size()) {
                    break;
                }
                if (this.kah.get(i2).get() == activity) {
                    this.kah.remove(this.kah.get(i2));
                }
                i = i2 + 1;
            }
        }
        cEA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cEA() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.kah.size(); i++) {
            Activity activity = this.kah.get(i).get();
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
        private static final d kai = new d((byte) 0);
    }
}
