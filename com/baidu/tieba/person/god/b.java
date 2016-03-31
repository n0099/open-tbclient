package com.baidu.tieba.person.god;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tieba.card.a.t;
import com.baidu.tieba.card.a.u;
import com.baidu.tieba.card.a.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class b {
    public static com.baidu.tieba.card.a.c b(as asVar, boolean z) {
        if (u.b(asVar)) {
            return null;
        }
        if (v.b(asVar)) {
            v vVar = new v(asVar);
            vVar.aWe = true;
            vVar.aWr = z;
            return vVar;
        } else if (t.b(asVar)) {
            t tVar = new t();
            tVar.aVJ = asVar;
            tVar.aWe = true;
            tVar.auT = z;
            return tVar;
        } else {
            return null;
        }
    }

    public static List<com.baidu.tieba.card.a.c> a(List<ThreadInfo> list, MetaData metaData, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                as asVar = new as();
                asVar.a(threadInfo);
                if (metaData != null && (asVar.getAuthor() == null || TextUtils.isEmpty(asVar.getAuthor().getUserId()))) {
                    asVar.setAuthor(metaData);
                }
                com.baidu.tieba.card.a.c b = b(asVar, z);
                if (b != null && b.isValid()) {
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }
}
