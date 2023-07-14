package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.a37;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.f17;
import com.baidu.tieba.p55;
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
public class m07 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public a37 c;
    public f17 d;
    public EnterForumModel e;
    public List<s25> f;
    public boolean g;
    public s07 h;
    public u27 i;
    public HashSet<Long> j;

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m07 a;

        /* loaded from: classes6.dex */
        public class a implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    dea.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", null);
                    p55Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements p55.e {
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

            @Override // com.baidu.tieba.p55.e
            public void onClick(p55 p55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                    p55Var.dismiss();
                }
            }
        }

        public e(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String V;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.X()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new is5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.Z().b();
                if (b2 != null) {
                    int W = b2.W();
                    if (W != 220012) {
                        if (W == 2121002) {
                            vg5.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0509), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f16a1), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1626), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (xi.isEmpty(b2.V())) {
                            V = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0505);
                        } else {
                            V = b2.V();
                        }
                        blockPopInfoData.block_info = V;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0507);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b3d);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z = true;
                }
                if (!z) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0506);
                    if (b2 != null) {
                        if (xi.isEmpty(b2.V())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0506);
                        } else {
                            string = b2.V();
                        }
                    }
                    vg5.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b3d), null, new c(this), null).show();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements a37.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u27 a;
        public final /* synthetic */ m07 b;

        public a(m07 m07Var, u27 u27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var, u27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = m07Var;
            this.a = u27Var;
        }

        @Override // com.baidu.tieba.a37.j
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
    public class b implements f17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m07 a;

        public b(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m07Var;
        }

        @Override // com.baidu.tieba.f17.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.h0(true, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m07 a;

        public c(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new is5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m07 a;

        public d(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new is5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public f(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(m07 m07Var, a aVar) {
            this(m07Var);
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public NoDataView b;

        public g(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(m07 m07Var, a aVar) {
            this(m07Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public h(m07 m07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(m07 m07Var, a aVar) {
            this(m07Var);
        }
    }

    public m07(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, u27 u27Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, u27Var};
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
        this.i = u27Var;
        a37 a37Var = new a37(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = a37Var;
        a37Var.C(new a(this, u27Var));
        this.e = enterForumModel;
        f17 f17Var = new f17(this.a.getPageActivity(), Integer.valueOf(l07.a(1)).intValue(), 0, this.c);
        this.d = f17Var;
        f17Var.u(new b(this));
    }

    public void g(int i) {
        a37 a37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (a37Var = this.c) != null) {
            a37Var.u(i);
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
            List<s25> list = this.f;
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
        f17 f17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (f17Var = this.d) != null) {
            f17Var.t(i);
        }
    }

    public void k(s07 s07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, s07Var) == null) {
            if (s07Var != this.h) {
                this.h = s07Var;
                notifyDataSetChanged();
            }
            a37 a37Var = this.c;
            if (a37Var != null) {
                a37Var.A(s07Var);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        a37 a37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (a37Var = this.c) != null) {
            a37Var.D(bdUniqueId);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a37 a37Var = this.c;
            if (a37Var == null) {
                return false;
            }
            return a37Var.j();
        }
        return invokeV.booleanValue;
    }

    public List<s25> f() {
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
            return s25.c.length;
        }
        return invokeV.intValue;
    }

    public void h() {
        a37 a37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (a37Var = this.c) != null) {
            a37Var.v();
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
        x27 x27Var;
        s25 s25Var;
        f fVar;
        g gVar;
        NoDataViewFactory.d b2;
        NoDataViewFactory.e a2;
        NoDataViewFactory.c a3;
        b37 b37Var;
        f37 f37Var;
        g37 g37Var;
        e37 e37Var;
        c37 c37Var;
        d37 d37Var;
        w27 w27Var;
        w07 w07Var;
        v27 v27Var;
        q07 q07Var;
        w17 w17Var;
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02b6, viewGroup, false);
                        hVar = new h(this, null);
                        hVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092542);
                        hVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09221c);
                        hVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
                        view2.setTag(hVar);
                    }
                    if (this.f.get(i) instanceof u07) {
                        u07 u07Var = (u07) this.f.get(i);
                        this.d.v(hVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (u07Var != null) {
                            hVar.a.setText(u07Var.d);
                            SkinManager.setViewTextColor(hVar.a, (int) R.color.CAM_X0105);
                            s07 s07Var = this.h;
                            if ((s07Var != null && s07Var.a) || u07Var.f) {
                                SkinManager.setBackgroundResource(hVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(hVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = hVar.b;
                            if (textView != null) {
                                if (u07Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(hVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.c.getLayoutParams();
                            if (u07Var.g != -1) {
                                layoutParams.setMargins(yi.g(viewGroup.getContext(), u07Var.g), 0, yi.g(viewGroup.getContext(), u07Var.g), 0);
                            }
                            if (u07Var.i != -1) {
                                d85.d(hVar.a).C(u07Var.i);
                            }
                            if (u07Var.h != -1) {
                                layoutParams.height = yi.g(viewGroup.getContext(), u07Var.h);
                            }
                            hVar.c.setLayoutParams(layoutParams);
                            if (u07Var.j != -1) {
                                hVar.c.setPadding(yi.g(viewGroup.getContext(), u07Var.j), 0, yi.g(viewGroup.getContext(), u07Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof x27)) {
                        x27Var = (x27) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d03f6, viewGroup, false);
                        x27Var = new x27(this.a, view2, this.b);
                        view2.setTag(x27Var);
                    }
                    if ((this.f.get(i) instanceof s25) && (s25Var = this.f.get(i)) != null) {
                        x27Var.f(s25Var);
                    }
                    x27Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02b5, (ViewGroup) null);
                        fVar = new f(this, null);
                        fVar.a = (TextView) view2.findViewById(R.id.footer_text);
                        fVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0907a2);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02b3, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091f54);
                        gVar.b = NoDataViewFactory.a(this.a.getPageActivity(), gVar.a, null, null, null);
                        view2.setTag(gVar);
                    }
                    d dVar = new d(this);
                    if (!TbadkCoreApplication.isLogin()) {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NOTLOGIN, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0665);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0463), dVar));
                    } else {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f07e6);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0461), dVar));
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
                    if (view2 != null && (view2.getTag() instanceof b37)) {
                        b37Var = (b37) view2.getTag();
                    } else {
                        b37Var = new b37(this.a);
                        view2 = b37Var.b();
                        view2.setTag(b37Var);
                    }
                    b37Var.a();
                    b37Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof f37)) {
                        f37Var = (f37) view2.getTag();
                    } else {
                        f37Var = new f37(this.a);
                        view2 = f37Var.d();
                        view2.setTag(f37Var);
                    }
                    if (this.f.get(i) instanceof l45) {
                        f37Var.c((l45) this.f.get(i));
                    }
                    if (this.e.Z() != null && this.e.Z().e() != null && this.e.Z().e().b() != null) {
                        if (this.e.Z().e().b().size() <= 0) {
                            z = false;
                        }
                        f37Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof g37)) {
                        g37Var = (g37) view2.getTag();
                    } else {
                        g37Var = new g37(this.a);
                        view2 = g37Var.k();
                        view2.setTag(g37Var);
                    }
                    if (this.f.get(i) instanceof j45) {
                        j45 j45Var = (j45) this.f.get(i);
                        g37Var.g(j45Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(j45Var.f()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", j45Var.f());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.Z() != null && this.e.Z().e() != null && this.e.Z().e().b() != null) {
                                if (this.e.Z().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i2 = 3;
                                }
                                statisticItem.param("obj_type", i2);
                                g37Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(j45Var.f()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof e37)) {
                        e37Var = (e37) view2.getTag();
                    } else {
                        e37Var = new e37(this.a);
                        view2 = e37Var.c();
                        view2.setTag(e37Var);
                    }
                    if (this.f.get(i) instanceof k45) {
                        e37Var.b((k45) this.f.get(i));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof c37)) {
                        c37Var = (c37) view2.getTag();
                    } else {
                        c37Var = new c37(this.a);
                        view2 = c37Var.d();
                        view2.setTag(c37Var);
                    }
                    if (this.f.get(i) instanceof o07) {
                        c37Var.c((o07) this.f.get(i));
                    }
                    if (this.e.Z() != null && this.e.Z().e() != null && this.e.Z().e().b() != null) {
                        if (this.e.Z().e().b().size() <= 0) {
                            z2 = false;
                        }
                        c37Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof d37)) {
                        d37Var = (d37) view2.getTag();
                    } else {
                        d37Var = new d37(this.a);
                        view2 = d37Var.b();
                        view2.setTag(d37Var);
                    }
                    d37Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof w27)) {
                        w27Var = (w27) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d05a3, viewGroup, false);
                        w27Var = new w27(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(w27Var);
                    }
                    if ((this.f.get(i) instanceof w07) && (w07Var = (w07) this.f.get(i)) != null) {
                        w27Var.f(w07Var);
                    }
                    w27Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof v27)) {
                        v27Var = (v27) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0203, viewGroup, false);
                        v27Var = new v27(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(v27Var);
                    }
                    if ((this.f.get(i) instanceof q07) && (q07Var = (q07) this.f.get(i)) != null && !ListUtils.isEmpty(q07Var.f())) {
                        v27Var.f(q07Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof w17)) {
                        w17Var = (w17) view2.getTag();
                    } else {
                        w17Var = new w17(this.a);
                        view2 = w17Var.a();
                        view2.setTag(w17Var);
                    }
                    if (this.f.get(i) instanceof u17) {
                        u17 u17Var = (u17) this.f.get(i);
                        w17Var.a().setData(u17Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (u17Var == null) {
                            str = "";
                        } else {
                            str = u17Var.f();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (u17Var != null) {
                            str2 = u17Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void l(List<s25> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            f17 f17Var = this.d;
            if (f17Var != null) {
                f17Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
