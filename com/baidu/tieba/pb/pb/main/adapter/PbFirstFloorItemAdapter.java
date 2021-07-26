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
import d.a.d.e.p.l;
import d.a.q0.h2.h.h;
import tbclient.Item;
/* loaded from: classes4.dex */
public class PbFirstFloorItemAdapter extends d.a.d.k.e.a<h, PbFirstFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener m;

    /* loaded from: classes4.dex */
    public class PbFirstFloorItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f19575e;

        /* renamed from: f  reason: collision with root package name */
        public ItemCardView f19576f;

        /* renamed from: g  reason: collision with root package name */
        public View f19577g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFirstFloorItemAdapter f19578h;

        /* loaded from: classes4.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ h f19579e;

            public a(PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder, h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pbFirstFloorItemViewHolder, hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19579e = hVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    Item item = this.f19579e.f57452e;
                    ItemClickJumpUtil.itemClickJump(item.forum_name, String.valueOf(item.item_id), 9, 9);
                    StatisticItem statisticItem = new StatisticItem("c14071");
                    statisticItem.param("tid", this.f19579e.f57453f);
                    statisticItem.param("obj_locate", this.f19579e.f57452e.item_id.longValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }

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
            this.f19578h = pbFirstFloorItemAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            this.f19577g = viewGroup.getChildAt(0);
            this.f19575e = (TextView) viewGroup.getChildAt(1);
            this.f19576f = (ItemCardView) viewGroup.getChildAt(2);
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.f19577g, R.color.CAM_X0203);
                SkinManager.setViewTextColor(this.f19575e, R.color.CAM_X0109);
                this.f19576f.x();
            }
        }

        public void c(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
                if (hVar != null) {
                    this.f19575e.setText(this.f19578h.f42341e.getText(R.string.related_recommendation));
                    this.f19576f.setData(hVar.f57452e, 17, hVar.f57453f);
                    this.f19576f.setOnClickListener(new a(this, hVar));
                }
                if (this.f19578h.m != null) {
                    this.f19576f.setOnClickListenerOfRightBtn(this.f19578h.m);
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

    /* loaded from: classes4.dex */
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
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        i0(i2, view, viewGroup, hVar, pbFirstFloorItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: g0 */
    public PbFirstFloorItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f42341e);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            int g2 = l.g(this.f42341e, R.dimen.M_W_X007);
            int g3 = l.g(this.f42341e, R.dimen.T_X09);
            int g4 = l.g(this.f42341e, R.dimen.M_H_X005);
            int g5 = l.g(this.f42341e, R.dimen.M_H_X003);
            View view = new View(this.f42341e);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.g(this.f42341e, R.dimen.tbds1));
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = g2;
            linearLayout.addView(view, layoutParams);
            TextView textView = new TextView(this.f42341e);
            textView.setTextSize(0, g3);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = g2;
            layoutParams2.topMargin = g4;
            layoutParams2.bottomMargin = g5;
            linearLayout.addView(textView, layoutParams2);
            ItemCardView itemCardView = new ItemCardView(this.f42341e);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = g2;
            layoutParams3.rightMargin = g2;
            layoutParams3.bottomMargin = g4;
            itemCardView.setPosition(5);
            linearLayout.addView(itemCardView, layoutParams3);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setOnClickListenerOfRightBtn(new a(this));
            return new PbFirstFloorItemViewHolder(this, linearLayout);
        }
        return (PbFirstFloorItemViewHolder) invokeL.objValue;
    }

    public View i0(int i2, View view, ViewGroup viewGroup, h hVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, hVar, pbFirstFloorItemViewHolder})) == null) {
            if (hVar != null && hVar.f57452e != null) {
                pbFirstFloorItemViewHolder.c(hVar);
            }
            pbFirstFloorItemViewHolder.b();
            StatisticItem statisticItem = new StatisticItem("c14070");
            statisticItem.param("tid", hVar.f57453f);
            statisticItem.param("obj_locate", hVar.f57452e.item_id.longValue());
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
