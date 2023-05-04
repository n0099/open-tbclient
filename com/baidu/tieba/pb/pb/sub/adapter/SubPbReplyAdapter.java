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
import com.baidu.tieba.fx8;
import com.baidu.tieba.i29;
import com.baidu.tieba.m29;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SubPbReplyAdapter extends i29<m29, SubPbReplyViewHolder> {
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b13);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f090b14);
        }

        public void c(boolean z) {
            View view2;
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (view2 = this.b) != null) {
                if (z) {
                    i = 0;
                } else {
                    i = 8;
                }
                view2.setVisibility(i);
            }
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbReplyAdapter(fx8 fx8Var, BdUniqueId bdUniqueId) {
        super(fx8Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fx8Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((fx8) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: s */
    public SubPbReplyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new SubPbReplyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d087e, viewGroup, false));
        }
        return (SubPbReplyViewHolder) invokeL.objValue;
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i29, com.baidu.tieba.vm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, m29 m29Var, SubPbReplyViewHolder subPbReplyViewHolder) {
        InterceptResult invokeCommon;
        int a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, m29Var, subPbReplyViewHolder})) == null) {
            if (m29Var == null) {
                a = 0;
            } else {
                a = m29Var.a();
            }
            String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f131c), String.valueOf(a));
            subPbReplyViewHolder.c(this.c);
            ((SubPbReplyViewHolder) this.viewholder).a.setText(format);
            ((SubPbReplyViewHolder) this.viewholder).b();
            return subPbReplyViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
