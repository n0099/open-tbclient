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
public class yv8 extends tv8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewStub o;
    public View p;
    public TbImageView q;
    public TextView r;
    public TextView s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yv8(TbPageContext tbPageContext, View view2) {
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
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f092872);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ri.j(tbPageContext.getPageActivity()) / 2;
        this.o.setLayoutParams(layoutParams);
        this.p = view2.findViewById(R.id.obfuscated_res_0x7f09272a);
        TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.user_avatar);
        this.q = tbImageView;
        tbImageView.setIsRound(true);
        this.q.setDefaultBgResource(R.drawable.icon_default_avatar100_bg);
        this.r = (TextView) view2.findViewById(R.id.user_name);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092754);
    }

    @Override // com.baidu.tieba.tv8
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            p45 d = p45.d(this.p);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0204);
            p45 d2 = p45.d(this.r);
            d2.w(R.color.CAM_X0105);
            d2.B(R.dimen.T_X05);
            d2.C(R.string.F_X02);
            p45 d3 = p45.d(this.s);
            d3.w(R.color.CAM_X0108);
            d3.B(R.dimen.T_X08);
            d3.C(R.string.F_X01);
        }
    }

    @Override // com.baidu.tieba.tv8
    public void c(uv8 uv8Var) {
        ShareStorage.StorageModel storageModel;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uv8Var) != null) || uv8Var == null || (storageModel = (ShareStorage.StorageModel) new Gson().fromJson(uv8Var.d, (Class<Object>) ShareStorage.StorageModel.class)) == null) {
            return;
        }
        this.q.N(storageModel.url, 10, false);
        this.r.setText(storageModel.displayname);
        this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1301, storageModel.app));
    }
}
