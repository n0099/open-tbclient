package com.baidu.tieba.person;
/* loaded from: classes.dex */
final class k extends com.baidu.tbadk.d {
    final /* synthetic */ EditMarkActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(EditMarkActivity editMarkActivity, com.baidu.tbadk.a aVar) {
        super(aVar);
        this.b = editMarkActivity;
    }

    @Override // com.baidu.tbadk.d
    public final void a(Object... objArr) {
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
                mVar6 = this.b.b;
                mVar6.g();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                mVar7 = this.b.b;
                kVar4 = this.b.a;
                mVar7.a(r1, kVar4, ((Boolean) objArr[2]).booleanValue());
                EditMarkActivity editMarkActivity = this.b;
                kVar5 = this.b.a;
                editMarkActivity.d = kVar5.f();
            } else if (((Integer) objArr[0]).intValue() == 3) {
                mVar4 = this.b.b;
                mVar4.g();
                if (objArr[1] != null && (objArr[1] instanceof String)) {
                    r1 = (String) objArr[1];
                }
                mVar5 = this.b.b;
                mVar5.a(r1, (com.baidu.tieba.model.k) null, false);
            } else if (((Integer) objArr[0]).intValue() == 1) {
                boolean booleanValue2 = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                r1 = objArr[2] != null ? (String) objArr[2] : null;
                booleanValue = objArr[3] != null ? ((Boolean) objArr[3]).booleanValue() : false;
                mVar2 = this.b.b;
                mVar2.a(booleanValue2, r1, booleanValue);
                if (booleanValue2) {
                    mVar3 = this.b.b;
                    kVar2 = this.b.a;
                    mVar3.a(kVar2.a());
                    kVar3 = this.b.a;
                    kVar3.a((Boolean) true);
                }
            } else if (((Integer) objArr[0]).intValue() == 2) {
                booleanValue = objArr[1] != null ? ((Boolean) objArr[1]).booleanValue() : false;
                String str = objArr[2] != null ? (String) objArr[2] : null;
                mVar = this.b.b;
                kVar = this.b.a;
                mVar.a(booleanValue, str, kVar.f());
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.e(e.getMessage());
        }
    }
}
