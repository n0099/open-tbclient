package com.baidu.tieba.recommendfrs;

import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tbadk.util.g<DataRes> {
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar) {
        this.dVL = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    /* renamed from: b */
    public void onReturnDataInUI(DataRes dataRes) {
        this.dVL.a(dataRes);
    }
}
