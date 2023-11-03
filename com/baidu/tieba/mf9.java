package com.baidu.tieba;

import android.content.Context;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.quickWebView.QuickWebView;
import com.baidu.tieba.view.LinearLayoutDetectsSoftKeyboard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.SearchSug.DataRes;
/* loaded from: classes7.dex */
public class mf9 {
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
    public QuickWebView n;
    public QuickWebView o;
    public View p;
    public boolean q;
    public BdTypeRecyclerView r;
    public we9 s;
    public final RecyclerView.OnScrollListener t;
    public View u;

    /* loaded from: classes7.dex */
    public class a extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mf9 a;

        public a(mf9 mf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mf9Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 2 || i == 1) {
                    BdUtilHelper.hideSoftKeyPad(this.a.a, recyclerView);
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

    /* loaded from: classes7.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mf9 a;

        public b(mf9 mf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mf9Var;
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
                        BdUtilHelper.hideSoftKeyPad(this.a.a, this.a.d);
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mf9 a;

        public c(mf9 mf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mf9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.d.setText("");
            }
        }
    }

    public mf9(View view2, Context context) {
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

    public void A(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str)) {
            this.d.setText(str);
            this.d.setSelection(str.length());
        }
    }

    public void B(TextWatcher textWatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textWatcher) == null) {
            this.d.addTextChangedListener(textWatcher);
        }
    }

    public void E(BaseWebView.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.n.setOnLoadUrlListener(cVar);
        }
    }

    public void F(BaseWebView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            this.n.setOnPageFinishedListener(dVar);
        }
    }

    public void G(BaseWebView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            this.n.setOnReceivedSslErrorListener(hVar);
        }
    }

    public void H(BaseWebView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.n.setOnReceivedErrorListener(gVar);
        }
    }

    public void r(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            ImageView imageView = this.e;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void t(NoDataViewFactory.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, eVar) == null) {
            this.m.setTextOption(eVar);
        }
    }

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.d.setOnClickListener(onClickListener);
            this.f.setOnClickListener(onClickListener);
        }
    }

    public void x(TextView.OnEditorActionListener onEditorActionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onEditorActionListener) == null) {
            this.d.setOnEditorActionListener(onEditorActionListener);
        }
    }

    public void y(View.OnFocusChangeListener onFocusChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onFocusChangeListener) == null) {
            this.d.setOnFocusChangeListener(onFocusChangeListener);
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, str) == null) && !StringUtils.isNull(str)) {
            this.d.setHint(str);
        }
    }

    public void C(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) != null) || dataRes == null) {
            return;
        }
        D();
        we9 we9Var = this.s;
        if (we9Var != null) {
            we9Var.c(dataRes, str);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.setVisibility(0);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
            this.i.setBackgroundResource(0);
        }
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public QuickWebView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.o;
        }
        return (QuickWebView) invokeV.objValue;
    }

    public QuickWebView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.n;
        }
        return (QuickWebView) invokeV.objValue;
    }

    public EditText g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.d;
        }
        return (EditText) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            QuickWebView quickWebView = (QuickWebView) this.b.findViewById(R.id.obfuscated_res_0x7f092184);
            this.o = quickWebView;
            quickWebView.l(true);
            this.p = this.b.findViewById(R.id.obfuscated_res_0x7f0921a6);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            QuickWebView quickWebView = (QuickWebView) this.b.findViewById(R.id.obfuscated_res_0x7f092196);
            this.n = quickWebView;
            quickWebView.l(true);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.d.setText("");
            this.d.requestFocus();
            this.f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f03d3));
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.r.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.o.setVisibility(0);
            this.r.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(8);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.r.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            this.m.setVisibility(0);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.r.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(0);
            this.m.setVisibility(8);
        }
    }

    public void I(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.view_navigation_bar);
            this.c = navigationBar;
            navigationBar.showBottomLine();
            View addCustomView = this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, R.layout.obfuscated_res_0x7f0d0919, (View.OnClickListener) null);
            this.u = addCustomView;
            this.g = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09216c);
            this.d = (EditText) this.u.findViewById(R.id.obfuscated_res_0x7f090fc0);
            this.e = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f090fb0);
            this.f = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090faf);
            this.h = (LinearLayout) this.u.findViewById(R.id.obfuscated_res_0x7f091676);
            this.i = (RelativeLayout) this.u.findViewById(R.id.obfuscated_res_0x7f091fff);
            this.e.setOnClickListener(new c(this));
            r(false);
            this.f.setText(this.a.getString(R.string.obfuscated_res_0x7f0f03d3));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!StringUtils.isNull(this.d.getText().toString())) {
                this.u.setFocusable(true);
                this.u.setFocusableInTouchMode(true);
                this.u.requestFocus();
            }
            if (CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.WEB && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NONE && CurrentPageTypeHelper.currentPageType != CurrentPageTypeHelper.PageType.NATIVE_WEB && !this.j) {
                QuickWebView quickWebView = this.n;
                if (quickWebView != null && quickWebView.getVisibility() == 0) {
                    this.n.sendNotification(CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
                QuickWebView quickWebView2 = this.o;
                if (quickWebView2 != null && quickWebView2.getVisibility() == 0) {
                    this.o.sendNotification(CommonTbJsBridge.GO_BACK_FROM_NATIVE, null);
                }
            }
            this.j = false;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) this.b.findViewById(R.id.obfuscated_res_0x7f090fc9);
            this.r = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this.a));
            this.r.setOnScrollListener(this.t);
            this.s = new we9(this.a, this.r);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            try {
                if (this.l != null) {
                    this.l.removeView(this.o);
                    this.l.removeView(this.n);
                }
                this.o.removeAllViews();
                this.n.removeAllViews();
                if (this.o != null) {
                    this.o.destroy();
                    this.o = null;
                }
                if (this.n != null) {
                    this.n.destroy();
                    this.n = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            h();
            LinearLayoutDetectsSoftKeyboard linearLayoutDetectsSoftKeyboard = (LinearLayoutDetectsSoftKeyboard) this.b.findViewById(R.id.obfuscated_res_0x7f092173);
            this.k = linearLayoutDetectsSoftKeyboard;
            linearLayoutDetectsSoftKeyboard.setOnTouchListener(new b(this));
            this.l = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090c81);
            NoDataView a2 = NoDataViewFactory.a(this.a, null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07038f)), null, null);
            this.m = a2;
            this.l.addView(a2, 0);
            i();
            k();
            j();
            l();
        }
    }

    public void o(BdPageContext<?> bdPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, bdPageContext, i) == null) {
            NoDataView noDataView = this.m;
            if (noDataView != null) {
                noDataView.f(bdPageContext, i);
            }
            we9 we9Var = this.s;
            if (we9Var != null) {
                we9Var.b();
            }
            SkinManager.setBgColor(this.k, i);
            if (i == 2) {
                this.d.setHintTextColor(SkinManager.getColor(R.color.s_navbar_title_color));
            } else {
                this.d.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
            }
            this.c.onChangeSkinType(bdPageContext, i);
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f080c9f, R.color.CAM_X0109, null);
            SkinManager.setNavbarTitleColor(this.d, R.color.CAM_X0105, R.color.s_navbar_title_color);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            SkinManager.setBackgroundResource(this.l, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0107, 1);
            I(this.q);
            QuickWebView quickWebView = this.o;
            if (quickWebView != null) {
                quickWebView.onChangeSkinType();
            }
            QuickWebView quickWebView2 = this.n;
            if (quickWebView2 != null) {
                quickWebView2.onChangeSkinType();
            }
            EMManager.from(this.h).setTextColor(R.color.CAM_X0109).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0210);
        }
    }
}
