package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
class v extends o {
    final /* synthetic */ s cux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.cux = sVar;
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
        x xVar7;
        com.baidu.tieba.myCollection.baseEditMark.a aVar5;
        com.baidu.tieba.myCollection.baseEditMark.a aVar6;
        ArrayList arrayList3;
        ArrayList arrayList4;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                xVar6 = this.cux.cuw;
                xVar6.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                xVar7 = this.cux.cuw;
                aVar5 = this.cux.ctY;
                xVar7.a(r3, aVar5, ((Boolean) objArr[2]).booleanValue());
                s sVar = this.cux;
                aVar6 = this.cux.ctY;
                sVar.cub = aVar6.aig();
                s sVar2 = this.cux;
                arrayList3 = this.cux.cub;
                if (arrayList3 != null) {
                    arrayList4 = this.cux.cub;
                    if (!arrayList4.isEmpty()) {
                        r2 = true;
                    }
                }
                sVar2.mIsEnableEdit = r2;
            } else if (((Integer) objArr[0]).intValue() == 3) {
                xVar4 = this.cux.cuw;
                xVar4.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                xVar5 = this.cux.cuw;
                xVar5.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                this.cux.mIsEnableEdit = false;
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r3 = objArr[2] != null ? (String) objArr[2] : null;
                r2 = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                xVar2 = this.cux.cuw;
                xVar2.a(booleanValue, r3, r2);
                if (booleanValue) {
                    xVar3 = this.cux.cuw;
                    aVar3 = this.cux.ctY;
                    xVar3.jC(aVar3.getOffset());
                    aVar4 = this.cux.ctY;
                    aVar4.f(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                xVar = this.cux.cuw;
                aVar = this.cux.ctY;
                xVar.a(booleanValue2, str, aVar);
                s sVar3 = this.cux;
                aVar2 = this.cux.ctY;
                sVar3.cub = aVar2.aig();
                s sVar4 = this.cux;
                arrayList = this.cux.cub;
                if (arrayList != null) {
                    arrayList2 = this.cux.cub;
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
        this.cux.sendEditEnableMessage(1);
    }
}
