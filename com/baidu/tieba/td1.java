package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadCode;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.view.IDownloadViewCreator;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.widget.view.NadExpressNaBaseView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class td1 extends pd1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView f;
    public final RelativeLayout g;
    public final bm0<?> h;
    public vl0 i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ td1 a;

        public a(td1 td1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = td1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i != null) {
                this.a.i.l();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements zl0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdBaseModel a;
        public final /* synthetic */ il0 b;
        public final /* synthetic */ td1 c;

        public b(td1 td1Var, AdBaseModel adBaseModel, il0 il0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {td1Var, adBaseModel, il0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = td1Var;
            this.a = adBaseModel;
            this.b = il0Var;
        }

        @Override // com.baidu.tieba.zl0
        public void a(AdDownloadStatus adDownloadStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, adDownloadStatus) == null) {
                int i = c.a[adDownloadStatus.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                td1 td1Var = this.c;
                                if (td1Var.e != null && td1Var.n(this.a)) {
                                    this.c.e.a(this.a);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        td1 td1Var2 = this.c;
                        if (td1Var2.e != null && td1Var2.n(this.a)) {
                            this.c.e.e(this.a);
                            return;
                        }
                        return;
                    }
                    td1 td1Var3 = this.c;
                    if (td1Var3.e != null && td1Var3.n(this.a)) {
                        this.c.e.d(this.a);
                        return;
                    }
                    return;
                }
                td1 td1Var4 = this.c;
                if (td1Var4.e != null && td1Var4.n(this.a)) {
                    this.c.e.f(this.a, this.b.i);
                }
            }
        }

        @Override // com.baidu.tieba.zl0
        public void b(AdDownloadCode adDownloadCode) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadCode) == null) {
                boolean z2 = true;
                if (adDownloadCode != AdDownloadCode.ERROR_FAST_CLICK) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.c.e == null) {
                    z2 = false;
                }
                if ((z & z2) && this.c.n(this.a)) {
                    this.c.e.b(this.a);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-407417015, "Lcom/baidu/tieba/td1$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-407417015, "Lcom/baidu/tieba/td1$c;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            a = iArr;
            try {
                iArr[AdDownloadStatus.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadStatus.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadStatus.INSTALLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public td1(int i, View view2) {
        super(i, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = (TextView) a(R.id.feed_ad_operate_download_app_name);
        this.g = (RelativeLayout) a(R.id.nad_feed_ad_operate_progress_button);
        view2.setBackgroundColor(0);
        this.h = ym0.a(this.g, IDownloadViewCreator.ViewType.FEED_DOWNLOAD_VIEW);
        this.g.setOnClickListener(new a(this));
        m();
    }

    @Override // com.baidu.tieba.pd1
    public void update(AdBaseModel adBaseModel, NadExpressNaBaseView nadExpressNaBaseView) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, adBaseModel, nadExpressNaBaseView) == null) {
            super.update(adBaseModel, nadExpressNaBaseView);
            if (pd1.c(adBaseModel) && adBaseModel.h != null) {
                m();
                String str = adBaseModel.h.b.a;
                if (!TextUtils.isEmpty(str) && (textView = this.f) != null) {
                    textView.setText(str);
                    o(adBaseModel);
                }
                if (TextUtils.isEmpty(adBaseModel.f.d)) {
                    return;
                }
                il0 c2 = il0.c(adBaseModel);
                this.i = new vl0(c2, this.h);
                gd1 gd1Var = this.e;
                if (gd1Var != null) {
                    gd1Var.c(adBaseModel);
                }
                this.i.n(new b(this, adBaseModel, c2));
                return;
            }
            i(8);
        }
    }

    public final boolean n(AdBaseModel adBaseModel) {
        InterceptResult invokeL;
        fr0 fr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adBaseModel)) == null) {
            if (adBaseModel == null || (fr0Var = adBaseModel.l) == null) {
                return false;
            }
            return fr0Var.e;
        }
        return invokeL.booleanValue;
    }

    public final void o(AdBaseModel adBaseModel) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, adBaseModel) != null) || this.f == null) {
            return;
        }
        if (adBaseModel.b) {
            i = R.color.NAD_FC4;
        } else {
            i = R.color.NAD_FC1;
        }
        this.f.setTextColor(getResources().getColor(i));
    }

    @Override // com.baidu.tieba.pd1
    public void e() {
        vl0 vl0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (vl0Var = this.i) != null) {
            vl0Var.j();
            this.i = null;
        }
    }

    public final void m() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (textView = this.f) != null) {
            textView.setTextColor(getResources().getColor(R.color.NAD_FC1));
        }
    }
}
