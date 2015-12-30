package com.baidu.tieba.recommendfrs;

import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.util.d<DataRes> {
    final /* synthetic */ n doE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(n nVar) {
        this.doE = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: b */
    public void onReturnDataInUI(DataRes dataRes) {
        this.doE.a(dataRes);
    }
}
