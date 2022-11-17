package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomListNetModel;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.tieba.jp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class uw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VoiceRoomListNetModel a;

    /* loaded from: classes6.dex */
    public static final class a implements NetModel.k<sw6, tw6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ip4<List<VoiceRoomWrapper>> a;

        public a(ip4<List<VoiceRoomWrapper>> ip4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ip4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ip4Var;
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.m
        public void n(MvcSocketResponsedMessage<tw6, ?> mvcSocketResponsedMessage, MvcSocketMessage<sw6, tw6> mvcSocketMessage, MvcNetMessage<sw6, tw6> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                if (mvcSocketResponsedMessage.getError() == 0) {
                    this.a.a(new jp4.c(mvcSocketResponsedMessage.getData().a()));
                    return;
                }
                ip4<List<VoiceRoomWrapper>> ip4Var = this.a;
                String errorString = mvcSocketResponsedMessage.getErrorString();
                Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
                ip4Var.a(new jp4.a(errorString, null, 2, null));
            }
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.l
        public void s(MvcHttpResponsedMessage<tw6> mvcHttpResponsedMessage, MvcHttpMessage<sw6, tw6> mvcHttpMessage, MvcNetMessage<sw6, tw6> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                if (mvcHttpResponsedMessage.getError() == 0) {
                    this.a.a(new jp4.c(mvcHttpResponsedMessage.getData().a()));
                    return;
                }
                ip4<List<VoiceRoomWrapper>> ip4Var = this.a;
                String errorString = mvcHttpResponsedMessage.getErrorString();
                Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
                ip4Var.a(new jp4.a(errorString, null, 2, null));
            }
        }
    }

    public uw6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new VoiceRoomListNetModel();
    }

    public final void a(TbPageContext<?> tbPageContext, long j, long j2, ip4<List<VoiceRoomWrapper>> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), Long.valueOf(j2), callback}) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(callback, "callback");
            sw6 sw6Var = new sw6(j, j2);
            this.a.setUniqueId(tbPageContext.getUniqueId());
            this.a.c0(sw6Var);
            this.a.b0(new a(callback));
            this.a.loadData();
            callback.a(new jp4.b(null, 1, null));
        }
    }
}
