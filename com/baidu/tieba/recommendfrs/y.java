package com.baidu.tieba.recommendfrs;

import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.Personalized.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.s<DataRes> {
    private final /* synthetic */ com.baidu.adp.lib.cache.o cFw;
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(r rVar, com.baidu.adp.lib.cache.o oVar) {
        this.dYM = rVar;
        this.cFw = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: aMk */
    public DataRes doInBackground() {
        byte[] bArr = (byte[]) this.cFw.get("0");
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
