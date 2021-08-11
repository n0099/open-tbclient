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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.s.q.c2;
import c.a.p0.i2.h.e;
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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class PbLinkGoodsRootView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public c f54832e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54833f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54834g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f54835h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadForumEnterGoodsButton f54836i;

    /* renamed from: j  reason: collision with root package name */
    public Context f54837j;
    public BdRecyclerView k;
    public LinearLayout l;
    public int m;
    public int n;
    public int o;
    public int p;
    public List<c.a.p0.a0.d0.c> q;
    public int r;
    public int s;
    public boolean t;
    public PbFragment u;
    public AbsVideoPbFragment v;
    public c2 w;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbLinkGoodsRootView f54838e;

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
            this.f54838e = pbLinkGoodsRootView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54838e.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SingleLinkCardView f54839a;

        /* renamed from: b  reason: collision with root package name */
        public View f54840b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbLinkGoodsRootView f54841c;

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
            this.f54841c = pbLinkGoodsRootView;
            this.f54840b = view.findViewById(R.id.mask_view);
            this.f54839a = (SingleLinkCardView) view.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbLinkGoodsRootView f54842a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f54843e;

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
                this.f54843e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f54843e.f54842a.j();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f54844e;

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
                this.f54844e = cVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f54844e.f54842a.j();
                }
            }
        }

        /* renamed from: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class View$OnClickListenerC1785c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f54845e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f54846f;

            public View$OnClickListenerC1785c(c cVar, int i2) {
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
                this.f54846f = cVar;
                this.f54845e = i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    PbLinkGoodsRootView pbLinkGoodsRootView = this.f54846f.f54842a;
                    pbLinkGoodsRootView.m((c.a.p0.a0.d0.c) pbLinkGoodsRootView.q.get(this.f54845e));
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
            this.f54842a = pbLinkGoodsRootView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54842a.r : invokeV.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewHolder, i2) == null) && (viewHolder instanceof b)) {
                b bVar = (b) viewHolder;
                if (i2 >= this.f54842a.q.size() || this.f54842a.q.get(i2) == null) {
                    return;
                }
                if (this.f54842a.u == null || this.f54842a.u.getLinkGoodsMoreShow() || i2 != 2 || this.f54842a.q.size() <= 3) {
                    if (this.f54842a.v == null || this.f54842a.v.getLinkGoodsMoreShow() || i2 != 2 || this.f54842a.q.size() <= 3) {
                        bVar.f54840b.setVisibility(8);
                    } else {
                        bVar.f54840b.setOnClickListener(new b(this));
                        bVar.f54840b.setVisibility(0);
                        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).into(bVar.f54840b);
                    }
                } else {
                    bVar.f54840b.setOnClickListener(new a(this));
                    bVar.f54840b.setVisibility(0);
                    TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).into(bVar.f54840b);
                }
                bVar.f54839a.bindData((c.a.p0.a0.d0.c) this.f54842a.q.get(i2));
                bVar.f54839a.setOnClickListener(new View$OnClickListenerC1785c(this, i2));
                if (!(this.f54842a.q.get(i2) instanceof PbLinkData) || this.f54842a.q.get(i2) == null) {
                    if (this.f54842a.q.get(i2) instanceof PbGoodsData) {
                        this.f54842a.l("c13961", 2);
                    }
                } else if (((PbLinkData) this.f54842a.q.get(i2)).urlType == 2) {
                    this.f54842a.l("c13961", 1);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) ? new b(this.f54842a, LayoutInflater.from(this.f54842a.f54837j).inflate(R.layout.pb_link_goods_item_layout, (ViewGroup) null)) : (RecyclerView.ViewHolder) invokeLI.objValue;
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

    public void bindData(e eVar, List<c.a.p0.a0.d0.c> list, String str, PbFragment pbFragment, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, list, str, pbFragment, Boolean.valueOf(z)}) == null) {
            this.u = pbFragment;
            bindData(eVar, list, str, z);
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
                TextView textView = this.f54833f;
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
                TextView textView2 = this.f54833f;
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
            this.f54832e.notifyDataSetChanged();
            setMarginTop(z);
            SkinManager.setViewTextColor(this.f54833f, R.color.CAM_X0107);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54834g, this.s, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
            TiebaStatic.log(new StatisticItem("c13968").param("fid", this.w.T()).param("fname", this.w.Z()).param("tid", this.w.q1()));
        }
    }

    public final void l(String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, str, i2) == null) || this.w == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(str).param("obj_type", i2).param("fid", this.w.T()).param("fname", this.w.Z()).param("tid", this.w.q1()));
    }

    public final void m(c.a.p0.a0.d0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) {
            if (cVar instanceof PbLinkData) {
                PbLinkData pbLinkData = (PbLinkData) cVar;
                if (pbLinkData == null) {
                    return;
                }
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.f54837j;
                if (pbLinkData.urlType == 1) {
                    UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<?> pageContext = tbPageContextSupport.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + k.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    l("c13962", 1);
                }
            } else if (cVar instanceof PbGoodsData) {
                TbPageContextSupport tbPageContextSupport2 = (TbPageContextSupport) this.f54837j;
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
                            this.f54837j.startActivity(intent);
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
        this.f54837j = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.k = bdRecyclerView;
        bdRecyclerView.setNestedScrollingEnabled(false);
        this.l = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.f54833f = (TextView) findViewById(R.id.tv_post);
        this.f54835h = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.f54834g = (ImageView) findViewById(R.id.iv_arrow);
        this.f54836i = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.m = l.g(this.f54837j, R.dimen.tbds14);
        this.n = l.g(this.f54837j, R.dimen.tbds44);
        this.o = l.g(this.f54837j, R.dimen.tbds36);
        this.p = l.g(this.f54837j, R.dimen.tbds22);
        this.f54832e = new c(this);
        this.k.setLayoutManager(new LinearLayoutManager(this.f54837j));
        this.k.setAdapter(this.f54832e);
        this.f54835h.setOnClickListener(new a(this));
    }

    public void bindData(e eVar, List<c.a.p0.a0.d0.c> list, String str, AbsVideoPbFragment absVideoPbFragment, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, list, str, absVideoPbFragment, Boolean.valueOf(z)}) == null) {
            this.v = absVideoPbFragment;
            bindData(eVar, list, str, z);
            AbsVideoPbFragment absVideoPbFragment2 = this.v;
            if (absVideoPbFragment2 != null) {
                i(absVideoPbFragment2.getLinkGoodsMoreShow());
            }
        }
    }

    public void bindData(e eVar, List<c.a.p0.a0.d0.c> list, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{eVar, list, str, Boolean.valueOf(z)}) == null) {
            this.q = list;
            c2 O = eVar.O();
            this.w = O;
            O.B3(eVar.o());
            this.w.x3(Long.valueOf(eVar.n()).longValue());
            this.t = z;
            this.r = list.size();
            if (list.size() < 4) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
            }
            if (this.t) {
                this.t = z;
                this.f54836i.setFrom(1);
                this.f54836i.bindData(this.w);
                this.f54836i.setVisibility(0);
                return;
            }
            this.f54836i.setVisibility(8);
        }
    }
}
