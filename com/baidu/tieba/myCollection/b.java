package com.baidu.tieba.myCollection;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class b extends BaseActivity<EditMarkActivity>.LoadDataCallBack {
    final /* synthetic */ EditMarkActivity byr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(EditMarkActivity editMarkActivity, BaseActivity baseActivity) {
        super();
        this.byr = editMarkActivity;
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
                gVar6 = this.byr.byo;
                gVar6.jI();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                gVar7 = this.byr.byo;
                aVar4 = this.byr.byn;
                gVar7.a(r1, aVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.byr;
                aVar5 = this.byr.byn;
                editMarkActivity.byq = aVar5.le();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                gVar4 = this.byr.byo;
                gVar4.jI();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                gVar5 = this.byr.byo;
                gVar5.a(r1, (com.baidu.tbadk.baseEditMark.a) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                gVar2 = this.byr.byo;
                gVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    gVar3 = this.byr.byo;
                    aVar2 = this.byr.byn;
                    gVar3.gW(aVar2.getOffset());
                    aVar3 = this.byr.byn;
                    aVar3.c((Boolean) true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                gVar = this.byr.byo;
                aVar = this.byr.byn;
                gVar.a(booleanValue, str, aVar.le());
            }
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }
}
