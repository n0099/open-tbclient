package com.baidu.tieba.im.under.common.uiliststyle.group.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.uilist.BaseSysAdapter;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.SubscribeSysItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class SubscribeAdapter extends BaseSysAdapter<SubscribeSysItem, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean l;

    /* loaded from: classes6.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final TextView b;
        public final LinearLayout c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Holder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.c = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0925a3);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09231d);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0924d7);
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                super.a(onClickListener);
                this.b.setOnClickListener(onClickListener);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscribeAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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
        this.l = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseSysAdapter
    @NonNull
    /* renamed from: Q */
    public Holder L(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0910, viewGroup, false));
        }
        return (Holder) invokeL.objValue;
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.l = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseSysAdapter
    @SuppressLint({"SetTextI18n"})
    /* renamed from: R */
    public void N(int i, @NonNull ViewGroup viewGroup, @NonNull SubscribeSysItem subscribeSysItem, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), viewGroup, subscribeSysItem, holder, list, Integer.valueOf(i2)}) == null) {
            EMManager.from(holder.c).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0625);
            EMManager from = EMManager.from(holder.a);
            int i3 = R.color.CAM_X0101;
            from.setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X09);
            EMManager textSize = EMManager.from(holder.b).setTextSize(R.dimen.T_X09);
            if (!this.l) {
                i3 = R.color.CAM_X0304;
            }
            textSize.setTextColor(i3).setTextStyle(R.string.F_X01);
            holder.b.setText(R.string.obfuscated_res_0x7f0f14b8);
            TextView textView = holder.a;
            textView.setText(subscribeSysItem.getTbMsg().getSubscribeTips() + C().getString(R.string.obfuscated_res_0x7f0f14b9));
        }
    }
}
