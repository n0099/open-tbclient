package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.u06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j1a extends o1a {
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
        public final /* synthetic */ j1a a;

        public a(j1a j1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j1aVar;
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
    public class b implements u06.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z0a a;
        public final /* synthetic */ j1a b;

        public b(j1a j1aVar, z0a z0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j1aVar, z0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = j1aVar;
            this.a = z0aVar;
        }

        @Override // com.baidu.tieba.u06.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                j1a j1aVar = this.b;
                if (j1aVar.k) {
                    j06.a(this.a.j);
                } else {
                    AdCard adCard = j1aVar.f;
                    if (adCard != null) {
                        j06.a(adCard.getButtonCmdScheme());
                    }
                }
                zy8.c(this.b.c);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1a(View view2, String str) {
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

    @Override // com.baidu.tieba.o1a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.b();
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0101, 1);
            this.j.setTextColorInitSkin(R.color.CAM_X0101);
            this.j.setBackgroundSkin(R.drawable.obfuscated_res_0x7f0814ef);
            this.j.b();
        }
    }

    @Override // com.baidu.tieba.o1a
    public void c(z0a z0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z0aVar) == null) {
            super.c(z0aVar);
            this.h.startLoad(z0aVar.c, 10, false);
            this.i.setText(z0aVar.b);
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0901));
            this.j.setInitText(z0aVar.e);
            if (this.c != null) {
                this.b.setOnClickListener(new a(this));
                this.j.setOnClickInterceptListener(new b(this, z0aVar));
                AdCard adCard = this.f;
                if (adCard != null) {
                    new t06(this.j, a1a.d(adCard));
                }
            }
            b();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            HeadImageView headImageView = (HeadImageView) a(R.id.obfuscated_res_0x7f092864);
            this.h = headImageView;
            headImageView.setDefaultResource(R.drawable.icon_default_avatar100);
            this.h.setDefaultBgResource(R.color.CAM_X0205);
            this.h.setIsRound(true);
            this.i = (TextView) a(R.id.user_name);
            this.j = (ApkDownloadView) a(R.id.obfuscated_res_0x7f09095d);
        }
    }
}
