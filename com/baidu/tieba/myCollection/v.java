package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* loaded from: classes.dex */
class v extends o {
    final /* synthetic */ s cFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.cFe = sVar;
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
                xVar7 = this.cFe.cFd;
                xVar7.nr();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                xVar8 = this.cFe.cFd;
                aVar6 = this.cFe.cEH;
                xVar8.a(r3, aVar6, ((Boolean) objArr[2]).booleanValue());
                s sVar = this.cFe;
                aVar7 = this.cFe.cEH;
                sVar.cEK = aVar7.anr();
                s sVar2 = this.cFe;
                arrayList3 = this.cFe.cEK;
                if (arrayList3 != null) {
                    arrayList4 = this.cFe.cEK;
                    if (!arrayList4.isEmpty()) {
                        r2 = true;
                    }
                }
                sVar2.SQ = r2;
            } else if (((Integer) objArr[0]).intValue() == 3) {
                xVar4 = this.cFe.cFd;
                xVar4.nr();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r3 = (String) objArr[1];
                }
                xVar5 = this.cFe.cFd;
                xVar5.a(r3, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
                xVar6 = this.cFe.cFd;
                aVar5 = this.cFe.cEH;
                xVar6.a(aVar5, false);
                this.cFe.SQ = false;
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r3 = objArr[2] != null ? (String) objArr[2] : null;
                r2 = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                xVar2 = this.cFe.cFd;
                xVar2.a(booleanValue, r3, r2);
                if (booleanValue) {
                    xVar3 = this.cFe.cFd;
                    aVar3 = this.cFe.cEH;
                    xVar3.kA(aVar3.getOffset());
                    aVar4 = this.cFe.cEH;
                    aVar4.f(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                xVar = this.cFe.cFd;
                aVar = this.cFe.cEH;
                xVar.a(booleanValue2, str, aVar);
                s sVar3 = this.cFe;
                aVar2 = this.cFe.cEH;
                sVar3.cEK = aVar2.anr();
                s sVar4 = this.cFe;
                arrayList = this.cFe.cEK;
                if (arrayList != null) {
                    arrayList2 = this.cFe.cEK;
                    if (!arrayList2.isEmpty()) {
                        z = true;
                        sVar4.SQ = z;
                    }
                }
                z = false;
                sVar4.SQ = z;
            }
        } catch (Exception e) {
            e.printStackTrace();
            BdLog.d(e.getMessage());
        }
        this.cFe.aZ(1);
    }
}
