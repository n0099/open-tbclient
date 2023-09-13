package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.view.CustomFitFrameCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class sx extends hx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b15 h;
    public mp6<b15> i;
    public CustomFitFrameCard j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sx(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        x(UtilHelper.getDimenPixelSize(R.dimen.tbds17));
    }

    public final boolean z(b15 b15Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, b15Var)) == null) {
            if (b15Var != null && b15Var.getThreadData() != null && b15Var.getThreadData().getTaskInfoData() != null && b15Var.getThreadData().getTaskInfoData().f() != null && b15Var.getThreadData().getTaskInfoData().j() == 4) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final void y(sx this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            mp6<b15> mp6Var = this$0.i;
            if (mp6Var != null) {
                mp6Var.a(view2, this$0.h);
            }
        }
    }

    @Override // com.baidu.tieba.vx
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        CustomFitFrameCard customFitFrameCard;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) && (customFitFrameCard = this.j) != null) {
            customFitFrameCard.b();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ux
    /* renamed from: A */
    public void onBindDataToView(b15 b15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b15Var) == null) {
            this.h = b15Var;
            if (z(b15Var)) {
                CustomFitFrameCard customFitFrameCard = this.j;
                if (customFitFrameCard != null) {
                    customFitFrameCard.setData(b15Var);
                }
                CustomFitFrameCard customFitFrameCard2 = this.j;
                if (customFitFrameCard2 != null) {
                    customFitFrameCard2.setVisibility(0);
                    return;
                }
                return;
            }
            CustomFitFrameCard customFitFrameCard3 = this.j;
            if (customFitFrameCard3 != null) {
                customFitFrameCard3.setVisibility(8);
            }
        }
    }

    @Override // com.baidu.tieba.ax
    public void o(mp6<b15> mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, mp6Var) == null) {
            this.i = mp6Var;
        }
    }

    @Override // com.baidu.tieba.ax
    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Context mContext = this.b;
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            CustomFitFrameCard customFitFrameCard = new CustomFitFrameCard(mContext, null, 2, null);
            this.j = customFitFrameCard;
            Intrinsics.checkNotNull(customFitFrameCard);
            customFitFrameCard.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.zw
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        sx.y(sx.this, view2);
                    }
                }
            });
            CustomFitFrameCard customFitFrameCard2 = this.j;
            Intrinsics.checkNotNull(customFitFrameCard2);
            return customFitFrameCard2;
        }
        return (View) invokeV.objValue;
    }
}
