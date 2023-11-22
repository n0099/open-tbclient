package com.baidu.tieba.immessagecenter.msgtab.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.e69;
import com.baidu.tieba.f69;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel;
import com.baidu.tieba.immessagecenter.arch.vm.IUiIntent;
import com.baidu.tieba.immessagecenter.arch.vm.IUiState;
import com.baidu.tieba.immessagecenter.msgtab.ui.adapter.MsgTabSideNavigationAdapter;
import com.baidu.tieba.uu4;
import com.baidu.tieba.y39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0016\u0010\u001d\u001a\u00020\u00142\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabSideNavigationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabSideNavigationAdapter$ViewHolder;", "activity", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "(Lcom/baidu/tbadk/core/BaseFragmentActivity;)V", "getActivity", "()Lcom/baidu/tbadk/core/BaseFragmentActivity;", "mBodyDataList", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "mItemClickListener", "Lcom/baidu/tbadk/callback/OnItemClickListener;", "getAllData", "getItem", CriusAttrConstants.POSITION, "", "getItemCount", "getItemViewType", "initBodyData", "", "list", "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnSelectedCallback", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "ViewHolder", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabSideNavigationAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity a;
    public final List<y39> b;
    public uu4<y39> c;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012.\u0010\u0002\u001a*\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0016\b\u0001\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR6\u0010\u0002\u001a*\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0016\b\u0001\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabSideNavigationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mItemView", "Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiState;", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiIntent;", "Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "(Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;)V", "bindData", "", "data", "Lcom/baidu/tieba/immessagecenter/msgtab/data/NavigationData;", "setOnClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BaseView<? extends IUiState, ? extends IUiIntent, ? extends BaseViewModel<? extends IUiState, ? extends IUiIntent>> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(BaseView<? extends IUiState, ? extends IUiIntent, ? extends BaseViewModel<? extends IUiState, ? extends IUiIntent>> mItemView) {
            super(mItemView.o());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mItemView};
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
            Intrinsics.checkNotNullParameter(mItemView, "mItemView");
            this.a = mItemView;
        }

        public final void a(y39 data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                BaseView<? extends IUiState, ? extends IUiIntent, ? extends BaseViewModel<? extends IUiState, ? extends IUiIntent>> baseView = this.a;
                if (baseView instanceof e69) {
                    ((e69) baseView).R(data);
                } else if (baseView instanceof f69) {
                    ((f69) baseView).R(data);
                }
            }
        }

        public final void b(View.OnClickListener clickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, clickListener) == null) {
                Intrinsics.checkNotNullParameter(clickListener, "clickListener");
                this.itemView.setOnClickListener(clickListener);
            }
        }
    }

    public MsgTabSideNavigationAdapter(BaseFragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.b = new ArrayList();
    }

    public static final void p(MsgTabSideNavigationAdapter this$0, y39 it, int i, View v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65537, null, this$0, it, i, v) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            Intrinsics.checkNotNullParameter(v, "v");
            uu4<y39> uu4Var = this$0.c;
            if (uu4Var != null) {
                uu4Var.b(v, it, i, 0L);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.size();
        }
        return invokeV.intValue;
    }

    public final List<y39> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return m(i).b();
        }
        return invokeI.intValue;
    }

    public final y39 m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return this.b.get(i);
        }
        return (y39) invokeI.objValue;
    }

    public final void n(List<y39> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public final void s(uu4<y39> uu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uu4Var) == null) {
            this.c = uu4Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(ViewHolder holder, final int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            final y39 m = m(i);
            holder.a(m);
            holder.b(new View.OnClickListener() { // from class: com.baidu.tieba.e49
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        MsgTabSideNavigationAdapter.p(MsgTabSideNavigationAdapter.this, m, i, view2);
                    }
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i != 1 && i != 2) {
                if (i == 3) {
                    e69 e69Var = new e69(this.a);
                    Context context = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                    BaseView.N(e69Var, context, parent, false, false, 8, null);
                    return new ViewHolder(e69Var);
                }
                throw new IllegalArgumentException("MsgTabLeftNavAdapter->onCreateViewHolder->" + i + " undefined !!!");
            }
            f69 f69Var = new f69(this.a);
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            BaseView.N(f69Var, context2, parent, false, false, 8, null);
            return new ViewHolder(f69Var);
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
