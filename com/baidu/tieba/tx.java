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
public class tx extends vy {
    public static /* synthetic */ Interceptable $ic;
    public static final int B;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public InterviewLiveLayout y;
    public int z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448318377, "Lcom/baidu/tieba/tx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448318377, "Lcom/baidu/tieba/tx;");
                return;
            }
        }
        B = xi.l(TbadkCoreApplication.getInst()) - ((xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tx(Context context) {
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
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01a1, (ViewGroup) null, true);
            this.f = inflate;
            this.g = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0925aa);
            this.A = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0925a9);
            this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090af1);
            this.y = (InterviewLiveLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090aed);
            zc8 t = t();
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

    @Override // com.baidu.tieba.zw
    public void p(z36<rr4> z36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, z36Var) == null) {
            this.y.setSubClickListener(z36Var);
        }
    }

    @Override // com.baidu.tieba.vy, com.baidu.tieba.zw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vy
    public zc8 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ad8 ad8Var = new ad8(this.b, this.i);
            ad8Var.setStageType("2003");
            return ad8Var;
        }
        return (zc8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vy, com.baidu.tieba.sx
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
    @Override // com.baidu.tieba.vy, com.baidu.tieba.rx
    /* renamed from: u */
    public void a(rr4 rr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rr4Var) == null) {
            this.h = rr4Var;
            if (rr4Var != null && rr4Var.getThreadData() != null) {
                ThreadData threadData = rr4Var.getThreadData();
                if (threadData.getThreadVideoInfo() != null) {
                    this.y.setVisibility(8);
                    this.i.setVisibility(0);
                    this.A.setVisibility(8);
                    super.a(rr4Var);
                    return;
                }
                this.i.setVisibility(8);
                this.A.setVisibility(0);
                ThreadCardUtils.setTitle(this.g, threadData);
                ThreadCardUtils.setAbstract(this.A, this.g, threadData, B);
                if (threadData.getTaskInfoData() != null && threadData.getTaskInfoData().h() != 0) {
                    this.y.setVisibility(8);
                    return;
                }
                this.y.setVisibility(0);
                this.y.a(rr4Var);
            }
        }
    }
}
