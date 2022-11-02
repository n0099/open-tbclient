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
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.view.itemcard.ItemCardHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.gx7;
import com.baidu.tieba.jn;
import com.baidu.tieba.sz4;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes5.dex */
public class PbFirstFloorItemAdapter extends jn<gx7, PbFirstFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener a;

    /* loaded from: classes5.dex */
    public class PbFirstFloorItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ItemCardView b;
        public View c;
        public final /* synthetic */ PbFirstFloorItemAdapter d;

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ gx7 a;
            public final /* synthetic */ PbFirstFloorItemViewHolder b;

            public a(PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder, gx7 gx7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pbFirstFloorItemViewHolder, gx7Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = pbFirstFloorItemViewHolder;
                this.a = gx7Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    int intValue = this.a.a.button_link_type.intValue();
                    ApkDetail apkDetail = this.a.a.apk_detail;
                    if (apkDetail != null) {
                        i = apkDetail.pkg_source.intValue();
                    } else {
                        i = 0;
                    }
                    int a = sz4.a(intValue, i);
                    ItemData itemData = new ItemData();
                    itemData.parseProto(this.a.a);
                    ItemCardHelper.q(this.b.b.getPosition(), this.a.a.item_id.longValue(), this.b.b.z(itemData), this.a.b, a, "", 2);
                    Item item = this.a.a;
                    ItemClickJumpUtil.itemClickJump(item.forum_name, String.valueOf(item.item_id), 9, 9);
                    StatisticItem statisticItem = new StatisticItem("c14071");
                    statisticItem.param("tid", this.a.b);
                    statisticItem.param("obj_locate", this.a.a.item_id.longValue());
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorItemViewHolder(PbFirstFloorItemAdapter pbFirstFloorItemAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorItemAdapter, view2};
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
            this.d = pbFirstFloorItemAdapter;
            ViewGroup viewGroup = (ViewGroup) view2;
            this.c = viewGroup.getChildAt(0);
            this.a = (TextView) viewGroup.getChildAt(1);
            this.b = (ItemCardView) viewGroup.getChildAt(2);
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0203);
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
                this.b.G();
            }
        }

        public void c(gx7 gx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gx7Var) == null) {
                if (gx7Var != null) {
                    this.a.setText(this.d.mContext.getText(R.string.obfuscated_res_0x7f0f100b));
                    ItemData itemData = new ItemData();
                    itemData.parseProto(gx7Var.a);
                    this.b.setData(itemData, 17, gx7Var.b);
                    this.b.setOnClickListener(new a(this, gx7Var));
                }
                if (this.d.a != null) {
                    this.b.setOnClickListenerOfRightBtn(this.d.a);
                }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001440, view2));
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
        this.a = null;
    }

    public void w(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.a = onClickListener;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.jn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, gx7 gx7Var, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        v(i, view2, viewGroup, gx7Var, pbFirstFloorItemViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: u */
    public PbFirstFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            int g = xi.g(this.mContext, R.dimen.M_W_X007);
            int g2 = xi.g(this.mContext, R.dimen.T_X09);
            int g3 = xi.g(this.mContext, R.dimen.M_H_X005);
            int g4 = xi.g(this.mContext, R.dimen.M_H_X003);
            View view2 = new View(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, xi.g(this.mContext, R.dimen.tbds1));
            layoutParams.leftMargin = g;
            layoutParams.rightMargin = g;
            linearLayout.addView(view2, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, g2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = g;
            layoutParams2.topMargin = g3;
            layoutParams2.bottomMargin = g4;
            linearLayout.addView(textView, layoutParams2);
            ItemCardView itemCardView = new ItemCardView(this.mContext);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = g;
            layoutParams3.rightMargin = g;
            layoutParams3.bottomMargin = g3;
            itemCardView.setPosition(5);
            linearLayout.addView(itemCardView, layoutParams3);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setOnClickListenerOfRightBtn(new a(this));
            return new PbFirstFloorItemViewHolder(this, linearLayout);
        }
        return (PbFirstFloorItemViewHolder) invokeL.objValue;
    }

    public View v(int i, View view2, ViewGroup viewGroup, gx7 gx7Var, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gx7Var, pbFirstFloorItemViewHolder})) == null) {
            if (gx7Var != null && gx7Var.a != null) {
                pbFirstFloorItemViewHolder.c(gx7Var);
            }
            pbFirstFloorItemViewHolder.b();
            StatisticItem statisticItem = new StatisticItem("c14070");
            statisticItem.param("tid", gx7Var.b);
            statisticItem.param("obj_locate", gx7Var.a.item_id.longValue());
            TiebaStatic.log(statisticItem);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
