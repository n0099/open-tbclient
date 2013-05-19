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
        com.baidu.tieba.c.c cVar;
        y yVar2;
        y yVar3;
        com.baidu.tieba.c.c cVar2;
        com.baidu.tieba.c.c cVar3;
        y yVar4;
        com.baidu.tieba.c.c cVar4;
        try {
            if (((Integer) objArr[0]).intValue() == 0) {
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                yVar4 = this.b.d;
                cVar4 = this.b.c;
                yVar4.a(r1, cVar4);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                yVar2 = this.b.d;
                yVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    yVar3 = this.b.d;
                    cVar2 = this.b.c;
                    yVar3.a(cVar2.a());
                    cVar3 = this.b.c;
                    cVar3.f();
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                yVar = this.b.d;
                cVar = this.b.c;
                yVar.a(booleanValue, str, cVar.b());
            }
        } catch (Exception e) {
        }
    }
}
