package com.baidu.tieba.personExtra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.an5;
import com.baidu.tieba.fn5;
import com.baidu.tieba.kn5;
import com.baidu.tieba.xi;
import com.baidu.tieba.ym5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class PersonConstellationActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public TextView b;
    public View c;
    public ImageView d;
    public BdSwitchView e;
    public kn5 f;
    public RelativeLayout g;
    public RelativeLayout h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public long n;
    public int o;
    public BdSwitchView.b p;
    public View.OnClickListener q;
    public fn5 r;

    /* loaded from: classes5.dex */
    public class c implements an5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonConstellationActivity a;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.f != null) {
                    this.a.a.f.f();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a.f != null) {
                    this.a.a.f.A();
                    this.a.a.f.f();
                }
            }
        }

        public c(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personConstellationActivity;
        }

        @Override // com.baidu.tieba.an5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SkinManager.setBackgroundResource(view2, R.drawable.person_birthday_select_top_bg);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091955);
                textView.setOnClickListener(new a(this));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091954);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new b(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements BdSwitchView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonConstellationActivity a;

        public a(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personConstellationActivity;
        }

        @Override // com.baidu.adp.widget.BdSwitchView.BdSwitchView.b
        public void h0(View view2, BdSwitchView.SwitchState switchState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, switchState) == null) {
                if (switchState == BdSwitchView.SwitchState.OFF) {
                    this.a.o = 2;
                } else {
                    this.a.o = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonConstellationActivity a;

        public b(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personConstellationActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 == this.a.c) {
                    this.a.d0();
                } else if (view2 == this.a.d) {
                    this.a.finish();
                } else if (view2 == this.a.g) {
                    this.a.J1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements fn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonConstellationActivity a;

        public d(PersonConstellationActivity personConstellationActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personConstellationActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personConstellationActivity;
        }

        @Override // com.baidu.tieba.fn5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, date, view2) != null) || date == null) {
                return;
            }
            if (date.getTime() > System.currentTimeMillis()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0e61);
                return;
            }
            this.a.i.setText(StringHelper.dateToConstellation(date));
            this.a.j.setText(StringHelper.getDateStringYearMonthDay(date));
            this.a.n = date.getTime() / 1000;
            if (this.a.e.getVisibility() != 0) {
                this.a.k.setVisibility(8);
                this.a.e.setVisibility(0);
                if (this.a.o == 1) {
                    this.a.e.k();
                } else {
                    this.a.e.h();
                }
            }
        }
    }

    public PersonConstellationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.q = new b(this);
        this.r = new d(this);
    }

    public static void K1(Activity activity, long j, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65546, null, new Object[]{activity, Long.valueOf(j), Integer.valueOf(i)}) != null) || activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(activity, PersonConstellationActivity.class);
        intent.putExtra("constellation_birthday", j);
        intent.putExtra("constellation_show_status", i);
        activity.startActivityForResult(intent, 1001);
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f == null) {
                ym5 ym5Var = new ym5(getActivity(), this.r);
                ym5Var.k(R.layout.obfuscated_res_0x7f0d0708, new c(this));
                ym5Var.f(18);
                ym5Var.p(new boolean[]{true, true, true, false, false, false});
                ym5Var.j("年", "月", "日", "时", "分", "秒");
                ym5Var.l(2.0f);
                ym5Var.o(0, 0, 0, 0, 0, 0);
                ym5Var.b(false);
                ym5Var.i(SkinManager.getColor(R.color.CAM_X0206));
                ym5Var.m(SkinManager.getColor(R.color.CAM_X0105));
                ym5Var.n(SkinManager.getColor(R.color.CAM_X0109));
                ym5Var.d(SkinManager.getColor(R.color.black_alpha30));
                ym5Var.e(SkinManager.getColor(R.color.CAM_X0201));
                ym5Var.c(false);
                ym5Var.h(this.h);
                this.f = ym5Var.a();
            }
            this.f.u();
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent intent = new Intent();
            intent.putExtra("constellation_birthday", this.n);
            intent.putExtra("constellation_show_status", this.o);
            setResult(-1, intent);
            finish();
        }
    }

    public final void initData() {
        Intent intent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (intent = getIntent()) != null) {
            this.n = intent.getLongExtra("constellation_birthday", 0L);
            this.o = intent.getIntExtra("constellation_show_status", 1);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            super.onChangeSkinType(i);
            this.a.onChangeSkinType(getPageContext(), i);
            this.e.b();
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1, i);
            SkinManager.setBackgroundResource(this.h, R.color.CAM_X0201, i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d071f);
            initData();
            this.h = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091957);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092604);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f0e7d)).setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
            View addCustomView = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d063f, (View.OnClickListener) null);
            this.c = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091c88);
            this.b = textView;
            textView.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbfontsize44));
            this.b.setText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0e79));
            SkinManager.setViewTextColor(this.b, R.color.navi_op_text, 1);
            this.c.setOnClickListener(this.q);
            ImageView imageView = (ImageView) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d090e, (View.OnClickListener) null);
            this.d = imageView;
            imageView.setOnClickListener(this.q);
            SkinManager.setImageResource(this.d, R.drawable.selector_topbar_return_black);
            BdSwitchView bdSwitchView = (BdSwitchView) findViewById(R.id.obfuscated_res_0x7f091958);
            this.e = bdSwitchView;
            bdSwitchView.setOnSwitchStateChangeListener(this.p);
            xi.b(getPageContext().getPageActivity(), this.e, 10, 10, 10, 10);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091953);
            this.g = relativeLayout;
            relativeLayout.setOnClickListener(this.q);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0906e8);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0906e6);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f0903ac);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091956);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091959);
            this.k = textView2;
            if (this.n == 0) {
                textView2.setVisibility(0);
                this.e.setVisibility(8);
                return;
            }
            textView2.setVisibility(8);
            this.e.setVisibility(0);
            if (this.o == 1) {
                this.e.m();
            } else {
                this.e.j();
            }
            Date date = new Date(this.n * 1000);
            this.i.setText(StringHelper.dateToConstellation(date));
            this.j.setText(StringHelper.getDateStringYearMonthDay(date));
        }
    }
}
