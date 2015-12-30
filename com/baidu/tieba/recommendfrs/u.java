package com.baidu.tieba.recommendfrs;

import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.util.m<DataRes> {
    final /* synthetic */ n doE;
    private final /* synthetic */ com.baidu.adp.lib.cache.o doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(n nVar, com.baidu.adp.lib.cache.o oVar) {
        this.doE = nVar;
        this.doF = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: ayi */
    public DataRes doInBackground() {
        byte[] bArr = (byte[]) this.doF.get("0");
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
        } catch (IOException e) {
            BdLog.e(e);
            return null;
        }
    }
}
