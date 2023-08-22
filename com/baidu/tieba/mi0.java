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
public class mi0 extends sd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseModel a;
    public View b;
    public View.OnClickListener c;

    public mi0(AdBaseModel adBaseModel, View view2) {
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

    @Override // com.baidu.tieba.sd1
    public void a(String str) {
        AdBaseModel adBaseModel;
        jr0 jr0Var;
        er0 er0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (adBaseModel = this.a) != null && (jr0Var = adBaseModel.f) != null && !TextUtils.isEmpty(jr0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_CLICK);
            clogBuilder.j(str);
            fr0 fr0Var = adBaseModel.m;
            if (fr0Var != null && (er0Var = fr0Var.q) != null) {
                clogBuilder.v(er0Var.a);
            }
            clogBuilder.p(adBaseModel.f.d);
            t31.e(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.sd1
    public void b(@NonNull rr0 rr0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rr0Var) == null) {
            if (rr0Var.c) {
                bj0.b(rr0Var.a);
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
        jr0 jr0Var;
        er0 er0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, logType, str, adBaseModel) == null) && adBaseModel != null && (jr0Var = adBaseModel.f) != null && !TextUtils.isEmpty(jr0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str);
            fr0 fr0Var = adBaseModel.m;
            if (fr0Var != null && (er0Var = fr0Var.q) != null) {
                clogBuilder.v(er0Var.a);
            }
            clogBuilder.p(adBaseModel.f.d);
            t31.e(clogBuilder);
        }
    }
}
