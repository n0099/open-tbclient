package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
class s extends l {
    final /* synthetic */ p ccw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.ccw = pVar;
    }

    @Override // com.baidu.tieba.myCollection.l
    public void callback(Object... objArr) {
        u uVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        ArrayList arrayList;
        boolean z;
        ArrayList arrayList2;
        u uVar2;
        u uVar3;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        com.baidu.tieba.myCollection.baseEditMark.a aVar4;
        u uVar4;
        u uVar5;
        u uVar6;
        u uVar7;
        com.baidu.tieba.myCollection.baseEditMark.a aVar5;
        com.baidu.tieba.myCollection.baseEditMark.a aVar6;
        ArrayList arrayList3;
        ArrayList arrayList4;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                uVar6 = this.ccw.ccv;
                uVar6.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                uVar7 = this.ccw.ccv;
                aVar5 = this.ccw.cbZ;
                uVar7.a(r3, aVar5, ((Boolean) objArr[2]).booleanValue());
                p pVar = this.ccw;
                aVar6 = this.ccw.cbZ;
                pVar.ccc = aVar6.adT();
                p pVar2 = this.ccw;
                arrayList3 = this.ccw.ccc;
                if (arrayList3 != null) {
                    arrayList4 = this.ccw.ccc;
                    if (!arrayList4.isEmpty()) {
                        r2 = true;
                    }
                }
                pVar2.mIsEnableEdit = r2;
            } else if (((Integer) objArr[0]).intValue() == 3) {
                uVar4 = this.ccw.ccv;
                uVar4.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                uVar5 = this.ccw.ccv;
                uVar5.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                this.ccw.mIsEnableEdit = false;
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r3 = objArr[2] != null ? (String) objArr[2] : null;
                r2 = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                uVar2 = this.ccw.ccv;
                uVar2.a(booleanValue, r3, r2);
                if (booleanValue) {
                    uVar3 = this.ccw.ccv;
                    aVar3 = this.ccw.cbZ;
                    uVar3.iL(aVar3.getOffset());
                    aVar4 = this.ccw.cbZ;
                    aVar4.f(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                uVar = this.ccw.ccv;
                aVar = this.ccw.cbZ;
                uVar.a(booleanValue2, str, aVar);
                p pVar3 = this.ccw;
                aVar2 = this.ccw.cbZ;
                pVar3.ccc = aVar2.adT();
                p pVar4 = this.ccw;
                arrayList = this.ccw.ccc;
                if (arrayList != null) {
                    arrayList2 = this.ccw.ccc;
                    if (!arrayList2.isEmpty()) {
                        z = true;
                        pVar4.mIsEnableEdit = z;
                    }
                }
                z = false;
                pVar4.mIsEnableEdit = z;
            }
        } catch (Exception e) {
            e.printStackTrace();
            BdLog.d(e.getMessage());
        }
        this.ccw.sendEditEnableMessage(1);
    }
}
