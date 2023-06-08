package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.adapter;

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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.NoticeModifySysMsg;
import com.baidu.tieba.nh8;
import com.baidu.tieba.o75;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class NoticeModifyAdapter extends BaseSysAdapter<NoticeModifySysMsg, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long k;
    public long l;

    /* loaded from: classes6.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinearLayout a;
        public final TextView b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final LinearLayout f;

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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09190f);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091005);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09100a);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e96);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091912);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091911);
        }

        @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseViewHolder
        public void a(@Nullable View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
                super.a(onClickListener);
                this.f.setOnClickListener(onClickListener);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoticeModifyAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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
    /* renamed from: P */
    public Holder J(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01f5, viewGroup, false));
        }
        return (Holder) invokeL.objValue;
    }

    public void R(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.k = j;
        }
    }

    public void S(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.l = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter
    @NonNull
    /* renamed from: Q */
    public View M(int i, @NonNull ViewGroup viewGroup, @NonNull NoticeModifySysMsg noticeModifySysMsg, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), viewGroup, noticeModifySysMsg, holder, list, Integer.valueOf(i2)})) == null) {
            o75 d = o75.d(holder.a);
            d.o(R.string.J_X04);
            d.f(R.color.CAM_X0625);
            o75 d2 = o75.d(holder.b);
            d2.w(R.color.CAM_X0101);
            d2.B(R.dimen.T_X09);
            d2.C(R.string.F_X01);
            o75 d3 = o75.d(holder.c);
            d3.w(R.color.CAM_X0101);
            d3.B(R.dimen.T_X09);
            d3.C(R.string.F_X01);
            o75 d4 = o75.d(holder.d);
            d4.w(R.color.CAM_X0101);
            d4.B(R.dimen.T_X09);
            d4.C(R.string.F_X01);
            o75 d5 = o75.d(holder.e);
            d5.B(R.dimen.T_X09);
            d5.w(R.color.CAM_X0304);
            d5.C(R.string.F_X01);
            if (noticeModifySysMsg != null && noticeModifySysMsg.getUserFrom() != null) {
                holder.c.setText(noticeModifySysMsg.getUserFrom().getUsername());
                int role = noticeModifySysMsg.getUserFrom().getRole();
                if (role == 1) {
                    holder.b.setText(R.string.obfuscated_res_0x7f0f093f);
                } else if (role == 2 || role == 3) {
                    holder.b.setText(R.string.obfuscated_res_0x7f0f0941);
                }
                holder.d.setText(R.string.obfuscated_res_0x7f0f0937);
                holder.e.setText(R.string.obfuscated_res_0x7f0f17e4);
                nh8.b("c15095", 2, this.k, this.l, TbadkCoreApplication.getCurrentAccount());
            }
            return holder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
