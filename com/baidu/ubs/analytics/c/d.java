package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes17.dex */
public final class d {
    private Stack<WeakReference<Activity>> oIe;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.oIe = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> ejs() {
        return this.oIe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.oIe.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.oIe != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oIe.size()) {
                    break;
                }
                if (this.oIe.get(i2).get() == activity) {
                    this.oIe.remove(this.oIe.get(i2));
                }
                i = i2 + 1;
            }
        }
        adS();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String adS() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.oIe.size(); i++) {
            Activity activity = this.oIe.get(i).get();
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
        private static final d oIf = new d((byte) 0);
    }
}
