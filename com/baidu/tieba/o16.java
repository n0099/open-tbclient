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
/* loaded from: classes7.dex */
public class o16 extends z5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o16() {
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
    @Override // com.baidu.tieba.w5
    public /* bridge */ /* synthetic */ SocketResponsedMessage g(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        i(socketResponsedMessage2);
        return socketResponsedMessage2;
    }

    public SocketResponsedMessage i(SocketResponsedMessage socketResponsedMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage)) == null) {
            if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                w16 addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
                this.a = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
                if (addressListData != null) {
                    for (a26 a26Var : addressListData.a()) {
                        List<y95> a = a26Var.a();
                        ArrayList arrayList = new ArrayList();
                        for (y95 y95Var : a) {
                            if (!this.a && y95Var.h() == 1) {
                                arrayList.add(y95Var);
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
