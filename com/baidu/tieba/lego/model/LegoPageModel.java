package com.baidu.tieba.lego.model;

import android.text.TextUtils;
import c.a.d.a.f;
import c.a.d.f.d.l;
import c.a.r0.w1.p.e;
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
import tbclient.Lego.DataRes;
/* loaded from: classes10.dex */
public class LegoPageModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c.a.d.c.g.a f46705e;

    /* renamed from: f  reason: collision with root package name */
    public b f46706f;

    /* loaded from: classes10.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LegoPageModel a;

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
            this.a = legoPageModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
        @Override // c.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j2;
            String str;
            boolean z;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.a.f46706f == null) {
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
                    j2 = tagCode;
                    z2 = legoPageRequest.getPageType() == 2;
                    str = itemId;
                    i2 = pn;
                    z = z3;
                    if (responsedMessage.getError() == 0) {
                        this.a.f46706f.b(j2, str, responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    DataRes dataRes = null;
                    if (responsedMessage instanceof LegoSocketResponse) {
                        dataRes = ((LegoSocketResponse) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof LegoHttpResponse) {
                        dataRes = ((LegoHttpResponse) responsedMessage).getResultData();
                    }
                    if (!z2) {
                        this.a.f46706f.a(j2, str, dataRes, z);
                    } else {
                        if (z && dataRes != null) {
                            c.a.q0.s.r.a.f();
                            l<byte[]> d2 = c.a.q0.s.r.a.d("tb.lego_update");
                            StringBuilder sb = new StringBuilder();
                            sb.append(j2);
                            sb.append("_");
                            sb.append(TextUtils.isEmpty(str) ? "" : str);
                            d2.a(sb.toString(), dataRes.toByteArray());
                        }
                        this.a.f46706f.c(j2, str, dataRes, z, i2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016455, dataRes));
                    return;
                }
            }
            j2 = 0;
            str = "";
            z = false;
            i2 = 1;
            if (responsedMessage.getError() == 0) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(long j2, String str, DataRes dataRes, boolean z);

        void b(long j2, String str, int i2, String str2);

        void c(long j2, String str, DataRes dataRes, boolean z, int i2);
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
        this.f46705e = new a(this, CmdConfigHttp.CMD_ENTERTAINMENT, 309312);
        setUniqueId(bdUniqueId);
        y();
        this.f46705e.getSocketMessageListener().setSelfListener(true);
        this.f46705e.getHttpMessageListener().setSelfListener(true);
        registerListener(this.f46705e);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            cancelMessage();
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

    public void x(int i2, long j2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, Integer.valueOf(i3), str2}) == null) {
            LegoPageRequest legoPageRequest = new LegoPageRequest();
            legoPageRequest.setNetType(NetMessage.NetType.HTTP);
            legoPageRequest.setTag(getUniqueId());
            legoPageRequest.setPn(i3);
            legoPageRequest.setItemId(str);
            legoPageRequest.setLastRank(str2);
            legoPageRequest.setTagCode(j2);
            legoPageRequest.setPageType(i2);
            e a2 = e.a(j2, str);
            if (a2 != null) {
                legoPageRequest.setRn(a2.f25179d);
                legoPageRequest.setParams(a2.f25180e);
            }
            legoPageRequest.getHttpMessage().addParam("page_id", j2);
            sendMessage(legoPageRequest);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ENTERTAINMENT, c.a.r0.t3.f0.a.a(TbConfig.ENTERTAINMENT_ADDRESS, 309312));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(LegoHttpResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void z(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f46706f = bVar;
        }
    }
}
