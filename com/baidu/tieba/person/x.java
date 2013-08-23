package com.baidu.tieba.person;
/* loaded from: classes.dex */
class x extends com.baidu.tieba.j {
    final /* synthetic */ EditMarkActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(EditMarkActivity editMarkActivity, com.baidu.tieba.g gVar) {
        super(gVar);
        this.b = editMarkActivity;
    }

    @Override // com.baidu.tieba.j
    public void a(Object... objArr) {
        boolean booleanValue;
        z zVar;
        com.baidu.tieba.model.f fVar;
        z zVar2;
        z zVar3;
        com.baidu.tieba.model.f fVar2;
        com.baidu.tieba.model.f fVar3;
        z zVar4;
        z zVar5;
        z zVar6;
        com.baidu.tieba.model.f fVar4;
        com.baidu.tieba.model.f fVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                zVar6 = this.b.b;
                fVar4 = this.b.f1590a;
                zVar6.a(r1, fVar4, (Boolean) objArr[2]);
                EditMarkActivity editMarkActivity = this.b;
                fVar5 = this.b.f1590a;
                editMarkActivity.d = fVar5.c();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                zVar4 = this.b.b;
                zVar4.f();
                zVar5 = this.b.b;
                zVar5.a(r1);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                zVar2 = this.b.b;
                zVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    zVar3 = this.b.b;
                    fVar2 = this.b.f1590a;
                    zVar3.a(fVar2.a());
                    fVar3 = this.b.f1590a;
                    fVar3.a((Boolean) true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                zVar = this.b.b;
                fVar = this.b.f1590a;
                zVar.a(booleanValue, str, fVar.c());
            }
        } catch (Exception e) {
        }
    }
}
