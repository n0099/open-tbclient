package com.baidu.tieba.immessagecenter.msgtab.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tieba.ag8;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.arch.vm.BaseViewModel;
import com.baidu.tieba.immessagecenter.arch.vm.IUiIntent;
import com.baidu.tieba.immessagecenter.arch.vm.IUiState;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabInteractNotifyItemView;
import com.baidu.tieba.mp8;
import com.baidu.tieba.sr8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J.\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000e2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabNotifyItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabNotifyItemAdapter$ViewHolder;", "mFragment", "Lcom/baidu/tbadk/core/BaseFragment;", "(Lcom/baidu/tbadk/core/BaseFragment;)V", "mInteractNotifyList", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgNotifyData;", "mSystemNotifyList", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "filterSystemNotifyList", "", "getItemCount", "", "type", "getItemViewType", CriusAttrConstants.POSITION, "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "headerViewsCount", "interactNotifyList", "sysNotifyList", "Companion", "ViewHolder", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabNotifyItemAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public final List<mp8> b;
    public final List<ImMessageCenterShowItemData> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-445300351, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabNotifyItemAdapter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-445300351, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabNotifyItemAdapter;");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012.\u0010\u0002\u001a*\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0016\b\u0001\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fR6\u0010\u0002\u001a*\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u0005\u0012\u0016\b\u0001\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020\u00050\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/adapter/MsgTabNotifyItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mItemView", "Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiState;", "Lcom/baidu/tieba/immessagecenter/arch/vm/IUiIntent;", "Lcom/baidu/tieba/immessagecenter/arch/vm/BaseViewModel;", "(Lcom/baidu/tieba/immessagecenter/arch/view/BaseView;)V", "bindData", "", "data", "Lcom/baidu/tbadk/core/data/ImMessageCenterShowItemData;", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgNotifyData;", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BaseView<? extends IUiState, ? extends IUiIntent, ? extends BaseViewModel<? extends IUiState, ? extends IUiIntent>> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(BaseView<? extends IUiState, ? extends IUiIntent, ? extends BaseViewModel<? extends IUiState, ? extends IUiIntent>> mItemView) {
            super(mItemView.m());
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

        public final void b(ImMessageCenterShowItemData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                BaseView<? extends IUiState, ? extends IUiIntent, ? extends BaseViewModel<? extends IUiState, ? extends IUiIntent>> baseView = this.a;
                if (baseView instanceof sr8) {
                    ((sr8) baseView).Q(data);
                }
            }
        }

        public final void c(mp8 data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                BaseView<? extends IUiState, ? extends IUiIntent, ? extends BaseViewModel<? extends IUiState, ? extends IUiIntent>> baseView = this.a;
                if (baseView instanceof MsgTabInteractNotifyItemView) {
                    ((MsgTabInteractNotifyItemView) baseView).Q(data);
                }
            }
        }
    }

    public MsgTabNotifyItemAdapter(BaseFragment mFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mFragment, "mFragment");
        this.a = mFragment;
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return m(0) + m(1);
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < this.b.size()) {
                return 0;
            }
            return 1;
        }
        return invokeI.intValue;
    }

    public final int m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    return 0;
                }
                return this.c.size();
            }
            return this.b.size();
        }
        return invokeI.intValue;
    }

    public final List<ImMessageCenterShowItemData> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ArrayList arrayList = new ArrayList();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!this.c.isEmpty()) {
                for (ImMessageCenterShowItemData imMessageCenterShowItemData : this.c) {
                    String friendNameShow = imMessageCenterShowItemData.getFriendNameShow();
                    Intrinsics.checkNotNullExpressionValue(friendNameShow, "item.friendNameShow");
                    linkedHashMap.put(friendNameShow, imMessageCenterShowItemData);
                }
                arrayList.addAll(linkedHashMap.values());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(ViewHolder holder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    holder.b(l().get(i - m(0)));
                    return;
                }
                return;
            }
            holder.c(this.b.get(i));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (i != 0) {
                if (i == 1) {
                    sr8 sr8Var = new sr8(this.a);
                    Context context = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                    BaseView.M(sr8Var, context, parent, false, false, 8, null);
                    return new ViewHolder(sr8Var);
                }
                throw new IllegalStateException("MsgNotifyTabComItemAdapter exception");
            }
            MsgTabInteractNotifyItemView msgTabInteractNotifyItemView = new MsgTabInteractNotifyItemView(this.a);
            Context context2 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
            BaseView.M(msgTabInteractNotifyItemView, context2, parent, false, false, 8, null);
            return new ViewHolder(msgTabInteractNotifyItemView);
        }
        return (ViewHolder) invokeLI.objValue;
    }

    public final void p(int i, List<mp8> list, List<? extends ImMessageCenterShowItemData> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, list, list2) == null) {
            if (list != null) {
                if (!(!list.isEmpty())) {
                    list = null;
                }
                if (list != null && ag8.a.b(list, this.b)) {
                    this.b.clear();
                    this.b.addAll(list);
                    notifyItemRangeChanged(i, list.size());
                }
            }
            if (list2 != null) {
                if (!(!list2.isEmpty())) {
                    list2 = null;
                }
                if (list2 != null) {
                    this.c.clear();
                    this.c.addAll(list2);
                    notifyItemRangeChanged(RangesKt___RangesKt.coerceAtLeast(0, this.b.size() + i), list2.size());
                }
            }
        }
    }
}
