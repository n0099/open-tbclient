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
public class zx extends bz {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public InterviewLiveLayout y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448324143, "Lcom/baidu/tieba/zx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448324143, "Lcom/baidu/tieba/zx;");
                return;
            }
        }
        B = fj.k(TbadkCoreApplication.getInst()) - ((fj.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + fj.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zx(Context context) {
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
        D();
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d019f, (ViewGroup) null, true);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092555);
            this.A = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092554);
            this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090ade);
            this.y = (InterviewLiveLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090ada);
            pb8 t = t();
            this.j = t;
            t.getMainView().setBackgroundResource(R.color.transparent);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.y.setFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.hx
    public void p(p26 p26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, p26Var) == null) {
            this.y.setSubClickListener(p26Var);
        }
    }

    @Override // com.baidu.tieba.bz, com.baidu.tieba.hx
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bz
    public pb8 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            qb8 qb8Var = new qb8(this.b, this.i);
            qb8Var.setStageType("2003");
            return qb8Var;
        }
        return (pb8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bz, com.baidu.tieba.yx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            if (this.z != i) {
                SkinManager.setBackgroundResource(this.y, R.drawable.addresslist_item_bg);
                this.y.l(this.z);
            }
            this.z = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bz, com.baidu.tieba.xx
    /* renamed from: u */
    public void a(ar4 ar4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ar4Var) == null) {
            this.h = ar4Var;
            if (ar4Var != null && ar4Var.getThreadData() != null) {
                ThreadData threadData = ar4Var.getThreadData();
                if (threadData.getThreadVideoInfo() != null) {
                    this.y.setVisibility(8);
                    this.i.setVisibility(0);
                    this.A.setVisibility(8);
                    super.a(ar4Var);
                    return;
                }
                this.i.setVisibility(8);
                this.y.setVisibility(0);
                this.A.setVisibility(0);
                this.y.a(ar4Var);
                ThreadCardUtils.setTitle(this.g, threadData);
                ThreadCardUtils.setAbstract(this.A, this.g, threadData, B);
            }
        }
    }
}
