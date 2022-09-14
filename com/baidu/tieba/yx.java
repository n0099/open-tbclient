package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.InterviewLiveLayout;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class yx extends az {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public InterviewLiveLayout y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448323182, "Lcom/baidu/tieba/yx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448323182, "Lcom/baidu/tieba/yx;");
                return;
            }
        }
        B = ej.k(TbadkCoreApplication.getInst()) - ((ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + ej.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yx(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = 3;
        A();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01a0, (ViewGroup) null, true);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092568);
            this.A = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092567);
            this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090ad4);
            this.y = (InterviewLiveLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090ad0);
            ra8 q = q();
            this.j = q;
            q.getMainView().setBackgroundResource(R.color.transparent);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.y.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.az, com.baidu.tieba.gx
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gx
    public void m(v16<lq4> v16Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, v16Var) == null) {
            this.y.setSubClickListener(v16Var);
        }
    }

    @Override // com.baidu.tieba.az, com.baidu.tieba.xx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            if (this.z != i) {
                SkinManager.setBackgroundResource(this.y, R.drawable.addresslist_item_bg);
                this.y.l(this.z);
            }
            this.z = i;
        }
    }

    @Override // com.baidu.tieba.az
    public ra8 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            sa8 sa8Var = new sa8(this.b, this.i);
            sa8Var.setStageType("2003");
            return sa8Var;
        }
        return (ra8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.az, com.baidu.tieba.wx
    /* renamed from: r */
    public void a(lq4 lq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lq4Var) == null) {
            this.h = lq4Var;
            if (lq4Var == null || lq4Var.getThreadData() == null) {
                return;
            }
            ThreadData threadData = lq4Var.getThreadData();
            if (threadData.getThreadVideoInfo() != null) {
                this.y.setVisibility(8);
                this.i.setVisibility(0);
                this.A.setVisibility(8);
                super.a(lq4Var);
                return;
            }
            this.i.setVisibility(8);
            this.y.setVisibility(0);
            this.A.setVisibility(0);
            this.y.a(lq4Var);
            ThreadCardUtils.setTitle(this.g, threadData);
            ThreadCardUtils.setAbstract(this.A, this.g, threadData, B);
        }
    }
}
