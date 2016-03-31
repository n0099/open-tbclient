package com.baidu.tieba.recommendfrs;

import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.util.p<DataRes> {
    private final /* synthetic */ com.baidu.adp.lib.cache.o cFE;
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar, com.baidu.adp.lib.cache.o oVar) {
        this.dVL = qVar;
        this.cFE = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: aMb */
    public DataRes doInBackground() {
        byte[] bArr = (byte[]) this.cFE.get("0");
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
