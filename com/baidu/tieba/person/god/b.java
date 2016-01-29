package com.baidu.tieba.person.god;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tieba.card.a.q;
import com.baidu.tieba.card.a.r;
import com.baidu.tieba.card.a.s;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class b {
    public static com.baidu.tieba.card.a.c b(ah ahVar, boolean z) {
        if (r.b(ahVar)) {
            return null;
        }
        if (s.b(ahVar)) {
            s sVar = new s(ahVar);
            sVar.aSt = true;
            sVar.aSF = z;
            return sVar;
        } else if (q.b(ahVar)) {
            q qVar = new q();
            qVar.aSc = ahVar;
            qVar.aSt = true;
            qVar.aut = z;
            return qVar;
        } else {
            return null;
        }
    }

    public static List<com.baidu.tieba.card.a.c> a(List<ThreadInfo> list, MetaData metaData, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                ah ahVar = new ah();
                ahVar.a(threadInfo);
                if (metaData != null && (ahVar.getAuthor() == null || TextUtils.isEmpty(ahVar.getAuthor().getUserId()))) {
                    ahVar.setAuthor(metaData);
                }
                com.baidu.tieba.card.a.c b = b(ahVar, z);
                if (b != null && b.isValid()) {
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }
}
