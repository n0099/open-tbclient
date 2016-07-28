package com.baidu.tieba.person.god;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.a.n;
import com.baidu.tieba.card.a.o;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class c {
    public static com.baidu.tieba.card.a.c b(be beVar, boolean z) {
        if (n.c(beVar)) {
            return null;
        }
        if (o.c(beVar)) {
            o oVar = new o(beVar);
            oVar.aWs = true;
            oVar.aWE = z;
            return oVar;
        } else if (com.baidu.tieba.card.a.f.c(beVar)) {
            return new com.baidu.tieba.card.a.f(beVar);
        } else {
            if (m.c(beVar)) {
                m mVar = new m();
                mVar.threadData = beVar;
                mVar.aWs = true;
                mVar.asx = z;
                return mVar;
            }
            return null;
        }
    }

    public static List<com.baidu.tieba.card.a.c> a(List<ThreadInfo> list, MetaData metaData, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                be beVar = new be();
                beVar.a(threadInfo);
                if (metaData != null && (beVar.getAuthor() == null || TextUtils.isEmpty(beVar.getAuthor().getUserId()))) {
                    beVar.setAuthor(metaData);
                }
                com.baidu.tieba.card.a.c b = b(beVar, z);
                if (b != null && b.isValid()) {
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }
}
