package com.baidu.tieba.recommend;

import com.baidu.tieba.data.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.model.r {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FindInterestFragment f1646a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(FindInterestFragment findInterestFragment) {
        this.f1646a = findInterestFragment;
    }

    @Override // com.baidu.tieba.model.r
    public void a(com.baidu.tieba.data.ae aeVar, int i, String str) {
        aq aqVar;
        bl blVar;
        aq aqVar2;
        bl blVar2;
        if (i == 0) {
            aqVar = this.f1646a.b;
            aqVar.a(aeVar);
            blVar = this.f1646a.e;
            if (blVar != null) {
                aqVar2 = this.f1646a.b;
                blVar2 = this.f1646a.e;
                aqVar2.a(blVar2.b());
                return;
            }
            this.f1646a.a(aeVar);
        }
    }
}
