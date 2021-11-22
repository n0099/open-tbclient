package com.baidu.tieba.pb.pb.main.relatelist;

import b.a.e.a.f;
import b.a.r0.k2.l;
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
/* loaded from: classes9.dex */
public class RelateRecThreadListModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53435e;

    /* renamed from: f  reason: collision with root package name */
    public RelateRecThreadRequestMessage f53436f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.n.a f53437g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.e.c.g.a f53438h;

    /* loaded from: classes9.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelateRecThreadListModel f53439a;

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
            this.f53439a = relateRecThreadListModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            RelateRecThreadRequestMessage relateRecThreadRequestMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f53439a.f53435e = false;
                if (responsedMessage == null || responsedMessage.getmOrginalMessage() == null || (relateRecThreadRequestMessage = (RelateRecThreadRequestMessage) responsedMessage.getmOrginalMessage().getExtra()) == null || this.f53439a.f53436f == null || this.f53439a.f53436f.threadId != relateRecThreadRequestMessage.threadId) {
                    return;
                }
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                if (error == 0 && !responsedMessage.hasError()) {
                    DataRes data = responsedMessage instanceof RelateRecThreadSocketResponseMessage ? ((RelateRecThreadSocketResponseMessage) responsedMessage).getData() : null;
                    if (responsedMessage instanceof RelateRecThreadHttpResponseMessage) {
                        data = ((RelateRecThreadHttpResponseMessage) responsedMessage).getData();
                    }
                    if (this.f53439a.f53437g != null) {
                        this.f53439a.f53437g.onSuccess(data);
                        return;
                    }
                    return;
                }
                String str = "errno=" + error + ",errmsg=" + errorString;
                if (StringUtils.isNull(errorString)) {
                    errorString = this.f53439a.A(l.error_unkown_try_again);
                }
                if (this.f53439a.f53437g != null) {
                    this.f53439a.f53437g.onError(error, errorString);
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
        this.f53435e = false;
        this.f53438h = new a(this, CmdConfigHttp.CMD_RELATE_REC_THREAD, 309701);
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
            b.a.r0.m3.f0.a.h(309701, RelateRecThreadSocketResponseMessage.class, false, false);
            b.a.r0.m3.f0.a.c(309701, CmdConfigHttp.CMD_RELATE_REC_THREAD, TbConfig.URL_RELATE_REC_THREAD, RelateRecThreadHttpResponseMessage.class, true, false, true, false);
            this.f53438h.getHttpMessageListener().setSelfListener(true);
            this.f53438h.getSocketMessageListener().setSelfListener(true);
            registerListener(this.f53438h);
        }
    }

    public boolean C(long j, long j2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (this.f53435e) {
                return false;
            }
            RelateRecThreadRequestMessage relateRecThreadRequestMessage = new RelateRecThreadRequestMessage();
            relateRecThreadRequestMessage.threadId = j2;
            relateRecThreadRequestMessage.forumId = j;
            relateRecThreadRequestMessage.sourceFrom = i3;
            relateRecThreadRequestMessage.sourceType = i2;
            sendMessage(relateRecThreadRequestMessage);
            this.f53436f = relateRecThreadRequestMessage;
            this.f53435e = true;
            String str = "sendReqMessage-->forumId=" + j + ",threadId=" + j2;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void D(b.a.q0.n.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f53437g = aVar;
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
            this.f53435e = false;
            this.f53436f = null;
            MessageManager.getInstance().unRegisterListener(this.f53438h);
        }
    }
}
