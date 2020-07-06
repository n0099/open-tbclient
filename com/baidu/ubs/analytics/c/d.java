package com.baidu.ubs.analytics.c;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes8.dex */
public final class d {
    private Stack<WeakReference<Activity>> mEU;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.mEU = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> dxn() {
        return this.mEU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.mEU.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.mEU != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mEU.size()) {
                    break;
                }
                if (this.mEU.get(i2).get() == activity) {
                    this.mEU.remove(this.mEU.get(i2));
                }
                i = i2 + 1;
            }
        }
        dxo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String dxo() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mEU.size(); i++) {
            Activity activity = this.mEU.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append("->");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private static final d mEV = new d((byte) 0);
    }
}
