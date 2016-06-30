package com.baidu.tieba.person;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class ResponsePersonBarByUidLocalMessage extends CustomResponsedMessage<String> {
    private s mData;

    public ResponsePersonBarByUidLocalMessage() {
        super(CmdConfigCustom.CMD_QUERY_PERSON_BAR_LOCAL_HISTORY);
    }

    public ResponsePersonBarByUidLocalMessage(int i) {
        super(i);
    }

    public void setPersonBarData(s sVar) {
        this.mData = sVar;
    }

    public s getPersonBarData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.CustomResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, String str) {
        this.mData = new s();
        this.mData.parserJson(str);
    }
}
