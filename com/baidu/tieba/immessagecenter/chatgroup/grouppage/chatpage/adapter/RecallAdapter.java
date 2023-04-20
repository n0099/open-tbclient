package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

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
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.RecallSysMsg;
import com.baidu.tieba.r25;
import com.baidu.tieba.s78;
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
    public long h;
    public long i;

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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091cfe);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090faf);
            this.c = (TextView) view2.findViewById(R.id.user_name);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0926ac);
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
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter
    @NonNull
    /* renamed from: J */
    public Holder E(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01e6, viewGroup, false));
        }
        return (Holder) invokeL.objValue;
    }

    public void M(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.h = j;
        }
    }

    public void N(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.i = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter
    @NonNull
    /* renamed from: K */
    public View G(int i, @NonNull ViewGroup viewGroup, @NonNull RecallSysMsg recallSysMsg, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), viewGroup, recallSysMsg, holder, list, Integer.valueOf(i2)})) == null) {
            r25 d = r25.d(holder.a);
            d.o(R.string.J_X04);
            d.f(R.color.CAM_X0625);
            r25 d2 = r25.d(holder.b);
            d2.w(R.color.CAM_X0101);
            d2.B(R.dimen.T_X09);
            d2.C(R.string.F_X01);
            r25 d3 = r25.d(holder.c);
            d3.w(R.color.CAM_X0101);
            d3.B(R.dimen.T_X09);
            d3.C(R.string.F_X01);
            r25 d4 = r25.d(holder.d);
            d4.w(R.color.CAM_X0101);
            d4.B(R.dimen.T_X09);
            d4.C(R.string.F_X01);
            if (recallSysMsg != null && recallSysMsg.getUserTo() != null && recallSysMsg.getUserFrom() != null) {
                int msgType = recallSysMsg.getMsgType();
                if (msgType == 7002) {
                    if (String.valueOf(recallSysMsg.getUserTo().getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                        int role = recallSysMsg.getUserFrom().getRole();
                        if (role != 2 && role != 3) {
                            if (role == 1) {
                                holder.b.setText(R.string.obfuscated_res_0x7f0f088a);
                            }
                        } else {
                            holder.b.setText(R.string.obfuscated_res_0x7f0f086b);
                        }
                        holder.c.setText("");
                        holder.d.setText(R.string.obfuscated_res_0x7f0f0887);
                    } else {
                        int role2 = recallSysMsg.getUserFrom().getRole();
                        if (role2 != 2 && role2 != 3) {
                            if (role2 == 1) {
                                holder.b.setText(R.string.obfuscated_res_0x7f0f088a);
                            }
                        } else {
                            holder.b.setText(R.string.obfuscated_res_0x7f0f086b);
                        }
                        holder.c.setText(recallSysMsg.getUserTo().getUsername());
                        holder.d.setText(R.string.obfuscated_res_0x7f0f0886);
                    }
                } else if (msgType == 7015) {
                    holder.b.setText("");
                    holder.c.setText(recallSysMsg.getUserTo().getUsername());
                    holder.d.setText(R.string.obfuscated_res_0x7f0f088e);
                }
            }
            s78.a("c15095", 3, this.h, this.i, TbadkCoreApplication.getCurrentAccount());
            return holder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
