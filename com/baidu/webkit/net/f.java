package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static final String f27556b = "f";

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f27557a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f27558c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f27559d;

    public f(BdNet bdNet) {
        this.f27558c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.f27559d = bdNetEngine;
        bdNetEngine.setEventListener(this.f27558c);
    }

    public final boolean a() {
        return this.f27557a != null;
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
            this.f27557a = bdNetTask;
            bdNetTask.setNet(this.f27558c);
            this.f27557a.setWorker(this);
            if (e.a().f27555c == null) {
                e.a().f27555c = this.f27558c.getContext();
            }
            BdNetEngine e2 = e.a().e();
            this.f27559d = e2;
            if (e2 != null) {
                e2.setEventListener(this.f27558c);
                e.a();
                if (!e.b()) {
                    bdNetEngine = this.f27559d;
                    bdNetTask2 = this.f27557a;
                } else if (this.f27557a.isHigherPriority()) {
                    bdNetEngine = this.f27559d;
                    bdNetTask2 = this.f27557a;
                }
                bdNetEngine.startDownload(bdNetTask2);
            } else {
                e.a();
                if (!e.b() || this.f27557a.isHigherPriority()) {
                    BdNetTask bdNetTask3 = this.f27557a;
                    if (bdNetTask3.getTaskPriority$78f3a484() == 0) {
                        a2 = e.a();
                        taskPriority$78f3a484 = BdNetTask.b.f27543b;
                    } else {
                        a2 = e.a();
                        taskPriority$78f3a484 = bdNetTask3.getTaskPriority$78f3a484();
                    }
                    a2.a(bdNetTask3, taskPriority$78f3a484 - 1);
                }
            }
            return true;
        } catch (Exception unused) {
            BdNetEngine bdNetEngine2 = this.f27559d;
            if (bdNetEngine2 != null) {
                bdNetEngine2.recycle();
            }
            BdNet bdNet = this.f27558c;
            if (bdNet != null) {
                bdNet.startError(bdNetTask);
            }
            return false;
        }
    }

    public final void b() {
        try {
            if (this.f27557a != null) {
                this.f27557a.setWorker(null);
                this.f27557a.stop();
                this.f27557a = null;
            }
        } catch (Exception e2) {
            Log.d(f27556b, "stop Exception", e2);
        }
    }
}
