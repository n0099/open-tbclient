package com.bytedance.embedapplog;

import com.tencent.connect.common.Constants;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class cg {

    /* renamed from: a  reason: collision with root package name */
    private static final LinkedList<ac> f3928a = new LinkedList<>();
    private static final LinkedList<ac> b = new LinkedList<>();

    public static void a(ac acVar) {
        synchronized (f3928a) {
            if (f3928a.size() > 200) {
                au.b("drop event in cache", null);
                b.add(f3928a.poll());
            }
            f3928a.add(acVar);
        }
    }

    public static void a() {
        ak akVar;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (f3928a) {
            linkedList.addAll(f3928a);
            linkedList2.addAll(b);
            f3928a.clear();
            b.clear();
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
