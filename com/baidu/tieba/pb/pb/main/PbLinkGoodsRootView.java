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
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.ox7;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.rz4;
import com.baidu.tieba.t46;
import com.baidu.tieba.wp4;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
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
    public List<t46> m;
    public int n;
    public int o;
    public boolean p;
    public PbFragment q;
    public AbsVideoPbFragment r;
    public ThreadData s;

    /* loaded from: classes5.dex */
    public class d extends RecyclerView.Adapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbLinkGoodsRootView a;

        /* loaded from: classes5.dex */
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
                    pbLinkGoodsRootView.p((t46) pbLinkGoodsRootView.m.get(this.a));
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements rz4 {
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

            @Override // com.baidu.tieba.rz4
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

        /* loaded from: classes5.dex */
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
                this.a.a.m();
            }
        }

        /* renamed from: com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView$d$d  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC0391d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public View$OnClickListenerC0391d(d dVar) {
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
                this.a.a.m();
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
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                t46 t46Var = (t46) this.a.m.get(i);
                if (t46Var instanceof CardLinkInfoData) {
                    return 3;
                }
                if (t46Var instanceof PbGoodsData) {
                    return 2;
                }
                return 1;
            }
            return invokeI.intValue;
        }

        public final void d(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, view2, i) != null) || view2 == null) {
                return;
            }
            if (this.a.m != null && this.a.q != null && !this.a.q.r5() && i == 2 && this.a.m.size() > 3) {
                view2.setOnClickListener(new c(this));
                view2.setVisibility(0);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).into(view2);
            } else if (this.a.r != null && this.a.m != null && !this.a.r.N3() && i == 2 && this.a.m.size() > 3) {
                view2.setOnClickListener(new View$OnClickListenerC0391d(this));
                view2.setVisibility(0);
                TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.cp_bg_line_d_alpha70, R.color.CAM_X0201).into(view2);
            } else {
                view2.setVisibility(8);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return invokeV.intValue;
            }
            return this.a.n;
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
                        bVar.a.a((t46) this.a.m.get(i));
                        bVar.a.setOnClickListener(new a(this, i));
                        if ((this.a.m.get(i) instanceof PbLinkData) && this.a.m.get(i) != null) {
                            if (((PbLinkData) this.a.m.get(i)).urlType == 2) {
                                this.a.o("c13961", 1);
                            }
                        } else if (this.a.m.get(i) instanceof PbGoodsData) {
                            this.a.o("c13961", 2);
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
                d(view2, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
                if (i == 3) {
                    return new c(this.a, LayoutInflater.from(this.a.f).inflate(R.layout.obfuscated_res_0x7f0d06eb, (ViewGroup) null));
                }
                return new b(this.a, LayoutInflater.from(this.a.f).inflate(R.layout.obfuscated_res_0x7f0d06e9, (ViewGroup) null));
            }
            return (RecyclerView.ViewHolder) invokeLI.objValue;
        }
    }

    /* loaded from: classes5.dex */
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
            this.a.m();
        }
    }

    /* loaded from: classes5.dex */
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
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0914ff);
            this.a = (SingleLinkCardView) view2.findViewById(R.id.obfuscated_res_0x7f091873);
        }
    }

    /* loaded from: classes5.dex */
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
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0914ff);
            this.a = (TbMountCardLinkLayout) view2.findViewById(R.id.obfuscated_res_0x7f09186f);
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
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06ea, this);
        BdRecyclerView bdRecyclerView = (BdRecyclerView) findViewById(R.id.obfuscated_res_0x7f091879);
        this.g = bdRecyclerView;
        bdRecyclerView.setNestedScrollingEnabled(false);
        this.h = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091883);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f09243d);
        this.d = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f091caf);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091027);
        this.e = (ThreadForumEnterGoodsButton) findViewById(R.id.obfuscated_res_0x7f0918c8);
        this.i = yi.g(this.f, R.dimen.tbds14);
        this.j = yi.g(this.f, R.dimen.tbds44);
        this.k = yi.g(this.f, R.dimen.tbds36);
        this.l = yi.g(this.f, R.dimen.tbds22);
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

    public void i(ox7 ox7Var, List<t46> list, String str, PbFragment pbFragment, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{ox7Var, list, str, pbFragment, Boolean.valueOf(z)}) == null) {
            this.q = pbFragment;
            k(ox7Var, list, str, z);
            PbFragment pbFragment2 = this.q;
            if (pbFragment2 != null) {
                l(pbFragment2.r5());
            }
        }
    }

    public void j(ox7 ox7Var, List<t46> list, String str, AbsVideoPbFragment absVideoPbFragment, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ox7Var, list, str, absVideoPbFragment, Boolean.valueOf(z)}) == null) {
            this.r = absVideoPbFragment;
            k(ox7Var, list, str, z);
            AbsVideoPbFragment absVideoPbFragment2 = this.r;
            if (absVideoPbFragment2 != null) {
                l(absVideoPbFragment2.N3());
            }
        }
    }

    public void k(ox7 ox7Var, List<t46> list, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{ox7Var, list, str, Boolean.valueOf(z)}) == null) {
            this.m = list;
            ThreadData Q = ox7Var.Q();
            this.s = Q;
            Q.setForum_name(ox7Var.n());
            this.s.setFid(Long.valueOf(ox7Var.m()).longValue());
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
                this.e.a(this.s);
                this.e.setVisibility(0);
                return;
            }
            this.e.setVisibility(8);
        }
    }

    public final void l(boolean z) {
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                this.n = this.m.size();
                TextView textView = this.b;
                if (this.p) {
                    resources2 = getResources();
                    i2 = R.string.obfuscated_res_0x7f0f0e12;
                } else {
                    resources2 = getResources();
                    i2 = R.string.obfuscated_res_0x7f0f0e14;
                }
                textView.setText(resources2.getString(i2));
                this.o = R.drawable.obfuscated_res_0x7f08096d;
            } else {
                if (this.n > 3) {
                    this.n = 3;
                }
                TextView textView2 = this.b;
                if (this.p) {
                    resources = getResources();
                    i = R.string.obfuscated_res_0x7f0f0e13;
                } else {
                    resources = getResources();
                    i = R.string.obfuscated_res_0x7f0f0e15;
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

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            PbFragment pbFragment = this.q;
            if (pbFragment != null) {
                if (pbFragment.r5()) {
                    this.q.G6(false);
                    l(false);
                    return;
                }
                this.q.G6(true);
                l(true);
                n();
                return;
            }
            AbsVideoPbFragment absVideoPbFragment = this.r;
            if (absVideoPbFragment != null) {
                if (absVideoPbFragment.N3()) {
                    this.r.p5(false);
                    l(false);
                    return;
                }
                this.r.p5(true);
                l(true);
                n();
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.s != null && this.p) {
            TiebaStatic.log(new StatisticItem("c13968").param("fid", this.s.getFid()).param("fname", this.s.getForum_name()).param("tid", this.s.getTid()));
        }
    }

    public final void o(String str, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, str, i) == null) && this.s != null) {
            TiebaStatic.log(new StatisticItem(str).param("obj_type", i).param("fid", this.s.getFid()).param("fname", this.s.getForum_name()).param("tid", this.s.getTid()));
        }
    }

    public final void p(t46 t46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, t46Var) == null) {
            if (t46Var instanceof PbLinkData) {
                PbLinkData pbLinkData = (PbLinkData) t46Var;
                if (pbLinkData == null) {
                    return;
                }
                TbPageContextSupport tbPageContextSupport = (TbPageContextSupport) this.f;
                if (pbLinkData.urlType == 1) {
                    UrlManager.getInstance().dealOneLink(tbPageContextSupport.getPageContext(), new String[]{pbLinkData.linkUrl});
                } else {
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext<?> pageContext = tbPageContextSupport.getPageContext();
                    urlManager.dealOneLink(pageContext, new String[]{wp4.a + xi.getUrlEncode(pbLinkData.linkUrl)});
                }
                if (pbLinkData.urlType == 2) {
                    o("c13962", 1);
                }
            } else if (t46Var instanceof PbGoodsData) {
                TbPageContextSupport tbPageContextSupport2 = (TbPageContextSupport) this.f;
                PbGoodsData pbGoodsData = (PbGoodsData) t46Var;
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
                            this.f.startActivity(intent);
                        } else if (UrlSchemaHelper.checkBaiduboxappSwan(pbGoodsData.linkUrl)) {
                            UrlManager.getInstance().dealOneLink(tbPageContextSupport2.getPageContext(), new String[]{UrlSchemaHelper.replaceSwanBaiduboxapp2Tiebaclient(pbGoodsData.linkUrl)});
                        } else if (!TextUtils.isEmpty(pbGoodsData.goodsUrlH5)) {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<?> pageContext2 = tbPageContextSupport2.getPageContext();
                            urlManager2.dealOneLink(pageContext2, new String[]{wp4.a + xi.getUrlEncode(pbGoodsData.goodsUrlH5)});
                        }
                    }
                } else {
                    UrlManager urlManager3 = UrlManager.getInstance();
                    TbPageContext<?> pageContext3 = tbPageContextSupport2.getPageContext();
                    urlManager3.dealOneLink(pageContext3, new String[]{wp4.a + xi.getUrlEncode(pbGoodsData.goodsUrlH5)});
                }
                o("c13962", 2);
            }
        }
    }
}
