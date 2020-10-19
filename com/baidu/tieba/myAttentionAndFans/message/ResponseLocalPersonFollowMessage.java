package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bc;
/* loaded from: classes23.dex */
public class ResponseLocalPersonFollowMessage extends CustomResponsedMessage<Object> {
    private bc data;

    public ResponseLocalPersonFollowMessage() {
        super(CmdConfigCustom.CMD_READ_PERSON_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.tbadk.core.data.bc' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    /* renamed from: getData */
    public Object getData2() {
        return this.data;
    }

    public void setData(bc bcVar) {
        this.data = bcVar;
    }
}
