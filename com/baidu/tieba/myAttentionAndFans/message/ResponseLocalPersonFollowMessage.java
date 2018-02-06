package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.aq;
/* loaded from: classes3.dex */
public class ResponseLocalPersonFollowMessage extends CustomResponsedMessage<Object> {
    private aq data;

    public ResponseLocalPersonFollowMessage() {
        super(2001188);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.tbadk.core.data.aq' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    /* renamed from: getData */
    public Object getData2() {
        return this.data;
    }

    public void setData(aq aqVar) {
        this.data = aqVar;
    }
}
