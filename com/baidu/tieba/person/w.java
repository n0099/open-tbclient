package com.baidu.tieba.person;
/* loaded from: classes.dex */
class w extends com.baidu.tieba.h {
    final /* synthetic */ EditMarkActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(EditMarkActivity editMarkActivity, com.baidu.tieba.e eVar) {
        super(eVar);
        this.b = editMarkActivity;
    }

    @Override // com.baidu.tieba.h
    public void a(Object... objArr) {
        boolean booleanValue;
        y yVar;
        com.baidu.tieba.c.f fVar;
        y yVar2;
        y yVar3;
        com.baidu.tieba.c.f fVar2;
        com.baidu.tieba.c.f fVar3;
        y yVar4;
        com.baidu.tieba.c.f fVar4;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                yVar4 = this.b.d;
                fVar4 = this.b.c;
                yVar4.a(r1, fVar4);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                yVar2 = this.b.d;
                yVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    yVar3 = this.b.d;
                    fVar2 = this.b.c;
                    yVar3.a(fVar2.a());
                    fVar3 = this.b.c;
                    fVar3.f();
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                yVar = this.b.d;
                fVar = this.b.c;
                yVar.a(booleanValue, str, fVar.b());
            }
        } catch (Exception e) {
        }
    }
}
