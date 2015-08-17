package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponseLocalPersonListMessage extends CustomResponsedMessage<Object> {
    private com.baidu.tieba.person.a.a data;

    public ResponseLocalPersonListMessage() {
        super(CmdConfigCustom.CMD_READ_PERSON_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.tieba.person.a.a' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    /* renamed from: getData */
    public Object getData2() {
        return this.data;
    }

    public void setData(com.baidu.tieba.person.a.a aVar) {
        this.data = aVar;
    }
}
