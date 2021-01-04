package com.bytedance.embedapplog;

import com.tencent.connect.common.Constants;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class cg {

    /* renamed from: a  reason: collision with root package name */
    private static final LinkedList<ac> f6120a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private static final LinkedList<ac> f6121b = new LinkedList<>();

    public static void a(ac acVar) {
        synchronized (f6120a) {
            if (f6120a.size() > 200) {
                au.b("drop event in cache", null);
                f6121b.add(f6120a.poll());
            }
            f6120a.add(acVar);
        }
    }

    public static void a() {
        ak akVar;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (f6120a) {
            linkedList.addAll(f6120a);
            linkedList2.addAll(f6121b);
            f6120a.clear();
            f6121b.clear();
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
