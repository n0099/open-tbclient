package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.RecallSysMsg;
import com.baidu.tieba.rw4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class RecallAdapter extends BaseSysAdapter<RecallSysMsg, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long f;
    public long g;

    /* loaded from: classes4.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinearLayout a;
        public final TextView b;
        public final TextView c;
        public final TextView d;

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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091c22);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ed7);
            this.c = (TextView) view2.findViewById(R.id.user_name);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092578);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecallAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter
    @NonNull
    /* renamed from: E */
    public Holder z(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01d8, viewGroup, false));
        }
        return (Holder) invokeL.objValue;
    }

    public void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.f = j;
        }
    }

    public void H(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.g = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter
    @NonNull
    /* renamed from: F */
    public View B(int i, @NonNull ViewGroup viewGroup, @NonNull RecallSysMsg recallSysMsg, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, recallSysMsg, holder, list, Integer.valueOf(i2)})) == null) {
            rw4 d = rw4.d(holder.a);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0603);
            rw4 d2 = rw4.d(holder.b);
            d2.v(R.color.CAM_X0101);
            d2.z(R.dimen.T_X09);
            d2.A(R.string.F_X01);
            rw4 d3 = rw4.d(holder.c);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X09);
            d3.A(R.string.F_X01);
            rw4 d4 = rw4.d(holder.d);
            d4.v(R.color.CAM_X0101);
            d4.z(R.dimen.T_X09);
            d4.A(R.string.F_X01);
            if (recallSysMsg != null && recallSysMsg.getUserTo() != null && recallSysMsg.getUserFrom() != null) {
                if (String.valueOf(recallSysMsg.getUserTo().getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                    int role = recallSysMsg.getUserFrom().getRole();
                    if (role == 2) {
                        holder.b.setText(R.string.obfuscated_res_0x7f0f0832);
                    } else if (role == 1) {
                        holder.b.setText(R.string.obfuscated_res_0x7f0f0846);
                    }
                    holder.c.setText("");
                    holder.d.setText(R.string.obfuscated_res_0x7f0f0845);
                } else {
                    int role2 = recallSysMsg.getUserFrom().getRole();
                    if (role2 == 2) {
                        holder.b.setText(R.string.obfuscated_res_0x7f0f0832);
                    } else if (role2 == 1) {
                        holder.b.setText(R.string.obfuscated_res_0x7f0f0846);
                    }
                    holder.c.setText(recallSysMsg.getUserTo().getUsername());
                    holder.d.setText(R.string.obfuscated_res_0x7f0f0844);
                }
            }
            TiebaStatic.log(new StatisticItem("c15095").param("obj_type", 3).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.f).param("room_id", this.g));
            return holder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
