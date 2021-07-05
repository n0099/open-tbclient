package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.s0.h2.h.h;
import tbclient.Item;
/* loaded from: classes5.dex */
public class PbFirstFloorItemAdapter extends d.a.c.k.e.a<h, PbFirstFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener m;

    /* loaded from: classes5.dex */
    public class PbFirstFloorItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19442e;

        /* renamed from: f  reason: collision with root package name */
        public ItemCardView f19443f;

        /* renamed from: g  reason: collision with root package name */
        public View f19444g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFirstFloorItemAdapter f19445h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorItemViewHolder(PbFirstFloorItemAdapter pbFirstFloorItemAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorItemAdapter, view};
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
            this.f19445h = pbFirstFloorItemAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            this.f19444g = viewGroup.getChildAt(0);
            this.f19442e = (TextView) viewGroup.getChildAt(1);
            this.f19443f = (ItemCardView) viewGroup.getChildAt(2);
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.f19444g, R.color.CAM_X0203);
                SkinManager.setViewTextColor(this.f19442e, R.color.CAM_X0109);
                this.f19443f.b();
            }
        }

        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
                if (hVar != null) {
                    this.f19442e.setText(this.f19445h.f44821e.getText(R.string.related_recommendation));
                    this.f19443f.setData(hVar.f60152e, 17);
                }
                if (this.f19445h.m != null) {
                    this.f19443f.setOnClickListenerOfRightBtn(this.f19445h.m);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(PbFirstFloorItemAdapter pbFirstFloorItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, view));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(PbFirstFloorItemAdapter pbFirstFloorItemAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorItemAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.c.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            h hVar;
            Item item;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof h) && (item = (hVar = (h) nVar).f60152e) != null) {
                ItemClickJumpUtil.itemClickJump(item.forum_name, String.valueOf(item.item_id), 9, 9);
                StatisticItem statisticItem = new StatisticItem("c14071");
                statisticItem.param("tid", hVar.f60153f);
                statisticItem.param("obj_locate", hVar.f60152e.item_id.longValue());
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorItemAdapter(Context context, BdUniqueId bdUniqueId) {
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
        this.m = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        i0(i2, view, viewGroup, hVar, pbFirstFloorItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public PbFirstFloorItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f44821e);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            int g2 = l.g(this.f44821e, R.dimen.M_W_X007);
            int g3 = l.g(this.f44821e, R.dimen.T_X09);
            int g4 = l.g(this.f44821e, R.dimen.M_H_X005);
            int g5 = l.g(this.f44821e, R.dimen.M_H_X003);
            View view = new View(this.f44821e);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.g(this.f44821e, R.dimen.tbds1));
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = g2;
            linearLayout.addView(view, layoutParams);
            TextView textView = new TextView(this.f44821e);
            textView.setTextSize(0, g3);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = g2;
            layoutParams2.topMargin = g4;
            layoutParams2.bottomMargin = g5;
            linearLayout.addView(textView, layoutParams2);
            ItemCardView itemCardView = new ItemCardView(this.f44821e);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = g2;
            layoutParams3.rightMargin = g2;
            layoutParams3.bottomMargin = g4;
            itemCardView.setPosition(5);
            linearLayout.addView(itemCardView, layoutParams3);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setOnClickListenerOfRightBtn(new a(this));
            a0(new b(this));
            return new PbFirstFloorItemViewHolder(this, linearLayout);
        }
        return (PbFirstFloorItemViewHolder) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, hVar, pbFirstFloorItemViewHolder})) == null) {
            if (hVar != null && hVar.f60152e != null) {
                pbFirstFloorItemViewHolder.c(hVar);
            }
            pbFirstFloorItemViewHolder.b();
            StatisticItem statisticItem = new StatisticItem("c14070");
            statisticItem.param("tid", hVar.f60153f);
            statisticItem.param("obj_locate", hVar.f60152e.item_id.longValue());
            TiebaStatic.log(statisticItem);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }
}
