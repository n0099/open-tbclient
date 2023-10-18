package com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.am8;
import com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.mm8;
import com.baidu.tieba.tl8;
import com.baidu.tieba.xl8;
import com.baidu.tieba.z68;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ChatNameViewHolder extends BaseItemViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mm8 e;
    public xl8 f;
    public String g;
    public tl8 h;
    public am8 i;
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
            this.i = am8.f(view2);
        } else {
            this.h = tl8.f(view2);
        }
    }

    @Override // com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder
    public void d(@NonNull z68 z68Var, @NonNull TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, z68Var, tbPageContext, i) == null) && (z68Var instanceof mm8)) {
            this.e = (mm8) z68Var;
            if (this.g.equals("message_tab")) {
                this.f = new xl8(this.e, this.i, this.j, this, this.g);
            } else {
                this.f = new xl8(this.e, this.h, this.j, this, this.g);
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
