package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Personal.PersonalResIdl;
/* loaded from: classes.dex */
public class PersonPolymericSocketResMsg extends SocketResponsedMessage {
    public PersonPolymericSocketResMsg() {
        super(309408);
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
                personPolymericReqMsg.getPersonPolymericData();
            }
        }
    }
}
