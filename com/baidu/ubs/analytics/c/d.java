package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> kVn;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.kVn = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cWd() {
        return this.kVn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.kVn.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.kVn != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kVn.size()) {
                    break;
                }
                if (this.kVn.get(i2).get() == activity) {
                    this.kVn.remove(this.kVn.get(i2));
                }
                i = i2 + 1;
            }
        }
        cWe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cWe() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.kVn.size(); i++) {
            Activity activity = this.kVn.get(i).get();
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
        private static final d kVo = new d((byte) 0);
    }
}
