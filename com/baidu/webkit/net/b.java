package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f26915b = "b";

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f26916a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f26917c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f26918d;

    public b(BdNet bdNet) {
        this.f26917c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.f26918d = bdNetEngine;
        bdNetEngine.setEventListener(this.f26917c);
    }

    public final boolean a() {
        return this.f26916a != null;
    }

    public final boolean a(BdNetTask bdNetTask) {
        a a2;
        int ordinal;
        BdNetEngine bdNetEngine;
        BdNetTask bdNetTask2;
        if (bdNetTask == null) {
            return false;
        }
        try {
            this.f26916a = bdNetTask;
            bdNetTask.setNet(this.f26917c);
            this.f26916a.setWorker(this);
            if (a.a().f26914c == null) {
                a.a().f26914c = this.f26917c.getContext();
            }
            BdNetEngine e2 = a.a().e();
            this.f26918d = e2;
            if (e2 != null) {
                e2.setEventListener(this.f26917c);
                a.a();
                if (!a.b()) {
                    bdNetEngine = this.f26918d;
                    bdNetTask2 = this.f26916a;
                } else if (!this.f26916a.isHigherPriority()) {
                    return true;
                } else {
                    bdNetEngine = this.f26918d;
                    bdNetTask2 = this.f26916a;
                }
                bdNetEngine.startDownload(bdNetTask2);
                return true;
            }
            a.a();
            if (!a.b() || this.f26916a.isHigherPriority()) {
                BdNetTask bdNetTask3 = this.f26916a;
                if (bdNetTask3.getTaskPriority() == null) {
                    a2 = a.a();
                    ordinal = BdNetTask.b.PRIORITY_NORMAL.ordinal();
                } else {
                    a2 = a.a();
                    ordinal = bdNetTask3.getTaskPriority().ordinal();
                }
                a2.a(bdNetTask3, ordinal);
                return true;
            }
            return true;
        } catch (Exception unused) {
            BdNetEngine bdNetEngine2 = this.f26918d;
            if (bdNetEngine2 != null) {
                bdNetEngine2.recycle();
            }
            BdNet bdNet = this.f26917c;
            if (bdNet != null) {
                bdNet.startError(bdNetTask);
            }
            return false;
        }
    }

    public final void b() {
        try {
            if (this.f26916a != null) {
                this.f26916a.setWorker(null);
                this.f26916a.stop();
                this.f26916a = null;
            }
        } catch (Exception e2) {
            Log.d(f26915b, "stop Exception", e2);
        }
    }
}
