package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.homepage.concern.adapter.HotCardListAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class t18 implements sy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public HotCardListAdapter b;
    public View c;
    public BdRecyclerView d;
    public EMTextView e;
    public EMTextView f;
    public j18 g;
    public int h;
    public BdUniqueId i;
    public View j;
    public LinearLayout k;
    public ImageView l;
    public ImageView m;
    public final rg<jn> n;
    public final View.OnClickListener o;

    /* loaded from: classes8.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public a(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdRecyclerView.i
        public void b(ViewGroup viewGroup, View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{viewGroup, view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.j(String.valueOf(i + 3));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h05 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public b(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // com.baidu.tieba.h05
        public void d(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.j(String.valueOf(i + 3));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends rg<jn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public c(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rg
        public void onLoaded(jn jnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, jnVar, str, i) == null) {
                if (jnVar == null || jnVar.j() == null) {
                    this.a.k(true);
                } else {
                    this.a.k.setBackground(jnVar.j());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t18 a;

        public d(t18 t18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t18Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m != view2 && this.a.f != view2) {
                    if (this.a.e == view2) {
                        str = "2";
                    } else {
                        str = "";
                    }
                } else {
                    str = "1";
                }
                if (!TextUtils.isEmpty(str)) {
                    t18.n("c15354", this.a.g.getTitle(), this.a.g.d(), ListUtils.getCount(this.a.g.getDataList()), str);
                }
                if (this.a.g != null && !xi.isEmpty(this.a.g.e())) {
                    UrlManager.getInstance().dealOneLink(this.a.g.e());
                }
            }
        }
    }

    public t18(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = 3;
        this.n = new c(this);
        this.o = new d(this);
        this.a = tbPageContext;
        i();
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o.onClick(this.c);
            n("c15354", this.g.getTitle(), this.g.d(), ListUtils.getCount(this.g.getDataList()), str);
        }
    }

    public void m(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.i = bdUniqueId;
        }
    }

    public static void n(String str, String str2, int i, int i2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_name", str2);
            statisticItem.param("obj_locate", i);
            statisticItem.param(TiebaStatic.Params.OBJ_TO, i2);
            if (!TextUtils.isEmpty(str3)) {
                statisticItem.param("obj_param1", str3);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d084e, (ViewGroup) null);
            this.c = inflate;
            this.d = (BdRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f090fa0);
            this.e = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090eed);
            this.f = (EMTextView) this.c.findViewById(R.id.right_btn);
            this.l = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090f06);
            this.j = this.c.findViewById(R.id.line_view);
            this.m = (ImageView) this.c.findViewById(R.id.arrow_img);
            this.k = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090ede);
            this.b = new HotCardListAdapter(this.a);
            this.d.setOverScrollMode(2);
            this.d.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            this.d.setAdapter(this.b);
            this.c.setOnClickListener(this.o);
            this.m.setOnClickListener(this.o);
            this.f.setOnClickListener(this.o);
            this.e.setOnClickListener(this.o);
            this.d.setOnItemClickListener(new a(this));
            this.b.o(new b(this));
        }
    }

    public final void k(boolean z) {
        j18 j18Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048579, this, z) != null) || (j18Var = this.g) == null) {
            return;
        }
        if (!z && j18Var.c() != null && !TextUtils.isEmpty(qla.g(this.g.c()))) {
            jn jnVar = (jn) sg.h().m(qla.g(this.g.c()), 45, this.n, this.i);
            if (jnVar != null) {
                this.k.setBackground(jnVar.j());
                return;
            }
            return;
        }
        this.k.setBackground(WebPManager.getMaskDrawable((int) R.drawable.bg_home_quanceng_card, WebPManager.ResourceStateType.NORMAL));
    }

    public void l(j18 j18Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, j18Var) != null) || j18Var == null) {
            return;
        }
        this.g = j18Var;
        this.e.setText(j18Var.getTitle());
        this.f.setText(j18Var.f());
        this.b.p(j18Var.getDataList(), j18Var.g());
        this.b.notifyDataSetChanged();
        k(false);
        n("c15353", this.g.getTitle(), this.g.d(), ListUtils.getCount(this.g.getDataList()), "");
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) && this.h != i) {
            d85 d2 = d85.d(this.e);
            d2.D(R.string.F_X02);
            d2.C(R.dimen.T_X07);
            d2.x(R.color.CAM_X0105);
            d85 d3 = d85.d(this.f);
            d3.C(R.dimen.T_X08);
            d3.x(R.color.CAM_X0109);
            d85.d(this.j).f(R.color.CAM_X0604);
            this.l.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_qunceng_hot_head, WebPManager.ResourceStateType.NORMAL));
            k(false);
            d85 d4 = d85.d(this.c);
            d4.o(R.string.J_X06);
            d4.f(R.color.CAM_X0201);
            WebPManager.setPureDrawable(this.m, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            HotCardListAdapter hotCardListAdapter = this.b;
            if (hotCardListAdapter != null) {
                hotCardListAdapter.notifyDataSetChanged();
            }
            this.h = i;
        }
    }
}
