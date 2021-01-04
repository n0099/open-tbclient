package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes6.dex */
public final class d {
    private Stack<WeakReference<Activity>> oOp;

    /* synthetic */ d(byte b2) {
        this();
    }

    private d() {
        this.oOp = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> ejC() {
        return this.oOp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.oOp.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.oOp != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oOp.size()) {
                    break;
                }
                if (this.oOp.get(i2).get() == activity) {
                    this.oOp.remove(this.oOp.get(i2));
                }
                i = i2 + 1;
            }
        }
        afN();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String afN() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.oOp.size(); i++) {
            Activity activity = this.oOp.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static final d oOq = new d((byte) 0);
    }
}
