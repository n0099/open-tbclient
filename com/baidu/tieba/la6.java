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
import com.baidu.tieba.bd6;
import com.baidu.tieba.eb6;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.eq8;
import com.baidu.tieba.iv4;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class la6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public bd6 c;
    public eb6 d;
    public EnterForumModel e;
    public List<ps4> f;
    public boolean g;
    public ra6 h;
    public vc6 i;
    public HashSet<Long> j;
    public eq8.c k;

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la6 a;

        /* loaded from: classes4.dex */
        public class a implements iv4.e {
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

            @Override // com.baidu.tieba.iv4.e
            public void onClick(iv4 iv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                    eq8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    iv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements iv4.e {
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

            @Override // com.baidu.tieba.iv4.e
            public void onClick(iv4 iv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                    iv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements iv4.e {
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

            @Override // com.baidu.tieba.iv4.e
            public void onClick(iv4 iv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iv4Var) == null) {
                    iv4Var.dismiss();
                }
            }
        }

        public e(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.B()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new xc5(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z2 = false;
                ForumCreateInfoData b2 = this.a.e.D().b();
                if (b2 != null) {
                    int A = b2.A();
                    if (A != 220012) {
                        if (A == 2121002) {
                            d45.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0483), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1480), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1411), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (wi.isEmpty(b2.z())) {
                            z = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f047f);
                        } else {
                            z = b2.z();
                        }
                        blockPopInfoData.block_info = z;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0481);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09d2);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z2 = true;
                }
                if (!z2) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0480);
                    if (b2 != null) {
                        if (wi.isEmpty(b2.z())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0480);
                        } else {
                            string = b2.z();
                        }
                    }
                    d45.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09d2), null, new c(this), null).show();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements bd6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vc6 a;
        public final /* synthetic */ la6 b;

        public a(la6 la6Var, vc6 vc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var, vc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = la6Var;
            this.a = vc6Var;
        }

        @Override // com.baidu.tieba.bd6.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.notifyDataSetChanged();
                this.a.y0(this.b.c.s());
                this.a.z0(this.b.c.t());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements eb6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la6 a;

        public b(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la6Var;
        }

        @Override // com.baidu.tieba.eb6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.L(true, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la6 a;

        public c(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new xc5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ la6 a;

        public d(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = la6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new xc5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends eq8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.eq8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.eq8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.eq8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.eq8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public f(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public g(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(la6 la6Var, a aVar) {
            this(la6Var);
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public ImageView b;
        public TextView c;
        public TBSpecificationBtn d;

        public h(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(la6 la6Var, a aVar) {
            this(la6Var);
        }
    }

    /* loaded from: classes4.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(la6 la6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {la6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(la6 la6Var, a aVar) {
            this(la6Var);
        }
    }

    public la6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, vc6 vc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, vc6Var};
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
        this.i = vc6Var;
        bd6 bd6Var = new bd6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = bd6Var;
        bd6Var.E(new a(this, vc6Var));
        this.e = enterForumModel;
        eb6 eb6Var = new eb6(this.a.getPageActivity(), Integer.valueOf(ka6.a(1)).intValue(), 0, this.c);
        this.d = eb6Var;
        eb6Var.u(new b(this));
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.f.size();
            if (size > 0 && i2 < size) {
                return this.f.get(i2);
            }
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<ps4> list = this.f;
            if (list != null && (i2 >= list.size() || i2 < 0)) {
                return -1L;
            }
            return i2;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 < this.f.size() && i2 >= 0) {
                return this.f.get(i2).c();
            }
            return 6;
        }
        return invokeI.intValue;
    }

    public void h(int i2) {
        bd6 bd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (bd6Var = this.c) != null) {
            bd6Var.w(i2);
        }
    }

    public void k(int i2) {
        eb6 eb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (eb6Var = this.d) != null) {
            eb6Var.t(i2);
        }
    }

    public void l(ra6 ra6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ra6Var) == null) {
            if (ra6Var != this.h) {
                this.h = ra6Var;
                notifyDataSetChanged();
            }
            bd6 bd6Var = this.c;
            if (bd6Var != null) {
                bd6Var.C(ra6Var);
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        bd6 bd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (bd6Var = this.c) != null) {
            bd6Var.F(bdUniqueId);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bd6 bd6Var = this.c;
            if (bd6Var == null) {
                return false;
            }
            return bd6Var.k();
        }
        return invokeV.booleanValue;
    }

    public List<ps4> g() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ps4.c.length;
        }
        return invokeV.intValue;
    }

    public void i() {
        bd6 bd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (bd6Var = this.c) != null) {
            bd6Var.x();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.g = true;
            this.j.clear();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g) {
            TiebaStatic.log("c13378");
            this.g = false;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        yc6 yc6Var;
        ps4 ps4Var;
        g gVar;
        h hVar;
        cd6 cd6Var;
        gd6 gd6Var;
        hd6 hd6Var;
        fd6 fd6Var;
        dd6 dd6Var;
        ed6 ed6Var;
        xc6 xc6Var;
        va6 va6Var;
        wc6 wc6Var;
        pa6 pa6Var;
        xb6 xb6Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view2, viewGroup)) == null) {
            boolean z = true;
            boolean z2 = true;
            int i3 = 1;
            boolean z3 = false;
            switch (getItemViewType(i2)) {
                case 0:
                    if (view2 != null && (view2.getTag() instanceof i)) {
                        iVar = (i) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0274, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092256);
                        iVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f63);
                        iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906ea);
                        view2.setTag(iVar);
                    }
                    if (this.f.get(i2) instanceof ta6) {
                        ta6 ta6Var = (ta6) this.f.get(i2);
                        this.d.v(iVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (ta6Var != null) {
                            iVar.a.setText(ta6Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            ra6 ra6Var = this.h;
                            if ((ra6Var != null && ra6Var.a) || ta6Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (ta6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (ta6Var.g != -1) {
                                layoutParams.setMargins(xi.g(viewGroup.getContext(), ta6Var.g), 0, xi.g(viewGroup.getContext(), ta6Var.g), 0);
                            }
                            if (ta6Var.i != -1) {
                                kw4.d(iVar.a).z(ta6Var.i);
                            }
                            if (ta6Var.h != -1) {
                                layoutParams.height = xi.g(viewGroup.getContext(), ta6Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (ta6Var.j != -1) {
                                iVar.c.setPadding(xi.g(viewGroup.getContext(), ta6Var.j), 0, xi.g(viewGroup.getContext(), ta6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof yc6)) {
                        yc6Var = (yc6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0398, viewGroup, false);
                        yc6Var = new yc6(this.a, view2, this.b);
                        view2.setTag(yc6Var);
                    }
                    if ((this.f.get(i2) instanceof ps4) && (ps4Var = this.f.get(i2)) != null) {
                        yc6Var.f(ps4Var);
                    }
                    yc6Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0273, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a5a);
                        gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0906ea);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0271, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091cb1);
                        hVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090eb7);
                        hVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090da3);
                        hVar.d = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090a5a);
                        iz4 iz4Var = new iz4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(iz4Var);
                        view2.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f0591);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03f5));
                        hVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f06ec);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03f3));
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
                    if (view2 != null && (view2.getTag() instanceof cd6)) {
                        cd6Var = (cd6) view2.getTag();
                    } else {
                        cd6Var = new cd6(this.a);
                        view2 = cd6Var.b();
                        view2.setTag(cd6Var);
                    }
                    cd6Var.a();
                    cd6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof gd6)) {
                        gd6Var = (gd6) view2.getTag();
                    } else {
                        gd6Var = new gd6(this.a);
                        view2 = gd6Var.d();
                        view2.setTag(gd6Var);
                    }
                    if (this.f.get(i2) instanceof hu4) {
                        gd6Var.c((hu4) this.f.get(i2));
                    }
                    if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                        if (this.e.D().e().b().size() <= 0) {
                            z = false;
                        }
                        gd6Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof hd6)) {
                        hd6Var = (hd6) view2.getTag();
                    } else {
                        hd6Var = new hd6(this.a);
                        view2 = hd6Var.k();
                        view2.setTag(hd6Var);
                    }
                    if (this.f.get(i2) instanceof fu4) {
                        fu4 fu4Var = (fu4) this.f.get(i2);
                        hd6Var.g(fu4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(fu4Var.j()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", fu4Var.j());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                                if (this.e.D().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i3 = 3;
                                }
                                statisticItem.param("obj_type", i3);
                                hd6Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(fu4Var.j()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof fd6)) {
                        fd6Var = (fd6) view2.getTag();
                    } else {
                        fd6Var = new fd6(this.a);
                        view2 = fd6Var.c();
                        view2.setTag(fd6Var);
                    }
                    if (this.f.get(i2) instanceof gu4) {
                        fd6Var.b((gu4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof dd6)) {
                        dd6Var = (dd6) view2.getTag();
                    } else {
                        dd6Var = new dd6(this.a);
                        view2 = dd6Var.d();
                        view2.setTag(dd6Var);
                    }
                    if (this.f.get(i2) instanceof na6) {
                        dd6Var.c((na6) this.f.get(i2));
                    }
                    if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                        if (this.e.D().e().b().size() <= 0) {
                            z2 = false;
                        }
                        dd6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof ed6)) {
                        ed6Var = (ed6) view2.getTag();
                    } else {
                        ed6Var = new ed6(this.a);
                        view2 = ed6Var.b();
                        view2.setTag(ed6Var);
                    }
                    ed6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof xc6)) {
                        xc6Var = (xc6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0531, viewGroup, false);
                        xc6Var = new xc6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(xc6Var);
                    }
                    if ((this.f.get(i2) instanceof va6) && (va6Var = (va6) this.f.get(i2)) != null) {
                        xc6Var.f(va6Var);
                    }
                    xc6Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof wc6)) {
                        wc6Var = (wc6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01df, viewGroup, false);
                        wc6Var = new wc6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(wc6Var);
                    }
                    if ((this.f.get(i2) instanceof pa6) && (pa6Var = (pa6) this.f.get(i2)) != null && !ListUtils.isEmpty(pa6Var.j())) {
                        wc6Var.f(pa6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof xb6)) {
                        xb6Var = (xb6) view2.getTag();
                    } else {
                        xb6Var = new xb6(this.a);
                        view2 = xb6Var.a();
                        view2.setTag(xb6Var);
                    }
                    if (this.f.get(i2) instanceof tb6) {
                        tb6 tb6Var = (tb6) this.f.get(i2);
                        xb6Var.a().setData(tb6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (tb6Var == null) {
                            str = "";
                        } else {
                            str = tb6Var.j();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (tb6Var != null) {
                            str2 = tb6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void m(List<ps4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            eb6 eb6Var = this.d;
            if (eb6Var != null) {
                eb6Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
