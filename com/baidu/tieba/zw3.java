package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zw3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public AdElementInfo b;
    public View c;
    public LinearLayout d;
    public int e;
    public int f;
    public AdImageVIew g;
    public AdImageVIew h;
    public RelativeLayout i;
    public RelativeLayout j;
    public RelativeLayout k;
    public TextView l;
    public TextView m;
    public Button n;
    public ImageView o;
    public boolean p;
    public wx3 q;
    public ay3 r;
    public e s;
    public boolean t;
    public Runnable u;
    public View.OnClickListener v;
    public View.OnClickListener w;

    /* loaded from: classes7.dex */
    public interface e {
        void b();
    }

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw3 a;

        public a(zw3 zw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw3 a;

        public b(zw3 zw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bz3.b(this.a.u);
                if (this.a.s != null) {
                    this.a.s.b();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw3 a;

        public c(zw3 zw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.q != null) {
                this.a.q.b(CommandType.BANNER_VIEW, null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zw3 a;

        public d(zw3 zw3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zw3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zw3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.r != null) {
                this.a.r.f(view2);
            }
        }
    }

    public zw3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new a(this);
        this.v = new c(this);
        this.w = new d(this);
        this.a = context;
        h();
    }

    public zw3(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, adElementInfo, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.u = new a(this);
        this.v = new c(this);
        this.w = new d(this);
        this.a = context;
        this.b = adElementInfo;
        this.p = ey3.a().j();
        this.t = z;
        h();
    }

    public void i(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.s = eVar;
        }
    }

    public void j(wx3 wx3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wx3Var) == null) {
            this.q = wx3Var;
        }
    }

    public void k(ay3 ay3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ay3Var) == null) {
            this.r = ay3Var;
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int a2 = fz3.a(i);
            this.e = a2;
            this.f = (int) (a2 / ax3.a);
            this.c.setLayoutParams(new RelativeLayout.LayoutParams(this.e, this.f));
            this.d.setLayoutParams(new RelativeLayout.LayoutParams(this.e, this.f));
            int i2 = (int) (this.f * ax3.b);
            this.j.setLayoutParams(new LinearLayout.LayoutParams(i2, this.f));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * ax3.m), (int) (this.f * ax3.n));
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.setMarginStart(0);
            this.h.setLayoutParams(layoutParams);
            int i3 = this.e - i2;
            this.i.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f));
            int i4 = this.f;
            float f = i3;
            int i5 = (int) (ax3.h * f);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(9);
            layoutParams2.topMargin = (int) (i4 * ax3.c);
            layoutParams2.leftMargin = i5;
            layoutParams2.rightMargin = i5;
            this.l.setLayoutParams(layoutParams2);
            this.l.setTextSize(0, (int) (i4 * ax3.e));
            this.l.setLineSpacing((int) (i4 * ax3.d), 1.0f);
            int i6 = this.f;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (i6 * ax3.g));
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = (int) (i6 * ax3.f);
            layoutParams3.leftMargin = i5;
            layoutParams3.rightMargin = i5;
            this.k.setLayoutParams(layoutParams3);
            int i7 = (int) (this.f * ax3.k);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (f * ax3.i), -1);
            layoutParams4.addRule(9);
            float f2 = (int) (ax3.l * i7);
            this.m.setTextSize(0, f2);
            layoutParams4.addRule(15);
            this.m.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (ax3.j * f), i7);
            layoutParams5.addRule(12);
            layoutParams5.addRule(11);
            this.n.setTextSize(0, f2);
            this.n.setLayoutParams(layoutParams5);
            if (this.o != null) {
                int i8 = (int) (this.f * ax3.o);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i8, i8);
                layoutParams6.addRule(10);
                layoutParams6.addRule(11);
                this.o.setLayoutParams(layoutParams6);
            }
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View view2 = this.c;
            if (view2 != null && view2.getVisibility() == 0) {
                this.c.setVisibility(4);
            }
            bz3.b(this.u);
        }
    }

    @SuppressLint({"InflateParams"})
    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Resources resources = this.a.getResources();
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06a0, (ViewGroup) null);
            this.c = inflate;
            this.d = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090332);
            this.j = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090324);
            AdImageVIew adImageVIew = (AdImageVIew) this.c.findViewById(R.id.obfuscated_res_0x7f090334);
            this.g = adImageVIew;
            AdElementInfo adElementInfo = this.b;
            if (adElementInfo != null) {
                adImageVIew.setImageUrl(adElementInfo.getPictureUrl());
            }
            AdImageVIew adImageVIew2 = (AdImageVIew) this.c.findViewById(R.id.obfuscated_res_0x7f090101);
            this.h = adImageVIew2;
            adImageVIew2.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
            this.i = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090325);
            this.k = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09032f);
            this.l = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090330);
            this.m = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090327);
            AdElementInfo adElementInfo2 = this.b;
            if (adElementInfo2 != null) {
                this.l.setText(adElementInfo2.getTitle());
                this.m.setText(this.b.getAppName());
            }
            Button button = (Button) this.c.findViewById(R.id.obfuscated_res_0x7f090323);
            this.n = button;
            button.setVisibility(8);
            AdElementInfo adElementInfo3 = this.b;
            if (adElementInfo3 != null && adElementInfo3.getActionType() == 1) {
                this.n.setVisibility(0);
                this.n.setText(resources.getString(R.string.obfuscated_res_0x7f0f11b6));
            }
            AdElementInfo adElementInfo4 = this.b;
            if (adElementInfo4 != null && adElementInfo4.getActionType() == 2) {
                this.n.setVisibility(0);
                this.n.setText(resources.getString(R.string.obfuscated_res_0x7f0f135b));
            }
            if (this.b == null) {
                this.j.setVisibility(8);
                this.i.setVisibility(8);
                this.c.findViewById(R.id.obfuscated_res_0x7f091813).setVisibility(0);
                return;
            }
            this.j.setVisibility(0);
            this.i.setVisibility(0);
            this.c.findViewById(R.id.obfuscated_res_0x7f091813).setVisibility(8);
            if (this.t) {
                this.n.setOnClickListener(this.w);
                this.d.setOnClickListener(this.w);
            } else {
                this.n.setOnClickListener(this.v);
                this.d.setOnClickListener(this.v);
            }
            this.c.setVisibility(4);
            if (this.p) {
                ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0906d5);
                this.o = imageView;
                imageView.setVisibility(0);
                this.o.setOnClickListener(new b(this));
            }
        }
    }

    public void l() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (view2 = this.c) != null && view2.getVisibility() == 4) {
            this.c.setAnimation(AnimationUtils.loadAnimation(this.a, R.anim.obfuscated_res_0x7f0100be));
            this.c.setVisibility(0);
            bz3.a(this.u, ey3.a().a());
        }
    }
}
