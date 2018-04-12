package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.ar;
/* loaded from: classes3.dex */
public class ResponseLocalPersonListMessage extends CustomResponsedMessage<Object> {
    private ar data;

    public ResponseLocalPersonListMessage() {
        super(2001188);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.tbadk.core.data.ar' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    /* renamed from: getData */
    public Object getData2() {
        return this.data;
    }

    public void setData(ar arVar) {
        this.data = arVar;
    }
}
