package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class g extends o {
    final /* synthetic */ EditMarkActivity cEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditMarkActivity editMarkActivity) {
        this.cEL = editMarkActivity;
    }

    @Override // com.baidu.tieba.myCollection.o
    public void callback(Object... objArr) {
        boolean booleanValue;
        m mVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar;
        m mVar2;
        m mVar3;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        m mVar7;
        com.baidu.tieba.myCollection.baseEditMark.a aVar4;
        com.baidu.tieba.myCollection.baseEditMark.a aVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                mVar6 = this.cEL.cEI;
                mVar6.nr();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                mVar7 = this.cEL.cEI;
                aVar4 = this.cEL.cEH;
                mVar7.a(r1, aVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.cEL;
                aVar5 = this.cEL.cEH;
                editMarkActivity.cEK = aVar5.anr();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                mVar4 = this.cEL.cEI;
                mVar4.nr();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                mVar5 = this.cEL.cEI;
                mVar5.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                mVar2 = this.cEL.cEI;
                mVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    mVar3 = this.cEL.cEI;
                    aVar2 = this.cEL.cEH;
                    mVar3.kA(aVar2.getOffset());
                    aVar3 = this.cEL.cEH;
                    aVar3.f(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                mVar = this.cEL.cEI;
                aVar = this.cEL.cEH;
                mVar.a(booleanValue, str, aVar);
            }
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }
}
