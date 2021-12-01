package com.baidu.tieba.model;

import c.a.d.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.model.message.AddPollPostHttpResponseMessage;
import com.baidu.tieba.model.message.AddPollPostRequestNetMessage;
import com.baidu.tieba.model.message.AddPollPostSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class AddPollPostModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f47039e;

    /* renamed from: f  reason: collision with root package name */
    public long f47040f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f47041g;

    /* loaded from: classes10.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddPollPostModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AddPollPostModel addPollPostModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addPollPostModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.a = addPollPostModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AddPollPostRequestNetMessage) && this.a.f47040f == ((AddPollPostRequestNetMessage) responsedMessage.getOrginalMessage().getExtra()).getThreadId()) {
                boolean z = responsedMessage instanceof AddPollPostHttpResponseMessage;
                if (z || (responsedMessage instanceof AddPollPostSocketResponseMessage)) {
                    AddPollPostHttpResponseMessage addPollPostHttpResponseMessage = z ? (AddPollPostHttpResponseMessage) responsedMessage : null;
                    AddPollPostSocketResponseMessage addPollPostSocketResponseMessage = responsedMessage instanceof AddPollPostSocketResponseMessage ? (AddPollPostSocketResponseMessage) responsedMessage : null;
                    int i2 = 0;
                    if (responsedMessage.getError() != 0) {
                        i2 = responsedMessage.getError();
                        str = responsedMessage.getErrorString();
                    } else if (addPollPostHttpResponseMessage != null && addPollPostHttpResponseMessage.getIdl() != null && addPollPostHttpResponseMessage.getIdl().data != null && addPollPostHttpResponseMessage.getIdl().data.error_code.intValue() != 0) {
                        i2 = addPollPostHttpResponseMessage.getIdl().data.error_code.intValue();
                        str = addPollPostHttpResponseMessage.getIdl().data.error_msg;
                    } else if (addPollPostSocketResponseMessage == null || addPollPostSocketResponseMessage.getIdl() == null || addPollPostSocketResponseMessage.getIdl().data == null || addPollPostSocketResponseMessage.getIdl().data.error_code.intValue() == 0) {
                        str = "";
                    } else {
                        i2 = addPollPostSocketResponseMessage.getIdl().data.error_code.intValue();
                        str = addPollPostSocketResponseMessage.getIdl().data.error_msg;
                    }
                    if (this.a.f47039e != null) {
                        this.a.f47039e.a(i2, str);
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(int i2, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddPollPostModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.f47041g = new a(this, CmdConfigHttp.CMD_ADD_POLL_POST, 309006);
        z();
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f47039e = bVar;
        }
    }

    public void B(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.f47040f = j2;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
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

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(this.f47041g);
        }
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f47041g);
        }
    }

    public void y(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
            AddPollPostRequestNetMessage addPollPostRequestNetMessage = new AddPollPostRequestNetMessage();
            addPollPostRequestNetMessage.setThreadId(c.a.d.f.m.b.g(str, 0L));
            addPollPostRequestNetMessage.setOptions(str2);
            addPollPostRequestNetMessage.setForumId(j2);
            sendMessage(addPollPostRequestNetMessage);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            c.a.r0.t3.f0.a.h(309006, AddPollPostSocketResponseMessage.class, false, false);
            c.a.r0.t3.f0.a.c(309006, CmdConfigHttp.CMD_ADD_POLL_POST, TbConfig.VOTE_ADD, AddPollPostHttpResponseMessage.class, false, false, false, false);
        }
    }
}
