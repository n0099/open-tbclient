package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ri1 {
    public static /* synthetic */ Interceptable $ic;
    public static Toast a;
    public transient /* synthetic */ FieldHolder $fh;

    public static View a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04e2, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091b34)).setText(str);
            return inflate;
        }
        return (View) invokeLL.objValue;
    }

    public static void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65541, null, context, str) != null) || context == null) {
            return;
        }
        Toast toast = a;
        if (toast != null) {
            toast.cancel();
        }
        b(context);
        a.setView(a(context, str));
        a.show();
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            Toast toast = new Toast(context.getApplicationContext());
            a = toast;
            toast.setGravity(17, 0, 0);
            a.setDuration(0);
        }
    }

    public static View c(Context context, int i, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i), str, Boolean.valueOf(z)})) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04e1, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091b33);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091b34);
            if (-1 == i) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(i);
                if (z) {
                    imageView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.obfuscated_res_0x7f010098));
                }
            }
            textView.setText(str);
            return inflate;
        }
        return (View) invokeCommon.objValue;
    }

    public static void d(Context context, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65539, null, context, i, str) != null) || context == null) {
            return;
        }
        Toast toast = a;
        if (toast != null) {
            toast.cancel();
        }
        b(context);
        a.setView(c(context, i, str, false));
        a.show();
    }

    public static void e(Context context, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i, str) != null) || context == null) {
            return;
        }
        Toast toast = a;
        if (toast != null) {
            toast.cancel();
        }
        b(context);
        a.setView(c(context, i, str, true));
        a.show();
    }
}
