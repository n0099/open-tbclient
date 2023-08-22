package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.coreExtra.util.DialogUtil;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.c07;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.s45;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.x17;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class jz6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public x17 c;
    public c07 d;
    public EnterForumModel e;
    public List<w15> f;
    public boolean g;
    public pz6 h;
    public r17 i;
    public HashSet<Long> j;

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz6 a;

        /* loaded from: classes6.dex */
        public class a implements s45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.s45.e
            public void onClick(s45 s45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                    gha.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", null);
                    s45Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements s45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.s45.e
            public void onClick(s45 s45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                    s45Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements s45.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.s45.e
            public void onClick(s45 s45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, s45Var) == null) {
                    s45Var.dismiss();
                }
            }
        }

        public e(jz6 jz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String N;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.P()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new zq5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.R().b();
                if (b2 != null) {
                    int O = b2.O();
                    if (O != 220012) {
                        if (O == 2121002) {
                            DialogUtil.createAlertDialog(this.a.a, (String) null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f050b), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f16b3), this.a.a.getResources().getString(R.string.think_more), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (di.isEmpty(b2.N())) {
                            N = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0507);
                        } else {
                            N = b2.N();
                        }
                        blockPopInfoData.block_info = N;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0509);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b46);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z = true;
                }
                if (!z) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0508);
                    if (b2 != null) {
                        if (di.isEmpty(b2.N())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0508);
                        } else {
                            string = b2.N();
                        }
                    }
                    DialogUtil.createAlertDialog(this.a.a, (String) null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b46), (String) null, new c(this), (s45.e) null).show();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements x17.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r17 a;
        public final /* synthetic */ jz6 b;

        public a(jz6 jz6Var, r17 r17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var, r17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jz6Var;
            this.a = r17Var;
        }

        @Override // com.baidu.tieba.x17.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.q());
                this.a.z0(this.b.c.r());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements c07.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz6 a;

        public b(jz6 jz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz6Var;
        }

        @Override // com.baidu.tieba.c07.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.Z(true, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz6 a;

        public c(jz6 jz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new zq5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz6 a;

        public d(jz6 jz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new zq5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public f(jz6 jz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(jz6 jz6Var, a aVar) {
            this(jz6Var);
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public NoDataView b;

        public g(jz6 jz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(jz6 jz6Var, a aVar) {
            this(jz6Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public h(jz6 jz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(jz6 jz6Var, a aVar) {
            this(jz6Var);
        }
    }

    public jz6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, r17 r17Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, r17Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.g = true;
        this.a = tbPageContext;
        this.b = viewEventCenter;
        this.j = new HashSet<>();
        this.i = r17Var;
        x17 x17Var = new x17(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = x17Var;
        x17Var.C(new a(this, r17Var));
        this.e = enterForumModel;
        c07 c07Var = new c07(this.a.getPageActivity(), Integer.valueOf(iz6.a(1)).intValue(), 0, this.c);
        this.d = c07Var;
        c07Var.u(new b(this));
    }

    public void g(int i) {
        x17 x17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (x17Var = this.c) != null) {
            x17Var.u(i);
        }
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int size = this.f.size();
            if (size > 0 && i < size) {
                return this.f.get(i);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            List<w15> list = this.f;
            if (list != null && (i >= list.size() || i < 0)) {
                return -1L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (i < this.f.size() && i >= 0) {
                return this.f.get(i).c();
            }
            return 6;
        }
        return invokeI.intValue;
    }

    public void j(int i) {
        c07 c07Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (c07Var = this.d) != null) {
            c07Var.t(i);
        }
    }

    public void k(pz6 pz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pz6Var) == null) {
            if (pz6Var != this.h) {
                this.h = pz6Var;
                notifyDataSetChanged();
            }
            x17 x17Var = this.c;
            if (x17Var != null) {
                x17Var.A(pz6Var);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        x17 x17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (x17Var = this.c) != null) {
            x17Var.D(bdUniqueId);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            x17 x17Var = this.c;
            if (x17Var == null) {
                return false;
            }
            return x17Var.j();
        }
        return invokeV.booleanValue;
    }

    public List<w15> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return w15.c.length;
        }
        return invokeV.intValue;
    }

    public void h() {
        x17 x17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (x17Var = this.c) != null) {
            x17Var.v();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = true;
            this.j.clear();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g) {
            TiebaStatic.log("c13378");
            this.g = false;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        h hVar;
        u17 u17Var;
        w15 w15Var;
        f fVar;
        g gVar;
        NoDataViewFactory.d b2;
        NoDataViewFactory.e a2;
        NoDataViewFactory.c a3;
        y17 y17Var;
        c27 c27Var;
        d27 d27Var;
        b27 b27Var;
        z17 z17Var;
        a27 a27Var;
        t17 t17Var;
        tz6 tz6Var;
        s17 s17Var;
        nz6 nz6Var;
        t07 t07Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            boolean z = true;
            boolean z2 = true;
            int i2 = 1;
            boolean z3 = false;
            switch (getItemViewType(i)) {
                case 0:
                    if (view2 != null && (view2.getTag() instanceof h)) {
                        hVar = (h) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02bc, viewGroup, false);
                        hVar = new h(this, null);
                        hVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09258f);
                        hVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092261);
                        hVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907b5);
                        view2.setTag(hVar);
                    }
                    if (this.f.get(i) instanceof rz6) {
                        rz6 rz6Var = (rz6) this.f.get(i);
                        this.d.v(hVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (rz6Var != null) {
                            hVar.a.setText(rz6Var.d);
                            SkinManager.setViewTextColor(hVar.a, (int) R.color.CAM_X0105);
                            pz6 pz6Var = this.h;
                            if ((pz6Var != null && pz6Var.a) || rz6Var.f) {
                                SkinManager.setBackgroundResource(hVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(hVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = hVar.b;
                            if (textView != null) {
                                if (rz6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(hVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.c.getLayoutParams();
                            if (rz6Var.g != -1) {
                                layoutParams.setMargins(BdUtilHelper.getDimens(viewGroup.getContext(), rz6Var.g), 0, BdUtilHelper.getDimens(viewGroup.getContext(), rz6Var.g), 0);
                            }
                            if (rz6Var.i != -1) {
                                EMManager.from(hVar.a).setTextSize(rz6Var.i);
                            }
                            if (rz6Var.h != -1) {
                                layoutParams.height = BdUtilHelper.getDimens(viewGroup.getContext(), rz6Var.h);
                            }
                            hVar.c.setLayoutParams(layoutParams);
                            if (rz6Var.j != -1) {
                                hVar.c.setPadding(BdUtilHelper.getDimens(viewGroup.getContext(), rz6Var.j), 0, BdUtilHelper.getDimens(viewGroup.getContext(), rz6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof u17)) {
                        u17Var = (u17) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d03fe, viewGroup, false);
                        u17Var = new u17(this.a, view2, this.b);
                        view2.setTag(u17Var);
                    }
                    if ((this.f.get(i) instanceof w15) && (w15Var = this.f.get(i)) != null) {
                        u17Var.f(w15Var);
                    }
                    u17Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02bb, (ViewGroup) null);
                        fVar = new f(this, null);
                        fVar.a = (TextView) view2.findViewById(R.id.footer_text);
                        fVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0907b5);
                        view2.setTag(fVar);
                    }
                    View view3 = fVar.b;
                    if (view3 != null) {
                        view3.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(fVar.a, (int) R.color.CAM_X0304);
                    return view2;
                case 3:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02b9, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091f96);
                        gVar.b = NoDataViewFactory.a(this.a.getPageActivity(), gVar.a, null, null, null);
                        view2.setTag(gVar);
                    }
                    d dVar = new d(this);
                    if (!TbadkCoreApplication.isLogin()) {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NOTLOGIN, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f066d);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0464), dVar));
                    } else {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f07ef);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0462), dVar));
                    }
                    gVar.b.setImgOption(b2);
                    gVar.b.setTextOption(a2);
                    gVar.b.setButtonOption(a3);
                    gVar.b.setVisibility(0);
                    SkinManager.setBackgroundColor(gVar.a, R.color.CAM_X0205);
                    gVar.b.f(this.a, TbadkCoreApplication.getInst().getSkinType());
                    return view2;
                case 4:
                    if (view2 == null) {
                        View m = this.c.m();
                        this.c.x();
                        return m;
                    }
                    return view2;
                case 5:
                    n();
                    if (view2 != null && (view2.getTag() instanceof y17)) {
                        y17Var = (y17) view2.getTag();
                    } else {
                        y17Var = new y17(this.a);
                        view2 = y17Var.b();
                        view2.setTag(y17Var);
                    }
                    y17Var.a();
                    y17Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof c27)) {
                        c27Var = (c27) view2.getTag();
                    } else {
                        c27Var = new c27(this.a);
                        view2 = c27Var.d();
                        view2.setTag(c27Var);
                    }
                    if (this.f.get(i) instanceof o35) {
                        c27Var.c((o35) this.f.get(i));
                    }
                    if (this.e.R() != null && this.e.R().e() != null && this.e.R().e().b() != null) {
                        if (this.e.R().e().b().size() <= 0) {
                            z = false;
                        }
                        c27Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof d27)) {
                        d27Var = (d27) view2.getTag();
                    } else {
                        d27Var = new d27(this.a);
                        view2 = d27Var.k();
                        view2.setTag(d27Var);
                    }
                    if (this.f.get(i) instanceof m35) {
                        m35 m35Var = (m35) this.f.get(i);
                        d27Var.g(m35Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(m35Var.f()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", m35Var.f());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.R() != null && this.e.R().e() != null && this.e.R().e().b() != null) {
                                if (this.e.R().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i2 = 3;
                                }
                                statisticItem.param("obj_type", i2);
                                d27Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(m35Var.f()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof b27)) {
                        b27Var = (b27) view2.getTag();
                    } else {
                        b27Var = new b27(this.a);
                        view2 = b27Var.c();
                        view2.setTag(b27Var);
                    }
                    if (this.f.get(i) instanceof n35) {
                        b27Var.b((n35) this.f.get(i));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof z17)) {
                        z17Var = (z17) view2.getTag();
                    } else {
                        z17Var = new z17(this.a);
                        view2 = z17Var.d();
                        view2.setTag(z17Var);
                    }
                    if (this.f.get(i) instanceof lz6) {
                        z17Var.c((lz6) this.f.get(i));
                    }
                    if (this.e.R() != null && this.e.R().e() != null && this.e.R().e().b() != null) {
                        if (this.e.R().e().b().size() <= 0) {
                            z2 = false;
                        }
                        z17Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof a27)) {
                        a27Var = (a27) view2.getTag();
                    } else {
                        a27Var = new a27(this.a);
                        view2 = a27Var.b();
                        view2.setTag(a27Var);
                    }
                    a27Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof t17)) {
                        t17Var = (t17) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d05af, viewGroup, false);
                        t17Var = new t17(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(t17Var);
                    }
                    if ((this.f.get(i) instanceof tz6) && (tz6Var = (tz6) this.f.get(i)) != null) {
                        t17Var.f(tz6Var);
                    }
                    t17Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof s17)) {
                        s17Var = (s17) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0209, viewGroup, false);
                        s17Var = new s17(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(s17Var);
                    }
                    if ((this.f.get(i) instanceof nz6) && (nz6Var = (nz6) this.f.get(i)) != null && !ListUtils.isEmpty(nz6Var.f())) {
                        s17Var.f(nz6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof t07)) {
                        t07Var = (t07) view2.getTag();
                    } else {
                        t07Var = new t07(this.a);
                        view2 = t07Var.a();
                        view2.setTag(t07Var);
                    }
                    if (this.f.get(i) instanceof r07) {
                        r07 r07Var = (r07) this.f.get(i);
                        t07Var.a().setData(r07Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (r07Var == null) {
                            str = "";
                        } else {
                            str = r07Var.f();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (r07Var != null) {
                            str2 = r07Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void l(List<w15> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            c07 c07Var = this.d;
            if (c07Var != null) {
                c07Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
