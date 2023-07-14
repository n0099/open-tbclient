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
public class yn8 extends ga5<List<? extends ChatMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yn8(@NonNull TbPageContext<BaseFragmentActivity> tbPageContext, @NonNull fa5<List<? extends ChatMsg>> fa5Var) {
        super(fa5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fa5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fa5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ga5
    /* renamed from: b */
    public void a(@NonNull List<? extends ChatMsg> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || list.size() <= 0) {
            return;
        }
        this.a.b(new ao8(this.b));
        if (!nm8.e()) {
            zn8 zn8Var = null;
            for (ChatMsg chatMsg : list) {
                if (zn8Var == null || zn8Var.d().size() >= 10) {
                    zn8Var = new zn8(this.b);
                    this.a.b(zn8Var);
                }
                if (chatMsg.hasReaction()) {
                    zn8Var.d().add(chatMsg);
                }
            }
        }
    }
}
