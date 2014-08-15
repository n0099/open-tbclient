package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class ResponseLocalPersonListMessage extends CustomResponsedMessage<Object> {
    private com.baidu.tieba.data.am data;

    public ResponseLocalPersonListMessage() {
        super(2001192);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.tieba.data.am' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    /* renamed from: getData */
    public Object getData2() {
        return this.data;
    }

    public void setData(com.baidu.tieba.data.am amVar) {
        this.data = amVar;
    }
}
