package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c.a.q0.o0.c;
import c.a.q0.s.g0.n.b;
import c.a.r0.q2.f;
import c.a.r0.q2.g;
import c.a.r0.q2.l;
import c.a.r0.q2.r.h;
import c.a.r0.t3.s0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class PbFirstFloorEnterForumAdapter extends c.a.d.m.e.a<h, PbFirstFloorEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment m;
    public PbFirstFloorEnterForumViewHolder n;
    public boolean o;
    public CustomMessageListener p;

    /* loaded from: classes11.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public CardForumHeadLayout f47708e;

        /* renamed from: f  reason: collision with root package name */
        public View f47709f;

        /* renamed from: g  reason: collision with root package name */
        public View f47710g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f47711h;

        /* renamed from: i  reason: collision with root package name */
        public h f47712i;

        /* renamed from: j  reason: collision with root package name */
        public TBSpecificationBtn f47713j;

        /* renamed from: k  reason: collision with root package name */
        public String f47714k;
        public String l;
        public final /* synthetic */ PbFirstFloorEnterForumAdapter m;

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
            this.m = pbFirstFloorEnterForumAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) viewGroup.getChildAt(0);
            this.f47708e = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.f47708e.setAfterClickListener(this);
            }
            this.f47709f = viewGroup.getChildAt(1);
            this.f47711h = (ImageView) viewGroup.getChildAt(2);
            this.f47710g = viewGroup.getChildAt(3);
        }

        public final void b(String str) {
            TbPageTag l;
            h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (l = c.l(this.m.m.getContext())) == null || (hVar = this.f47712i) == null) {
                return;
            }
            c.a.r0.q2.u.f.g1.c.a(str, hVar.f21531j, hVar.f21532k, TbadkCoreApplication.getCurrentAccount(), l.locatePage);
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f47713j == null) {
                return;
            }
            if (this.m.o) {
                this.f47713j.setText(TbadkCoreApplication.getInst().getResources().getString(l.followed));
                this.f47713j.setClickable(false);
                ((b) this.f47713j.getStyleConfig()).s(f.CAM_X0109);
                return;
            }
            this.f47713j.setText(TbadkCoreApplication.getInst().getResources().getString(l.attention));
        }

        public void changeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                WebPManager.setPureDrawable(this.f47711h, c.a.r0.q2.h.icon_pure_list_arrow16_right, f.CAM_X0107, null);
                SkinManager.setBackgroundColor(this.f47709f, f.CAM_X0203);
                SkinManager.setBackgroundColor(this.f47710g, f.CAM_X0203);
                this.f47708e.onChangeSkinType();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13698").param("tid", this.f47712i.f21532k).param("fid", this.f47712i.f21531j).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }

        public void setData(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                if (hVar != null) {
                    this.f47712i = hVar;
                    this.f47714k = hVar.f21531j;
                    this.l = hVar.f21526e;
                    if (!this.m.o) {
                        this.m.o = hVar.l;
                    }
                    this.f47710g.setVisibility(hVar.f21530i ? 0 : 8);
                    if (getView() != null) {
                        getView().setPadding(0, 0, 0, hVar.f21530i ? c.a.d.f.p.l.f(this.m.f2907e, g.tbds42) : 0);
                    }
                    this.f47708e.setData(hVar.f21526e, hVar.f21527f, hVar.f21528g, hVar.f21529h);
                }
                if (this.f47713j == null || this.m.o) {
                    return;
                }
                this.f47711h.setVisibility(4);
                this.f47713j.setVisibility(0);
                c();
                b("c14274");
            }
        }
    }

    /* loaded from: classes11.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorEnterForumAdapter a;

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
            this.a = pbFirstFloorEnterForumAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k) && ((k) customResponsedMessage.getData()).f24044b) {
                this.a.o = true;
                this.a.n.c();
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
        this.p = new a(this, 2001437);
        this.m = baseFragment;
        baseFragment.getPageContext();
        baseFragment.registerListener(this.p);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        m0(i2, view, viewGroup, hVar, pbFirstFloorEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: l0 */
    public PbFirstFloorEnterForumViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f2907e);
            int f2 = c.a.d.f.p.l.f(this.f2907e, g.M_W_X007);
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f2907e);
            cardForumHeadLayout.setPadding(0, c.a.d.f.p.l.f(this.f2907e, g.tbds32), 0, c.a.d.f.p.l.f(this.f2907e, g.tbds13));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = f2;
            layoutParams.rightMargin = f2;
            frameLayout.addView(cardForumHeadLayout, layoutParams);
            View view = new View(this.f2907e);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, c.a.d.f.p.l.f(this.f2907e, g.tbds1));
            layoutParams2.leftMargin = f2;
            layoutParams2.rightMargin = f2;
            frameLayout.addView(view, layoutParams2);
            ImageView imageView = new ImageView(this.f2907e);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(c.a.d.f.p.l.f(this.f2907e, g.tbds42), c.a.d.f.p.l.f(this.f2907e, g.tbds42));
            layoutParams3.gravity = 21;
            layoutParams3.rightMargin = f2;
            frameLayout.addView(imageView, layoutParams3);
            View view2 = new View(this.f2907e);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, c.a.d.f.p.l.f(this.f2907e, g.tbds1));
            layoutParams4.leftMargin = f2;
            layoutParams4.rightMargin = f2;
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
            PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder = new PbFirstFloorEnterForumViewHolder(this, frameLayout);
            this.n = pbFirstFloorEnterForumViewHolder;
            return pbFirstFloorEnterForumViewHolder;
        }
        return (PbFirstFloorEnterForumViewHolder) invokeL.objValue;
    }

    public View m0(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, hVar, pbFirstFloorEnterForumViewHolder})) == null) {
            if (hVar != null) {
                pbFirstFloorEnterForumViewHolder.setData(hVar);
            }
            pbFirstFloorEnterForumViewHolder.changeSkinType();
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
