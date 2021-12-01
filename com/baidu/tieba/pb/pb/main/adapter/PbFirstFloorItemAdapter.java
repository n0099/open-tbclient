package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.q0.s.g0.p.c;
import c.a.r0.q2.f;
import c.a.r0.q2.g;
import c.a.r0.q2.l;
import c.a.r0.q2.r.i;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes11.dex */
public class PbFirstFloorItemAdapter extends c.a.d.m.e.a<i, PbFirstFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener m;

    /* loaded from: classes11.dex */
    public class PbFirstFloorItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f47715e;

        /* renamed from: f  reason: collision with root package name */
        public ItemCardView f47716f;

        /* renamed from: g  reason: collision with root package name */
        public View f47717g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PbFirstFloorItemAdapter f47718h;

        /* loaded from: classes11.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ i f47719e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PbFirstFloorItemViewHolder f47720f;

            public a(PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder, i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pbFirstFloorItemViewHolder, iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f47720f = pbFirstFloorItemViewHolder;
                this.f47719e = iVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    int intValue = this.f47719e.f21534e.button_link_type.intValue();
                    ApkDetail apkDetail = this.f47719e.f21534e.apk_detail;
                    int a = c.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(this.f47719e.f21534e);
                    ItemCardHelper.q(this.f47720f.f47716f.getPosition(), this.f47719e.f21534e.item_id.longValue(), this.f47720f.f47716f.getButtonState(itemData), this.f47719e.f21535f, a, "", 2);
                    Item item = this.f47719e.f21534e;
                    ItemClickJumpUtil.itemClickJump(item.forum_name, String.valueOf(item.item_id), 9, 9);
                    StatisticItem statisticItem = new StatisticItem("c14071");
                    statisticItem.param("tid", this.f47719e.f21535f);
                    statisticItem.param("obj_locate", this.f47719e.f21534e.item_id.longValue());
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
            this.f47718h = pbFirstFloorItemAdapter;
            ViewGroup viewGroup = (ViewGroup) view;
            this.f47717g = viewGroup.getChildAt(0);
            this.f47715e = (TextView) viewGroup.getChildAt(1);
            this.f47716f = (ItemCardView) viewGroup.getChildAt(2);
        }

        public void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.f47717g, f.CAM_X0203);
                SkinManager.setViewTextColor(this.f47715e, f.CAM_X0109);
                this.f47716f.onChangeSkinType();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            }
        }

        public void setData(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
                if (iVar != null) {
                    this.f47715e.setText(this.f47718h.f2907e.getText(l.related_recommendation));
                    ItemData itemData = new ItemData();
                    itemData.parseProto(iVar.f21534e);
                    this.f47716f.setData(itemData, 17, iVar.f21535f);
                    this.f47716f.setOnClickListener(new a(this, iVar));
                }
                if (this.f47718h.m != null) {
                    this.f47716f.setOnClickListenerOfRightBtn(this.f47718h.m);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
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
    @Override // c.a.d.m.e.a
    public /* bridge */ /* synthetic */ View Z(int i2, View view, ViewGroup viewGroup, i iVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        j0(i2, view, viewGroup, iVar, pbFirstFloorItemViewHolder);
        return view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: i0 */
    public PbFirstFloorItemViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.f2907e);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            int f2 = c.a.d.f.p.l.f(this.f2907e, g.M_W_X007);
            int f3 = c.a.d.f.p.l.f(this.f2907e, g.T_X09);
            int f4 = c.a.d.f.p.l.f(this.f2907e, g.M_H_X005);
            int f5 = c.a.d.f.p.l.f(this.f2907e, g.M_H_X003);
            View view = new View(this.f2907e);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, c.a.d.f.p.l.f(this.f2907e, g.tbds1));
            layoutParams.leftMargin = f2;
            layoutParams.rightMargin = f2;
            linearLayout.addView(view, layoutParams);
            TextView textView = new TextView(this.f2907e);
            textView.setTextSize(0, f3);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = f2;
            layoutParams2.topMargin = f4;
            layoutParams2.bottomMargin = f5;
            linearLayout.addView(textView, layoutParams2);
            ItemCardView itemCardView = new ItemCardView(this.f2907e);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = f2;
            layoutParams3.rightMargin = f2;
            layoutParams3.bottomMargin = f4;
            itemCardView.setPosition(5);
            linearLayout.addView(itemCardView, layoutParams3);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setOnClickListenerOfRightBtn(new a(this));
            return new PbFirstFloorItemViewHolder(this, linearLayout);
        }
        return (PbFirstFloorItemViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, i iVar, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, iVar, pbFirstFloorItemViewHolder})) == null) {
            if (iVar != null && iVar.f21534e != null) {
                pbFirstFloorItemViewHolder.setData(iVar);
            }
            pbFirstFloorItemViewHolder.onChangeSkinType();
            StatisticItem statisticItem = new StatisticItem("c14070");
            statisticItem.param("tid", iVar.f21535f);
            statisticItem.param("obj_locate", iVar.f21534e.item_id.longValue());
            TiebaStatic.log(statisticItem);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }
}
