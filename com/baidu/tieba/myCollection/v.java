package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
class v extends o {
    final /* synthetic */ s cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.cyx = sVar;
    }

    @Override // com.baidu.tieba.myCollection.o
    public void callback(Object... objArr) {
        x xVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        ArrayList arrayList;
        boolean z;
        ArrayList arrayList2;
        x xVar2;
        x xVar3;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        com.baidu.tieba.myCollection.baseEditMark.a aVar4;
        x xVar4;
        x xVar5;
        x xVar6;
        com.baidu.tieba.myCollection.baseEditMark.a aVar5;
        x xVar7;
        x xVar8;
        com.baidu.tieba.myCollection.baseEditMark.a aVar6;
        com.baidu.tieba.myCollection.baseEditMark.a aVar7;
        ArrayList arrayList3;
        ArrayList arrayList4;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                xVar7 = this.cyx.cyw;
                xVar7.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                xVar8 = this.cyx.cyw;
                aVar6 = this.cyx.cya;
                xVar8.a(r3, aVar6, ((Boolean) objArr[2]).booleanValue());
                s sVar = this.cyx;
                aVar7 = this.cyx.cya;
                sVar.cyd = aVar7.ajt();
                s sVar2 = this.cyx;
                arrayList3 = this.cyx.cyd;
                if (arrayList3 != null) {
                    arrayList4 = this.cyx.cyd;
                    if (!arrayList4.isEmpty()) {
                        r2 = true;
                    }
                }
                sVar2.mIsEnableEdit = r2;
            } else if (((Integer) objArr[0]).intValue() == 3) {
                xVar4 = this.cyx.cyw;
                xVar4.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                xVar5 = this.cyx.cyw;
                xVar5.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                xVar6 = this.cyx.cyw;
                aVar5 = this.cyx.cya;
                xVar6.a(aVar5, false);
                this.cyx.mIsEnableEdit = false;
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r3 = objArr[2] != null ? (String) objArr[2] : null;
                r2 = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                xVar2 = this.cyx.cyw;
                xVar2.a(booleanValue, r3, r2);
                if (booleanValue) {
                    xVar3 = this.cyx.cyw;
                    aVar3 = this.cyx.cya;
                    xVar3.ka(aVar3.getOffset());
                    aVar4 = this.cyx.cya;
                    aVar4.f(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                xVar = this.cyx.cyw;
                aVar = this.cyx.cya;
                xVar.a(booleanValue2, str, aVar);
                s sVar3 = this.cyx;
                aVar2 = this.cyx.cya;
                sVar3.cyd = aVar2.ajt();
                s sVar4 = this.cyx;
                arrayList = this.cyx.cyd;
                if (arrayList != null) {
                    arrayList2 = this.cyx.cyd;
                    if (!arrayList2.isEmpty()) {
                        z = true;
                        sVar4.mIsEnableEdit = z;
                    }
                }
                z = false;
                sVar4.mIsEnableEdit = z;
            }
        } catch (Exception e) {
            e.printStackTrace();
            BdLog.d(e.getMessage());
        }
        this.cyx.sendEditEnableMessage(1);
    }
}
