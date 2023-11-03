package com.baidu.tieba.im.under.common.uiliststyle.group.adapter;

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
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.base.core.uilist.BaseSysAdapter;
import com.baidu.tieba.im.base.core.uilist.BaseViewHolder;
import com.baidu.tieba.im.lib.socket.msg.TbNoticeModifySysMsg;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.NoticeModifySysItem;
import com.baidu.tieba.uv8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class NoticeModifyAdapter extends BaseSysAdapter<NoticeModifySysItem, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long l;
    public long m;

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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a24);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09108d);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091092);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f11);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a27);
            this.f = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a26);
        }

        @Override // com.baidu.tieba.im.base.core.uilist.BaseViewHolder
        public void a(View.OnClickListener onClickListener) {
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
    @Override // com.baidu.tieba.im.base.core.uilist.BaseSysAdapter
    @NonNull
    /* renamed from: R */
    public Holder M(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0203, viewGroup, false));
        }
        return (Holder) invokeL.objValue;
    }

    public void T(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.l = j;
        }
    }

    public void U(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.m = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.base.core.uilist.BaseSysAdapter
    /* renamed from: S */
    public void O(int i, @NonNull ViewGroup viewGroup, @NonNull NoticeModifySysItem noticeModifySysItem, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), viewGroup, noticeModifySysItem, holder, list, Integer.valueOf(i2)}) == null) {
            EMManager.from(holder.a).setCorner(R.string.J_X04).setBackGroundColor(R.color.CAM_X0625);
            EMManager.from(holder.b).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            EMManager.from(holder.c).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            EMManager.from(holder.d).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            EMManager.from(holder.e).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0304).setTextStyle(R.string.F_X01);
            TbNoticeModifySysMsg tbMsg = noticeModifySysItem.getTbMsg();
            if (tbMsg != null && tbMsg.getUserFrom() != null) {
                holder.c.setText(tbMsg.getUserFrom().getUsername());
                int role = tbMsg.getUserFrom().getRole();
                if (role == 1) {
                    holder.b.setText(R.string.obfuscated_res_0x7f0f0978);
                } else if (role == 2 || role == 3) {
                    holder.b.setText(R.string.obfuscated_res_0x7f0f097b);
                }
                holder.d.setText(R.string.obfuscated_res_0x7f0f0970);
                holder.e.setText(R.string.obfuscated_res_0x7f0f1846);
                uv8.d("c15095", 2, this.l, this.m, TbadkCoreApplication.getCurrentAccount());
            }
        }
    }
}
