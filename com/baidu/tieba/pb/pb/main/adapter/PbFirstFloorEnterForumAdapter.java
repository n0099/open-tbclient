package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import c.a.d.f.p.n;
import c.a.o0.o0.c;
import c.a.o0.r.l0.n.b;
import c.a.p0.a4.t0.f;
import c.a.p0.w2.i.h;
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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbFirstFloorEnterForumAdapter extends c.a.d.o.e.a<h, PbFirstFloorEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment i;
    public PbFirstFloorEnterForumViewHolder j;
    public boolean k;
    public CustomMessageListener l;

    /* loaded from: classes5.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CardForumHeadLayout a;

        /* renamed from: b  reason: collision with root package name */
        public View f35007b;

        /* renamed from: c  reason: collision with root package name */
        public View f35008c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f35009d;

        /* renamed from: e  reason: collision with root package name */
        public h f35010e;

        /* renamed from: f  reason: collision with root package name */
        public TBSpecificationBtn f35011f;

        /* renamed from: g  reason: collision with root package name */
        public String f35012g;

        /* renamed from: h  reason: collision with root package name */
        public String f35013h;
        public final /* synthetic */ PbFirstFloorEnterForumAdapter i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorEnterForumViewHolder(PbFirstFloorEnterForumAdapter pbFirstFloorEnterForumAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorEnterForumAdapter, view};
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
            this.i = pbFirstFloorEnterForumAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) viewGroup.getChildAt(0);
            this.a = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.a.setAfterClickListener(this);
            }
            this.f35007b = viewGroup.getChildAt(1);
            this.f35009d = (ImageView) viewGroup.getChildAt(2);
            this.f35008c = viewGroup.getChildAt(3);
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WebPManager.setPureDrawable(this.f35009d, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
                SkinManager.setBackgroundColor(this.f35007b, R.color.CAM_X0203);
                SkinManager.setBackgroundColor(this.f35008c, R.color.CAM_X0203);
                this.a.d();
            }
        }

        public void e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
                if (hVar != null) {
                    this.f35010e = hVar;
                    this.f35012g = hVar.f19826f;
                    this.f35013h = hVar.a;
                    if (!this.i.k) {
                        this.i.k = hVar.f19828h;
                    }
                    this.f35008c.setVisibility(hVar.f19825e ? 0 : 8);
                    if (b() != null) {
                        b().setPadding(0, 0, 0, hVar.f19825e ? n.f(this.i.a, R.dimen.tbds42) : 0);
                    }
                    this.a.setData(hVar.a, hVar.f19822b, hVar.f19823c, hVar.f19824d);
                }
                if (this.f35011f == null || this.i.k) {
                    return;
                }
                this.f35009d.setVisibility(4);
                this.f35011f.setVisibility(0);
                g();
                f("c14274");
            }
        }

        public final void f(String str) {
            TbPageTag l;
            h hVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (l = c.l(this.i.i.getContext())) == null || (hVar = this.f35010e) == null) {
                return;
            }
            c.a.p0.w2.m.f.n1.c.a(str, hVar.f19826f, hVar.f19827g, TbadkCoreApplication.getCurrentAccount(), l.locatePage);
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f35011f == null) {
                return;
            }
            if (this.i.k) {
                this.f35011f.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0627));
                this.f35011f.setClickable(false);
                ((b) this.f35011f.getStyleConfig()).t(R.color.CAM_X0109);
                return;
            }
            this.f35011f.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f029b));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13698").param("tid", this.f35010e.f19827g).param("fid", this.f35010e.f19826f).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFirstFloorEnterForumAdapter a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbFirstFloorEnterForumAdapter pbFirstFloorEnterForumAdapter, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorEnterForumAdapter, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f) && ((f) customResponsedMessage.getData()).f12402b) {
                this.a.k = true;
                this.a.j.g();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this, 2001437);
        this.i = baseFragment;
        baseFragment.getPageContext();
        baseFragment.registerListener(this.l);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // c.a.d.o.e.a
    public /* bridge */ /* synthetic */ View S(int i, View view, ViewGroup viewGroup, h hVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        f0(i, view, viewGroup, hVar, pbFirstFloorEnterForumViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: e0 */
    public PbFirstFloorEnterForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.a);
            int f2 = n.f(this.a, R.dimen.M_W_X007);
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.a);
            cardForumHeadLayout.setPadding(0, n.f(this.a, R.dimen.tbds32), 0, n.f(this.a, R.dimen.tbds13));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = f2;
            layoutParams.rightMargin = f2;
            frameLayout.addView(cardForumHeadLayout, layoutParams);
            View view = new View(this.a);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, n.f(this.a, R.dimen.tbds1));
            layoutParams2.leftMargin = f2;
            layoutParams2.rightMargin = f2;
            frameLayout.addView(view, layoutParams2);
            ImageView imageView = new ImageView(this.a);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(n.f(this.a, R.dimen.tbds42), n.f(this.a, R.dimen.tbds42));
            layoutParams3.gravity = 21;
            layoutParams3.rightMargin = f2;
            frameLayout.addView(imageView, layoutParams3);
            View view2 = new View(this.a);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, n.f(this.a, R.dimen.tbds1));
            layoutParams4.leftMargin = f2;
            layoutParams4.rightMargin = f2;
            layoutParams4.gravity = 80;
            frameLayout.addView(view2, layoutParams4);
            PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder = new PbFirstFloorEnterForumViewHolder(this, frameLayout);
            this.j = pbFirstFloorEnterForumViewHolder;
            return pbFirstFloorEnterForumViewHolder;
        }
        return (PbFirstFloorEnterForumViewHolder) invokeL.objValue;
    }

    public View f0(int i, View view, ViewGroup viewGroup, h hVar, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, hVar, pbFirstFloorEnterForumViewHolder})) == null) {
            if (hVar != null) {
                pbFirstFloorEnterForumViewHolder.e(hVar);
            }
            pbFirstFloorEnterForumViewHolder.d();
            return view;
        }
        return (View) invokeCommon.objValue;
    }
}
