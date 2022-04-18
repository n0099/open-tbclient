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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ly7;
import com.repackage.ot7;
import com.repackage.py7;
/* loaded from: classes3.dex */
public class SubPbReplyAdapter extends ly7<py7, SubPbReplyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean k;

    /* loaded from: classes3.dex */
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
            this.a = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0909e9);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0909ea);
        }

        public void d() {
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

        public void e(boolean z) {
            View view2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (view2 = this.b) == null) {
                return;
            }
            view2.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubPbReplyAdapter(ot7 ot7Var, BdUniqueId bdUniqueId) {
        super(ot7Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ot7Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ot7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: Z */
    public SubPbReplyViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new SubPbReplyViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07ae, viewGroup, false)) : (SubPbReplyViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ly7, com.repackage.ho
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, py7 py7Var, SubPbReplyViewHolder subPbReplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, py7Var, subPbReplyViewHolder})) == null) {
            String format = String.format(TbadkApplication.getInst().getString(R.string.obfuscated_res_0x7f0f11f3), String.valueOf(py7Var == null ? 0 : py7Var.a()));
            subPbReplyViewHolder.e(this.k);
            ((SubPbReplyViewHolder) this.g).a.setText(format);
            ((SubPbReplyViewHolder) this.g).d();
            return subPbReplyViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.k = z;
        }
    }
}
