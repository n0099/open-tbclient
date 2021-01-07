package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes15.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final String f6030b = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    BdNetTask f6031a;
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
        return this.f6031a != null;
    }

    public final boolean a(BdNetTask bdNetTask) {
        if (bdNetTask == null) {
            return false;
        }
        try {
            this.f6031a = bdNetTask;
            this.f6031a.setNet(this.c);
            this.f6031a.setWorker(this);
            if (e.a().c == null) {
                e.a().c = this.c.getContext();
            }
            this.d = e.a().e();
            if (this.d != null) {
                this.d.setEventListener(this.c);
                e.a();
                if (!e.b()) {
                    this.d.startDownload(this.f6031a);
                } else if (this.f6031a.isHigherPriority()) {
                    this.d.startDownload(this.f6031a);
                }
            } else {
                e.a();
                if (!e.b() || this.f6031a.isHigherPriority()) {
                    BdNetTask bdNetTask2 = this.f6031a;
                    if (bdNetTask2.getTaskPriority$78f3a484() == 0) {
                        e.a().a(bdNetTask2, BdNetTask.b.f6025b - 1);
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
            if (this.f6031a != null) {
                this.f6031a.setWorker(null);
                this.f6031a.stop();
                this.f6031a = null;
            }
        } catch (Exception e) {
            Log.d(f6030b, "stop Exception", e);
        }
    }
}
