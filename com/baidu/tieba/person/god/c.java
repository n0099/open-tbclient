package com.baidu.tieba.person.god;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.card.a.n;
import com.baidu.tieba.card.a.o;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class c {
    public static com.baidu.tieba.card.a.c b(az azVar, boolean z) {
        if (n.c(azVar)) {
            return null;
        }
        if (o.c(azVar)) {
            o oVar = new o(azVar);
            oVar.aVu = true;
            oVar.aVG = z;
            return oVar;
        } else if (com.baidu.tieba.card.a.f.c(azVar)) {
            return new com.baidu.tieba.card.a.f(azVar);
        } else {
            if (m.c(azVar)) {
                m mVar = new m();
                mVar.threadData = azVar;
                mVar.aVu = true;
                mVar.arI = z;
                return mVar;
            }
            return null;
        }
    }

    public static List<com.baidu.tieba.card.a.c> a(List<ThreadInfo> list, MetaData metaData, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null) {
                az azVar = new az();
                azVar.a(threadInfo);
                if (metaData != null && (azVar.getAuthor() == null || TextUtils.isEmpty(azVar.getAuthor().getUserId()))) {
                    azVar.setAuthor(metaData);
                }
                com.baidu.tieba.card.a.c b = b(azVar, z);
                if (b != null && b.isValid()) {
                    arrayList.add(b);
                }
            }
        }
        return arrayList;
    }
}
