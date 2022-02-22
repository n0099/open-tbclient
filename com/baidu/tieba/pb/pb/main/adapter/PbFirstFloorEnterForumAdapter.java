package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c.a.d.f.p.n;
import c.a.t0.p0.c;
import c.a.t0.s.l0.n.b;
import c.a.u0.u2.f;
import c.a.u0.u2.g;
import c.a.u0.u2.l;
import c.a.u0.u2.r.h;
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
/* loaded from: classes13.dex */
public class PbFirstFloorEnterForumAdapter extends c.a.d.o.e.a<h, PbFirstFloorEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment m;
    public PbFirstFloorEnterForumViewHolder n;
    public boolean o;
    public CustomMessageListener p;

    /* loaded from: classes13.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public CardForumHeadLayout f46801e;

        /* renamed from: f  reason: collision with root package name */
        public View f46802f;

        /* renamed from: g  reason: collision with root package name */
        public View f46803g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f46804h;

        /* renamed from: i  reason: collision with root package name */
        public h f46805i;

        /* renamed from: j  reason: collision with root package name */
        public TBSpecificationBtn f46806j;
        public String k;
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
            this.f46801e = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.f46801e.setAfterClickListener(this);
            }
            this.f46802f = viewGroup.getChildAt(1);
            this.f46804h = (ImageView) viewGroup.getChildAt(2);
            this.f46803g = viewGroup.getChildAt(3);
        }

        public final void b(String str) {
            TbPageTag l;
            h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (l = c.l(this.m.m.getContext())) == null || (hVar = this.f46805i) == null) {
                return;
            }
            c.a.u0.u2.u.f.h1.c.a(str, hVar.f23192j, hVar.k, TbadkCoreApplication.getCurrentAccount(), l.locatePage);
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f46806j == null) {
                return;
            }
            if (this.m.o) {
                this.f46806j.setText(TbadkCoreApplication.getInst().getResources().getString(l.followed));
                this.f46806j.setClickable(false);
                ((b) this.f46806j.getStyleConfig()).t(f.CAM_X0109);
                return;
            }
            this.f46806j.setText(TbadkCoreApplication.getInst().getResources().getString(l.attention));
        }

        public void changeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                WebPManager.setPureDrawable(this.f46804h, c.a.u0.u2.h.icon_pure_list_arrow16_right, f.CAM_X0107, null);
                SkinManager.setBackgroundColor(this.f46802f, f.CAM_X0203);
                SkinManager.setBackgroundColor(this.f46803g, f.CAM_X0203);
                this.f46801e.onChangeSkinType();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13698").param("tid", this.f46805i.k).param("fid", this.f46805i.f23192j).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }

        public void setData(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, hVar) == null) {
                if (hVar != null) {
                    this.f46805i = hVar;
                    this.k = hVar.f23192j;
                    this.l = hVar.f23187e;
                    if (!this.m.o) {
                        this.m.o = hVar.l;
                    }
                    this.f46803g.setVisibility(hVar.f23191i ? 0 : 8);
                    if (getView() != null) {
                        getView().setPadding(0, 0, 0, hVar.f23191i ? n.f(this.m.f2447e, g.tbds42) : 0);
                    }
                    this.f46801e.setData(hVar.f23187e, hVar.f23188f, hVar.f23189g, hVar.f23190h);
                }
                if (this.f46806j == null || this.m.o) {
                    return;
                }
                this.f46804h.setVisibility(4);
                this.f46806j.setVisibility(0);
                c();
                b("c14274");
            }
        }
    }

    /* loaded from: classes13.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.u0.z3.t0.f) && ((c.a.u0.z3.t0.f) customResponsedMessage.getData()).f26402b) {
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
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        f0(i2, view, viewGroup, hVar, pbFirstFloorEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: e0 */
    public PbFirstFloorEnterForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f2447e);
            int f2 = n.f(this.f2447e, g.M_W_X007);
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f2447e);
            cardForumHeadLayout.setPadding(0, n.f(this.f2447e, g.tbds32), 0, n.f(this.f2447e, g.tbds13));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = f2;
            layoutParams.rightMargin = f2;
            frameLayout.addView(cardForumHeadLayout, layoutParams);
            View view = new View(this.f2447e);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, n.f(this.f2447e, g.tbds1));
            layoutParams2.leftMargin = f2;
            layoutParams2.rightMargin = f2;
            frameLayout.addView(view, layoutParams2);
            ImageView imageView = new ImageView(this.f2447e);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(n.f(this.f2447e, g.tbds42), n.f(this.f2447e, g.tbds42));
            layoutParams3.gravity = 21;
            layoutParams3.rightMargin = f2;
            frameLayout.addView(imageView, layoutParams3);
            View view2 = new View(this.f2447e);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, n.f(this.f2447e, g.tbds1));
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

    public View f0(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
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
