package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.searchbox.perfframe.basic.PerfFrameTrackUIUtil;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes3.dex */
public final class d {
    private Stack<WeakReference<Activity>> oJK;

    /* synthetic */ d(byte b2) {
        this();
    }

    private d() {
        this.oJK = new Stack<>();
    }

    public final Stack<WeakReference<Activity>> efL() {
        return this.oJK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(WeakReference<Activity> weakReference) {
        this.oJK.add(weakReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Activity activity) {
        if (this.oJK != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.oJK.size()) {
                    break;
                }
                if (this.oJK.get(i2).get() == activity) {
                    this.oJK.remove(this.oJK.get(i2));
                }
                i = i2 + 1;
            }
        }
        abU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String abU() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.oJK.size(); i++) {
            Activity activity = this.oJK.get(i).get();
            if (activity != null) {
                sb.append(activity.getClass().getSimpleName());
                sb.append(PerfFrameTrackUIUtil.SEPERATOR_ARROR);
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private static final d oJL = new d((byte) 0);
    }
}
