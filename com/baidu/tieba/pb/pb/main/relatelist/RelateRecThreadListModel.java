package com.baidu.tieba.pb.pb.main.relatelist;

import c.a.d.a.f;
import c.a.s0.s2.l;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RelateRecThread.DataRes;
/* loaded from: classes12.dex */
public class RelateRecThreadListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48264e;

    /* renamed from: f  reason: collision with root package name */
    public RelateRecThreadRequestMessage f48265f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.n.a f48266g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.d.c.g.a f48267h;

    /* loaded from: classes12.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ RelateRecThreadListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RelateRecThreadListModel relateRecThreadListModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateRecThreadListModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = relateRecThreadListModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RelateRecThreadRequestMessage relateRecThreadRequestMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.f48264e = false;
                if (responsedMessage == null || responsedMessage.getmOrginalMessage() == null || (relateRecThreadRequestMessage = (RelateRecThreadRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) == null || this.a.f48265f == null || this.a.f48265f.threadId != relateRecThreadRequestMessage.threadId) {
                    return;
                }
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                if (error == 0 && !responsedMessage.hasError()) {
                    DataRes data = responsedMessage instanceof RelateRecThreadSocketResponseMessage ? ((RelateRecThreadSocketResponseMessage) responsedMessage).getData() : null;
                    if (responsedMessage instanceof RelateRecThreadHttpResponseMessage) {
                        data = ((RelateRecThreadHttpResponseMessage) responsedMessage).getData();
                    }
                    if (this.a.f48266g != null) {
                        this.a.f48266g.onSuccess(data);
                        return;
                    }
                    return;
                }
                String str = "errno=" + error + ",errmsg=" + errorString;
                if (StringUtils.isNull(errorString)) {
                    errorString = this.a.A(l.error_unkown_try_again);
                }
                if (this.a.f48266g != null) {
                    this.a.f48266g.onError(error, errorString);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelateRecThreadListModel(f fVar, BdUniqueId bdUniqueId) {
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
        this.f48264e = false;
        this.f48267h = new a(this, CmdConfigHttp.CMD_RELATE_REC_THREAD, 309701);
        setUniqueId(bdUniqueId);
        B();
    }

    public final String A(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? TbadkCoreApplication.getInst().getString(i2) : (String) invokeI.objValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.s0.v3.f0.a.h(309701, RelateRecThreadSocketResponseMessage.class, false, false);
            c.a.s0.v3.f0.a.c(309701, CmdConfigHttp.CMD_RELATE_REC_THREAD, TbConfig.URL_RELATE_REC_THREAD, RelateRecThreadHttpResponseMessage.class, true, false, true, false);
            this.f48267h.getHttpMessageListener().setSelfListener(true);
            this.f48267h.getSocketMessageListener().setSelfListener(true);
            registerListener(this.f48267h);
        }
    }

    public boolean C(long j2, long j3, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (this.f48264e) {
                return false;
            }
            RelateRecThreadRequestMessage relateRecThreadRequestMessage = new RelateRecThreadRequestMessage();
            relateRecThreadRequestMessage.threadId = j3;
            relateRecThreadRequestMessage.forumId = j2;
            relateRecThreadRequestMessage.sourceFrom = i3;
            relateRecThreadRequestMessage.sourceType = i2;
            sendMessage(relateRecThreadRequestMessage);
            this.f48265f = relateRecThreadRequestMessage;
            this.f48264e = true;
            String str = "sendReqMessage-->forumId=" + j2 + ",threadId=" + j3;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void D(c.a.r0.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f48266g = aVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f48264e = false;
            this.f48265f = null;
            MessageManager.getInstance().unRegisterListener(this.f48267h);
        }
    }
}
