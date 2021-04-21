package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static final String f26745b = "f";

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f26746a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f26747c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f26748d;

    public f(BdNet bdNet) {
        this.f26747c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.f26748d = bdNetEngine;
        bdNetEngine.setEventListener(this.f26747c);
    }

    public final boolean a() {
        return this.f26746a != null;
    }

    public final boolean a(BdNetTask bdNetTask) {
        e a2;
        int taskPriority$78f3a484;
        BdNetEngine bdNetEngine;
        BdNetTask bdNetTask2;
        if (bdNetTask == null) {
            return false;
        }
        try {
            this.f26746a = bdNetTask;
            bdNetTask.setNet(this.f26747c);
            this.f26746a.setWorker(this);
            if (e.a().f26744c == null) {
                e.a().f26744c = this.f26747c.getContext();
            }
            BdNetEngine e2 = e.a().e();
            this.f26748d = e2;
            if (e2 != null) {
                e2.setEventListener(this.f26747c);
                e.a();
                if (!e.b()) {
                    bdNetEngine = this.f26748d;
                    bdNetTask2 = this.f26746a;
                } else if (this.f26746a.isHigherPriority()) {
                    bdNetEngine = this.f26748d;
                    bdNetTask2 = this.f26746a;
                }
                bdNetEngine.startDownload(bdNetTask2);
            } else {
                e.a();
                if (!e.b() || this.f26746a.isHigherPriority()) {
                    BdNetTask bdNetTask3 = this.f26746a;
                    if (bdNetTask3.getTaskPriority$78f3a484() == 0) {
                        a2 = e.a();
                        taskPriority$78f3a484 = BdNetTask.b.f26732b;
                    } else {
                        a2 = e.a();
                        taskPriority$78f3a484 = bdNetTask3.getTaskPriority$78f3a484();
                    }
                    a2.a(bdNetTask3, taskPriority$78f3a484 - 1);
                }
            }
            return true;
        } catch (Exception unused) {
            BdNetEngine bdNetEngine2 = this.f26748d;
            if (bdNetEngine2 != null) {
                bdNetEngine2.recycle();
            }
            BdNet bdNet = this.f26747c;
            if (bdNet != null) {
                bdNet.startError(bdNetTask);
            }
            return false;
        }
    }

    public final void b() {
        try {
            if (this.f26746a != null) {
                this.f26746a.setWorker(null);
                this.f26746a.stop();
                this.f26746a = null;
            }
        } catch (Exception e2) {
            Log.d(f26745b, "stop Exception", e2);
        }
    }
}
