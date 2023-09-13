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
public class vq8 extends n95<List<? extends ChatMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vq8(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull m95<List<? extends ChatMsg>> m95Var) {
        super(m95Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, m95Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((m95) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.n95
    /* renamed from: b */
    public void a(@NonNull List<? extends ChatMsg> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.a.b(new xq8(this.b));
            wq8 wq8Var = null;
            for (ChatMsg chatMsg : list) {
                if (wq8Var == null || wq8Var.d().size() >= 10) {
                    wq8Var = new wq8(this.b);
                    this.a.b(wq8Var);
                }
                if (chatMsg.hasReaction()) {
                    wq8Var.d().add(chatMsg);
                }
            }
        }
    }
}
