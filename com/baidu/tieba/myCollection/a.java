package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class a extends BaseActivity<EditMarkActivity>.LoadDataCallBack {
    final /* synthetic */ EditMarkActivity bDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(EditMarkActivity editMarkActivity, BaseActivity baseActivity) {
        super();
        this.bDZ = editMarkActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        boolean booleanValue;
        f fVar;
        com.baidu.tieba.myCollection.baseEditMark.a aVar;
        f fVar2;
        f fVar3;
        com.baidu.tieba.myCollection.baseEditMark.a aVar2;
        com.baidu.tieba.myCollection.baseEditMark.a aVar3;
        f fVar4;
        f fVar5;
        f fVar6;
        f fVar7;
        com.baidu.tieba.myCollection.baseEditMark.a aVar4;
        com.baidu.tieba.myCollection.baseEditMark.a aVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                fVar6 = this.bDZ.bDW;
                fVar6.mW();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                fVar7 = this.bDZ.bDW;
                aVar4 = this.bDZ.bDV;
                fVar7.a(r1, aVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.bDZ;
                aVar5 = this.bDZ.bDV;
                editMarkActivity.bDY = aVar5.Yj();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                fVar4 = this.bDZ.bDW;
                fVar4.mW();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                fVar5 = this.bDZ.bDW;
                fVar5.a(r1, (com.baidu.tieba.myCollection.baseEditMark.a) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                fVar2 = this.bDZ.bDW;
                fVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    fVar3 = this.bDZ.bDW;
                    aVar2 = this.bDZ.bDV;
                    fVar3.gY(aVar2.getOffset());
                    aVar3 = this.bDZ.bDV;
                    aVar3.e(true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                fVar = this.bDZ.bDW;
                aVar = this.bDZ.bDV;
                fVar.a(booleanValue, str, aVar);
            }
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }
}
