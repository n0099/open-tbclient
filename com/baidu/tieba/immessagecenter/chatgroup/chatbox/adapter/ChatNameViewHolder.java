package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.c39;
import com.baidu.tieba.fn8;
import com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.j29;
import com.baidu.tieba.n29;
import com.baidu.tieba.q29;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ChatNameViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c39 e;
    public n29 f;
    public String g;
    public j29 h;
    public q29 i;
    public View j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatNameViewHolder(@NonNull View view2, String str) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = str;
        this.j = view2;
        if (str.equals("message_tab")) {
            this.i = q29.f(view2);
        } else {
            this.h = j29.f(view2);
        }
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull fn8 fn8Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, fn8Var, tbPageContext, i) == null) && (fn8Var instanceof c39)) {
            this.e = (c39) fn8Var;
            if (this.g.equals("message_tab")) {
                this.f = new n29(this.e, this.i, this.j, this, this.g);
            } else {
                this.f = new n29(this.e, this.h, this.j, this, this.g);
            }
            this.f.f(this.e);
        }
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.f.g();
        }
    }
}
