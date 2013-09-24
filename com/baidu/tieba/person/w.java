package com.baidu.tieba.person;
/* loaded from: classes.dex */
class w extends com.baidu.tieba.m {
    final /* synthetic */ EditMarkActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(EditMarkActivity editMarkActivity, com.baidu.tieba.j jVar) {
        super(jVar);
        this.b = editMarkActivity;
    }

    @Override // com.baidu.tieba.m
    public void a(Object... objArr) {
        boolean booleanValue;
        y yVar;
        com.baidu.tieba.model.h hVar;
        y yVar2;
        y yVar3;
        com.baidu.tieba.model.h hVar2;
        com.baidu.tieba.model.h hVar3;
        y yVar4;
        y yVar5;
        y yVar6;
        com.baidu.tieba.model.h hVar4;
        com.baidu.tieba.model.h hVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                yVar6 = this.b.b;
                hVar4 = this.b.f1640a;
                yVar6.a(r1, hVar4, (Boolean) objArr[2]);
                EditMarkActivity editMarkActivity = this.b;
                hVar5 = this.b.f1640a;
                editMarkActivity.d = hVar5.c();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                yVar4 = this.b.b;
                yVar4.e();
                yVar5 = this.b.b;
                yVar5.a(r1);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                yVar2 = this.b.b;
                yVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    yVar3 = this.b.b;
                    hVar2 = this.b.f1640a;
                    yVar3.a(hVar2.a());
                    hVar3 = this.b.f1640a;
                    hVar3.a((Boolean) true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                yVar = this.b.b;
                hVar = this.b.f1640a;
                yVar.a(booleanValue, str, hVar.c());
            }
        } catch (Exception e) {
        }
    }
}
