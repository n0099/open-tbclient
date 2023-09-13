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
import com.baidu.tieba.b37;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.g17;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class n07 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public b37 c;
    public g17 d;
    public EnterForumModel e;
    public List<b25> f;
    public boolean g;
    public t07 h;
    public v27 i;
    public HashSet<Long> j;

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n07 a;

        /* loaded from: classes7.dex */
        public class a implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    aja.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", null);
                    y45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements y45.e {
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

            @Override // com.baidu.tieba.y45.e
            public void onClick(y45 y45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, y45Var) == null) {
                    y45Var.dismiss();
                }
            }
        }

        public e(n07 n07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String M;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.O()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new tr5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.Q().b();
                if (b2 != null) {
                    int N = b2.N();
                    if (N != 220012) {
                        if (N == 2121002) {
                            DialogUtil.createAlertDialog(this.a.a, (String) null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f050d), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f16d1), this.a.a.getResources().getString(R.string.think_more), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (ei.isEmpty(b2.M())) {
                            M = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0509);
                        } else {
                            M = b2.M();
                        }
                        blockPopInfoData.block_info = M;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f050b);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b59);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z = true;
                }
                if (!z) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f050a);
                    if (b2 != null) {
                        if (ei.isEmpty(b2.M())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f050a);
                        } else {
                            string = b2.M();
                        }
                    }
                    DialogUtil.createAlertDialog(this.a.a, (String) null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b59), (String) null, new c(this), (y45.e) null).show();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements b37.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v27 a;
        public final /* synthetic */ n07 b;

        public a(n07 n07Var, v27 v27Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n07Var, v27Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n07Var;
            this.a = v27Var;
        }

        @Override // com.baidu.tieba.b37.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.q());
                this.a.z0(this.b.c.r());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g17.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n07 a;

        public b(n07 n07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n07Var;
        }

        @Override // com.baidu.tieba.g17.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.Y(true, i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n07 a;

        public c(n07 n07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new tr5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n07 a;

        public d(n07 n07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new tr5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public f(n07 n07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(n07 n07Var, a aVar) {
            this(n07Var);
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public NoDataView b;

        public g(n07 n07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(n07 n07Var, a aVar) {
            this(n07Var);
        }
    }

    /* loaded from: classes7.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public h(n07 n07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(n07 n07Var, a aVar) {
            this(n07Var);
        }
    }

    public n07(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, v27 v27Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, v27Var};
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
        this.i = v27Var;
        b37 b37Var = new b37(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = b37Var;
        b37Var.C(new a(this, v27Var));
        this.e = enterForumModel;
        g17 g17Var = new g17(this.a.getPageActivity(), Integer.valueOf(m07.a(1)).intValue(), 0, this.c);
        this.d = g17Var;
        g17Var.u(new b(this));
    }

    public void g(int i) {
        b37 b37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (b37Var = this.c) != null) {
            b37Var.u(i);
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
            List<b25> list = this.f;
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
        g17 g17Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (g17Var = this.d) != null) {
            g17Var.t(i);
        }
    }

    public void k(t07 t07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, t07Var) == null) {
            if (t07Var != this.h) {
                this.h = t07Var;
                notifyDataSetChanged();
            }
            b37 b37Var = this.c;
            if (b37Var != null) {
                b37Var.A(t07Var);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        b37 b37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (b37Var = this.c) != null) {
            b37Var.D(bdUniqueId);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            b37 b37Var = this.c;
            if (b37Var == null) {
                return false;
            }
            return b37Var.j();
        }
        return invokeV.booleanValue;
    }

    public List<b25> f() {
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
            return b25.c.length;
        }
        return invokeV.intValue;
    }

    public void h() {
        b37 b37Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (b37Var = this.c) != null) {
            b37Var.v();
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
        y27 y27Var;
        b25 b25Var;
        f fVar;
        g gVar;
        NoDataViewFactory.d b2;
        NoDataViewFactory.e a2;
        NoDataViewFactory.c a3;
        c37 c37Var;
        g37 g37Var;
        h37 h37Var;
        f37 f37Var;
        d37 d37Var;
        e37 e37Var;
        x27 x27Var;
        x07 x07Var;
        w27 w27Var;
        r07 r07Var;
        x17 x17Var;
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02bf, viewGroup, false);
                        hVar = new h(this, null);
                        hVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0925d1);
                        hVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922a1);
                        hVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907aa);
                        view2.setTag(hVar);
                    }
                    if (this.f.get(i) instanceof v07) {
                        v07 v07Var = (v07) this.f.get(i);
                        this.d.v(hVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (v07Var != null) {
                            hVar.a.setText(v07Var.d);
                            SkinManager.setViewTextColor(hVar.a, (int) R.color.CAM_X0105);
                            t07 t07Var = this.h;
                            if ((t07Var != null && t07Var.a) || v07Var.f) {
                                SkinManager.setBackgroundResource(hVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(hVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = hVar.b;
                            if (textView != null) {
                                if (v07Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(hVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.c.getLayoutParams();
                            if (v07Var.g != -1) {
                                layoutParams.setMargins(BdUtilHelper.getDimens(viewGroup.getContext(), v07Var.g), 0, BdUtilHelper.getDimens(viewGroup.getContext(), v07Var.g), 0);
                            }
                            if (v07Var.i != -1) {
                                EMManager.from(hVar.a).setTextSize(v07Var.i);
                            }
                            if (v07Var.h != -1) {
                                layoutParams.height = BdUtilHelper.getDimens(viewGroup.getContext(), v07Var.h);
                            }
                            hVar.c.setLayoutParams(layoutParams);
                            if (v07Var.j != -1) {
                                hVar.c.setPadding(BdUtilHelper.getDimens(viewGroup.getContext(), v07Var.j), 0, BdUtilHelper.getDimens(viewGroup.getContext(), v07Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof y27)) {
                        y27Var = (y27) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0405, viewGroup, false);
                        y27Var = new y27(this.a, view2, this.b);
                        view2.setTag(y27Var);
                    }
                    if ((this.f.get(i) instanceof b25) && (b25Var = this.f.get(i)) != null) {
                        y27Var.f(b25Var);
                    }
                    y27Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02be, (ViewGroup) null);
                        fVar = new f(this, null);
                        fVar.a = (TextView) view2.findViewById(R.id.footer_text);
                        fVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0907aa);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02bc, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091fd6);
                        gVar.b = NoDataViewFactory.a(this.a.getPageActivity(), gVar.a, null, null, null);
                        view2.setTag(gVar);
                    }
                    d dVar = new d(this);
                    if (!TbadkCoreApplication.isLogin()) {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NOTLOGIN, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0670);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0466), dVar));
                    } else {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f07f2);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0464), dVar));
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
                    if (view2 != null && (view2.getTag() instanceof c37)) {
                        c37Var = (c37) view2.getTag();
                    } else {
                        c37Var = new c37(this.a);
                        view2 = c37Var.b();
                        view2.setTag(c37Var);
                    }
                    c37Var.a();
                    c37Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof g37)) {
                        g37Var = (g37) view2.getTag();
                    } else {
                        g37Var = new g37(this.a);
                        view2 = g37Var.d();
                        view2.setTag(g37Var);
                    }
                    if (this.f.get(i) instanceof t35) {
                        g37Var.c((t35) this.f.get(i));
                    }
                    if (this.e.Q() != null && this.e.Q().e() != null && this.e.Q().e().b() != null) {
                        if (this.e.Q().e().b().size() <= 0) {
                            z = false;
                        }
                        g37Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof h37)) {
                        h37Var = (h37) view2.getTag();
                    } else {
                        h37Var = new h37(this.a);
                        view2 = h37Var.k();
                        view2.setTag(h37Var);
                    }
                    if (this.f.get(i) instanceof r35) {
                        r35 r35Var = (r35) this.f.get(i);
                        h37Var.g(r35Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(r35Var.f()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", r35Var.f());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.Q() != null && this.e.Q().e() != null && this.e.Q().e().b() != null) {
                                if (this.e.Q().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i2 = 3;
                                }
                                statisticItem.param("obj_type", i2);
                                h37Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(r35Var.f()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof f37)) {
                        f37Var = (f37) view2.getTag();
                    } else {
                        f37Var = new f37(this.a);
                        view2 = f37Var.c();
                        view2.setTag(f37Var);
                    }
                    if (this.f.get(i) instanceof s35) {
                        f37Var.b((s35) this.f.get(i));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof d37)) {
                        d37Var = (d37) view2.getTag();
                    } else {
                        d37Var = new d37(this.a);
                        view2 = d37Var.d();
                        view2.setTag(d37Var);
                    }
                    if (this.f.get(i) instanceof p07) {
                        d37Var.c((p07) this.f.get(i));
                    }
                    if (this.e.Q() != null && this.e.Q().e() != null && this.e.Q().e().b() != null) {
                        if (this.e.Q().e().b().size() <= 0) {
                            z2 = false;
                        }
                        d37Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof e37)) {
                        e37Var = (e37) view2.getTag();
                    } else {
                        e37Var = new e37(this.a);
                        view2 = e37Var.b();
                        view2.setTag(e37Var);
                    }
                    e37Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof x27)) {
                        x27Var = (x27) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d05bf, viewGroup, false);
                        x27Var = new x27(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(x27Var);
                    }
                    if ((this.f.get(i) instanceof x07) && (x07Var = (x07) this.f.get(i)) != null) {
                        x27Var.f(x07Var);
                    }
                    x27Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof w27)) {
                        w27Var = (w27) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d020c, viewGroup, false);
                        w27Var = new w27(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(w27Var);
                    }
                    if ((this.f.get(i) instanceof r07) && (r07Var = (r07) this.f.get(i)) != null && !ListUtils.isEmpty(r07Var.f())) {
                        w27Var.f(r07Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof x17)) {
                        x17Var = (x17) view2.getTag();
                    } else {
                        x17Var = new x17(this.a);
                        view2 = x17Var.a();
                        view2.setTag(x17Var);
                    }
                    if (this.f.get(i) instanceof v17) {
                        v17 v17Var = (v17) this.f.get(i);
                        x17Var.a().setData(v17Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (v17Var == null) {
                            str = "";
                        } else {
                            str = v17Var.f();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (v17Var != null) {
                            str2 = v17Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void l(List<b25> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            g17 g17Var = this.d;
            if (g17Var != null) {
                g17Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
