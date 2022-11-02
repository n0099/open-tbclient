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
import com.baidu.tieba.ip4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class iw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final VoiceRoomListNetModel a;

    /* loaded from: classes4.dex */
    public static final class a implements NetModel.k<gw6, hw6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hp4<List<VoiceRoomWrapper>> a;

        public a(hp4<List<VoiceRoomWrapper>> hp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hp4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hp4Var;
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.m
        public void n(MvcSocketResponsedMessage<hw6, ?> mvcSocketResponsedMessage, MvcSocketMessage<gw6, hw6> mvcSocketMessage, MvcNetMessage<gw6, hw6> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) && mvcSocketResponsedMessage != null && !mvcSocketResponsedMessage.hasError()) {
                if (mvcSocketResponsedMessage.getError() == 0) {
                    this.a.a(new ip4.c(mvcSocketResponsedMessage.getData().a()));
                    return;
                }
                hp4<List<VoiceRoomWrapper>> hp4Var = this.a;
                String errorString = mvcSocketResponsedMessage.getErrorString();
                Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
                hp4Var.a(new ip4.a(errorString, null, 2, null));
            }
        }

        @Override // com.baidu.tbadk.mvc.model.NetModel.l
        public void s(MvcHttpResponsedMessage<hw6> mvcHttpResponsedMessage, MvcHttpMessage<gw6, hw6> mvcHttpMessage, MvcNetMessage<gw6, hw6> mvcNetMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) && mvcHttpResponsedMessage != null && !mvcHttpResponsedMessage.hasError()) {
                if (mvcHttpResponsedMessage.getError() == 0) {
                    this.a.a(new ip4.c(mvcHttpResponsedMessage.getData().a()));
                    return;
                }
                hp4<List<VoiceRoomWrapper>> hp4Var = this.a;
                String errorString = mvcHttpResponsedMessage.getErrorString();
                Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
                hp4Var.a(new ip4.a(errorString, null, 2, null));
            }
        }
    }

    public iw6() {
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

    public final void a(TbPageContext<?> tbPageContext, long j, long j2, hp4<List<VoiceRoomWrapper>> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{tbPageContext, Long.valueOf(j), Long.valueOf(j2), callback}) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
            Intrinsics.checkNotNullParameter(callback, "callback");
            gw6 gw6Var = new gw6(j, j2);
            this.a.setUniqueId(tbPageContext.getUniqueId());
            this.a.c0(gw6Var);
            this.a.b0(new a(callback));
            this.a.loadData();
            callback.a(new ip4.b(null, 1, null));
        }
    }
}
