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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
import d.a.q0.h2.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f19481e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19482f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19483g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f19484h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f19485i;
    public Context j;
    public BdRecyclerView k;
    public LinearLayout l;
    public int m;
    public int n;
    public int o;
    public int p;
    public List<d.a.q0.a0.e0.c> q;
    public int r;
    public int s;
    public boolean t;
    public PbFragment u;
    public AbsVideoPbFragment v;
    public b2 w;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbLinkGoodsRootView f19486e;

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
            this.f19486e = pbLinkGoodsRootView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f19486e.m();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SingleLinkCardView f19487a;

        /* renamed from: b  reason: collision with root package name */
        public View f19488b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbLinkGoodsRootView f19489c;

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
            this.f19489c = pbLinkGoodsRootView;
            this.f19488b = view.findViewById(R.id.mask_view);
            this.f19487a = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbLinkGoodsRootView f19490a;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19491e;

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
                this.f19491e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f19491e.f19490a.m();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f19492e;

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
                this.f19492e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f19492e.f19490a.m();
                }
            }
        }

        /* renamed from: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView$c$c  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC0232c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f19493e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f19494f;

            public View$OnClickListenerC0232c(c cVar, int i2) {
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
                this.f19494f = cVar;
                this.f19493e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    PbLinkGoodsRootView pbLinkGoodsRootView = this.f19494f.f19490a;
                    pbLinkGoodsRootView.p((d.a.q0.a0.e0.c) pbLinkGoodsRootView.q.get(this.f19493e));
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
            this.f19490a = pbLinkGoodsRootView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f19490a.r : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i2) == null) && (viewHolder instanceof b)) {
                b bVar = (b) viewHolder;
                if (i2 >= this.f19490a.q.size() || this.f19490a.q.get(i2) == null) {
                    return;
                }
                if (this.f19490a.u == null || this.f19490a.u.L4() || i2 != 2 || this.f19490a.q.size() <= 3) {
                    if (this.f19490a.v == null || this.f19490a.v.g3() || i2 != 2 || this.f19490a.q.size() <= 3) {
                        bVar.f19488b.setVisibility(8);
                    } else {
                        bVar.f19488b.setOnClickListener(new b(this));
                        bVar.f19488b.setVisibility(0);
                        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).into(bVar.f19488b);
                    }
                } else {
                    bVar.f19488b.setOnClickListener(new a(this));
                    bVar.f19488b.setVisibility(0);
                    TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).into(bVar.f19488b);
                }
                bVar.f19487a.a((d.a.q0.a0.e0.c) this.f19490a.q.get(i2));
                bVar.f19487a.setOnClickListener(new View$OnClickListenerC0232c(this, i2));
                if (!(this.f19490a.q.get(i2) instanceof PbLinkData) || this.f19490a.q.get(i2) == null) {
                    if (this.f19490a.q.get(i2) instanceof PbGoodsData) {
                        this.f19490a.o("c13961", 2);
                    }
                } else if (((PbLinkData) this.f19490a.q.get(i2)).urlType == 2) {
                    this.f19490a.o("c13961", 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new b(this.f19490a, LayoutInflater.from(this.f19490a.j).inflate(R.layout.pb_link_goods_item_layout, (ViewGroup) null)) : (RecyclerView.ViewHolder) invokeLI.objValue;
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

    public void i(e eVar, List<d.a.q0.a0.e0.c> list, String str, PbFragment pbFragment, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, list, str, pbFragment, Boolean.valueOf(z)}) == null) {
            this.u = pbFragment;
            k(eVar, list, str, z);
            PbFragment pbFragment2 = this.u;
            if (pbFragment2 != null) {
                l(pbFragment2.L4());
            }
        }
    }

    public void j(e eVar, List<d.a.q0.a0.e0.c> list, String str, AbsVideoPbFragment absVideoPbFragment, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, list, str, absVideoPbFragment, Boolean.valueOf(z)}) == null) {
            this.v = absVideoPbFragment;
            k(eVar, list, str, z);
            AbsVideoPbFragment absVideoPbFragment2 = this.v;
            if (absVideoPbFragment2 != null) {
                l(absVideoPbFragment2.g3());
            }
        }
    }

    public void k(e eVar, List<d.a.q0.a0.e0.c> list, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, list, str, Boolean.valueOf(z)}) == null) {
            this.q = list;
            b2 N = eVar.N();
            this.w = N;
            N.s3(eVar.o());
            this.w.o3(Long.valueOf(eVar.n()).longValue());
            this.t = z;
            this.r = list.size();
            if (list.size() < 4) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
            }
            if (this.t) {
                this.t = z;
                this.f19485i.setFrom(1);
                this.f19485i.a(this.w);
                this.f19485i.setVisibility(0);
                return;
            }
            this.f19485i.setVisibility(8);
        }
    }

    public final void l(boolean z) {
        Resources resources;
        int i2;
        Resources resources2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.r = this.q.size();
                TextView textView = this.f19482f;
                if (this.t) {
                    resources2 = getResources();
                    i3 = R.string.pb_first_goods_more_close;
                } else {
                    resources2 = getResources();
                    i3 = R.string.pb_first_link_more_close;
                }
                textView.setText(resources2.getString(i3));
                this.s = R.drawable.icon_pure_fold12_svg;
            } else {
                if (this.r > 3) {
                    this.r = 3;
                }
                TextView textView2 = this.f19482f;
                if (this.t) {
                    resources = getResources();
                    i2 = R.string.pb_first_goods_more_open;
                } else {
                    resources = getResources();
                    i2 = R.string.pb_first_link_more_open;
                }
                textView2.setText(resources.getString(i2));
                this.s = R.drawable.icon_pure_unfold12_svg;
            }
            this.f19481e.notifyDataSetChanged();
            setMarginTop(z);
            SkinManager.setViewTextColor(this.f19482f, R.color.CAM_X0107);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f19483g, this.s, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbFragment pbFragment = this.u;
            if (pbFragment != null) {
                if (pbFragment.L4()) {
                    this.u.Z5(false);
                    l(false);
                    return;
                }
                this.u.Z5(true);
                l(true);
                n();
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.v;
            if (absVideoPbFragment != null) {
                if (absVideoPbFragment.g3()) {
                    this.v.G4(false);
                    l(false);
                    return;
                }
                this.v.G4(true);
                l(true);
                n();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.w != null && this.t) {
            TiebaStatic.log(new StatisticItem("c13968").param("fid", this.w.R()).param("fname", this.w.X()).param("tid", this.w.o1()));
        }
    }

    public final void o(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) || this.w == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(str).param("obj_type", i2).param("fid", this.w.R()).param("fname", this.w.X()).param("tid", this.w.o1()));
    }

    public final void p(d.a.q0.a0.e0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            if (cVar instanceof PbLinkData) {
                PbLinkData pbLinkData = (PbLinkData) cVar;
                if (pbLinkData == null) {
                    return;
                }
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.j;
                if (pbLinkData.urlType == 1) {
                    UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<?> pageContext = tbPageContextSupport.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    o("c13962", 1);
                }
            } else if (cVar instanceof PbGoodsData) {
                TbPageContextSupport tbPageContextSupport2 = (TbPageContextSupport) this.j;
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
                            this.j.startActivity(intent);
                        } else if (!TextUtils.isEmpty(pbGoodsData.goodsUrlH5)) {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<?> pageContext2 = tbPageContextSupport2.getPageContext();
                            urlManager2.dealOneLink(pageContext2, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    UrlManager urlManager3 = UrlManager.getInstance();
                    TbPageContext<?> pageContext3 = tbPageContextSupport2.getPageContext();
                    urlManager3.dealOneLink(pageContext3, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + k.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                o("c13962", 2);
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
        this.j = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.k = bdRecyclerView;
        bdRecyclerView.setNestedScrollingEnabled(false);
        this.l = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.f19482f = (TextView) findViewById(R.id.tv_post);
        this.f19484h = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.f19483g = (ImageView) findViewById(R.id.iv_arrow);
        this.f19485i = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.m = l.g(this.j, R.dimen.tbds14);
        this.n = l.g(this.j, R.dimen.tbds44);
        this.o = l.g(this.j, R.dimen.tbds36);
        this.p = l.g(this.j, R.dimen.tbds22);
        this.f19481e = new c(this);
        this.k.setLayoutManager(new LinearLayoutManager(this.j));
        this.k.setAdapter(this.f19481e);
        this.f19484h.setOnClickListener(new a(this));
    }
}
