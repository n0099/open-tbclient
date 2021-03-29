package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static final String f27052b = "f";

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f27053a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f27054c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f27055d;

    public f(BdNet bdNet) {
        this.f27054c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.f27055d = bdNetEngine;
        bdNetEngine.setEventListener(this.f27054c);
    }

    public final boolean a() {
        return this.f27053a != null;
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
            this.f27053a = bdNetTask;
            bdNetTask.setNet(this.f27054c);
            this.f27053a.setWorker(this);
            if (e.a().f27051c == null) {
                e.a().f27051c = this.f27054c.getContext();
            }
            BdNetEngine e2 = e.a().e();
            this.f27055d = e2;
            if (e2 != null) {
                e2.setEventListener(this.f27054c);
                e.a();
                if (!e.b()) {
                    bdNetEngine = this.f27055d;
                    bdNetTask2 = this.f27053a;
                } else if (this.f27053a.isHigherPriority()) {
                    bdNetEngine = this.f27055d;
                    bdNetTask2 = this.f27053a;
                }
                bdNetEngine.startDownload(bdNetTask2);
            } else {
                e.a();
                if (!e.b() || this.f27053a.isHigherPriority()) {
                    BdNetTask bdNetTask3 = this.f27053a;
                    if (bdNetTask3.getTaskPriority$78f3a484() == 0) {
                        a2 = e.a();
                        taskPriority$78f3a484 = BdNetTask.b.f27039b;
                    } else {
                        a2 = e.a();
                        taskPriority$78f3a484 = bdNetTask3.getTaskPriority$78f3a484();
                    }
                    a2.a(bdNetTask3, taskPriority$78f3a484 - 1);
                }
            }
            return true;
        } catch (Exception unused) {
            BdNetEngine bdNetEngine2 = this.f27055d;
            if (bdNetEngine2 != null) {
                bdNetEngine2.recycle();
            }
            BdNet bdNet = this.f27054c;
            if (bdNet != null) {
                bdNet.startError(bdNetTask);
            }
            return false;
        }
    }

    public final void b() {
        try {
            if (this.f27053a != null) {
                this.f27053a.setWorker(null);
                this.f27053a.stop();
                this.f27053a = null;
            }
        } catch (Exception e2) {
            Log.d(f27052b, "stop Exception", e2);
        }
    }
}
