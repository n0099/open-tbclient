package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes17.dex */
public final class d {
    private Stack<WeakReference<Activity>> oIg;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.oIg = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> ejt() {
        return this.oIg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.oIg.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.oIg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oIg.size()) {
                    break;
                }
                if (this.oIg.get(i2).get() == activity) {
                    this.oIg.remove(this.oIg.get(i2));
                }
                i = i2 + 1;
            }
        }
        adS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String adS() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.oIg.size(); i++) {
            Activity activity = this.oIg.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a {
        private static final d oIh = new d((byte) 0);
    }
}
