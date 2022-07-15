package com.baidu.tieba.personPolymeric.mode.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d08;
import com.squareup.wire.Wire;
import tbclient.Personal.PersonalResIdl;
/* loaded from: classes3.dex */
public class PersonPolymericSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonPolymericSocketResMsg() {
        super(309408);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            PersonPolymericReqMsg personPolymericReqMsg = (PersonPolymericReqMsg) getOrginalMessage().getExtra();
            PersonalResIdl personalResIdl = (PersonalResIdl) new Wire(new Class[0]).parseFrom(bArr, PersonalResIdl.class);
            if (personalResIdl != null) {
                setError(personalResIdl.error.errorno.intValue());
                setErrorString(personalResIdl.error.usermsg);
                if (getError() != 0) {
                    return personalResIdl;
                }
                d08 personCenterData = personPolymericReqMsg.getPersonCenterData();
                if (personalResIdl.data != null && personCenterData != null) {
                    personCenterData.a(personalResIdl);
                }
            }
            return personalResIdl;
        }
        return invokeIL.objValue;
    }
}
