package com.baidu.tieba.person.god;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.a.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class b {
    public static com.baidu.tieba.card.a.c b(ax axVar, boolean z) {
        if (m.b(axVar)) {
            return null;
        }
        if (n.b(axVar)) {
            n nVar = new n(axVar);
            nVar.aRY = true;
            nVar.aSl = z;
            return nVar;
        } else if (l.b(axVar)) {
            l lVar = new l();
            lVar.aRG = axVar;
            lVar.aRY = true;
            lVar.aqS = z;
            return lVar;
        } else {
            return null;
        }
    }

    public static List<com.baidu.tieba.card.a.c> a(List<ThreadInfo> list, MetaData metaData, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                ax axVar = new ax();
                axVar.a(threadInfo);
                if (metaData != null && (axVar.getAuthor() == null || TextUtils.isEmpty(axVar.getAuthor().getUserId()))) {
                    axVar.setAuthor(metaData);
                }
                com.baidu.tieba.card.a.c b = b(axVar, z);
                if (b != null && b.isValid()) {
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }
}
