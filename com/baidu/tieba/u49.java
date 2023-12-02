package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class u49 extends c55<List<? extends ChatMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u49(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull b55<List<? extends ChatMsg>> b55Var) {
        super(b55Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, b55Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b55) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c55
    /* renamed from: b */
    public void a(@NonNull List<? extends ChatMsg> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a.b(new w49(this.b));
            v49 v49Var = null;
            for (ChatMsg chatMsg : list) {
                if (v49Var == null || v49Var.d().size() >= 10) {
                    v49Var = new v49(this.b);
                    this.a.b(v49Var);
                }
                if (chatMsg.hasReaction()) {
                    v49Var.d().add(chatMsg);
                }
            }
        }
    }
}
