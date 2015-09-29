package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
class e extends l {
    final /* synthetic */ EditMarkActivity cbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EditMarkActivity editMarkActivity) {
        this.cbr = editMarkActivity;
    }

    @Override // com.baidu.tieba.myCollection.l
    public void callback(Object... objArr) {
        boolean booleanValue;
        j jVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar;
        j jVar2;
        j jVar3;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        j jVar4;
        j jVar5;
        j jVar6;
        j jVar7;
        com.baidu.tieba.myCollection.baseEditMark.a aVar4;
        com.baidu.tieba.myCollection.baseEditMark.a aVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                jVar6 = this.cbr.cbo;
                jVar6.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                jVar7 = this.cbr.cbo;
                aVar4 = this.cbr.cbn;
                jVar7.a(r1, aVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.cbr;
                aVar5 = this.cbr.cbn;
                editMarkActivity.cbq = aVar5.adC();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                jVar4 = this.cbr.cbo;
                jVar4.completePullRefresh();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                jVar5 = this.cbr.cbo;
                jVar5.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                jVar2 = this.cbr.cbo;
                jVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    jVar3 = this.cbr.cbo;
                    aVar2 = this.cbr.cbn;
                    jVar3.iy(aVar2.getOffset());
                    aVar3 = this.cbr.cbn;
                    aVar3.f(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                jVar = this.cbr.cbo;
                aVar = this.cbr.cbn;
                jVar.a(booleanValue, str, aVar);
            }
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }
}
