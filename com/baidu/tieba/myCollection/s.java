package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
class s extends l {
    final /* synthetic */ p bXY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.bXY = pVar;
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
                uVar6 = this.bXY.bXX;
                uVar6.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                uVar7 = this.bXY.bXX;
                aVar5 = this.bXY.bXB;
                uVar7.a(r3, aVar5, ((Boolean) objArr[2]).booleanValue());
                p pVar = this.bXY;
                aVar6 = this.bXY.bXB;
                pVar.bXE = aVar6.acj();
                p pVar2 = this.bXY;
                arrayList3 = this.bXY.bXE;
                if (arrayList3 != null) {
                    arrayList4 = this.bXY.bXE;
                    if (!arrayList4.isEmpty()) {
                        r2 = true;
                    }
                }
                pVar2.mIsEnableEdit = r2;
            } else if (((Integer) objArr[0]).intValue() == 3) {
                uVar4 = this.bXY.bXX;
                uVar4.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                uVar5 = this.bXY.bXX;
                uVar5.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                this.bXY.mIsEnableEdit = false;
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r3 = objArr[2] != null ? (String) objArr[2] : null;
                r2 = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                uVar2 = this.bXY.bXX;
                uVar2.a(booleanValue, r3, r2);
                if (booleanValue) {
                    uVar3 = this.bXY.bXX;
                    aVar3 = this.bXY.bXB;
                    uVar3.iq(aVar3.getOffset());
                    aVar4 = this.bXY.bXB;
                    aVar4.f(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                uVar = this.bXY.bXX;
                aVar = this.bXY.bXB;
                uVar.a(booleanValue2, str, aVar);
                p pVar3 = this.bXY;
                aVar2 = this.bXY.bXB;
                pVar3.bXE = aVar2.acj();
                p pVar4 = this.bXY;
                arrayList = this.bXY.bXE;
                if (arrayList != null) {
                    arrayList2 = this.bXY.bXE;
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
        this.bXY.sendEditEnableMessage(1);
    }
}
