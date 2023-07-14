package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SearchSug.DataRes;
/* loaded from: classes8.dex */
public class t29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public NavigationBar c;
    public EditText d;
    public ImageView e;
    public TextView f;
    public ImageView g;
    public LinearLayout h;
    public RelativeLayout i;
    public boolean j;
    public LinearLayoutDetectsSoftKeyboard k;
    public FrameLayout l;
    public NoDataView m;
    public TbWebView n;
    public TbWebView o;
    public View p;
    public boolean q;
    public BdTypeRecyclerView r;
    public w29 s;
    public final RecyclerView.OnScrollListener t;
    public View u;

    /* loaded from: classes8.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t29 a;

        public a(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t29Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 2 || i == 1) {
                    yi.A(this.a.a, recyclerView);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                super.onScrolled(recyclerView, i, i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t29 a;

        public b(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t29Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.a.k.setFocusable(true);
                    this.a.k.setFocusableInTouchMode(true);
                    if (this.a.d.hasFocus()) {
                        yi.A(this.a.a, this.a.d);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t29 a;

        public c(t29 t29Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t29Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.setText("");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements on6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ on6 a;

        public d(t29 t29Var, on6 on6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t29Var, on6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = on6Var;
        }

        @Override // com.baidu.tieba.on6
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, webView, str)) == null) {
                on6 on6Var = this.a;
                if (on6Var != null) {
                    return on6Var.shouldOverrideUrlLoading(webView, str);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public t29(View view2, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = true;
        this.q = true;
        this.t = new a(this);
        this.b = view2;
        this.a = context;
        m();
    }

    public void D(TextView.OnEditorActionListener onEditorActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onEditorActionListener) == null) {
            this.d.setOnEditorActionListener(onEditorActionListener);
        }
    }

    public void E(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onFocusChangeListener) == null) {
            this.d.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && !StringUtils.isNull(str)) {
            this.d.setHint(str);
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !StringUtils.isNull(str)) {
            this.d.setText(str);
            this.d.setSelection(str.length());
        }
    }

    public void H(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, textWatcher) == null) {
            this.d.addTextChangedListener(textWatcher);
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.o.q(System.currentTimeMillis());
            this.o.loadUrl(str);
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.n.q(System.currentTimeMillis());
            this.n.loadUrl(str);
        }
    }

    public void u(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            ImageView imageView = this.e;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void w(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, eVar) == null) {
            this.m.setTextOption(eVar);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
            this.d.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
        }
    }

    public void A(on6 on6Var, pn6 pn6Var, rn6 rn6Var, sn6 sn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, on6Var, pn6Var, rn6Var, sn6Var) == null) {
            B(this.n, on6Var, pn6Var, rn6Var, sn6Var);
        }
    }

    public void z(on6 on6Var, pn6 pn6Var, rn6 rn6Var, sn6 sn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048609, this, on6Var, pn6Var, rn6Var, sn6Var) == null) {
            B(this.o, on6Var, pn6Var, rn6Var, sn6Var);
        }
    }

    public void B(TbWebView tbWebView, on6 on6Var, pn6 pn6Var, rn6 rn6Var, sn6 sn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbWebView, on6Var, pn6Var, rn6Var, sn6Var) == null) {
            tbWebView.setOnLoadUrlListener(new d(this, on6Var));
            tbWebView.setOnPageFinishedListener(pn6Var);
            tbWebView.setOnReceivedErrorListener(rn6Var);
            tbWebView.setOnReceivedSslErrorListener(sn6Var);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.r.setVisibility(8);
            TbWebView tbWebView = this.o;
            if (tbWebView != null) {
                tbWebView.setVisibility(8);
            }
            TbWebView tbWebView2 = this.n;
            if (tbWebView2 != null) {
                tbWebView2.setVisibility(0);
            }
            this.m.setVisibility(8);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.r.setVisibility(0);
            TbWebView tbWebView = this.o;
            if (tbWebView != null) {
                tbWebView.setVisibility(8);
            }
            TbWebView tbWebView2 = this.n;
            if (tbWebView2 != null) {
                tbWebView2.setVisibility(8);
            }
            this.m.setVisibility(8);
            this.i.setBackgroundResource(0);
        }
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public TbWebView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.o;
        }
        return (TbWebView) invokeV.objValue;
    }

    public TbWebView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.n;
        }
        return (TbWebView) invokeV.objValue;
    }

    public EditText g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.d;
        }
        return (EditText) invokeV.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.d.setText("");
            this.d.requestFocus();
            this.f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f03ce));
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.r.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.o.onPause();
            this.n.onPause();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            TbWebView tbWebView = this.o;
            if (tbWebView != null) {
                tbWebView.setVisibility(0);
            }
            this.r.setVisibility(8);
            TbWebView tbWebView2 = this.n;
            if (tbWebView2 != null) {
                tbWebView2.setVisibility(8);
                this.n.loadUrl("about:blank");
            }
            this.m.setVisibility(8);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.r.setVisibility(8);
            TbWebView tbWebView = this.o;
            if (tbWebView != null) {
                tbWebView.setVisibility(8);
            }
            TbWebView tbWebView2 = this.n;
            if (tbWebView2 != null) {
                tbWebView2.setVisibility(8);
            }
            this.m.setVisibility(0);
        }
    }

    public void I(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dataRes, str) != null) || dataRes == null) {
            return;
        }
        J();
        w29 w29Var = this.s;
        if (w29Var != null) {
            w29Var.c(dataRes, str);
        }
    }

    public void K(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.q = z;
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType != 0 && this.q) {
                this.p.setVisibility(0);
                View view2 = this.p;
                if (skinType == 4) {
                    i = R.color.CAM_X0606;
                } else {
                    i = R.color.CAM_X0605;
                }
                view2.setBackgroundColor(SkinManager.getColor(i));
                return;
            }
            this.p.setVisibility(8);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.showBottomLine();
            View addCustomView = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d08eb, (View.OnClickListener) null);
            this.u = addCustomView;
            this.g = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f0920cc);
            this.d = (EditText) this.u.findViewById(R.id.obfuscated_res_0x7f090f5a);
            this.e = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f090f4a);
            this.f = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090f49);
            this.h = (LinearLayout) this.u.findViewById(R.id.obfuscated_res_0x7f091600);
            this.i = (RelativeLayout) this.u.findViewById(R.id.obfuscated_res_0x7f091f60);
            this.e.setOnClickListener(new c(this));
            u(false);
            this.f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f03ce));
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.o.onResume();
            this.n.onResume();
            if (!StringUtils.isNull(this.d.getText().toString())) {
                this.u.setFocusable(true);
                this.u.setFocusableInTouchMode(true);
                this.u.requestFocus();
            }
            if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.j) {
                TbWebView tbWebView = this.n;
                if (tbWebView != null && tbWebView.getVisibility() == 0) {
                    jn6.a().d(this.n, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
                TbWebView tbWebView2 = this.o;
                if (tbWebView2 != null && tbWebView2.getVisibility() == 0) {
                    jn6.a().d(this.o, CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
            }
            this.j = false;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.o = (TbWebView) this.b.findViewById(R.id.obfuscated_res_0x7f0920e4);
            Drawable drawable = ResourcesCompat.getDrawable(SelectorHelper.getResources(), R.drawable.obfuscated_res_0x7f080539, this.a.getTheme());
            this.o.V((int) SelectorHelper.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703eb), drawable);
            this.p = this.b.findViewById(R.id.obfuscated_res_0x7f092106);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            h();
            LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) this.b.findViewById(R.id.obfuscated_res_0x7f0920d3);
            this.k = linearLayoutDetectsSoftKeyboard;
            linearLayoutDetectsSoftKeyboard.setOnTouchListener(new b(this));
            this.l = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090c28);
            NoDataView a2 = NoDataViewFactory.a(this.a, null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07038f)), null, null);
            this.m = a2;
            this.l.addView(a2, 0);
            i();
            k();
            j();
            l();
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.n = (TbWebView) this.b.findViewById(R.id.obfuscated_res_0x7f0920f6);
            Drawable drawable = ResourcesCompat.getDrawable(SelectorHelper.getResources(), R.drawable.obfuscated_res_0x7f080539, this.a.getTheme());
            this.n.V((int) SelectorHelper.getResources().getDimension(R.dimen.obfuscated_res_0x7f0703eb), drawable);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.b.findViewById(R.id.obfuscated_res_0x7f090f63);
            this.r = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a));
            this.r.setOnScrollListener(this.t);
            this.s = new w29(this.a, this.r);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            try {
                if (this.l != null) {
                    this.l.removeView(this.o);
                    this.l.removeView(this.n);
                }
                this.o.removeAllViews();
                this.n.removeAllViews();
                if (this.o != null) {
                    this.o.onDestroy();
                    this.o = null;
                }
                if (this.n != null) {
                    this.n.onDestroy();
                    this.n = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void q(l9<?> l9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, l9Var, i) == null) {
            NoDataView noDataView = this.m;
            if (noDataView != null) {
                noDataView.f(l9Var, i);
            }
            w29 w29Var = this.s;
            if (w29Var != null) {
                w29Var.b();
            }
            SkinManager.setBgColor(this.k, i);
            if (i == 2) {
                this.d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
            } else {
                this.d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            this.c.onChangeSkinType(l9Var, i);
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f080c67, R.color.CAM_X0109, null);
            SkinManager.setNavbarTitleColor(this.d, R.color.CAM_X0105, R.color.s_navbar_title_color);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0107, 1);
            K(this.q);
            TbWebView tbWebView = this.o;
            if (tbWebView != null) {
                d85.d(tbWebView).f(R.color.CAM_X0503);
            }
            TbWebView tbWebView2 = this.n;
            if (tbWebView2 != null) {
                d85.d(tbWebView2).f(R.color.CAM_X0503);
            }
            d85 d2 = d85.d(this.h);
            d2.x(R.color.CAM_X0109);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0210);
        }
    }
}
