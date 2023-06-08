package com.baidu.tieba;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.addresslist.relationship.ResponseGetAddressListMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class v66 extends hb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v66() {
        super(304001);
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.ResponsedMessage' to match base method */
    @Override // com.baidu.tieba.eb
    public /* bridge */ /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        c(socketResponsedMessage2);
        return socketResponsedMessage2;
    }

    public SocketResponsedMessage c(SocketResponsedMessage socketResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage)) == null) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                d76 addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                this.a = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
                if (addressListData != null) {
                    for (h76 h76Var : addressListData.a()) {
                        List<ef5> a = h76Var.a();
                        ArrayList arrayList = new ArrayList();
                        for (ef5 ef5Var : a) {
                            if (!this.a && ef5Var.h() == 1) {
                                arrayList.add(ef5Var);
                            }
                        }
                        a.removeAll(arrayList);
                    }
                }
            }
            return socketResponsedMessage;
        }
        return (SocketResponsedMessage) invokeL.objValue;
    }
}
