package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class k extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(EditMarkActivity editMarkActivity, BaseActivity baseActivity) {
        super();
        this.a = editMarkActivity;
    }

    @Override // com.baidu.tbadk.BaseActivity.LoadDataCallBack
    public void callback(Object... objArr) {
        boolean booleanValue;
        m mVar;
        com.baidu.tieba.model.k kVar;
        m mVar2;
        m mVar3;
        com.baidu.tieba.model.k kVar2;
        com.baidu.tieba.model.k kVar3;
        m mVar4;
        m mVar5;
        m mVar6;
        m mVar7;
        com.baidu.tieba.model.k kVar4;
        com.baidu.tieba.model.k kVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                mVar6 = this.a.b;
                mVar6.j();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                mVar7 = this.a.b;
                kVar4 = this.a.a;
                mVar7.a(r1, kVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.a;
                kVar5 = this.a.a;
                editMarkActivity.d = kVar5.f();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                mVar4 = this.a.b;
                mVar4.j();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                mVar5 = this.a.b;
                mVar5.a(r1, (com.baidu.tieba.model.k) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                mVar2 = this.a.b;
                mVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    mVar3 = this.a.b;
                    kVar2 = this.a.a;
                    mVar3.a(kVar2.a());
                    kVar3 = this.a.a;
                    kVar3.a((Boolean) true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                mVar = this.a.b;
                kVar = this.a.a;
                mVar.a(booleanValue, str, kVar.f());
            }
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }
}
