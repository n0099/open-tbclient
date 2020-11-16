package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes22.dex */
public class ResponseLocalPersonFollowMessage extends CustomResponsedMessage<Object> {
    private bd data;

    public ResponseLocalPersonFollowMessage() {
        super(CmdConfigCustom.CMD_READ_PERSON_LIST);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.baidu.tbadk.core.data.bd' to match base method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage
    /* renamed from: getData */
    public Object getData2() {
        return this.data;
    }

    public void setData(bd bdVar) {
        this.data = bdVar;
    }
}
