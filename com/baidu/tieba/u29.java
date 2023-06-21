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
/* loaded from: classes8.dex */
public class u29 extends p29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewStub o;
    public View p;
    public TbImageView q;
    public TextView r;
    public TextView s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u29(TbPageContext tbPageContext, View view2) {
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
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f0928b8);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = wi.j(tbPageContext.getPageActivity()) / 2;
        this.o.setLayoutParams(layoutParams);
        this.p = view2.findViewById(R.id.obfuscated_res_0x7f09276f);
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.user_avatar);
        this.q = tbImageView;
        tbImageView.setIsRound(true);
        this.q.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.r = (TextView) view2.findViewById(R.id.user_name);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092799);
    }

    @Override // com.baidu.tieba.p29
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            p75 d = p75.d(this.p);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0204);
            p75 d2 = p75.d(this.r);
            d2.x(R.color.CAM_X0105);
            d2.C(R.dimen.T_X05);
            d2.D(R.string.F_X02);
            p75 d3 = p75.d(this.s);
            d3.x(R.color.CAM_X0108);
            d3.C(R.dimen.T_X08);
            d3.D(R.string.F_X01);
        }
    }

    @Override // com.baidu.tieba.p29
    public void c(q29 q29Var) {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q29Var) != null) || q29Var == null || (storageModel = (ShareStorage.StorageModel) new Gson().fromJson(q29Var.d, (Class<Object>) ShareStorage.StorageModel.class)) == null) {
            return;
        }
        this.q.N(storageModel.url, 10, false);
        this.r.setText(storageModel.displayname);
        this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1357, storageModel.app));
    }
}
