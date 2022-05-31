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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.li;
import com.repackage.np7;
import com.repackage.wm;
import com.repackage.xt4;
import tbclient.ApkDetail;
import tbclient.Item;
/* loaded from: classes3.dex */
public class PbFirstFloorItemAdapter extends wm<np7, PbFirstFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener i;

    /* loaded from: classes3.dex */
    public class PbFirstFloorItemViewHolder extends TypeAdapter.ViewHolder implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public ItemCardView b;
        public View c;
        public final /* synthetic */ PbFirstFloorItemAdapter d;

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ np7 a;
            public final /* synthetic */ PbFirstFloorItemViewHolder b;

            public a(PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder, np7 np7Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {pbFirstFloorItemViewHolder, np7Var};
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
                this.a = np7Var;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    int intValue = this.a.a.button_link_type.intValue();
                    ApkDetail apkDetail = this.a.a.apk_detail;
                    int a = xt4.a(intValue, apkDetail != null ? apkDetail.pkg_source.intValue() : 0);
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

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0203);
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
                this.b.G();
            }
        }

        public void e(np7 np7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, np7Var) == null) {
                if (np7Var != null) {
                    this.a.setText(this.d.a.getText(R.string.obfuscated_res_0x7f0f0f99));
                    ItemData itemData = new ItemData();
                    itemData.parseProto(np7Var.a);
                    this.b.setData(itemData, 17, np7Var.b);
                    this.b.setOnClickListener(new a(this, np7Var));
                }
                if (this.d.i != null) {
                    this.b.setOnClickListenerOfRightBtn(this.d.i);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.i = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, np7 np7Var, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        c0(i, view2, viewGroup, np7Var, pbFirstFloorItemViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public PbFirstFloorItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            int f = li.f(this.a, R.dimen.M_W_X007);
            int f2 = li.f(this.a, R.dimen.T_X09);
            int f3 = li.f(this.a, R.dimen.M_H_X005);
            int f4 = li.f(this.a, R.dimen.M_H_X003);
            View view2 = new View(this.a);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, li.f(this.a, R.dimen.tbds1));
            layoutParams.leftMargin = f;
            layoutParams.rightMargin = f;
            linearLayout.addView(view2, layoutParams);
            TextView textView = new TextView(this.a);
            textView.setTextSize(0, f2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = f;
            layoutParams2.topMargin = f3;
            layoutParams2.bottomMargin = f4;
            linearLayout.addView(textView, layoutParams2);
            ItemCardView itemCardView = new ItemCardView(this.a);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = f;
            layoutParams3.rightMargin = f;
            layoutParams3.bottomMargin = f3;
            itemCardView.setPosition(5);
            linearLayout.addView(itemCardView, layoutParams3);
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setOnClickListenerOfRightBtn(new a(this));
            return new PbFirstFloorItemViewHolder(this, linearLayout);
        }
        return (PbFirstFloorItemViewHolder) invokeL.objValue;
    }

    public View c0(int i, View view2, ViewGroup viewGroup, np7 np7Var, PbFirstFloorItemViewHolder pbFirstFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, np7Var, pbFirstFloorItemViewHolder})) == null) {
            if (np7Var != null && np7Var.a != null) {
                pbFirstFloorItemViewHolder.e(np7Var);
            }
            pbFirstFloorItemViewHolder.d();
            StatisticItem statisticItem = new StatisticItem("c14070");
            statisticItem.param("tid", np7Var.b);
            statisticItem.param("obj_locate", np7Var.a.item_id.longValue());
            TiebaStatic.log(statisticItem);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
            this.i = onClickListener;
        }
    }
}
