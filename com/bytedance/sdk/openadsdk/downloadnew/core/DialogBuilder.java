package com.bytedance.sdk.openadsdk.downloadnew.core;

import android.graphics.drawable.Drawable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class DialogBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IDialogStatusChangedListener dialogStatusChangedListener;
    public Drawable icon;
    public String message;
    public String negativeBtnText;
    public String positiveBtnText;
    public String title;

    public DialogBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static DialogBuilder builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new DialogBuilder() : (DialogBuilder) invokeV.objValue;
    }

    public DialogBuilder setDialogStatusChangedListener(IDialogStatusChangedListener iDialogStatusChangedListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iDialogStatusChangedListener)) == null) {
            this.dialogStatusChangedListener = iDialogStatusChangedListener;
            return this;
        }
        return (DialogBuilder) invokeL.objValue;
    }

    public DialogBuilder setIcon(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable)) == null) {
            this.icon = drawable;
            return this;
        }
        return (DialogBuilder) invokeL.objValue;
    }

    public DialogBuilder setMessage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.message = str;
            return this;
        }
        return (DialogBuilder) invokeL.objValue;
    }

    public DialogBuilder setNegativeBtnText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.negativeBtnText = str;
            return this;
        }
        return (DialogBuilder) invokeL.objValue;
    }

    public DialogBuilder setPositiveBtnText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            this.positiveBtnText = str;
            return this;
        }
        return (DialogBuilder) invokeL.objValue;
    }

    public DialogBuilder setTitle(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.title = str;
            return this;
        }
        return (DialogBuilder) invokeL.objValue;
    }
}
