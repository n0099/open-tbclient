package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.multidelmenu.view.MultiDelPostMenuView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s16 extends r16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MultiDelPostMenuView c;
    public ViewGroup d;

    public s16(TbPageContext tbPageContext, ViewGroup viewGroup, h16 h16Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, h16Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = viewGroup;
        p16 p16Var = new p16(tbPageContext, new i16(h16Var));
        this.b = p16Var;
        p16Var.d(this);
        this.c = new MultiDelPostMenuView(tbPageContext, this);
    }

    @Override // com.baidu.tieba.r16
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a) {
            return;
        }
        this.a = false;
        MultiDelPostMenuView multiDelPostMenuView = this.c;
        if (multiDelPostMenuView != null && this.d != null && multiDelPostMenuView.getParent() != null) {
            this.d.removeView(this.c);
        }
        o16 o16Var = this.b;
        if (o16Var != null) {
            o16Var.dismiss();
        }
        this.c = null;
        this.d = null;
        this.b = null;
    }

    @Override // com.baidu.tieba.r16
    public void d(int i) {
        MultiDelPostMenuView multiDelPostMenuView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && (multiDelPostMenuView = this.c) != null) {
            multiDelPostMenuView.setDelCount(i);
        }
    }

    @Override // com.baidu.tieba.r16
    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.a) {
            return;
        }
        this.a = true;
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            viewGroup.addView(this.c, new ViewGroup.LayoutParams(-1, -1));
        }
    }
}
