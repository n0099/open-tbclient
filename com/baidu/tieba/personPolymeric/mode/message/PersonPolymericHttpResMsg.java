package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jz7;
import com.squareup.wire.Wire;
import tbclient.Personal.PersonalResIdl;
/* loaded from: classes3.dex */
public class PersonPolymericHttpResMsg extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPolymericHttpResMsg() {
        super(CmdConfigHttp.CMD_PERSON_POLYMERIC);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            PersonPolymericReqMsg personPolymericReqMsg = (PersonPolymericReqMsg) getOrginalMessage().getExtra();
            PersonalResIdl personalResIdl = (PersonalResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalResIdl.class);
            if (personalResIdl != null) {
                setError(personalResIdl.error.errorno.intValue());
                setErrorString(personalResIdl.error.usermsg);
                if (getError() != 0) {
                    return;
                }
                jz7 personCenterData = personPolymericReqMsg.getPersonCenterData();
                if (personalResIdl.data == null || personCenterData == null) {
                    return;
                }
                personCenterData.a(personalResIdl);
            }
        }
    }
}
