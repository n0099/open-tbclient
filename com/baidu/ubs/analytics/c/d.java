package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes14.dex */
public final class d {
    private Stack<WeakReference<Activity>> oWy;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.oWy = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> eiu() {
        return this.oWy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.oWy.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.oWy != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oWy.size()) {
                    break;
                }
                if (this.oWy.get(i2).get() == activity) {
                    this.oWy.remove(this.oWy.get(i2));
                }
                i = i2 + 1;
            }
        }
        adL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String adL() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.oWy.size(); i++) {
            Activity activity = this.oWy.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class a {
        private static final d oWz = new d((byte) 0);
    }
}
