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
/* loaded from: classes5.dex */
public class mh8 extends oh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout h;
    public RoundTbImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public CountDownTextView n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public a(mh8 mh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh8Var};
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mh8 a;

        public b(mh8 mh8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mh8Var;
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

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yg8 a;
        public final /* synthetic */ mh8 b;

        public c(mh8 mh8Var, yg8 yg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mh8Var, yg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mh8Var;
            this.a = yg8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            boolean z;
            int i;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                yg8 yg8Var = this.a;
                String str2 = yg8Var.d;
                if (!wi0.n(yg8Var.j)) {
                    z = vi0.b(this.b.e.getPageActivity(), this.b.c.p);
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
                    i = wf8.b(this.b.e, str2, str, str3, this.a.j);
                } else {
                    i = 3;
                }
                if (i == 0) {
                    return;
                }
                ClogBuilder clogBuilder = new ClogBuilder();
                clogBuilder.y(ClogBuilder.LogType.CLICK).v("VIDEO_FLOW_TAIL").q(String.valueOf(this.b.c.position + 1)).p(this.b.c.g);
                z01.b(clogBuilder);
                qi7.c(this.b.c);
                this.b.n.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mh8(View view2, String str) {
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

    @Override // com.baidu.tieba.oh8
    public void j(CountDownTextView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.j(cVar);
            this.n.setTimeoutListener(cVar);
        }
    }

    @Override // com.baidu.tieba.oh8
    public void c(yg8 yg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, yg8Var) == null) {
            super.c(yg8Var);
            if (yg8Var == null) {
                return;
            }
            this.i.K(yg8Var.c, 30, false);
            this.j.setText(yg8Var.b);
            this.k.setText(yg8Var.i);
            this.l.setText(yg8Var.e);
            this.m.setOnClickListener(new b(this));
            this.n.setFormatString(this.e.getResources().getString(R.string.obfuscated_res_0x7f0f00b9));
            this.h.setOnClickListener(new c(this, yg8Var));
        }
    }

    @Override // com.baidu.tieba.oh8
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            this.n.update(5);
            this.n.e();
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.FREE_SHOW).v("VIDEO_FLOW_TAIL").q(String.valueOf(this.c.position + 1)).p(this.c.g);
            z01.b(clogBuilder);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setOnClickListener(new a(this));
            this.h = (RelativeLayout) a(R.id.obfuscated_res_0x7f090099);
            this.i = (RoundTbImageView) a(R.id.obfuscated_res_0x7f0924df);
            this.j = (TextView) a(R.id.obfuscated_res_0x7f0924f6);
            this.k = (TextView) a(R.id.obfuscated_res_0x7f0924cf);
            this.l = (TextView) a(R.id.obfuscated_res_0x7f092366);
            this.m = (TextView) a(R.id.obfuscated_res_0x7f091c1b);
            this.n = (CountDownTextView) a(R.id.obfuscated_res_0x7f09071f);
        }
    }
}
