package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static final String f27051b = "f";

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f27052a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f27053c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f27054d;

    public f(BdNet bdNet) {
        this.f27053c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.f27054d = bdNetEngine;
        bdNetEngine.setEventListener(this.f27053c);
    }

    public final boolean a() {
        return this.f27052a != null;
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
            this.f27052a = bdNetTask;
            bdNetTask.setNet(this.f27053c);
            this.f27052a.setWorker(this);
            if (e.a().f27050c == null) {
                e.a().f27050c = this.f27053c.getContext();
            }
            BdNetEngine e2 = e.a().e();
            this.f27054d = e2;
            if (e2 != null) {
                e2.setEventListener(this.f27053c);
                e.a();
                if (!e.b()) {
                    bdNetEngine = this.f27054d;
                    bdNetTask2 = this.f27052a;
                } else if (this.f27052a.isHigherPriority()) {
                    bdNetEngine = this.f27054d;
                    bdNetTask2 = this.f27052a;
                }
                bdNetEngine.startDownload(bdNetTask2);
            } else {
                e.a();
                if (!e.b() || this.f27052a.isHigherPriority()) {
                    BdNetTask bdNetTask3 = this.f27052a;
                    if (bdNetTask3.getTaskPriority$78f3a484() == 0) {
                        a2 = e.a();
                        taskPriority$78f3a484 = BdNetTask.b.f27038b;
                    } else {
                        a2 = e.a();
                        taskPriority$78f3a484 = bdNetTask3.getTaskPriority$78f3a484();
                    }
                    a2.a(bdNetTask3, taskPriority$78f3a484 - 1);
                }
            }
            return true;
        } catch (Exception unused) {
            BdNetEngine bdNetEngine2 = this.f27054d;
            if (bdNetEngine2 != null) {
                bdNetEngine2.recycle();
            }
            BdNet bdNet = this.f27053c;
            if (bdNet != null) {
                bdNet.startError(bdNetTask);
            }
            return false;
        }
    }

    public final void b() {
        try {
            if (this.f27052a != null) {
                this.f27052a.setWorker(null);
                this.f27052a.stop();
                this.f27052a = null;
            }
        } catch (Exception e2) {
            Log.d(f27051b, "stop Exception", e2);
        }
    }
}
