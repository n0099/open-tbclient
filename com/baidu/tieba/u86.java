package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.kb6;
import com.baidu.tieba.n96;
import com.baidu.tieba.no8;
import com.baidu.tieba.nu4;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class u86 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public kb6 c;
    public n96 d;
    public EnterForumModel e;
    public List<wr4> f;
    public boolean g;
    public a96 h;
    public eb6 i;
    public HashSet<Long> j;
    public no8.c k;

    /* loaded from: classes6.dex */
    public class a implements kb6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb6 a;
        public final /* synthetic */ u86 b;

        public a(u86 u86Var, eb6 eb6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var, eb6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = u86Var;
            this.a = eb6Var;
        }

        @Override // com.baidu.tieba.kb6.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.s());
                this.a.z0(this.b.c.t());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements n96.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u86 a;

        public b(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u86Var;
        }

        @Override // com.baidu.tieba.n96.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.L(true, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u86 a;

        public c(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new wb5(6, null, null, null));
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u86 a;

        public d(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null) {
                return;
            }
            this.a.b.dispatchMvcEvent(new wb5(6, null, null, null));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u86 a;

        /* loaded from: classes6.dex */
        public class a implements nu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    no8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    nu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements nu4.e {
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

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    nu4Var.dismiss();
                }
            }
        }

        public e(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u86Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.B()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new wb5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.D().b();
                if (b2 != null) {
                    int A = b2.A();
                    if (A == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = dj.isEmpty(b2.z()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0476) : b2.z();
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0478);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09b7);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    } else if (A == 2121002) {
                        f35.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f047a), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1449), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f13df), new a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0477);
                if (b2 != null) {
                    string = dj.isEmpty(b2.z()) ? this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0477) : b2.z();
                }
                f35.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09b7), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends no8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.no8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.no8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.no8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.no8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public g(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(u86 u86Var, a aVar) {
            this(u86Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ImageView b;
        public TextView c;
        public TBSpecificationBtn d;

        public h(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(u86 u86Var, a aVar) {
            this(u86Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(u86 u86Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u86Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(u86 u86Var, a aVar) {
            this(u86Var);
        }
    }

    public u86(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, eb6 eb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, eb6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new ArrayList();
        this.g = true;
        this.k = new f(this);
        this.a = tbPageContext;
        this.b = viewEventCenter;
        this.j = new HashSet<>();
        this.i = eb6Var;
        kb6 kb6Var = new kb6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = kb6Var;
        kb6Var.E(new a(this, eb6Var));
        this.e = enterForumModel;
        n96 n96Var = new n96(this.a.getPageActivity(), Integer.valueOf(t86.a(1)).intValue(), 0, this.c);
        this.d = n96Var;
        n96Var.u(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            kb6 kb6Var = this.c;
            if (kb6Var == null) {
                return false;
            }
            return kb6Var.k();
        }
        return invokeV.booleanValue;
    }

    public List<wr4> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.f.size();
            if (size <= 0 || i2 >= size) {
                return null;
            }
            return this.f.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<wr4> list = this.f;
            if (list == null || (i2 < list.size() && i2 >= 0)) {
                return i2;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 >= this.f.size() || i2 < 0) {
                return 6;
            }
            return this.f.get(i2).c();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        hb6 hb6Var;
        wr4 wr4Var;
        g gVar;
        h hVar;
        lb6 lb6Var;
        pb6 pb6Var;
        qb6 qb6Var;
        ob6 ob6Var;
        mb6 mb6Var;
        nb6 nb6Var;
        gb6 gb6Var;
        e96 e96Var;
        fb6 fb6Var;
        y86 y86Var;
        ga6 ga6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view2, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view2 != null && (view2.getTag() instanceof i)) {
                        iVar = (i) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0273, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092219);
                        iVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f19);
                        iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906d3);
                        view2.setTag(iVar);
                    }
                    if (this.f.get(i2) instanceof c96) {
                        c96 c96Var = (c96) this.f.get(i2);
                        this.d.v(iVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (c96Var != null) {
                            iVar.a.setText(c96Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            a96 a96Var = this.h;
                            if ((a96Var != null && a96Var.a) || c96Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (c96Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (c96Var.g != -1) {
                                layoutParams.setMargins(ej.f(viewGroup.getContext(), c96Var.g), 0, ej.f(viewGroup.getContext(), c96Var.g), 0);
                            }
                            if (c96Var.i != -1) {
                                hv4.d(iVar.a).z(c96Var.i);
                            }
                            if (c96Var.h != -1) {
                                layoutParams.height = ej.f(viewGroup.getContext(), c96Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (c96Var.j != -1) {
                                iVar.c.setPadding(ej.f(viewGroup.getContext(), c96Var.j), 0, ej.f(viewGroup.getContext(), c96Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof hb6)) {
                        hb6Var = (hb6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0391, viewGroup, false);
                        hb6Var = new hb6(this.a, view2, this.b);
                        view2.setTag(hb6Var);
                    }
                    if ((this.f.get(i2) instanceof wr4) && (wr4Var = this.f.get(i2)) != null) {
                        hb6Var.f(wr4Var);
                    }
                    hb6Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0272, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a3d);
                        gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0906d3);
                        view2.setTag(gVar);
                    }
                    View view3 = gVar.b;
                    if (view3 != null) {
                        view3.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(gVar.a, (int) R.color.CAM_X0304);
                    return view2;
                case 3:
                    if (view2 != null && (view2.getTag() instanceof h)) {
                        hVar = (h) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0270, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091c6d);
                        hVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e94);
                        hVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d67);
                        hVar.d = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090a3d);
                        my4 my4Var = new my4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(my4Var);
                        view2.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f0586);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03ec));
                        hVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f06dd);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03ea));
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(hVar.c, (int) R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(hVar.a, R.color.CAM_X0205);
                    hVar.d.k();
                    TBSpecificationBtn tBSpecificationBtn = hVar.d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view2;
                    }
                    return view2;
                case 4:
                    if (view2 == null) {
                        View o = this.c.o();
                        this.c.z();
                        return o;
                    }
                    return view2;
                case 5:
                    o();
                    if (view2 != null && (view2.getTag() instanceof lb6)) {
                        lb6Var = (lb6) view2.getTag();
                    } else {
                        lb6Var = new lb6(this.a);
                        view2 = lb6Var.b();
                        view2.setTag(lb6Var);
                    }
                    lb6Var.a();
                    lb6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof pb6)) {
                        pb6Var = (pb6) view2.getTag();
                    } else {
                        pb6Var = new pb6(this.a);
                        view2 = pb6Var.d();
                        view2.setTag(pb6Var);
                    }
                    if (this.f.get(i2) instanceof pt4) {
                        pb6Var.c((pt4) this.f.get(i2));
                    }
                    if (this.e.D() == null || this.e.D().e() == null || this.e.D().e().b() == null) {
                        return view2;
                    }
                    pb6Var.e(this.e.D().e().b().size() > 0);
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof qb6)) {
                        qb6Var = (qb6) view2.getTag();
                    } else {
                        qb6Var = new qb6(this.a);
                        view2 = qb6Var.k();
                        view2.setTag(qb6Var);
                    }
                    if (this.f.get(i2) instanceof nt4) {
                        nt4 nt4Var = (nt4) this.f.get(i2);
                        qb6Var.g(nt4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(nt4Var.j()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", nt4Var.j());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                                boolean z = this.e.D().e().b().size() > 0;
                                statisticItem.param("obj_type", z ? 3 : 1);
                                qb6Var.m(z);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(nt4Var.j()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof ob6)) {
                        ob6Var = (ob6) view2.getTag();
                    } else {
                        ob6Var = new ob6(this.a);
                        view2 = ob6Var.c();
                        view2.setTag(ob6Var);
                    }
                    if (this.f.get(i2) instanceof ot4) {
                        ob6Var.b((ot4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof mb6)) {
                        mb6Var = (mb6) view2.getTag();
                    } else {
                        mb6Var = new mb6(this.a);
                        view2 = mb6Var.d();
                        view2.setTag(mb6Var);
                    }
                    if (this.f.get(i2) instanceof w86) {
                        mb6Var.c((w86) this.f.get(i2));
                    }
                    if (this.e.D() == null || this.e.D().e() == null || this.e.D().e().b() == null) {
                        return view2;
                    }
                    mb6Var.e(this.e.D().e().b().size() > 0);
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof nb6)) {
                        nb6Var = (nb6) view2.getTag();
                    } else {
                        nb6Var = new nb6(this.a);
                        view2 = nb6Var.b();
                        view2.setTag(nb6Var);
                    }
                    nb6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof gb6)) {
                        gb6Var = (gb6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0522, viewGroup, false);
                        gb6Var = new gb6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(gb6Var);
                    }
                    if ((this.f.get(i2) instanceof e96) && (e96Var = (e96) this.f.get(i2)) != null) {
                        gb6Var.f(e96Var);
                    }
                    gb6Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof fb6)) {
                        fb6Var = (fb6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01de, viewGroup, false);
                        fb6Var = new fb6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(fb6Var);
                    }
                    if (!(this.f.get(i2) instanceof y86) || (y86Var = (y86) this.f.get(i2)) == null || ListUtils.isEmpty(y86Var.j())) {
                        return view2;
                    }
                    fb6Var.f(y86Var);
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof ga6)) {
                        ga6Var = (ga6) view2.getTag();
                    } else {
                        ga6Var = new ga6(this.a);
                        view2 = ga6Var.a();
                        view2.setTag(ga6Var);
                    }
                    if (this.f.get(i2) instanceof ca6) {
                        ca6 ca6Var = (ca6) this.f.get(i2);
                        ga6Var.a().setData(ca6Var);
                        TiebaStatic.log(new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", ca6Var != null ? ca6Var.j() : "").param("obj_source", ca6Var != null ? ca6Var.getFrom() : ""));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? wr4.c.length : invokeV.intValue;
    }

    public void h(int i2) {
        kb6 kb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (kb6Var = this.c) == null) {
            return;
        }
        kb6Var.w(i2);
    }

    public void i() {
        kb6 kb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (kb6Var = this.c) == null) {
            return;
        }
        kb6Var.x();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = true;
            this.j.clear();
        }
    }

    public void k(int i2) {
        n96 n96Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (n96Var = this.d) == null) {
            return;
        }
        n96Var.t(i2);
    }

    public void l(a96 a96Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, a96Var) == null) {
            if (a96Var != this.h) {
                this.h = a96Var;
                notifyDataSetChanged();
            }
            kb6 kb6Var = this.c;
            if (kb6Var != null) {
                kb6Var.C(a96Var);
            }
        }
    }

    public void m(List<wr4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            n96 n96Var = this.d;
            if (n96Var != null) {
                n96Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        kb6 kb6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) || (kb6Var = this.c) == null) {
            return;
        }
        kb6Var.F(bdUniqueId);
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g) {
            TiebaStatic.log("c13378");
            this.g = false;
        }
    }
}
