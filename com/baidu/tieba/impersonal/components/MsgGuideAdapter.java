package com.baidu.tieba.impersonal.components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewSingleClickCompat;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ae9;
import com.baidu.tieba.ee9;
import com.baidu.tieba.gq8;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.impersonal.data.BehaviorExt;
import com.baidu.tieba.impersonal.data.MsgGuideInfo;
import com.baidu.tieba.impersonal.databinding.ItemMsgGuideBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0001)B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u001aJ\u001c\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001aH\u0016J\u0012\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001aH\u0016J\u0016\u0010'\u001a\u00020\u001e2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0007R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0013@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/baidu/tieba/impersonal/components/MsgGuideAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/tieba/impersonal/components/MsgGuideAdapter$ViewHolder;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Lcom/baidu/tieba/impersonal/data/BehaviorExt;", "behaviorExt", "getBehaviorExt$im_personal_release", "()Lcom/baidu/tieba/impersonal/data/BehaviorExt;", "setBehaviorExt$im_personal_release", "(Lcom/baidu/tieba/impersonal/data/BehaviorExt;)V", "getContext", "()Landroid/content/Context;", "mAbilityList", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "processor", "getProcessor$im_personal_release", "()Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "setProcessor$im_personal_release", "(Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;)V", "getItemCount", "", "getItemData", CriusAttrConstants.POSITION, "onBindViewHolder", "", "holder", "onClick", "v", "Landroid/view/View;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "list", "ViewHolder", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgGuideAdapter extends RecyclerView.Adapter<ViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public List<AbilityItem> b;
    public gq8 c;
    public BehaviorExt d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/tieba/impersonal/components/MsgGuideAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/baidu/tieba/impersonal/databinding/ItemMsgGuideBinding;", "(Lcom/baidu/tieba/impersonal/components/MsgGuideAdapter;Lcom/baidu/tieba/impersonal/databinding/ItemMsgGuideBinding;)V", "curSkinType", "", "bindChild", "", "abilityItem", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "onChangeSkinType", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ItemMsgGuideBinding a;
        public int b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(MsgGuideAdapter msgGuideAdapter, ItemMsgGuideBinding binding) {
            super(binding.getRoot());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {msgGuideAdapter, binding};
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
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.a = binding;
            this.b = 3;
            onChangeSkinType();
        }

        public final void a(AbilityItem abilityItem) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, abilityItem) == null) {
                Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
                MsgGuideInfo a = ae9.a.a(abilityItem);
                TextView textView = this.a.c;
                String str3 = null;
                if (a != null) {
                    str = a.getContent();
                } else {
                    str = null;
                }
                textView.setText(str);
                if (a != null) {
                    str2 = a.getSubContent();
                } else {
                    str2 = null;
                }
                if (StringUtils.isNull(str2)) {
                    this.a.d.setVisibility(8);
                    return;
                }
                this.a.d.setVisibility(0);
                TextView textView2 = this.a.d;
                if (a != null) {
                    str3 = a.getSubContent();
                }
                textView2.setText(str3);
            }
        }

        public final void onChangeSkinType() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.b == SkinManager.getCurrentSkinType()) {
                return;
            }
            this.b = SkinManager.getCurrentSkinType();
            EMManager.from(this.a.getRoot()).setCorner(R.string.J_X05).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0212));
            EMManager.from(this.a.c).setTextStyle(R.string.F_X01);
            EMManager.from(this.a.d).setTextStyle(R.string.F_X01);
            WebPManager.setPureDrawable(this.a.e, R.drawable.obfuscated_res_0x7f080c0c, R.color.CAM_X0605, WebPManager.ResourceStateType.NORMAL);
        }
    }

    public MsgGuideAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(ViewHolder holder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            ViewSingleClickCompat.setOnClickListener(holder.itemView, this);
            holder.itemView.setTag(R.id.obfuscated_res_0x7f092379, Integer.valueOf(i));
            holder.itemView.setTag(R.id.obfuscated_res_0x7f092378, ListUtils.getItem(this.b, i));
            AbilityItem abilityItem = (AbilityItem) ListUtils.getItem(this.b, i);
            if (abilityItem != null) {
                Intrinsics.checkNotNullExpressionValue(abilityItem, "getItem(mAbilityList, position)");
                holder.a(abilityItem);
            }
            holder.onChangeSkinType();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ItemMsgGuideBinding c = ItemMsgGuideBinding.c(LayoutInflater.from(this.a), parent, false);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.f…(context), parent, false)");
            return new ViewHolder(this, c);
        }
        return (ViewHolder) invokeLI.objValue;
    }

    public final void o(BehaviorExt behaviorExt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, behaviorExt) == null) {
            this.d = behaviorExt;
        }
    }

    public final void p(gq8 gq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gq8Var) == null) {
            this.c = gq8Var;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(List<AbilityItem> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        AbilityItem abilityItem;
        gq8 gq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, view2) != null) || view2 == null) {
            return;
        }
        Object tag = view2.getTag(R.id.obfuscated_res_0x7f092378);
        if (tag != null) {
            abilityItem = (AbilityItem) tag;
        } else {
            abilityItem = null;
        }
        Object tag2 = view2.getTag(R.id.obfuscated_res_0x7f092379);
        if (tag2 != null) {
            ((Integer) tag2).intValue();
            if (abilityItem != null && (gq8Var = this.c) != null) {
                gq8Var.d(abilityItem, null, null);
            }
            ee9.b(TbadkCoreApplication.getCurrentAccount(), "2", this.d);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
