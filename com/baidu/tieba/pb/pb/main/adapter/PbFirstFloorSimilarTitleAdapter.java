package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.fc9;
import com.baidu.tieba.jn;
import com.baidu.tieba.o49;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorSimilarTitleAdapter;
import com.baidu.tieba.pb.pb.main.view.SimilarTitleView;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0014B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0014J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u00060\u0003R\u00020\u0000H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorSimilarTitleAdapter;", "Lcom/baidu/adp/widget/ListView/AbsDelegateAdapter;", "Lcom/baidu/tieba/pb/data/PbFirstFloorSimilarTitleData;", "Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorSimilarTitleAdapter$PbFirstFloorSimilarTitleViewHolder;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "type", "Lcom/baidu/adp/BdUniqueId;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/adp/BdUniqueId;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onFillViewHolder", "Landroid/view/View;", CriusAttrConstants.POSITION, "", "convertView", "data", "viewHolder", "PbFirstFloorSimilarTitleViewHolder", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PbFirstFloorSimilarTitleAdapter extends jn<o49, PbFirstFloorSimilarTitleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> a;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorSimilarTitleAdapter$PbFirstFloorSimilarTitleViewHolder;", "Lcom/baidu/adp/widget/ListView/TypeAdapter$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/baidu/tieba/pb/pb/main/adapter/PbFirstFloorSimilarTitleAdapter;Landroid/view/View;)V", "divider", "similarTitleView", "Lcom/baidu/tieba/pb/pb/main/view/SimilarTitleView;", "onChangeSkinType", "", "setData", "data", "Lcom/baidu/tieba/pb/data/PbFirstFloorSimilarTitleData;", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public final class PbFirstFloorSimilarTitleViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View a;
        public final SimilarTitleView b;
        public final View c;
        public final /* synthetic */ PbFirstFloorSimilarTitleAdapter d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorSimilarTitleViewHolder(PbFirstFloorSimilarTitleAdapter pbFirstFloorSimilarTitleAdapter, View v) {
            super(v);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbFirstFloorSimilarTitleAdapter, v};
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
            this.d = pbFirstFloorSimilarTitleAdapter;
            this.a = v;
            View childAt = ((ViewGroup) v).getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "v as ViewGroup).getChildAt(0)");
            this.c = childAt;
            View childAt2 = ((ViewGroup) this.a).getChildAt(1);
            if (childAt2 != null) {
                this.b = (SimilarTitleView) childAt2;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.pb.pb.main.view.SimilarTitleView");
        }

        public static final void c(o49 o49Var, PbFirstFloorSimilarTitleAdapter this$0, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, o49Var, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (o49Var != null) {
                    UrlManager.getInstance().dealOneLink(o49Var.getUrl());
                }
                fc9.n(o49Var, 1, this$0.a, "2");
            }
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0204);
                this.b.a();
            }
        }

        public final void b(final o49 o49Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o49Var) == null) {
                SimilarTitleView similarTitleView = this.b;
                CharSequence text = this.d.mContext.getText(R.string.obfuscated_res_0x7f0f0f9a);
                Intrinsics.checkNotNullExpressionValue(text, "mContext.getText(R.strin…st_floor_similar_content)");
                similarTitleView.setTitle(text);
                if (o49Var != null) {
                    this.b.setTags(o49Var.J());
                }
                SimilarTitleView similarTitleView2 = this.b;
                final PbFirstFloorSimilarTitleAdapter pbFirstFloorSimilarTitleAdapter = this.d;
                similarTitleView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.a99
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            PbFirstFloorSimilarTitleAdapter.PbFirstFloorSimilarTitleViewHolder.c(o49.this, pbFirstFloorSimilarTitleAdapter, view2);
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbFirstFloorSimilarTitleAdapter(TbPageContext<BaseFragmentActivity> pageContext, BdUniqueId bdUniqueId) {
        super(pageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, bdUniqueId};
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
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.a = pageContext;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.jn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, o49 o49Var, PbFirstFloorSimilarTitleViewHolder pbFirstFloorSimilarTitleViewHolder) {
        x(i, view2, viewGroup, o49Var, pbFirstFloorSimilarTitleViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: u */
    public PbFirstFloorSimilarTitleViewHolder onCreateViewHolder(ViewGroup parent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, parent)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            LinearLayout linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            linearLayout.addView(new View(this.mContext), new LinearLayout.LayoutParams(-1, wi.g(this.mContext, R.dimen.tbds16)));
            Context mContext = this.mContext;
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            linearLayout.addView(new SimilarTitleView(mContext, null, 0, 6, null), new LinearLayout.LayoutParams(-1, -2));
            return new PbFirstFloorSimilarTitleViewHolder(this, linearLayout);
        }
        return (PbFirstFloorSimilarTitleViewHolder) invokeL.objValue;
    }

    public View x(int i, View convertView, ViewGroup parent, o49 o49Var, PbFirstFloorSimilarTitleViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), convertView, parent, o49Var, viewHolder})) == null) {
            Intrinsics.checkNotNullParameter(convertView, "convertView");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (o49Var != null) {
                viewHolder.b(o49Var);
            }
            viewHolder.a();
            return convertView;
        }
        return (View) invokeCommon.objValue;
    }
}
