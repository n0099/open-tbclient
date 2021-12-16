package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.m;
import c.a.r0.s.r.d2;
import c.a.s0.s2.f;
import c.a.s0.s2.g;
import c.a.s0.s2.h;
import c.a.s0.s2.i;
import c.a.s0.s2.j;
import c.a.s0.s2.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes12.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f48144e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f48145f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f48146g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f48147h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f48148i;

    /* renamed from: j  reason: collision with root package name */
    public Context f48149j;

    /* renamed from: k  reason: collision with root package name */
    public BdRecyclerView f48150k;
    public LinearLayout l;
    public int m;
    public int n;
    public int o;
    public int p;
    public List<c.a.s0.g0.f0.c> q;
    public int r;
    public int s;
    public boolean t;
    public PbFragment u;
    public AbsVideoPbFragment v;
    public d2 w;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbLinkGoodsRootView f48151e;

        public a(PbLinkGoodsRootView pbLinkGoodsRootView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLinkGoodsRootView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48151e = pbLinkGoodsRootView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48151e.j();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SingleLinkCardView a;

        /* renamed from: b  reason: collision with root package name */
        public View f48152b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbLinkGoodsRootView f48153c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbLinkGoodsRootView pbLinkGoodsRootView, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLinkGoodsRootView, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48153c = pbLinkGoodsRootView;
            this.f48152b = view.findViewById(i.mask_view);
            this.a = (SingleLinkCardView) view.findViewById(i.pb_item_single_link_card);
        }
    }

    /* loaded from: classes12.dex */
    public class c extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLinkGoodsRootView a;

        /* loaded from: classes12.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f48154e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48154e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f48154e.a.j();
                }
            }
        }

        /* loaded from: classes12.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f48155e;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48155e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f48155e.a.j();
                }
            }
        }

        /* renamed from: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView$c$c  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class View$OnClickListenerC1924c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f48156e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f48157f;

            public View$OnClickListenerC1924c(c cVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48157f = cVar;
                this.f48156e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    PbLinkGoodsRootView pbLinkGoodsRootView = this.f48157f.a;
                    pbLinkGoodsRootView.m((c.a.s0.g0.f0.c) pbLinkGoodsRootView.q.get(this.f48156e));
                }
            }
        }

        public c(PbLinkGoodsRootView pbLinkGoodsRootView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLinkGoodsRootView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbLinkGoodsRootView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.r : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i2) == null) && (viewHolder instanceof b)) {
                b bVar = (b) viewHolder;
                if (i2 >= this.a.q.size() || this.a.q.get(i2) == null) {
                    return;
                }
                if (this.a.u == null || this.a.u.getLinkGoodsMoreShow() || i2 != 2 || this.a.q.size() <= 3) {
                    if (this.a.v == null || this.a.v.getLinkGoodsMoreShow() || i2 != 2 || this.a.q.size() <= 3) {
                        bVar.f48152b.setVisibility(8);
                    } else {
                        bVar.f48152b.setOnClickListener(new b(this));
                        bVar.f48152b.setVisibility(0);
                        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(f.cp_bg_line_d_alpha70, f.CAM_X0201).into(bVar.f48152b);
                    }
                } else {
                    bVar.f48152b.setOnClickListener(new a(this));
                    bVar.f48152b.setVisibility(0);
                    TBSelector.makeDrawableSelector().setShape(0).gradientLinear(f.cp_bg_line_d_alpha70, f.CAM_X0201).into(bVar.f48152b);
                }
                bVar.a.bindData((c.a.s0.g0.f0.c) this.a.q.get(i2));
                bVar.a.setOnClickListener(new View$OnClickListenerC1924c(this, i2));
                if (!(this.a.q.get(i2) instanceof PbLinkData) || this.a.q.get(i2) == null) {
                    if (this.a.q.get(i2) instanceof PbGoodsData) {
                        this.a.l("c13961", 2);
                    }
                } else if (((PbLinkData) this.a.q.get(i2)).urlType == 2) {
                    this.a.l("c13961", 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new b(this.a, LayoutInflater.from(this.a.f48149j).inflate(j.pb_link_goods_item_layout, (ViewGroup) null)) : (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbLinkGoodsRootView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void bindData(c.a.s0.s2.r.f fVar, List<c.a.s0.g0.f0.c> list, String str, PbFragment pbFragment, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{fVar, list, str, pbFragment, Boolean.valueOf(z)}) == null) {
            this.u = pbFragment;
            bindData(fVar, list, str, z);
            PbFragment pbFragment2 = this.u;
            if (pbFragment2 != null) {
                i(pbFragment2.getLinkGoodsMoreShow());
            }
        }
    }

    public final void i(boolean z) {
        Resources resources;
        int i2;
        Resources resources2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.r = this.q.size();
                TextView textView = this.f48145f;
                if (this.t) {
                    resources2 = getResources();
                    i3 = l.pb_first_goods_more_close;
                } else {
                    resources2 = getResources();
                    i3 = l.pb_first_link_more_close;
                }
                textView.setText(resources2.getString(i3));
                this.s = h.icon_pure_fold12_svg;
            } else {
                if (this.r > 3) {
                    this.r = 3;
                }
                TextView textView2 = this.f48145f;
                if (this.t) {
                    resources = getResources();
                    i2 = l.pb_first_goods_more_open;
                } else {
                    resources = getResources();
                    i2 = l.pb_first_link_more_open;
                }
                textView2.setText(resources.getString(i2));
                this.s = h.icon_pure_unfold12_svg;
            }
            this.f48144e.notifyDataSetChanged();
            setMarginTop(z);
            SkinManager.setViewTextColor(this.f48145f, f.CAM_X0107);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f48146g, this.s, f.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbFragment pbFragment = this.u;
            if (pbFragment != null) {
                if (pbFragment.getLinkGoodsMoreShow()) {
                    this.u.setShowLinkGoodsMore(false);
                    i(false);
                    return;
                }
                this.u.setShowLinkGoodsMore(true);
                i(true);
                k();
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.v;
            if (absVideoPbFragment != null) {
                if (absVideoPbFragment.getLinkGoodsMoreShow()) {
                    this.v.setShowLinkGoodsMore(false);
                    i(false);
                    return;
                }
                this.v.setShowLinkGoodsMore(true);
                i(true);
                k();
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.w != null && this.t) {
            TiebaStatic.log(new StatisticItem("c13968").param("fid", this.w.U()).param("fname", this.w.a0()).param("tid", this.w.v1()));
        }
    }

    public final void l(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) || this.w == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(str).param("obj_type", i2).param("fid", this.w.U()).param("fname", this.w.a0()).param("tid", this.w.v1()));
    }

    public final void m(c.a.s0.g0.f0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            if (cVar instanceof PbLinkData) {
                PbLinkData pbLinkData = (PbLinkData) cVar;
                if (pbLinkData == null) {
                    return;
                }
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.f48149j;
                if (pbLinkData.urlType == 1) {
                    UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<?> pageContext = tbPageContextSupport.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + c.a.d.f.p.l.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    l("c13962", 1);
                }
            } else if (cVar instanceof PbGoodsData) {
                TbPageContextSupport tbPageContextSupport2 = (TbPageContextSupport) this.f48149j;
                PbGoodsData pbGoodsData = (PbGoodsData) cVar;
                if (pbGoodsData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                    if (pbGoodsData.linkUrl.startsWith("tiebaclient://")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, pbGoodsData.linkUrl));
                    } else {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(pbGoodsData.linkUrl));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                            this.f48149j.startActivity(intent);
                        } else if (!TextUtils.isEmpty(pbGoodsData.goodsUrlH5)) {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<?> pageContext2 = tbPageContextSupport2.getPageContext();
                            urlManager2.dealOneLink(pageContext2, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + c.a.d.f.p.l.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    UrlManager urlManager3 = UrlManager.getInstance();
                    TbPageContext<?> pageContext3 = tbPageContextSupport2.getPageContext();
                    urlManager3.dealOneLink(pageContext3, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + c.a.d.f.p.l.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                l("c13962", 2);
            }
        }
    }

    public void setMarginTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.l.setPadding(0, this.o, 0, this.p);
            } else {
                this.l.setPadding(0, this.m, 0, this.n);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbLinkGoodsRootView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLinkGoodsRootView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.q = new ArrayList();
        this.r = 3;
        this.t = false;
        this.f48149j = context;
        LayoutInflater.from(context).inflate(j.pb_link_goods_layout, this);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(i.pb_link_goods_rv);
        this.f48150k = bdRecyclerView;
        bdRecyclerView.setNestedScrollingEnabled(false);
        this.l = (LinearLayout) findViewById(i.pb_more_post_rl);
        this.f48145f = (TextView) findViewById(i.tv_post);
        this.f48147h = (RelativeLayout) findViewById(i.rl_more_post);
        this.f48146g = (ImageView) findViewById(i.iv_arrow);
        this.f48148i = (ThreadForumEnterGoodsButton) findViewById(i.pb_tip_enter_button);
        this.m = m.f(this.f48149j, g.tbds14);
        this.n = m.f(this.f48149j, g.tbds44);
        this.o = m.f(this.f48149j, g.tbds36);
        this.p = m.f(this.f48149j, g.tbds22);
        this.f48144e = new c(this);
        this.f48150k.setLayoutManager(new LinearLayoutManager(this.f48149j));
        this.f48150k.setAdapter(this.f48144e);
        this.f48147h.setOnClickListener(new a(this));
    }

    public void bindData(c.a.s0.s2.r.f fVar, List<c.a.s0.g0.f0.c> list, String str, AbsVideoPbFragment absVideoPbFragment, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{fVar, list, str, absVideoPbFragment, Boolean.valueOf(z)}) == null) {
            this.v = absVideoPbFragment;
            bindData(fVar, list, str, z);
            AbsVideoPbFragment absVideoPbFragment2 = this.v;
            if (absVideoPbFragment2 != null) {
                i(absVideoPbFragment2.getLinkGoodsMoreShow());
            }
        }
    }

    public void bindData(c.a.s0.s2.r.f fVar, List<c.a.s0.g0.f0.c> list, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{fVar, list, str, Boolean.valueOf(z)}) == null) {
            this.q = list;
            d2 O = fVar.O();
            this.w = O;
            O.M3(fVar.n());
            this.w.I3(Long.valueOf(fVar.m()).longValue());
            this.t = z;
            this.r = list.size();
            if (list.size() < 4) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
            }
            if (this.t) {
                this.t = z;
                this.f48148i.setFrom(1);
                this.f48148i.bindData(this.w);
                this.f48148i.setVisibility(0);
                return;
            }
            this.f48148i.setVisibility(8);
        }
    }
}
