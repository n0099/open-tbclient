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
import d.a.c.a.f;
import d.a.c.e.d.l;
import d.a.s0.n1.p.e;
import tbclient.Lego.DataRes;
/* loaded from: classes5.dex */
public class LegoPageModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f18275e;

    /* renamed from: f  reason: collision with root package name */
    public b f18276f;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LegoPageModel f18277a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LegoPageModel legoPageModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {legoPageModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18277a = legoPageModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            String str;
            boolean z;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.f18277a.f18276f == null) {
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
                    i2 = pn;
                    z = z3;
                    if (responsedMessage.getError() == 0) {
                        this.f18277a.f18276f.b(j, str, responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    DataRes dataRes = null;
                    if (responsedMessage instanceof LegoSocketResponse) {
                        dataRes = ((LegoSocketResponse) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof LegoHttpResponse) {
                        dataRes = ((LegoHttpResponse) responsedMessage).getResultData();
                    }
                    if (!z2) {
                        this.f18277a.f18276f.a(j, str, dataRes, z);
                    } else {
                        if (z && dataRes != null) {
                            l<byte[]> d2 = d.a.r0.r.r.a.f().d("tb.lego_update");
                            StringBuilder sb = new StringBuilder();
                            sb.append(j);
                            sb.append("_");
                            sb.append(TextUtils.isEmpty(str) ? "" : str);
                            d2.a(sb.toString(), dataRes.toByteArray());
                        }
                        this.f18277a.f18276f.c(j, str, dataRes, z, i2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, dataRes));
                    return;
                }
            }
            j = 0;
            str = "";
            z = false;
            i2 = 1;
            if (responsedMessage.getError() == 0) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(long j, String str, DataRes dataRes, boolean z);

        void b(long j, String str, int i2, String str2);

        void c(long j, String str, DataRes dataRes, boolean z, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LegoPageModel(f fVar, BdUniqueId bdUniqueId) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18275e = new a(this, CmdConfigHttp.CMD_ENTERTAINMENT, 309312);
        setUniqueId(bdUniqueId);
        y();
        this.f18275e.getSocketMessageListener().setSelfListener(true);
        this.f18275e.getHttpMessageListener().setSelfListener(true);
        registerListener(this.f18275e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void x(int i2, long j, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i3), str2}) == null) {
            LegoPageRequest legoPageRequest = new LegoPageRequest();
            legoPageRequest.setNetType(NetMessage.NetType.HTTP);
            legoPageRequest.setTag(getUniqueId());
            legoPageRequest.setPn(i3);
            legoPageRequest.setItemId(str);
            legoPageRequest.setLastRank(str2);
            legoPageRequest.setTagCode(j);
            legoPageRequest.setPageType(i2);
            e a2 = e.a(j, str);
            if (a2 != null) {
                legoPageRequest.setRn(a2.f63906d);
                legoPageRequest.setParams(a2.f63907e);
            }
            legoPageRequest.getHttpMessage().addParam("page_id", j);
            sendMessage(legoPageRequest);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ENTERTAINMENT, d.a.s0.h3.d0.a.a(TbConfig.ENTERTAINMENT_ADDRESS, 309312));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(LegoHttpResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void z(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f18276f = bVar;
        }
    }
}
