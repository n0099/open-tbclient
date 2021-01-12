package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.person.b;
import com.squareup.wire.Wire;
import tbclient.Personal.PersonalResIdl;
/* loaded from: classes7.dex */
public class PersonPolymericSocketResMsg extends SocketResponsedMessage {
    public PersonPolymericSocketResMsg() {
        super(CmdConfigSocket.CMD_PERSON_POLYMERIC);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PersonPolymericReqMsg personPolymericReqMsg = (PersonPolymericReqMsg) getOrginalMessage().getExtra();
        PersonalResIdl personalResIdl = (PersonalResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalResIdl.class);
        if (personalResIdl != null) {
            setError(personalResIdl.error.errorno.intValue());
            setErrorString(personalResIdl.error.usermsg);
            if (getError() == 0) {
                b personCenterData = personPolymericReqMsg.getPersonCenterData();
                if (personalResIdl.data != null && personCenterData != null) {
                    personCenterData.a(personalResIdl);
                }
            }
        }
    }
}
