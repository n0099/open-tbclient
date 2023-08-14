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
public class ul8 extends x85<List<? extends ChatMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ul8(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull w85<List<? extends ChatMsg>> w85Var) {
        super(w85Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, w85Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((w85) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x85
    /* renamed from: b */
    public void a(@NonNull List<? extends ChatMsg> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a.b(new wl8(this.b));
            vl8 vl8Var = null;
            for (ChatMsg chatMsg : list) {
                if (vl8Var == null || vl8Var.d().size() >= 10) {
                    vl8Var = new vl8(this.b);
                    this.a.b(vl8Var);
                }
                if (chatMsg.hasReaction()) {
                    vl8Var.d().add(chatMsg);
                }
            }
        }
    }
}
