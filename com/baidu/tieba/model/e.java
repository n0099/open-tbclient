package com.baidu.tieba.model;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.cache.u<byte[]> {
    final /* synthetic */ d bup;
    private final /* synthetic */ com.baidu.tieba.data.e buq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.data.e eVar) {
        this.bup = dVar;
        this.buq = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: k */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.buq.au(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.buq.a(forumRecommendResIdl.data);
                    this.buq.bq(true);
                }
            } catch (Exception e) {
                this.buq.au(false);
            }
            if (this.buq.isSuccess() && !this.buq.CA()) {
                this.buq.Cy().CO();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.buq.isEmpty());
            handler = this.bup.mUIHandler;
            handler.post(new f(this, this.buq));
        }
    }
}
