package com.baidu.tieba;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: HeaderViewLogic.java */
/* loaded from: classes4.dex */
public final /* synthetic */ class kt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static lt6 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return new mt6();
        }
        return (lt6) invokeV.objValue;
    }

    public static View b(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            return view2.findViewById(R.id.obfuscated_res_0x7f090b82);
        }
        return (View) invokeL.objValue;
    }

    @NonNull
    public static TextView c(@NonNull View view2, boolean z) {
        InterceptResult invokeLZ;
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, view2, z)) == null) {
            if (z) {
                textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d54);
            } else {
                textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090d55);
            }
            textView.bringToFront();
            pw4.d(textView).v(R.color.CAM_X0619);
            return textView;
        }
        return (TextView) invokeLZ.objValue;
    }

    public static void d(@NonNull View view2, @NonNull View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, view2, view3) == null) {
            pw4 d = pw4.d(view2);
            d.n(R.string.J_X11);
            d.s(R.array.Mask_X005);
        }
    }
}
