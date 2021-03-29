package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import d.b.h0.r.q.g1;
/* loaded from: classes3.dex */
public class ResponseLocalPersonFollowMessage extends CustomResponsedMessage<Object> {
    public g1 data;

    public ResponseLocalPersonFollowMessage() {
        super(2001188);
    }

    public void setData(g1 g1Var) {
        this.data = g1Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'd.b.h0.r.q.g1' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    /* renamed from: getData */
    public Object getData2() {
        return this.data;
    }
}
