package com.baidu.tieba.person;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.m {
    final /* synthetic */ EditMarkActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(EditMarkActivity editMarkActivity) {
        super(editMarkActivity);
        this.b = editMarkActivity;
    }

    @Override // com.baidu.tieba.m
    public void a(Object... objArr) {
        boolean booleanValue;
        aa aaVar;
        com.baidu.tieba.model.o oVar;
        aa aaVar2;
        aa aaVar3;
        com.baidu.tieba.model.o oVar2;
        com.baidu.tieba.model.o oVar3;
        aa aaVar4;
        aa aaVar5;
        aa aaVar6;
        aa aaVar7;
        com.baidu.tieba.model.o oVar4;
        com.baidu.tieba.model.o oVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                aaVar6 = this.b.b;
                aaVar6.k();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                aaVar7 = this.b.b;
                oVar4 = this.b.a;
                aaVar7.a(r1, oVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.b;
                oVar5 = this.b.a;
                editMarkActivity.d = oVar5.f();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                aaVar4 = this.b.b;
                aaVar4.k();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                aaVar5 = this.b.b;
                aaVar5.a(r1, (com.baidu.tieba.model.o) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                aaVar2 = this.b.b;
                aaVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    aaVar3 = this.b.b;
                    oVar2 = this.b.a;
                    aaVar3.a(oVar2.a());
                    oVar3 = this.b.a;
                    oVar3.a((Boolean) true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                aaVar = this.b.b;
                oVar = this.b.a;
                aaVar.a(booleanValue, str, oVar.f());
            }
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.d(e.getMessage());
        }
    }
}
