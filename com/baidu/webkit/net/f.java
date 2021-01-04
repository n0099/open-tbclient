package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final String f6029b = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    BdNetTask f6030a;
    private BdNet c;
    private BdNetEngine d;

    public f(BdNet bdNet) {
        this.c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.d = bdNetEngine;
        this.d.setEventListener(this.c);
    }

    public final boolean a() {
        return this.f6030a != null;
    }

    public final boolean a(BdNetTask bdNetTask) {
        if (bdNetTask == null) {
            return false;
        }
        try {
            this.f6030a = bdNetTask;
            this.f6030a.setNet(this.c);
            this.f6030a.setWorker(this);
            if (e.a().c == null) {
                e.a().c = this.c.getContext();
            }
            this.d = e.a().e();
            if (this.d != null) {
                this.d.setEventListener(this.c);
                e.a();
                if (!e.b()) {
                    this.d.startDownload(this.f6030a);
                } else if (this.f6030a.isHigherPriority()) {
                    this.d.startDownload(this.f6030a);
                }
            } else {
                e.a();
                if (!e.b() || this.f6030a.isHigherPriority()) {
                    BdNetTask bdNetTask2 = this.f6030a;
                    if (bdNetTask2.getTaskPriority$78f3a484() == 0) {
                        e.a().a(bdNetTask2, BdNetTask.b.f6024b - 1);
                    } else {
                        e.a().a(bdNetTask2, bdNetTask2.getTaskPriority$78f3a484() - 1);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            if (this.d != null) {
                this.d.recycle();
            }
            if (this.c != null) {
                this.c.startError(bdNetTask);
                return false;
            }
            return false;
        }
    }

    public final void b() {
        try {
            if (this.f6030a != null) {
                this.f6030a.setWorker(null);
                this.f6030a.stop();
                this.f6030a = null;
            }
        } catch (Exception e) {
            Log.d(f6029b, "stop Exception", e);
        }
    }
}
