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
import com.baidu.tieba.jv4;
import com.baidu.tieba.nd6;
import com.baidu.tieba.pq8;
import com.baidu.tieba.qb6;
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
public class xa6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public nd6 c;
    public qb6 d;
    public EnterForumModel e;
    public List<qs4> f;
    public boolean g;
    public db6 h;
    public hd6 i;
    public HashSet<Long> j;
    public pq8.c k;

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa6 a;

        /* loaded from: classes6.dex */
        public class a implements jv4.e {
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

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    pq8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    jv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements jv4.e {
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

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements jv4.e {
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

            @Override // com.baidu.tieba.jv4.e
            public void onClick(jv4 jv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, jv4Var) == null) {
                    jv4Var.dismiss();
                }
            }
        }

        public e(xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.B()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new ed5(14, null, null, null));
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
                            i45.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0484), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1487), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1418), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (xi.isEmpty(b2.z())) {
                            z = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0480);
                        } else {
                            z = b2.z();
                        }
                        blockPopInfoData.block_info = z;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0482);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09d4);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z2 = true;
                }
                if (!z2) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0481);
                    if (b2 != null) {
                        if (xi.isEmpty(b2.z())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0481);
                        } else {
                            string = b2.z();
                        }
                    }
                    i45.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09d4), null, new c(this), null).show();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements nd6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd6 a;
        public final /* synthetic */ xa6 b;

        public a(xa6 xa6Var, hd6 hd6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var, hd6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xa6Var;
            this.a = hd6Var;
        }

        @Override // com.baidu.tieba.nd6.j
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
    public class b implements qb6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa6 a;

        public b(xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa6Var;
        }

        @Override // com.baidu.tieba.qb6.d
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
        public final /* synthetic */ xa6 a;

        public c(xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new ed5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xa6 a;

        public d(xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xa6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new ed5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends pq8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.pq8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.pq8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.pq8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.pq8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public f(xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var};
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

    /* loaded from: classes6.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public g(xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(xa6 xa6Var, a aVar) {
            this(xa6Var);
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

        public h(xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(xa6 xa6Var, a aVar) {
            this(xa6Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(xa6 xa6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xa6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(xa6 xa6Var, a aVar) {
            this(xa6Var);
        }
    }

    public xa6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, hd6 hd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, hd6Var};
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
        this.i = hd6Var;
        nd6 nd6Var = new nd6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = nd6Var;
        nd6Var.E(new a(this, hd6Var));
        this.e = enterForumModel;
        qb6 qb6Var = new qb6(this.a.getPageActivity(), Integer.valueOf(wa6.a(1)).intValue(), 0, this.c);
        this.d = qb6Var;
        qb6Var.u(new b(this));
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
            List<qs4> list = this.f;
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
        nd6 nd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (nd6Var = this.c) != null) {
            nd6Var.w(i2);
        }
    }

    public void k(int i2) {
        qb6 qb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (qb6Var = this.d) != null) {
            qb6Var.t(i2);
        }
    }

    public void l(db6 db6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, db6Var) == null) {
            if (db6Var != this.h) {
                this.h = db6Var;
                notifyDataSetChanged();
            }
            nd6 nd6Var = this.c;
            if (nd6Var != null) {
                nd6Var.C(db6Var);
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        nd6 nd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (nd6Var = this.c) != null) {
            nd6Var.F(bdUniqueId);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            nd6 nd6Var = this.c;
            if (nd6Var == null) {
                return false;
            }
            return nd6Var.k();
        }
        return invokeV.booleanValue;
    }

    public List<qs4> g() {
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
            return qs4.c.length;
        }
        return invokeV.intValue;
    }

    public void i() {
        nd6 nd6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (nd6Var = this.c) != null) {
            nd6Var.x();
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
        kd6 kd6Var;
        qs4 qs4Var;
        g gVar;
        h hVar;
        od6 od6Var;
        sd6 sd6Var;
        td6 td6Var;
        rd6 rd6Var;
        pd6 pd6Var;
        qd6 qd6Var;
        jd6 jd6Var;
        hb6 hb6Var;
        id6 id6Var;
        bb6 bb6Var;
        jc6 jc6Var;
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0275, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092263);
                        iVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091f6f);
                        iVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f0906eb);
                        view2.setTag(iVar);
                    }
                    if (this.f.get(i2) instanceof fb6) {
                        fb6 fb6Var = (fb6) this.f.get(i2);
                        this.d.v(iVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (fb6Var != null) {
                            iVar.a.setText(fb6Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            db6 db6Var = this.h;
                            if ((db6Var != null && db6Var.a) || fb6Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (fb6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (fb6Var.g != -1) {
                                layoutParams.setMargins(yi.g(viewGroup.getContext(), fb6Var.g), 0, yi.g(viewGroup.getContext(), fb6Var.g), 0);
                            }
                            if (fb6Var.i != -1) {
                                pw4.d(iVar.a).z(fb6Var.i);
                            }
                            if (fb6Var.h != -1) {
                                layoutParams.height = yi.g(viewGroup.getContext(), fb6Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (fb6Var.j != -1) {
                                iVar.c.setPadding(yi.g(viewGroup.getContext(), fb6Var.j), 0, yi.g(viewGroup.getContext(), fb6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof kd6)) {
                        kd6Var = (kd6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0399, viewGroup, false);
                        kd6Var = new kd6(this.a, view2, this.b);
                        view2.setTag(kd6Var);
                    }
                    if ((this.f.get(i2) instanceof qs4) && (qs4Var = this.f.get(i2)) != null) {
                        kd6Var.f(qs4Var);
                    }
                    kd6Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof g)) {
                        gVar = (g) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0274, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a5b);
                        gVar.b = view2.findViewById(R.id.obfuscated_res_0x7f0906eb);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0272, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091cbd);
                        hVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090eba);
                        hVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090da5);
                        hVar.d = (TBSpecificationBtn) view2.findViewById(R.id.obfuscated_res_0x7f090a5b);
                        nz4 nz4Var = new nz4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(nz4Var);
                        view2.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f0592);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03f6));
                        hVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.c.setText(R.string.obfuscated_res_0x7f0f06ed);
                        hVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03f4));
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
                    if (view2 != null && (view2.getTag() instanceof od6)) {
                        od6Var = (od6) view2.getTag();
                    } else {
                        od6Var = new od6(this.a);
                        view2 = od6Var.b();
                        view2.setTag(od6Var);
                    }
                    od6Var.a();
                    od6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof sd6)) {
                        sd6Var = (sd6) view2.getTag();
                    } else {
                        sd6Var = new sd6(this.a);
                        view2 = sd6Var.d();
                        view2.setTag(sd6Var);
                    }
                    if (this.f.get(i2) instanceof iu4) {
                        sd6Var.c((iu4) this.f.get(i2));
                    }
                    if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                        if (this.e.D().e().b().size() <= 0) {
                            z = false;
                        }
                        sd6Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof td6)) {
                        td6Var = (td6) view2.getTag();
                    } else {
                        td6Var = new td6(this.a);
                        view2 = td6Var.k();
                        view2.setTag(td6Var);
                    }
                    if (this.f.get(i2) instanceof gu4) {
                        gu4 gu4Var = (gu4) this.f.get(i2);
                        td6Var.g(gu4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(gu4Var.j()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", gu4Var.j());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                                if (this.e.D().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i3 = 3;
                                }
                                statisticItem.param("obj_type", i3);
                                td6Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(gu4Var.j()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof rd6)) {
                        rd6Var = (rd6) view2.getTag();
                    } else {
                        rd6Var = new rd6(this.a);
                        view2 = rd6Var.c();
                        view2.setTag(rd6Var);
                    }
                    if (this.f.get(i2) instanceof hu4) {
                        rd6Var.b((hu4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof pd6)) {
                        pd6Var = (pd6) view2.getTag();
                    } else {
                        pd6Var = new pd6(this.a);
                        view2 = pd6Var.d();
                        view2.setTag(pd6Var);
                    }
                    if (this.f.get(i2) instanceof za6) {
                        pd6Var.c((za6) this.f.get(i2));
                    }
                    if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                        if (this.e.D().e().b().size() <= 0) {
                            z2 = false;
                        }
                        pd6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof qd6)) {
                        qd6Var = (qd6) view2.getTag();
                    } else {
                        qd6Var = new qd6(this.a);
                        view2 = qd6Var.b();
                        view2.setTag(qd6Var);
                    }
                    qd6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof jd6)) {
                        jd6Var = (jd6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0532, viewGroup, false);
                        jd6Var = new jd6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(jd6Var);
                    }
                    if ((this.f.get(i2) instanceof hb6) && (hb6Var = (hb6) this.f.get(i2)) != null) {
                        jd6Var.f(hb6Var);
                    }
                    jd6Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof id6)) {
                        id6Var = (id6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01df, viewGroup, false);
                        id6Var = new id6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(id6Var);
                    }
                    if ((this.f.get(i2) instanceof bb6) && (bb6Var = (bb6) this.f.get(i2)) != null && !ListUtils.isEmpty(bb6Var.j())) {
                        id6Var.f(bb6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof jc6)) {
                        jc6Var = (jc6) view2.getTag();
                    } else {
                        jc6Var = new jc6(this.a);
                        view2 = jc6Var.a();
                        view2.setTag(jc6Var);
                    }
                    if (this.f.get(i2) instanceof fc6) {
                        fc6 fc6Var = (fc6) this.f.get(i2);
                        jc6Var.a().setData(fc6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (fc6Var == null) {
                            str = "";
                        } else {
                            str = fc6Var.j();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (fc6Var != null) {
                            str2 = fc6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void m(List<qs4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            qb6 qb6Var = this.d;
            if (qb6Var != null) {
                qb6Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
