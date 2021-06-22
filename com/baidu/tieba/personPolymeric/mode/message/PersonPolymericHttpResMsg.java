package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.a.o0.g2.b;
import tbclient.Personal.PersonalResIdl;
/* loaded from: classes5.dex */
public class PersonPolymericHttpResMsg extends TbHttpResponsedMessage {
    public PersonPolymericHttpResMsg() {
        super(CmdConfigHttp.CMD_PERSON_POLYMERIC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        PersonPolymericReqMsg personPolymericReqMsg = (PersonPolymericReqMsg) getOrginalMessage().getExtra();
        PersonalResIdl personalResIdl = (PersonalResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalResIdl.class);
        if (personalResIdl != null) {
            setError(personalResIdl.error.errorno.intValue());
            setErrorString(personalResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            b personCenterData = personPolymericReqMsg.getPersonCenterData();
            if (personalResIdl.data == null || personCenterData == null) {
                return;
            }
            personCenterData.a(personalResIdl);
        }
    }
}
