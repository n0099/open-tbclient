package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Personal.PersonalResIdl;
/* loaded from: classes.dex */
public class PersonPolymericHttpResMsg extends TbHttpResponsedMessage {
    public PersonPolymericHttpResMsg() {
        super(CmdConfigHttp.CMD_PERSON_POLYMERIC);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PersonPolymericReqMsg personPolymericReqMsg = (PersonPolymericReqMsg) getOrginalMessage().getExtra();
        PersonalResIdl personalResIdl = (PersonalResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalResIdl.class);
        if (personalResIdl != null) {
            setError(personalResIdl.error.errorno.intValue());
            setErrorString(personalResIdl.error.usermsg);
            if (getError() == 0) {
                personPolymericReqMsg.getPersonPolymericData();
            }
        }
    }
}
