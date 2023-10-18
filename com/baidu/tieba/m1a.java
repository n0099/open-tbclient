package com.baidu.tieba;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class m1a extends o1a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout h;
    public RoundTbImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public CountDownTextView n;

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

        public a(m1a m1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m1aVar};
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
        public final /* synthetic */ m1a a;

        public b(m1a m1aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m1aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m1aVar;
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
        public final /* synthetic */ m1a b;

        public c(m1a m1aVar, z0a z0aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m1aVar, z0aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m1aVar;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1a(View view2, String str) {
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
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
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
            this.l.setText(z0aVar.e);
            this.m.setOnClickListener(new b(this));
            this.n.setFormatString(this.e.getResources().getString(R.string.obfuscated_res_0x7f0f00e6));
            this.h.setOnClickListener(new c(this, z0aVar));
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

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setOnClickListener(new a(this));
            this.h = (RelativeLayout) a(R.id.obfuscated_res_0x7f0900a6);
            this.i = (RoundTbImageView) a(R.id.user_head);
            this.j = (TextView) a(R.id.user_name);
            this.k = (TextView) a(R.id.obfuscated_res_0x7f09282b);
            this.l = (TextView) a(R.id.obfuscated_res_0x7f0926ba);
            this.m = (TextView) a(R.id.replay_btn);
            this.n = (CountDownTextView) a(R.id.obfuscated_res_0x7f0907fa);
        }
    }
}
