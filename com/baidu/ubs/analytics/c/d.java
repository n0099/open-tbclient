package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> jPB;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.jPB = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> cAq() {
        return this.jPB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.jPB.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.jPB != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jPB.size()) {
                    break;
                }
                if (this.jPB.get(i2).get() == activity) {
                    this.jPB.remove(this.jPB.get(i2));
                }
                i = i2 + 1;
            }
        }
        cAr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String cAr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.jPB.size(); i++) {
            Activity activity = this.jPB.get(i).get();
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
        private static final d jPC = new d((byte) 0);
    }
}
