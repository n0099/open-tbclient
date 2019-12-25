package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes9.dex */
public class f {
    private static final String b = f.class.getSimpleName();
    BdNetTask a;
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
        return this.a != null;
    }

    public final boolean a(BdNetTask bdNetTask) {
        if (bdNetTask == null) {
            return false;
        }
        try {
            this.a = bdNetTask;
            this.a.setNet(this.c);
            this.a.setWorker(this);
            if (e.a().c == null) {
                e.a().c = this.c.getContext();
            }
            this.d = e.a().e();
            if (this.d != null) {
                this.d.setEventListener(this.c);
                e.a();
                if (!e.b()) {
                    this.d.startDownload(this.a);
                } else if (this.a.isHigherPriority()) {
                    this.d.startDownload(this.a);
                }
            } else {
                e.a();
                if (!e.b() || this.a.isHigherPriority()) {
                    BdNetTask bdNetTask2 = this.a;
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
            if (this.a != null) {
                this.a.setWorker(null);
                this.a.stop();
                this.a = null;
            }
        } catch (Exception e) {
            Log.d(b, "stop Exception", e);
        }
    }
}
