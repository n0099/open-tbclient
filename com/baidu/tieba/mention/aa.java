package com.baidu.tieba.mention;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ReplyMe.ReplyMeResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.adp.lib.cache.u<byte[]> {
    final /* synthetic */ v a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(v vVar) {
        this.a = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    public void a(String str, byte[] bArr) {
        int i;
        Handler handler;
        if (bArr != null) {
            i = this.a.h;
            if (i == 1) {
                try {
                    com.baidu.tieba.model.al alVar = new com.baidu.tieba.model.al();
                    alVar.a(((ReplyMeResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyMeResIdl.class)).data);
                    if (alVar.a()) {
                        handler = this.a.l;
                        handler.post(new ab(this, alVar));
                    } else {
                        this.a.m();
                    }
                } catch (Exception e) {
                    BdLog.detailException(e);
                }
            }
        }
    }
}
