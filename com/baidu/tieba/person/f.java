package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class f extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ EditMarkActivity bAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(EditMarkActivity editMarkActivity, BaseActivity baseActivity) {
        super();
        this.bAW = editMarkActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        boolean booleanValue;
        h hVar;
        com.baidu.tieba.model.j jVar;
        h hVar2;
        h hVar3;
        com.baidu.tieba.model.j jVar2;
        com.baidu.tieba.model.j jVar3;
        h hVar4;
        h hVar5;
        h hVar6;
        h hVar7;
        com.baidu.tieba.model.j jVar4;
        com.baidu.tieba.model.j jVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                hVar6 = this.bAW.bAT;
                hVar6.hN();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                hVar7 = this.bAW.bAT;
                jVar4 = this.bAW.bAS;
                hVar7.a(r1, jVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.bAW;
                jVar5 = this.bAW.bAS;
                editMarkActivity.bAV = jVar5.Ti();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                hVar4 = this.bAW.bAT;
                hVar4.hN();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                hVar5 = this.bAW.bAT;
                hVar5.a(r1, (com.baidu.tieba.model.j) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                hVar2 = this.bAW.bAT;
                hVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    hVar3 = this.bAW.bAT;
                    jVar2 = this.bAW.bAS;
                    hVar3.gU(jVar2.getOffset());
                    jVar3 = this.bAW.bAS;
                    jVar3.g(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                hVar = this.bAW.bAT;
                jVar = this.bAW.bAS;
                hVar.a(booleanValue, str, jVar.Ti());
            }
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }
}
