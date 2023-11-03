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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PbGoodsData;
import com.baidu.tbadk.core.data.PbLinkData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GroupChatEntranceStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.SingleLinkCardView;
import com.baidu.tbadk.core.view.ThreadForumEnterGoodsButton;
import com.baidu.tbadk.core.view.commonMountCard.TbMountCardLinkLayout;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tieba.R;
import com.baidu.tieba.ds9;
import com.baidu.tieba.gm6;
import com.baidu.tieba.qd;
import com.baidu.tieba.x55;
import com.baidu.tieba.yr4;
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
    public d a;
    public TextView b;
    public ImageView c;
    public RelativeLayout d;
    public ThreadForumEnterGoodsButton e;
    public Context f;
    public BdRecyclerView g;
    public LinearLayout h;
    public int i;
    public int j;
    public int k;
    public int l;
    public List<gm6> m;
    public int n;
    public int o;
    public boolean p;
    public PbFragment q;
    public ThreadData r;

    /* loaded from: classes7.dex */
    public class d extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLinkGoodsRootView a;

        /* loaded from: classes7.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ d b;

            public a(d dVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    PbLinkGoodsRootView pbLinkGoodsRootView = this.b.a;
                    pbLinkGoodsRootView.o((gm6) pbLinkGoodsRootView.m.get(this.a));
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements x55 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ d b;

            public b(d dVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = i;
            }

            @Override // com.baidu.tieba.x55
            public void a(String str) {
                CardLinkInfoData cardLinkInfoData;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    if (("1".equals(str) || "3".equals(str) || "2".equals(str)) && this.b.a.m != null && this.a < this.b.a.m.size() && (this.b.a.m.get(this.a) instanceof CardLinkInfoData) && (cardLinkInfoData = (CardLinkInfoData) this.b.a.m.get(this.a)) != null) {
                        UrlSchemaHelper.goToNewPageByScheme(cardLinkInfoData.getUrl());
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public c(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                    return;
                }
                this.a.a.k();
            }
        }

        public d(PbLinkGoodsRootView pbLinkGoodsRootView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLinkGoodsRootView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbLinkGoodsRootView;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                gm6 gm6Var = (gm6) this.a.m.get(i);
                if (gm6Var instanceof CardLinkInfoData) {
                    return 3;
                }
                if (gm6Var instanceof PbGoodsData) {
                    return 2;
                }
                return 1;
            }
            return invokeI.intValue;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return invokeV.intValue;
            }
            return this.a.n;
        }

        public final void l(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) != null) || view2 == null) {
                return;
            }
            if (this.a.m != null && this.a.q != null && !this.a.q.O6() && i == 2 && this.a.m.size() > 3) {
                view2.setOnClickListener(new c(this));
                view2.setVisibility(0);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).into(view2);
                return;
            }
            view2.setVisibility(8);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, viewHolder, i) == null) {
                View view2 = null;
                if (viewHolder instanceof b) {
                    b bVar = (b) viewHolder;
                    if (i < this.a.m.size() && this.a.m.get(i) != null) {
                        View view3 = bVar.b;
                        bVar.a.a((gm6) this.a.m.get(i));
                        bVar.a.setItemOnClickListener(new a(this, i));
                        if ((this.a.m.get(i) instanceof PbLinkData) && this.a.m.get(i) != null) {
                            if (((PbLinkData) this.a.m.get(i)).urlType == 2) {
                                this.a.m("c13961", 1);
                            }
                        } else if (this.a.m.get(i) instanceof PbGoodsData) {
                            this.a.m("c13961", 2);
                        }
                        view2 = view3;
                    }
                } else if ((viewHolder instanceof c) && this.a.m != null && i < this.a.m.size() && (this.a.m.get(i) instanceof CardLinkInfoData)) {
                    c cVar = (c) viewHolder;
                    view2 = cVar.b;
                    TbMountCardLinkLayout tbMountCardLinkLayout = cVar.a;
                    if (tbMountCardLinkLayout != null) {
                        tbMountCardLinkLayout.setData((CardLinkInfoData) this.a.m.get(i));
                        tbMountCardLinkLayout.setClickListener(new b(this, i));
                    }
                }
                l(view2, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
                if (i == 3) {
                    return new c(this.a, LayoutInflater.from(this.a.f).inflate(R.layout.pb_link_mount_card_item_layout, (ViewGroup) null));
                }
                return new b(this.a, LayoutInflater.from(this.a.f).inflate(R.layout.pb_link_goods_item_layout, (ViewGroup) null));
            }
            return (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLinkGoodsRootView a;

        public a(PbLinkGoodsRootView pbLinkGoodsRootView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLinkGoodsRootView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbLinkGoodsRootView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.k();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SingleLinkCardView a;
        public View b;
        public final /* synthetic */ PbLinkGoodsRootView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbLinkGoodsRootView pbLinkGoodsRootView, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLinkGoodsRootView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbLinkGoodsRootView;
            this.b = view2.findViewById(R.id.mask_view);
            this.a = (SingleLinkCardView) view2.findViewById(R.id.pb_item_single_link_card);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbMountCardLinkLayout a;
        public View b;
        public final /* synthetic */ PbLinkGoodsRootView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbLinkGoodsRootView pbLinkGoodsRootView, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbLinkGoodsRootView, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = pbLinkGoodsRootView;
            this.b = view2.findViewById(R.id.mask_view);
            this.a = (TbMountCardLinkLayout) view2.findViewById(R.id.pb_item_link_mount_card);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_GROUP_CHAT_ENTRANCE_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_locate", 5).param("fid", GroupChatEntranceStatisticUtils.getForumIdByUrl(str)).param("room_id", GroupChatEntranceStatisticUtils.getRoomIdByUrl(str)));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbLinkGoodsRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.m = new ArrayList();
        this.n = 3;
        this.p = false;
        this.f = context;
        LayoutInflater.from(context).inflate(R.layout.pb_link_goods_layout, this);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.pb_link_goods_rv);
        this.g = bdRecyclerView;
        bdRecyclerView.setNestedScrollingEnabled(false);
        this.h = (LinearLayout) findViewById(R.id.pb_more_post_rl);
        this.b = (TextView) findViewById(R.id.tv_post);
        this.d = (RelativeLayout) findViewById(R.id.rl_more_post);
        this.c = (ImageView) findViewById(R.id.iv_arrow);
        this.e = (ThreadForumEnterGoodsButton) findViewById(R.id.pb_tip_enter_button);
        this.i = BdUtilHelper.getDimens(this.f, R.dimen.tbds14);
        this.j = BdUtilHelper.getDimens(this.f, R.dimen.tbds44);
        this.k = BdUtilHelper.getDimens(this.f, R.dimen.tbds36);
        this.l = BdUtilHelper.getDimens(this.f, R.dimen.tbds22);
        this.a = new d(this);
        this.g.setLayoutManager(new LinearLayoutManager(this.f));
        this.g.setAdapter(this.a);
        this.d.setOnClickListener(new a(this));
    }

    public void setMarginTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.h.setPadding(0, this.k, 0, this.l);
            } else {
                this.h.setPadding(0, this.i, 0, this.j);
            }
        }
    }

    public void h(ds9 ds9Var, List<gm6> list, String str, PbFragment pbFragment, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{ds9Var, list, str, pbFragment, Boolean.valueOf(z)}) == null) {
            this.q = pbFragment;
            i(ds9Var, list, str, z);
            PbFragment pbFragment2 = this.q;
            if (pbFragment2 != null) {
                j(pbFragment2.O6());
            }
        }
    }

    public void i(ds9 ds9Var, List<gm6> list, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ds9Var, list, str, Boolean.valueOf(z)}) == null) {
            this.m = list;
            ThreadData O = ds9Var.O();
            this.r = O;
            O.setForum_name(ds9Var.m());
            this.r.setFid(Long.valueOf(ds9Var.l()).longValue());
            this.p = z;
            this.n = list.size();
            if (list.size() < 4) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
            }
            if (this.p) {
                this.p = z;
                this.e.setFrom(1);
                this.e.a(this.r);
                this.e.setVisibility(0);
                return;
            }
            this.e.setVisibility(8);
        }
    }

    public final void j(boolean z) {
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.n = this.m.size();
                TextView textView = this.b;
                if (this.p) {
                    resources2 = getResources();
                    i2 = R.string.obfuscated_res_0x7f0f100e;
                } else {
                    resources2 = getResources();
                    i2 = R.string.obfuscated_res_0x7f0f1010;
                }
                textView.setText(resources2.getString(i2));
                this.o = R.drawable.icon_pure_fold12_svg;
            } else {
                if (this.n > 3) {
                    this.n = 3;
                }
                TextView textView2 = this.b;
                if (this.p) {
                    resources = getResources();
                    i = R.string.obfuscated_res_0x7f0f100f;
                } else {
                    resources = getResources();
                    i = R.string.obfuscated_res_0x7f0f1011;
                }
                textView2.setText(resources.getString(i));
                this.o = R.drawable.icon_pure_unfold12_svg;
            }
            this.a.notifyDataSetChanged();
            setMarginTop(z);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0107);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, this.o, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public final void k() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (pbFragment = this.q) != null) {
            if (pbFragment.O6()) {
                this.q.A8(false);
                j(false);
                return;
            }
            this.q.A8(true);
            j(true);
            l();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.r != null && this.p) {
            TiebaStatic.log(new StatisticItem("c13968").param("fid", this.r.getFid()).param("fname", this.r.getForum_name()).param("tid", this.r.getTid()));
        }
    }

    public final void m(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) && this.r != null) {
            TiebaStatic.log(new StatisticItem(str).param("obj_type", i).param("fid", this.r.getFid()).param("fname", this.r.getForum_name()).param("tid", this.r.getTid()));
        }
    }

    public final void o(gm6 gm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gm6Var) == null) {
            if (gm6Var instanceof PbLinkData) {
                PbLinkData pbLinkData = (PbLinkData) gm6Var;
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.f;
                int i = pbLinkData.urlType;
                if (i != 1 && i != 5) {
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<?> pageContext = tbPageContextSupport.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{yr4.a + qd.getUrlEncode(pbLinkData.linkUrl)});
                } else {
                    UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                }
                if (pbLinkData.urlType == 2) {
                    m("c13962", 1);
                }
                if (pbLinkData.urlType == 5) {
                    n(pbLinkData.linkUrl);
                }
            } else if (gm6Var instanceof PbGoodsData) {
                TbPageContextSupport tbPageContextSupport2 = (TbPageContextSupport) this.f;
                PbGoodsData pbGoodsData = (PbGoodsData) gm6Var;
                if (pbGoodsData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(pbGoodsData.linkUrl)) {
                    if (pbGoodsData.linkUrl.startsWith("tiebaclient://")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921361, pbGoodsData.linkUrl));
                    } else {
                        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(pbGoodsData.linkUrl));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                            this.f.startActivity(intent);
                        } else if (UrlSchemaHelper.checkBaiduboxappSwan(pbGoodsData.linkUrl)) {
                            UrlManager.getInstance().dealOneLink(tbPageContextSupport2.getPageContext(), new String[]{UrlSchemaHelper.replaceSwanBaiduboxapp2Tiebaclient(pbGoodsData.linkUrl)});
                        } else if (!TextUtils.isEmpty(pbGoodsData.goodsUrlH5)) {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<?> pageContext2 = tbPageContextSupport2.getPageContext();
                            urlManager2.dealOneLink(pageContext2, new String[]{yr4.a + qd.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    UrlManager urlManager3 = UrlManager.getInstance();
                    TbPageContext<?> pageContext3 = tbPageContextSupport2.getPageContext();
                    urlManager3.dealOneLink(pageContext3, new String[]{yr4.a + qd.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                m("c13962", 2);
            }
        }
    }
}
