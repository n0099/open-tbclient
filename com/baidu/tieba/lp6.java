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
import com.baidu.tieba.bs6;
import com.baidu.tieba.d05;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.eq6;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes5.dex */
public class lp6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public bs6 c;
    public eq6 d;
    public EnterForumModel e;
    public List<jx4> f;
    public boolean g;
    public rp6 h;
    public vr6 i;
    public HashSet<Long> j;

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lp6 a;

        /* loaded from: classes5.dex */
        public class a implements d05.e {
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

            @Override // com.baidu.tieba.d05.e
            public void onClick(d05 d05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                    fn9.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", null);
                    d05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements d05.e {
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

            @Override // com.baidu.tieba.d05.e
            public void onClick(d05 d05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                    d05Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements d05.e {
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

            @Override // com.baidu.tieba.d05.e
            public void onClick(d05 d05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d05Var) == null) {
                    d05Var.dismiss();
                }
            }
        }

        public e(lp6 lp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lp6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String Q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.S()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new ok5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.U().b();
                if (b2 != null) {
                    int R = b2.R();
                    if (R != 220012) {
                        if (R == 2121002) {
                            la5.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f04a1), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1520), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f14b0), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (hi.isEmpty(b2.Q())) {
                            Q = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f049d);
                        } else {
                            Q = b2.Q();
                        }
                        blockPopInfoData.block_info = Q;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f049f);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a62);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z = true;
                }
                if (!z) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f049e);
                    if (b2 != null) {
                        if (hi.isEmpty(b2.Q())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f049e);
                        } else {
                            string = b2.Q();
                        }
                    }
                    la5.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a62), null, new c(this), null).show();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements bs6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vr6 a;
        public final /* synthetic */ lp6 b;

        public a(lp6 lp6Var, vr6 vr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp6Var, vr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lp6Var;
            this.a = vr6Var;
        }

        @Override // com.baidu.tieba.bs6.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.q());
                this.a.z0(this.b.c.r());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements eq6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lp6 a;

        public b(lp6 lp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lp6Var;
        }

        @Override // com.baidu.tieba.eq6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.c0(true, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lp6 a;

        public c(lp6 lp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lp6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new ok5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lp6 a;

        public d(lp6 lp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lp6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new ok5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public f(lp6 lp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(lp6 lp6Var, a aVar) {
            this(lp6Var);
        }
    }

    /* loaded from: classes5.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ImageView b;
        public TextView c;
        public TBSpecificationBtn d;

        public g(lp6 lp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(lp6 lp6Var, a aVar) {
            this(lp6Var);
        }
    }

    /* loaded from: classes5.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public h(lp6 lp6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(lp6 lp6Var, a aVar) {
            this(lp6Var);
        }
    }

    public lp6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, vr6 vr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, vr6Var};
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
        this.i = vr6Var;
        bs6 bs6Var = new bs6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = bs6Var;
        bs6Var.C(new a(this, vr6Var));
        this.e = enterForumModel;
        eq6 eq6Var = new eq6(this.a.getPageActivity(), Integer.valueOf(kp6.a(1)).intValue(), 0, this.c);
        this.d = eq6Var;
        eq6Var.u(new b(this));
    }

    public void g(int i) {
        bs6 bs6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (bs6Var = this.c) != null) {
            bs6Var.u(i);
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
            List<jx4> list = this.f;
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
        eq6 eq6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (eq6Var = this.d) != null) {
            eq6Var.t(i);
        }
    }

    public void k(rp6 rp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rp6Var) == null) {
            if (rp6Var != this.h) {
                this.h = rp6Var;
                notifyDataSetChanged();
            }
            bs6 bs6Var = this.c;
            if (bs6Var != null) {
                bs6Var.A(rp6Var);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        bs6 bs6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (bs6Var = this.c) != null) {
            bs6Var.D(bdUniqueId);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bs6 bs6Var = this.c;
            if (bs6Var == null) {
                return false;
            }
            return bs6Var.j();
        }
        return invokeV.booleanValue;
    }

    public List<jx4> f() {
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
            return jx4.c.length;
        }
        return invokeV.intValue;
    }

    public void h() {
        bs6 bs6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (bs6Var = this.c) != null) {
            bs6Var.v();
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
        yr6 yr6Var;
        jx4 jx4Var;
        f fVar;
        g gVar;
        cs6 cs6Var;
        gs6 gs6Var;
        hs6 hs6Var;
        fs6 fs6Var;
        ds6 ds6Var;
        es6 es6Var;
        xr6 xr6Var;
        vp6 vp6Var;
        wr6 wr6Var;
        pp6 pp6Var;
        xq6 xq6Var;
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d028d, viewGroup, false);
                        hVar = new h(this, null);
                        hVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923f2);
                        hVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920d6);
                        hVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090772);
                        view2.setTag(hVar);
                    }
                    if (this.f.get(i) instanceof tp6) {
                        tp6 tp6Var = (tp6) this.f.get(i);
                        this.d.v(hVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (tp6Var != null) {
                            hVar.a.setText(tp6Var.d);
                            SkinManager.setViewTextColor(hVar.a, (int) R.color.CAM_X0105);
                            rp6 rp6Var = this.h;
                            if ((rp6Var != null && rp6Var.a) || tp6Var.f) {
                                SkinManager.setBackgroundResource(hVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(hVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = hVar.b;
                            if (textView != null) {
                                if (tp6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(hVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.c.getLayoutParams();
                            if (tp6Var.g != -1) {
                                layoutParams.setMargins(ii.g(viewGroup.getContext(), tp6Var.g), 0, ii.g(viewGroup.getContext(), tp6Var.g), 0);
                            }
                            if (tp6Var.i != -1) {
                                r25.d(hVar.a).B(tp6Var.i);
                            }
                            if (tp6Var.h != -1) {
                                layoutParams.height = ii.g(viewGroup.getContext(), tp6Var.h);
                            }
                            hVar.c.setLayoutParams(layoutParams);
                            if (tp6Var.j != -1) {
                                hVar.c.setPadding(ii.g(viewGroup.getContext(), tp6Var.j), 0, ii.g(viewGroup.getContext(), tp6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof yr6)) {
                        yr6Var = (yr6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d03c2, viewGroup, false);
                        yr6Var = new yr6(this.a, view2, this.b);
                        view2.setTag(yr6Var);
                    }
                    if ((this.f.get(i) instanceof jx4) && (jx4Var = this.f.get(i)) != null) {
                        yr6Var.f(jx4Var);
                    }
                    yr6Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d028c, (ViewGroup) null);
                        fVar = new f(this, null);
                        fVar.a = (TextView) view2.findViewById(R.id.footer_text);
                        fVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090772);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d028a, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091e1d);
                        gVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fed);
                        gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090eca);
                        gVar.d = (TBSpecificationBtn) view2.findViewById(R.id.footer_text);
                        n55 n55Var = new n55();
                        gVar.d.setTextSize(R.dimen.tbds42);
                        gVar.d.setConfig(n55Var);
                        view2.setTag(gVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        gVar.c.setText(R.string.obfuscated_res_0x7f0f05b1);
                        gVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0416));
                        gVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(gVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        gVar.c.setText(R.string.obfuscated_res_0x7f0f0728);
                        gVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0414));
                        SkinManager.setImageResource(gVar.b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(gVar.c, (int) R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(gVar.a, R.color.CAM_X0205);
                    gVar.d.k();
                    TBSpecificationBtn tBSpecificationBtn = gVar.d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view2;
                    }
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
                    if (view2 != null && (view2.getTag() instanceof cs6)) {
                        cs6Var = (cs6) view2.getTag();
                    } else {
                        cs6Var = new cs6(this.a);
                        view2 = cs6Var.b();
                        view2.setTag(cs6Var);
                    }
                    cs6Var.a();
                    cs6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof gs6)) {
                        gs6Var = (gs6) view2.getTag();
                    } else {
                        gs6Var = new gs6(this.a);
                        view2 = gs6Var.d();
                        view2.setTag(gs6Var);
                    }
                    if (this.f.get(i) instanceof bz4) {
                        gs6Var.c((bz4) this.f.get(i));
                    }
                    if (this.e.U() != null && this.e.U().e() != null && this.e.U().e().b() != null) {
                        if (this.e.U().e().b().size() <= 0) {
                            z = false;
                        }
                        gs6Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof hs6)) {
                        hs6Var = (hs6) view2.getTag();
                    } else {
                        hs6Var = new hs6(this.a);
                        view2 = hs6Var.k();
                        view2.setTag(hs6Var);
                    }
                    if (this.f.get(i) instanceof zy4) {
                        zy4 zy4Var = (zy4) this.f.get(i);
                        hs6Var.g(zy4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(zy4Var.f()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", zy4Var.f());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.U() != null && this.e.U().e() != null && this.e.U().e().b() != null) {
                                if (this.e.U().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i2 = 3;
                                }
                                statisticItem.param("obj_type", i2);
                                hs6Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(zy4Var.f()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof fs6)) {
                        fs6Var = (fs6) view2.getTag();
                    } else {
                        fs6Var = new fs6(this.a);
                        view2 = fs6Var.c();
                        view2.setTag(fs6Var);
                    }
                    if (this.f.get(i) instanceof az4) {
                        fs6Var.b((az4) this.f.get(i));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof ds6)) {
                        ds6Var = (ds6) view2.getTag();
                    } else {
                        ds6Var = new ds6(this.a);
                        view2 = ds6Var.d();
                        view2.setTag(ds6Var);
                    }
                    if (this.f.get(i) instanceof np6) {
                        ds6Var.c((np6) this.f.get(i));
                    }
                    if (this.e.U() != null && this.e.U().e() != null && this.e.U().e().b() != null) {
                        if (this.e.U().e().b().size() <= 0) {
                            z2 = false;
                        }
                        ds6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof es6)) {
                        es6Var = (es6) view2.getTag();
                    } else {
                        es6Var = new es6(this.a);
                        view2 = es6Var.b();
                        view2.setTag(es6Var);
                    }
                    es6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof xr6)) {
                        xr6Var = (xr6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0564, viewGroup, false);
                        xr6Var = new xr6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(xr6Var);
                    }
                    if ((this.f.get(i) instanceof vp6) && (vp6Var = (vp6) this.f.get(i)) != null) {
                        xr6Var.f(vp6Var);
                    }
                    xr6Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof wr6)) {
                        wr6Var = (wr6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01f0, viewGroup, false);
                        wr6Var = new wr6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(wr6Var);
                    }
                    if ((this.f.get(i) instanceof pp6) && (pp6Var = (pp6) this.f.get(i)) != null && !ListUtils.isEmpty(pp6Var.f())) {
                        wr6Var.f(pp6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof xq6)) {
                        xq6Var = (xq6) view2.getTag();
                    } else {
                        xq6Var = new xq6(this.a);
                        view2 = xq6Var.a();
                        view2.setTag(xq6Var);
                    }
                    if (this.f.get(i) instanceof tq6) {
                        tq6 tq6Var = (tq6) this.f.get(i);
                        xq6Var.a().setData(tq6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (tq6Var == null) {
                            str = "";
                        } else {
                            str = tq6Var.f();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (tq6Var != null) {
                            str2 = tq6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void l(List<jx4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            eq6 eq6Var = this.d;
            if (eq6Var != null) {
                eq6Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
