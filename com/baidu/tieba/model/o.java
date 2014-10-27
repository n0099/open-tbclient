package com.baidu.tieba.model;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.lib.cache.u<byte[]> {
    final /* synthetic */ n bou;
    private final /* synthetic */ com.baidu.tieba.data.o bov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.baidu.tieba.data.o oVar) {
        this.bou = nVar;
        this.bov = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: i */
    public void d(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.bov.ab(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.bov.a(forumRecommendResIdl.data);
                    this.bov.bp(true);
                }
            } catch (Exception e) {
                this.bov.ab(false);
            }
            if (this.bov.isSuccess() && !this.bov.yS()) {
                this.bov.yQ().zy();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.bov.isEmpty());
            handler = this.bou.mUIHandler;
            handler.post(new p(this, this.bov));
        }
    }
}
