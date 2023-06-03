package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.e0a;
import com.baidu.tieba.in;
import com.baidu.tieba.jw9;
import com.baidu.tieba.l39;
import com.baidu.tieba.m75;
import com.baidu.tieba.n25;
import com.baidu.tieba.pr5;
import com.baidu.tieba.u99;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbFirstFloorEnterForumAdapter extends in<l39, PbFirstFloorEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public PbFirstFloorEnterForumViewHolder b;
    public boolean c;
    public CustomMessageListener d;

    /* loaded from: classes7.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CardForumHeadLayout a;
        public View b;
        public View c;
        public ImageView d;
        public l39 e;
        public final /* synthetic */ PbFirstFloorEnterForumAdapter f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorEnterForumViewHolder(PbFirstFloorEnterForumAdapter pbFirstFloorEnterForumAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorEnterForumAdapter, view2};
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
            this.f = pbFirstFloorEnterForumAdapter;
            ViewGroup viewGroup = (ViewGroup) view2;
            CardForumHeadLayout cardForumHeadLayout = (CardForumHeadLayout) viewGroup.getChildAt(0);
            this.a = cardForumHeadLayout;
            if (cardForumHeadLayout != null) {
                cardForumHeadLayout.setOnClickListener(cardForumHeadLayout);
                this.a.setAfterClickListener(this);
            }
            this.b = viewGroup.getChildAt(1);
            this.d = (ImageView) viewGroup.getChildAt(2);
            this.c = viewGroup.getChildAt(3);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WebPManager.setPureDrawable(this.d, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0203);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0203);
                if (UbsABTestHelper.isPbEnterForum()) {
                    m75 d = m75.d(this.a);
                    d.o(R.string.J_X05);
                    d.h(jw9.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
                } else {
                    this.a.setBackground(null);
                }
                this.a.g();
            }
        }

        public void b(l39 l39Var) {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l39Var) == null) {
                if (l39Var != null) {
                    this.e = l39Var;
                    if (!this.f.c) {
                        this.f.c = l39Var.h;
                    }
                    View view2 = this.c;
                    if (l39Var.e) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    view2.setVisibility(i);
                    if (getView() != null) {
                        View view3 = getView();
                        if (l39Var.e) {
                            i2 = vi.g(this.f.mContext, R.dimen.tbds42);
                        } else {
                            i2 = 0;
                        }
                        view3.setPadding(0, 0, 0, i2);
                    }
                    n25 n25Var = l39Var.j;
                    if (UbsABTestHelper.isPbEnterForum() && n25Var != null) {
                        n25Var.g(TbadkCoreApplication.getInst().getString(R.string.enter_forum));
                        this.b.setVisibility(8);
                    }
                    this.a.setData(l39Var.a, l39Var.b, l39Var.c, l39Var.d, l39Var.i, n25Var);
                    TiebaStatic.log(new StatisticItem("c15303").param("tid", l39Var.g).param("fid", l39Var.f).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                }
                if (UbsABTestHelper.isPbEnterForum()) {
                    this.d.setVisibility(8);
                } else {
                    this.d.setVisibility(0);
                }
                if (!this.f.c) {
                    this.d.setVisibility(4);
                    c("c14274");
                }
            }
        }

        public final void c(String str) {
            TbPageTag l;
            l39 l39Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (l = pr5.l(this.f.a.getContext())) != null && (l39Var = this.e) != null) {
                u99.a(str, l39Var.f, l39Var.g, TbadkCoreApplication.getCurrentAccount(), l.locatePage);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13698").param("tid", this.e.g).param("fid", this.e.f).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof e0a) || !((e0a) customResponsedMessage.getData()).b) {
                return;
            }
            this.a.c = true;
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
        a aVar = new a(this, 2001437);
        this.d = aVar;
        this.a = baseFragment;
        baseFragment.registerListener(aVar);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.in
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, l39 l39Var, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        z(i, view2, viewGroup, l39Var, pbFirstFloorEnterForumViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: y */
    public PbFirstFloorEnterForumViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            int i2 = 0;
            frameLayout.setClipChildren(false);
            int g = vi.g(this.mContext, R.dimen.M_W_X007);
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.mContext);
            int g2 = vi.g(this.mContext, R.dimen.tbds32);
            int g3 = vi.g(this.mContext, R.dimen.tbds13);
            if (UbsABTestHelper.isPbEnterForum()) {
                int g4 = vi.g(this.mContext, R.dimen.M_W_X006);
                cardForumHeadLayout.setNeedShowForumlable(false);
                cardForumHeadLayout.setBarNameIncludePadding(false);
                cardForumHeadLayout.setBarThreadLineSpace(vi.g(this.mContext, R.dimen.tbds26));
                cardForumHeadLayout.setAttentionLineSpace(vi.g(this.mContext, R.dimen.tbds26));
                int g5 = vi.g(this.mContext, R.dimen.tbds16);
                g3 = vi.g(this.mContext, R.dimen.tbds15);
                i = vi.g(this.mContext, R.dimen.tbds28);
                g2 = g5;
                i2 = g4;
            } else {
                i = 0;
            }
            cardForumHeadLayout.setPadding(i2, g2, i2, g3);
            cardForumHeadLayout.setJumpCallFrom(2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = g;
            layoutParams.rightMargin = g;
            layoutParams.topMargin = i;
            frameLayout.addView(cardForumHeadLayout, layoutParams);
            View view2 = new View(this.mContext);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, vi.g(this.mContext, R.dimen.tbds1));
            layoutParams2.leftMargin = g;
            layoutParams2.rightMargin = g;
            frameLayout.addView(view2, layoutParams2);
            ImageView imageView = new ImageView(this.mContext);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(vi.g(this.mContext, R.dimen.tbds42), vi.g(this.mContext, R.dimen.tbds42));
            layoutParams3.gravity = 21;
            layoutParams3.rightMargin = g;
            frameLayout.addView(imageView, layoutParams3);
            View view3 = new View(this.mContext);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, vi.g(this.mContext, R.dimen.tbds1));
            layoutParams4.leftMargin = g;
            layoutParams4.rightMargin = g;
            layoutParams4.gravity = 80;
            frameLayout.addView(view3, layoutParams4);
            PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder = new PbFirstFloorEnterForumViewHolder(this, frameLayout);
            this.b = pbFirstFloorEnterForumViewHolder;
            return pbFirstFloorEnterForumViewHolder;
        }
        return (PbFirstFloorEnterForumViewHolder) invokeL.objValue;
    }

    public View z(int i, View view2, ViewGroup viewGroup, l39 l39Var, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l39Var, pbFirstFloorEnterForumViewHolder})) == null) {
            if (l39Var != null) {
                pbFirstFloorEnterForumViewHolder.b(l39Var);
            }
            pbFirstFloorEnterForumViewHolder.a();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
