package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NavigationBarCoverTip extends BaseCoverTip {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavigationBarCoverTip(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavigationBarCoverTip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationBarCoverTip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        c();
    }

    @Override // com.baidu.tieba.view.BaseCoverTip
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                setPadding(0, UtilHelper.getStatusBarHeight(), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
            } else {
                setPadding(0, 0, 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
            }
            super.c();
        }
    }

    @Override // com.baidu.tieba.view.BaseCoverTip
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.g();
            Activity activity = this.g;
            if (activity != null) {
                UtilHelper.changeStatusBarIconAndTextColor(false, activity);
                this.g = null;
            }
        }
    }

    @Override // com.baidu.tieba.view.BaseCoverTip
    public Animation getInAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return AnimationUtils.loadAnimation(getContext(), R.anim.in_from_top);
        }
        return (Animation) invokeV.objValue;
    }

    @Override // com.baidu.tieba.view.BaseCoverTip
    public Animation getOutAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f010103);
        }
        return (Animation) invokeV.objValue;
    }

    public void i(Activity activity, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, activity, i) == null) {
            k(activity, null, i);
        }
    }

    public void j(Activity activity, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, activity, view2) == null) {
            k(activity, view2, 5000);
        }
    }

    public void k(Activity activity, View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, activity, view2, i) == null) {
            this.g = activity;
            if (activity != null) {
                UtilHelper.changeStatusBarIconAndTextColor(true, activity);
            }
            super.h(view2, i);
        }
    }
}
