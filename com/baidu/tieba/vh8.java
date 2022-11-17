package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.gr5;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class vh8 extends ai8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView h;
    public TextView i;
    public ApkDownloadView j;
    public boolean k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vh8 a;

        public a(vh8 vh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vh8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j.performClick();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements gr5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh8 a;
        public final /* synthetic */ vh8 b;

        public b(vh8 vh8Var, kh8 kh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vh8Var, kh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vh8Var;
            this.a = kh8Var;
        }

        @Override // com.baidu.tieba.gr5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                vh8 vh8Var = this.b;
                if (vh8Var.k) {
                    wq5.a(this.a.j);
                } else {
                    AdCard adCard = vh8Var.f;
                    if (adCard != null) {
                        wq5.a(adCard.getButtonCmdScheme());
                    }
                }
                cj7.c(this.b.c);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vh8(View view2, String str) {
        super(view2, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        l();
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.k = z;
        }
    }

    @Override // com.baidu.tieba.ai8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.b();
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
            this.j.setTextColorInitSkin(R.color.CAM_X0101);
            this.j.setBackgroundSkin(R.drawable.obfuscated_res_0x7f081240);
            this.j.c();
        }
    }

    @Override // com.baidu.tieba.ai8
    public void c(kh8 kh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh8Var) == null) {
            super.c(kh8Var);
            this.h.K(kh8Var.c, 10, false);
            this.i.setText(kh8Var.b);
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
            this.j.setInitText(kh8Var.e);
            if (this.c != null) {
                this.b.setOnClickListener(new a(this));
                this.j.setOnClickInterceptListener(new b(this, kh8Var));
                AdCard adCard = this.f;
                if (adCard != null) {
                    new fr5(this.j, lh8.d(adCard));
                }
            }
            b();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = (HeadImageView) a(R.id.obfuscated_res_0x7f092512);
            this.h = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.h.setDefaultBgResource(R.color.CAM_X0205);
            this.h.setIsRound(true);
            this.i = (TextView) a(R.id.obfuscated_res_0x7f092505);
            this.j = (ApkDownloadView) a(R.id.obfuscated_res_0x7f09085c);
        }
    }
}
