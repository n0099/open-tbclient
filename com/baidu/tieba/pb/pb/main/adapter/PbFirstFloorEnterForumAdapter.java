package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.e;
import d.a.d.e.p.l;
import d.a.p0.b.d;
import d.a.p0.l0.c;
import d.a.q0.h2.h.g;
import d.a.q0.h3.q0.k;
/* loaded from: classes4.dex */
public class PbFirstFloorEnterForumAdapter extends d.a.d.k.e.a<g, PbFirstFloorEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public BaseFragment n;
    public PbFirstFloorEnterForumViewHolder o;
    public boolean p;
    public CustomMessageListener q;

    /* loaded from: classes4.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public CardForumHeadLayout f19568e;

        /* renamed from: f  reason: collision with root package name */
        public View f19569f;

        /* renamed from: g  reason: collision with root package name */
        public View f19570g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f19571h;

        /* renamed from: i  reason: collision with root package name */
        public g f19572i;
        public TBSpecificationBtn j;
        public LikeModel k;
        public String l;
        public String m;
        public View.OnClickListener n;
        public final /* synthetic */ PbFirstFloorEnterForumAdapter o;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PbFirstFloorEnterForumViewHolder f19573e;

            public a(PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pbFirstFloorEnterForumViewHolder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19573e = pbFirstFloorEnterForumViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder = this.f19573e;
                    LikeModel likeModel = pbFirstFloorEnterForumViewHolder.k;
                    if (likeModel != null) {
                        likeModel.L(pbFirstFloorEnterForumViewHolder.m, pbFirstFloorEnterForumViewHolder.l);
                    }
                    this.f19573e.f("c14276");
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b extends e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder, PbFirstFloorEnterForumAdapter pbFirstFloorEnterForumAdapter) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pbFirstFloorEnterForumViewHolder, pbFirstFloorEnterForumAdapter};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.d.a.e
            public void c(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921600, obj));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorEnterForumViewHolder(PbFirstFloorEnterForumAdapter pbFirstFloorEnterForumAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorEnterForumAdapter, view};
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
            this.o = pbFirstFloorEnterForumAdapter;
            this.n = new a(this);
            ViewGroup viewGroup = (ViewGroup) view;
            CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) viewGroup.getChildAt(0);
            this.f19568e = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.f19568e.setAfterClickListener(this);
            }
            this.f19569f = viewGroup.getChildAt(1);
            this.f19571h = (ImageView) viewGroup.getChildAt(2);
            this.f19570g = viewGroup.getChildAt(3);
            if (d.O() || d.N()) {
                LikeModel likeModel = new LikeModel(pbFirstFloorEnterForumAdapter.m);
                this.k = likeModel;
                likeModel.setLoadDataCallBack(new b(this, pbFirstFloorEnterForumAdapter));
                TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) viewGroup.getChildAt(4);
                this.j = tBSpecificationBtn;
                tBSpecificationBtn.setVisibility(8);
                this.j.setTextSize(R.dimen.T_X08);
                this.j.setOnClickListener(this.n);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WebPManager.setPureDrawable(this.f19571h, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
                SkinManager.setBackgroundColor(this.f19569f, R.color.CAM_X0203);
                SkinManager.setBackgroundColor(this.f19570g, R.color.CAM_X0203);
                this.f19568e.b();
            }
        }

        public void e(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) {
                if (gVar != null) {
                    this.f19572i = gVar;
                    this.l = gVar.j;
                    this.m = gVar.f57446e;
                    if (!this.o.p) {
                        this.o.p = gVar.l;
                    }
                    this.f19570g.setVisibility(gVar.f57450i ? 0 : 8);
                    if (a() != null) {
                        a().setPadding(0, 0, 0, gVar.f57450i ? l.g(this.o.f42341e, R.dimen.tbds42) : 0);
                    }
                    this.f19568e.setData(gVar.f57446e, gVar.f57447f, gVar.f57448g, gVar.f57449h);
                }
                if (this.j == null || this.o.p) {
                    return;
                }
                this.f19571h.setVisibility(4);
                this.j.setVisibility(0);
                g();
                f("c14274");
            }
        }

        public final void f(String str) {
            TbPageTag l;
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (l = c.l(this.o.n.getContext())) == null || (gVar = this.f19572i) == null) {
                return;
            }
            d.a.q0.h2.k.e.g1.c.a(str, gVar.j, gVar.k, TbadkCoreApplication.getCurrentAccount(), l.locatePage);
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.j == null) {
                return;
            }
            if (this.o.p) {
                this.j.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.followed));
                this.j.setClickable(false);
                ((d.a.p0.s.f0.n.b) this.j.getStyleConfig()).r(R.color.CAM_X0109);
                return;
            }
            this.j.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.attention));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13698").param("tid", this.f19572i.k).param("fid", this.f19572i.j).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFirstFloorEnterForumAdapter f19574a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbFirstFloorEnterForumAdapter pbFirstFloorEnterForumAdapter, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorEnterForumAdapter, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19574a = pbFirstFloorEnterForumAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && ((k) customResponsedMessage.getData()).f58819b) {
                this.f19574a.p = true;
                this.f19574a.o.g();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorEnterForumAdapter(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getContext(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = new a(this, 2001437);
        this.n = baseFragment;
        this.m = baseFragment.getPageContext();
        baseFragment.registerListener(this.q);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        m0(i2, view, viewGroup, gVar, pbFirstFloorEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: l0 */
    public PbFirstFloorEnterForumViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f42341e);
            int g2 = l.g(this.f42341e, R.dimen.M_W_X007);
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f42341e);
            cardForumHeadLayout.setPadding(0, l.g(this.f42341e, R.dimen.tbds32), 0, l.g(this.f42341e, R.dimen.tbds13));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = g2;
            frameLayout.addView(cardForumHeadLayout, layoutParams);
            View view = new View(this.f42341e);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(this.f42341e, R.dimen.tbds1));
            layoutParams2.leftMargin = g2;
            layoutParams2.rightMargin = g2;
            frameLayout.addView(view, layoutParams2);
            ImageView imageView = new ImageView(this.f42341e);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(l.g(this.f42341e, R.dimen.tbds42), l.g(this.f42341e, R.dimen.tbds42));
            layoutParams3.gravity = 21;
            layoutParams3.rightMargin = g2;
            frameLayout.addView(imageView, layoutParams3);
            View view2 = new View(this.f42341e);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, l.g(this.f42341e, R.dimen.tbds1));
            layoutParams4.leftMargin = g2;
            layoutParams4.rightMargin = g2;
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
            if (d.N() || d.O()) {
                TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(this.f42341e);
                FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams5.gravity = 21;
                layoutParams5.rightMargin = g2;
                frameLayout.addView(tBSpecificationBtn, layoutParams5);
            }
            PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder = new PbFirstFloorEnterForumViewHolder(this, frameLayout);
            this.o = pbFirstFloorEnterForumViewHolder;
            return pbFirstFloorEnterForumViewHolder;
        }
        return (PbFirstFloorEnterForumViewHolder) invokeL.objValue;
    }

    public View m0(int i2, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, pbFirstFloorEnterForumViewHolder})) == null) {
            if (gVar != null) {
                pbFirstFloorEnterForumViewHolder.e(gVar);
            }
            pbFirstFloorEnterForumViewHolder.d();
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
