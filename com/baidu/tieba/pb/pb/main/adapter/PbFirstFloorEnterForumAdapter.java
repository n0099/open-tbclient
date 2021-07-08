package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.a;
import d.a.p0.h2.h.g;
/* loaded from: classes4.dex */
public class PbFirstFloorEnterForumAdapter extends a<g, PbFirstFloorEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public CardForumHeadLayout f19477e;

        /* renamed from: f  reason: collision with root package name */
        public View f19478f;

        /* renamed from: g  reason: collision with root package name */
        public View f19479g;

        /* renamed from: h  reason: collision with root package name */
        public ImageView f19480h;

        /* renamed from: i  reason: collision with root package name */
        public g f19481i;
        public final /* synthetic */ PbFirstFloorEnterForumAdapter j;

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
            this.j = pbFirstFloorEnterForumAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) viewGroup.getChildAt(0);
            this.f19477e = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.f19477e.setAfterClickListener(this);
            }
            this.f19478f = viewGroup.getChildAt(1);
            this.f19480h = (ImageView) viewGroup.getChildAt(2);
            this.f19479g = viewGroup.getChildAt(3);
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WebPManager.setPureDrawable(this.f19480h, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
                SkinManager.setBackgroundColor(this.f19478f, R.color.CAM_X0203);
                SkinManager.setBackgroundColor(this.f19479g, R.color.CAM_X0203);
                this.f19477e.b();
            }
        }

        public void c(g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar) == null) || gVar == null) {
                return;
            }
            this.f19481i = gVar;
            this.f19479g.setVisibility(gVar.f56906i ? 0 : 8);
            if (a() != null) {
                a().setPadding(0, 0, 0, gVar.f56906i ? l.g(this.j.f41837e, R.dimen.tbds42) : 0);
            }
            this.f19477e.setData(gVar.f56902e, gVar.f56903f, gVar.f56904g, gVar.f56905h);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13698").param("tid", this.f19481i.k).param("fid", this.f19481i.j).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorEnterForumAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        h0(i2, view, viewGroup, gVar, pbFirstFloorEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public PbFirstFloorEnterForumViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.f41837e);
            int g2 = l.g(this.f41837e, R.dimen.M_W_X007);
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.f41837e);
            cardForumHeadLayout.setPadding(0, l.g(this.f41837e, R.dimen.tbds32), 0, l.g(this.f41837e, R.dimen.tbds13));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = g2;
            frameLayout.addView(cardForumHeadLayout, layoutParams);
            View view = new View(this.f41837e);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, l.g(this.f41837e, R.dimen.tbds1));
            layoutParams2.leftMargin = g2;
            layoutParams2.rightMargin = g2;
            frameLayout.addView(view, layoutParams2);
            ImageView imageView = new ImageView(this.f41837e);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(l.g(this.f41837e, R.dimen.tbds42), l.g(this.f41837e, R.dimen.tbds42));
            layoutParams3.gravity = 21;
            layoutParams3.rightMargin = g2;
            frameLayout.addView(imageView, layoutParams3);
            View view2 = new View(this.f41837e);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, l.g(this.f41837e, R.dimen.tbds1));
            layoutParams4.leftMargin = g2;
            layoutParams4.rightMargin = g2;
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
            return new PbFirstFloorEnterForumViewHolder(this, frameLayout);
        }
        return (PbFirstFloorEnterForumViewHolder) invokeL.objValue;
    }

    public View h0(int i2, View view, ViewGroup viewGroup, g gVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, pbFirstFloorEnterForumViewHolder})) == null) {
            if (gVar != null) {
                pbFirstFloorEnterForumViewHolder.c(gVar);
            }
            pbFirstFloorEnterForumViewHolder.b();
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
