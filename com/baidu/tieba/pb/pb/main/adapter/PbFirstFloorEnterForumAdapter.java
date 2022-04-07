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
import com.repackage.as7;
import com.repackage.ho;
import com.repackage.mu4;
import com.repackage.oi;
import com.repackage.tx7;
import com.repackage.u75;
import com.repackage.vm8;
/* loaded from: classes3.dex */
public class PbFirstFloorEnterForumAdapter extends ho<as7, PbFirstFloorEnterForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment i;
    public PbFirstFloorEnterForumViewHolder j;
    public boolean k;
    public CustomMessageListener l;

    /* loaded from: classes3.dex */
    public class PbFirstFloorEnterForumViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CardForumHeadLayout a;
        public View b;
        public View c;
        public ImageView d;
        public as7 e;
        public TBSpecificationBtn f;
        public String g;
        public String h;
        public final /* synthetic */ PbFirstFloorEnterForumAdapter i;

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
            this.i = pbFirstFloorEnterForumAdapter;
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

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WebPManager.setPureDrawable(this.d, R.drawable.icon_pure_list_arrow16_right, R.color.CAM_X0107, null);
                SkinManager.setBackgroundColor(this.b, R.color.CAM_X0203);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0203);
                this.a.d();
            }
        }

        public void e(as7 as7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, as7Var) == null) {
                if (as7Var != null) {
                    this.e = as7Var;
                    this.g = as7Var.f;
                    this.h = as7Var.a;
                    if (!this.i.k) {
                        this.i.k = as7Var.h;
                    }
                    this.c.setVisibility(as7Var.e ? 0 : 8);
                    if (b() != null) {
                        b().setPadding(0, 0, 0, as7Var.e ? oi.f(this.i.a, R.dimen.tbds42) : 0);
                    }
                    this.a.setData(as7Var.a, as7Var.b, as7Var.c, as7Var.d);
                }
                if (this.f == null || this.i.k) {
                    return;
                }
                this.d.setVisibility(4);
                this.f.setVisibility(0);
                g();
                f("c14274");
            }
        }

        public final void f(String str) {
            TbPageTag l;
            as7 as7Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || (l = u75.l(this.i.i.getContext())) == null || (as7Var = this.e) == null) {
                return;
            }
            tx7.a(str, as7Var.f, as7Var.g, TbadkCoreApplication.getCurrentAccount(), l.locatePage);
        }

        public final void g() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f == null) {
                return;
            }
            if (this.i.k) {
                this.f.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f062e));
                this.f.setClickable(false);
                ((mu4) this.f.getStyleConfig()).t(R.color.CAM_X0109);
                return;
            }
            this.f.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f029c));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13698").param("tid", this.e.g).param("fid", this.e.f).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof vm8) && ((vm8) customResponsedMessage.getData()).b) {
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
    @Override // com.repackage.ho
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, as7 as7Var, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        f0(i, view2, viewGroup, as7Var, pbFirstFloorEnterForumViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: e0 */
    public PbFirstFloorEnterForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.a);
            int f = oi.f(this.a, R.dimen.M_W_X007);
            CardForumHeadLayout cardForumHeadLayout = new CardForumHeadLayout(this.a);
            cardForumHeadLayout.setPadding(0, oi.f(this.a, R.dimen.tbds32), 0, oi.f(this.a, R.dimen.tbds13));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = f;
            layoutParams.rightMargin = f;
            frameLayout.addView(cardForumHeadLayout, layoutParams);
            View view2 = new View(this.a);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, oi.f(this.a, R.dimen.tbds1));
            layoutParams2.leftMargin = f;
            layoutParams2.rightMargin = f;
            frameLayout.addView(view2, layoutParams2);
            ImageView imageView = new ImageView(this.a);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(oi.f(this.a, R.dimen.tbds42), oi.f(this.a, R.dimen.tbds42));
            layoutParams3.gravity = 21;
            layoutParams3.rightMargin = f;
            frameLayout.addView(imageView, layoutParams3);
            View view3 = new View(this.a);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, oi.f(this.a, R.dimen.tbds1));
            layoutParams4.leftMargin = f;
            layoutParams4.rightMargin = f;
            layoutParams4.gravity = 80;
            frameLayout.addView(view3, layoutParams4);
            PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder = new PbFirstFloorEnterForumViewHolder(this, frameLayout);
            this.j = pbFirstFloorEnterForumViewHolder;
            return pbFirstFloorEnterForumViewHolder;
        }
        return (PbFirstFloorEnterForumViewHolder) invokeL.objValue;
    }

    public View f0(int i, View view2, ViewGroup viewGroup, as7 as7Var, PbFirstFloorEnterForumViewHolder pbFirstFloorEnterForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, as7Var, pbFirstFloorEnterForumViewHolder})) == null) {
            if (as7Var != null) {
                pbFirstFloorEnterForumViewHolder.e(as7Var);
            }
            pbFirstFloorEnterForumViewHolder.d();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
