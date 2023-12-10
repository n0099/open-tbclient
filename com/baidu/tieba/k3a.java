package com.baidu.tieba;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tieba.os;
import com.baidu.tieba.pb.pb.main.orignalThread.BaseOriginalThreadView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k3a extends BaseOriginalThreadView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ju k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k3a(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.orignalThread.BaseOriginalThreadView, com.baidu.tieba.e3a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            super.a();
            l().addView(k().g());
            if (this.k == null) {
                ju juVar = new ju(this.a.getPageActivity());
                this.k = juVar;
                juVar.setFrom("pb");
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X004);
            layoutParams.bottomMargin = this.a.getResources().getDimensionPixelOffset(R.dimen.tbds_30);
            l().addView(this.k.g(), layoutParams);
            l().addView(i(false));
            return l();
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pb.pb.main.orignalThread.BaseOriginalThreadView, com.baidu.tieba.e3a
    public void b(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            super.b(tbPageContext, i);
            if (this.e != i) {
                this.e = i;
                ju juVar = this.k;
                if (juVar != null) {
                    juVar.onChangeSkinType(tbPageContext, i);
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.main.orignalThread.BaseOriginalThreadView, com.baidu.tieba.e3a
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            super.c(originalThreadInfo);
            ju juVar = this.k;
            if (juVar != null) {
                juVar.onBindDataToView(f());
            }
            k().onBindDataToView(f());
        }
    }

    @Override // com.baidu.tieba.e3a
    public void d(os.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            super.d(aVar);
            ju juVar = this.k;
            if (juVar != null) {
                juVar.B(aVar);
            }
            k().A(aVar);
            m();
        }
    }

    @Override // com.baidu.tieba.e3a
    public void e(mm6 mm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mm6Var) == null) {
            super.e(mm6Var);
            ju juVar = this.k;
            if (juVar != null) {
                juVar.n(this.b);
            }
        }
    }
}
