package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xb9 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                a = SharedPrefHelper.getInstance().getString("nick_name_activity_link", "");
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static SpannableStringBuilder b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) str);
            int length = spannableStringBuilder.length();
            Drawable drawable = context.getResources().getDrawable(R.drawable.icon_nichenghuodong);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableStringBuilder.append((CharSequence) "tag");
            spannableStringBuilder.setSpan(new p95(drawable), length, spannableStringBuilder.length(), 33);
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }
}
