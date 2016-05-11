package com.baidu.tieba.recommendfrs;

import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements com.baidu.tbadk.util.g<DataRes> {
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar) {
        this.dYM = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: b */
    public void onReturnDataInUI(DataRes dataRes) {
        this.dYM.a(dataRes);
    }
}
