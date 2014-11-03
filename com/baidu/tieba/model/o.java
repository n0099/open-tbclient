package com.baidu.tieba.model;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.lib.cache.u<byte[]> {
    final /* synthetic */ n boI;
    private final /* synthetic */ com.baidu.tieba.data.o boJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.baidu.tieba.data.o oVar) {
        this.boI = nVar;
        this.boJ = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: i */
    public void d(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.boJ.ab(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.boJ.a(forumRecommendResIdl.data);
                    this.boJ.bp(true);
                }
            } catch (Exception e) {
                this.boJ.ab(false);
            }
            if (this.boJ.isSuccess() && !this.boJ.yU()) {
                this.boJ.yS().zA();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.boJ.isEmpty());
            handler = this.boI.mUIHandler;
            handler.post(new p(this, this.boJ));
        }
    }
}
