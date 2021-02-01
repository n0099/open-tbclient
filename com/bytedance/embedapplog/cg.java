package com.bytedance.embedapplog;

import com.tencent.connect.common.Constants;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class cg {

    /* renamed from: a  reason: collision with root package name */
    private static final LinkedList<ac> f5823a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private static final LinkedList<ac> f5824b = new LinkedList<>();

    public static void a(ac acVar) {
        synchronized (f5823a) {
            if (f5823a.size() > 200) {
                au.b("drop event in cache", null);
                f5824b.add(f5823a.poll());
            }
            f5823a.add(acVar);
        }
    }

    public static void a() {
        ak akVar;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (f5823a) {
            linkedList.addAll(f5823a);
            linkedList2.addAll(f5824b);
            f5823a.clear();
            f5824b.clear();
        }
        while (!linkedList.isEmpty()) {
            bx.a((ac) linkedList.poll());
        }
        while (!linkedList2.isEmpty()) {
            ac acVar = (ac) linkedList2.poll();
            if (acVar instanceof ak) {
                akVar = (ak) acVar;
            } else if (acVar instanceof ae) {
                ae aeVar = (ae) acVar;
                akVar = new ak("" + aeVar.i() + aeVar.j(), Constants.VIA_REPORT_TYPE_START_WAP, 1);
            } else if (!(acVar instanceof ag)) {
                akVar = null;
            } else {
                akVar = new ak(((ag) acVar).j(), Constants.VIA_REPORT_TYPE_START_WAP, 1);
            }
            bx.a(akVar);
        }
    }
}
