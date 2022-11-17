package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.gr5;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xh8 extends ai8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout h;
    public RoundTbImageView i;
    public TextView j;
    public TextView k;
    public ApkDownloadView l;
    public TextView m;
    public CountDownTextView n;
    public AdAppInfoView o;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public a(xh8 xh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xh8 a;

        public b(xh8 xh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xh8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            View.OnClickListener onClickListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (onClickListener = this.a.g) != null) {
                onClickListener.onClick(view2);
                this.a.n.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kh8 a;
        public final /* synthetic */ xh8 b;

        public c(xh8 xh8Var, kh8 kh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xh8Var, kh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xh8Var;
            this.a = kh8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            int i;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                kh8 kh8Var = this.a;
                String str2 = kh8Var.d;
                if (!xi0.n(kh8Var.j)) {
                    z = wi0.b(this.b.e.getPageActivity(), this.b.c.p);
                } else {
                    z = false;
                }
                if (!z) {
                    AdvertAppInfo advertAppInfo = this.b.c;
                    String str3 = advertAppInfo.g;
                    if (advertAppInfo.h()) {
                        str = this.b.c.getDownloadId();
                    } else {
                        str = this.b.c.a;
                    }
                    i = ig8.b(this.b.e, str2, str, str3, this.a.j);
                } else {
                    i = 3;
                }
                if (i == 0) {
                    return;
                }
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.y(ClogBuilder.LogType.CLICK).v("VIDEO_FLOW_TAIL").q(String.valueOf(this.b.c.position + 1)).p(this.b.c.g);
                a11.b(clogBuilder);
                cj7.c(this.b.c);
                this.b.n.c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements gr5.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xh8 a;

        public d(xh8 xh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xh8Var;
        }

        @Override // com.baidu.tieba.gr5.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                wq5.a(this.a.f.getButtonCmdScheme());
                cj7.c(this.a.c);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xh8(View view2, String str) {
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

    @Override // com.baidu.tieba.ai8
    public void j(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            super.j(cVar);
            this.n.setTimeoutListener(cVar);
        }
    }

    @Override // com.baidu.tieba.ai8
    public void c(kh8 kh8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kh8Var) == null) {
            super.c(kh8Var);
            if (kh8Var == null) {
                return;
            }
            this.i.K(kh8Var.c, 30, false);
            this.j.setText(kh8Var.b);
            this.k.setText(kh8Var.i);
            this.m.setOnClickListener(new b(this));
            this.n.setFormatString(this.e.getResources().getString(R.string.obfuscated_res_0x7f0f00b9));
            this.h.setOnClickListener(new c(this, kh8Var));
            AdvertAppInfo advertAppInfo = this.c;
            if (advertAppInfo != null && this.f != null && advertAppInfo.h()) {
                this.o.setAd(this.c);
                this.o.setAppInfo(this.c.h.getAppInfoModel());
                m();
            }
        }
    }

    @Override // com.baidu.tieba.ai8
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            this.n.update(5);
            this.n.e();
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).v("VIDEO_FLOW_TAIL").q(String.valueOf(this.c.position + 1)).p(this.c.g);
            a11.b(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.ai8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.e();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.setOnClickListener(new a(this));
            this.h = (RelativeLayout) a(R.id.obfuscated_res_0x7f090099);
            this.i = (RoundTbImageView) a(R.id.obfuscated_res_0x7f0924ee);
            this.j = (TextView) a(R.id.obfuscated_res_0x7f092505);
            this.k = (TextView) a(R.id.obfuscated_res_0x7f0924de);
            this.l = (ApkDownloadView) a(R.id.obfuscated_res_0x7f090849);
            this.m = (TextView) a(R.id.obfuscated_res_0x7f091c25);
            this.n = (CountDownTextView) a(R.id.obfuscated_res_0x7f090720);
            this.o = (AdAppInfoView) a(R.id.obfuscated_res_0x7f0900bc);
            this.l.setTextColorInitSkin(R.color.CAM_X0101);
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.l.setTextSize(R.dimen.T_X06);
            this.l.setForegroundSkin(R.color.black_alpha15);
            this.l.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0812bd);
            this.l.setRatio(0);
            this.l.c();
        }
    }

    public final void m() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (adCard = this.f) != null && adCard.downloadInfo != null) {
            this.l.setInitText(adCard.operate.a);
            this.l.setOnClickInterceptListener(new d(this));
            new fr5(this.l, lh8.d(this.f));
        }
    }
}
