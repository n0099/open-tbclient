package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yf9 extends PbListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yf9(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = tbPageContext;
        c().setPadding(0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be), 0, tbPageContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070416));
        D();
        C();
        z();
        L(R.dimen.obfuscated_res_0x7f070201);
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.g();
            H(this.F.getResources().getString(R.string.load_more));
            c().setVisibility(0);
        }
    }

    @Override // com.baidu.tbadk.core.view.PbListView
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.g();
            H(this.F.getResources().getString(R.string.list_no_more));
            c().setVisibility(0);
        }
    }
}
