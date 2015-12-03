package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class g extends o {
    final /* synthetic */ EditMarkActivity cuc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditMarkActivity editMarkActivity) {
        this.cuc = editMarkActivity;
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
                mVar6 = this.cuc.ctZ;
                mVar6.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                mVar7 = this.cuc.ctZ;
                aVar4 = this.cuc.ctY;
                mVar7.a(r1, aVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.cuc;
                aVar5 = this.cuc.ctY;
                editMarkActivity.cub = aVar5.aig();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                mVar4 = this.cuc.ctZ;
                mVar4.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                mVar5 = this.cuc.ctZ;
                mVar5.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                mVar2 = this.cuc.ctZ;
                mVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    mVar3 = this.cuc.ctZ;
                    aVar2 = this.cuc.ctY;
                    mVar3.jC(aVar2.getOffset());
                    aVar3 = this.cuc.ctY;
                    aVar3.f(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                mVar = this.cuc.ctZ;
                aVar = this.cuc.ctY;
                mVar.a(booleanValue, str, aVar);
            }
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }
}
