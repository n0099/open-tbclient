package com.bytedance.embedapplog;

import com.tencent.connect.common.Constants;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class cg {

    /* renamed from: a  reason: collision with root package name */
    private static final LinkedList<ac> f5821a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    private static final LinkedList<ac> f5822b = new LinkedList<>();

    public static void a(ac acVar) {
        synchronized (f5821a) {
            if (f5821a.size() > 200) {
                au.b("drop event in cache", null);
                f5822b.add(f5821a.poll());
            }
            f5821a.add(acVar);
        }
    }

    public static void a() {
        ak akVar;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        synchronized (f5821a) {
            linkedList.addAll(f5821a);
            linkedList2.addAll(f5822b);
            f5821a.clear();
            f5822b.clear();
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
