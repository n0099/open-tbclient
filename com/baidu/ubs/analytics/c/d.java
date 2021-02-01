package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes15.dex */
public final class d {
    private Stack<WeakReference<Activity>> oTT;

    /* synthetic */ d(byte b2) {
        this();
    }

    private d() {
        this.oTT = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> eid() {
        return this.oTT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.oTT.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.oTT != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oTT.size()) {
                    break;
                }
                if (this.oTT.get(i2).get() == activity) {
                    this.oTT.remove(this.oTT.get(i2));
                }
                i = i2 + 1;
            }
        }
        adI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String adI() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.oTT.size(); i++) {
            Activity activity = this.oTT.get(i).get();
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
        private static final d oTU = new d((byte) 0);
    }
}
