package com.baidu.tieba.pb.account.forbid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.dj;
import com.baidu.tieba.ej;
import com.baidu.tieba.nu4;
import com.baidu.tieba.qu7;
import com.baidu.tieba.ru7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class ForbidActivity extends BaseActivity<ForbidActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public RadioGroup b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public TextView k;
    public TextView l;
    public BdListView m;
    public d n;
    public nu4 o;
    public View.OnClickListener p;

    /* loaded from: classes5.dex */
    public class a implements RadioGroup.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbidActivity a;

        public a(ForbidActivity forbidActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbidActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbidActivity;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, radioGroup, i) == null) {
                ForbidActivity forbidActivity = this.a;
                forbidActivity.O1(forbidActivity.b.getCheckedRadioButtonId());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ru7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbidActivity a;

        public b(ForbidActivity forbidActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbidActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbidActivity;
        }

        @Override // com.baidu.tieba.ru7.b
        public void a(ForbidTplData forbidTplData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, forbidTplData) == null) {
                if (StringUtils.isNull(forbidTplData.error.errMsg)) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c59);
                } else {
                    this.a.showToast(forbidTplData.error.errMsg);
                }
            }
        }

        @Override // com.baidu.tieba.ru7.b
        public void b(ForbidTplData forbidTplData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidTplData) == null) {
                this.a.l.setText(this.a.h);
                int i = forbidTplData.type;
                if (i == 1 || i == 2) {
                    this.a.findViewById(R.id.obfuscated_res_0x7f091b48).setVisibility(0);
                    this.a.findViewById(R.id.obfuscated_res_0x7f091b47).setVisibility(0);
                }
                this.a.n = new d(forbidTplData.reason);
                this.a.m.setAdapter((ListAdapter) this.a.n);
                String[] strArr = forbidTplData.reason;
                if (strArr == null || strArr.length == 0) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c73);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForbidActivity a;

        /* loaded from: classes5.dex */
        public class a implements qu7.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* renamed from: com.baidu.tieba.pb.account.forbid.ForbidActivity$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0373a implements nu4.e {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0373a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.baidu.tieba.nu4.e
                public void onClick(nu4 nu4Var) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) || nu4Var == null) {
                        return;
                    }
                    nu4Var.dismiss();
                    this.a.a.a.getActivity().finish();
                }
            }

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

            @Override // com.baidu.tieba.qu7.b
            public void a(ForbidResultData forbidResultData) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, forbidResultData) == null) {
                    ForbidActivity forbidActivity = this.a.a;
                    forbidActivity.showToast(forbidActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0664));
                    this.a.a.finish();
                }
            }

            @Override // com.baidu.tieba.qu7.b
            public void b(ForbidResultData forbidResultData) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forbidResultData) == null) || forbidResultData == null) {
                    return;
                }
                String str = forbidResultData.error_msg;
                switch (forbidResultData.error_code) {
                    case NetWorkErr.ERROR_DELETE_MCN_USER_THREAD /* 1211067 */:
                    case NetWorkErr.ERROR_IS_REPEAT_FORBIDDEN /* 1211068 */:
                        if (this.a.a.o == null) {
                            ForbidActivity forbidActivity = this.a.a;
                            forbidActivity.o = new nu4(forbidActivity.getActivity());
                        }
                        this.a.a.o.setMessage(str);
                        this.a.a.o.setPositiveButton(R.string.obfuscated_res_0x7f0f09b7, new C0373a(this));
                        this.a.a.o.setCanceledOnTouchOutside(false);
                        this.a.a.o.create(this.a.a.getPageContext());
                        this.a.a.o.show();
                        return;
                    default:
                        ForbidActivity forbidActivity2 = this.a.a;
                        forbidActivity2.showToast(forbidActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0662));
                        return;
                }
            }
        }

        public c(ForbidActivity forbidActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forbidActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forbidActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ForbidActivity forbidActivity;
            View findViewById;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.n == null || dj.isEmpty(this.a.n.b()) || (findViewById = (forbidActivity = this.a).findViewById(forbidActivity.b.getCheckedRadioButtonId())) == null) {
                return;
            }
            qu7.b(this.a.c, this.a.d, this.a.e, this.a.g, this.a.j, (String) findViewById.getTag(), this.a.n.b(), this.a.h, this.a.i, new a(this));
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String[] a;
        public int b;
        public View.OnClickListener c;

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.b = ((e) view2.getTag()).c;
                    this.a.notifyDataSetChanged();
                }
            }
        }

        public d(String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = 0;
            this.c = new a(this);
            this.a = strArr;
        }

        public String b() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String[] strArr = this.a;
                if (strArr == null || (i = this.b) >= strArr.length) {
                    return null;
                }
                return strArr[i];
            }
            return (String) invokeV.objValue;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                String[] strArr = this.a;
                if (strArr == null) {
                    return 0;
                }
                return strArr.length;
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                return null;
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                return 0L;
            }
            return invokeI.longValue;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"ResourceAsColor"})
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            e eVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d029e, (ViewGroup) null);
                    eVar = new e(null);
                    eVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091b65);
                    eVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090610);
                    view2.setTag(eVar);
                    view2.setOnClickListener(this.c);
                } else {
                    eVar = (e) view2.getTag();
                }
                eVar.c = i;
                eVar.a.setText(this.a[i]);
                if (eVar.c == this.b) {
                    SkinManager.setImageResource(eVar.b, R.drawable.icon_found_information_choose);
                    eVar.b.setVisibility(0);
                    SkinManager.setViewTextColor(eVar.a, R.color.common_color_10047, 1);
                } else {
                    eVar.b.setVisibility(4);
                    SkinManager.setViewTextColor(eVar.a, R.color.common_color_10039, 1);
                }
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ImageView b;
        public int c;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public ForbidActivity() {
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
        this.p = new c(this);
    }

    public final void O1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            for (int i2 = 0; i2 < 3; i2++) {
                RadioButton radioButton = (RadioButton) this.b.getChildAt(i2);
                if (radioButton.getId() == i) {
                    SkinManager.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_s);
                    SkinManager.setViewTextColor(radioButton, R.color.CAM_X0101, 3);
                } else {
                    SkinManager.setBackgroundResource(radioButton, R.drawable.btn_prohibit_day_n);
                    SkinManager.setViewTextColor(radioButton, R.color.common_color_10039, 3);
                }
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent intent = getIntent();
            this.c = intent.getStringExtra("forum_id");
            this.d = intent.getStringExtra("forum_name");
            this.e = intent.getStringExtra("thread_id");
            this.f = intent.getStringExtra(ForbidActivityConfig.MANAGER_USER_ID);
            this.g = intent.getStringExtra("user_name");
            this.j = intent.getStringExtra("post_id");
            this.h = intent.getStringExtra("name_show");
            this.i = intent.getStringExtra("portrait");
            ru7.b(this.c, this.f, new b(this));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.onChangeSkinType(i);
            boolean z = i == 1;
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091c6c);
            getLayoutMode().l(z);
            getLayoutMode().k(findViewById);
            this.a.onChangeSkinType(getPageContext(), i);
            this.k.setTextColor(SkinManager.getColor(R.color.CAM_X0106));
            this.m.setDivider(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080584));
            this.m.setDividerHeight(ej.d(getPageContext().getPageActivity(), 1.0f));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0021);
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0925c4);
                this.a = navigationBar;
                navigationBar.setTitleText(getPageContext().getString(R.string.obfuscated_res_0x7f0f0663));
                this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
                this.k = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f0661), this.p);
                this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f090a3f);
                this.m = (BdListView) findViewById(R.id.obfuscated_res_0x7f09133b);
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.obfuscated_res_0x7f090a3e);
                this.b = radioGroup;
                radioGroup.setOnCheckedChangeListener(new a(this));
                initData();
                return;
            }
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11018)));
        }
    }
}
