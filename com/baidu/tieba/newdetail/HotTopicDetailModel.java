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
import com.baidu.tieba.a77;
import com.baidu.tieba.ej;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.hottopic.message.RequestGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.RequestHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseHttpHotTopicMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketGetTopicRelateThreadMessage;
import com.baidu.tieba.hottopic.message.ResponseSocketHotTopicMessage;
import com.baidu.tieba.hq4;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.mq7;
import com.baidu.tieba.oq7;
import com.baidu.tieba.pb;
import com.baidu.tieba.r9;
import com.baidu.tieba.s67;
import com.baidu.tieba.v67;
import com.baidu.tieba.w67;
import com.baidu.tieba.zs4;
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
    public mq7 a;
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
    public class a extends pb {
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

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = this.a.c;
                this.a.c = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z2 = responsedMessage instanceof ResponseHttpHotTopicMessage;
                if ((z2 || (responsedMessage instanceof ResponseSocketHotTopicMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                    w67 w67Var = null;
                    if (z2) {
                        ResponseHttpHotTopicMessage responseHttpHotTopicMessage = (ResponseHttpHotTopicMessage) responsedMessage;
                        if (responseHttpHotTopicMessage.getHotTopicData() != null) {
                            w67Var = responseHttpHotTopicMessage.getHotTopicData();
                        }
                    }
                    if (responsedMessage instanceof ResponseSocketHotTopicMessage) {
                        ResponseSocketHotTopicMessage responseSocketHotTopicMessage = (ResponseSocketHotTopicMessage) responsedMessage;
                        if (responseSocketHotTopicMessage.getHotTopicData() != null) {
                            w67Var = responseSocketHotTopicMessage.getHotTopicData();
                        }
                    }
                    if (w67Var != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                        int intValue = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                        w67Var.p = intValue;
                        v67 v67Var = w67Var.k;
                        if (v67Var != null) {
                            v67Var.d = intValue;
                        }
                        if (w67Var.p == -1) {
                            this.a.c = z;
                        }
                    }
                    if (this.a.a != null) {
                        this.a.a.q0(w67Var != null ? responsedMessage.getError() : -1, w67Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends pb {
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

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.c = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z = responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage;
                if ((z || (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                    v67 v67Var = null;
                    if (z) {
                        ResponseHttpGetTopicRelateThreadMessage responseHttpGetTopicRelateThreadMessage = (ResponseHttpGetTopicRelateThreadMessage) responsedMessage;
                        if (responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                            v67Var = responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData();
                        }
                    }
                    if (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) {
                        ResponseSocketGetTopicRelateThreadMessage responseSocketGetTopicRelateThreadMessage = (ResponseSocketGetTopicRelateThreadMessage) responsedMessage;
                        if (responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                            v67Var = responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData();
                        }
                    }
                    if (v67Var != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                        v67Var.d = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                    }
                    int error = v67Var != null ? responsedMessage.getError() : -1;
                    if (this.a.a != null) {
                        this.a.a.q(error, v67Var);
                    }
                    if (this.a.b != null) {
                        this.a.b.q(error, v67Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends pb {
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

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            int i;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof BlessHttpResponseMessage;
            if ((z || (responsedMessage instanceof BlessSocketResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
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
                    i = -1;
                } else {
                    int intValue = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                    if (intValue == 1 || intValue == 2) {
                        this.a.d = false;
                    }
                    i = intValue;
                }
                if (this.a.a != null) {
                    this.a.a.r1(j4 != 0 ? responsedMessage.getError() : -1, j4, j3, i);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void q(int i, @Nullable v67 v67Var);
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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.j = ej.k(TbadkCoreApplication.getInst().getApp());
        this.k = ej.i(TbadkCoreApplication.getInst().getApp());
        J();
    }

    public boolean A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately() || this.c) {
                return false;
            }
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
        return invokeI.booleanValue;
    }

    public boolean B(int i, zs4 zs4Var, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), zs4Var, Long.valueOf(j)})) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately() || this.c) {
                return false;
            }
            cancelLoadData();
            RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
            requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.e));
            requestGetTopicRelateThreadMessage.setTopicName(this.f);
            requestGetTopicRelateThreadMessage.setRn(10);
            requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(zs4Var.a() + 1));
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
        return invokeCommon.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            oq7.f(this.h, "c14392");
        }
    }

    public void I(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, intent) == null) && intent != null && intent.getIntExtra("extra_share_status", 2) == 1) {
            oq7.f(this.h, "c14390");
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(new a(this, CmdConfigHttp.CMD_HOT_TOPIC, 303050));
            registerListener(new b(this, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005));
            registerListener(new c(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085));
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
            RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
            requestHotTopicMessage.setTopicId(Long.valueOf(this.e));
            requestHotTopicMessage.setTopicName(this.f);
            requestHotTopicMessage.setCall_from(P(this.g));
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
    }

    public boolean L(s67 s67Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, s67Var)) == null) {
            if (s67Var == null || !BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                return false;
            }
            RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
            requestBlessMessage.setPkId(Long.valueOf(s67Var.c));
            requestBlessMessage.setTopicId(Long.valueOf(this.e));
            requestBlessMessage.setPkIndex(1);
            requestBlessMessage.setClickType(s67Var.d != 0 ? 1 : 0);
            requestBlessMessage.setPkType(1);
            requestBlessMessage.setUserPkId(s67Var.d);
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

    public boolean M(a77 a77Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, a77Var, i)) == null) {
            if (a77Var == null || !BdNetTypeUtil.isNetworkAvailableForImmediately() || this.d) {
                return false;
            }
            RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
            requestBlessMessage.setPkId(Long.valueOf(a77Var.g));
            requestBlessMessage.setTopicId(Long.valueOf(this.e));
            requestBlessMessage.setPkIndex(i);
            requestBlessMessage.setClickType(a77Var.h == 0 ? 0 : 1);
            requestBlessMessage.setPkType(0);
            requestBlessMessage.setUserPkId(a77Var.h);
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

    public void N(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void O(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048585, this, j, str) == null) {
            this.e = j;
            this.f = str;
        }
    }

    public final int P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
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
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            cancelMessage();
            this.c = false;
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? z(1) : invokeV.booleanValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.g = str;
        }
    }

    public boolean z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately() || this.c) {
                return false;
            }
            cancelLoadData();
            RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
            requestHotTopicMessage.setTopicId(Long.valueOf(this.e));
            requestHotTopicMessage.setTopicName(this.f);
            requestHotTopicMessage.setCall_from(P(this.g));
            requestHotTopicMessage.setSort_type(Integer.valueOf(i));
            requestHotTopicMessage.setScrH(Integer.valueOf(this.k));
            requestHotTopicMessage.setScrW(Integer.valueOf(this.j));
            requestHotTopicMessage.setSrcDip(Double.valueOf(this.i));
            requestHotTopicMessage.setQType(Integer.valueOf(hq4.c().e()));
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
        return invokeI.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailModel(TbPageContext<?> tbPageContext, mq7 mq7Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, mq7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.j = ej.k(TbadkCoreApplication.getInst().getApp());
        this.k = ej.i(TbadkCoreApplication.getInst().getApp());
        J();
        this.a = mq7Var;
        this.h = tbPageContext;
    }
}
