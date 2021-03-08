package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes14.dex */
public class f {
    private static final String b = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    BdNetTask f3869a;
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
        return this.f3869a != null;
    }

    public final boolean a(BdNetTask bdNetTask) {
        if (bdNetTask == null) {
            return false;
        }
        try {
            this.f3869a = bdNetTask;
            this.f3869a.setNet(this.c);
            this.f3869a.setWorker(this);
            if (e.a().c == null) {
                e.a().c = this.c.getContext();
            }
            this.d = e.a().e();
            if (this.d != null) {
                this.d.setEventListener(this.c);
                e.a();
                if (!e.b()) {
                    this.d.startDownload(this.f3869a);
                } else if (this.f3869a.isHigherPriority()) {
                    this.d.startDownload(this.f3869a);
                }
            } else {
                e.a();
                if (!e.b() || this.f3869a.isHigherPriority()) {
                    BdNetTask bdNetTask2 = this.f3869a;
                    if (bdNetTask2.getTaskPriority$78f3a484() == 0) {
                        e.a().a(bdNetTask2, BdNetTask.b.b - 1);
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
            if (this.f3869a != null) {
                this.f3869a.setWorker(null);
                this.f3869a.stop();
                this.f3869a = null;
            }
        } catch (Exception e) {
            Log.d(b, "stop Exception", e);
        }
    }
}
