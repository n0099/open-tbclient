package com.baidu.tieba.newdetail;

import android.content.Intent;
import androidx.annotation.Nullable;
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
import com.repackage.b37;
import com.repackage.c37;
import com.repackage.d9;
import com.repackage.g37;
import com.repackage.ni;
import com.repackage.om7;
import com.repackage.op4;
import com.repackage.pi;
import com.repackage.qm7;
import com.repackage.y27;
import com.repackage.za;
/* loaded from: classes3.dex */
public class HotTopicDetailModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public om7 a;
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

    /* loaded from: classes3.dex */
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

        @Override // com.repackage.za
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
                    c37 c37Var = null;
                    if (z2) {
                        ResponseHttpHotTopicMessage responseHttpHotTopicMessage = (ResponseHttpHotTopicMessage) responsedMessage;
                        if (responseHttpHotTopicMessage.getHotTopicData() != null) {
                            c37Var = responseHttpHotTopicMessage.getHotTopicData();
                        }
                    }
                    if (responsedMessage instanceof ResponseSocketHotTopicMessage) {
                        ResponseSocketHotTopicMessage responseSocketHotTopicMessage = (ResponseSocketHotTopicMessage) responsedMessage;
                        if (responseSocketHotTopicMessage.getHotTopicData() != null) {
                            c37Var = responseSocketHotTopicMessage.getHotTopicData();
                        }
                    }
                    if (c37Var != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                        int intValue = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                        c37Var.p = intValue;
                        b37 b37Var = c37Var.k;
                        if (b37Var != null) {
                            b37Var.d = intValue;
                        }
                        if (c37Var.p == -1) {
                            this.a.c = z;
                        }
                    }
                    if (this.a.a != null) {
                        this.a.a.r0(c37Var != null ? responsedMessage.getError() : -1, c37Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.c = false;
                if (responsedMessage == null) {
                    return;
                }
                boolean z = responsedMessage instanceof ResponseHttpGetTopicRelateThreadMessage;
                if ((z || (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                    b37 b37Var = null;
                    if (z) {
                        ResponseHttpGetTopicRelateThreadMessage responseHttpGetTopicRelateThreadMessage = (ResponseHttpGetTopicRelateThreadMessage) responsedMessage;
                        if (responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                            b37Var = responseHttpGetTopicRelateThreadMessage.getHotThreadItemListData();
                        }
                    }
                    if (responsedMessage instanceof ResponseSocketGetTopicRelateThreadMessage) {
                        ResponseSocketGetTopicRelateThreadMessage responseSocketGetTopicRelateThreadMessage = (ResponseSocketGetTopicRelateThreadMessage) responsedMessage;
                        if (responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData() != null) {
                            b37Var = responseSocketGetTopicRelateThreadMessage.getHotThreadItemListData();
                        }
                    }
                    if (b37Var != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof Integer)) {
                        b37Var.d = ((Integer) responsedMessage.getOrginalMessage().getExtra()).intValue();
                    }
                    int error = b37Var != null ? responsedMessage.getError() : -1;
                    if (this.a.a != null) {
                        this.a.a.p(error, b37Var);
                    }
                    if (this.a.b != null) {
                        this.a.b.p(error, b37Var);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

        @Override // com.repackage.za
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
                    this.a.a.s1(j4 != 0 ? responsedMessage.getError() : -1, j4, j3, i);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void p(int i, @Nullable b37 b37Var);
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
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.j = pi.k(TbadkCoreApplication.getInst().getApp());
        this.k = pi.i(TbadkCoreApplication.getInst().getApp());
        K();
    }

    public boolean A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (!ni.A() || this.c) {
                return false;
            }
            cancelLoadData();
            RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
            requestHotTopicMessage.setTopicId(Long.valueOf(this.e));
            requestHotTopicMessage.setTopicName(this.f);
            requestHotTopicMessage.setCall_from(Q(this.g));
            requestHotTopicMessage.setSort_type(Integer.valueOf(i));
            requestHotTopicMessage.setScrH(Integer.valueOf(this.k));
            requestHotTopicMessage.setScrW(Integer.valueOf(this.j));
            requestHotTopicMessage.setSrcDip(Double.valueOf(this.i));
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

    public boolean B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (!ni.A() || this.c) {
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

    public boolean C(int i, op4 op4Var, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), op4Var, Long.valueOf(j)})) == null) {
            if (!ni.A() || this.c) {
                return false;
            }
            cancelLoadData();
            RequestGetTopicRelateThreadMessage requestGetTopicRelateThreadMessage = new RequestGetTopicRelateThreadMessage();
            requestGetTopicRelateThreadMessage.setTopicId(Long.valueOf(this.e));
            requestGetTopicRelateThreadMessage.setTopicName(this.f);
            requestGetTopicRelateThreadMessage.setRn(10);
            requestGetTopicRelateThreadMessage.setPageNo(Integer.valueOf(op4Var.a() + 1));
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

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            qm7.f(this.h, "c14392");
        }
    }

    public void J(Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, intent) == null) && intent != null && intent.getIntExtra("extra_share_status", 2) == 1) {
            qm7.f(this.h, "c14390");
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            registerListener(new a(this, CmdConfigHttp.CMD_HOT_TOPIC, 303050));
            registerListener(new b(this, CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005));
            registerListener(new c(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && ni.A()) {
            RequestHotTopicMessage requestHotTopicMessage = new RequestHotTopicMessage();
            requestHotTopicMessage.setTopicId(Long.valueOf(this.e));
            requestHotTopicMessage.setTopicName(this.f);
            requestHotTopicMessage.setCall_from(Q(this.g));
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

    public boolean M(y27 y27Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, y27Var)) == null) {
            if (y27Var == null || !ni.A()) {
                return false;
            }
            RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
            requestBlessMessage.setPkId(Long.valueOf(y27Var.c));
            requestBlessMessage.setTopicId(Long.valueOf(this.e));
            requestBlessMessage.setPkIndex(1);
            requestBlessMessage.setClickType(y27Var.d != 0 ? 1 : 0);
            requestBlessMessage.setPkType(1);
            requestBlessMessage.setUserPkId(y27Var.d);
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

    public boolean N(g37 g37Var, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, g37Var, i)) == null) {
            if (g37Var == null || !ni.A() || this.d) {
                return false;
            }
            RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
            requestBlessMessage.setPkId(Long.valueOf(g37Var.g));
            requestBlessMessage.setTopicId(Long.valueOf(this.e));
            requestBlessMessage.setPkIndex(i);
            requestBlessMessage.setClickType(g37Var.h == 0 ? 0 : 1);
            requestBlessMessage.setPkType(0);
            requestBlessMessage.setUserPkId(g37Var.h);
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

    public void O(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.b = dVar;
        }
    }

    public void P(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048586, this, j, str) == null) {
            this.e = j;
            this.f = str;
        }
    }

    public final int Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? A(1) : invokeV.booleanValue;
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.g = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicDetailModel(TbPageContext<?> tbPageContext, om7 om7Var) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, om7Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        this.j = pi.k(TbadkCoreApplication.getInst().getApp());
        this.k = pi.i(TbadkCoreApplication.getInst().getApp());
        K();
        this.a = om7Var;
        this.h = tbPageContext;
    }
}
