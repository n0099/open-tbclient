package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static final String f26737b = "f";

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f26738a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f26739c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f26740d;

    public f(BdNet bdNet) {
        this.f26739c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.f26740d = bdNetEngine;
        bdNetEngine.setEventListener(this.f26739c);
    }

    public final boolean a() {
        return this.f26738a != null;
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
            this.f26738a = bdNetTask;
            bdNetTask.setNet(this.f26739c);
            this.f26738a.setWorker(this);
            if (e.a().f26736c == null) {
                e.a().f26736c = this.f26739c.getContext();
            }
            BdNetEngine e2 = e.a().e();
            this.f26740d = e2;
            if (e2 != null) {
                e2.setEventListener(this.f26739c);
                e.a();
                if (!e.b()) {
                    bdNetEngine = this.f26740d;
                    bdNetTask2 = this.f26738a;
                } else if (this.f26738a.isHigherPriority()) {
                    bdNetEngine = this.f26740d;
                    bdNetTask2 = this.f26738a;
                }
                bdNetEngine.startDownload(bdNetTask2);
            } else {
                e.a();
                if (!e.b() || this.f26738a.isHigherPriority()) {
                    BdNetTask bdNetTask3 = this.f26738a;
                    if (bdNetTask3.getTaskPriority$78f3a484() == 0) {
                        a2 = e.a();
                        taskPriority$78f3a484 = BdNetTask.b.f26724b;
                    } else {
                        a2 = e.a();
                        taskPriority$78f3a484 = bdNetTask3.getTaskPriority$78f3a484();
                    }
                    a2.a(bdNetTask3, taskPriority$78f3a484 - 1);
                }
            }
            return true;
        } catch (Exception unused) {
            BdNetEngine bdNetEngine2 = this.f26740d;
            if (bdNetEngine2 != null) {
                bdNetEngine2.recycle();
            }
            BdNet bdNet = this.f26739c;
            if (bdNet != null) {
                bdNet.startError(bdNetTask);
            }
            return false;
        }
    }

    public final void b() {
        try {
            if (this.f26738a != null) {
                this.f26738a.setWorker(null);
                this.f26738a.stop();
                this.f26738a = null;
            }
        } catch (Exception e2) {
            Log.d(f26737b, "stop Exception", e2);
        }
    }
}
