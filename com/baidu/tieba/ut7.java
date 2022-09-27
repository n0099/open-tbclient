package com.baidu.tieba;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
/* loaded from: classes6.dex */
public class ut7 extends pt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewStub o;
    public View p;
    public TbImageView q;
    public TextView r;
    public TextView s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ut7(TbPageContext tbPageContext, View view2) {
        super(tbPageContext, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0925e3);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ej.i(tbPageContext.getPageActivity()) / 2;
        this.o.setLayoutParams(layoutParams);
        this.p = view2.findViewById(R.id.obfuscated_res_0x7f0924ad);
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f092488);
        this.q = tbImageView;
        tbImageView.setIsRound(true);
        this.q.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924b6);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924d1);
    }

    @Override // com.baidu.tieba.pt7
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            hv4 d = hv4.d(this.p);
            d.n(R.string.J_X05);
            d.f(R.color.CAM_X0204);
            hv4 d2 = hv4.d(this.r);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
            d2.A(R.string.F_X02);
            hv4 d3 = hv4.d(this.s);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
        }
    }

    @Override // com.baidu.tieba.pt7
    public void c(qt7 qt7Var) {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qt7Var) == null) || qt7Var == null || (storageModel = (ShareStorage.StorageModel) new Gson().fromJson(qt7Var.d, (Class<Object>) ShareStorage.StorageModel.class)) == null) {
            return;
        }
        this.q.K(storageModel.url, 10, false);
        this.r.setText(storageModel.displayname);
        this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1159, storageModel.app));
    }
}
