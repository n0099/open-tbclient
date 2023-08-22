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
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
public class z08 implements ux {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext a;
    public HotCardListAdapter b;
    public View c;
    public BdRecyclerView d;
    public EMTextView e;
    public EMTextView f;
    public p08 g;
    public int h;
    public BdUniqueId i;
    public View j;
    public LinearLayout k;
    public ImageView l;
    public ImageView m;
    public final BdResourceCallback<BdImage> n;
    public final View.OnClickListener o;

    /* loaded from: classes8.dex */
    public class a implements BdRecyclerView.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z08 a;

        public a(z08 z08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z08Var;
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
    public class b implements qz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z08 a;

        public b(z08 z08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z08Var;
        }

        @Override // com.baidu.tieba.qz4
        public void d(View view2, Object obj, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, obj, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                this.a.j(String.valueOf(i + 3));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z08 a;

        public c(z08 z08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                if (bdImage == null || bdImage.getAsBitmapDrawable() == null) {
                    this.a.k(true);
                } else {
                    this.a.k.setBackground(bdImage.getAsBitmapDrawable());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z08 a;

        public d(z08 z08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z08Var;
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
                    z08.n("c15354", this.a.g.getTitle(), this.a.g.d(), ListUtils.getCount(this.a.g.getDataList()), str);
                }
                if (this.a.g != null && !di.isEmpty(this.a.g.e())) {
                    UrlManager.getInstance().dealOneLink(this.a.g.e());
                }
            }
        }
    }

    public z08(TbPageContext<?> tbPageContext) {
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
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d085c, (ViewGroup) null);
            this.c = inflate;
            this.d = (BdRecyclerView) inflate.findViewById(R.id.obfuscated_res_0x7f090fc0);
            this.e = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f090f0c);
            this.f = (EMTextView) this.c.findViewById(R.id.right_btn);
            this.l = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090f26);
            this.j = this.c.findViewById(R.id.line_view);
            this.m = (ImageView) this.c.findViewById(R.id.arrow_img);
            this.k = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090efd);
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
        p08 p08Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048579, this, z) != null) || (p08Var = this.g) == null) {
            return;
        }
        if (!z && p08Var.c() != null && !TextUtils.isEmpty(epa.g(this.g.c()))) {
            BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResource(epa.g(this.g.c()), 45, this.n, this.i);
            if (bdImage != null) {
                this.k.setBackground(bdImage.getAsBitmapDrawable());
                return;
            }
            return;
        }
        this.k.setBackground(WebPManager.getMaskDrawable((int) R.drawable.bg_home_quanceng_card, WebPManager.ResourceStateType.NORMAL));
    }

    public void l(p08 p08Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, p08Var) != null) || p08Var == null) {
            return;
        }
        this.g = p08Var;
        this.e.setText(p08Var.getTitle());
        this.f.setText(p08Var.f());
        this.b.p(p08Var.getDataList(), p08Var.g());
        this.b.notifyDataSetChanged();
        k(false);
        n("c15353", this.g.getTitle(), this.g.d(), ListUtils.getCount(this.g.getDataList()), "");
    }

    @Override // com.baidu.tieba.ux
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, tbPageContext, i) == null) && this.h != i) {
            EMManager.from(this.e).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0105);
            EMManager.from(this.f).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0109);
            EMManager.from(this.j).setBackGroundColor(R.color.CAM_X0604);
            this.l.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_mask_qunceng_hot_head, WebPManager.ResourceStateType.NORMAL));
            k(false);
            EMManager.from(this.c).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            WebPManager.setPureDrawable(this.m, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL);
            HotCardListAdapter hotCardListAdapter = this.b;
            if (hotCardListAdapter != null) {
                hotCardListAdapter.notifyDataSetChanged();
            }
            this.h = i;
        }
    }
}
