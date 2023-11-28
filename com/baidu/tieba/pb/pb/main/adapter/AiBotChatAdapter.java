package com.baidu.tieba.pb.pb.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.AiBotChatCardView;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tieba.R;
import com.baidu.tieba.ci;
import com.baidu.tieba.jw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0013B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00060\u0003R\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J6\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\u0010\u0012\u001a\u00060\u0003R\u00020\u0000H\u0014¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/adapter/AiBotChatAdapter;", "Lcom/baidu/adp/widget/ListView/AbsDelegateAdapter;", "Lcom/baidu/tbadk/core/data/AiBotChatData;", "Lcom/baidu/tieba/pb/pb/main/adapter/AiBotChatAdapter$PbFirstFloorAiBotChatViewHolder;", "context", "Landroid/content/Context;", "type", "Lcom/baidu/adp/BdUniqueId;", "(Landroid/content/Context;Lcom/baidu/adp/BdUniqueId;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onFillViewHolder", "Landroid/view/View;", CriusAttrConstants.POSITION, "", "convertView", "data", "viewHolder", "PbFirstFloorAiBotChatViewHolder", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AiBotChatAdapter extends ci<jw4, PbFirstFloorAiBotChatViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/tieba/pb/pb/main/adapter/AiBotChatAdapter$PbFirstFloorAiBotChatViewHolder;", "Lcom/baidu/adp/widget/ListView/TypeAdapter$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/baidu/tieba/pb/pb/main/adapter/AiBotChatAdapter;Landroid/view/View;)V", "aiBotChatCardView", "Lcom/baidu/card/view/AiBotChatCardView;", CommonTbJsBridge.CHANGE_SKIN_TYPE, "", "setData", "data", "Lcom/baidu/tbadk/core/data/AiBotChatData;", "pb_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public final class PbFirstFloorAiBotChatViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public AiBotChatCardView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PbFirstFloorAiBotChatViewHolder(AiBotChatAdapter aiBotChatAdapter, View v) {
            super(v);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aiBotChatAdapter, v};
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
            View childAt = ((ViewGroup) v).getChildAt(0);
            if (childAt != null) {
                this.a = (AiBotChatCardView) childAt;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.card.view.AiBotChatCardView");
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        public final void b(jw4 jw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jw4Var) != null) || jw4Var == null) {
                return;
            }
            this.a.setData(jw4Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiBotChatAdapter(Context context, BdUniqueId bdUniqueId) {
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
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ci
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, jw4 jw4Var, PbFirstFloorAiBotChatViewHolder pbFirstFloorAiBotChatViewHolder) {
        u(i, view2, viewGroup, jw4Var, pbFirstFloorAiBotChatViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: t */
    public PbFirstFloorAiBotChatViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            frameLayout.setClipChildren(false);
            int dimens = BdUtilHelper.getDimens(this.mContext, R.dimen.M_W_X007);
            int dimens2 = BdUtilHelper.getDimens(this.mContext, R.dimen.tbds24);
            Context mContext = this.mContext;
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            AiBotChatCardView aiBotChatCardView = new AiBotChatCardView(mContext, null, 2, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = dimens;
            layoutParams.rightMargin = dimens;
            layoutParams.topMargin = dimens2;
            frameLayout.addView(aiBotChatCardView, layoutParams);
            return new PbFirstFloorAiBotChatViewHolder(this, frameLayout);
        }
        return (PbFirstFloorAiBotChatViewHolder) invokeL.objValue;
    }

    public View u(int i, View convertView, ViewGroup parent, jw4 jw4Var, PbFirstFloorAiBotChatViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), convertView, parent, jw4Var, viewHolder})) == null) {
            Intrinsics.checkNotNullParameter(convertView, "convertView");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            if (jw4Var != null) {
                viewHolder.b(jw4Var);
            }
            viewHolder.a();
            return convertView;
        }
        return (View) invokeCommon.objValue;
    }
}
