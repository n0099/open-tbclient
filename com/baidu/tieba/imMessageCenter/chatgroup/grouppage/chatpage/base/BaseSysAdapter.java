package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysMsg;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.mh7;
import com.baidu.tieba.qh7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class BaseSysAdapter<ChildItemData extends BaseSysMsg, ChildViewHolder extends BaseViewHolder> extends mh7<ChildItemData, Holder<ChildViewHolder>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public abstract View B(int i, @NonNull ViewGroup viewGroup, @NonNull ChildItemData childitemdata, @NonNull ChildViewHolder childviewholder, @NonNull List<Object> list, int i2);

    @NonNull
    public abstract ChildViewHolder z(@NonNull ViewGroup viewGroup);

    /* loaded from: classes4.dex */
    public static class Holder<ChildViewHolder extends BaseViewHolder> extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ChildViewHolder a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(@NonNull View view2, @NonNull ChildViewHolder childviewholder) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, childviewholder};
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
            c(this);
            this.a = childviewholder;
            childviewholder.c(this);
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                super.a(onClickListener);
                this.a.a(onClickListener);
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void b(@Nullable View.OnLongClickListener onLongClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
                super.b(onLongClickListener);
                this.a.b(onLongClickListener);
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void d(@NonNull qh7 qh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qh7Var) == null) {
                super.d(qh7Var);
                this.a.d(qh7Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseSysAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: A */
    public final Holder<ChildViewHolder> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            Holder<ChildViewHolder> holder = new Holder<>(frameLayout, z(frameLayout));
            y(holder);
            return holder;
        }
        return (Holder) invokeL.objValue;
    }

    public final View C(int i, View view2, ViewGroup viewGroup, ChildItemData childitemdata, Holder<ChildViewHolder> holder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, childitemdata, holder})) == null) {
            onFillViewHolder(i, viewGroup, holder, childitemdata, Collections.EMPTY_LIST);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: D */
    public void onFillViewHolder(int i, ViewGroup viewGroup, Holder<ChildViewHolder> holder, ChildItemData childitemdata, @NonNull List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), viewGroup, holder, childitemdata, list}) == null) {
            super.onFillViewHolder(i, viewGroup, (ViewGroup) holder, (Holder<ChildViewHolder>) childitemdata, list);
            View B = B(i, viewGroup, childitemdata, holder.a, list, TbadkCoreApplication.getInst().getSkinType());
            if (B.getParent() == null) {
                ((ViewGroup) holder.getView()).addView(B);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter<ChildItemData extends com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysMsg, ChildViewHolder extends com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        C(i, view2, viewGroup, (BaseSysMsg) obj, (Holder) viewHolder);
        return view2;
    }
}
