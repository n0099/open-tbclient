package com.baidu.tieba.pb.pb.sub.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a28;
import com.baidu.tieba.w18;
import com.baidu.tieba.ww7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SubPbReplyAdapter extends w18<a28, SubPbReplyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;

    /* loaded from: classes5.dex */
    public static class SubPbReplyViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;
        public View b;
        public int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubPbReplyViewHolder(View view2) {
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
            this.c = 3;
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090a10);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f090a11);
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c != TbadkApplication.getInst().getSkinType()) {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0105);
                    SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
                    SkinManager.setBackgroundColor(this.a, R.color.CAM_X0201);
                }
                this.c = TbadkApplication.getInst().getSkinType();
            }
        }

        public void c(boolean z) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (view2 = this.b) == null) {
                return;
            }
            view2.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbReplyAdapter(ww7 ww7Var, BdUniqueId bdUniqueId) {
        super(ww7Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ww7Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ww7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: s */
    public SubPbReplyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new SubPbReplyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0807, viewGroup, false)) : (SubPbReplyViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w18, com.baidu.tieba.qn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, a28 a28Var, SubPbReplyViewHolder subPbReplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, a28Var, subPbReplyViewHolder})) == null) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1238), String.valueOf(a28Var == null ? 0 : a28Var.a()));
            subPbReplyViewHolder.c(this.c);
            ((SubPbReplyViewHolder) this.viewholder).a.setText(format);
            ((SubPbReplyViewHolder) this.viewholder).b();
            return subPbReplyViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c = z;
        }
    }
}
