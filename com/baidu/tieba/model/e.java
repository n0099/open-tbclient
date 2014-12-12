package com.baidu.tieba.model;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.cache.u<byte[]> {
    final /* synthetic */ d bsS;
    private final /* synthetic */ com.baidu.tieba.data.e bsT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.data.e eVar) {
        this.bsS = dVar;
        this.bsT = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: k */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.bsT.as(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.bsT.a(forumRecommendResIdl.data);
                    this.bsT.bn(true);
                }
            } catch (Exception e) {
                this.bsT.as(false);
            }
            if (this.bsT.isSuccess() && !this.bsT.Cg()) {
                this.bsT.Ce().Cv();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.bsT.isEmpty());
            handler = this.bsS.mUIHandler;
            handler.post(new f(this, this.bsT));
        }
    }
}
