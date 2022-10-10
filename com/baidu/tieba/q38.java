package com.baidu.tieba;

import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.switchs.HasUseGlideSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
/* loaded from: classes5.dex */
public class q38 {
    public static /* synthetic */ Interceptable $ic;
    public static SparseIntArray a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948041011, "Lcom/baidu/tieba/q38;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948041011, "Lcom/baidu/tieba/q38;");
                return;
            }
        }
        a = new SparseIntArray();
    }

    public static void a(SmallTailInfo smallTailInfo, TextView textView, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{smallTailInfo, textView, simpleDraweeView, linearLayout, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || smallTailInfo == null || textView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) simpleDraweeView.getLayoutParams();
        int b = b(R.dimen.obfuscated_res_0x7f070207);
        if (z2 && z3) {
            layoutParams.setMargins(b, 0, b, b(R.dimen.obfuscated_res_0x7f07025f));
            layoutParams2.setMargins(b, 0, 0, 0);
        } else if (z) {
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams2.setMargins(0, 0, 0, 0);
        } else if (!z2) {
            layoutParams.setMargins(b(R.dimen.obfuscated_res_0x7f070231), 0, b(R.dimen.obfuscated_res_0x7f07020f), b(R.dimen.obfuscated_res_0x7f0701b2));
            layoutParams2.setMargins(b(R.dimen.obfuscated_res_0x7f070231), 0, 0, 0);
        } else {
            layoutParams.setMargins(b, 0, b, b(R.dimen.obfuscated_res_0x7f0701b2));
            layoutParams2.setMargins(b, 0, 0, 0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) smallTailInfo.tailSpannable);
        textView.setLayoutParams(layoutParams);
        textView.setText(spannableStringBuilder);
        textView.setTextColor(smallTailInfo.showColorId);
        if (HasUseGlideSwitch.isSwitchOn()) {
            simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setUri(Uri.parse("res://drawable/" + R.drawable.obfuscated_res_0x7f080ee7)).setAutoPlayAnimations(true).build());
            simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
            simpleDraweeView.setLayoutParams(layoutParams2);
            simpleDraweeView.setPadding(0, 0, b(R.dimen.obfuscated_res_0x7f070201), 0);
        }
        textView.setVisibility(0);
        simpleDraweeView.setVisibility(0);
        linearLayout.setVisibility(0);
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            int i2 = a.get(i, -1);
            if (i2 == -1) {
                int f = ej.f(TbadkCoreApplication.getInst().getContext(), i);
                a.put(i, f);
                return f;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public static void c(SmallTailInfo smallTailInfo, TextView textView, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout, boolean z, boolean z2, boolean z3) {
        SpannableString spannableString;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{smallTailInfo, textView, simpleDraweeView, linearLayout, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) || smallTailInfo == null || (spannableString = smallTailInfo.tailSpannable) == null || spannableString.length() == 0 || textView == null) {
            return;
        }
        smallTailInfo.updateShowInfo();
        a(smallTailInfo, textView, simpleDraweeView, linearLayout, z, z2, z3);
    }
}
