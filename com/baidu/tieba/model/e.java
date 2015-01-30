package com.baidu.tieba.model;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ForumRecommend.DataRes;
import tbclient.ForumRecommend.ForumRecommendResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.lib.cache.u<byte[]> {
    final /* synthetic */ d buq;
    private final /* synthetic */ com.baidu.tieba.data.e bur;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, com.baidu.tieba.data.e eVar) {
        this.buq = dVar;
        this.bur = eVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.cache.u
    /* renamed from: k */
    public void onItemGet(String str, byte[] bArr) {
        Handler handler;
        if (bArr != null) {
            this.bur.au(true);
            try {
                ForumRecommendResIdl forumRecommendResIdl = (ForumRecommendResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRecommendResIdl.class);
                if (forumRecommendResIdl.data != null && (forumRecommendResIdl.data instanceof DataRes)) {
                    this.bur.a(forumRecommendResIdl.data);
                    this.bur.bq(true);
                }
            } catch (Exception e) {
                this.bur.au(false);
            }
            if (this.bur.isSuccess() && !this.bur.CG()) {
                this.bur.CE().CU();
            }
            BdLog.d("EnterForumTask,TYPE_DB,data.isEmpty=" + this.bur.isEmpty());
            handler = this.buq.mUIHandler;
            handler.post(new f(this, this.bur));
        }
    }
}
