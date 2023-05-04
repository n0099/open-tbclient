package com.baidu.tieba.newdetail;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.a9;
import com.baidu.tieba.ar8;
import com.baidu.tieba.ay7;
import com.baidu.tieba.cr8;
import com.baidu.tieba.cz4;
import com.baidu.tieba.dy7;
import com.baidu.tieba.ey7;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.tieba.ii;
import com.baidu.tieba.iw4;
import com.baidu.tieba.iy7;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.za;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HotTopicDetailModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ar8 a;
    @Nullable
    public d b;
    public boolean c;
    public boolean d;
    public long e;
    public String f;
    public String g;
    public TbPageContext<HotTopicDetailActivity> h;
    public double i;
    public int j;
    public int k;

    /* loaded from: classes5.dex */
    public interface d {
        void p(int i, @Nullable dy7 dy7Var);
    }

    /* loaded from: classes5.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HotTopicDetailModel hotTopicDetailModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = hotTopicDetailModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            boolean z = this.a.c;
            this.a.c = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z2 = responsedMessage instanceof ResponseHttpHotTopicMessage;
            if ((!z2 && !(responsedMessage instanceof ResponseSocketHotTopicMessage)) || responsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId()) {
                return;
            }
            ey7 ey7Var = null;
            if (z2) {
                ResponseHttpHotTopicMessage responseHttpHotTopicMessage = (ResponseHttpHotTopicMessage) responsedMessage;
                if (responseHttpHotTopicMessage.getHotTopicData() != null) {
                    ey7Var = responseHttpHotTopicMessage.getHotTopicData();
                }
            }
            if (responsedMessage instanceof ResponseSocketHotTopicMessage) {
                ResponseSocketHotTopicMessage responseSocketHotTopicMessage = (ResponseSocketHotTopicMessage) responsedMessage;
                if (responseSocketHotTopicMessage.getHotTopicData() != null) {
                    ey7Var = responseSocketHotTopicMessage.getHotTopicData();
                }
            }
            int i = -1;
            if (ey7Var != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                int intValue = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                ey7Var.p = intValue;
                dy7 dy7Var = ey7Var.k;
                if (dy7Var != null) {
                    dy7Var.d = intValue;
                }
                if (ey7Var.p == -1) {
                    this.a.c = z;
                }
            }
            if (this.a.a != null) {
                if (ey7Var != null) {
                    i = responsedMessage.getError();
                }
                this.a.a.o0(i, ey7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HotTopicDetailModel hotTopicDetailModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = hotTopicDetailModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.c = false;
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage;
            if ((!z && !(responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) || responsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId()) {
                return;
            }
            dy7 dy7Var = null;
            if (z) {
                ResponseHttpGetTopicRelateThreadMessage responseHttpGetTopicRelateThreadMessage = (ResponseHttpGetTopicRelateThreadMessage) responsedMessage;
                if (responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                    dy7Var = responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData();
                }
            }
            if (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) {
                ResponseSocketGetTopicRelateThreadMessage responseSocketGetTopicRelateThreadMessage = (ResponseSocketGetTopicRelateThreadMessage) responsedMessage;
                if (responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                    dy7Var = responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData();
                }
            }
            if (dy7Var != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                dy7Var.d = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
            }
            if (dy7Var != null) {
                i = responsedMessage.getError();
            } else {
                i = -1;
            }
            if (this.a.a != null) {
                this.a.a.p(i, dy7Var);
            }
            if (this.a.b != null) {
                this.a.b.p(i, dy7Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicDetailModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(HotTopicDetailModel hotTopicDetailModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicDetailModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = hotTopicDetailModel;
        }

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BlessHttpResponseMessage;
            if ((!z && !(responsedMessage instanceof BlessSocketResponseMessage)) || responsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId()) {
                return;
            }
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
            if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                int intValue = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                if (intValue == 1 || intValue == 2) {
                    this.a.d = false;
                }
                i = intValue;
            } else {
                i = -1;
            }
            if (this.a.a != null) {
                if (j4 != 0) {
                    i2 = responsedMessage.getError();
                } else {
                    i2 = -1;
                }
                this.a.a.q1(i2, j4, j3, i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.j = ii.l(TbadkCoreApplication.getInst().getApp());
        this.k = ii.j(TbadkCoreApplication.getInst().getApp());
        f0();
    }

    public boolean h0(ay7 ay7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ay7Var)) == null) {
            int i = 0;
            if (ay7Var == null || !BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                return false;
            }
            RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
            requestBlessMessage.setPkId(Long.valueOf(ay7Var.c));
            requestBlessMessage.setTopicId(Long.valueOf(this.e));
            requestBlessMessage.setPkIndex(1);
            if (ay7Var.d != 0) {
                i = 1;
            }
            requestBlessMessage.setClickType(i);
            requestBlessMessage.setPkType(1);
            requestBlessMessage.setUserPkId(ay7Var.d);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailModel(TbPageContext<?> tbPageContext, ar8 ar8Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ar8Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.j = ii.l(TbadkCoreApplication.getInst().getApp());
        this.k = ii.j(TbadkCoreApplication.getInst().getApp());
        f0();
        this.a = ar8Var;
        this.h = tbPageContext;
    }

    public void e0(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, intent) == null) && intent != null && intent.getIntExtra("extra_share_status", 2) == 1) {
            cr8.f(this.h, "c14390");
        }
    }

    public void j0(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.g = str;
        }
    }

    public void k0(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048587, this, j, str) == null) {
            this.e = j;
            this.f = str;
        }
    }

    public boolean V(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (BdNetTypeUtil.isNetworkAvailableForImmediately() && !this.c) {
                cancelLoadData();
                RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
                requestHotTopicMessage.setTopicId(Long.valueOf(this.e));
                requestHotTopicMessage.setTopicName(this.f);
                requestHotTopicMessage.setCall_from(l0(this.g));
                requestHotTopicMessage.setSort_type(Integer.valueOf(i));
                requestHotTopicMessage.setScrH(Integer.valueOf(this.k));
                requestHotTopicMessage.setScrW(Integer.valueOf(this.j));
                requestHotTopicMessage.setSrcDip(Double.valueOf(this.i));
                requestHotTopicMessage.setQType(Integer.valueOf(iw4.c().e()));
                if (requestHotTopicMessage.getHttpMessage() != null) {
                    requestHotTopicMessage.getHttpMessage().setExtra(Integer.valueOf(i));
                    requestHotTopicMessage.getHttpMessage().setTag(getUniqueId());
                }
                if (requestHotTopicMessage.getSocketMessage() != null) {
                    requestHotTopicMessage.getSocketMessage().setExtra(Integer.valueOf(i));
                    requestHotTopicMessage.getSocketMessage().setTag(getUniqueId());
                }
                requestHotTopicMessage.setTag(this.unique_id);
                boolean sendMessage = MessageManager.getInstance().sendMessage(requestHotTopicMessage);
                this.c = sendMessage;
                return sendMessage;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean W(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (BdNetTypeUtil.isNetworkAvailableForImmediately() && !this.c) {
                cancelLoadData();
                RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
                requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.e));
                requestGetTopicRelateThreadMessage.setTopicName(this.f);
                requestGetTopicRelateThreadMessage.setRn(10);
                requestGetTopicRelateThreadMessage.setPageNo(1);
                requestGetTopicRelateThreadMessage.setLastId(0L);
                requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i));
                requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(this.k));
                requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(this.j));
                requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(this.i));
                if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
                    requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i));
                    requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
                }
                if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
                    requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i));
                    requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
                }
                requestGetTopicRelateThreadMessage.setTag(this.unique_id);
                boolean sendMessage = MessageManager.getInstance().sendMessage(requestGetTopicRelateThreadMessage);
                this.c = sendMessage;
                return sendMessage;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean X(int i, cz4 cz4Var, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), cz4Var, Long.valueOf(j)})) == null) {
            if (BdNetTypeUtil.isNetworkAvailableForImmediately() && !this.c) {
                cancelLoadData();
                RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
                requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.e));
                requestGetTopicRelateThreadMessage.setTopicName(this.f);
                requestGetTopicRelateThreadMessage.setRn(10);
                requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(cz4Var.a() + 1));
                requestGetTopicRelateThreadMessage.setLastId(Long.valueOf(j));
                requestGetTopicRelateThreadMessage.setSort_type(Integer.valueOf(i));
                requestGetTopicRelateThreadMessage.setScrH(Integer.valueOf(this.k));
                requestGetTopicRelateThreadMessage.setScrW(Integer.valueOf(this.j));
                requestGetTopicRelateThreadMessage.setScrDip(Double.valueOf(this.i));
                if (requestGetTopicRelateThreadMessage.getHttpMessage() != null) {
                    requestGetTopicRelateThreadMessage.getHttpMessage().setExtra(Integer.valueOf(i));
                    requestGetTopicRelateThreadMessage.getHttpMessage().setTag(getUniqueId());
                }
                if (requestGetTopicRelateThreadMessage.getSocketMessage() != null) {
                    requestGetTopicRelateThreadMessage.getSocketMessage().setExtra(Integer.valueOf(i));
                    requestGetTopicRelateThreadMessage.getSocketMessage().setTag(getUniqueId());
                }
                requestGetTopicRelateThreadMessage.setTag(this.unique_id);
                boolean sendMessage = MessageManager.getInstance().sendMessage(requestGetTopicRelateThreadMessage);
                this.c = sendMessage;
                return sendMessage;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            cancelMessage();
            this.c = false;
            return false;
        }
        return invokeV.booleanValue;
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            cr8.f(this.h, "c14392");
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return V(1);
        }
        return invokeV.booleanValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            registerListener(new a(this, CmdConfigHttp.CMD_HOT_TOPIC, 303050));
            registerListener(new b(this, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005));
            registerListener(new c(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085));
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            return;
        }
        RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
        requestHotTopicMessage.setTopicId(Long.valueOf(this.e));
        requestHotTopicMessage.setTopicName(this.f);
        requestHotTopicMessage.setCall_from(l0(this.g));
        requestHotTopicMessage.setSort_type(1);
        requestHotTopicMessage.setScrH(Integer.valueOf(this.k));
        requestHotTopicMessage.setScrW(Integer.valueOf(this.j));
        requestHotTopicMessage.setSrcDip(Double.valueOf(this.i));
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

    public boolean i0(iy7 iy7Var, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, iy7Var, i)) == null) {
            if (iy7Var == null || !BdNetTypeUtil.isNetworkAvailableForImmediately() || this.d) {
                return false;
            }
            RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
            requestBlessMessage.setPkId(Long.valueOf(iy7Var.g));
            requestBlessMessage.setTopicId(Long.valueOf(this.e));
            requestBlessMessage.setPkIndex(i);
            if (iy7Var.h == 0) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            requestBlessMessage.setClickType(i2);
            requestBlessMessage.setPkType(0);
            requestBlessMessage.setUserPkId(iy7Var.h);
            requestBlessMessage.setTag(this.unique_id);
            if (requestBlessMessage.getHttpMessage() != null) {
                requestBlessMessage.getHttpMessage().setExtra(Integer.valueOf(i));
                requestBlessMessage.getHttpMessage().setTag(getUniqueId());
            }
            if (requestBlessMessage.getSocketMessage() != null) {
                requestBlessMessage.getSocketMessage().setExtra(Integer.valueOf(i));
                requestBlessMessage.getSocketMessage().setTag(getUniqueId());
            }
            boolean sendMessage = MessageManager.getInstance().sendMessage(requestBlessMessage);
            this.d = sendMessage;
            return sendMessage;
        }
        return invokeLI.booleanValue;
    }

    public final int l0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
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
            if (!"5".equals(str)) {
                return 1;
            }
            return 5;
        }
        return invokeL.intValue;
    }
}
