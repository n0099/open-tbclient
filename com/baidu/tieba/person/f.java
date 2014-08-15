package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
/* loaded from: classes.dex */
class f extends BaseActivity.LoadDataCallBack {
    final /* synthetic */ EditMarkActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(EditMarkActivity editMarkActivity, BaseActivity baseActivity) {
        super();
        this.a = editMarkActivity;
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
                hVar6 = this.a.b;
                hVar6.j();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                hVar7 = this.a.b;
                jVar4 = this.a.a;
                hVar7.a(r1, jVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.a;
                jVar5 = this.a.a;
                editMarkActivity.d = jVar5.f();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                hVar4 = this.a.b;
                hVar4.j();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                hVar5 = this.a.b;
                hVar5.a(r1, (com.baidu.tieba.model.j) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                hVar2 = this.a.b;
                hVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    hVar3 = this.a.b;
                    jVar2 = this.a.a;
                    hVar3.a(jVar2.a());
                    jVar3 = this.a.a;
                    jVar3.a((Boolean) true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                hVar = this.a.b;
                jVar = this.a.a;
                hVar.a(booleanValue, str, jVar.f());
            }
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }
}
