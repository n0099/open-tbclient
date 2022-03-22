package com.baidu.tieba.setting.officialAccountPush;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetOfficialSwitch.OfficialList;
/* loaded from: classes5.dex */
public class OfficialAccountPushModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public static int NET_SUCCESS;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.d.c.g.a f35921b;
    public ArrayList<OfficialAccountPushInfo> list;
    public List<OfficialList> official_list;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialAccountPushModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OfficialAccountPushModel officialAccountPushModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialAccountPushModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialAccountPushModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            OfficialAccountPushHttpResponseMessage officialAccountPushHttpResponseMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof OfficialAccountPushSocketResponseMessage) {
                    OfficialAccountPushSocketResponseMessage officialAccountPushSocketResponseMessage = (OfficialAccountPushSocketResponseMessage) responsedMessage;
                    if (officialAccountPushSocketResponseMessage == null || officialAccountPushSocketResponseMessage.getList() == null) {
                        return;
                    }
                    this.a.a.a(officialAccountPushSocketResponseMessage.getList(), officialAccountPushSocketResponseMessage.getError(), officialAccountPushSocketResponseMessage.getErrorString());
                }
                if (!(responsedMessage instanceof OfficialAccountPushHttpResponseMessage) || (officialAccountPushHttpResponseMessage = (OfficialAccountPushHttpResponseMessage) responsedMessage) == null) {
                    return;
                }
                this.a.a.a(officialAccountPushHttpResponseMessage.getList(), officialAccountPushHttpResponseMessage.getError(), officialAccountPushHttpResponseMessage.getErrorString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(ArrayList<OfficialAccountPushInfo> arrayList, int i, String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1195144270, "Lcom/baidu/tieba/setting/officialAccountPush/OfficialAccountPushModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1195144270, "Lcom/baidu/tieba/setting/officialAccountPush/OfficialAccountPushModel;");
        }
    }

    public OfficialAccountPushModel(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.list = new ArrayList<>();
        a aVar = new a(this, CmdConfigHttp.CMD_OFFICIAL_ACCOUNT_PUSH, 309620);
        this.f35921b = aVar;
        this.a = bVar;
        registerListener(aVar);
        c.a.p0.a4.g0.a.f(309620, OfficialAccountPushSocketResponseMessage.class, false);
        c.a.p0.a4.g0.a.c(309620, CmdConfigHttp.CMD_OFFICIAL_ACCOUNT_PUSH, TbConfig.CHECK_OFFICIAL_SWITCH_URL, OfficialAccountPushHttpResponseMessage.class, true, false, true, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            super.cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f35921b);
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            sendMessage(new OfficialAccountPushRequestMessage());
        }
    }
}
