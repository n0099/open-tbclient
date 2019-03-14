package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.as;
/* loaded from: classes5.dex */
public class ResponseLocalPersonFollowMessage extends CustomResponsedMessage<Object> {
    private as data;

    public ResponseLocalPersonFollowMessage() {
        super(2001188);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.tbadk.core.data.as' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    /* renamed from: getData */
    public Object getData2() {
        return this.data;
    }

    public void setData(as asVar) {
        this.data = asVar;
    }
}
