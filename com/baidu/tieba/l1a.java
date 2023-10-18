package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.view.AdAppInfoView;
import com.baidu.tieba.recapp.widget.ApkDownloadView;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.u06;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l1a extends o1a {
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

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public a(l1a l1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l1aVar};
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

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l1a a;

        public b(l1a l1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l1aVar;
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

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z0a a;
        public final /* synthetic */ l1a b;

        public c(l1a l1aVar, z0a z0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l1aVar, z0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l1aVar;
            this.a = z0aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            int i;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                z0a z0aVar = this.a;
                String str2 = z0aVar.d;
                if (!me0.n(z0aVar.j)) {
                    z = le0.b(this.b.e.getPageActivity(), this.b.c.q);
                } else {
                    z = false;
                }
                if (!z) {
                    AdvertAppInfo advertAppInfo = this.b.c;
                    String str3 = advertAppInfo.g;
                    if (advertAppInfo.e()) {
                        str = this.b.c.getDownloadId();
                    } else {
                        str = this.b.c.a;
                    }
                    i = uz9.b(this.b.e, str2, str, str3, this.a.j);
                } else {
                    i = 3;
                }
                if (i == 0) {
                    return;
                }
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.y(ClogBuilder.LogType.CLICK).v("VIDEO_FLOW_TAIL").q(String.valueOf(this.b.c.position + 1)).p(this.b.c.g);
                jy0.e(clogBuilder);
                zy8.c(this.b.c);
                this.b.n.c();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements u06.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l1a a;

        public d(l1a l1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l1aVar;
        }

        @Override // com.baidu.tieba.u06.a
        public boolean a(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                j06.a(this.a.f.getButtonCmdScheme());
                zy8.c(this.a.c);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1a(View view2, String str) {
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

    @Override // com.baidu.tieba.o1a
    public void j(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            super.j(cVar);
            this.n.setTimeoutListener(cVar);
        }
    }

    @Override // com.baidu.tieba.o1a
    public void c(z0a z0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, z0aVar) == null) {
            super.c(z0aVar);
            if (z0aVar == null) {
                return;
            }
            this.i.startLoad(z0aVar.c, 30, false);
            this.j.setText(z0aVar.b);
            this.k.setText(z0aVar.i);
            this.m.setOnClickListener(new b(this));
            this.n.setFormatString(this.e.getResources().getString(R.string.obfuscated_res_0x7f0f00e6));
            this.h.setOnClickListener(new c(this, z0aVar));
            AdvertAppInfo advertAppInfo = this.c;
            if (advertAppInfo != null && this.f != null && advertAppInfo.e()) {
                this.o.setAd(this.c);
                this.o.setAppInfo(this.c.h.getAppInfoModel());
                m();
            }
        }
    }

    @Override // com.baidu.tieba.o1a
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            this.n.f(5);
            this.n.e();
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).v("VIDEO_FLOW_TAIL").q(String.valueOf(this.c.position + 1)).p(this.c.g);
            jy0.e(clogBuilder);
        }
    }

    @Override // com.baidu.tieba.o1a
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
            this.h = (RelativeLayout) a(R.id.obfuscated_res_0x7f0900a6);
            this.i = (RoundTbImageView) a(R.id.user_head);
            this.j = (TextView) a(R.id.user_name);
            this.k = (TextView) a(R.id.obfuscated_res_0x7f09282b);
            this.l = (ApkDownloadView) a(R.id.download_btn);
            this.m = (TextView) a(R.id.replay_btn);
            this.n = (CountDownTextView) a(R.id.obfuscated_res_0x7f0907fa);
            this.o = (AdAppInfoView) a(R.id.obfuscated_res_0x7f0900ce);
            this.l.setTextColorInitSkin(R.color.CAM_X0101);
            this.l.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            this.l.setTextSize(R.dimen.T_X06);
            this.l.setForegroundSkin(R.color.black_alpha15);
            this.l.setBackgroundSkin(R.drawable.obfuscated_res_0x7f081573);
            this.l.setRatio(0);
            this.l.b();
        }
    }

    public final void m() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (adCard = this.f) != null && adCard.downloadInfo != null) {
            this.l.setInitText(adCard.operate.a);
            this.l.setOnClickInterceptListener(new d(this));
            new t06(this.l, a1a.d(this.f));
        }
    }
}
