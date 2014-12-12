package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class b extends BaseActivity<EditMarkActivity>.LoadDataCallBack {
    final /* synthetic */ EditMarkActivity bwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(EditMarkActivity editMarkActivity, BaseActivity baseActivity) {
        super();
        this.bwI = editMarkActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        boolean booleanValue;
        g gVar;
        com.baidu.tbadk.baseEditMark.a aVar;
        g gVar2;
        g gVar3;
        com.baidu.tbadk.baseEditMark.a aVar2;
        com.baidu.tbadk.baseEditMark.a aVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g gVar7;
        com.baidu.tbadk.baseEditMark.a aVar4;
        com.baidu.tbadk.baseEditMark.a aVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                gVar6 = this.bwI.bwF;
                gVar6.jJ();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                gVar7 = this.bwI.bwF;
                aVar4 = this.bwI.bwE;
                gVar7.a(r1, aVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.bwI;
                aVar5 = this.bwI.bwE;
                editMarkActivity.bwH = aVar5.le();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                gVar4 = this.bwI.bwF;
                gVar4.jJ();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                gVar5 = this.bwI.bwF;
                gVar5.a(r1, (com.baidu.tbadk.baseEditMark.a) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                gVar2 = this.bwI.bwF;
                gVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    gVar3 = this.bwI.bwF;
                    aVar2 = this.bwI.bwE;
                    gVar3.gN(aVar2.getOffset());
                    aVar3 = this.bwI.bwE;
                    aVar3.c((Boolean) true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                gVar = this.bwI.bwF;
                aVar = this.bwI.bwE;
                gVar.a(booleanValue, str, aVar.le());
            }
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }
}
