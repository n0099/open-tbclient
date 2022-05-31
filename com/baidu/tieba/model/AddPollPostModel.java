package com.baidu.tieba.model;

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
import com.repackage.b9;
import com.repackage.ig8;
import com.repackage.jg;
import com.repackage.wa;
/* loaded from: classes3.dex */
public class AddPollPostModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public long b;
    public wa c;

    /* loaded from: classes3.dex */
    public class a extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddPollPostModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AddPollPostModel addPollPostModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addPollPostModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = addPollPostModel;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && (responsedMessage.getOrginalMessage().getExtra() instanceof AddPollPostRequestNetMessage) && this.a.b == ((AddPollPostRequestNetMessage) responsedMessage.getOrginalMessage().getExtra()).getThreadId()) {
                boolean z = responsedMessage instanceof AddPollPostHttpResponseMessage;
                if (z || (responsedMessage instanceof AddPollPostSocketResponseMessage)) {
                    AddPollPostHttpResponseMessage addPollPostHttpResponseMessage = z ? (AddPollPostHttpResponseMessage) responsedMessage : null;
                    AddPollPostSocketResponseMessage addPollPostSocketResponseMessage = responsedMessage instanceof AddPollPostSocketResponseMessage ? (AddPollPostSocketResponseMessage) responsedMessage : null;
                    int i = 0;
                    if (responsedMessage.getError() != 0) {
                        i = responsedMessage.getError();
                        str = responsedMessage.getErrorString();
                    } else if (addPollPostHttpResponseMessage != null && addPollPostHttpResponseMessage.getIdl() != null && addPollPostHttpResponseMessage.getIdl().data != null && addPollPostHttpResponseMessage.getIdl().data.error_code.intValue() != 0) {
                        i = addPollPostHttpResponseMessage.getIdl().data.error_code.intValue();
                        str = addPollPostHttpResponseMessage.getIdl().data.error_msg;
                    } else if (addPollPostSocketResponseMessage == null || addPollPostSocketResponseMessage.getIdl() == null || addPollPostSocketResponseMessage.getIdl().data == null || addPollPostSocketResponseMessage.getIdl().data.error_code.intValue() == 0) {
                        str = "";
                    } else {
                        i = addPollPostSocketResponseMessage.getIdl().data.error_code.intValue();
                        str = addPollPostSocketResponseMessage.getIdl().data.error_msg;
                    }
                    if (this.a.a != null) {
                        this.a.a.a(i, str);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i, String str);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this, CmdConfigHttp.CMD_ADD_POLL_POST, 309006);
        B();
    }

    public void A(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            AddPollPostRequestNetMessage addPollPostRequestNetMessage = new AddPollPostRequestNetMessage();
            addPollPostRequestNetMessage.setThreadId(jg.g(str, 0L));
            addPollPostRequestNetMessage.setOptions(str2);
            addPollPostRequestNetMessage.setForumId(j);
            sendMessage(addPollPostRequestNetMessage);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ig8.h(309006, AddPollPostSocketResponseMessage.class, false, false);
            ig8.c(309006, CmdConfigHttp.CMD_ADD_POLL_POST, TbConfig.VOTE_ADD, AddPollPostHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void C(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void D(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.b = j;
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

    public void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            registerListener(this.c);
        }
    }

    public void unRegisterListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.c);
        }
    }
}
