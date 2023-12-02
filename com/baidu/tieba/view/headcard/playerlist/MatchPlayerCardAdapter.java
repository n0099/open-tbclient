package com.baidu.tieba.view.headcard.playerlist;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mbb;
import com.baidu.tieba.view.headcard.playerlist.MatchPlayerCardAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0016J\u001c\u0010\u000f\u001a\u00020\n2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0014\u0010\u0016\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/view/headcard/playerlist/MatchPlayerCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/tieba/view/headcard/playerlist/MatchPlayerCardAdapter$ViewHolder;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mData", "", "Lcom/baidu/tieba/view/headcard/data/MatchPlayerInfoData;", "clickStatisticLog", "", "objType", "", "data", "getItemCount", "onBindViewHolder", "holder", CriusAttrConstants.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "ViewHolder", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MatchPlayerCardAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<mbb> b;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/baidu/tieba/view/headcard/playerlist/MatchPlayerCardAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mView", "Lcom/baidu/tieba/view/headcard/playerlist/PlayerCardView;", "(Lcom/baidu/tieba/view/headcard/playerlist/MatchPlayerCardAdapter;Lcom/baidu/tieba/view/headcard/playerlist/PlayerCardView;)V", "getMView", "()Lcom/baidu/tieba/view/headcard/playerlist/PlayerCardView;", "bindView", "", "data", "Lcom/baidu/tieba/view/headcard/data/MatchPlayerInfoData;", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final PlayerCardView a;
        public final /* synthetic */ MatchPlayerCardAdapter b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MatchPlayerCardAdapter matchPlayerCardAdapter, PlayerCardView mView) {
            super(mView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {matchPlayerCardAdapter, mView};
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
            Intrinsics.checkNotNullParameter(mView, "mView");
            this.b = matchPlayerCardAdapter;
            this.a = mView;
        }

        public static final void b(mbb data, MatchPlayerCardAdapter this$0, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65537, null, data, this$0, view2) == null) {
                Intrinsics.checkNotNullParameter(data, "$data");
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (!TextUtils.isEmpty(data.l())) {
                    BrowserHelper.startWebActivity(this$0.a, data.l());
                    this$0.o(4, data);
                }
            }
        }

        public final void a(final mbb data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.setData(data);
                PlayerCardView playerCardView = this.a;
                final MatchPlayerCardAdapter matchPlayerCardAdapter = this.b;
                playerCardView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.zbb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            MatchPlayerCardAdapter.ViewHolder.b(mbb.this, matchPlayerCardAdapter, view2);
                        }
                    }
                });
            }
        }
    }

    public MatchPlayerCardAdapter(Context mContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.a = mContext;
    }

    public final void setData(List<mbb> data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.b = data;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<mbb> list = this.b;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                list = null;
            }
            return ListUtils.getCount(list);
        }
        return invokeV.intValue;
    }

    public final void o(int i, mbb mbbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mbbVar) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_COLLECT_COVER_CLICK);
            statisticItem.param("obj_type", i);
            statisticItem.addParam("obj_locate", mbbVar.n());
            statisticItem.addParam("obj_source", mbbVar.h());
            statisticItem.addParam("fid", mbbVar.b());
            statisticItem.addParam("fname", mbbVar.c());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onBindViewHolder(ViewHolder holder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            List<mbb> list = this.b;
            List<mbb> list2 = null;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
                list = null;
            }
            if (list.size() <= i) {
                return;
            }
            List<mbb> list3 = this.b;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mData");
            } else {
                list2 = list3;
            }
            holder.a(list2.get(i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return new ViewHolder(this, new PlayerCardView(this.a, null, 0, 6, null));
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
