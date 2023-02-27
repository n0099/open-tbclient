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
import com.baidu.tieba.bp6;
import com.baidu.tieba.en6;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.q15;
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
public class lm6 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ViewEventCenter b;
    public bp6 c;
    public en6 d;
    public EnterForumModel e;
    public List<xy4> f;
    public boolean g;
    public rm6 h;
    public vo6 i;
    public HashSet<Long> j;

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lm6 a;

        /* loaded from: classes5.dex */
        public class a implements q15.e {
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

            @Override // com.baidu.tieba.q15.e
            public void onClick(q15 q15Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                    a79.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", null);
                    q15Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements q15.e {
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

            @Override // com.baidu.tieba.q15.e
            public void onClick(q15 q15Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                    q15Var.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class c implements q15.e {
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

            @Override // com.baidu.tieba.q15.e
            public void onClick(q15 q15Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                    q15Var.dismiss();
                }
            }
        }

        public e(lm6 lm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String N;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log("c13379");
                if (this.a.e.P()) {
                    if (this.a.b != null) {
                        this.a.b.dispatchMvcEvent(new kk5(14, null, null, null));
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
                            ua5.b(this.a.a, null, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f04a0), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f1514), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f14a5), new a(this), new b(this)).show();
                        }
                    } else {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        if (dj.isEmpty(b2.N())) {
                            N = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f049c);
                        } else {
                            N = b2.N();
                        }
                        blockPopInfoData.block_info = N;
                        blockPopInfoData.ahead_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f049e);
                        blockPopInfoData.ok_info = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a59);
                        blockPopInfoData.ahead_url = AntiHelper.a;
                        AntiHelper.s(this.a.a.getPageActivity(), blockPopInfoData);
                    }
                    z = true;
                }
                if (!z) {
                    String string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f049d);
                    if (b2 != null) {
                        if (dj.isEmpty(b2.N())) {
                            string = this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f049d);
                        } else {
                            string = b2.N();
                        }
                    }
                    ua5.b(this.a.a, null, string, this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a59), null, new c(this), null).show();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements bp6.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vo6 a;
        public final /* synthetic */ lm6 b;

        public a(lm6 lm6Var, vo6 vo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm6Var, vo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lm6Var;
            this.a = vo6Var;
        }

        @Override // com.baidu.tieba.bp6.j
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
    public class b implements en6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lm6 a;

        public b(lm6 lm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lm6Var;
        }

        @Override // com.baidu.tieba.en6.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.e.Z(true, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lm6 a;

        public c(lm6 lm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new kk5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lm6 a;

        public d(lm6 lm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lm6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null) {
                this.a.b.dispatchMvcEvent(new kk5(6, null, null, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;

        public f(lm6 lm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(lm6 lm6Var, a aVar) {
            this(lm6Var);
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

        public g(lm6 lm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ g(lm6 lm6Var, a aVar) {
            this(lm6Var);
        }
    }

    /* loaded from: classes5.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public TextView b;
        public RelativeLayout c;

        public h(lm6 lm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ h(lm6 lm6Var, a aVar) {
            this(lm6Var);
        }
    }

    public lm6(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, vo6 vo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, vo6Var};
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
        this.i = vo6Var;
        bp6 bp6Var = new bp6(this.a, recentlyVisitedForumModel, viewEventCenter);
        this.c = bp6Var;
        bp6Var.C(new a(this, vo6Var));
        this.e = enterForumModel;
        en6 en6Var = new en6(this.a.getPageActivity(), Integer.valueOf(km6.a(1)).intValue(), 0, this.c);
        this.d = en6Var;
        en6Var.u(new b(this));
    }

    public void g(int i) {
        bp6 bp6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (bp6Var = this.c) != null) {
            bp6Var.u(i);
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
            List<xy4> list = this.f;
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
        en6 en6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (en6Var = this.d) != null) {
            en6Var.t(i);
        }
    }

    public void k(rm6 rm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rm6Var) == null) {
            if (rm6Var != this.h) {
                this.h = rm6Var;
                notifyDataSetChanged();
            }
            bp6 bp6Var = this.c;
            if (bp6Var != null) {
                bp6Var.A(rm6Var);
            }
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        bp6 bp6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) && (bp6Var = this.c) != null) {
            bp6Var.D(bdUniqueId);
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            bp6 bp6Var = this.c;
            if (bp6Var == null) {
                return false;
            }
            return bp6Var.j();
        }
        return invokeV.booleanValue;
    }

    public List<xy4> f() {
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
            return xy4.c.length;
        }
        return invokeV.intValue;
    }

    public void h() {
        bp6 bp6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (bp6Var = this.c) != null) {
            bp6Var.v();
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
        yo6 yo6Var;
        xy4 xy4Var;
        f fVar;
        g gVar;
        cp6 cp6Var;
        gp6 gp6Var;
        hp6 hp6Var;
        fp6 fp6Var;
        dp6 dp6Var;
        ep6 ep6Var;
        xo6 xo6Var;
        vm6 vm6Var;
        wo6 wo6Var;
        pm6 pm6Var;
        xn6 xn6Var;
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0282, viewGroup, false);
                        hVar = new h(this, null);
                        hVar.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0923a4);
                        hVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09209c);
                        hVar.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090755);
                        view2.setTag(hVar);
                    }
                    if (this.f.get(i) instanceof tm6) {
                        tm6 tm6Var = (tm6) this.f.get(i);
                        this.d.v(hVar.b);
                        this.d.r();
                        this.d.q(TbadkCoreApplication.getInst().getSkinType());
                        if (tm6Var != null) {
                            hVar.a.setText(tm6Var.d);
                            SkinManager.setViewTextColor(hVar.a, (int) R.color.CAM_X0105);
                            rm6 rm6Var = this.h;
                            if ((rm6Var != null && rm6Var.a) || tm6Var.f) {
                                SkinManager.setBackgroundResource(hVar.c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(hVar.c, R.color.CAM_X0205);
                            }
                            TextView textView = hVar.b;
                            if (textView != null) {
                                if (tm6Var.e) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(hVar.b, R.color.transparent);
                            }
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.c.getLayoutParams();
                            if (tm6Var.g != -1) {
                                layoutParams.setMargins(ej.g(viewGroup.getContext(), tm6Var.g), 0, ej.g(viewGroup.getContext(), tm6Var.g), 0);
                            }
                            if (tm6Var.i != -1) {
                                b35.d(hVar.a).z(tm6Var.i);
                            }
                            if (tm6Var.h != -1) {
                                layoutParams.height = ej.g(viewGroup.getContext(), tm6Var.h);
                            }
                            hVar.c.setLayoutParams(layoutParams);
                            if (tm6Var.j != -1) {
                                hVar.c.setPadding(ej.g(viewGroup.getContext(), tm6Var.j), 0, ej.g(viewGroup.getContext(), tm6Var.j), 0);
                                return view2;
                            }
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 1:
                    if (view2 != null && (view2.getTag() instanceof yo6)) {
                        yo6Var = (yo6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d03b6, viewGroup, false);
                        yo6Var = new yo6(this.a, view2, this.b);
                        view2.setTag(yo6Var);
                    }
                    if ((this.f.get(i) instanceof xy4) && (xy4Var = this.f.get(i)) != null) {
                        yo6Var.f(xy4Var);
                    }
                    yo6Var.h(this.h);
                    return view2;
                case 2:
                    if (view2 != null && (view2.getTag() instanceof f)) {
                        fVar = (f) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0281, (ViewGroup) null);
                        fVar = new f(this, null);
                        fVar.a = (TextView) view2.findViewById(R.id.footer_text);
                        fVar.b = view2.findViewById(R.id.obfuscated_res_0x7f090755);
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
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d027f, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091de3);
                        gVar.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090fb7);
                        gVar.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e99);
                        gVar.d = (TBSpecificationBtn) view2.findViewById(R.id.footer_text);
                        y55 y55Var = new y55();
                        gVar.d.setTextSize(R.dimen.tbds42);
                        gVar.d.setConfig(y55Var);
                        view2.setTag(gVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        gVar.c.setText(R.string.obfuscated_res_0x7f0f05b4);
                        gVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0412));
                        gVar.d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(gVar.b, R.drawable.new_pic_emotion_09);
                    } else {
                        gVar.c.setText(R.string.obfuscated_res_0x7f0f072d);
                        gVar.d.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0410));
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
                    if (view2 != null && (view2.getTag() instanceof cp6)) {
                        cp6Var = (cp6) view2.getTag();
                    } else {
                        cp6Var = new cp6(this.a);
                        view2 = cp6Var.b();
                        view2.setTag(cp6Var);
                    }
                    cp6Var.a();
                    cp6Var.c(new e(this));
                    return view2;
                case 6:
                default:
                    return view2;
                case 7:
                    if (view2 != null && (view2.getTag() instanceof gp6)) {
                        gp6Var = (gp6) view2.getTag();
                    } else {
                        gp6Var = new gp6(this.a);
                        view2 = gp6Var.d();
                        view2.setTag(gp6Var);
                    }
                    if (this.f.get(i) instanceof p05) {
                        gp6Var.c((p05) this.f.get(i));
                    }
                    if (this.e.R() != null && this.e.R().e() != null && this.e.R().e().b() != null) {
                        if (this.e.R().e().b().size() <= 0) {
                            z = false;
                        }
                        gp6Var.e(z);
                        return view2;
                    }
                    return view2;
                case 8:
                    if (view2 != null && (view2.getTag() instanceof hp6)) {
                        hp6Var = (hp6) view2.getTag();
                    } else {
                        hp6Var = new hp6(this.a);
                        view2 = hp6Var.k();
                        view2.setTag(hp6Var);
                    }
                    if (this.f.get(i) instanceof n05) {
                        n05 n05Var = (n05) this.f.get(i);
                        hp6Var.g(n05Var);
                        if (this.i.Q().getGlobalVisibleRect(new Rect()) && view2.getGlobalVisibleRect(new Rect()) && !this.j.contains(Long.valueOf(n05Var.h()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", n05Var.h());
                            statisticItem.param("obj_locate", 1);
                            if (this.e.R() != null && this.e.R().e() != null && this.e.R().e().b() != null) {
                                if (this.e.R().e().b().size() > 0) {
                                    z3 = true;
                                }
                                if (z3) {
                                    i2 = 3;
                                }
                                statisticItem.param("obj_type", i2);
                                hp6Var.m(z3);
                            }
                            TiebaStatic.log(statisticItem);
                            this.j.add(Long.valueOf(n05Var.h()));
                            return view2;
                        }
                        return view2;
                    }
                    return view2;
                case 9:
                    if (view2 != null && (view2.getTag() instanceof fp6)) {
                        fp6Var = (fp6) view2.getTag();
                    } else {
                        fp6Var = new fp6(this.a);
                        view2 = fp6Var.c();
                        view2.setTag(fp6Var);
                    }
                    if (this.f.get(i) instanceof o05) {
                        fp6Var.b((o05) this.f.get(i));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view2;
                case 10:
                    if (view2 != null && (view2.getTag() instanceof dp6)) {
                        dp6Var = (dp6) view2.getTag();
                    } else {
                        dp6Var = new dp6(this.a);
                        view2 = dp6Var.d();
                        view2.setTag(dp6Var);
                    }
                    if (this.f.get(i) instanceof nm6) {
                        dp6Var.c((nm6) this.f.get(i));
                    }
                    if (this.e.R() != null && this.e.R().e() != null && this.e.R().e().b() != null) {
                        if (this.e.R().e().b().size() <= 0) {
                            z2 = false;
                        }
                        dp6Var.e(z2);
                        return view2;
                    }
                    return view2;
                case 11:
                    if (view2 != null && (view2.getTag() instanceof ep6)) {
                        ep6Var = (ep6) view2.getTag();
                    } else {
                        ep6Var = new ep6(this.a);
                        view2 = ep6Var.b();
                        view2.setTag(ep6Var);
                    }
                    ep6Var.a();
                    return view2;
                case 12:
                    if (view2 != null && (view2.getTag() instanceof xo6)) {
                        xo6Var = (xo6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d0557, viewGroup, false);
                        xo6Var = new xo6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(xo6Var);
                    }
                    if ((this.f.get(i) instanceof vm6) && (vm6Var = (vm6) this.f.get(i)) != null) {
                        xo6Var.f(vm6Var);
                    }
                    xo6Var.h(this.h);
                    return view2;
                case 13:
                    if (view2 != null && (view2.getTag() instanceof wo6)) {
                        wo6Var = (wo6) view2.getTag();
                    } else {
                        view2 = this.a.getPageActivity().getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01ec, viewGroup, false);
                        wo6Var = new wo6(this.a, view2, this.b, this.c, this.e);
                        view2.setTag(wo6Var);
                    }
                    if ((this.f.get(i) instanceof pm6) && (pm6Var = (pm6) this.f.get(i)) != null && !ListUtils.isEmpty(pm6Var.h())) {
                        wo6Var.f(pm6Var);
                        return view2;
                    }
                    return view2;
                case 14:
                    if (view2 != null && (view2.getTag() instanceof xn6)) {
                        xn6Var = (xn6) view2.getTag();
                    } else {
                        xn6Var = new xn6(this.a);
                        view2 = xn6Var.a();
                        view2.setTag(xn6Var);
                    }
                    if (this.f.get(i) instanceof tn6) {
                        tn6 tn6Var = (tn6) this.f.get(i);
                        xn6Var.a().setData(tn6Var);
                        StatisticItem param = new StatisticItem("c14584").param("uid", TbadkCoreApplication.getCurrentAccountId());
                        String str2 = "";
                        if (tn6Var == null) {
                            str = "";
                        } else {
                            str = tn6Var.h();
                        }
                        StatisticItem param2 = param.param("fid", str);
                        if (tn6Var != null) {
                            str2 = tn6Var.getFrom();
                        }
                        TiebaStatic.log(param2.param("obj_source", str2));
                        return view2;
                    }
                    return view2;
            }
        }
        return (View) invokeILL.objValue;
    }

    public void l(List<xy4> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, list, z) == null) {
            en6 en6Var = this.d;
            if (en6Var != null) {
                en6Var.p();
            }
            this.f.clear();
            if (list != null) {
                this.f.addAll(list);
            }
            this.i.c0(z);
        }
    }
}
