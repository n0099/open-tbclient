package com.bytedance.pangle.fragment;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.lang.reflect.InvocationTargetException;
@Keep
/* loaded from: classes7.dex */
public class ZeusDialogFragmentV4 extends DialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Application.ActivityLifecycleCallbacks callbacks;

    public ZeusDialogFragmentV4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.callbacks = new b(this);
        a.a(ZeusDialogFragmentV4.class);
    }

    @Override // androidx.fragment.app.Fragment, com.baidu.tieba.h2
    @Nullable
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return ZeusTransformUtils.wrapperContext(super.getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0]));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return super.getContext();
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                return super.getContext();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return super.getContext();
            }
        }
        return (Context) invokeV.objValue;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            super.onAttach(context);
            Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            try {
                return new Dialog(ZeusTransformUtils.wrapperContext(getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0])), getTheme());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return (Dialog) invokeL.objValue;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
            super.onDetach();
        }
    }
}
