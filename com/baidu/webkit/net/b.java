package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f26833b = "b";

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f26834a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f26835c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f26836d;

    public b(BdNet bdNet) {
        this.f26835c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.f26836d = bdNetEngine;
        bdNetEngine.setEventListener(this.f26835c);
    }

    public final boolean a() {
        return this.f26834a != null;
    }

    public final boolean a(BdNetTask bdNetTask) {
        a a2;
        int ordinal;
        BdNetEngine bdNetEngine;
        BdNetTask bdNetTask2;
        if (bdNetTask == null) {
            return false;
        }
        try {
            this.f26834a = bdNetTask;
            bdNetTask.setNet(this.f26835c);
            this.f26834a.setWorker(this);
            if (a.a().f26832c == null) {
                a.a().f26832c = this.f26835c.getContext();
            }
            BdNetEngine e2 = a.a().e();
            this.f26836d = e2;
            if (e2 != null) {
                e2.setEventListener(this.f26835c);
                a.a();
                if (!a.b()) {
                    bdNetEngine = this.f26836d;
                    bdNetTask2 = this.f26834a;
                } else if (!this.f26834a.isHigherPriority()) {
                    return true;
                } else {
                    bdNetEngine = this.f26836d;
                    bdNetTask2 = this.f26834a;
                }
                bdNetEngine.startDownload(bdNetTask2);
                return true;
            }
            a.a();
            if (!a.b() || this.f26834a.isHigherPriority()) {
                BdNetTask bdNetTask3 = this.f26834a;
                if (bdNetTask3.getTaskPriority() == null) {
                    a2 = a.a();
                    ordinal = BdNetTask.b.PRIORITY_NORMAL.ordinal();
                } else {
                    a2 = a.a();
                    ordinal = bdNetTask3.getTaskPriority().ordinal();
                }
                a2.a(bdNetTask3, ordinal);
                return true;
            }
            return true;
        } catch (Exception unused) {
            BdNetEngine bdNetEngine2 = this.f26836d;
            if (bdNetEngine2 != null) {
                bdNetEngine2.recycle();
            }
            BdNet bdNet = this.f26835c;
            if (bdNet != null) {
                bdNet.startError(bdNetTask);
            }
            return false;
        }
    }

    public final void b() {
        try {
            if (this.f26834a != null) {
                this.f26834a.setWorker(null);
                this.f26834a.stop();
                this.f26834a = null;
            }
        } catch (Exception e2) {
            Log.d(f26833b, "stop Exception", e2);
        }
    }
}
