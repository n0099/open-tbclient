package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes7.dex */
public class b {
    public static final String b = "b";
    public BdNetTask a;
    public BdNet c;
    public BdNetEngine d;

    public b(BdNet bdNet) {
        this.c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.d = bdNetEngine;
        bdNetEngine.setEventListener(this.c);
    }

    public final boolean a() {
        return this.a != null;
    }

    public final boolean a(BdNetTask bdNetTask) {
        a a;
        int ordinal;
        BdNetEngine bdNetEngine;
        BdNetTask bdNetTask2;
        if (bdNetTask == null) {
            return false;
        }
        try {
            this.a = bdNetTask;
            bdNetTask.setNet(this.c);
            this.a.setWorker(this);
            if (a.a().c == null) {
                a.a().c = this.c.getContext();
            }
            BdNetEngine e = a.a().e();
            this.d = e;
            if (e != null) {
                e.setEventListener(this.c);
                a.a();
                if (!a.b()) {
                    bdNetEngine = this.d;
                    bdNetTask2 = this.a;
                } else if (!this.a.isHigherPriority()) {
                    return true;
                } else {
                    bdNetEngine = this.d;
                    bdNetTask2 = this.a;
                }
                bdNetEngine.startDownload(bdNetTask2);
                return true;
            }
            a.a();
            if (!a.b() || this.a.isHigherPriority()) {
                BdNetTask bdNetTask3 = this.a;
                if (bdNetTask3.getTaskPriority() == null) {
                    a = a.a();
                    ordinal = BdNetTask.b.PRIORITY_NORMAL.ordinal();
                } else {
                    a = a.a();
                    ordinal = bdNetTask3.getTaskPriority().ordinal();
                }
                a.a(bdNetTask3, ordinal);
                return true;
            }
            return true;
        } catch (Exception unused) {
            BdNetEngine bdNetEngine2 = this.d;
            if (bdNetEngine2 != null) {
                bdNetEngine2.recycle();
            }
            BdNet bdNet = this.c;
            if (bdNet != null) {
                bdNet.startError(bdNetTask);
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
