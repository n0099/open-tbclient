package com.baidu.webkit.net;

import com.baidu.webkit.net.BdNetTask;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f26801b = "b";

    /* renamed from: a  reason: collision with root package name */
    public BdNetTask f26802a;

    /* renamed from: c  reason: collision with root package name */
    public BdNet f26803c;

    /* renamed from: d  reason: collision with root package name */
    public BdNetEngine f26804d;

    public b(BdNet bdNet) {
        this.f26803c = bdNet;
    }

    public final void a(BdNetEngine bdNetEngine) {
        this.f26804d = bdNetEngine;
        bdNetEngine.setEventListener(this.f26803c);
    }

    public final boolean a() {
        return this.f26802a != null;
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
            this.f26802a = bdNetTask;
            bdNetTask.setNet(this.f26803c);
            this.f26802a.setWorker(this);
            if (a.a().f26800c == null) {
                a.a().f26800c = this.f26803c.getContext();
            }
            BdNetEngine e2 = a.a().e();
            this.f26804d = e2;
            if (e2 != null) {
                e2.setEventListener(this.f26803c);
                a.a();
                if (!a.b()) {
                    bdNetEngine = this.f26804d;
                    bdNetTask2 = this.f26802a;
                } else if (!this.f26802a.isHigherPriority()) {
                    return true;
                } else {
                    bdNetEngine = this.f26804d;
                    bdNetTask2 = this.f26802a;
                }
                bdNetEngine.startDownload(bdNetTask2);
                return true;
            }
            a.a();
            if (!a.b() || this.f26802a.isHigherPriority()) {
                BdNetTask bdNetTask3 = this.f26802a;
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
            BdNetEngine bdNetEngine2 = this.f26804d;
            if (bdNetEngine2 != null) {
                bdNetEngine2.recycle();
            }
            BdNet bdNet = this.f26803c;
            if (bdNet != null) {
                bdNet.startError(bdNetTask);
            }
            return false;
        }
    }

    public final void b() {
        try {
            if (this.f26802a != null) {
                this.f26802a.setWorker(null);
                this.f26802a.stop();
                this.f26802a = null;
            }
        } catch (Exception e2) {
            Log.d(f26801b, "stop Exception", e2);
        }
    }
}
