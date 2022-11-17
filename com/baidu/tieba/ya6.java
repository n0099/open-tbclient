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
import com.baidu.tieba.kv4;
import com.baidu.tieba.od6;
import com.baidu.tieba.qq8;
import com.baidu.tieba.rb6;
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
public class ya6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public od6 c;
    public rb6 d;
    public EnterForumModel e;
    public List<rs4> f;
    public boolean g;
    public eb6 h;
    public id6 i;
    public HashSet<Long> j;
    public qq8.c k;

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya6 a;

        /* loaded from: classes6.dex */
        public class a implements kv4.e {
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

            @Override // com.baidu.tieba.kv4.e
            public void onClick(kv4 kv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                    qq8.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.a.a.k);
                    kv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements kv4.e {
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

            @Override // com.baidu.tieba.kv4.e
            public void onClick(kv4 kv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                    kv4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class c implements kv4.e {
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

            @Override // com.baidu.tieba.kv4.e
            public void onClick(kv4 kv4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, kv4Var) == null) {
                    kv4Var.dismiss();
                }
            }
        }

        public e(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.B()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new fd5(14, null, null, null));
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
                            j45.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0484), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1487), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1418), new a(this), new b(this)).show();
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
                    j45.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f09d4), null, new c(this), null).show();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements od6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id6 a;
        public final /* synthetic */ ya6 b;

        public a(ya6 ya6Var, id6 id6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var, id6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ya6Var;
            this.a = id6Var;
        }

        @Override // com.baidu.tieba.od6.j
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
    public class b implements rb6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya6 a;

        public b(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya6Var;
        }

        @Override // com.baidu.tieba.rb6.d
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
        public final /* synthetic */ ya6 a;

        public c(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new fd5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya6 a;

        public d(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new fd5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends qq8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.qq8.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.qq8.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.qq8.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.baidu.tieba.qq8.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }

        public f(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
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

        public g(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(ya6 ya6Var, a aVar) {
            this(ya6Var);
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

        public h(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(ya6 ya6Var, a aVar) {
            this(ya6Var);
        }
    }

    /* loaded from: classes6.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public i(ya6 ya6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ i(ya6 ya6Var, a aVar) {
            this(ya6Var);
        }
    }

    public ya6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, id6 id6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, id6Var};
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
        this.i = id6Var;
        od6 od6Var = new od6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = od6Var;
        od6Var.E(new a(this, id6Var));
        this.e = enterForumModel;
        rb6 rb6Var = new rb6(this.a.getPageActivity(), Integer.valueOf(xa6.a(1)).intValue(), 0, this.c);
        this.d = rb6Var;
        rb6Var.u(new b(this));
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
            List<rs4> list = this.f;
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
        od6 od6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (od6Var = this.c) != null) {
            od6Var.w(i2);
        }
    }

    public void k(int i2) {
        rb6 rb6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && (rb6Var = this.d) != null) {
            rb6Var.t(i2);
        }
    }

    public void l(eb6 eb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eb6Var) == null) {
            if (eb6Var != this.h) {
                this.h = eb6Var;
                notifyDataSetChanged();
            }
            od6 od6Var = this.c;
            if (od6Var != null) {
                od6Var.C(eb6Var);
            }
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        od6 od6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (od6Var = this.c) != null) {
            od6Var.F(bdUniqueId);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            od6 od6Var = this.c;
            if (od6Var == null) {
                return false;
            }
            return od6Var.k();
        }
        return invokeV.booleanValue;
    }

    public List<rs4> g() {
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
            return rs4.c.length;
        }
        return invokeV.intValue;
    }

    public void i() {
        od6 od6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (od6Var = this.c) != null) {
            od6Var.x();
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
        ld6 ld6Var;
        rs4 rs4Var;
        g gVar;
        h hVar;
        pd6 pd6Var;
        td6 td6Var;
        ud6 ud6Var;
        sd6 sd6Var;
        qd6 qd6Var;
        rd6 rd6Var;
        kd6 kd6Var;
        ib6 ib6Var;
        jd6 jd6Var;
        cb6 cb6Var;
        kc6 kc6Var;
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
                    if (this.f.get(i2) instanceof gb6) {
                        gb6 gb6Var = (gb6) this.f.get(i2);
                        this.d.v(iVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (gb6Var != null) {
                            iVar.a.setText(gb6Var.d);
                            SkinManager.setViewTextColor(iVar.a, (int) R.color.CAM_X0105);
                            eb6 eb6Var = this.h;
                            if ((eb6Var != null && eb6Var.a) || gb6Var.f) {
                                SkinManager.setBackgroundResource(iVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.b;
                            if (textView != null) {
                                if (gb6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) iVar.c.getLayoutParams();
                            if (gb6Var.g != -1) {
                                layoutParams.setMargins(yi.g(viewGroup.getContext(), gb6Var.g), 0, yi.g(viewGroup.getContext(), gb6Var.g), 0);
                            }
                            if (gb6Var.i != -1) {
                                qw4.d(iVar.a).z(gb6Var.i);
                            }
                            if (gb6Var.h != -1) {
                                layoutParams.height = yi.g(viewGroup.getContext(), gb6Var.h);
                            }
                            iVar.c.setLayoutParams(layoutParams);
                            if (gb6Var.j != -1) {
                                iVar.c.setPadding(yi.g(viewGroup.getContext(), gb6Var.j), 0, yi.g(viewGroup.getContext(), gb6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof ld6)) {
                        ld6Var = (ld6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0399, viewGroup, false);
                        ld6Var = new ld6(this.a, view2, this.b);
                        view2.setTag(ld6Var);
                    }
                    if ((this.f.get(i2) instanceof rs4) && (rs4Var = this.f.get(i2)) != null) {
                        ld6Var.f(rs4Var);
                    }
                    ld6Var.h(this.h);
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
                        oz4 oz4Var = new oz4();
                        hVar.d.setTextSize(R.dimen.tbds42);
                        hVar.d.setConfig(oz4Var);
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
                    if (view2 != null && (view2.getTag() instanceof pd6)) {
                        pd6Var = (pd6) view2.getTag();
                    } else {
                        pd6Var = new pd6(this.a);
                        view2 = pd6Var.b();
                        view2.setTag(pd6Var);
                    }
                    pd6Var.a();
                    pd6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof td6)) {
                        td6Var = (td6) view2.getTag();
                    } else {
                        td6Var = new td6(this.a);
                        view2 = td6Var.d();
                        view2.setTag(td6Var);
                    }
                    if (this.f.get(i2) instanceof ju4) {
                        td6Var.c((ju4) this.f.get(i2));
                    }
                    if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                        if (this.e.D().e().b().size() <= 0) {
                            z = false;
                        }
                        td6Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof ud6)) {
                        ud6Var = (ud6) view2.getTag();
                    } else {
                        ud6Var = new ud6(this.a);
                        view2 = ud6Var.k();
                        view2.setTag(ud6Var);
                    }
                    if (this.f.get(i2) instanceof hu4) {
                        hu4 hu4Var = (hu4) this.f.get(i2);
                        ud6Var.g(hu4Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(hu4Var.j()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", hu4Var.j());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                                if (this.e.D().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i3 = 3;
                                }
                                statisticItem.param("obj_type", i3);
                                ud6Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(hu4Var.j()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof sd6)) {
                        sd6Var = (sd6) view2.getTag();
                    } else {
                        sd6Var = new sd6(this.a);
                        view2 = sd6Var.c();
                        view2.setTag(sd6Var);
                    }
                    if (this.f.get(i2) instanceof iu4) {
                        sd6Var.b((iu4) this.f.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof qd6)) {
                        qd6Var = (qd6) view2.getTag();
                    } else {
                        qd6Var = new qd6(this.a);
                        view2 = qd6Var.d();
                        view2.setTag(qd6Var);
                    }
                    if (this.f.get(i2) instanceof ab6) {
                        qd6Var.c((ab6) this.f.get(i2));
                    }
                    if (this.e.D() != null && this.e.D().e() != null && this.e.D().e().b() != null) {
                        if (this.e.D().e().b().size() <= 0) {
                            z2 = false;
                        }
                        qd6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof rd6)) {
                        rd6Var = (rd6) view2.getTag();
                    } else {
                        rd6Var = new rd6(this.a);
                        view2 = rd6Var.b();
                        view2.setTag(rd6Var);
                    }
                    rd6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof kd6)) {
                        kd6Var = (kd6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0532, viewGroup, false);
                        kd6Var = new kd6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(kd6Var);
                    }
                    if ((this.f.get(i2) instanceof ib6) && (ib6Var = (ib6) this.f.get(i2)) != null) {
                        kd6Var.f(ib6Var);
                    }
                    kd6Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof jd6)) {
                        jd6Var = (jd6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01df, viewGroup, false);
                        jd6Var = new jd6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(jd6Var);
                    }
                    if ((this.f.get(i2) instanceof cb6) && (cb6Var = (cb6) this.f.get(i2)) != null && !ListUtils.isEmpty(cb6Var.j())) {
                        jd6Var.f(cb6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof kc6)) {
                        kc6Var = (kc6) view2.getTag();
                    } else {
                        kc6Var = new kc6(this.a);
                        view2 = kc6Var.a();
                        view2.setTag(kc6Var);
                    }
                    if (this.f.get(i2) instanceof gc6) {
                        gc6 gc6Var = (gc6) this.f.get(i2);
                        kc6Var.a().setData(gc6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (gc6Var == null) {
                            str = "";
                        } else {
                            str = gc6Var.j();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (gc6Var != null) {
                            str2 = gc6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void m(List<rs4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            rb6 rb6Var = this.d;
            if (rb6Var != null) {
                rb6Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
