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
import com.baidu.tieba.cx4;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.itemdata.ManagerTipsSysMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class ManagerTipsAdapter extends BaseSysAdapter<ManagerTipsSysMsg, Holder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean f;
    public long g;
    public long h;

    /* loaded from: classes4.dex */
    public static class Holder extends BaseViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final LinearLayout b;

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
            this.b = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0922fb);
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091546);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManagerTipsAdapter(@NonNull TbPageContext<?> tbPageContext, @NonNull BdUniqueId bdUniqueId) {
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
        this.f = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter
    @NonNull
    /* renamed from: E */
    public Holder z(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            return new Holder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0593, viewGroup, false));
        }
        return (Holder) invokeL.objValue;
    }

    public void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.g = j;
        }
    }

    public void H(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.h = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseSysAdapter
    @NonNull
    /* renamed from: F */
    public View B(int i, @NonNull ViewGroup viewGroup, @NonNull ManagerTipsSysMsg managerTipsSysMsg, @NonNull Holder holder, @NonNull List<Object> list, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), viewGroup, managerTipsSysMsg, holder, list, Integer.valueOf(i2)})) == null) {
            if (managerTipsSysMsg != null && managerTipsSysMsg.getManagerTips() != null) {
                holder.a.setText(managerTipsSysMsg.getManagerTips());
                cx4 d = cx4.d(holder.b);
                d.n(R.string.J_X04);
                d.f(R.color.CAM_X0625);
                cx4 d2 = cx4.d(holder.a);
                d2.v(R.color.CAM_X0101);
                d2.z(R.dimen.T_X09);
                if (this.f) {
                    this.f = false;
                    TiebaStatic.log(new StatisticItem("c15095").param("obj_type", 1).param("fid", this.g).param("room_id", this.h).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
            return holder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
