package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vi9 extends wh9<ti9, PbPageNewsInfoHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ze9 g;
    public PbPageNewsInfoHolder.b h;

    /* loaded from: classes8.dex */
    public class a implements PbPageNewsInfoHolder.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vi9 a;

        public a(vi9 vi9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vi9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vi9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.b
        public void a(ti9 ti9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, ti9Var) == null) && ti9Var != null) {
                xm9.a(this.a.g, ti9Var, ti9Var.e0, 5);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vi9(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bn9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
    }

    public void r(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ze9Var) == null) {
            this.g = ze9Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public PbPageNewsInfoHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            return new PbPageNewsInfoHolder(this.b.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07a0, viewGroup, false), this.h);
        }
        return (PbPageNewsInfoHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.wh9, com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        y(i, view2, viewGroup, (ti9) obj, (PbPageNewsInfoHolder) viewHolder);
        return view2;
    }

    public View y(int i, View view2, ViewGroup viewGroup, ti9 ti9Var, PbPageNewsInfoHolder pbPageNewsInfoHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ti9Var, pbPageNewsInfoHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) ti9Var, (ti9) pbPageNewsInfoHolder);
            if (ti9Var == null) {
                return view2;
            }
            ti9Var.e0 = i + 1;
            xm9.d(this.b.getUniqueId(), this.g, ti9Var, ti9Var.e0, 5);
            pbPageNewsInfoHolder.h(ti9Var);
            pbPageNewsInfoHolder.i(TbadkCoreApplication.getInst().getSkinType());
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
