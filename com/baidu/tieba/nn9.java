package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class nn9 extends lm9<i35, PbRecommendNovelHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public aj9 g;
    public PbRecommendNovelHolder.b h;

    /* loaded from: classes7.dex */
    public class a implements PbRecommendNovelHolder.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nn9 a;

        public a(nn9 nn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nn9Var;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbRecommendNovelHolder.b
        public void a(i35 i35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, i35Var) == null) && i35Var != null) {
                nr9.a(this.a.g, i35Var, i35Var.f0, 6);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nn9(PbFragment pbFragment, BdUniqueId bdUniqueId) {
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
                super((rr9) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
    }

    public void r(aj9 aj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aj9Var) == null) {
            this.g = aj9Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public PbRecommendNovelHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            return new PbRecommendNovelHolder(this.b.getPageContext(), LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d07c5, viewGroup, false), this.h);
        }
        return (PbRecommendNovelHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.lm9, com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        y(i, view2, viewGroup, (i35) obj, (PbRecommendNovelHolder) viewHolder);
        return view2;
    }

    public View y(int i, View view2, ViewGroup viewGroup, i35 i35Var, PbRecommendNovelHolder pbRecommendNovelHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, i35Var, pbRecommendNovelHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) i35Var, (i35) pbRecommendNovelHolder);
            if (i35Var == null) {
                return view2;
            }
            i35Var.f0 = i + 1;
            nr9.d(this.b.getUniqueId(), this.g, i35Var, i35Var.f0, 6);
            pbRecommendNovelHolder.d(i35Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
