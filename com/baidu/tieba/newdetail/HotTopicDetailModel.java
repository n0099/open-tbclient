package com.baidu.tieba.newdetail;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.s.q.a1;
import d.a.q0.g1.c.d;
import d.a.q0.g1.c.e;
import d.a.q0.g1.c.i;
/* loaded from: classes4.dex */
public class HotTopicDetailModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.b2.a f18853e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18854f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18855g;

    /* renamed from: h  reason: collision with root package name */
    public long f18856h;

    /* renamed from: i  reason: collision with root package name */
    public String f18857i;
    public String j;
    public double k;
    public int l;
    public int m;

    /* loaded from: classes4.dex */
    public class a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailModel f18858a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotTopicDetailModel hotTopicDetailModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f18858a = hotTopicDetailModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0094  */
        @Override // d.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            e eVar;
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            boolean z = this.f18858a.f18854f;
            this.f18858a.f18854f = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z2 = responsedMessage instanceof ResponseHttpHotTopicMessage;
            if ((!z2 && !(responsedMessage instanceof ResponseSocketHotTopicMessage)) || responsedMessage.getOrginalMessage().getTag() != this.f18858a.getUniqueId()) {
                return;
            }
            if (z2) {
                ResponseHttpHotTopicMessage responseHttpHotTopicMessage = (ResponseHttpHotTopicMessage) responsedMessage;
                if (responseHttpHotTopicMessage.getHotTopicData() != null) {
                    eVar = responseHttpHotTopicMessage.getHotTopicData();
                    if (responsedMessage instanceof ResponseSocketHotTopicMessage) {
                        ResponseSocketHotTopicMessage responseSocketHotTopicMessage = (ResponseSocketHotTopicMessage) responsedMessage;
                        if (responseSocketHotTopicMessage.getHotTopicData() != null) {
                            eVar = responseSocketHotTopicMessage.getHotTopicData();
                        }
                    }
                    if (eVar != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                        int intValue = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                        eVar.s = intValue;
                        dVar = eVar.k;
                        if (dVar != null) {
                            dVar.U3 = intValue;
                        }
                        if (eVar.s == -1) {
                            this.f18858a.f18854f = z;
                        }
                    }
                    if (eVar == null) {
                        this.f18858a.f18853e.netCallback(responsedMessage.getError(), eVar);
                        return;
                    } else {
                        this.f18858a.f18853e.netCallback(-1, null);
                        return;
                    }
                }
            }
            eVar = null;
            if (responsedMessage instanceof ResponseSocketHotTopicMessage) {
            }
            if (eVar != null) {
                int intValue2 = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                eVar.s = intValue2;
                dVar = eVar.k;
                if (dVar != null) {
                }
                if (eVar.s == -1) {
                }
            }
            if (eVar == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailModel f18859a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HotTopicDetailModel hotTopicDetailModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f18859a = hotTopicDetailModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x007e  */
        @Override // d.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d dVar;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.f18859a.f18854f = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage;
            if ((!z && !(responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) || responsedMessage.getOrginalMessage().getTag() != this.f18859a.getUniqueId()) {
                return;
            }
            if (z) {
                ResponseHttpGetTopicRelateThreadMessage responseHttpGetTopicRelateThreadMessage = (ResponseHttpGetTopicRelateThreadMessage) responsedMessage;
                if (responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                    dVar = responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData();
                    if (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) {
                        ResponseSocketGetTopicRelateThreadMessage responseSocketGetTopicRelateThreadMessage = (ResponseSocketGetTopicRelateThreadMessage) responsedMessage;
                        if (responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                            dVar = responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData();
                        }
                    }
                    if (dVar != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                        dVar.U3 = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                    }
                    if (dVar == null) {
                        this.f18859a.f18853e.netLoadMoreCallback(responsedMessage.getError(), dVar);
                        return;
                    } else {
                        this.f18859a.f18853e.netLoadMoreCallback(-1, null);
                        return;
                    }
                }
            }
            dVar = null;
            if (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) {
            }
            if (dVar != null) {
                dVar.U3 = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
            }
            if (dVar == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicDetailModel f18860a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HotTopicDetailModel hotTopicDetailModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f18860a = hotTopicDetailModel;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BlessHttpResponseMessage;
            if ((z || (responsedMessage instanceof BlessSocketResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.f18860a.getUniqueId()) {
                if (z) {
                    BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                    j = blessHttpResponseMessage.userPkId;
                    j2 = blessHttpResponseMessage.pkID;
                } else {
                    j = 0;
                    j2 = 0;
                }
                if (responsedMessage instanceof BlessSocketResponseMessage) {
                    BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                    j = blessSocketResponseMessage.userPkId;
                    j2 = blessSocketResponseMessage.pkID;
                }
                long j3 = j;
                long j4 = j2;
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                    i2 = -1;
                } else {
                    int intValue = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                    if (intValue == 1 || intValue == 2) {
                        this.f18860a.f18855g = false;
                    }
                    i2 = intValue;
                }
                if (j4 != 0) {
                    this.f18860a.f18853e.netPkCallback(responsedMessage.getError(), j4, j3, i2);
                } else {
                    this.f18860a.f18853e.netPkCallback(-1, j4, j3, i2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailModel(TbPageContext<?> tbPageContext, d.a.q0.b2.a aVar) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
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
        this.k = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.l = l.k(TbadkCoreApplication.getInst().getApp());
        this.m = l.i(TbadkCoreApplication.getInst().getApp());
        D();
        this.f18853e = aVar;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            registerListener(new a(this, CmdConfigHttp.CMD_HOT_TOPIC, 303050));
            registerListener(new b(this, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005));
            registerListener(new c(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085));
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && j.A()) {
            RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
            requestHotTopicMessage.setTopicId(Long.valueOf(this.f18856h));
            requestHotTopicMessage.setTopicName(this.f18857i);
            requestHotTopicMessage.setCall_from(I(this.j));
            requestHotTopicMessage.setSort_type(1);
            requestHotTopicMessage.setScrH(Integer.valueOf(this.m));
            requestHotTopicMessage.setScrW(Integer.valueOf(this.l));
            requestHotTopicMessage.setSrcDip(Double.valueOf(this.k));
            if (requestHotTopicMessage.getHttpMessage() != null) {
                requestHotTopicMessage.getHttpMessage().setExtra(-1);
                requestHotTopicMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestHotTopicMessage.getSocketMessage() != null) {
                requestHotTopicMessage.getSocketMessage().setExtra(-1);
                requestHotTopicMessage.getSocketMessage().setTag(getUniqueId());
            }
            requestHotTopicMessage.setTag(this.unique_id);
            MessageManager.getInstance().sendMessage(requestHotTopicMessage);
        }
    }

    public boolean F(d.a.q0.g1.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar)) == null) {
            if (aVar == null || !j.A()) {
                return false;
            }
            RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
            requestBlessMessage.setPkId(Long.valueOf(aVar.f56938g));
            requestBlessMessage.setTopicId(Long.valueOf(this.f18856h));
            requestBlessMessage.setPkIndex(1);
            requestBlessMessage.setClickType(aVar.f56939h != 0 ? 1 : 0);
            requestBlessMessage.setPkType(1);
            requestBlessMessage.setUserPkId(aVar.f56939h);
            requestBlessMessage.setTag(this.unique_id);
            if (requestBlessMessage.getHttpMessage() != null) {
                requestBlessMessage.getHttpMessage().setExtra(0);
                requestBlessMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestBlessMessage.getSocketMessage() != null) {
                requestBlessMessage.getSocketMessage().setExtra(0);
                requestBlessMessage.getSocketMessage().setTag(getUniqueId());
            }
            return MessageManager.getInstance().sendMessage(requestBlessMessage);
        }
        return invokeL.booleanValue;
    }

    public boolean G(i iVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, iVar, i2)) == null) {
            if (iVar == null || !j.A() || this.f18855g) {
                return false;
            }
            RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
            requestBlessMessage.setPkId(Long.valueOf(iVar.l));
            requestBlessMessage.setTopicId(Long.valueOf(this.f18856h));
            requestBlessMessage.setPkIndex(i2);
            requestBlessMessage.setClickType(iVar.m == 0 ? 0 : 1);
            requestBlessMessage.setPkType(0);
            requestBlessMessage.setUserPkId(iVar.m);
            requestBlessMessage.setTag(this.unique_id);
            if (requestBlessMessage.getHttpMessage() != null) {
                requestBlessMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
                requestBlessMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestBlessMessage.getSocketMessage() != null) {
                requestBlessMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
                requestBlessMessage.getSocketMessage().setTag(getUniqueId());
            }
            boolean sendMessage = MessageManager.getInstance().sendMessage(requestBlessMessage);
            this.f18855g = sendMessage;
            return sendMessage;
        }
        return invokeLI.booleanValue;
    }

    public void H(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048580, this, j, str) == null) {
            this.f18856h = j;
            this.f18857i = str;
        }
    }

    public final int I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if ("1".equals(str)) {
                return 1;
            }
            if ("2".equals(str)) {
                return 2;
            }
            if ("3".equals(str)) {
                return 3;
            }
            if ("4".equals(str)) {
                return 4;
            }
            return "5".equals(str) ? 5 : 1;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? w(1) : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.j = str;
        }
    }

    public boolean w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (!j.A() || this.f18854f) {
                return false;
            }
            cancelLoadData();
            RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
            requestHotTopicMessage.setTopicId(Long.valueOf(this.f18856h));
            requestHotTopicMessage.setTopicName(this.f18857i);
            requestHotTopicMessage.setCall_from(I(this.j));
            requestHotTopicMessage.setSort_type(Integer.valueOf(i2));
            requestHotTopicMessage.setScrH(Integer.valueOf(this.m));
            requestHotTopicMessage.setScrW(Integer.valueOf(this.l));
            requestHotTopicMessage.setSrcDip(Double.valueOf(this.k));
            if (requestHotTopicMessage.getHttpMessage() != null) {
                requestHotTopicMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
                requestHotTopicMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestHotTopicMessage.getSocketMessage() != null) {
                requestHotTopicMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
                requestHotTopicMessage.getSocketMessage().setTag(getUniqueId());
            }
            requestHotTopicMessage.setTag(this.unique_id);
            boolean sendMessage = MessageManager.getInstance().sendMessage(requestHotTopicMessage);
            this.f18854f = sendMessage;
            return sendMessage;
        }
        return invokeI.booleanValue;
    }

    public boolean x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            if (!j.A() || this.f18854f) {
                return false;
            }
            cancelLoadData();
            RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
            requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.f18856h));
            requestGetTopicRelateThreadMessage.setTopicName(this.f18857i);
            requestGetTopicRelateThreadMessage.setRn(10);
            requestGetTopicRelateThreadMessage.setPageNo(1);
            requestGetTopicRelateThreadMessage.setLastId(0L);
            requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i2));
            requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(this.m));
            requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(this.l));
            requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(this.k));
            if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
                requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
                requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
                requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
                requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
            }
            requestGetTopicRelateThreadMessage.setTag(this.unique_id);
            boolean sendMessage = MessageManager.getInstance().sendMessage(requestGetTopicRelateThreadMessage);
            this.f18854f = sendMessage;
            return sendMessage;
        }
        return invokeI.booleanValue;
    }

    public boolean y(int i2, a1 a1Var, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), a1Var, Long.valueOf(j)})) == null) {
            if (!j.A() || this.f18854f) {
                return false;
            }
            cancelLoadData();
            RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
            requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.f18856h));
            requestGetTopicRelateThreadMessage.setTopicName(this.f18857i);
            requestGetTopicRelateThreadMessage.setRn(10);
            requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(a1Var.a() + 1));
            requestGetTopicRelateThreadMessage.setLastId(Long.valueOf(j));
            requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i2));
            requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(this.m));
            requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(this.l));
            requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(this.k));
            if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
                requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i2));
                requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
                requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i2));
                requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
            }
            requestGetTopicRelateThreadMessage.setTag(this.unique_id);
            boolean sendMessage = MessageManager.getInstance().sendMessage(requestGetTopicRelateThreadMessage);
            this.f18854f = sendMessage;
            return sendMessage;
        }
        return invokeCommon.booleanValue;
    }
}
