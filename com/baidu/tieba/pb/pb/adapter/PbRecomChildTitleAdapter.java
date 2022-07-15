package com.baidu.tieba.pb.pb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.du7;
import com.repackage.gz5;
import com.repackage.qy7;
import com.repackage.ur4;
/* loaded from: classes3.dex */
public class PbRecomChildTitleAdapter extends du7<gz5, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewHolder o;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public TextView b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view2) {
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
            this.a = 3;
            d(view2);
        }

        public void c(gz5 gz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gz5Var) == null) {
                this.b.setText(gz5Var.a);
            }
        }

        public final void d(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922a1);
                this.b = textView;
                ur4.d(textView).A(R.string.F_X02);
            }
        }

        public void e() {
            int skinType;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a == (skinType = TbadkCoreApplication.getInst().getSkinType())) {
                return;
            }
            SkinManager.setBackgroundColor(b(), R.color.CAM_X0202);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            this.a = skinType;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbRecomChildTitleAdapter(qy7 qy7Var, BdUniqueId bdUniqueId) {
        super(qy7Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy7Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qy7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.du7, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        d0(i, view2, viewGroup, (gz5) obj, (ViewHolder) viewHolder);
        return view2;
    }

    public ViewHolder b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : (ViewHolder) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public ViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0699, viewGroup, false));
            this.o = viewHolder;
            return viewHolder;
        }
        return (ViewHolder) invokeL.objValue;
    }

    public View d0(int i, View view2, ViewGroup viewGroup, gz5 gz5Var, ViewHolder viewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, gz5Var, viewHolder})) == null) {
            super.S(i, view2, viewGroup, gz5Var, viewHolder);
            viewHolder.c(gz5Var);
            viewHolder.e();
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
