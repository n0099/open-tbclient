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
/* loaded from: classes6.dex */
public class vh0 extends v81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBaseModel a;
    public View b;
    public View.OnClickListener c;

    public vh0(AdBaseModel adBaseModel, View view2) {
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

    @Override // com.baidu.tieba.v81
    public void a(String str) {
        AdBaseModel adBaseModel;
        sp0 sp0Var;
        np0 np0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (adBaseModel = this.a) != null && (sp0Var = adBaseModel.f) != null && !TextUtils.isEmpty(sp0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_CLICK);
            clogBuilder.j(str);
            op0 op0Var = adBaseModel.m;
            if (op0Var != null && (np0Var = op0Var.f) != null) {
                clogBuilder.v(np0Var.a);
            }
            clogBuilder.p(adBaseModel.f.d);
            z01.b(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.v81
    public void b(@NonNull yp0 yp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yp0Var) == null) {
            if (yp0Var.c) {
                ii0.b(yp0Var.a);
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
        sp0 sp0Var;
        np0 np0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, logType, str, adBaseModel) == null) && adBaseModel != null && (sp0Var = adBaseModel.f) != null && !TextUtils.isEmpty(sp0Var.d)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(logType);
            clogBuilder.j(str);
            op0 op0Var = adBaseModel.m;
            if (op0Var != null && (np0Var = op0Var.f) != null) {
                clogBuilder.v(np0Var.a);
            }
            clogBuilder.p(adBaseModel.f.d);
            z01.b(clogBuilder);
        }
    }
}
