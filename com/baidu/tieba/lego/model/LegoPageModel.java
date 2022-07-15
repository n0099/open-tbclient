package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.br4;
import com.repackage.d9;
import com.repackage.te;
import com.repackage.wh8;
import com.repackage.yd7;
import com.repackage.za;
import tbclient.Lego.DataRes;
/* loaded from: classes3.dex */
public class LegoPageModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public za a;
    public b b;

    /* loaded from: classes3.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoPageModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LegoPageModel legoPageModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoPageModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = legoPageModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
        @Override // com.repackage.za
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            String str;
            boolean z;
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.a.b == null) {
                return;
            }
            boolean z2 = false;
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof LegoPageRequest) {
                    LegoPageRequest legoPageRequest = (LegoPageRequest) extra;
                    long tagCode = legoPageRequest.getTagCode();
                    String itemId = legoPageRequest.getItemId();
                    int pn = legoPageRequest.getPn();
                    boolean z3 = legoPageRequest.getPn() == 1;
                    j = tagCode;
                    z2 = legoPageRequest.getPageType() == 2;
                    str = itemId;
                    i = pn;
                    z = z3;
                    if (responsedMessage.getError() == 0) {
                        this.a.b.b(j, str, responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    DataRes dataRes = null;
                    if (responsedMessage instanceof LegoSocketResponse) {
                        dataRes = ((LegoSocketResponse) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof LegoHttpResponse) {
                        dataRes = ((LegoHttpResponse) responsedMessage).getResultData();
                    }
                    if (!z2) {
                        this.a.b.a(j, str, dataRes, z);
                    } else {
                        if (z && dataRes != null) {
                            br4.f();
                            te<byte[]> d = br4.d("tb.lego_update");
                            StringBuilder sb = new StringBuilder();
                            sb.append(j);
                            sb.append("_");
                            sb.append(TextUtils.isEmpty(str) ? "" : str);
                            d.a(sb.toString(), dataRes.toByteArray());
                        }
                        this.a.b.c(j, str, dataRes, z, i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, dataRes));
                    return;
                }
            }
            j = 0;
            str = "";
            z = false;
            i = 1;
            if (responsedMessage.getError() == 0) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(long j, String str, DataRes dataRes, boolean z);

        void b(long j, String str, int i, String str2);

        void c(long j, String str, DataRes dataRes, boolean z, int i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoPageModel(d9 d9Var, BdUniqueId bdUniqueId) {
        super(d9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d9Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this, CmdConfigHttp.CMD_ENTERTAINMENT, 309312);
        setUniqueId(bdUniqueId);
        registerHttpTask();
        this.a.getSocketMessageListener().setSelfListener(true);
        this.a.getHttpMessageListener().setSelfListener(true);
        registerListener(this.a);
    }

    public void B(int i, long j, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), str, Integer.valueOf(i2), str2}) == null) {
            LegoPageRequest legoPageRequest = new LegoPageRequest();
            legoPageRequest.setNetType(NetMessage.NetType.HTTP);
            legoPageRequest.setTag(getUniqueId());
            legoPageRequest.setPn(i2);
            legoPageRequest.setItemId(str);
            legoPageRequest.setLastRank(str2);
            legoPageRequest.setTagCode(j);
            legoPageRequest.setPageType(i);
            yd7 a2 = yd7.a(j, str);
            if (a2 != null) {
                legoPageRequest.setRn(a2.d);
                legoPageRequest.setParams(a2.e);
            }
            legoPageRequest.getHttpMessage().addParam("page_id", j);
            sendMessage(legoPageRequest);
        }
    }

    public void C(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.b = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerHttpTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ENTERTAINMENT, wh8.a(TbConfig.ENTERTAINMENT_ADDRESS, 309312));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(LegoHttpResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
