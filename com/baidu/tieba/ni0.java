package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ni0 extends wd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseModel a;
    public View b;
    public View.OnClickListener c;

    public ni0(AdBaseModel adBaseModel, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adBaseModel, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = adBaseModel;
        this.b = view2;
    }

    @Override // com.baidu.tieba.wd1
    public void a(String str) {
        AdBaseModel adBaseModel;
        nr0 nr0Var;
        ir0 ir0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (adBaseModel = this.a) != null && (nr0Var = adBaseModel.f) != null && !TextUtils.isEmpty(nr0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_CLICK);
            clogBuilder.j(str);
            jr0 jr0Var = adBaseModel.m;
            if (jr0Var != null && (ir0Var = jr0Var.q) != null) {
                clogBuilder.v(ir0Var.a);
            }
            clogBuilder.p(adBaseModel.f.d);
            x31.e(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.wd1
    public void b(@NonNull vr0 vr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vr0Var) == null) {
            if (vr0Var.c) {
                cj0.b(vr0Var.a);
                g(ClogBuilder.LogType.CLICK, "detailbtn", this.a);
            }
            View.OnClickListener onClickListener = this.c;
            if (onClickListener != null) {
                onClickListener.onClick(this.b);
            }
        }
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.c = onClickListener;
        }
    }

    public final void g(ClogBuilder.LogType logType, String str, AdBaseModel adBaseModel) {
        nr0 nr0Var;
        ir0 ir0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, logType, str, adBaseModel) == null) && adBaseModel != null && (nr0Var = adBaseModel.f) != null && !TextUtils.isEmpty(nr0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str);
            jr0 jr0Var = adBaseModel.m;
            if (jr0Var != null && (ir0Var = jr0Var.q) != null) {
                clogBuilder.v(ir0Var.a);
            }
            clogBuilder.p(adBaseModel.f.d);
            x31.e(clogBuilder);
        }
    }
}
