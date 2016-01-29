package com.baidu.tieba.recommendfrs;

import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.util.d<DataRes> {
    final /* synthetic */ p dDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dDT = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    /* renamed from: b */
    public void onReturnDataInUI(DataRes dataRes) {
        this.dDT.a(dataRes);
    }
}
