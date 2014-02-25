package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ab extends com.baidu.tieba.i {
    final /* synthetic */ EditMarkActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(EditMarkActivity editMarkActivity, com.baidu.tieba.f fVar) {
        super(fVar);
        this.b = editMarkActivity;
    }

    @Override // com.baidu.tieba.i
    public void a(Object... objArr) {
        boolean booleanValue;
        ad adVar;
        com.baidu.tieba.model.g gVar;
        ad adVar2;
        ad adVar3;
        com.baidu.tieba.model.g gVar2;
        com.baidu.tieba.model.g gVar3;
        ad adVar4;
        ad adVar5;
        ad adVar6;
        ad adVar7;
        com.baidu.tieba.model.g gVar4;
        com.baidu.tieba.model.g gVar5;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                adVar6 = this.b.b;
                adVar6.j();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                adVar7 = this.b.b;
                gVar4 = this.b.a;
                adVar7.a(r1, gVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.b;
                gVar5 = this.b.a;
                editMarkActivity.d = gVar5.f();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                adVar4 = this.b.b;
                adVar4.j();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                adVar5 = this.b.b;
                adVar5.a(r1, (com.baidu.tieba.model.g) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                adVar2 = this.b.b;
                adVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    adVar3 = this.b.b;
                    gVar2 = this.b.a;
                    adVar3.a(gVar2.a());
                    gVar3 = this.b.a;
                    gVar3.a((Boolean) true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                adVar = this.b.b;
                gVar = this.b.a;
                adVar.a(booleanValue, str, gVar.f());
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.e(e.getMessage());
        }
    }
}
