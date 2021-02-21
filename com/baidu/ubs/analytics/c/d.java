package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes15.dex */
public final class d {
    private Stack<WeakReference<Activity>> oUt;

    /* synthetic */ d(byte b2) {
        this();
    }

    private d() {
        this.oUt = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> eil() {
        return this.oUt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.oUt.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.oUt != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oUt.size()) {
                    break;
                }
                if (this.oUt.get(i2).get() == activity) {
                    this.oUt.remove(this.oUt.get(i2));
                }
                i = i2 + 1;
            }
        }
        adI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String adI() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.oUt.size(); i++) {
            Activity activity = this.oUt.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {
        private static final d oUu = new d((byte) 0);
    }
}
