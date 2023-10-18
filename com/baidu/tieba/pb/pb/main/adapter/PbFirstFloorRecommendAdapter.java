package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.core.widget.recommendcard.RecommendCardView;
import com.baidu.tieba.lh;
import com.baidu.tieba.pb.data.PbFirstFloorRecommendData;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorRecommendAdapter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00172\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0017\u0018B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002J\u0014\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u00022\n\u0010\u0016\u001a\u00060\u0003R\u00020\u0000H\u0014¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorRecommendAdapter;", "Lcom/baidu/adp/widget/ListView/AbsDelegateAdapter;", "Lcom/baidu/tieba/pb/data/PbFirstFloorRecommendData;", "Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorRecommendAdapter$PbFirstFloorRecommendViewHolder;", "context", "Landroid/content/Context;", "type", "Lcom/baidu/adp/BdUniqueId;", "(Landroid/content/Context;Lcom/baidu/adp/BdUniqueId;)V", "eventStat", "", "statisticItem", "Lcom/baidu/tbadk/core/util/StatisticItem;", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onFillViewHolder", "Landroid/view/View;", CriusAttrConstants.POSITION, "", "convertView", "viewHolder", "Companion", "PbFirstFloorRecommendViewHolder", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PbFirstFloorRecommendAdapter extends lh<PbFirstFloorRecommendData, PbFirstFloorRecommendViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1368993906, "Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorRecommendAdapter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1368993906, "Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorRecommendAdapter;");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorRecommendAdapter$PbFirstFloorRecommendViewHolder;", "Lcom/baidu/adp/widget/ListView/TypeAdapter$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorRecommendAdapter;Landroid/view/View;)V", "divider", "recommendCardView", "Lcom/baidu/tieba/core/widget/recommendcard/RecommendCardView;", "textView", "Landroid/widget/TextView;", "onChangeSkinType", "", "setData", "data", "Lcom/baidu/tieba/pb/data/PbFirstFloorRecommendData;", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public final class PbFirstFloorRecommendViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final RecommendCardView b;
        public final View c;
        public final /* synthetic */ PbFirstFloorRecommendAdapter d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorRecommendViewHolder(PbFirstFloorRecommendAdapter pbFirstFloorRecommendAdapter, View v) {
            super(v);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorRecommendAdapter, v};
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
            Intrinsics.checkNotNullParameter(v, "v");
            this.d = pbFirstFloorRecommendAdapter;
            ViewGroup viewGroup = (ViewGroup) v;
            View childAt = viewGroup.getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "v as ViewGroup).getChildAt(0)");
            this.c = childAt;
            View childAt2 = viewGroup.getChildAt(1);
            if (childAt2 != null) {
                this.a = (TextView) childAt2;
                View childAt3 = viewGroup.getChildAt(2);
                if (childAt3 != null) {
                    this.b = (RecommendCardView) childAt3;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.core.widget.recommendcard.RecommendCardView");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }

        public static final void b(PbFirstFloorRecommendData pbFirstFloorRecommendData, PbFirstFloorRecommendAdapter this$0, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, pbFirstFloorRecommendData, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (!TextUtils.isEmpty(pbFirstFloorRecommendData.d().card_scheme)) {
                    UrlManager.getInstance().dealOneLink(pbFirstFloorRecommendData.d().card_scheme);
                }
                StatisticItem param = new StatisticItem("c14071").param(TiebaStatic.Params.OBJ_PARAM2, 1);
                Intrinsics.checkNotNullExpressionValue(param, "StatisticItem(PbStatisti…_PARAM2, CLICK_ROOT_AREA)");
                this$0.t(param, pbFirstFloorRecommendData);
            }
        }

        public static final void c(PbFirstFloorRecommendData pbFirstFloorRecommendData, PbFirstFloorRecommendAdapter this$0, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65538, null, pbFirstFloorRecommendData, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (!TextUtils.isEmpty(pbFirstFloorRecommendData.d().button_scheme)) {
                    UrlManager.getInstance().dealOneLink(pbFirstFloorRecommendData.d().button_scheme);
                }
                StatisticItem param = new StatisticItem("c14071").param(TiebaStatic.Params.OBJ_PARAM2, 1);
                Intrinsics.checkNotNullExpressionValue(param, "StatisticItem(PbStatisti…_PARAM2, CLICK_ROOT_AREA)");
                this$0.t(param, pbFirstFloorRecommendData);
            }
        }

        public static final void d(PbFirstFloorRecommendData pbFirstFloorRecommendData, PbFirstFloorRecommendAdapter this$0, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65539, null, pbFirstFloorRecommendData, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (!TextUtils.isEmpty(pbFirstFloorRecommendData.d().bottom_scheme)) {
                    UrlManager.getInstance().dealOneLink(pbFirstFloorRecommendData.d().bottom_scheme);
                }
                StatisticItem param = new StatisticItem("c14071").param(TiebaStatic.Params.OBJ_PARAM2, 2);
                Intrinsics.checkNotNullExpressionValue(param, "StatisticItem(PbStatisti…, CLICK_LEFT_BOTTOM_AREA)");
                this$0.t(param, pbFirstFloorRecommendData);
            }
        }

        public final void a(final PbFirstFloorRecommendData pbFirstFloorRecommendData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, pbFirstFloorRecommendData) != null) || pbFirstFloorRecommendData == null) {
                return;
            }
            this.a.setText(this.d.mContext.getText(R.string.related_recommendation));
            RecommendCardView recommendCardView = this.b;
            final PbFirstFloorRecommendAdapter pbFirstFloorRecommendAdapter = this.d;
            recommendCardView.setRootOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lk9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PbFirstFloorRecommendAdapter.PbFirstFloorRecommendViewHolder.b(PbFirstFloorRecommendData.this, pbFirstFloorRecommendAdapter, view2);
                    }
                }
            });
            RecommendCardView recommendCardView2 = this.b;
            final PbFirstFloorRecommendAdapter pbFirstFloorRecommendAdapter2 = this.d;
            recommendCardView2.setRightButtonOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.nk9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PbFirstFloorRecommendAdapter.PbFirstFloorRecommendViewHolder.c(PbFirstFloorRecommendData.this, pbFirstFloorRecommendAdapter2, view2);
                    }
                }
            });
            RecommendCardView recommendCardView3 = this.b;
            final PbFirstFloorRecommendAdapter pbFirstFloorRecommendAdapter3 = this.d;
            recommendCardView3.setBottomGroupOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ok9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        PbFirstFloorRecommendAdapter.PbFirstFloorRecommendViewHolder.d(PbFirstFloorRecommendData.this, pbFirstFloorRecommendAdapter3, view2);
                    }
                }
            });
            this.b.a(pbFirstFloorRecommendData.c());
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0203);
                SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorRecommendAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.lh
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, PbFirstFloorRecommendData pbFirstFloorRecommendData, PbFirstFloorRecommendViewHolder pbFirstFloorRecommendViewHolder) {
        x(i, view2, viewGroup, pbFirstFloorRecommendData, pbFirstFloorRecommendViewHolder);
        return view2;
    }

    public final void t(StatisticItem statisticItem, PbFirstFloorRecommendData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, data) == null) {
            Intrinsics.checkNotNullParameter(statisticItem, "statisticItem");
            Intrinsics.checkNotNullParameter(data, "data");
            statisticItem.param("tid", data.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", data.d().title).param("obj_param1", 6).param("objType", 2).eventStat();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: u */
    public PbFirstFloorRecommendViewHolder onCreateViewHolder(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            int dimens = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            int dimens2 = BdUtilHelper.getDimens(this.mContext, R.dimen.T_X09);
            int dimens3 = BdUtilHelper.getDimens(this.mContext, R.dimen.M_H_X005);
            int dimens4 = BdUtilHelper.getDimens(this.mContext, R.dimen.M_H_X003);
            View view2 = new View(this.mContext);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(this.mContext, R.dimen.tbds1));
            layoutParams.leftMargin = dimens;
            layoutParams.rightMargin = dimens;
            linearLayout.addView(view2, layoutParams);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(0, dimens2);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.leftMargin = dimens;
            layoutParams2.topMargin = dimens3;
            layoutParams2.bottomMargin = dimens4;
            linearLayout.addView(textView, layoutParams2);
            Context mContext = this.mContext;
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            RecommendCardView recommendCardView = new RecommendCardView(mContext, null, 0, 6, null);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = dimens;
            layoutParams3.rightMargin = dimens;
            layoutParams3.bottomMargin = dimens3;
            linearLayout.addView(recommendCardView, layoutParams3);
            return new PbFirstFloorRecommendViewHolder(this, linearLayout);
        }
        return (PbFirstFloorRecommendViewHolder) invokeL.objValue;
    }

    public View x(int i, View convertView, ViewGroup parent, PbFirstFloorRecommendData pbFirstFloorRecommendData, PbFirstFloorRecommendViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), convertView, parent, pbFirstFloorRecommendData, viewHolder})) == null) {
            Intrinsics.checkNotNullParameter(convertView, "convertView");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (pbFirstFloorRecommendData != null) {
                viewHolder.a(pbFirstFloorRecommendData);
                t(new StatisticItem("c14070"), pbFirstFloorRecommendData);
            }
            viewHolder.onChangeSkinType();
            return convertView;
        }
        return (View) invokeCommon.objValue;
    }
}
