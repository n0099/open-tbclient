package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.m58;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class o58 implements i58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public m58.e b;
    public List<fu7> c;
    public View d;
    public View e;
    public TabMenuPopView f;
    public m58 g;
    public TabMenuPopView.c h;

    /* loaded from: classes7.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o58 a;

        public a(o58 o58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o58Var;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view2, fu7 fu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, fu7Var) == null) {
                if (this.a.g != null) {
                    this.a.g.c();
                }
                this.a.b.a(fu7Var.b);
            }
        }
    }

    public o58() {
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
        this.h = new a(this);
    }

    @Override // com.baidu.tieba.i58
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.i58
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.i58
    public void a(Context context, m58 m58Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, m58Var) == null) && context != null && m58Var != null) {
            this.a = context;
            this.g = m58Var;
            this.b = m58Var.d();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0985, (ViewGroup) null);
            this.d = inflate;
            this.e = inflate.findViewById(R.id.top_line);
            TabMenuPopView tabMenuPopView = (TabMenuPopView) this.d.findViewById(R.id.obfuscated_res_0x7f0906a0);
            this.f = tabMenuPopView;
            tabMenuPopView.setOnItemClickCallBack(this.h);
        }
    }

    @Override // com.baidu.tieba.i58
    public void setData(List<fu7> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || list == null) {
            return;
        }
        this.c = list;
        fu7 fu7Var = new fu7();
        fu7Var.b = 0;
        fu7Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f02a8);
        fu7Var.c = false;
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
        this.f.setData(this.c, fu7Var);
    }
}
