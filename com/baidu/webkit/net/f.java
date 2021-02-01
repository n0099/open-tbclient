package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final String f5732b = f.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    BdNetTask f5733a;
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
        return this.f5733a != null;
    }

    public final boolean a(BdNetTask bdNetTask) {
        if (bdNetTask == null) {
            return false;
        }
        try {
            this.f5733a = bdNetTask;
            this.f5733a.setNet(this.c);
            this.f5733a.setWorker(this);
            if (e.a().c == null) {
                e.a().c = this.c.getContext();
            }
            this.d = e.a().e();
            if (this.d != null) {
                this.d.setEventListener(this.c);
                e.a();
                if (!e.b()) {
                    this.d.startDownload(this.f5733a);
                } else if (this.f5733a.isHigherPriority()) {
                    this.d.startDownload(this.f5733a);
                }
            } else {
                e.a();
                if (!e.b() || this.f5733a.isHigherPriority()) {
                    BdNetTask bdNetTask2 = this.f5733a;
                    if (bdNetTask2.getTaskPriority$78f3a484() == 0) {
                        e.a().a(bdNetTask2, BdNetTask.b.f5727b - 1);
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
            if (this.f5733a != null) {
                this.f5733a.setWorker(null);
                this.f5733a.stop();
                this.f5733a = null;
            }
        } catch (Exception e) {
            Log.d(f5732b, "stop Exception", e);
        }
    }
}
