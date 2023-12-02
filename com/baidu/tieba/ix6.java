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
import com.baidu.tieba.by6;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.f05;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.wz6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class ix6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public wz6 c;
    public by6 d;
    public EnterForumModel e;
    public List<gx4> f;
    public boolean g;
    public ox6 h;
    public qz6 i;
    public HashSet<Long> j;

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix6 a;

        /* loaded from: classes6.dex */
        public class a implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    uxa.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", null);
                    f05Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements f05.e {
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

            @Override // com.baidu.tieba.f05.e
            public void onClick(f05 f05Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                    f05Var.dismiss();
                }
            }
        }

        public e(ix6 ix6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String O;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.Q()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new eo5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.a.e.S().b();
                if (b2 != null) {
                    int P = b2.P();
                    if (P != 220012) {
                        if (P == 2121002) {
                            DialogUtil.createAlertDialog(this.a.a, (String) null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f051d), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f170a), this.a.a.getResources().getString(R.string.think_more), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (rd.isEmpty(b2.O())) {
                            O = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0519);
                        } else {
                            O = b2.O();
                        }
                        blockPopInfoData.block_info = O;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f051b);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b86);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z = true;
                }
                if (!z) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f051a);
                    if (b2 != null) {
                        if (rd.isEmpty(b2.O())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f051a);
                        } else {
                            string = b2.O();
                        }
                    }
                    DialogUtil.createAlertDialog(this.a.a, (String) null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0b86), (String) null, new c(this), (f05.e) null).show();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements wz6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qz6 a;
        public final /* synthetic */ ix6 b;

        public a(ix6 ix6Var, qz6 qz6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var, qz6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ix6Var;
            this.a = qz6Var;
        }

        @Override // com.baidu.tieba.wz6.j
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
    public class b implements by6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix6 a;

        public b(ix6 ix6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix6Var;
        }

        @Override // com.baidu.tieba.by6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.a0(true, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix6 a;

        public c(ix6 ix6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new eo5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ix6 a;

        public d(ix6 ix6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ix6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new eo5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public f(ix6 ix6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(ix6 ix6Var, a aVar) {
            this(ix6Var);
        }
    }

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public NoDataView b;

        public g(ix6 ix6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(ix6 ix6Var, a aVar) {
            this(ix6Var);
        }
    }

    /* loaded from: classes6.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public h(ix6 ix6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ix6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(ix6 ix6Var, a aVar) {
            this(ix6Var);
        }
    }

    public ix6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, qz6 qz6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, qz6Var};
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
        this.i = qz6Var;
        wz6 wz6Var = new wz6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = wz6Var;
        wz6Var.C(new a(this, qz6Var));
        this.e = enterForumModel;
        by6 by6Var = new by6(this.a.getPageActivity(), Integer.valueOf(hx6.a(1)).intValue(), 0, this.c);
        this.d = by6Var;
        by6Var.u(new b(this));
    }

    public void g(int i) {
        wz6 wz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (wz6Var = this.c) != null) {
            wz6Var.u(i);
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
            List<gx4> list = this.f;
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
        by6 by6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (by6Var = this.d) != null) {
            by6Var.t(i);
        }
    }

    public void k(ox6 ox6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ox6Var) == null) {
            if (ox6Var != this.h) {
                this.h = ox6Var;
                notifyDataSetChanged();
            }
            wz6 wz6Var = this.c;
            if (wz6Var != null) {
                wz6Var.A(ox6Var);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        wz6 wz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (wz6Var = this.c) != null) {
            wz6Var.D(bdUniqueId);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            wz6 wz6Var = this.c;
            if (wz6Var == null) {
                return false;
            }
            return wz6Var.j();
        }
        return invokeV.booleanValue;
    }

    public List<gx4> f() {
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
            return gx4.c.length;
        }
        return invokeV.intValue;
    }

    public void h() {
        wz6 wz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (wz6Var = this.c) != null) {
            wz6Var.v();
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
        tz6 tz6Var;
        gx4 gx4Var;
        f fVar;
        g gVar;
        NoDataViewFactory.d b2;
        NoDataViewFactory.e a2;
        NoDataViewFactory.c a3;
        xz6 xz6Var;
        b07 b07Var;
        c07 c07Var;
        a07 a07Var;
        yz6 yz6Var;
        zz6 zz6Var;
        sz6 sz6Var;
        sx6 sx6Var;
        rz6 rz6Var;
        mx6 mx6Var;
        sy6 sy6Var;
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02cc, viewGroup, false);
                        hVar = new h(this, null);
                        hVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092685);
                        hVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092340);
                        hVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0907f7);
                        view2.setTag(hVar);
                    }
                    if (this.f.get(i) instanceof qx6) {
                        qx6 qx6Var = (qx6) this.f.get(i);
                        this.d.v(hVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (qx6Var != null) {
                            hVar.a.setText(qx6Var.d);
                            SkinManager.setViewTextColor(hVar.a, (int) R.color.CAM_X0105);
                            ox6 ox6Var = this.h;
                            if ((ox6Var != null && ox6Var.a) || qx6Var.f) {
                                SkinManager.setBackgroundResource(hVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(hVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = hVar.b;
                            if (textView != null) {
                                if (qx6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(hVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.c.getLayoutParams();
                            if (qx6Var.g != -1) {
                                layoutParams.setMargins(BdUtilHelper.getDimens(viewGroup.getContext(), qx6Var.g), 0, BdUtilHelper.getDimens(viewGroup.getContext(), qx6Var.g), 0);
                            }
                            if (qx6Var.i != -1) {
                                EMManager.from(hVar.a).setTextSize(qx6Var.i);
                            }
                            if (qx6Var.h != -1) {
                                layoutParams.height = BdUtilHelper.getDimens(viewGroup.getContext(), qx6Var.h);
                            }
                            hVar.c.setLayoutParams(layoutParams);
                            if (qx6Var.j != -1) {
                                hVar.c.setPadding(BdUtilHelper.getDimens(viewGroup.getContext(), qx6Var.j), 0, BdUtilHelper.getDimens(viewGroup.getContext(), qx6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof tz6)) {
                        tz6Var = (tz6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d041d, viewGroup, false);
                        tz6Var = new tz6(this.a, view2, this.b);
                        view2.setTag(tz6Var);
                    }
                    if ((this.f.get(i) instanceof gx4) && (gx4Var = this.f.get(i)) != null) {
                        tz6Var.h(gx4Var);
                    }
                    tz6Var.j(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02cb, (ViewGroup) null);
                        fVar = new f(this, null);
                        fVar.a = (TextView) view2.findViewById(R.id.footer_text);
                        fVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0907f7);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d02c9, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = view2.findViewById(R.id.obfuscated_res_0x7f09206b);
                        gVar.b = NoDataViewFactory.a(this.a.getPageActivity(), gVar.a, null, null, null);
                        view2.setTag(gVar);
                    }
                    d dVar = new d(this);
                    if (!TbadkCoreApplication.isLogin()) {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NOTLOGIN, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0680);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0472), dVar));
                    } else {
                        b2 = NoDataViewFactory.d.b(NoDataViewFactory.ImgType.FINDBAR, 0);
                        a2 = NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0803);
                        a3 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0470), dVar));
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
                    if (view2 != null && (view2.getTag() instanceof xz6)) {
                        xz6Var = (xz6) view2.getTag();
                    } else {
                        xz6Var = new xz6(this.a);
                        view2 = xz6Var.b();
                        view2.setTag(xz6Var);
                    }
                    xz6Var.a();
                    xz6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof b07)) {
                        b07Var = (b07) view2.getTag();
                    } else {
                        b07Var = new b07(this.a);
                        view2 = b07Var.d();
                        view2.setTag(b07Var);
                    }
                    if (this.f.get(i) instanceof yy4) {
                        b07Var.c((yy4) this.f.get(i));
                    }
                    if (this.e.S() != null && this.e.S().e() != null && this.e.S().e().b() != null) {
                        if (this.e.S().e().b().size() <= 0) {
                            z = false;
                        }
                        b07Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof c07)) {
                        c07Var = (c07) view2.getTag();
                    } else {
                        c07Var = new c07(this.a);
                        view2 = c07Var.k();
                        view2.setTag(c07Var);
                    }
                    if (this.f.get(i) instanceof wy4) {
                        wy4 wy4Var = (wy4) this.f.get(i);
                        c07Var.g(wy4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(wy4Var.f()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", wy4Var.f());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.S() != null && this.e.S().e() != null && this.e.S().e().b() != null) {
                                if (this.e.S().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i2 = 3;
                                }
                                statisticItem.param("obj_type", i2);
                                c07Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(wy4Var.f()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof a07)) {
                        a07Var = (a07) view2.getTag();
                    } else {
                        a07Var = new a07(this.a);
                        view2 = a07Var.c();
                        view2.setTag(a07Var);
                    }
                    if (this.f.get(i) instanceof xy4) {
                        a07Var.b((xy4) this.f.get(i));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof yz6)) {
                        yz6Var = (yz6) view2.getTag();
                    } else {
                        yz6Var = new yz6(this.a);
                        view2 = yz6Var.d();
                        view2.setTag(yz6Var);
                    }
                    if (this.f.get(i) instanceof kx6) {
                        yz6Var.c((kx6) this.f.get(i));
                    }
                    if (this.e.S() != null && this.e.S().e() != null && this.e.S().e().b() != null) {
                        if (this.e.S().e().b().size() <= 0) {
                            z2 = false;
                        }
                        yz6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof zz6)) {
                        zz6Var = (zz6) view2.getTag();
                    } else {
                        zz6Var = new zz6(this.a);
                        view2 = zz6Var.b();
                        view2.setTag(zz6Var);
                    }
                    zz6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof sz6)) {
                        sz6Var = (sz6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d05e2, viewGroup, false);
                        sz6Var = new sz6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(sz6Var);
                    }
                    if ((this.f.get(i) instanceof sx6) && (sx6Var = (sx6) this.f.get(i)) != null) {
                        sz6Var.h(sx6Var);
                    }
                    sz6Var.j(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof rz6)) {
                        rz6Var = (rz6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0215, viewGroup, false);
                        rz6Var = new rz6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(rz6Var);
                    }
                    if ((this.f.get(i) instanceof mx6) && (mx6Var = (mx6) this.f.get(i)) != null && !ListUtils.isEmpty(mx6Var.f())) {
                        rz6Var.h(mx6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof sy6)) {
                        sy6Var = (sy6) view2.getTag();
                    } else {
                        sy6Var = new sy6(this.a);
                        view2 = sy6Var.a();
                        view2.setTag(sy6Var);
                    }
                    if (this.f.get(i) instanceof qy6) {
                        qy6 qy6Var = (qy6) this.f.get(i);
                        sy6Var.a().setData(qy6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (qy6Var == null) {
                            str = "";
                        } else {
                            str = qy6Var.f();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (qy6Var != null) {
                            str2 = qy6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void l(List<gx4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            by6 by6Var = this.d;
            if (by6Var != null) {
                by6Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
