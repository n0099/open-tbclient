package com.baidu.tieba.interestlabel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.o0.f0.g;
import c.a.o0.f0.h;
import c.a.o0.r.t.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LabelSettingView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f34160b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.z1.c.a f34161c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f34162d;

    /* renamed from: e  reason: collision with root package name */
    public View f34163e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34164f;

    /* renamed from: g  reason: collision with root package name */
    public NoNetworkView f34165g;

    /* renamed from: h  reason: collision with root package name */
    public GridLineView f34166h;
    public g i;
    public h j;
    public c.a.p0.z1.a.b k;
    public c.a.o0.r.t.a l;
    public boolean m;
    public NoNetworkView.b n;

    /* loaded from: classes5.dex */
    public class a implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LabelSettingView a;

        public a(LabelSettingView labelSettingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = labelSettingView;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && z && this.a.k.getCount() == 0 && this.a.f34161c != null) {
                this.a.f34161c.getLabel();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LabelSettingView a;

        public b(LabelSettingView labelSettingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = labelSettingView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.a.f34160b.getPageActivity().finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LabelSettingView a;

        public c(LabelSettingView labelSettingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = labelSettingView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LabelSettingView a;

        public d(LabelSettingView labelSettingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {labelSettingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = labelSettingView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && l.A() && this.a.f34161c != null) {
                this.a.f34161c.getLabel();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelSettingView(TbPageContext<?> tbPageContext, c.a.p0.z1.c.a aVar) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.n = new a(this);
        this.f34160b = tbPageContext;
        this.f34161c = aVar;
        i(tbPageContext.getPageActivity());
        l();
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.m = z;
            this.f34164f.setSelected(z);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            NoNetworkView noNetworkView = this.f34165g;
            if (noNetworkView != null) {
                noNetworkView.d(this.n);
            }
            this.l.dismiss();
            g();
            h();
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.z1.a.b bVar = this.k;
            if (bVar == null) {
                return false;
            }
            return !ListUtils.equalList(bVar.f(), this.k.g());
        }
        return invokeV.booleanValue;
    }

    public void g() {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (gVar = this.i) == null) {
            return;
        }
        gVar.dettachView(this);
        this.i = null;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.j) == null) {
            return;
        }
        hVar.dettachView(this);
        this.j = null;
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d003e, (ViewGroup) this, true);
            this.f34162d = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09119e);
            this.f34165g = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f09119f);
            this.f34166h = (GridLineView) findViewById(R.id.obfuscated_res_0x7f09119d);
            this.f34162d.setTitleText(context.getString(R.string.obfuscated_res_0x7f0f03b4));
            this.f34163e = this.f34162d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
            this.f34164f = (TextView) this.f34162d.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0407, this);
            this.f34165g.a(this.n);
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.f34160b.getPageActivity());
            this.l = aVar;
            aVar.setMessage(this.f34160b.getString(R.string.obfuscated_res_0x7f0f041e));
            this.l.setPositiveButton(this.f34160b.getString(R.string.obfuscated_res_0x7f0f025c), new b(this));
            this.l.setNegativeButton(this.f34160b.getString(R.string.obfuscated_res_0x7f0f036c), new c(this));
            this.l.create(this.f34160b);
            c.a.p0.z1.a.b bVar = new c.a.p0.z1.a.b(this);
            this.k = bVar;
            this.f34166h.setAdapter((ListAdapter) bVar);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.i;
            if (gVar != null) {
                return gVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            h hVar = this.j;
            if (hVar != null) {
                return hVar.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        int skinType;
        NoNetworkView noNetworkView;
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.a) {
            return;
        }
        this.a = skinType;
        TbPageContext<?> tbPageContext = this.f34160b;
        if (tbPageContext != null && (navigationBar = this.f34162d) != null) {
            navigationBar.onChangeSkinType(tbPageContext, skinType);
        }
        TextView textView = this.f34164f;
        if (textView != null) {
            SkinManager.setViewTextColor(textView, (int) R.drawable.color_nav_complete_selector);
        }
        TbPageContext<?> tbPageContext2 = this.f34160b;
        if (tbPageContext2 != null && (noNetworkView = this.f34165g) != null) {
            noNetworkView.c(tbPageContext2, this.a);
        }
        GridLineView gridLineView = this.f34166h;
        if (gridLineView != null) {
            gridLineView.d();
        }
        g gVar = this.i;
        if (gVar != null) {
            gVar.onChangeSkinType();
        }
        h hVar = this.j;
        if (hVar != null) {
            hVar.onChangeSkinType();
        }
        c.a.p0.z1.a.b bVar = this.k;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        setBackgroundColor(SkinManager.getColor(this.a, (int) R.color.CAM_X0205));
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l.show();
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || j()) {
            return;
        }
        if (this.i == null) {
            g gVar = new g(getContext());
            this.i = gVar;
            gVar.onChangeSkinType();
        }
        this.i.attachView(this, z);
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || k()) {
            return;
        }
        if (this.j == null) {
            this.j = new h(getContext(), new d(this));
        }
        this.j.k(this.f34160b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702aa));
        this.j.attachView(this, z);
        this.j.p();
        this.f34166h.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            if (view == this.f34163e) {
                if (f()) {
                    m();
                } else {
                    this.f34160b.getPageActivity().finish();
                }
            } else if (view == this.f34164f && this.f34161c != null && this.m) {
                TiebaStatic.log(new StatisticItem("c12237").param("uid", TbadkCoreApplication.getCurrentAccount()));
                this.f34161c.subLabel(this.k.g());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            e();
            super.onDetachedFromWindow();
        }
    }

    public void setData(c.a.p0.z1.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) || bVar == null || ListUtils.isEmpty(bVar.b())) {
            return;
        }
        this.f34166h.setVisibility(0);
        this.k.h(bVar);
        this.k.notifyDataSetChanged();
    }
}
